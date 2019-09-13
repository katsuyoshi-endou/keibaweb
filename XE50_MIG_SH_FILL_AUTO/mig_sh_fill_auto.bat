@ECHO OFF

rem ======================================================================
rem  �I�[�g�t�B���������o�b�`
rem ======================================================================
title �I�[�g�t�B���������o�b�`

rem ---------------------
rem �o�b�`�ݒ�
rem ---------------------
Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%
Set dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
Set tm=%time: =0%
Set ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%
Set BATCH_NAME=mig_sh_fill_auto

rem �yDB�ڑ����z�p�X�ݒ�
Set DB_SET_PATH=C:\Lysithea\Career\Batch\BatchSetting\setEnv.bat

rem DB�ڑ����̑��݃`�F�b�N
if not exist %DB_SET_PATH% (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

call %DB_SET_PATH%
if %ERRORLEVEL% == 8 (
EXIT /B %ERRORLEVEL%
)

rem log�t�H���_�̑��݃`�F�b�N
if not exist %BATCH_HOME%\log (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

rem ---------------------
rem �{����
rem ---------------------
SQLPLUS -s %USERNAME%/%PASSWORD%@%CONNECT% @%BATCH_HOME%sql\%BATCH_NAME%.sql >> %BATCH_HOME%log\%BATCH_NAME%_%dt%_%ts%.log
EXIT /B %ERRORLEVEL%


