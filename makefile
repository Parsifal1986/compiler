# 变量定义
JAVAC = javac
JAVA = java
SRC = src                          # 源代码目录
BIN = bin                          # 编译后的输出目录
MAIN = Compiler                    # 主类文件名（不带扩展名）
ANTLR_JAR_PATH = /ulib/antlr-4.9.3-complete.jar  # ANTLR JAR 文件路径

# 获取主Java文件
MAIN_SRC = $(SRC)/$(MAIN).java

# 默认目标
all: $(BIN)/$(MAIN).class

# 编译Java文件
$(BIN)/$(MAIN).class: $(MAIN_SRC)
	@mkdir -p $(BIN)
	$(JAVAC) -sourcepath $(SRC) -d $(BIN) $(MAIN_SRC)

# 运行Java程序
run: all
	$(JAVA) -cp "$(BIN):$(ANTLR_JAR_PATH)" $(MAIN)

# 清理生成的class文件
clean:
	rm -rf $(BIN)

.PHONY: all clean run
