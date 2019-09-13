echo off

cd /d %~dp0

REM ***** 環境設定 START *****
SET EXE_PATH= %CD%\\scripts\\

REM 接続情報
SET CAREER_USER=CAREER
SET CAREER_USER_PW=CAREER
SET SID=CAREER
REM SET SID=127.0.0.1:1522/CAREER

SET /P JOB_SID="JOBデータベースの接続文字列を指定："

sqlplus %CAREER_USER%/%CAREER_USER_PW%@%SID% @%EXE_PATH%04_CreateDBLink_CAREER-JOB.sql %JOB_SID%

pause
