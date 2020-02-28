package eg.edu.alexu.csd.datastructure.hangman;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;


public class Hangman implements IHangman {
	private ArrayList<String> dictionary = new ArrayList<String>();
	private String[] words;
	public int maxGuesses=1;
	public int wrongGuesses;
	public String secretWord;
	public	String guessedWord;
	private	String guessedChars="";
	
	public void readDictionary(){
		try {
			dictionary = (ArrayList<String>) Files.readAllLines(Paths.get("dictionary.txt"));

		}
		catch (IOException e) {
			System.out.println("Could not Read The Dictionary File Not Found?!");
			}
		words = new String[dictionary.size()];
		setDictionary(words);
	}
		
	
	public void setDictionary(String[] words){
        for (int i = 0; i < dictionary.size(); i++) { 
        	words[i] = dictionary.get(i); 
        }
		secretWord=selectRandomSecretWord();		 
		 
	}
	public String selectRandomSecretWord(){
		Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt())%words.length;
        secretWord=words[wordIndex];
        wrongGuesses= 0;
        guessedWord="";
        for(int i = 0; i < secretWord.length(); i++)
		{
			guessedWord += "-";
		}
        return words[wordIndex];
		
	}
	public String guess(Character c) throws Exception{
		if(!secretWord.matches("^[a-zA-Z]*$") || secretWord==null){
			throw new Exception ("Buggy Secret Word");
		}
		
		if(c == null || !(c.toString()).matches("^[a-zA-Z]")){
			System.out.println("Enter A Character From A-Z Or a-z");
			return guessedWord;
		}
		
		if( guessedWord.toLowerCase().contains(c.toString().toLowerCase())){
			System.out.println("You Already Guessed This Character AND You Know It IS in The Word: ");
			return guessedWord;
		}
		
		if( guessedChars.toLowerCase().contains(c.toString().toLowerCase())) {
			System.out.println("You Already Guessed This Character AND You Know It IS NOT in The Word: ");
			return guessedWord;

		}
		
		guessedChars += c;
		
		
		if(secretWord.toLowerCase().contains(c.toString().toLowerCase())) {
			for(int i = 0; i < secretWord.length(); i++)
			{
				if(Character.toLowerCase(c) == secretWord.toLowerCase().charAt(i))
				{
					guessedWord=guessedWord.substring(0, i) + c + guessedWord.substring(i+1);
				}

			}
			System.out.println("Good Guess :");
			if(!guessedWord.contains("-"))
			{
				System.out.println("You have Won\nSecret Word Is: "+ secretWord);
				return secretWord;
			}
		}
		else
		{
			wrongGuesses++;
			System.out.println("Wrong Guess: ");
			if(wrongGuesses >= maxGuesses)
			{
				System.out.println("You have lost\nSecret Word Is: "+ secretWord);
				return null;
			}
			return guessedWord;

		}
		
		return guessedWord;
			
		
		
	}
	public void setMaxWrongGuesses(Integer max){

		if (max != null && max>0)	
		 maxGuesses = max;
		else
			maxGuesses=1;
			
	}
}