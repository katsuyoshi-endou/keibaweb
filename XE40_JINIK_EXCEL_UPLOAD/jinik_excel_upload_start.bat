@ECHO OFF
REM *************************************************************
REM  �T�v	�F �l�ވ琬�v��Excel�A�b�v���[�h�t�@�C���捞�݋N���o�b�`
REM *************************************************************

title �l�ވ琬�v��Excel�A�b�v���[�h�捞�݃o�b�`

Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%

SET JINIK_EXCEL_UPLOAD_JAR=%BATCH_HOME%\jar\JinikExcelUpload.jar

REM �y�蓮�ݒ藓�zJava���s�p�X���`���Ă��������iJava 8�j
REM --------------------------------------------------------------
SET JAVA_BATCH_HOME=D:\Hitachi\Cosminexus\jdk\bin
REM --------------------------------------------------------------

SET LIBRARY_DIR=%BATCH_HOME%\library\*
SET PROPERTY_DIR=%BATCH_HOME%\properties\*.properties

REM �K�{�t�@�C�����݃`�F�b�N
if not exist %JAVA_BATCH_HOME% goto error0

SET JAVA_CMD=%JAVA_BATCH_HOME%\java
SET CLASS_PATH=%LIBRARY_DIR%;%PROPERTY_DIR%;%JINIK_EXCEL_UPLOAD_JAR%

%JAVA_CMD% -Xms256m -Xmx512m -cp %CLASS_PATH% jp.co.hisas.career.app.batch.jinik.excelupload.JinikExcelFileUpdateBatch
REM EXIT /B %ERRORLEVEL%
REM EXIT
EXIT

:error0
echo JAVA���s�p�X����`����Ă��܂���B�ݒ���m�F���Ă��������B
set ERRORLEVEL=8
goto end

:end
REM EXIT /B %ERRORLEVEL%
EXIT
