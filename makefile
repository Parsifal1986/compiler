# 变量定义
JAVAC = javac
JAVA = java
SRC = src
BIN = build
MAIN = Compiler
ANTLR_JAR_PATH = /ulib/antlr-4.9.3-complete.jar

.PHONY: build clean run

# 编译目标
build: 
	@javac -sourcepath src -d $(BIN) src/Compiler.java

# 运行Java程序
run:
	@java -cp "$(BIN):$(ANTLR_JAR_PATH)" Compiler

# 清理生成的class文件
clean:
	rm -rf $(BIN)
