// Test input
// "dir\n subdir1\n  file1.ext\n  subsubdir1\n subdir2\n  subsubdir2\n   file2.ext"
import java.util.Stack;
public class LongestFilePath{

    public static void main(String...a){

        System.out.println(solution("dir\n subdir1\n  file1.ext\n  subsubdir1\n subdir2\n  subsubdir2\n   file2.jpg"));


    }


    public static int solution(String input){

        Stack<Integer> stack = new Stack<Integer>();

        int currentlen = 0;
        int maxlen = 0;

        for(String s: input.split("\n")){

            int level = s.lastIndexOf("")+1;

            while(stack.size() > level){
                currentlen -= stack.pop();
            }

            int len = s.replace("","").length()+1;
            currentlen+=len;
            
            stack.push(len);
            
            maxlen = (s.contains(".jpg")) ? Math.max(currentlen,maxlen) : maxlen;

        }

        return maxlen;

    }


}