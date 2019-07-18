package co.grandcircus;

import java.util.Scanner;

public class Lab6 {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String cont = "yes";
	int timesRolled = 0;
	int sides = 0;
	while (cont.equalsIgnoreCase("yes")) {
	    if (timesRolled == 0) {
		System.out.println("Welcome to the Grand Circus Casino!" + "\n");
		System.out.println("How many sides should each die have?");
		System.out.print("> ");
		sides = scan.nextInt();
	    }

	    int firstRoll = randomDiceRoll(sides);
	    int secondRoll = randomDiceRoll(sides);
	    timesRolled++;

	    printDiceRoll(timesRolled, firstRoll, secondRoll);

	    // Special rolls apply only to 6-sided dice
	    if (sides == 6) {
		String message = specialRoll(firstRoll, secondRoll);
		if (!message.isEmpty()) {
		    System.out.println(message);
		} else {
		    System.out.println();
		}
	    }

	    System.out.println();
	    System.out.println("Roll again? (yes/no)");
	    cont = scan.next();
	}

	System.out.println("Goodbye.");
	scan.close();
    }

    public static int randomDiceRoll(int sides) {
	return (int) (Math.random() * sides) + 1;
    }

    public static String specialRoll(int die1, int die2) {
	if ((die1 + die2 == 7) || (die1 + die2 == 11)) {
	    return "You rolled craps.";
	} else if (die1 == 1 && die2 == 1) {
	    return "You rolled snake eyes.";
	} else if (die1 == 6 && die2 == 6) {
	    return "You rolled box cars.";
	}
	return "";
    }

    private static void printDiceRoll(int timesRolled, int firstRoll, int secondRoll) {
	System.out.printf("Roll %d:\n", timesRolled);
	System.out.println(firstRoll);
	System.out.println(secondRoll);
    }

}
