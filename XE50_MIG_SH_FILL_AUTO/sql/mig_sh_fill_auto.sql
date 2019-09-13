set serveroutput ON
set linesize 4000
set feedback off
set heading off
set pagesize 0
set verify off

var exitCode  NUMBER;

DECLARE

	nResult PLS_INTEGER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSDATE, 'YYYY/MM/DD_HH24:MI:SS') || '],処理開始しました。');
	:exitCode := BATCH_MIG_SH_FILL_AUTO.MAIN('BATCH');
	IF :exitCode = '1' THEN
		DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSDATE, 'YYYY/MM/DD_HH24:MI:SS') || '],警告終了しました。');
	ELSIF :exitCode = '8' THEN
		DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSDATE, 'YYYY/MM/DD_HH24:MI:SS') || '],異常終了しました。');
	ELSE
		DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSDATE, 'YYYY/MM/DD_HH24:MI:SS') || '],正常終了しました。');
	END IF;
END;
/
EXIT :exitCode
