make:
	make compile

compile:
	javac -d .  *.java


run:	compile
	java vending_machine_solution.Machine


test:	compile
	java vending_machine_solution.Testing


clean:
	rm *~


reset:
	make clean && rm *.class
