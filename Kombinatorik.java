import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;






public class Kombinatorik extends JPanel {
    private JButton jcomp1;
    private JCheckBox jcomp2;
    private JComboBox jcomp3;
    private JLabel jcomp4;
    private JMenuBar jcomp5;
    private JFileChooser jcomp6;
    private JTextField jcomp7;
    private static JDialog d; 
    private JLabel jcomp8;
    
    static int test = 0;
    static int test2 = 0;
    static boolean ce = false;
    static boolean ae = false;
    public Kombinatorik() {
        //construct preComponents
        String[] jcomp3Items = {"A", "B", "C"};
        JMenu fileMenu = new JMenu ("Datei");
        
        JMenuItem exitItem = new JMenuItem ("Beenden");
        fileMenu.add (exitItem);
        JMenu helpMenu = new JMenu ("Hilfe");
      
        JMenuItem aboutItem = new JMenuItem ("Info");
        helpMenu.add (aboutItem);

        //construct components
        jcomp1 = new JButton ("Berechnen");
        jcomp2 = new JCheckBox ("Ausgeben?");
        jcomp3 = new JComboBox (jcomp3Items);
        jcomp6 = new JFileChooser ();
        jcomp4 = new JLabel ("Option");
        jcomp5 = new JMenuBar();
        jcomp5.add (fileMenu);
        jcomp5.add (helpMenu);
        jcomp7 = new JTextField (5);
        jcomp7.setVisible(false);
     
        setPreferredSize (new Dimension (210, 150));
        setLayout (null);
        exitItem.addMouseListener(new MouseListener() {
       	 @Override
       	  public void mouseClicked(MouseEvent e) {
       	    // action here
       		
       	  }

       	  @Override
       	  public void mousePressed(MouseEvent e) {
       		System.exit(0);
       	  }

       	  @Override
       	  public void mouseReleased(MouseEvent e) {
       	  }

       	  @Override
       	  public void mouseEntered(MouseEvent e) {
       	  }

       	  @Override
       	  public void mouseExited(MouseEvent e) {
       	  }
       	});;
        aboutItem.addMouseListener(new MouseListener() {
        	 @Override
        	  public void mouseClicked(MouseEvent e) {
        	    // action here
        		
        	  }

        	  @Override
        	  public void mousePressed(MouseEvent e) {
        		  createFrame();
        	  }

        	  @Override
        	  public void mouseReleased(MouseEvent e) {
        	  }

        	  @Override
        	  public void mouseEntered(MouseEvent e) {
        	  }

        	  @Override
        	  public void mouseExited(MouseEvent e) {
        	  }
        	});;
    

        
        
        jcomp1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
               

                 Character[] großklein = new Character[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                         'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                         'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

                 Character[] sonderzeichen = new Character[] { '§', '$', '%', '&', '?', '+', '#', '!' };
                 Character[] sonderzeichenextra = new Character[] { '§', '$', '%', '&', '?', '+', '#', '!', '-', ';', ':' };
             	
					FileWriter schreiber;
					
				try {
				     
				    	  
				       
				
                 int zähler = 0;
                 List<List<Character>> lists = new ArrayList<List<Character>>();
                 List<String> result = new ArrayList<String>();
                 
                 Kombinatorik item1 = new Kombinatorik();
                 String pfad = "log";
            	if(jcomp2.isSelected()) {
            		
                    
            	 jcomp6.setDialogTitle("Wählen Sie ein Textdokument aus.");   
                 int userSelection = jcomp6.showSaveDialog(jcomp6);
                 
                 if (userSelection == JFileChooser.APPROVE_OPTION) {
                     File fileToSave = jcomp6.getSelectedFile();
                     System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                     String testt = fileToSave.getAbsolutePath();
                     pfad = testt;
              
                 }  
                 
            	} 
             	
            	schreiber = new FileWriter(pfad);
            	File file
                = new File(System.getenv("USERNAME"));
            	file.delete();
            	
                 String x = String.valueOf(jcomp3.getSelectedItem());
            	
                 if(x == "A") {
                	 {
                		 ce=false;
                		 ae=true;

                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichen));
                         item1.generatePermutations(lists, result, 0, "");
                         test2++;
                        
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(sonderzeichen), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                      
                         test2++;
                         lists = Arrays.asList(Arrays.asList(sonderzeichen), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
              
                         for (String str : result) {
                        	 if(jcomp2.isSelected()) {
                             schreiber.write(str + System.lineSeparator());
                        	 }
                         }
                         zähler = (result.size());
                         test2 = 0;
                         jcomp7.setVisible(true);
                     
                         jcomp7.setText(zähler + "");
                         } 
                	 schreiber.close();
                	 
                 } else if(x == "B") {
                	 {
                		 ce=false;
                		 ae=false;

                		 lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         lists = Arrays.asList(Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                    	 zähler = (result.size() * 5);
                    
                         jcomp7.setVisible(true);
                       
                         jcomp7.setText(zähler + "");
                         } 
                	 schreiber.close();
                	 
                 } else if(x == "C") {
                	 {
                         ce=true;
                         ae=false;

                		 lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(sonderzeichenextra));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                       
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++; //######
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(sonderzeichenextra), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                         lists = Arrays.asList(Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         result.clear();
                         test++;
                        
                         lists = Arrays.asList(Arrays.asList(sonderzeichenextra), Arrays.asList(großklein), Arrays.asList(großklein), Arrays.asList(sonderzeichenextra), Arrays.asList(großklein));
                         item1.generatePermutations(lists, result, 0, "");
                         for (String str : result) {
                        	 if(jcomp2.isSelected())
                             schreiber.write(str + System.lineSeparator());
                         }
                         
                    	 zähler = (result.size() * 10);
                    	
                         jcomp7.setVisible(true);
                         jcomp7.setText(zähler + "");
                         } 
                	 	test = 0;
                	 
                 }
                 
                 
            
            	
             	 schreiber.close();
            	
            	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
            	
            }
        });
        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
    
        add (jcomp7);
       
       
        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (5, 90, 190, 20);
        jcomp2.setBounds (110, 60, 100, 25);
        jcomp3.setBounds (5, 60, 100, 25);
        jcomp4.setBounds (5, 30, 100, 25);
        jcomp5.setBounds (0, 0, 495, 30);
        jcomp7.setBounds (5, 115, 190, 25);

        jcomp7.setEditable(false);
   
      
      
    }
 
	
    void generatePermutations(List<List<Character>> lists, List<String> result, int depth, String current) {
    	
        if (depth == lists.size()) {
        	
        	if(ce == false || test == 0 && current.charAt(3) != current.charAt(4) || test == 1 && current.charAt(2) != current.charAt(4) || test == 2 && current.charAt(1) != current.charAt(4) || test == 3 && current.charAt(0) != current.charAt(4)|| test == 4 && current.charAt(1) != current.charAt(2)|| test == 5 && current.charAt(2) != current.charAt(3)|| test == 6 && current.charAt(0) != current.charAt(1)|| test == 7 && current.charAt(1) != current.charAt(3)|| test == 8 && current.charAt(0) != current.charAt(2)|| test == 9 && current.charAt(0) != current.charAt(3)) {
        		if(ae == false || test2 == 0 && current.charAt(0) != current.charAt(1) || test2 == 1 && current.charAt(0) != current.charAt(2) || test2 == 2 && current.charAt(1) != current.charAt(2)) {
        		result.add(current);
        		}
        	}
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
        
    }
    public static void createFrame()
    {
    	
    	JFrame f= new JFrame();  
        d = new JDialog(f , "Info", true);  
        d.setLayout( new FlowLayout() );  
        
        JButton b = new JButton ("OK");  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
               d.setVisible(false);  
            }  
        });  
        d.add( new JLabel ("<html><center>Kombinatorik - Passwörter</center><br/>© Tim Joswig, Ismail Olgun, Roman Kempf<br/>Dieses Programm wurde im Rahmen eines<br/>Hochschul-Projektes entwickelt und dient<br/>der Berechnung von Passwort-Kombinationen.<br/><br/>Option A:<br/>3-STELLIGES PASSWORT<br/>2 GROß- UND/ODER KLEINBUCHSTABEN<br/>(DÜRFEN NUR EINMAL VORKOMMEN)<br/>1 SONDERZEICHEN (§,$,%,&,?,+,#,!)<br/><br/>Option B:<br/>5-STELLIGES PASSWORT<br/>4 GROß- UND/ODER KLEINBUCHSTABEN<br/>(DÜRFEN AUCH MEHRFACH VORKOMMEN)<br/>1 SONDERZEICHEN (§,$,%,&,?,+,#,!,-,;,:)<br/><br/>Option C:<br/>5-STELLIGES PASSWORT<br/>3 GROß- UND/ODER KLEINBUCHSTABEN<br/>(DÜRFEN MEHRFACH VORKOMMEN)<br/>2 SONDERZEICHEN (§,$,%,&,?,+,#,!,-,;,:)<br/>(DÜRFEN NUR EINMAL VORKOMMEN)<br/><br/></html>"));     
        d.add(b); 
        ImageIcon img = new ImageIcon("C:\\Users\\kempf\\Downloads\\tt.png");
        d.setIconImage(img.getImage());
        d.setSize(300,500);    
        d.setVisible(true);  
        
        
    }
    public static void main (String[] args) {
    	
        JFrame frame = new JFrame ("Kombinatorik - Passwörter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Kombinatorik());
        frame.pack();
        frame.setVisible (true);
        ImageIcon img = new ImageIcon("C:\\Users\\kempf\\Downloads\\tt.png");
        frame.setIconImage(img.getImage());
    }
}