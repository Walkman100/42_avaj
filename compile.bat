@echo off
echo Finding sources...
wsl -- find . -name *.java > sources.txt

rem Fix for logger not being compiled
rem echo ./wtc/mcarter/avaj/simulator/Logger.java >> sources.txt

echo Compiling...
javac -sourcepath @sources.txt
