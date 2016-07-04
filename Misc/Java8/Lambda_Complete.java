import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda_Complete {

    /** Let's try to figure the functional programming magic added to java 8 and all its functional
     * programming specific syntaxes , programming paradigms and patterns , lambda expressions and finally
     * java.util.function package while exploring interfaces , abstract classes , runnables and consumers.
     * Also touching upon the topic of anonymous methods (method reference)  and classes (object reference)
     * All of these are related so let us map them together...
     */



    public static void main(String[] args) {
        System.out.println("Hello World!!");

        /** Firstly, what is a lambda expression exactly and how do we write it?
         *  a lambda expression looks like the following syntax '(parameters) -> do something;'
         *  Upon closer investigation youll notice that ... a lambda expression is like a method except
         *  it does not require a return type and even a name (It's anonymous)
         *  you don't even have to  use 'new' keyword or even have block braces if only one statement
         */

        // an example :

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        list.forEach(
                (Integer value) -> System.out.println("Lambda exp:  the number in the list was : " + value)
        );


        /** See and notice how we passed a weird looking statement as an argument to the forEach method of out list
         * That means the forEach method must have some runnable like artifact defined as its argument when it was declared defined
         * And that is called a Consumer. It's a functional interface (a special kind of interface) and it was written as a part of Java 8 functional programming front
         * under a package called java.util.function.
         *
         * To understand functional interface we must also know about SAM
         * Single Abstract Method interfaces (SAM Interfaces) is not a new concept.
         * It means interfaces with only one single method.
         * In java, we already have many examples of such SAM interfaces.
         * From java 8, they will also be referred as functional interfaces as well.
         * Java 8, enforces the rule of single responsibility by
         * marking these interfaces with a new annotation i.e. @FunctionalInterface.
         *
         *
         *
         *
         * To be frank, The above code can also be written with normal syntax using 'new' keyword and passing the object
         * reference to the forEach method
         */

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Object reference: the number in the list is  :" + integer);
            }
        });


        /**
         * The consumer is a functional interface predefined and declared in java8 that runs whatever is given to it in the 'accept' method
         * which has to be overriden anyway as it is an abstract method in the functional interface.(all methods are abstract by default in the abstract class)
         */


        /** This is the age of the impatient young programmer who wants to type less and do more and java developers saw all the
         * unnecessary code we have to write in the case of the object reference passing and have desinged a more simpler and
         * faster way to write these out ..i.e using lambda expressions.  They are just syntactic sugar to ease in the functional
         * programming users like javascripters or scala users into an more OOP like design.
         *
         * The accept methid and the default 'andThen' method in consumer functional interface translates object reference style code into
         * a lambda expression styled code..
         *
         */


        /** another such functional interface is a runnable and
         * its equivalent method to 'accept' is 'run'
         * and it is generally used for asynchronous programming paradigms
         */


        /**
         * Lambda expressions always automatically infers the context from its lexical
         * position in the code and acts accordingly
         *
         */



        /** Let us now understand how to write a simple method equivalent (but slightly modified) to 'forEach' which actually take in consumer like interfaces
         * in the form of lambda expressions or object references as arguments.
         *
         *
         * We need to first declare a functional interface class
         * and then pass that as the argument while declaring and defining our forEach method
         *
         * Firstly we will use pre written SAMinterface or a functional interfaces like Runnable and then consumer
         * and then we will try and build one ourselves
         *
         */


        // a small example of runnables and run methods

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Obj Reference: Hello World from a runnable");
            }
        }).start();


        // Above same as

        new Thread(  ()-> System.out.println("Lambda : Hellow world from a runnable")  ).start();


        forEach_Consumer(list, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("forEach_Consumer, reference: the number in list is :" + integer);
            }
        });
        forEach_Consumer(list, (Integer i ) -> System.out.println("forEach_Consumer, lambda exp: the number in list is :" + i));

        forEach_Doodad(list, new Doodad<Integer>() {
            @Override
            public void absorb(Integer integer) {
                System.out.println("forEach_Doodad, reference: the number in list is :" + integer);
            }
        });


        forEach_Doodad(list, (Integer integer) -> System.out.println("forEach_Doodad, lambda exp: the number in list is :" + integer));


    }




    static void forEach_Consumer(List<Integer> list, Consumer<Integer> consumer){

        for (Integer i : list){

            // the lambda expression gets the variable passed to the accept method

            consumer.accept(i);
        }

    }


    static void forEach_Doodad(List<Integer> list, Doodad<Integer> doodad){

        for(Integer i : list){

            doodad.absorb(i);

        }

    }


    /** our own version of the the SAM interface/ functional interface
     *  we will name it doodad (idk..) and the single method as absorb.
     */
    @FunctionalInterface
    interface Doodad<T>{

        void absorb(T t);

    }










}

