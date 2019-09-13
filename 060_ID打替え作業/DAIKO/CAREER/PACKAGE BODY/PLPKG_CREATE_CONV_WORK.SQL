CREATE OR REPLACE PACKAGE BODY PLPKG_CREATE_CONV_WORK AS

FUNCTION MAIN RETURN NUMBER
AS
    vRETURN         PLS_INTEGER;
BEGIN
    vRETURN := 0;

    vRETURN := CREATE_CONV_PERSONAL_TBL();
    IF vRETURN <> 0 THEN
        ROLLBACK;
        
        RETURN vRETURN;
    END IF;

    COMMIT;

    RETURN 0;

EXCEPTION
    WHEN OTHERS THEN
        RAISE;

END MAIN;

-- 打替え対象社員情報（CONV_PERSONAL_TBL）のレコード作成処理
FUNCTION CREATE_CONV_PERSONAL_TBL RETURN NUMBER
AS
    vREC_CNT            PLS_INTEGER;

    -- CONV_PERSONAL_TBL用カーソル定義
    CURSOR curPERSONAL_INFO
    IS
        SELECT TRIM(SIMEI_NO) AS SIMEI_NO FROM T01_PERSONAL_TBL;

    -- CONV_RULE_TBL用カーソル定義
    CURSOR curCONV_RULE
    IS
        SELECT
            OLD_SIMEI_NO,
            NEW_SIMEI_NO
        FROM CONV_RULE_TBL;

BEGIN
    -- 打ち替え対象社員情報テーブルのレコードクリア
    DELETE FROM CONV_PERSONAL_TBL;

    -- T01_PERSONAL_TBLにいる社員をすべて打替え対象社員情報テーブル（CONV_PERSONAL_TBL）へコピー
    -- このとき「新氏名No」は、一律'0900' + （旧）氏名Noで格納する
    FOR recPERSONAL IN curPERSONAL_INFO LOOP
        IF LENGTH(recPERSONAL.SIMEI_NO) <= 6 THEN
            INSERT INTO CONV_PERSONAL_TBL( OLD_SIMEI_NO, NEW_SIMEI_NO ) VALUES( recPERSONAL.SIMEI_NO, '0900' || recPERSONAL.SIMEI_NO );
        ELSE
            -- '0900'を付加すると桁あふれを起こす場合は、ログを出力して次へ
            DBMS_OUTPUT.PUT_LINE('新しい社員番号が、格納できるサイズ（半角10桁）を超えています。 >> ' || recPERSONAL.SIMEI_NO);
        END IF;
    END LOOP;

    -- 打替えルールに載っている人はここで「新氏名No」を正しいIDで上書き
    FOR recCONV_RULE IN curCONV_RULE LOOP
        UPDATE CONV_PERSONAL_TBL SET NEW_SIMEI_NO = recCONV_RULE.NEW_SIMEI_NO WHERE OLD_SIMEI_NO = recCONV_RULE.OLD_SIMEI_NO;

        vREC_CNT := SQL%ROWCOUNT;
        IF vREC_CNT = 0 THEN
            -- 更新件数が、0件のときは打替えルールに載っているが対象がいないというログを出力
            DBMS_OUTPUT.PUT_LINE('社員情報が見つかりませんでした。　現：' || recCONV_RULE.OLD_SIMEI_NO || ', 新：' || recCONV_RULE.NEW_SIMEI_NO);
        END IF;
    END LOOP;

    -- 除外者テーブルに載っている人を削除
    DELETE FROM CONV_PERSONAL_TBL WHERE TRIM(OLD_SIMEI_NO) IN (
        SELECT TRIM(SIMEI_NO) FROM CONV_EXCLUSION_LIST_TBL
    );

    RETURN 0;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT(sqlerrm);
    
        IF curPERSONAL_INFO%ISOPEN THEN
            CLOSE curPERSONAL_INFO;
        END IF;

        IF curCONV_RULE%ISOPEN THEN
            CLOSE curCONV_RULE;
        END IF;

        RAISE;

END CREATE_CONV_PERSONAL_TBL;

END PLPKG_CREATE_CONV_WORK;
/
