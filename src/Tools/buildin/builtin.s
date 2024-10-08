	.text
	.attribute	4, 16
	.attribute	5, "rv32i2p1_m2p0_a2p1_c2p0"
	.file	"builtin.c"
	.globl	print                           # -- Begin function print
	.p2align	1
	.type	print,@function
print:                                  # @print
# %bb.0:
	mv	a1, a0
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	tail	printf
.Lfunc_end0:
	.size	print, .Lfunc_end0-print
                                        # -- End function
	.globl	println                         # -- Begin function println
	.p2align	1
	.type	println,@function
println:                                # @println
# %bb.0:
	mv	a1, a0
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	tail	printf
.Lfunc_end1:
	.size	println, .Lfunc_end1-println
                                        # -- End function
	.globl	printInt                        # -- Begin function printInt
	.p2align	1
	.type	printInt,@function
printInt:                               # @printInt
# %bb.0:
	mv	a1, a0
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	tail	printf
.Lfunc_end2:
	.size	printInt, .Lfunc_end2-printInt
                                        # -- End function
	.globl	printlnInt                      # -- Begin function printlnInt
	.p2align	1
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
# %bb.0:
	mv	a1, a0
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	tail	printf
.Lfunc_end3:
	.size	printlnInt, .Lfunc_end3-printlnInt
                                        # -- End function
	.globl	getString                       # -- Begin function getString
	.p2align	1
	.type	getString,@function
getString:                              # @getString
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	li	a0, 1024
	call	malloc
	mv	a1, a0
	sw	a1, 8(sp)                       # 4-byte Folded Spill
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	scanf
                                        # kill: def $x11 killed $x10
	lw	a0, 8(sp)                       # 4-byte Folded Reload
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	getString, .Lfunc_end4-getString
                                        # -- End function
	.globl	getInt                          # -- Begin function getInt
	.p2align	1
	.type	getInt,@function
getInt:                                 # @getInt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	getInt, .Lfunc_end5-getInt
                                        # -- End function
	.globl	toString                        # -- Begin function toString
	.p2align	1
	.type	toString,@function
toString:                               # @toString
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	sw	a0, 4(sp)                       # 4-byte Folded Spill
	li	a0, 12
	call	malloc
	lw	a2, 4(sp)                       # 4-byte Folded Reload
	sw	a0, 8(sp)                       # 4-byte Folded Spill
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	call	sprintf
                                        # kill: def $x11 killed $x10
	lw	a0, 8(sp)                       # 4-byte Folded Reload
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	toString, .Lfunc_end6-toString
                                        # -- End function
	.globl	booltoString                    # -- Begin function booltoString
	.p2align	1
	.type	booltoString,@function
booltoString:                           # @booltoString
# %bb.0:
	addi	sp, sp, -16
	lui	a1, %hi(.L.str.5)
	addi	a1, a1, %lo(.L.str.5)
	sw	a1, 8(sp)                       # 4-byte Folded Spill
	lui	a1, %hi(.L.str.4)
	addi	a1, a1, %lo(.L.str.4)
	sw	a1, 12(sp)                      # 4-byte Folded Spill
	bnez	a0, .LBB7_2
# %bb.1:
	lw	a0, 8(sp)                       # 4-byte Folded Reload
	sw	a0, 12(sp)                      # 4-byte Folded Spill
.LBB7_2:
	lw	a1, 12(sp)                      # 4-byte Folded Reload
                                        # implicit-def: $x10
	addi	sp, sp, 16
	tail	sprintf
.Lfunc_end7:
	.size	booltoString, .Lfunc_end7-booltoString
                                        # -- End function
	.globl	string.length                   # -- Begin function string.length
	.p2align	1
	.type	string.length,@function
string.length:                          # @string.length
# %bb.0:
	tail	strlen
.Lfunc_end8:
	.size	string.length, .Lfunc_end8-string.length
                                        # -- End function
	.globl	string.substring                # -- Begin function string.substring
	.p2align	1
	.type	string.substring,@function
string.substring:                       # @string.substring
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)                      # 4-byte Folded Spill
	sw	a2, 12(sp)                      # 4-byte Folded Spill
	sw	a0, 16(sp)                      # 4-byte Folded Spill
	sub	a0, a1, a0
	sw	a0, 20(sp)                      # 4-byte Folded Spill
	addi	a0, a0, 1
	call	malloc
	lw	a1, 20(sp)                      # 4-byte Folded Reload
	sw	a0, 24(sp)                      # 4-byte Folded Spill
	li	a0, 0
	bge	a0, a1, .LBB9_2
	j	.LBB9_1
.LBB9_1:
	lw	a2, 20(sp)                      # 4-byte Folded Reload
	lw	a0, 24(sp)                      # 4-byte Folded Reload
	lw	a1, 12(sp)                      # 4-byte Folded Reload
	lw	a3, 16(sp)                      # 4-byte Folded Reload
	add	a1, a1, a3
	call	memcpy
	j	.LBB9_2
.LBB9_2:
	lw	a0, 24(sp)                      # 4-byte Folded Reload
	lw	a1, 20(sp)                      # 4-byte Folded Reload
	add	a2, a0, a1
	li	a1, 0
	sb	a1, 0(a2)
	lw	ra, 28(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 32
	ret
.Lfunc_end9:
	.size	string.substring, .Lfunc_end9-string.substring
                                        # -- End function
	.globl	string.parseInt                 # -- Begin function string.parseInt
	.p2align	1
	.type	string.parseInt,@function
string.parseInt:                        # @string.parseInt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 8
	call	sscanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end10:
	.size	string.parseInt, .Lfunc_end10-string.parseInt
                                        # -- End function
	.globl	string.ord                      # -- Begin function string.ord
	.p2align	1
	.type	string.ord,@function
string.ord:                             # @string.ord
# %bb.0:
	add	a0, a0, a1
	lbu	a0, 0(a0)
	ret
.Lfunc_end11:
	.size	string.ord, .Lfunc_end11-string.ord
                                        # -- End function
	.globl	string.lt                       # -- Begin function string.lt
	.p2align	1
	.type	string.lt,@function
string.lt:                              # @string.lt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	string.lt, .Lfunc_end12-string.lt
                                        # -- End function
	.globl	string.le                       # -- Begin function string.le
	.p2align	1
	.type	string.le,@function
string.le:                              # @string.le
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	string.le, .Lfunc_end13-string.le
                                        # -- End function
	.globl	string.gt                       # -- Begin function string.gt
	.p2align	1
	.type	string.gt,@function
string.gt:                              # @string.gt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	mv	a1, a0
	li	a0, 0
	slt	a0, a0, a1
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	string.gt, .Lfunc_end14-string.gt
                                        # -- End function
	.globl	string.ge                       # -- Begin function string.ge
	.p2align	1
	.type	string.ge,@function
string.ge:                              # @string.ge
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	string.ge, .Lfunc_end15-string.ge
                                        # -- End function
	.globl	string.eq                       # -- Begin function string.eq
	.p2align	1
	.type	string.eq,@function
string.eq:                              # @string.eq
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end16:
	.size	string.eq, .Lfunc_end16-string.eq
                                        # -- End function
	.globl	string.ne                       # -- Begin function string.ne
	.p2align	1
	.type	string.ne,@function
string.ne:                              # @string.ne
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	string.ne, .Lfunc_end17-string.ne
                                        # -- End function
	.globl	string.add                      # -- Begin function string.add
	.p2align	1
	.type	string.add,@function
string.add:                             # @string.add
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)                      # 4-byte Folded Spill
	sw	a1, 20(sp)                      # 4-byte Folded Spill
	sw	a0, 16(sp)                      # 4-byte Folded Spill
	call	strlen
	mv	a1, a0
	lw	a0, 20(sp)                      # 4-byte Folded Reload
	sw	a1, 12(sp)                      # 4-byte Folded Spill
	call	strlen
	mv	a1, a0
	lw	a0, 12(sp)                      # 4-byte Folded Reload
	add	a0, a0, a1
	addi	a0, a0, 1
	call	malloc
	lw	a2, 16(sp)                      # 4-byte Folded Reload
	lw	a3, 20(sp)                      # 4-byte Folded Reload
	sw	a0, 24(sp)                      # 4-byte Folded Spill
	lui	a1, %hi(.L.str.6)
	addi	a1, a1, %lo(.L.str.6)
	call	sprintf
                                        # kill: def $x11 killed $x10
	lw	a0, 24(sp)                      # 4-byte Folded Reload
	lw	ra, 28(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 32
	ret
.Lfunc_end18:
	.size	string.add, .Lfunc_end18-string.add
                                        # -- End function
	.globl	newarray                        # -- Begin function newarray
	.p2align	1
	.type	newarray,@function
newarray:                               # @newarray
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	sw	a0, 8(sp)                       # 4-byte Folded Spill
	mul	a0, a1, a0
	addi	a0, a0, 4
	call	malloc
	lw	a1, 8(sp)                       # 4-byte Folded Reload
	sw	a1, 0(a0)
	addi	a0, a0, 4
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end19:
	.size	newarray, .Lfunc_end19-newarray
                                        # -- End function
	.globl	_array.size                     # -- Begin function _array.size
	.p2align	1
	.type	_array.size,@function
_array.size:                            # @_array.size
# %bb.0:
	addi	sp, sp, -16
	sw	a0, 8(sp)                       # 4-byte Folded Spill
	li	a1, 0
	sw	a1, 12(sp)                      # 4-byte Folded Spill
	beqz	a0, .LBB20_2
	j	.LBB20_1
.LBB20_1:
	lw	a0, 8(sp)                       # 4-byte Folded Reload
	lw	a0, -4(a0)
	sw	a0, 12(sp)                      # 4-byte Folded Spill
	j	.LBB20_2
.LBB20_2:
	lw	a0, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end20:
	.size	_array.size, .Lfunc_end20-_array.size
                                        # -- End function
	.type	.L.str,@object                  # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object                # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object                # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object                # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.type	.L.str.4,@object                # @.str.4
.L.str.4:
	.asciz	"true"
	.size	.L.str.4, 5

	.type	.L.str.5,@object                # @.str.5
.L.str.5:
	.asciz	"false"
	.size	.L.str.5, 6

	.type	.L.str.6,@object                # @.str.6
.L.str.6:
	.asciz	"%s%s"
	.size	.L.str.6, 5

	.ident	"Ubuntu clang version 18.1.8 (++20240731024944+3b5b5c1ec4a3-1~exp1~20240731145000.144)"
	.section	".note.GNU-stack","",@progbits
	.addrsig
