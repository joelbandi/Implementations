public class HashTable<K,V> {

    /**
     * FEATURES:
     * 1. collision proof. It uses chaining manage collisions in namespace.
     * 2. Also resizable when a lot of elements are being stored into the table and all slots are filled
     * 3. Concurrent and Thread Data structure
     * 
     * */


    private Entry<K,V>[] table;
    private static int TABLE_SIZE = 256;
    private int occupied; // For use in later versions (load factor)

    public class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next; // For use later for chaining purposes
        Entry(K key,V value){
            this.key=key;
            this.value=value;
            this.next = null;
        }
    }

    HashTable(){
        this.table = new Entry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;
        }
        this.occupied = 0;
    }

    public synchronized V get(K key){
        int hash = key.hashCode() % TABLE_SIZE;
        if(table[hash] != null){

            Entry<K,V> e = table[hash];
            while(e.next != null){
                if(e.key.equals(key)){
                    return e.value;
                }else{
                    e=e.next;
                }
            }


            if(table[hash].key.equals(key)){
                return table[hash].value;
            }else{
                return null;
            }


        }else{
            return null;
        }
    }

    public synchronized void put(K key,V value){
        int hash = key.hashCode() % TABLE_SIZE;
        if(table[hash] == null){
            table[hash] = new Entry<K,V>(key,value);
        }else{
            Entry<K,V> e = table[hash];
            while(e.next!=null){
                e = e.next;
            }
            e.next = new Entry<K,V>(key,value);
        }
    }

    public int size(){
        return TABLE_SIZE;
    }
}