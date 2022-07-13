import java.util.ArrayList;
import java.io.Serializable;

public class Musician implements Serializable
{
    private String givenName;
    private String familyName;
    private ArrayList<Instrument> instruments;
    
    public Musician(String givenName, String familyName, ArrayList<Instrument> instruments)
    {
        this.givenName = givenName;
        this.familyName = familyName;
        this.instruments = instruments;
    }
    
    public void addInstrument(Instrument instrument)
    {
        instruments.add(instrument);
    }

    public ArrayList<Instrument> getInstruments()
    {
     return instruments;
    }
    
    public String toString()
    {        
        return givenName + "," + familyName;
    }
    
    public String saveData()
    {
      return instruments + "]" + givenName + "/" + familyName;
    }
}