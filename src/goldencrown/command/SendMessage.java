package goldencrown.command;

import goldencrown.*;

public class SendMessage implements Command
{
    @Override
    public void execute()
    {
        IOConsole.printString("Enter the king's name: ");
        King king = GoldenCrown.getKing(IOConsole.readString());
        
        if(king != null)
        {
            IOConsole.printString("Enter the kingdom's name: ");
            Kingdom kingdom = GoldenCrown.getKingdom(IOConsole.readString());

            if(kingdom!=null)
            {
               IOConsole.printString("Enter the message: ");
               king.attackKingdom(kingdom, IOConsole.readString());
               IOConsole.printString("Message sent successfully");
            }
        }
    }
}
