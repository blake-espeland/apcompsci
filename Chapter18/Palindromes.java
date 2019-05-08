package chapter18;
import java.util.*;
public class Palindromes {
private String[] word;
private String sent , newSent = "";

private boolean testPalindrome(){
	if (sent.equals(newSent)){
		return true;
	}else
		return false;
}

private void enter(){
	System.out.println("Enter something and Imma see if it's a palindrome: ");
	Scanner in = new Scanner(System.in);
	sent = in.nextLine();
	sent = sent.replaceAll("\\s", "");
	sent = sent.replaceAll("\\W", "");
		for (int i = 0; i <= sent.length(); i++){
			if (i == 0){
				newSent += sent.substring(sent.length());
			}else{
				newSent += sent.substring(sent.length() - i , (sent.length() - i) + 1);
				System.out.println(newSent);
			}	
		}
	}


public static void main(String[] args){
	Palindromes p = new Palindromes();
	p.enter();
	if (p.testPalindrome()){
		System.out.printf("You have entered a palindrome!");
	}else
		System.out.printf("You have not entered a palindrome.");
}
}
