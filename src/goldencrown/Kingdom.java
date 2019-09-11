package goldencrown;

public class Kingdom
{
    private String name;
    private Emblem emblem;

    Kingdom(String name,Emblem emblem)
    {
        this.name = name;
        this.emblem = emblem;
    }

    @Override
    public String toString()
    {
        return name;
    }

    boolean sendMessage(String message)
    {
        return emblem.matchEmblem(message);
    }
}