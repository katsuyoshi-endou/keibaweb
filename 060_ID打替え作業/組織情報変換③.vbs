Option Explicit

'**************************************************************************************
'*	名前：組織情報修正スクリプト
'*	内容：CSVファイルから組織１０～２０を削除名称１０～２０を削除
'*	FILE：組織コード変換
'*	備考：
'*
'*	作成：2011/09/20 N.YOSHIDA	初回リリース
'*  履歴：2019/09/05 Y.MAEDA	上位コードを当該組織コードへ変換するよう修正
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

dim debug_flg
debug_flg = 0

if debug_flg = 0 then
	'**************************************************************************************
	if objArgs.Count < 1 then
		MsgBox "ＣＳＶファイル又はディレクトリをドラッグして下さい。", vbOKOnly, "データ変換ツール"
		WScript.Quit
	end if
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
if debug_flg = 0 then
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
end if

Dim Inline
Dim LineCnt
Dim SkipLine
Dim AfterLine
Dim BforeLine
Dim PutLine
 
Dim Acnt
Dim Alen
Dim Sprit10
Dim strArray
Dim strParentCode

SkipLine = 1

for each f in dic.Items
	
	idx = 0
	LineCnt = 0
	'------------------------------------
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\変更後" & fso.GetBaseName(objArgs(idx)) & ".csv"
	SET CsvBook 	= fso.OpenTextFile(objArgs(idx))
	SET CrtCsvBook  = fso.CreateTextFile(CrtPATH)
	
	redim RankList(0)
	redim CodeList(0)
	redim SzkList(0)

	Dim i
	i = 0

	'上位組織検索用配列作成
	Do Until ( CsvBook.AtEndOfStream )
		Inline = CsvBook.ReadLine
		
		strArray = split(Inline,",")
		redim preserve RankList(i)
		redim preserve CodeList(i)
		redim preserve SzkList(i)
		
		RankList(i) = strArray(0)
		CodeList(i) = strArray(1)
		SzkList(i) = strArray(51)

		i = i + 1
		
	Loop
	CsvBook.CLOSE


	SET CsvBook 	= fso.OpenTextFile(objArgs(idx))

	If Err.Number <> 0 Then
		' エラー発生時はログ出力して続行する
		idx = idx + 1
'		ResultErrLog.Add CStr(f) + "(" + CStr(idx) + ")",_
'			" / ErrNo:" + CStr(Err.Number) & ", " & CStr(Err.Description)
	else
		PutLine = ""

		'ランク、コード、所属コードの配列作成

		'CSV書き出し処理
		Do Until ( CsvBook.AtEndOfStream )

			Inline = CsvBook.ReadLine

			strArray = split(Inline,",")
			strParentCode = "0"

			'上位ランク、上位コードより、上位所属コードを求める
			call parent_code(strArray(2),strArray(3), strParentCode)
			
			'wscript.echo "ランク:" & strArray(0)
			'wscript.echo "コード:" & strArray(1)
			'wscript.echo "上位ランク:" & strArray(2)
			'wscript.echo "上位コード:" & strArray(3)
			'wscript.echo "部署コード:" & strArray(51)
			'wscript.echo "上位部署コード:" & strParentCode
			

			'ライン書き出し（コード10～20、名称10～20は不要）
			PutLine = 	strArray(0) & "," & strArray(51) & "," & strArray(2) & "," & strParentCode & "," &  strArray(4) & "," & _
						strArray(5) & "," & strArray(6) & "," & strArray(7) & "," & strArray(8) & "," &  strArray(9) & "," & _
						strArray(10) & "," & strArray(11) & "," & strArray(12) & "," & strArray(13) & "," &  strArray(14) & "," & _
						strArray(15) & "," & strArray(27) & "," & strArray(28) & "," & strArray(29) & "," &  strArray(30) & "," & _
						strArray(31) & "," & strArray(32) & "," & strArray(33) & "," & strArray(34) & "," &  strArray(35) & "," & _
						strArray(47) & "," & strArray(48) & "," & strArray(49) & "," & strArray(50) & "," & strArray(51) & "," & _
						strArray(52)

			'wscript.echo PutLine
			CrtCsvBook.WriteLine(PutLine)

		Loop
	end if
	CsvBook.CLOSE
	CrtCsvBook.CLOSE
next


'///////////////////////////////////////////////////////////////////////////
'■ 上位組織の部署コード取得
'
'引数
'				:rank	上位ランク
'				:code	上位コード
'戻り値
'				:strParentCode	上位所属コード
'///////////////////////////////////////////////////////////////////////////

Function parent_code(rank,code,strParentCode)

	for i = 0 To UBound(RankList)
		if RankList(i) = rank and CodeList(i) = code then
			strParentCode = SzkList(i)
			'wscript.echo "上位部署コード:" & strParentCode
			exit Function
		end if 
	Next

end Function































