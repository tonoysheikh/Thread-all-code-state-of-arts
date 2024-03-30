
package su.threadcode;

public class secondType implements Runnable{
    public static void main(String[] args) {
        secondType sc = new secondType();
        Thread td = new Thread(sc);
        td.start();
    }
    @Override
    public void run()
    {
        System.out.println("I am runnable thread.");
    }
    
 
}
