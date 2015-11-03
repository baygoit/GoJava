One of the great example of Chain of Responsibility pattern is ATM Dispense machine.
The user enters the amount to be dispensed and the machine dispense amount in terms of defined currency bills
such as 50$, 20$, 10$ etc. If the user enters an amount that is not multiples of 10, it throws error.
We will use Chain of Responsibility pattern to implement this solution.
The chain will process the request in the same order as below image.