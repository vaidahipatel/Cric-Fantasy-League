import java.beans.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
public class CFL
{
    int win_run;
    String win_team;
    String[] Tcode = new String[8];
    final String[] stad = new String[5];
    String[] opt = {"bat","ball"};
    int t1,t2,batball;
    boolean teamsel;
    CFL()
    {
        Tcode[0] = "CSK";
        Tcode[1] = "MI";
        Tcode[2] = "SRH";
        Tcode[3] = "DC";
        Tcode[4] = "DD";
        Tcode[5] = "KXIIP";
        Tcode[6] = "RCB";
        Tcode[7] = "KKR";
        stad[0] = "Dubai";
        stad[1] = "Lords";
        stad[2] = "Wankhede";
        stad[3] = "Berlin";
        stad[4] = "Sardar Patel";
    }
    void displayWelcome()
    {
        System.out.print("\n\n\n\n\n");
        System.out.print("\n\t\t\t  **-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**");
        System.out.print("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("\n\t\t\t        =                 WELCOME                   =");
        System.out.print("\n\t\t\t        =                    TO                     =");
        System.out.print("\n\t\t\t        =                                           =");
        System.out.print("\n\t\t\t        =             CRICKET  FANTASY              =");
        System.out.print("\n\t\t\t        =                  LEAGUE                   =");
        System.out.print("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("\n\t\t\t  **-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**-**\n");
    }
    void displayPointTable()
    {
        System.out.println("\n\t\t\t                          POINTS TABLE ");
        System.out.println("\n\t\t\t Name            Total Matches         Wins            Points");
        System.out.println("\n\t\t\t ------------------------------------------------------------------ ");
        try
        {
            XMLDecoder y =new XMLDecoder(new BufferedInputStream(new FileInputStream("team.xml")));
            TeamStats[] c;
            c = (TeamStats[]) y.readObject();
            y.close();
            for(int i = 0; i<c.length;i++)
            {
                c[i].display();
            }
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
    }
    void setMatch()
    {
        Random rand = new Random();
        t1 = rand.nextInt(8);  //t1 for team 1
        t2 = rand.nextInt(8);   //t2 for team 2
        while(t1==t2)
        {
            t2 = rand.nextInt(8);
        }

        System.out.println("\n\n\n\n");
        System.out.print("\n\t\t\t Today's Match : "+Tcode[t1]+ " Vs "+Tcode[t2]);

        int s1 = rand.nextInt(5);
        System.out.println("\n\t\t\t  It is a sunny morning day on the grounds of "+stad[s1]+" International Cricket stadium");

        String[] toss = {"Heads","Tails"};
        System.out.print("\n\t\t\t Empire is all set to flip the coin ");
        int callfortoss = rand.nextInt(2);
        batball = rand.nextInt(2);

        System.out.print("\n\t\t\t "+toss[callfortoss]+" is the call for "+Tcode[t1]);
        if(toss[callfortoss].equals(toss[rand.nextInt(2)]))
        {
            System.out.print("\n\t\t\t "+Tcode[t1]+" won the toss and choose to "+opt[batball]);
            teamsel = true;
        }
        else
        {
            System.out.println("\n\t\t\t "+Tcode[t2]+" won the toss and choose to "+opt[batball]);
            teamsel = false;
        }

        System.out.print("\n\n\n\n\n");
        System.out.println("\n\t\t\t Lets see who wins this one.");
        System.out.println("\n\t\t\t Betting amount for this match is Rs.50 ");
        // Prize details to be written
        /*
        If you win, Rs 2,000 is all yours and will be transferred to your account
        1st winner will get Rs 2,000
        2nd winner will get Rs 1,000
        3rd winner will get Rs 500
        Let’s test your Luck
         */

    }
    int displayUserMenu()
    {
        Scanner sc=new Scanner(System.in);
        int choice=4;
        System.out.print("\n\t\t\t Press Enter to continue.");
        sc.nextLine();
        System.out.print("\n\t\t\t How would you like to proceed : ");
        System.out.print("\n\t\t\t 1.New User");
        System.out.print("\n\t\t\t 2.Old User");
        System.out.print("\n\t\t\t 3.Start the game");
        System.out.print("\n\t\t\t 4.Exit");
        System.out.print("\n\t\t\t   Enter your choice : ");
        choice=sc.nextInt();
        return choice;
    }
    int displayMenu()
    {
        Scanner sc=new Scanner(System.in);
        int choice=2;
        System.out.print("\n\t\t\t Press Enter to continue.");
        sc.nextLine();
        System.out.print("\n\t\t\t How you want to proceed : ");
        System.out.print("\n\t\t\t 1.Play again");
        System.out.print("\n\t\t\t 2.Exit");
        System.out.print("\n\t\t\t Enter your choice : ");
        choice=sc.nextInt();
        return choice;
    }
    void predict(User u)
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.print("\n\t\t\t Predict winning team : "+Tcode[t1]+" Vs "+Tcode[t2]);
            System.out.print("\n\t\t\t "+t1+"."+Tcode[t1]);
            System.out.print("\n\t\t\t "+t2+"."+Tcode[t2]);
            System.out.print("\n\t\t\t Enter your choice : ");
            int i=sc.nextInt();
            if(i==t1 || i==t2)
            {
                u.team_predict= Tcode[i];
                break;
            }
            System.out.println("\n\t\t\t Invalid choice!!");
        }
        while(true)
        {
            System.out.print("\n\t\t\t Predict winning team runs : ");
            int i=sc.nextInt();
            if(i>=0)
            {
                u.runs_predict=i;
                break;
            }
            System.out.println("\n\t\t\t Runs can't be negative!!");
        }
    }
    User newUser()
    {
        try
        {
            XMLDecoder y = new XMLDecoder(new BufferedInputStream(new FileInputStream("users.xml")));
            ArrayList<User> lst=new ArrayList<>();
            User a;
            try
            {
                while(true)
                {
                    a = (User) y.readObject();
                    lst.add(a);
                }
            }
            catch (ArrayIndexOutOfBoundsException ignored) {}
            y.close();
            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("users.xml")));
            for(int i=0;i<lst.size();i++)
            {
                x.writeObject(lst.get(i));
            }

            User u = new User(lst.size()+1);
            u.input();
            predict(u);
            x.writeObject(u);
            x.close();
            return u;
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
        return null;
    }
    User oldUser()
    {
        try
        {
            Scanner sc= new Scanner(System.in);
            System.out.print("\n\t\t\t Enter your user id : ");
            int uid = sc.nextInt();
            XMLDecoder y = new XMLDecoder(new BufferedInputStream(new FileInputStream("users.xml")));
            User u=null;
            try
            {
                do
                {
                    u = (User) y.readObject();
                }while(u.uid!=uid);
            }
            catch (ArrayIndexOutOfBoundsException ignored) {}
            y.close();
            if(u==null || u.uid!=uid)
            {
                System.out.println("\n\t\t\t No record found.");
                return null;
            }
            sc.nextLine();
            System.out.print("\n\t\t\t Enter your password : ");
            String p = sc.nextLine();
            if(p.equals(u.password))
            {
                u.displayUser();
                predict(u);
                return u;
            }
            else
            {
                System.out.println("\n\t\t\t Incorrect Password!!");
                return null;
            }
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
        return null;
    }
    void playGame()
    {
        TeamStats[] c = new TeamStats[8];
        try
        {
            XMLDecoder y =new XMLDecoder(new BufferedInputStream(new FileInputStream("team.xml")));
            c = (TeamStats[]) y.readObject();
            y.close();
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
        c[t2].totalmatch = c[t2].totalmatch + 1;
        c[t1].totalmatch = c[t1].totalmatch + 1;

        System.out.print("\n\n");
        if(opt[batball].equals("bat"))
        {
            if(teamsel)
            {
                Result_holder rh = new Result_holder(Tcode[t1],Tcode[t2]);
                if((rh.winner()).equals(Tcode[t1]))
                {
                    c[t1].wins = c[t1].wins + 1;
                    c[t1].points = (c[t1].wins*100f)/c[t1].totalmatch;
                }
                else if((rh.winner()).equals(Tcode[t2]))
                {
                    c[t2].wins = c[t2].wins + 1;
                    c[t2].points = (c[t2].wins*100f)/c[t2].totalmatch;
                }
			win_run = rh.runWin();
	        win_team = rh.winner();
            }
            else
            {
                Result_holder rh = new Result_holder(Tcode[t2],Tcode[t1]);
                if((rh.winner()).equals(Tcode[t2]))
                {
                    c[t2].wins = c[t2].wins + 1;
                }
                else if((rh.winner()).equals(Tcode[t1]))
                {
                    c[t1].wins = c[t1].wins + 1;
                }
		        win_run = rh.runWin();
	            win_team = rh.winner();
            }
        }
        else if(opt[batball].equals("ball"))
        {
            if(teamsel)
            {
                Result_holder rh = new Result_holder(Tcode[t2],Tcode[t1]);
                if((rh.winner()).equals(Tcode[t2]))
                {
                    c[t2].wins = c[t2].wins + 1;
                }
                else if((rh.winner()).equals(Tcode[t1]))
                {
					c[t1].wins = c[t1].wins + 1;
				}
                win_run = rh.runWin();
				win_team = rh.winner();

            }
            else
            {
                Result_holder rh = new Result_holder(Tcode[t1],Tcode[t2]);
                if((rh.winner()).equals(Tcode[t1]))
                {
                    c[t1].wins = c[t1].wins + 1;
                }
                else if((rh.winner()).equals(Tcode[t2]))
                {
                    c[t2].wins = c[t2].wins + 1;
                }
                win_run = rh.runWin();
				win_team = rh.winner();
            }
			c[t1].points = (c[t1].wins*100f)/c[t1].totalmatch;
			c[t2].points = (c[t2].wins*100f)/c[t2].totalmatch;
        }
        try
        {
            XMLEncoder new1 = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("team.xml")));
            new1.writeObject(c);
            new1.close();
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
    }
    void updateUser(ArrayList<User> lst)
    {
        try
        {
            XMLDecoder y = new XMLDecoder(new BufferedInputStream(new FileInputStream("users.xml")));
            ArrayList<User> l = new ArrayList<>();
            User a;
            try
            {
                while (true)
                {
                    a = (User) y.readObject();
                    l.add(a);
                }
            }
            catch (ArrayIndexOutOfBoundsException ignored) {}
            y.close();

			int j = 0;
			for(int i = 0;i<l.size();i++)
			{
				if(l.get(i).uid == lst.get(j).uid)
				{
					l.get(i).uid = lst.get(j).uid;
					l.get(i).points = lst.get(j).points;
					l.get(i).name = lst.get(j).name;
					l.get(i).team_predict = lst.get(j).team_predict;
					l.get(i).age = lst.get(j).age;
					l.get(i).password = lst.get(j).password;
					l.get(i).runs_predict = lst.get(j).runs_predict;
				    j++;
				}
			}


            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("users.xml")));
            for (int i = 0; i < l.size(); i++)
            {
                x.writeObject(l /*.get(i).uid*/);
            }
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
    }

    void result(ArrayList<User> lst)
    {
		int total_ded=0;
		ArrayList<Integer> winners=new ArrayList<>();


        for(int i=0;i<lst.size();i++)
        {
            if(win_team.equalsIgnoreCase(lst.get(i).team_predict))
            {
                lst.get(i).runs_predict = Math.abs(lst.get(i).runs_predict - win_run);
                winners.add(i);
            }
            else
            {
                lst.get(i).runs_predict  = 9999;
				total_ded = total_ded + 50;
                lst.get(i).points = lst.get(i).points  - 50;
            }
        }


	    if(winners.size() == 0)
		{
			System.out.println("\n\t\t\t No winner for the game !!");
		}
	    else if(winners.size() == 1)
		{
            lst.get(winners.get(0)).points+=total_ded;
		}
		else if(winners.size() == 2)
		{
            int min_index;
            if(lst.get(winners.get(0)).runs_predict<lst.get(winners.get(1)).runs_predict)
                min_index=0;
            else
                min_index=1;
            lst.get(winners.get(min_index)).points+=(total_ded*3)/5.0;
            lst.get(winners.get(Math.abs(min_index-1))).points+=(total_ded*2)/5.0;
		}
		else
		{
            lst.sort(new sortWinner());
            lst.get(0).points+=(total_ded *5)/9.0;
            lst.get(1).points+=(total_ded *3)/9.0;
            lst.get(2).points+=(total_ded)/9.0;
		}
        System.out.println("\n\t\t\t Participants : ");
		for(User u:lst)
        {
            u.displayUser();
        }
         System.out.print("\n\n\n\n\n");
         System.out.print("\n\t\t\t                           LEADERBOARD");
		 System.out.print("\n\n");
		 System.out.print("\n\t\t\t  ID  |     Name    |    Team bet    |      points \n");
		 System.out.print("\n\t\t\t ---------------------------------------------------------------");


		 // Display Leaderboard
		 for(User u:lst)
		 {
		 System.out.print("\n\t\t\t  "+u.uid+"\t   "+u.name+" \t "+u.team_predict+"\t\t   "+u.points);
		 }

	     lst.sort(new sortByUid());
        //Update User File
         updateUser(lst);
    }

    public static void main(String[] args)
    {
        while(true)
        {
            CFL ob = new CFL();
            ob.displayWelcome();
            ob.displayPointTable();
            ob.setMatch();

            ArrayList<User> lst = new ArrayList<>();
            int choice = 0;
            while(choice!=3)
            {
                User u;
                choice = ob.displayUserMenu();
                switch (choice)
                {
                    case 1:
                        u=ob.newUser();
                        if(u!=null)
                            lst.add(u);
                        break;
                    case 2:
                        u=ob.oldUser();
                        if(u!=null)
                            lst.add(u);
                        break;
                    case 3:
                        // To do: Checking if user entered the contest or left
                        ob.playGame();
                        break;
                    case 4:
                        System.out.println("\n\t\t\t Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("\n\t\t\t Invalid choice!!\n\t\t\t Please try again.");
                }
            }
            lst.sort(new sortByUid());
            ob.result(lst);
            choice=0;
            while(choice!=1)
            {
                choice = ob.displayMenu();
                switch (choice)
                {
                    case 1:
                        break;
                    case 2:
                        System.out.println("\n\t\t\t Thanks for playing Cric Fantasy League.");
                        System.exit(0);
                    default:
                        System.out.println("\n\t\t\t Invalid choice!!\n\t\t\t Please try again.");
                }
            }
        }
    }
}
