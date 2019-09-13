ECHO OFF

Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%

REM 実行日時
Set dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
Set tm=%time: =0%
Set ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%

REM ログファイル名
SET LOG_DIR=%BATCH_HOME%\log
SET LOG_NAME=jinik_excel_upload_stop_%dt%_%ts%.log
SET LOG_FILE=%LOG_DIR%\%LOG_NAME%

REM logフォルダの存在チェック
if not exist %LOG_DIR% (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

REM バッチ起動時刻:
echo %date%_%time% : start>>%LOG_FILE%

type nul > %BATCH_HOME%\jinik_upload_stop.ri

IF ERRORLEVEL 1 (
echo %date%_%time% : abnormal_end>>%LOG_FILE%
EXIT /B 8
)
echo %date%_%time% : end>>%LOG_FILE%
EXIT /B 0
