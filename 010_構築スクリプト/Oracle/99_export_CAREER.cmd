echo off

cd /d %~dp0

REM ***** ���ݒ� START *****
SET EXE_PATH= %CD%\\scripts\\

REM �G�N�X�|�[�g���������{����f�[�^�x�[�X�ւ̐ڑ�������܂���IP&PORT
SET SID=CAREER
REM SET SID=127.0.0.1:1522/CAREER

REM �����t�^���s����SYSTEM���[�U/�p�X���[�h
SET SYSTEM_USER=SYSTEM
SET SYSTEM_USER_PW=SYSTEM

REM �G�N�X�|�[�g���s���[�U/�p�X���[�h
SET EXP_USER=CAREER
SET EXP_USER_PW=CAREER

REM �G�N�X�|�[�g�Ώۂ̃X�L�[�}
SET EXP_TGT_SCHEMA=CAREER

REM �G�N�X�|�[�g�����I�����AEXP_FULL_DATABASE���[�����폜�iYES:����ANO:���Ȃ��j
SET REVOKE_EXP_ROLE=YES
REM ***** ���ݒ� END *****

SET dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
SET tm=%time: =0%
SET ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%

SET DUMP_FILE=CAREER_%dt%_%ts%.dmp
SET LOG_FILE=export_%dt%_%ts%.log

sqlplus %SYSTEM_USER%/%SYSTEM_USER_PW%@%SID% @%EXE_PATH%AA_ControlExpImpRole.sql %EXP_USER% EXP GRANT

EXPDP %EXP_USER%/%EXP_USER_PW%@%SID% DIRECTORY=LY_DMP_DIR DUMPFILE=%DUMP_FILE% LOGFILE=%LOG_FILE% CONTENT=ALL SCHEMAS=%EXP_TGT_SCHEMA%

IF {%REVOKE_EXP_ROLE%} == {YES} (
  sqlplus %SYSTEM_USER%/%SYSTEM_USER_PW%@%SID% @%EXE_PATH%AA_ControlExpImpRole.sql %EXP_USER% EXP REVOKE
)

pause
