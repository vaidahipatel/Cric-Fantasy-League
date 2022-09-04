import java.beans.*;
import java.io.*;
import java.util.Scanner;

public class TstatDefault
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        TeamStats ob1[] = new TeamStats[8];
        for(int i = 0; i<ob1.length;i++)
        {
            ob1[i] = new TeamStats();
        }

        ob1[0].details("CSK",11,14);
        ob1[1].details("MI",10,14);
        ob1[2].details("SRH",10,14);
        ob1[3].details("DC",9,14);
        ob1[4].details("DD",8,14);
        ob1[5].details("KXIIP",8,14);
        ob1[6].details("RCB",7,14);
        ob1[7].details("KKR",6,14);

        try
        {
            XMLEncoder x=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("team.xml")));
            x.writeObject(ob1);
            x.close();

            XMLDecoder y =new XMLDecoder(new BufferedInputStream(new FileInputStream("team.xml")));
            TeamStats c[];
            c = (TeamStats[]) y.readObject();
         for(int i = 0; i<ob1.length;i++)
         {
            c[i].display();
         }

        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: File not found");
        }
    }

}
