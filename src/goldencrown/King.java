package goldencrown;

import java.util.*;

public class King
{
    private HashSet<Kingdom> won;
    private String name;

    private final int MIN_TO_WIN = 3;

    King(String name)
    {
        this.name = name;
        won = new HashSet<>();
    }

    @Override
    public String toString()
    {
        return name;
    }

    public boolean attackKingdom(Kingdom kingdom, String message)
    {
        if(kingdom.sendMessage(message))
        {
            won.add(kingdom);
            return true;
        }

        return false;
    }

    public String getAllies()
    {
        return won.toString();
    }

    public boolean rulesSoutheros()
    {
        return (won.size() >= MIN_TO_WIN);
    }
}