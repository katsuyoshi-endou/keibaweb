echo off

cd /d %~dp0

REM ***** 環境設定 START *****
SET EXE_PATH= %CD%\\scripts\\

REM 接続情報
SET SYSTEM_USER=SYSTEM
SET SYSTEM_USER_PW=SYSTEM
SET SID=CAREER
REM SET SID=127.0.0.1:1522/CAREER

sqlplus %SYSTEM_USER%/%SYSTEM_USER_PW%@%SID% @%EXE_PATH%03_CreateUser_CAREER.sql

pause
