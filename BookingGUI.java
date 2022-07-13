import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class BookingGUI extends JFrame
{
 ArrayList<Instrument> muInstrument = new ArrayList<>();
  
 DefaultComboBoxModel<Instrument> mdlInstrument;
    DefaultComboBoxModel<Musician> mdlMusician;
    DefaultComboBoxModel<Band> mdlBand;
    DefaultComboBoxModel<Venue> mdlVenue;
    DefaultComboBoxModel<Gig> mdlGig;
    
    DefaultListModel<Instrument> mdlInstruments;
    DefaultListModel<Musician> mdlMusicians;
    DefaultListModel<Band> mdlBands;
    DefaultListModel<Venue> mdlVenues;
    DefaultListModel<Gig> mdlGigs;
    
    public BookingGUI()
    {
        mdlInstrument = new DefaultComboBoxModel<Instrument>();
        mdlInstruments = new DefaultListModel<Instrument>();
        
        mdlMusician = new DefaultComboBoxModel<Musician>();
        mdlMusicians = new DefaultListModel<Musician>();
        
        mdlBand = new DefaultComboBoxModel<Band>();
        mdlBands = new DefaultListModel<Band>();
        
        mdlVenue = new DefaultComboBoxModel<Venue>();
        mdlVenues = new DefaultListModel<Venue>();
        
        mdlGig = new DefaultComboBoxModel<Gig>();
        mdlGigs = new DefaultListModel<Gig>();
        
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Add Instrument", new InstrumentPanel());
        tabs.addTab("Add Musician ", new MusicianPanel());
        tabs.addTab("Add Band ", new BandPanel());
        tabs.addTab("Add Venue", new VenuePanel());
        tabs.addTab("Create Gig",new GigPanel());
        tabs.addTab("Display Gigs", new DisplayGigsPanel());
        tabs.addTab("Save Instruments Data", new SaveInstrumentsPanel());
        tabs.addTab("Save Musicians Data", new SaveMusiciansPanel());
        tabs.addTab("Save Bands Data", new SaveBandsPanel());
        tabs.addTab("Save Venues Data", new SaveVenuesPanel());
        tabs.addTab("Save Gigs Data", new SaveGigsPanel());
        add(tabs, BorderLayout.CENTER);
        
      BufferedReader instrumentReader = null;
      BufferedReader musicianReader = null;
      BufferedReader bandReader = null;
      BufferedReader venueReader = null;
      BufferedReader gigsReader = null;
      
         try
        {
            //read the instruments
            instrumentReader = new BufferedReader(new FileReader("instruments.txt"));
            String in = null;
            while((in = instrumentReader.readLine())!= null)
            {
                String[] tokens = in.split(":");
               Instrument i = new Instrument(tokens[0]);
                mdlInstrument.addElement(i);
            }
         }
        catch(Exception ex)
        {
            
        }
        finally
        {
            
        }
        
        try
          
        {
          //read the musicians
          musicianReader = new BufferedReader(new FileReader("musicians.txt"));
          String mu = null;
            while ((mu = musicianReader.readLine()) != null)
            {
                Instrument inst = null;
                Musician mus = null;
                String[] instruments = mu.split("]");
                ArrayList<Instrument> ints = new ArrayList<Instrument>();
                String [] name = mu.split("/");
                if (instruments.length > 1)
                {
                    inst = new Instrument(instruments[0]);
                    ints.add(inst);
                    Musician m = new Musician(name[0],name[1],ints);
                     mdlMusician.addElement(m);
                }             
        }
        }
        catch(Exception e)
        {
          
        }
        finally
        {
        }
        
     try
        {
          //read the bands
          bandReader = new BufferedReader(new FileReader("bands.txt"));
          String bd = null;
            while ((bd = bandReader.readLine()) != null)
            {
                Instrument inst = null;
                Musician mus = null;
                Band bnd = null;
                String[] instruments = bd.split("]");
                ArrayList<Instrument> ints = new ArrayList<Instrument>();
                String[] musicians = bd.split("]");
                ArrayList<Musician> bms = new ArrayList<Musician>();
                String [] mName = bd.split(":");
                String [] bName = bd.split(":");
                if (musicians.length > 1)
                {
                    inst = new Instrument(instruments[0]);
                    ints.add(inst);
                    mus = new Musician(mName[0],mName[1],ints);
                    bms.add(mus);
                    Band b = new Band(bName[0],bName[1],(Integer.parseInt(bName[2])),bms);
                    mdlBand.addElement(b);
                }             
        }
        }
        catch(Exception e)
        {
          
        }
        finally
        {
        }
    
       try
        {
            //read the venues
            venueReader = new BufferedReader(new FileReader("venues.txt"));
            String ven = null;
            while((ven=venueReader.readLine())!= null)
            {
                String[] vtokens = ven.split(":");
               Venue v = new Venue(vtokens[0],vtokens[1],vtokens[2]);
                mdlVenue.addElement(v);
            }
         }
        catch(Exception ex)
        {
            
        }
        finally
        {
            
        }
        
        try
        {
          //read the gigs
          gigsReader = new BufferedReader(new FileReader("gigs.txt"));
          String gi = null;
            while((gi = gigsReader.readLine())!= null)
            {
                Instrument inst = null;
                Musician mus = null;
                Band bnd = null;
                String[] instruments = gi.split("]");
                ArrayList<Instrument> ints = new ArrayList<Instrument>();
                String[] musicians = gi.split("]");
                ArrayList<Musician> bms = new ArrayList<Musician>();
                String [] mName = gi.split(":");
                String [] bName = gi.split(":");
                String[] vtokens = gi.split(":"); 
                if (musicians.length > 1)
                {
                    inst = new Instrument(instruments[0]);
                    ints.add(inst);
                    mus = new Musician(mName[0],mName[1],ints);
                    bms.add(mus);
                    Band b = new Band(bName[0],bName[1],(Integer.parseInt(bName[2])),bms);
                    Venue v = new Venue(vtokens[0],vtokens[1],vtokens[2]);
                    Gig g = new Gig(b,v,vtokens[2]);
                    mdlGigs.addElement(g);
                    
                }              
            }
        }
        catch(Exception e)
        {
          
        }
        finally
        {
        }
        
        setBounds(300, 100, 400, 600);
        setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        new BookingGUI();
    }
    
    class InstrumentPanel extends JPanel
    {
        JLabel lblIntName;
        JTextField txtIntName;
        JButton btnAdd;
        
        public InstrumentPanel()
        {
            lblIntName = new JLabel("Instrument Name: ");
            txtIntName = new JTextField(30);
            btnAdd = new JButton("Add Instrument");
            btnAdd.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
               {
                    String name = txtIntName.getText();
                    mdlInstrument.addElement(new Instrument(name));
                    txtIntName.setText("");
                }
            }
            );
            add(lblIntName);
            add(txtIntName);
            add(btnAdd);
        }
     }
    
    class MusicianPanel extends JPanel
    {   
        JList<Instrument> jltInstrument;
        
        JLabel lblGName, lblFName;
        JTextField txtGName, txtFName;
        JButton btnAdd;
        
        public MusicianPanel()
        { 
            jltInstrument = new JList<Instrument>(mdlInstrument);
            add(jltInstrument);
            lblGName = new JLabel("Given Name: ");
            lblFName = new JLabel("Family Name: ");
            txtGName = new JTextField(30);
            txtFName = new JTextField(30);
            btnAdd = new JButton("Add Musician");
            btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              if(e.getSource() == btnAdd){
            String GName = txtGName.getText();
            String FName = txtFName.getText();
             java.util.List<Instrument> selectedInstrument = jltInstrument.getSelectedValuesList();
             ArrayList<Instrument> instruments = new ArrayList<Instrument>();
             for(Instrument i: selectedInstrument)
              {
                    instruments.add(i);
             }
             mdlMusician.addElement(new Musician(GName, FName, instruments));
                    txtGName.setText("");
                    txtFName.setText("");
                }
            }
            });
            
            add(lblGName);
            add(txtGName);
            add(lblFName);
            add(txtFName);
            add(btnAdd);
        }
    }
        
    class BandPanel extends JPanel
    {   
        JList<Musician> jltMusician;
        
        JLabel lblBName, lblStyle, lblFee;
        JTextField txtBName, txtStyle, txtFee;
        JButton btnAdd;
       
        public BandPanel()
        {
            jltMusician = new JList<Musician>(mdlMusician);
            add(jltMusician);
            lblBName = new JLabel("Band Name: ");
            lblStyle = new JLabel("Band Style: ");
            lblFee = new JLabel("Fee: ");
            txtBName = new JTextField(30);
            txtStyle = new JTextField(30);
            txtFee = new JTextField(8);
            btnAdd = new JButton("Add Band");
            btnAdd.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
               {
                
              if(e.getSource() == btnAdd){
                    String bName = txtBName.getText();
                    String style = txtStyle.getText();
                    int fee = Integer.parseInt(txtFee.getText());
                    
                    java.util.List<Musician> selectedMusician = jltMusician.getSelectedValuesList();
                ArrayList<Musician> musicians = new ArrayList<Musician>();
                for(Musician m: selectedMusician)
                {
                    musicians.add(m);
                }
                    
                    
                    mdlBand.addElement(new Band(bName, style, fee, musicians));
                    txtBName.setText("");
                    txtStyle.setText("");
                    txtFee.setText("");
              }}
       });
            add(lblBName);
            add(txtBName);
            add(lblStyle);
            add(txtStyle);
            add(lblFee);
            add(txtFee);
            add(btnAdd);
        }
    }
        
      class VenuePanel extends JPanel
    {   
        JLabel lblVName, lblAddress, lblManager;
        JTextField txtVName, txtAddress, txtManager;
        JButton btnAdd;
        
        public VenuePanel()
        {
            lblVName = new JLabel("Venue Name: ");
            lblAddress = new JLabel("Address Name: ");
            lblManager = new JLabel("Manager: ");
            txtVName = new JTextField(30);
            txtAddress = new JTextField(30);
            txtManager = new JTextField(30);
            btnAdd = new JButton("Add Venue");
            btnAdd.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e)
                {
                    String VName = txtVName.getText();
                    String Address = txtAddress.getText();
                    String Manager = txtManager.getText();
                    mdlVenue.addElement(new Venue(VName, Address, Manager));
                    txtVName.setText("");
                    txtAddress.setText("");
                    txtManager.setText("");
                }
            }
          );
            
            add(lblVName);
            add(txtVName);
            add(lblAddress);
            add(txtAddress);
            add(lblManager);
            add(txtManager);
            add(btnAdd);
        }
      }
    
      
        class GigPanel extends JPanel
    {
        JComboBox<Band> cbxBand;
        JComboBox<Venue> cbxVenue;
        
        JLabel lblGDate;
        JTextField txtGDate;
        JButton btnAdd;
        
        public GigPanel()
        {
            cbxBand = new JComboBox<Band>(mdlBand);
            add(cbxBand);
            
            cbxVenue = new JComboBox<Venue>(mdlVenue);
            add(cbxVenue);
            
            
            lblGDate = new JLabel("Gig Date: ");
            txtGDate = new JTextField(30);
            btnAdd = new JButton("Add Gig");
            btnAdd.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
               {
                    String date = txtGDate.getText();
                    txtGDate.setText("");
                    
                     //finds the selected band and venue
                Band band = (Band)cbxBand.getSelectedItem();
                Venue venue = (Venue)cbxVenue.getSelectedItem();
    
                //adds the gig
                mdlGigs.addElement(new Gig(band, venue, date));
        }
            });
         
            add(lblGDate);
            add(txtGDate);
            add(btnAdd);
        }
    }

   class DisplayGigsPanel extends JPanel
 {
     JButton btnList;
        JTextArea display;
        
        public DisplayGigsPanel()
        {
            btnList = new JButton("Show Gigs");
            btnList.addActionListener(
               new ActionListener()
               {
                  public void actionPerformed(ActionEvent e)
                  {
                    display.setText("");
                  
                    {
                        display.append(mdlGigs.toString() + "\n");
                    }
                  }
                }
            );
            display = new JTextArea(10, 50);
            JScrollPane scroller = new JScrollPane(display);
            
            add(btnList);
            add(scroller);
        }
}

                                      
    
class SaveInstrumentsPanel extends JPanel
    {
        public SaveInstrumentsPanel()
        {
            JButton btnSave = new JButton("Save Instruments Data");
            add(btnSave);
            btnSave.addActionListener(new ButtonHandler());
                
        }
        
        class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                PrintWriter instrumentWriter = null;
                try
                {
                    instrumentWriter = new PrintWriter("instruments.txt");
                     for(int i=0;i<mdlInstrument.getSize();i++)
                    {
                        instrumentWriter.println(mdlInstrument.getElementAt(i).saveData());
                    }
                    instrumentWriter.flush();  
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if(instrumentWriter != null)
                        instrumentWriter.close();
                }

        }
   }
}

class SaveMusiciansPanel extends JPanel
    {
        public SaveMusiciansPanel()
        {
            JButton btnSave = new JButton("Save Musicians Data");
            add(btnSave);
            btnSave.addActionListener(new ButtonHandler());
                
        }
        
        class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                PrintWriter musiciansWriter = null;
                try
                {
                    musiciansWriter = new PrintWriter("musicians.txt");
                     for(int i=0;i<mdlMusician.getSize();i++)
                    {
                        musiciansWriter.println(mdlMusician.getElementAt(i).saveData());
                    }
                    musiciansWriter.flush();  
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if(musiciansWriter != null)
                       musiciansWriter.close();
                }

        }
   }
}

class SaveBandsPanel extends JPanel
    {
        public SaveBandsPanel()
        {
            JButton btnSave = new JButton("Save Bands Data");
            add(btnSave);
            btnSave.addActionListener(new ButtonHandler());
                
        }
        
        class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                PrintWriter bandWriter = null;
                try
                {
                    bandWriter = new PrintWriter("bands.txt");
                     for(int i=0;i<mdlBand.getSize();i++)
                    {
                        bandWriter.println(mdlBand.getElementAt(i).saveData());
                    }
                    bandWriter.flush();
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if(bandWriter != null)
                        bandWriter.close();
                }
            }
        }
   }

class SaveVenuesPanel extends JPanel
    {
        public SaveVenuesPanel()
        {
            JButton btnSave = new JButton("Save Venues Data");
            add(btnSave);
            btnSave.addActionListener(new ButtonHandler());
                
        }
        
        class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                PrintWriter venueWriter = null;
                try
                {
                    venueWriter = new PrintWriter("venues.txt");
                     for(int i=0;i<mdlVenue.getSize();i++)
                    {
                        venueWriter.println(mdlVenue.getElementAt(i).saveData());
                    }
                   venueWriter.flush();
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if(venueWriter != null)
                        venueWriter.close();
                }
            }
        }
   }



class SaveGigsPanel extends JPanel
    {
        public SaveGigsPanel()
        {
            JButton btnSave = new JButton("Save Gigs Data");
            add(btnSave);
            btnSave.addActionListener(new ButtonHandler());
                
        }
        
        class ButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                PrintWriter gigsWriter = null;
                try
                {
                    gigsWriter = new PrintWriter("gigs.txt");
                     for(int i=0;i<mdlGigs.getSize();i++)
                    {
                        gigsWriter.println(mdlGigs.getElementAt(i).saveData());
                    }
                    gigsWriter.flush();  
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if(gigsWriter != null)
                        gigsWriter.close();
                }

                }
            }
        }
}





