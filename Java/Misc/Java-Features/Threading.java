public class Threading {
    public static void main(String[] args) {

        Thread one = new Action();
        one.start();
        //this will spin up a new thread into existence


        while(true){
            System.out.println("main thread");
            try {
                    Thread.sleep(500);
                }
                catch (Exception err) {
                    System.out.println(err.getMessage());
                }
        }

    }


    public static class Action extends Thread {


        @Override
        public void run(){


            while(true){
                System.out.println("\t\n--- Action thread ---\n");
                try {
                    Thread.sleep(1000);
                }
                catch (Exception err) {
                    System.out.println(err.getMessage());
                }
            }

        }
    }

    public static class Task implements Runnable{

       @Override
        public void run(){


            while(true){
                System.out.println("\t\n--- Action thread ---\n");
                try {
                    Thread.sleep(1000);
                }
                catch (Exception err) {
                    System.out.println(err.getMessage());
                }
            }

        }

    }

}