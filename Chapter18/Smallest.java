package chapter18;
import java.util.*;
public class Smallest {
	
	private void recursiveMinimum(){
		int i = 0;
		Scanner in = new Scanner(System.in);
		int ent , lowest = 1000000000;
		int yeet[] = new int[10];
		System.out.println("How many numbers do you want to enter?: ");
		int max = in.nextInt();
		for (i = 0; i < max; i++){
			System.out.printf("Enter number %d: " , i + 1);
			ent = in.nextInt();
			yeet[i] = ent;
		}
		
		for (i = 0; i < yeet.length; i++){
			if (lowest > yeet[i]){
				lowest = yeet[i];
			}
		}
		System.out.println("Smallest number: " + lowest);
	}
	public static void main(String[] args){
		Smallest s = new Smallest();
		try{
			s.recursiveMinimum();
		}catch(Exception e){
			s.recursiveMinimum();
		}
		
	}
}
