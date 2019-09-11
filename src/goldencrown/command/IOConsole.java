package goldencrown.command;

import java.io.PrintWriter;
import java.util.Scanner;

public class IOConsole
{
    private static final Scanner IN;
    private static final PrintWriter OUT;
    
    static
    {
        IN = new Scanner(System.in);
        OUT = new PrintWriter(System.out, true);
    }
    
    public static String readString()
    {
        return IN.nextLine();
    }
    
    public static void printString(String string)
    {
        OUT.println(string);
        OUT.flush();
    }
}
