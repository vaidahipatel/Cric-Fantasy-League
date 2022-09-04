import java.util.Random;
public class Result_holder
{
    Random rand = new Random();
    int score1 = rand.nextInt(101)+100;
    int wickets1 = rand.nextInt(11);
    int score2; int wickets2; int win_runs;
    boolean won1,won2;
    String team1 , team2;

    Result_holder(String s1 , String s2)
    {
        team1 = s1;team2 = s2;
        System.out.print("\n\t\t\t --------------------- First Innings----------------------------");
        System.out.print("\n\t\t\t "+s1+" has scored "+score1+" with a loss of wickets : "+wickets1);
        System.out.print("\n\t\t\t Final Score || "+s1+" : "+score1+"/"+wickets1);

        System.out.print("\n\t\t\t --------------------- Second Innings----------------------------");
        wickets2 = rand.nextInt(11);
        if(wickets2 == 10)
        {
            System.out.print("\n\t\t\t" +s2+" lost all its wickets !!");
            System.out.print("\n\t\t\t "+s1+" won the match !!!");
            won1 = true; win_runs = score1;
        }
        else
        {
            do
            {
                score2 = rand.nextInt(13) + (score1-6);
                if(score1 > score2)
                {
                    System.out.print("\n\t\t\t "+s2+" has scored "+score2+" with a loss of wickets : "+wickets2);
                    System.out.print("\n\t\t\t Final Score || "+s2+" : "+score2+"/"+wickets2);
                    System.out.print("\n\t\t\t "+s1+" won the match !!!\n");
                    won1 = true; win_runs = score1;
                    break;
                }
                else if(score2 > score1)
                {
                    System.out.print("\n\t\t\t "+s2+" has scored "+score2+" with a loss of wickets : "+wickets2);
                    System.out.print("\n\t\t\t Final Score || "+s2+" : "+score2+"/"+wickets2);
                    System.out.print("\n\t\t\t "+s2+"   won the match !!!\n");
                    won2 = true; won1 = false; win_runs = score2;
                    break;
                }
            }while(score1 == score2);
        }

    }
    String winner()
    {
        if(won1)
            return team1;
        else if(won2)
            return team2;
        return null;
    }
    int runWin()
    {
        return win_runs;
    }
}
