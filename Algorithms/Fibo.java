
public class Fibo{

	public static void main(String args[]){
		int number = Integer.parseInt(args[0]);

		// no memoization
		long startTime = System.nanoTime();
		for(int i = 1; i<=number; i++ ){
			System.out.println(solution(i));
		}
		long endTime = System.nanoTime();
		System.out.println("\n Total execution time without memoization :" 
			+ (endTime - startTime) + "\n");



		//with memoization
		int[] cache = new int[number];
		long startTime2 = System.nanoTime();
		for(int i = 1; i<=number; i++ ){
			System.out.println(solution_memoization(i,cache));
		}
		long endTime2 = System.nanoTime();
		System.out.println("\n Total execution time with memoization :" 
			+ (endTime - startTime) + "\n");


		//WTF???!!??!?!?

	}


	public static int solution(int n){

		if(n <= 0){
			return 0; // error code
		}
		if(n == 1){
			return 1;
		}
		return solution(n-2)+solution(n-1);

	}


	public static int solution_memoization(int n, int[] cache){

		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(cache[n-1] == 0){
			cache[n-1] = solution_memoization(n-2,cache)+solution_memoization(n-1,cache);
			return cache[n-1];
		}else{
			return cache[n-1];
		}

	}

}