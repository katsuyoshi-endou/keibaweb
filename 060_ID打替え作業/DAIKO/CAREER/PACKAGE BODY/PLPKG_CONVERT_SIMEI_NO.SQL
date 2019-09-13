CREATE OR REPLACE PACKAGE BODY PLPKG_CONVERT_SIMEI_NO AS

FUNCTION MAIN RETURN NUMBER
AS
    vRETURN             NUMBER;

BEGIN
    vRETURN := 0;

    -- 実行前チェック処理
    vRETURN := CHECK_PROCESS_MAIN_PROC_EXECUTE();
    IF vRETURN <> 0 THEN
        RETURN vRETURN;
    END IF;

    -- 「氏名No」項目および関連項目の更新処理
    vRETURN := UPDATE_SIMEINO_COLUMNS();
    IF vRETURN <> 0 THEN
        ROLLBACK;
        
        RETURN vRETURN;
    END IF;

    COMMIT;

    RETURN 0;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(sqlerrm);

        ROLLBACK;

        RETURN 1;

END MAIN;

-- 打ち替えメイン処理の実行前のチェック
FUNCTION CHECK_PROCESS_MAIN_PROC_EXECUTE RETURN NUMBER
AS
    vREC_CNT1           PLS_INTEGER;
    vREC_CNT2           PLS_INTEGER;

BEGIN
    --打替え用のワークテーブルの両方、もしくは一方にレコードがなければ何もしない
    SELECT COUNT(*) INTO vREC_CNT1 FROM CONV_PERSONAL_TBL;

    IF vREC_CNT1 = 0 THEN
        DBMS_OUTPUT.PUT_LINE('変換処理用のワークテーブル（CONV_PERSONAL_TBL）にレコードが存在しません。処理を終了します。');
        RETURN 1;
    END IF;

    SELECT COUNT(*) INTO vREC_CNT2 FROM CONV_TARGET_COLUMN_TBL;

    IF vREC_CNT2 = 0 THEN
        DBMS_OUTPUT.PUT_LINE('変換処理用のワークテーブル（CONV_TARGET_COLUMN_TBL）にレコードが存在しません。処理を終了します。');
        RETURN 2;
    END IF;

    RETURN 0;

EXCEPTION
    WHEN OTHERS THEN
        RAISE;

END CHECK_PROCESS_MAIN_PROC_EXECUTE;

-- 「氏名No」項目の更新処理
FUNCTION UPDATE_SIMEINO_COLUMNS RETURN NUMBER
AS
    vSQL        VARCHAR2(1000);
    vCNT        PLS_INTEGER;

    -- 打替え対象社員情報テーブル用のカーソル定義
    CURSOR curCONV_PERSONAL
    IS
        SELECT
            OLD_SIMEI_NO,
            NEW_SIMEI_NO
        FROM CONV_PERSONAL_TBL;

    -- 打替え先カラム情報テーブル用のカーソル定義
    CURSOR curCONV_COLUMNS
    IS
        SELECT
            TABLE_NAME,
            COLUMN_NAME
        FROM CONV_TARGET_COLUMN_TBL
        WHERE CONV_FLG = '1'
        ORDER BY TABLE_NAME, COLUMN_NAME;

BEGIN
    vCNT := 0;

    FOR recPERSONAL_INFO IN curCONV_PERSONAL LOOP
        FOR recCONV_COLUMN IN curCONV_COLUMNS LOOP
            vSQL := 'UPDATE ' || recCONV_COLUMN.TABLE_NAME || ' SET ' || recCONV_COLUMN.COLUMN_NAME || ' = :NEW_ID WHERE ' || recCONV_COLUMN.COLUMN_NAME || ' = ' || recPERSONAL_INFO.OLD_SIMEI_NO;

--            IF vCNT = 0 THEN
--                DBMS_OUTPUT.PUT_LINE(vSQL || ', NEW_ID >> ' || recPERSONAL_INFO.NEW_SIMEI_NO);
--            END IF;

            IF ( recCONV_COLUMN.TABLE_NAME = 'PERSONAL_PROFILE_IMPORT' AND recCONV_COLUMN.COLUMN_NAME = 'SIMEI_NO_FLG' ) OR ( recCONV_COLUMN.TABLE_NAME = 'T01_PERSONAL_TBL' AND recCONV_COLUMN.COLUMN_NAME = 'SIMEI_NO_FLG' ) THEN
                -- 上記のテーブル・カラムについてのみ形式が、'3' + 氏名Noとなる
                EXECUTE IMMEDIATE vSQL USING '3' || recPERSONAL_INFO.NEW_SIMEI_NO;
            ELSE
                EXECUTE IMMEDIATE vSQL USING recPERSONAL_INFO.NEW_SIMEI_NO;
            END IF;
        END LOOP;

        vCNT := vCNT + 1;
    END LOOP;

    RETURN 0;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(sqlerrm);
    
        IF curCONV_PERSONAL%ISOPEN THEN
            CLOSE curCONV_PERSONAL;
        END IF;

        IF curCONV_COLUMNS%ISOPEN THEN
            CLOSE curCONV_COLUMNS;
        END IF;

        RAISE;

END UPDATE_SIMEINO_COLUMNS;

END PLPKG_CONVERT_SIMEI_NO;
/
