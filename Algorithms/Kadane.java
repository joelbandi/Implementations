import java.util.Arrays;
public class Kadane{
	public static void main(String[] Args){
		int[] array = new int[]{1,2,-8,-4,8,2,5,-25,6,8,-7};
		solution(array);
	}

	public static void solution(int[] array){
		int bestEver = 0;
		int bestTail = 0;
		int bestHead = 0;
		int currentHead = 0;
		int currentSum = 0;
		for (int i = 0; i< array.length; i++){
			currentSum += array[i];
			if(currentSum <= 0){
				currentSum = 0;
				currentHead = i;
			}else if(currentSum >= bestEver){
				bestEver = currentSum;
				bestTail = i;
				bestHead = currentHead;
			}
		}
		System.out.println("Best sum is : "+ bestEver);
		System.out.print("Maximum subarray is: ");
		for(int i = bestHead+1; i<= bestTail ; i++){
			System.out.print(array[i]+"  ");
		}
		System.out.println();
	}
}