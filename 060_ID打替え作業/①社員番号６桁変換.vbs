Option Explicit

'**************************************************************************************
'*	���O�F�Ј��R�[�h�C���X�N���v�g
'*	���e�FCSV�t�@�C������Ј��ԍ��𒊏o���O�O���Z�b�g����
'*	FILE�F�Ј��ԍ��U���ϊ�
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
end if
'**************************************************************************************

res = MsgBox(objArgs(0) + vbCrLf + "����" + CStr(dic.Count) + "�t�@�C������Ј��ԍ����U���ɕϊ����܂��B" + vbCrLf + vbCrLf _
	+ "���s���܂����H" + vbCrLf + vbCrLf _ 
	+ "�͂��@�@�@�@�F�@�Ј��ԍ���ϊ����ăt�@�C�����o�͂��܂��B" + vbCrLf  _ 
	+ "�������@�@�@�F�@�Ȃɂ������I�����܂��B�@" + vbCrLf  _ 
	, vbYesNo , "�Ј��ԍ��̕ϊ�")
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
 
Dim Acnt
Dim Alen
Dim SYAINCD

SkipLine = 3

for each f in dic.Items
	
	idx = 0
	LineCnt = 0
	'------------------------------------
	CrtPATH = fso.GetParentFolderName(objArgs(idx)) & "\�ύX��" & fso.GetBaseName(objArgs(idx)) & ".CSV"
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
				Alen = len(Inline) - Acnt + 1	'�J���}�ȍ~�̕������Z�o
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

