import java.util.Scanner;

public class ObserveThePeople 
{
    public void observeThePeople()
    {
        Scanner sc = new Scanner(System.in);
        int input = 0; int single = 0; int couple = 0; int familysize3 = 0;
        for(int i = 1; i < 6; i++)
        {
            System.out.print("Enter group #"+i+":");
            input=sc.nextInt();
            switch(input)
            {
                case 1:
                    single++;
                    break;
                case 2:
                    couple++;
                    break;
                case 3:
                    familysize3++;
                    break;
            }
        }
        sc.close();
        System.out.println("Statistics\n"+single+" Singles\n"+couple+" Couples\n"+familysize3+" Families");
    }
    public static void main(String[] args)
    {
        ObserveThePeople t1 = new ObserveThePeople();
        t1.observeThePeople();
    }
}
