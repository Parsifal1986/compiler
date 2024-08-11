#!/bin/bash

# 切换到项目目录
cd /root/repository/compiler

ANTLR_JAR_PATH=lib/antlr-4.9.3-complete.jar

# 编译Java文件
java -cp "bin:$ANTLR_JAR_PATH" Compiler

# echo "运行完成"