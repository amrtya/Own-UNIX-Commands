#! /bin/bash

javac ~/Programming/PersonalProjects/Own-UNIX-Commands/own-wc-command/src/Main.java; 


if [ $# -eq 0 ];
  then
    java -cp ~/Programming/PersonalProjects/Own-UNIX-Commands/own-wc-command/src: Main
elif [ $# -eq 1 ];
  then
    java -cp ~/Programming/PersonalProjects/Own-UNIX-Commands/own-wc-command/src: Main "$1"
elif [ $# -eq 2 ];
  then
    java -cp ~/Programming/PersonalProjects/Own-UNIX-Commands/own-wc-command/src: Main "$1" "$2"  
fi
