import java.util.Arrays;
public class MaximumSumPath{
	public static void main(String[] Args){

		/**
		 * In order to give a new array as an input to this program,
		 * simply change the value to array defined in line 11 to whatever
		 * you want. 
		 */
		

		int[][] array = new int[][]{{12,4,38},{2,10,4},{10,48,10}};


		Packet ans = solution(array);
		ans.print();
	}
	public static Packet solution(int[][] mat){
		String path = "";
		int max;
		if(mat.length!=mat[0].length){
			System.out.println("Not a square matrix");
			return null;
		}
		Packet p = new Packet();
		final int x = mat.length;
		int[][] nmat = mat;
		for(int i = x-1; i >=0 ; i--){
			for(int j = x-1; j >=0 ; j--){
				try{
					nmat[i][j+1]=nmat[i][j+1];
				}catch(ArrayIndexOutOfBoundsException e){
					try{
						nmat[i][j] = nmat[i][j] + nmat[i+1][j];
					}catch(ArrayIndexOutOfBoundsException e1){
						continue;
					}
					continue;
				}
				try{
					nmat[i+1][j]=nmat[i+1][j];
				}catch(ArrayIndexOutOfBoundsException e){
					nmat[i][j] = nmat[i][j] + nmat[i][j+1];
					continue;
				}
				if(nmat[i][j+1] >= nmat[i+1][j] ){
					nmat[i][j] = nmat[i][j]+nmat[i][j+1];
				}else{
					nmat[i][j] = nmat[i][j]+nmat[i+1][j]; 
				}
			}
		}
		max = nmat[0][0];
		int i = 0;
		int j = 0;
		for(int k = 0 ; k<= x; k++){
			try{
				nmat[i][j+1]=nmat[i][j+1];
			}catch(ArrayIndexOutOfBoundsException e){
				path += "↓";
				i++;
				continue;
			}
			try{
				nmat[i+1][j]=nmat[i+1][j];
			}catch(ArrayIndexOutOfBoundsException e){
				path += "→";
				j++;
				continue;
			}
			if(nmat[i][j+1]>=nmat[i+1][j]){
				path += "→";
				j++;
			}else{
				path += "↓";
				i++;
			}
			if(i==x-1 && j==x-1){
				break;
			}
		}
		p.maxValue=max;
		p.path=path;
		return p;
	}
	public static class Packet{
		public int maxValue;
		public String path;

		public void print(){
			System.out.println("value : "+maxValue);
			System.out.println("path  : "+path);
		}
	}
}
	
