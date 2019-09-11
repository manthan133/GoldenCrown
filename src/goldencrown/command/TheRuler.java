package goldencrown.command;

import goldencrown.*;

public class TheRuler implements Command
{
    @Override
    public void execute()
    {
        King ruler = getRuler();
        
        if(ruler!=null)
        {
            IOConsole.printString(ruler.toString());
        }
        else
        {
            IOConsole.printString("None");
        }
    }   

    private King getRuler()
    {
        for(String name : GoldenCrown.getKings().keySet())
        {
            King king = GoldenCrown.getKings().get(name);
            
            if(king.rulesSoutheros())
            {
                return king;
            }
        }
        
        return null;
    }
}
