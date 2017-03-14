//Tower of Hanoi

class Hanoi {

	public static void main(String... args){


		solution(7,"SRC","AUX","DST");




	}

	public static void solution(int disc,String src,String aux,String dst){
		if(disc>0){
			

			solution(disc-1,src,dst,aux);

			System.out.println("move disc "+ disc + " from "+ src + " to " + dst);

			solution(disc-1,aux,src,dst);

		}

	}

//recursive ftw...


}