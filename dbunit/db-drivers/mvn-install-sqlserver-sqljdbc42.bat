rem Convenience script to put Microsoft SQL Server DB driver jar in local Maven repo for building dbUnit

rem To use this script:
rem  1. download driver jar from Oracle website
rem  2. place the jar in directory containing this script and run this script

setlocal

set FILE=sqljdbc42.jar
set GROUP=com.microsoft
set ARTIFACT=sqljdbc42
set VERSION=4.2.0

mvn install:install-file -Dfile=%FILE% -DgroupId=%GROUP% -DartifactId=%ARTIFACT% -Dversion=%VERSION% -Dpackaging=jar

endlocal
