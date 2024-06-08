import java.util.Scanner;

public class WordGame {
	
	/* The playGame() function gets ALL the user input and puts them into a string array which is returned.
	 * The user input is a String except the AGE variable which is scan.nextInt().
	 * I use a while loop with try/catch to force the user to enter a number for AGE that is above 0.
	 * It would be interesting to add a while loop and try/catch for the strings to prevent the user from entering numbers in them. (Ex: Name = 53 would be prevented.)
	*/
	public static String[] playGame(Scanner scanObj) {	
		System.out.print("\nPlease enter your name: ");
		String NAME = scanObj.nextLine();

		int AGENUM = 0;
		while (AGENUM <= 0) {
			try {
				System.out.print("Please enter your age: ");
				AGENUM = scanObj.nextInt();
			}
			catch (Exception e) {
				System.out.println("Please enter a valid number!");
				scanObj.nextLine();
			}
		}
		String AGE = String.valueOf(AGENUM);
		scanObj.nextLine();
		
		System.out.print("Please enter your hometown / city: ");
		String CITY = scanObj.nextLine();
		System.out.print("Please enter the college you attended: ");
		String COLLEGE = scanObj.nextLine();
		System.out.print("Please enter your current/dream profession: ");
		String PROFESSION = scanObj.nextLine();
		System.out.print("Please enter an animal: ");
		String ANIMAL = scanObj.nextLine();
		System.out.print("Please enter an animal name: ");
		String PETNAME = scanObj.nextLine();
		
		//this is the array of userInput for the story
		String[] wordList = {NAME, AGE, CITY, COLLEGE, PROFESSION, ANIMAL, PETNAME};
		return wordList;
	}
	
	
	/* The displayOutput() function displays all the userInput that was captured in the playGame() function.
	 * I pass in an array as the argument.
	 */
	public static void displayOutput(String[] wordList) {
		String name = wordList[0];
		String age = wordList[1];
		String city = wordList[2];
		String college = wordList[3];
		String profession = wordList[4];
		String animal = wordList[5];
		String petname = wordList[6];
		
		System.out.println("\n\nThere once was a person named " + name + " who lived in " + city + ".");
		System.out.println("At the age of " + age + ", " + name + " went to " + college + ".");
		System.out.println(name + " graduated and went to work as a " + profession + ".");
		System.out.println("Then, " + name + " adopted a(n) " + animal + " named " + petname + ".");
		System.out.println("They both lived happily ever after!\n\n");
		
	}
	
	
	/* The checkRestart() function runs at the beginning of the program and end of every game session.
	 * It prompts the user if they want to play, and returns true/false depending on the userInput.
	 */
	public static Boolean checkRestart(Scanner scanObj) {
		System.out.print("Press ENTER to play a word game (N to QUIT): ");
		String startGame = scanObj.nextLine();
		if (startGame.equals("N")  || startGame.equals("n")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		//greet the user
		System.out.println("Hello! Welcome to the Word Game App!\n\n");
		
		//create scanner object and delimiter for excessive enters of nextInt().
		Scanner inputObj = new Scanner(System.in);
		inputObj.useDelimiter("\\R");
		
		//create empty array for the userInput. I declare this before the while loop to avoid creating it over and over.
		String [] wordList;
		
		//check if the user wants to play the word game for the first time.
		Boolean restart = checkRestart(inputObj);
		
		//while the user wants to play, I run the playGame(), displayOutput() and checkRestart() functions.
		while (restart) {
			//wordList gets the values from the playGame() function.
			wordList = playGame(inputObj);
			//pass the wordList to displayOutput() to be displayed.
			displayOutput(wordList);
			//check if user wants to keep on playing
			restart = checkRestart(inputObj);
		}
		
		//The user doesn't want to play, end program
		System.out.println("\n\nGame Ended! Goodbye");
		
		//close scanner to avoid leaks.
		inputObj.close();
	}
	
}


/**
System.out.println("\n\nThere once was a person named " + NAME + " who lived in " + CITY + ".");
System.out.println("At the age of " + AGE + ", " + NAME + " went to " + COLLEGE + ".");
System.out.println(NAME + " graduated and went to work as a " + PROFESSION + ".");
System.out.println("Then " + NAME + " adopted a(n) " + ANIMAL + " named " + PETNAME + ".");
System.out.println("They both lived happily ever after!\n\n");
*/
