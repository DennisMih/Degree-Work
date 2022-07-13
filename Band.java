import java.util.ArrayList;

public class Band
{
    private String Bname;
    private String style;
    private int fee;
    private ArrayList<Musician> musicians;
    
    public Band(String Bname, String style, int fee, ArrayList<Musician> musicians)
    {
        this.Bname = Bname;
        this.style = style;
        this.fee = fee;
       this.musicians = musicians;
    }
    
    public void addMusician(Musician musician)
    {
        musicians.add(musician);
    }
    
    public void removeMusician(Musician musician)
    {
      musicians.remove(musician);
    }
    
      public ArrayList<Musician> getMusician()
    {
     return musicians;
    }
    
    public String toString()
    {
        return musicians + Bname + style + fee;
    }
    
    public String saveData()
    {
        return musicians + "]" + Bname + ":" + style + ":" + fee + ":";
    }
  }