cd /root/repository/compiler

if [ -n "$2" ]; then
  testcases/codegen/scripts/test_asm.bash 'sh run_main.sh' testcases/codegen/$1 src/Tools/buildin/builtin.ll tmp $2
else
  testcases/codegen/scripts/test_asm.bash 'sh run_main.sh' testcases/codegen/$1 src/Tools/buildin/builtin.ll tmp
fi