echo off

cd /d %~dp0

REM ***** ���ݒ� START *****
SET EXE_PATH= %CD%\\scripts\\

REM �ڑ����
SET CAREER_USER=CAREER
SET CAREER_USER_PW=CAREER
SET SID=CAREER
REM SET SID=127.0.0.1:1522/CAREER

SET /P JOB_SID="JOB�f�[�^�x�[�X�̐ڑ���������w��F"

sqlplus %CAREER_USER%/%CAREER_USER_PW%@%SID% @%EXE_PATH%04_CreateDBLink_CAREER-JOB.sql %JOB_SID%

pause
