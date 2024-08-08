current_dir=$(pwd)

ANTLR_JAR_PATH="$current_dir/lib/antlr-4.9.3-complete.jar"

# 设置输出目录
OUTPUT_DIR="src/Parser"

# 设置包名
PACKAGE_NAME="Parser"

# 编译语法文件
java -jar "$ANTLR_JAR_PATH" -Dlanguage=Java -package "$PACKAGE_NAME" -visitor -o "$OUTPUT_DIR" $current_dir/src/Parser/Mx.g4

# 打印编译完成信息
echo "ANTLR4 语法文件编译完成。"
