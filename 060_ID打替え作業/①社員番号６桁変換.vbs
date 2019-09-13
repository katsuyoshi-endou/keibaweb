Option Explicit

'**************************************************************************************
'*	名前：社員コード修正スクリプト
'*	内容：CSVファイルから社員番号を抽出し前０をセットする
'*	FILE：社員番号６桁変換
'*	備考：
'*
'*	作成：2011/09/20 N.YOSHIDA 初回リリース
'*  履歴：XXXX/XX/XX X.XXXXXXX 
'**************************************************************************************

'Public Const SearchString = "\"	'この文字列を書き換えることによって、参照先の削除対象を更新可能です。
Dim fso
Dim objArgs
Dim dic
Dim CsvBook
Dim CrtCsvBook
Dim CrtPATH
Dim idx
'**************************************************************************************

Set fso = CreateObject("Scripting.FileSystemObject")
Set dic = CreateObject("Scripting.Dictionary")

'引数取得
set objArgs = WScript.Arguments

'**************************************************************************************
if objArgs.Count < 1 then
	MsgBox "ＣＳＶファイル又はディレクトリをドラッグして下さい。", vbOKOnly, "データ変換ツール"
	WScript.Quit
end if

Dim res
Dim f
' 対象Excelファイルの検索
if StrComp(fso.GetExtensionName(objArgs(0)),"csv",vbTextCompare)=0 then
  for each f In objArgs
    dic.Add f,f
  next
else
	WScript.Echo "csvじゃないとだめ"
	WScript.Quit
end if
'**************************************************************************************

res = MsgBox(objArgs(0) + vbCrLf + "内の" + CStr(dic.Count) + "ファイルから社員番号を６桁に変換します。" + vbCrLf + vbCrLf _
	+ "実行しますか？" + vbCrLf + vbCrLf _ 
	+ "はい　　　　：　社員番号を変換してファイルを出力します。" + vbCrLf  _ 
	+ "いいえ　　　：　なにもせず終了します。　" + vbCrLf  _ 
	, vbYesNo , "社員番号の変換")
if res = vbNo then
	WScript.Quit
end if

'	, vbYesNoCancel or vbQuestion, "社員番号の変換")
'**************************************************************************************
Dim Inline
Dim LineCnt
Dim SkipLine
Dim AfterLine
Dim BforeLine
 
Dim Acnt
Dim Alen
Dim SYAINCD

SkipLine = 3

for each f in dic.Items
	
	idx = 0
	LineCnt = 0
	'------------------------------------
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\変更後" & fso.GetBaseName(objArgs(idx)) & ".CSV"
	SET CsvBook 	= fso.OpenTextFile(objArgs(idx))
	SET CrtCsvBook  = fso.CreateTextFile(CrtPATH)

	If Err.Number <> 0 Then
		' エラー発生時はログ出力して続行する
		idx = idx + 1
		ResultErrLog.Add CStr(f) + "(" + CStr(idx) + ")",_
			" / ErrNo:" + CStr(Err.Number) & ", " & CStr(Err.Description)
	Else
	'------------------------------------
		Do Until ( CsvBook.AtEndOfStream )
			LineCnt = LineCnt + 1
			Inline = CsvBook.ReadLine
			If LineCnt >= SkipLine Then
				'左から第一カンマ以降を抽出
				Acnt = InStr(Inline,",")	'左からのカンマまでの桁数取得
				Alen = len(Inline) - Acnt + 1	'カンマ以降の文字長算出
				AfterLine = Mid(Inline,Acnt,Alen)
				BforeLine = Mid(Inline,1,(Acnt-1))
				SYAINCD   = REPLACE(BforeLine,"""","")
				'-------------------------------------------------
				Alen      = Len(SYAINCD)
				If Alen = 1 Then
					SYAINCD = "00000" & SYAINCD
				ElseIf  Alen = 2 Then
					SYAINCD = "0000" & SYAINCD
				ElseIf  Alen = 3 Then
					SYAINCD = "000" & SYAINCD
				ElseIf  Alen = 4 Then
					SYAINCD = "00" & SYAINCD
				ElseIf  Alen = 5 Then
					SYAINCD = "0" & SYAINCD
				End If
				
				'WScript.Echo SYAINCD  DEBUG DISP 
				Inline = """" & SYAINCD & """" & AfterLine
			End If
			CrtCsvBook.WriteLine(Inline)
		Loop
	End If
	CsvBook.CLOSE
	CrtCsvBook.CLOSE
next

