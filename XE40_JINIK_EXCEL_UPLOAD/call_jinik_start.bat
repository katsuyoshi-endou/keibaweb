@ECHO OFF
REM ****************************************************************
REM  概要	： 人材育成計画Excelアップロードファイル取込みを起動する
REM ****************************************************************

title 人材育成計画Excelアップロードファイル取込みバッチ

Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%

REM 変数セット
Set dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
Set tm=%time: =0%
Set ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%

REM logフォルダの存在チェック
if not exist %BATCH_HOME%\log (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

REM 人材育成計画Excelアップロードファイル取込み
CD /D %BATCH_HOME%

START %BATCH_HOME%\jinik_excel_upload_start.bat

rem jinik_excel_upload_start.batでjinik_upload_stop.riが削除される処理が実行されるまでスリープ
ping 127.0.0.1 -n 10 > nul

IF EXIST %BATCH_HOME%\jinik_upload_stop.ri (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)
EXIT /B %ERRORLEVEL%
