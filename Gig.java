import java.util.GregorianCalendar;

public class Gig
{
    private Band band;
    private Venue venue;
    private String date;
    
    public Gig(Band band, Venue venue, String date)
    {
        this.band = band;
        this.venue = venue;
        this.date = date;
    }
    
    public String toString()
    {
        return "\n" + band + "\n"  + venue + "\n" + "Plays On: " + date;
    }
    
    public String saveData()
    {
        return band + "]]"  + venue + ":" + date + ":";
    }
}