
package tests;




public class Tescior {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("starting: " + Thread.currentThread());

        new Thread(() -> {
            synchronized (lock){
                System.out.println("running: " + Thread.currentThread());
            }
        }).start();


        synchronized (lock){
            System.out.println("finishing: " + Thread.currentThread());
        }
    }
}
