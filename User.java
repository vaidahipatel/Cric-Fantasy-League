import java.util.Comparator;
import java.util.Scanner;
public class User
{
    public int uid,age,runs_predict;
	
    public String password,name,team_predict;
    public double points;
    public User()
    {
        uid=age=runs_predict=0;
        points=500;
    }
    public User(int id)
    {
        uid=id;
        age=0;
        points=500;
    }
    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\n\t\t\t User id = "+uid);
        System.out.print("\n\t\t\t Enter name of the user : ");
        name=sc.nextLine();
        System.out.print("\n\t\t\t Create password : ");
        password=sc.nextLine();
        System.out.print("\n\t\t\t Enter your age : ");
        age=sc.nextInt();
        System.out.print("\n\t\t\t Points = "+points);
    }
    void displayUser()
    {
        System.out.print("\n\t\t\t User id = "+uid);
        System.out.print("\n\t\t\t Name of the user = "+name);
        System.out.print("\n\t\t\t Age = "+age);
        System.out.print("\n\t\t\t Points = "+points+"\n");
    }
}
class sortByUid implements Comparator<User>
{
    public int compare(User u1,User u2)
    {
        return u1.uid-u2.uid;
    }
}
class sortWinner implements Comparator<User>
{
    public int compare(User u1,User u2)
    {
        if(u1.runs_predict==9999 && u2.runs_predict==9999)
            return 0;
        else if(u1.runs_predict==9999)
            return 1;
        else if(u2.runs_predict==9999)
            return -1;
        else
            return u1.runs_predict- u2.runs_predict;
    }
}
