package chapter18;
import java.util.*;
public class Backward {
	
	private void stringReverse(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter something and I'll say it backwards: ");
		String s = in.nextLine();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++){
			System.out.printf("%s" , array[(array.length - 1) - i]);
		}
	}
	
	public static void main(String[] args){
		Backward b = new Backward();
		b.stringReverse();
	}
}
