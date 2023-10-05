import java.util.Random;

public class Quest 
{
    Random rand = new Random();
    // parent method to initialise board for game
    public void initialiseGameBoard()
    {
        // initalise entire board to E
        char board[][] = new char[20][20];
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                board[i][j] = 'E';
            }
        }
        // insertion of resources, threads and potion
        board = insertResources(board);
        board = insertThreats(board);
        int potionPost[] = generateEmptyPosition(board);
        board[potionPost[0]][potionPost[1]] = 'P';
        // checking
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    // child method of initialiseGameBoard, inserts resources
    public char[][] insertResources(char board[][])
    {
        int foodcount = 10;
        int weaponcount = 10;
        int healthcount = 10;
        int choice = 0;
        for(int i = 0; i < 30; i++)
        {
            int tempPost[] = generateEmptyPosition(board);
            while(true)
            {
                choice = rand.nextInt(1,4);
                if(choice==1 && foodcount!=0)
                {
                    foodcount--;
                    board[tempPost[0]][tempPost[1]]='F';
                    break;
                }
                if(choice==2 && weaponcount!=0)
                {
                    weaponcount--;
                    board[tempPost[0]][tempPost[1]]='W';
                    break;
                }
                if(choice==3 && healthcount!=0)
                {
                    healthcount--;
                    board[tempPost[0]][tempPost[1]]='H';
                    break;
                }
            }
        }
        return board;
    }

    // child method of initialiseGameBoard, insert threads
    public char[][] insertThreats(char board[][])
    {
        int giantcount = 5;
        int ssandcount = 5;
        int ktreecount = 10;
        int crittercount = 10;
        int choice = 0;
        for(int i = 0; i < 30; i++)
        {
            int tempPost[] = generateEmptyPosition(board);
            while(true)
            {
                choice = rand.nextInt(1,5);
                if(choice==1 && giantcount!=0)
                {
                    giantcount--;
                    board[tempPost[0]][tempPost[1]]='G';
                    break;
                }
                if(choice==2 && ssandcount!=0)
                {
                    ssandcount--;
                    board[tempPost[0]][tempPost[1]]='S';
                    break;
                }
                if(choice==3 && ktreecount!=0)
                {
                    ktreecount--;
                    board[tempPost[0]][tempPost[1]]='K';
                    break;
                }
                if(choice==4 && crittercount!=0)
                {
                    crittercount--;
                    board[tempPost[0]][tempPost[1]]='C';
                    break;
                }
            }
        }
        return board;
    }
    
    // modular method to generate empty board position
    public int[] generateEmptyPosition(char[][] board)
    {
        while(true)
        {
            int position[] = {rand.nextInt(0,20), rand.nextInt(0,20)};
            if(board[position[0]][position[1]]=='E')
            {
                return position;
            }
        }
    }

    public void checkForResult(char board[][])
    {
        int resourceleft = 0; int foodleft = 0; int weaponleft = 0; int healthleft = 0; 
        int threatleft = 0; int giantleft=0; int ssandleft = 0; int ktreeleft = 0; int critterleft = 0;
        boolean win = true;
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                switch(board[i][j])
                {
                    case 'F':
                        foodleft++;
                        resourceleft++;
                        break;
                    case 'W':
                        weaponleft++;
                        resourceleft++;
                        break;
                    case 'H':
                        healthleft++;
                        resourceleft++;
                        break;
                    case 'P':
                        win = false;
                        break;
                    case 'G':
                        giantleft++;
                        threatleft++;
                        break;
                    case 'S':
                        ssandleft++;
                        threatleft++;
                        break;
                    case 'K':
                        ktreeleft++;
                        threatleft++;
                        break;
                    case 'C':
                        critterleft++;
                        threatleft++;
                        break;
                }
            }
        }
        System.out.println("Total Resource Uncovered: "+(30-resourceleft));
        System.out.println("Food: "+(10-foodleft)+"\nWeapon: "+(10-weaponleft)+"\nHealth: "+(10-healthleft));
        System.out.println("Total threats encountered: "+(30-threatleft));
        System.out.println("Giants: "+(5-giantleft)+"\nSinking Sand: "+(5-ssandleft)+"\nKilling Tree: "+(10-ktreeleft)+"\nCritters: "+(10-critterleft));
    }
    

    // method to update health when encountering health or dealing with threats
    public int updateHealth(int currHealth, char boardLetter)
    {
        switch(boardLetter)
        {
            case 'G':
                System.out.println("Giant encountered, health reduced to zero");
                currHealth = 0;
            case 'S':
                System.out.println("Sinking sand encountered, health reduced by 3");
                currHealth-=3;
            case 'K':
                System.out.println("Killer tree encountered, health reduced by 5");
                currHealth-=5;
            case 'C':
                System.out.println("Critter encountered, health reduced by 5");
                currHealth-=5;
            case 'H':
                System.out.println("Health uncovered, health increased by 10");
                currHealth+=10;
        }
        return currHealth;
    }

    // method to update health when encountering food
    public int updateHealth(int currHealth, int position[], char board[][])
    {
        int healthincrease = 5;
        int xcoord = position[0];
        int ycoord = position[1];
        char adjacentLetters[] = {board[xcoord-1][ycoord+1], board[xcoord][ycoord+1], board[xcoord+1][ycoord+1],
            board[xcoord-1][ycoord], board[xcoord][ycoord], board[xcoord+1][ycoord],
            board[xcoord-1][ycoord-1], board[xcoord][ycoord-1], board[xcoord+1][ycoord-1]};
        for(int i = 0; i < adjacentLetters.length; i++)
        {
            switch(adjacentLetters[i])
            {
                case 'G':
                    healthincrease-=999;
                case 'S':
                    healthincrease-=3;
                case 'K':
                    healthincrease-=5;
                case 'C':
                    healthincrease-=5;
            }
        }
        if(healthincrease > 0)
        {
            System.out.println("Food encountered, health increased by "+healthincrease);
            return currHealth+healthincrease;
        }
        else
        {
            System.out.println("Food encountered, but too many threats, no health increase");
            return currHealth;
        }
    }

    public void makeAMove()
    {
        
    }

    public static void main(String[] args)
    {
        Quest q1 = new Quest();
        q1.initialiseGameBoard();
    }
}
