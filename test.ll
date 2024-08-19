
$_array::size() = comdat any
$string::parseInt() = comdat any
$string::ord() = comdat any
$string::length() = comdat any
$string::substring() = comdat any

@n0 = global i32 zeroinitializer
@p1 = global i32 zeroinitializer
@k2 = global i32 zeroinitializer
@i3 = global i32 zeroinitializer
@.str6 = private unnamed_addr constant [4 x i8] c"<< "
@.str17 = private unnamed_addr constant [2 x i8] c"("
@.str19 = private unnamed_addr constant [3 x i8] c") "
@.str21 = private unnamed_addr constant [2 x i8] c" "
@.str28 = private unnamed_addr constant [4 x i8] c">> "
define i32 @main() {
common1:
	%tmp.var0 = call i32 getInt()
	store i32 %tmp.var0, @n0
	%tmp.var1 = call i32 getInt()
	store i32 %tmp.var1, @p1
	%tmp.var2 = call i32 getInt()
	store i32 %tmp.var2, @k2
	%tmp.var4 = load i32, i32 @p1
	%tmp.var5 = load i32, i32 @k2
	%tmp.var3 = sub i32 %tmp.var4, %tmp.var5
	%tmp.var4 = icmp sgt i32 %tmp.var3, 1
	%tmp.var5 = trunc i8 %tmp.var4 to i1
	br %tmp.var5, label if.true2, label if.end3
if.true2:
	call void print(ptr @.str6)
	br label if.end3
if.end3:
	br label for.init4
for.init4:
	%tmp.var7 = load i32, i32 @p1
	%tmp.var8 = load i32, i32 @k2
	%tmp.var6 = sub i32 %tmp.var7, %tmp.var8
	store i32 %tmp.var6, @i3
	br label for.cond5
for.cond5:
	%tmp.var9 = load i32, i32 @i3
	%tmp.var10 = load i32, i32 @p1
	%tmp.var11 = load i32, i32 @k2
	%tmp.var7 = add i32 %tmp.var10, %tmp.var11
	%tmp.var8 = icmp sle i32 %tmp.var9, %tmp.var7
	%tmp.var9 = trunc i8 %tmp.var8 to i1
	br %tmp.var9, label for.body6, label for.end8
for.body6:
	%tmp.var12 = load i32, i32 @i3
	%tmp.var10 = icmp sle i32 1, %tmp.var12
	%tmp.var13 = load i32, i32 @i3
	%tmp.var14 = load i32, i32 @n0
	%tmp.var11 = icmp sle i32 %tmp.var13, %tmp.var14
	%tmp.var12 = and i8 %tmp.var10, %tmp.var11
	%tmp.var13 = trunc i8 %tmp.var12 to i1
	br %tmp.var13, label if.true9, label if.end10
for.end8:
	%tmp.var25 = load i32, i32 @p1
	%tmp.var26 = load i32, i32 @k2
	%tmp.var17 = add i32 %tmp.var25, %tmp.var26
	%tmp.var27 = load i32, i32 @n0
	%tmp.var18 = icmp slt i32 %tmp.var17, %tmp.var27
	%tmp.var19 = trunc i8 %tmp.var18 to i1
	br %tmp.var19, label if.true14, label if.end15
if.true9:
	%tmp.var15 = load i32, i32 @i3
	%tmp.var16 = load i32, i32 @p1
	%tmp.var14 = icmp eq i32 %tmp.var15, %tmp.var16
	%tmp.var15 = trunc i8 %tmp.var14 to i1
	br %tmp.var15, label if.true11, label if.false12
if.end10:
	br label for.step7
if.true14:
	call void print(ptr @.str28)
	br label if.end15
if.end15:
	ret 0
if.true11:
	call void print(ptr @.str17)
	%tmp.var18 = load i32, i32 @i3
	%tmp.var16 = call ptr toString(i32 %tmp.var18)
	call void print(ptr %tmp.var16)
	call void print(ptr @.str19)
	br label if.end13
if.false12:
	%tmp.var20 = load i32, i32 @i3
	call void printInt(i32 %tmp.var20)
	call void print(ptr @.str21)
	br label if.end13
for.step7:
	%tmp.var22 = load i32, i32 @i3
	%tmp.var23 = add i32 %tmp.var22, 1
	store i32 %tmp.var23, @i3
	%tmp.var24 = load i32, i32 @i3
	br label for.cond5
if.end13:
	br label if.end10
}
