echo off

cd /d %~dp0

REM ***** 環境設定 START *****
SET EXE_PATH= %CD%\\scripts\\

SET SID=CAREER
REM SET SID=127.0.0.1:1522/CAREER

SET SYSTEM_USER=SYSTEM
SET SYSTEM_USER_PW=SYSTEM

SET IMP_USER=CAREER
SET IMP_USER_PW=CAREER
SET IMP_TGT_SCHEMA=CAREER

REM インポート処理終了時、IMP_FULL_DATABASEロールを削除（YES:する、NO:しない）
SET REVOKE_IMP_ROLE=YES

SET dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
SET tm=%time: =0%
SET ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%
SET LOG_FILE=import_%dt%_%ts%.log
REM ***** 環境設定 END *****

SET /P EXP_FILE="インポートするファイルを指定："

sqlplus %SYSTEM_USER%/%SYSTEM_USER_PW%@%SID% @%EXE_PATH%AA_ControlExpImpRole.sql %IMP_USER% IMP GRANT

IMPDP %IMP_USER%/%IMP_USER_PW%@%SID% DIRECTORY=LY_DMP_DIR DUMPFILE=%EXP_FILE% LOGFILE=%LOG_FILE% SCHEMAS=%IMP_TGT_SCHEMA% TABLE_EXISTS_ACTION=REPLACE

IF {%REVOKE_IMP_ROLE%} == {YES} (
  sqlplus %SYSTEM_USER%/%SYSTEM_USER_PW%@%SID% @%EXE_PATH%AA_ControlExpImpRole.sql %IMP_USER% IMP REVOKE
)

pause
