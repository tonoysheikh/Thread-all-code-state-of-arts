
package su.threadcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bankaccount {
    private double initial_balance;
    private Lock lock;
    
    bankaccount()
    {
        initial_balance = 0.0;
        lock = new ReentrantLock();
    }
    
    void deposit(double amt)
    {
        lock.lock();
        try{
            System.out.println("Your deposit amount "+amt);
            initial_balance += amt;
            System.out.println("your current balance "+initial_balance);
        }
        finally
        {
           lock.unlock();
        }
    }
    
    void withdraw(double amt)
    {
        lock.lock();
        try{
            if(initial_balance > amt)
            {
                System.out.println("Your withdraw amount "+amt);
                initial_balance -= amt;
                System.out.println("Your current balance "+initial_balance);
            }
            else
            {
                System.out.println("You have not enough balance.");
            }
        }
        finally{
            lock.unlock();
        }
        
    }
    public static void main(String[] args) {
        bankaccount ba = new bankaccount();
        
        Thread dth1 = new Thread(() -> ba.deposit(50.0));
        Thread dth2 = new Thread(() -> ba.deposit(200.0));
        Thread wth1 = new Thread(() -> ba.withdraw(50.0));
        
        dth1.start();
        dth2.start();
        wth1.start();
    }
 
}
