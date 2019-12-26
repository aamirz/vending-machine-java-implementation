
## Vending Machine : Java Implementation

The supplied makefile contains all the instructions for compiling this solution and running tests.
Most of the magic happens in Machine.java (which implements the VendingMachine interfaces).

To compile you can issue:

```
$ make
```

or

```
$ make compile
```

To run tests you can issue:

```
$ make test
```

At this point in time the testing infrastructure is a bit rudimentary. A human being has to run the tests and inspect the machine's behavior (standard output) in order to determine if it is working properly. Luckily, real vending machines do concern themselves with a human customer's experience. 

For more robust testing, ideally the vending machine would have a well defined log (location supplied by user) and the tests would perform actions and then check the log output.
