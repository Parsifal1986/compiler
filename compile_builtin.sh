cd src/Tools/buildin/

clang-18 -S -emit-llvm --target=riscv32-unknown-elf -O2 -fno-builtin-printf -fno-builtin-scanf -fno-builtin-sprintf -fno-builtin-strlen -fno-builtin-sscanf -fno-builtin-strcmp -fno-builtin-strcat builtin.c -o builtin_intermediate.ll

sed 's/string_/string./g;s/array_/_array./g' builtin_intermediate.ll > builtin.ll