@ECHO OFF
REM *************************************************************
REM  概要	： 人材育成計画Excelアップロードファイル取込み起動バッチ
REM *************************************************************

title 人材育成計画Excelアップロード取込みバッチ

Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%

SET JINIK_EXCEL_UPLOAD_JAR=%BATCH_HOME%\jar\JinikExcelUpload.jar

REM 【手動設定欄】Java実行パスを定義してください（Java 8）
REM --------------------------------------------------------------
SET JAVA_BATCH_HOME=D:\Hitachi\Cosminexus\jdk\bin
REM --------------------------------------------------------------

SET LIBRARY_DIR=%BATCH_HOME%\library\*
SET PROPERTY_DIR=%BATCH_HOME%\properties\*.properties

REM 必須ファイル存在チェック
if not exist %JAVA_BATCH_HOME% goto error0

SET JAVA_CMD=%JAVA_BATCH_HOME%\java
SET CLASS_PATH=%LIBRARY_DIR%;%PROPERTY_DIR%;%JINIK_EXCEL_UPLOAD_JAR%

%JAVA_CMD% -Xms256m -Xmx512m -cp %CLASS_PATH% jp.co.hisas.career.app.batch.jinik.excelupload.JinikExcelFileUpdateBatch
REM EXIT /B %ERRORLEVEL%
REM EXIT
EXIT

:error0
echo JAVA実行パスが定義されていません。設定を確認してください。
set ERRORLEVEL=8
goto end

:end
REM EXIT /B %ERRORLEVEL%
EXIT
