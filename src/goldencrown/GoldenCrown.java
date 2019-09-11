package goldencrown;

import goldencrown.command.*;
import java.util.*;
import java.io.*;

public class GoldenCrown
{
    private static HashMap<String,King> kings;
    private static HashMap<String,Kingdom> kingdoms;
    
    private static final String CONFIG = "configurations/";
    private static final String KINGDOMS_DATA_FILE = CONFIG+"kingdoms.csv";
    private static final String KINGS_DATA_FILE = CONFIG+"kings.csv";
    private static final String COMMANDS_FILE = CONFIG+"commands.txt";
    
    static
    {
        try
        {
            readKings();
            readKingdoms();
        } 
        catch (IOException ex)
        {
            IOConsole.printString(ex.getMessage());
        }
    }
    
    private static void readKings() throws IOException
    {
        kings = new HashMap<>();
        
        try (BufferedReader readCSV = new BufferedReader(new FileReader(KINGS_DATA_FILE))) 
        {
            String king = readCSV.readLine();
            
            while(king != null)
            {
                kings.put(king.toUpperCase(),new King(king));
                king = readCSV.readLine();
            }
        }
    }
    
    private static void readKingdoms() throws IOException
    {
        kingdoms = new HashMap<>();
        
        try (BufferedReader readCSV = new BufferedReader(new FileReader(KINGDOMS_DATA_FILE)))
        {
            String kingdom = readCSV.readLine();
            
            while(kingdom != null)
            {
                StringTokenizer name_emblem = new StringTokenizer(kingdom,",");
                
                String name = name_emblem.nextToken();
                kingdoms.put(name.toUpperCase(),new Kingdom(name, new Emblem(name_emblem.nextToken())));
                
                kingdom = readCSV.readLine();
            }
        }
    }
    
    public static King getKing(String name)
    {
        name = name.toUpperCase();
        
        if(!kings.containsKey(name))
        {
            IOConsole.printString("Invalid king name");
            return null;
        }
        
        return kings.get(name);
    }
    
    public static Kingdom getKingdom(String name)
    {
        name = name.toUpperCase();
        
        if(!kingdoms.containsKey(name))
        {
            IOConsole.printString("Invalid kingdom name");
            return null;
        }
        
        return kingdoms.get(name);
    }
    
    public static HashMap<String,King> getKings()
    {
        return (HashMap<String,King>)kings.clone();
    }
    
    public static void main(String[] args) throws IOException
    {
        try (BufferedReader readCommands = new BufferedReader(new FileReader(COMMANDS_FILE))) 
        {
            String command = readCommands.readLine();
            
            while(command != null)
            {
                IOConsole.printString(""+command);
                command = readCommands.readLine();
            }
            
            IOConsole.printString("");
        }
        
        HashMap<Integer,Command> commands = new HashMap<>();
        
        commands.put(1,new TheRuler());
        commands.put(2,new SendMessage());
        commands.put(3,new GetAllies());
        
        while(true)
        {
            IOConsole.printString("Enter command index: ");
           
            try
            {
                int index = Integer.parseInt(IOConsole.readString());
                commands.get(index).execute();
            }
            catch(NumberFormatException | NullPointerException e)
            {
                IOConsole.printString("Invalid command");
            }
        }
    }
}