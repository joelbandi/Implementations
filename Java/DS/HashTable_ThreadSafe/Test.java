import java.util.Random;

public class Test {
  Point [] p = new Point[10000];
  Integer [] iarray = new Integer[1000];
  
  void initializeTable() {
    Random r=new Random();
    for (int i=0;i<p.length;i++) {
      int x=r.nextInt(60);
      int y=r.nextInt(60);
      p[i] = new Point(x, y);
    }
    for (int i=0;i<iarray.length;i++) {
      iarray[i]=new Integer(r.nextInt(10000));
    }
  }
    
    
  boolean putOrGet(Random r) {
    //10% puts   90% gets
    return (r.nextInt(1000) > 900);
  }
  
  Point getRandomPoint(Random r) {
    return p[r.nextInt(p.length)];
  }

  Integer getRandomInt(Random r) {
    return iarray[r.nextInt(iarray.length)];
  }
  
  void action(HashTable table) {
    Random r=new Random();
    for(int k = 0; k < 5000000 ; k++) {
      if(putOrGet(r)){
        Point point = getRandomPoint(r);
        Integer i = getRandomInt(r);
        table.put(point, i);
      } else {
        Point point = getRandomPoint(r);
        Integer g =(Integer) table.get(point);
        // System.out.println(g);
      }
    }
  }
  
  public static void main(String...args) {
    Test t =new Test();
    HashTable<Point,Integer> table = new HashTable<Point,Integer>();
    t.initializeTable();
    Thread[] threads=new Thread[4]; // Use 4 Threads
    System.out.println("Running test...Please wait for few minutes");
    long starttime=System.currentTimeMillis();
    
    for(int i=0;i<threads.length;i++) {
      threads[i] = new Thread(new Runnable() {
          public void run(){
            try {
              t.action(table);
            } catch(Exception e){
              e.printStackTrace();
            }
          }
        });
      threads[i].start();
    }
    
    for(int i=0;i<threads.length;i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    long endtime=System.currentTimeMillis();
    System.out.println("Total time in mS: " + (endtime-starttime));
    System.out.println("Total size is: " + table.size());
  }
}