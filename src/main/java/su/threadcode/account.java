
package su.threadcode;


public class account {
    double init_balance = 0.0;
    void deposit(double amt)
    {
        init_balance += amt;
        System.out.println("Your Current Balance " + init_balance);
    }
    void withdraw(double amt)
    {
        if(amt < init_balance)
        {
            init_balance -= amt;
            System.out.println("Your Current Balance " + init_balance);
        }
        else
        {
            System.out.println("Your have not enough balance.");
        }
        
    }
    public static void main(String[] args) {
        account ac = new account();
        
        Thread dth1 = new Thread(() -> ac.deposit(50.0));
        Thread dth2 = new Thread(() -> ac.deposit(50.0));
        
        dth1.start();
        dth2.start();
    }
 
}
