Option Explicit

'**************************************************************************************
'*	���O�F�g�D���C���X�N���v�g
'*	���e�FCSV�t�@�C������g�D�P�O�`�Q�O���폜���̂P�O�`�Q�O���폜
'*	FILE�F�g�D�R�[�h�ϊ�
'*	���l�F
'*
'*	�쐬�F2011/09/20 N.YOSHIDA ���񃊃��[�X
'*  �����FXXXX/XX/XX X.XXXXXXX 
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

'**************************************************************************************
if objArgs.Count < 1 then
	MsgBox "�b�r�u�t�@�C�����̓f�B���N�g�����h���b�O���ĉ������B", vbOKOnly, "�f�[�^�ϊ��c�[��"
	WScript.Quit
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
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\�ύX��" & fso.GetBaseName(objArgs(idx)) & ".csv"
	SET CsvBook 	= fso.OpenTextFile(objArgs(idx))
	SET CrtCsvBook  = fso.CreateTextFile(CrtPATH)

	If Err.Number <> 0 Then
		' �G���[�������̓��O�o�͂��đ��s����
		idx = idx + 1
		ResultErrLog.Add CStr(f) + "(" + CStr(idx) + ")",_
			" / ErrNo:" + CStr(Err.Number) & ", " & CStr(Err.Description)
	Else
	'------------------------------------
		Do Until ( CsvBook.AtEndOfStream )
			LineCnt = LineCnt + 1
			Inline = CsvBook.ReadLine
			If LineCnt >= SkipLine Then
				'��������J���}�ȍ~�𒊏o
				Acnt = InStr(Inline,",")	'������̃J���}�܂ł̌����擾
				AfterLine = Inline			'�S��������Z�b�g
				Sprit10   = 0
				PutLine   = ""
				'------------------------------------
				Do Until (Acnt = 0)
					Sprit10 = Sprit10 +1
					Acnt = InStr(AfterLine,",")			'������̃J���}�܂ł̌����擾
					Alen = len(AfterLine) - Acnt 		'�J���}�ȍ~�̕������Z�o
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

