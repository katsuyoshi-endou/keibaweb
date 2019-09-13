@ECHO OFF

rem ======================================================================
rem  オートフィル物理化バッチ
rem ======================================================================
title オートフィル物理化バッチ

rem ---------------------
rem バッチ設定
rem ---------------------
Set BATCH_HOME=%~dp0
CD /D %BATCH_HOME%
Set dt=%date:~-10,4%%date:~-5,2%%date:~-2,2%
Set tm=%time: =0%
Set ts=%tm:~0,2%%tm:~3,2%%tm:~6,2%
Set BATCH_NAME=mig_sh_fill_auto

rem 【DB接続情報】パス設定
Set DB_SET_PATH=C:\Lysithea\Career\Batch\BatchSetting\setEnv.bat

rem DB接続情報の存在チェック
if not exist %DB_SET_PATH% (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

call %DB_SET_PATH%
if %ERRORLEVEL% == 8 (
EXIT /B %ERRORLEVEL%
)

rem logフォルダの存在チェック
if not exist %BATCH_HOME%\log (
set ERRORLEVEL=8
EXIT /B %ERRORLEVEL%
)

rem ---------------------
rem 本処理
rem ---------------------
SQLPLUS -s %USERNAME%/%PASSWORD%@%CONNECT% @%BATCH_HOME%sql\%BATCH_NAME%.sql >> %BATCH_HOME%log\%BATCH_NAME%_%dt%_%ts%.log
EXIT /B %ERRORLEVEL%


