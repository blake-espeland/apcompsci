package chapter14;
import java.util.*;
public class RandomSenctence {
	public static void main(String[] args){
		Random rand = new Random();
		String[] article = {"the" , "a" , "one" , "some" , "any" , "all"};
		String[] noun = {"dicator" , "house" , "gun" , "bomber" , "raid" , "leg"};
		String[] verbs = {"shot" , "take over" , "steal" , "pulverize" , "occupy" , "cut off"};
		String[] preposition = {"to" , "from" , "over" , "under" , "towards" , "at"};
		String[] place = {"Iraq" , "Iowa" , "Canada" , "Ucatan" , "Luxemburg" , "Yeezy"};
		
		for (int i = 0; i <= 20; i++){
			int a = rand.nextInt(6) + 0;
			int b = rand.nextInt(6) + 0;
			int c = rand.nextInt(6) + 0;
			int d = rand.nextInt(6) + 0;
			int e = rand.nextInt(6) + 0;
			String art = article[a];
			String nou = noun[b];
			String ver = verbs[c];
			String pre = preposition[d];
			String pla = place[e];
			System.out.printf("%s %s %s %s %s." , art.substring(0,1).toUpperCase() + art.substring(1 , art.length()).toLowerCase()
					, nou 
					, pre 
					, ver 
					, pla);
			System.out.println();
		}
		
	}
}
