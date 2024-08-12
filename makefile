.PHONY: build
build:
	find -name '*.java' | xargs javac -d build -cp /ulib/antlr-4.9.3-complete.jar

.PHONY: run
run:
	cd build && java -cp /ulib/antlr-4.9.3-complete.jar:. Compiler