echo off

SET /P ANSWER="�uD:\Hitachi\Cosminexus\xxxx�v�Ƀp�X��ʂ��܂��B�h���C�u�E�p�X�͐������ł����iY/N�j�H"

if /i {%ANSWER%}=={y} (goto :yes)
if /i {%ANSWER%}=={yes} (goto :yes)

pause

exit

:yes

setx /M PATH "D:\Hitachi\Cosminexus\jdk\bin;D:\Hitachi\Cosminexus\PRF\bin;D:\Hitachi\Cosminexus\TPB\bin;D:\Hitachi\Cosminexus\DAB\lib;%PATH%;"
setx /M TZ "JST-9"

pause
