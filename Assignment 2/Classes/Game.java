package eg.edu.alexu.csd.datastructure.hangman;
import java.util.Scanner;


public class Game {

	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(System.in);
		Hangman game = new Hangman();
		game.readDictionary();
		System.out.print("How maney Wrong Guesses Do You Want? :");
		game.setMaxWrongGuesses(read.nextInt());
		while (game.wrongGuesses< game.maxGuesses && game.guessedWord.contains("-"))
		{
			System.out.printf("Remaing Guesses = %d \n%s\nGuess A Charactar: ",(game.maxGuesses-game.wrongGuesses),game.guessedWord);
			game.guess(read.next().charAt(0));

		}
		
		
		
	}

}
