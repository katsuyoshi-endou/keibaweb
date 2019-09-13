echo off

SET /P ANSWER="「D:\Hitachi\Cosminexus\xxxx」にパスを通します。ドライブ・パスは正しいですか（Y/N）？"

if /i {%ANSWER%}=={y} (goto :yes)
if /i {%ANSWER%}=={yes} (goto :yes)

pause

exit

:yes

setx /M PATH "D:\Hitachi\Cosminexus\jdk\bin;D:\Hitachi\Cosminexus\PRF\bin;D:\Hitachi\Cosminexus\TPB\bin;D:\Hitachi\Cosminexus\DAB\lib;%PATH%;"
setx /M TZ "JST-9"

pause
