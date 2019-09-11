package goldencrown.command;

import goldencrown.*;

public class GetAllies implements Command
{
    @Override
    public void execute() 
    {
        IOConsole.printString("Enter the king's name: ");
        King king = GoldenCrown.getKing(IOConsole.readString());
        
        if(king!=null)
        {
            /*king.getAllies().forEach((kingdom)-> 
            {
                IOConsole.printString(kingdom+" ");
            });*/
            IOConsole.printString(king.getAllies());
        }
    }
}
