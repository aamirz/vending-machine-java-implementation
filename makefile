make:
	make compile

compile:
	javac -d .  *.java


run:
	java vending_machine_solution.Machine


test:
	java vending_machine_solution.Testing


clean:
	rm *~


reset:
	make clean && rm *.class
