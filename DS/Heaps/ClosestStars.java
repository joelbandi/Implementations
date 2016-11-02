import java.io.*;
import java.util.*;
public class ClosestStars{

    public static void main(String...args){

        Comparator<Star> sc = new StarComparator();
        PriorityQueue<Star> queue = new PriorityQueue<Star>(3, sc);

        try{

            FileReader fileReader = new FileReader("star.list");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                    String[] linearray = line.split("\t");
                    queue.add(new Star(Integer.parseInt(linearray[0]),Integer.parseInt(linearray[1]),Integer.parseInt(linearray[2])));
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        int count= 0;
        while (queue.size() != 0 && count < 10)
        {
            System.out.println(queue.remove());
            count++;
        }



    }


    public static class Star{
        int x;
        int y;
        int z;
        double dist;
        Star(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
            dist = Math.sqrt((x*x)+(y*y)+(z*z));
        }

        public String toString(){
            return x+" "+y+" "+z;
        }
    }

    public static class StarComparator implements Comparator<Star>{

        @Override
        public int compare(Star a,Star b){
            if(a.dist > b.dist){
                return 1;
            }else if (a.dist<b.dist){
                return -1;
            }

            return 0;
        }

    }


}