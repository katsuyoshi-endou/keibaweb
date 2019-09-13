Option Explicit

'**************************************************************************************
'*	名前：組織情報修正スクリプト
'*	内容：CSVファイルから組織１０～２０を削除名称１０～２０を削除
'*	FILE：組織コード変換
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
	' ディレクトリ指定。再帰的に検索する

end if
'**************************************************************************************

res = MsgBox(objArgs(0) + vbCrLf + "内の" + CStr(dic.Count) + "ファイルから組織情報１０～２０までの項目を削除します。" + vbCrLf + vbCrLf _
	+ "実行しますか？" + vbCrLf + vbCrLf _ 
	+ "はい　　　　：　組織情報を変換してファイルを出力します。" + vbCrLf  _ 
	+ "いいえ　　　：　なにもせず終了します。　" + vbCrLf  _ 
	, vbYesNo , "組織情報の変換")
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
Dim PutLine
 
Dim Acnt
Dim Alen
Dim Sprit10

SkipLine = 1

for each f in dic.Items
	
	idx = 0
	LineCnt = 0
	'------------------------------------
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\変更後" & fso.GetBaseName(objArgs(idx)) & ".csv"
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
				AfterLine = Inline			'全文字列をセット
				Sprit10   = 0
				PutLine   = ""
				'------------------------------------
				Do Until (Acnt = 0)
					Sprit10 = Sprit10 +1
					Acnt = InStr(AfterLine,",")			'左からのカンマまでの桁数取得
					Alen = len(AfterLine) - Acnt 		'カンマ以降の文字長算出
					BforeLine = Mid(AfterLine,1,Acnt)
'					WScript.Echo Acnt & "BFORE" & BforeLine 'DEBUG DISP 
					AfterLine = Mid(AfterLine,Acnt+1,Alen)
'					WScript.Echo Acnt & "AFTER" & AfterLine 'DEBUG DISP 
					If (Sprit10 > 16 and Sprit10 < 28)  Then
					ElseIf (Sprit10 > 36 and Sprit10 < 48) Then
					Else
						PutLine =  PutLine & BforeLine 
					End If
					''
					''
				Loop
				PutLine =  PutLine & AfterLine
				'------------------------------------
			End If
			CrtCsvBook.WriteLine(PutLine)
		Loop
	End If
	CsvBook.CLOSE
	CrtCsvBook.CLOSE
next

