import java.util.Stack;
import java.util.ArrayList;
public class Plates<T>{

    private class Container<E>{
        private Stack < E > stack;
        private int limit;
        private int plateCount;

        Container(int limit) {
            stack = new Stack <E> ();
            this.limit = limit;
            this.plateCount = 0;
        }

        public boolean isFull() {
            return this.plateCount >= this.limit;
        }

        public boolean isEmpty() {
            return this.plateCount == 0;
        }

        public boolean push(E plate) {
            if (!this.isFull()) {
                this.stack.push(plate);
                this.plateCount++;
                return true;
            } else {
                return false;
            }
        }

        public E pop() {
            if (!this.isEmpty()) {
                this.plateCount--;
                return this.stack.pop();
            } else {
                return null;
            }
        }

        public E peek() {
            if (!this.isEmpty()) {
                return this.stack.peek();
            }
            return null;
        }
    }

    private ArrayList < Container > arraylist;
    private int containerLimit;
    private int containerCount;

    Plates(int containerLimit) {
        this.arraylist = new ArrayList < Container > ();
        this.containerLimit = containerLimit;
    }

    public boolean push(T element) {
        if (this.arraylist.size() == 0) {
            this.containerCount = 0;
            this.arraylist.add(new Container < T > (this.containerLimit));
            this.arraylist.get(this.containerCount).push(element);
            return true;
        }

        if (this.arraylist.get(this.containerCount).push(element)) {
            return true;
        }else{
            this.arraylist.add(new Container<T>(this.containerLimit));
            this.containerCount++;
            if(this.arraylist.get(this.containerCount).push(element)){
                return true;
            }
        }
        return false;
    }


    public T pop(){
        if(this.containerCount >= 0){
            T element = (T)this.arraylist.get(this.containerCount).pop();
            if(this.arraylist.get(this.containerCount).isEmpty()){
                this.containerCount--;
            }
            return element;
        }else{
            return null;
        }
    }

    public T peek(){
        if(this.containerCount >= 0){
            return (T)this.arraylist.get(this.containerCount).peek();
        }else{
            return null;
        }
    }

    public int length(){
        return this.containerCount;
    }

    public int depth(){
        return this.containerLimit;
    }

    public T select(int container){
        System.out.println("Select Call has been made");
    }
}