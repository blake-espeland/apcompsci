package chapter19;
import java.math.*;
import java.util.Random;
public class BubbleSort {
	
	private void aye(int array[] , int n){
		
		for (int i = 0; i < n - 1; i++){
			boolean change = false;
			for (int j = 0; j < n - i - 1; j++){
				
				if (array[j] > array[j+1]){
					
					int temp = array[j];
					array[j] = array[j+1];
					array[j + 1] = temp;
					change = true;
					
					}

			if (change = false){
				break;
			}
			
			
			}
			}
		
	}
	
	private void print(int array[] , int i){
		System.out.printf("%nSorted array: %n");
		System.out.printf("{ ");
		for (int k = 0; k < array.length; k++){
			System.out.printf("%d " , array[k]);
			}
		System.out.println("}");
	}
		
	
	

	public static void main(String[] args){
		BubbleSort b = new BubbleSort();
		Random r = new Random();
		
		int array[] = new int[10];
		int n = array.length;
		int i = 0;
		System.out.println("Original Array: ");
		System.out.printf("{ ");
		for (int k = 0; k < n; k++){
			int rand = r.nextInt(100) + 1;
			array[k] = rand;
			System.out.printf("%d " , array[k]);
		}
		System.out.printf("}");
		b.aye(array, n);
		b.print(array , i);
		}
	}

