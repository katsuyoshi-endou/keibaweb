@ECHO OFF
REM ****************************************************************
REM  �T�v	�F �l�ވ琬�v��Excel�A�b�v���[�h�t�@�C���捞�݂��N������
REM ****************************************************************

title �l�ވ琬�v��Excel�A�b�v���[�h�t�@�C���捞�݃o�b�`

Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%

REM �ϐ��Z�b�g
Set dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
Set tm=%time: =0%
Set ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%

REM log�t�H���_�̑��݃`�F�b�N
if not exist %BATCH_HOME%\log (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

REM �l�ވ琬�v��Excel�A�b�v���[�h�t�@�C���捞��
CD /D %BATCH_HOME%

START %BATCH_HOME%\jinik_excel_upload_start.bat

rem jinik_excel_upload_start.bat��jinik_upload_stop.ri���폜����鏈�������s�����܂ŃX���[�v
ping 127.0.0.1 -n 10 > nul

IF EXIST %BATCH_HOME%\jinik_upload_stop.ri (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)
EXIT /B %ERRORLEVEL%
