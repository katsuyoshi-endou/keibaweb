CREATE OR REPLACE PACKAGE PLPKG_CREATE_CONV_WORK
AS 

-- パッケージ名
cvFunctionName              CONSTANT VARCHAR2(40) := 'PLPKG_CONVERT_SIMEI_NO';

---------------------------------------------------------------------
-- 機能   ：社員番号切替用のワークテーブル関連を作成するメイン処理
-- 戻り値 ：終了コード
---------------------------------------------------------------------
FUNCTION MAIN RETURN NUMBER;

-- 打替え対象社員情報（CONV_PERSONAL_TBL）のレコード作成処理
FUNCTION CREATE_CONV_PERSONAL_TBL RETURN NUMBER;

END PLPKG_CREATE_CONV_WORK;
/
