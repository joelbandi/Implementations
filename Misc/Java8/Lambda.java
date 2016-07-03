import java.util.List;
import java.util.Arrays;
public class Lambda{


    public static void main(String[] args){


    	List<Integer> list = Arrays.asList(1,2,3,4,5,6);


    	list.forEach((Integer data) -> 

    		System.out.println(data));


    }


}