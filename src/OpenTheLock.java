import java.util.Random;
public class OpenTheLock 
{
    Random rand = new Random();
    public void openTheLock()
    {
        int lock[] = {rand.nextInt(10,45), rand.nextInt(10,45), rand.nextInt(10,45)};
        int attempt[] = {rand.nextInt(5,45), rand.nextInt(5,45), rand.nextInt(5,45)};
        boolean valid = true;
        for(int i = 0; i < lock.length; i++)
        {
            System.out.println("Lock number "+i+" is : "+lock[i]+"\nAttempt number "+i+"  is: "+attempt[i]);
            if(lock[i]!=attempt[i])
            {
                valid = false;
                break;
            }
        }
        if(valid==true) {System.out.println("Lock opens!");}
        else{System.out.println("Invalid combination!");}
    }
    public static void main(String[] args)
    {
        OpenTheLock t1 = new OpenTheLock();
        t1.openTheLock();
    }
}
