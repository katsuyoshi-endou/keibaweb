Option Explicit

'**************************************************************************************
'*	���O�F�g�D���C���X�N���v�g
'*	���e�FCSV�t�@�C������g�D�P�O�`�Q�O���폜���̂P�O�`�Q�O���폜
'*	FILE�F�g�D�R�[�h�ϊ�
'*	���l�F
'*
'*	�쐬�F2011/09/20 N.YOSHIDA	���񃊃��[�X
'*  �����F2019/09/05 Y.MAEDA	��ʃR�[�h�𓖊Y�g�D�R�[�h�֕ϊ�����悤�C��
'**************************************************************************************

'Public Const SearchString = "\"	'���̕���������������邱�Ƃɂ���āA�Q�Ɛ�̍폜�Ώۂ��X�V�\�ł��B
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

'�����擾
set objArgs = WScript.Arguments

dim debug_flg
debug_flg = 0

if debug_flg = 0 then
	'**************************************************************************************
	if objArgs.Count < 1 then
		MsgBox "�b�r�u�t�@�C�����̓f�B���N�g�����h���b�O���ĉ������B", vbOKOnly, "�f�[�^�ϊ��c�[��"
		WScript.Quit
	end if
end if

Dim res
Dim f
' �Ώ�Excel�t�@�C���̌���
if StrComp(fso.GetExtensionName(objArgs(0)),"csv",vbTextCompare)=0 then
  for each f In objArgs
    dic.Add f,f
  next
else
	WScript.Echo "csv����Ȃ��Ƃ���"
	WScript.Quit
	' �f�B���N�g���w��B�ċA�I�Ɍ�������

end if
if debug_flg = 0 then
	'**************************************************************************************

	res = MsgBox(objArgs(0) + vbCrLf + "����" + CStr(dic.Count) + "�t�@�C������g�D���P�O�`�Q�O�܂ł̍��ڂ��폜���܂��B" + vbCrLf + vbCrLf _
		+ "���s���܂����H" + vbCrLf + vbCrLf _ 
		+ "�͂��@�@�@�@�F�@�g�D����ϊ����ăt�@�C�����o�͂��܂��B" + vbCrLf  _ 
		+ "�������@�@�@�F�@�Ȃɂ������I�����܂��B�@" + vbCrLf  _ 
		, vbYesNo , "�g�D���̕ϊ�")
	if res = vbNo then
		WScript.Quit
	end if
	'	, vbYesNoCancel or vbQuestion, "�Ј��ԍ��̕ϊ�")
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
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\�ύX��" & fso.GetBaseName(objArgs(idx)) & ".csv"
	SET CsvBook 	= fso.OpenTextFile(objArgs(idx))
	SET CrtCsvBook  = fso.CreateTextFile(CrtPATH)
	
	redim RankList(0)
	redim CodeList(0)
	redim SzkList(0)

	Dim i
	i = 0

	'��ʑg�D�����p�z��쐬
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
		' �G���[�������̓��O�o�͂��đ��s����
		idx = idx + 1
'		ResultErrLog.Add CStr(f) + "(" + CStr(idx) + ")",_
'			" / ErrNo:" + CStr(Err.Number) & ", " & CStr(Err.Description)
	else
		PutLine = ""

		'�����N�A�R�[�h�A�����R�[�h�̔z��쐬

		'CSV�����o������
		Do Until ( CsvBook.AtEndOfStream )

			Inline = CsvBook.ReadLine

			strArray = split(Inline,",")
			strParentCode = "0"

			'��ʃ����N�A��ʃR�[�h���A��ʏ����R�[�h�����߂�
			call parent_code(strArray(2),strArray(3), strParentCode)
			
			'wscript.echo "�����N:" & strArray(0)
			'wscript.echo "�R�[�h:" & strArray(1)
			'wscript.echo "��ʃ����N:" & strArray(2)
			'wscript.echo "��ʃR�[�h:" & strArray(3)
			'wscript.echo "�����R�[�h:" & strArray(51)
			'wscript.echo "��ʕ����R�[�h:" & strParentCode
			

			'���C�������o���i�R�[�h10�`20�A����10�`20�͕s�v�j
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
'�� ��ʑg�D�̕����R�[�h�擾
'
'����
'				:rank	��ʃ����N
'				:code	��ʃR�[�h
'�߂�l
'				:strParentCode	��ʏ����R�[�h
'///////////////////////////////////////////////////////////////////////////

Function parent_code(rank,code,strParentCode)

	for i = 0 To UBound(RankList)
		if RankList(i) = rank and CodeList(i) = code then
			strParentCode = SzkList(i)
			'wscript.echo "��ʕ����R�[�h:" & strParentCode
			exit Function
		end if 
	Next

end Function































