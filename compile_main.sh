#!/bin/bash

# 切换到项目目录
cd /root/repository/compiler

# 编译Java文件
javac -sourcepath src -d bin src/Compiler.java


echo "Java文件编译完成"
