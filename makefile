java:
	javac -d .  *.java


run:
	java vending_machine_solution.Machine


clean:
	rm *~


reset:
	make clean && rm *.class
