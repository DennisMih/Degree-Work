public class Venue
{
    private String Vname;
    private String address;
    private String manager;
    
    public Venue(String Vname, String address, String manager)
    {
        this.Vname = Vname;
        this.address = address;
        this.manager = manager;
    }
    
    public String toString()
    {
      return Vname + ": " + address + ": " + manager + ": ";
    }
  public String saveData()
    {
    return Vname + ":" + address + ":" + manager + ":";
    }

}

