@echo off
echo Finding sources...
wsl -- find . -name *.java > sources.txt
echo Compiling...
javac -sourcepath @sources.txt
