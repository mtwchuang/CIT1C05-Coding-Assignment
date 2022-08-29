import java.util.Random;

public class FindIt 
{
    public int[] insertNumbers()
    {
        Random rand = new Random();
        int array[] = new int[10];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(1,11);
        }
        return array;
    }
    public void computePattern()
    {
        int input[] = insertNumbers();
        int patterncount = 0;
        for(int i = 0; i < 10;i+=2)
        {
            if(input[i]+input[i+1]>7) {patterncount++;}
        }
        System.out.print("Array: ");
        for(int i = 0; i < 10; i++)
        {
            System.out.print(input[i]+" ");
        }
        System.out.println("\nNumber of patterns: "+patterncount);
    }
    public static void main(String[] args)
    {
        FindIt t1 = new FindIt();
        t1.computePattern();
    }
}
