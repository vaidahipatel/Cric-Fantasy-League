public class TeamStats
{
    public String name;
    public int totalmatch;
    public int wins;
    public float points;
    
    public void details(String name, int wins,int match)
    {
        this.name = name;
        this.wins = wins;
		totalmatch = match;
        this.points = (wins*100f)/totalmatch;
    }
    public void display()
    {
        System.out.print("\n\t\t\t "+name+"\t\t\t"+totalmatch+"\t\t"+wins+"\t\t "+points);
    }
}
