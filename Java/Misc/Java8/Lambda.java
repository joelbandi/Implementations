import java.util.List;
import java.util.Arrays;
public class Lambda{

    public static void main(String[] args){
    
    	List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    
    	//read how to implement a callback type of pattern using interfaces first
    	// read Callbacks.java src code first and then try to understand how 
    	// an anonymous function can be passed instead of an 
    	//anonymnous class - > functional composition pattern instead of
    	//object composition pattern


    	list.forEach((Integer data) -> 
    		System.out.println(data));



    	for(Integer i : list){
    		System.out.println(i);
    	}
    
    }
}