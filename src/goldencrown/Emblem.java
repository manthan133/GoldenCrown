package goldencrown;

import java.util.*;

class Emblem
{
    private HashMap<Character,Integer> emblem;

    Emblem(String name)
    {
        emblem = getEmblem(name.toUpperCase());
    }

    HashMap<Character,Integer> getEmblem(String message)
    {
        HashMap<Character,Integer> emblem = new HashMap<Character,Integer>();

        for(int i=0;i<message.length();i++)
        {
            emblem.put(message.charAt(i), emblem.getOrDefault(message.charAt(i),0)+1);
        }

        return emblem;
    }
	
    boolean matchEmblem(String message)
    {
        HashMap<Character,Integer> match = getEmblem(message.toUpperCase());

        for(char c : emblem.keySet()) 
        {
            if(emblem.get(c) > match.getOrDefault(c, 0))
            {
                return false;
            }
        }

        return true;
    }
}