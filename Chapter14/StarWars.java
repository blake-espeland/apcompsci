package chapter14;

import java.util.Scanner;
import java.util.*;
public class StarWars {
	public static void main(String[] args){
		String fName , lName , mName , born , car , medic;
		try{
			Scanner in = new Scanner(System.in);
		
		System.out.printf("%nFollow my directions you must, Star Wars name you will find.");
		
		System.out.printf("%nFirst name you must enter: ");
		fName = in.next();
		
		System.out.printf("%nLast name you must enter: ");
		lName = in.next();
		
		System.out.printf("%nPlace of birth you must enter: ");
		born = in.next();
		
		System.out.printf("%nMaiden name of your mother you must enter: ");
		mName = in.next();
		
		System.out.printf("%nFirst car you must enter: ");
		car = in.next();
		
		System.out.printf("%nLast medication you must enter: ");
		medic = in.next();
		
		String f = fName.substring(0 , 3);
		String l = lName.substring(0 , 2);
		String b = born.substring(0 , 3);
		String m = mName.substring(0 , 2);
		String last = lName.substring(lName.length() - 3 , lName.length());
		byte[] yeet = last.getBytes();
		byte[] yuh = new byte [yeet.length];
		for (int i = 0; i < yeet.length; i ++){
			yuh[i] = yeet[yeet.length - i - 1];
		}
		System.out.printf("Star Wars Name: %n%s%s %s%s" 
				, f.substring(0,1).toUpperCase() + f.substring(1 , f.length()).toLowerCase()
				, l.toLowerCase() 
				, m.substring(0,1).toUpperCase() + m.substring(1 , m.length()).toLowerCase() 
				, b.toLowerCase());
		System.out.printf("%nStar Wars Honorable Title: %n%s%s of %s"
				, new String(yuh).substring(0 , 1).toUpperCase() + new String(yuh).substring(1 , new String(yuh).length()).toLowerCase()
				, car.toLowerCase()
				, medic.substring(0 , 1).toUpperCase() + medic.substring(1).toLowerCase());
		}catch(Exception e){
			System.out.printf("%nThere was a Disturbance in the Force.");
			main(args);
		}
		
		
	}
}
