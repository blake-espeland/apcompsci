package chapter14;
import java.util.*;
public class PigLatin {
	public String[] word;
	public String end = "ay" , sentence;
	public char first;
	public PigLatin(){
	}
	
	public void convert(){
		word = sentence.split(" ");
		String newSent = "";
		for(String words : word){
			newSent += words.substring(1) + words.substring(0,1) + "ay" + " ";
		}
		System.out.println(newSent);
	}
	
	public void printLatinWord(){
	try{
		System.out.printf("Enter a sentence and I'll convert it to Pig Latin, or enter quit to quit: ");
		do {
			Scanner in = new Scanner(System.in);
			sentence = in.nextLine();
			convert();	
		} while( !sentence.equals ( "quit" ) );
	}catch (Exception e){
		printLatinWord();
	}
		
	}
	
	public static void main(String[] args){
		PigLatin p = new PigLatin();
		p.printLatinWord();
	}
}
