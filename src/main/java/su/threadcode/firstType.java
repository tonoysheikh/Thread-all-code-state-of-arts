
package su.threadcode;


public class firstType extends Thread{
    public static void main(String[] args) {
        firstType th = new firstType();
        th.start();   
    }
    
    @Override
    public void run()
    {
          System.out.println("I am extends Thread");  
    }
}
