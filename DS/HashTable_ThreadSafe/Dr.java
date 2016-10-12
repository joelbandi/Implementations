public class Dr {
    public static void main(String[] args) {
        HashTable<Point,String> ht = new HashTable<Point,String>();
        ht.put(new Point(1,2),"Hello X World");
        System.out.println(ht.get(new Point(1,2)));
        System.out.println(ht.size());
    }
}