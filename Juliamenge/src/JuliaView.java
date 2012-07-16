import java.awt.*;
import java.util.*;
import javax.swing.*;

public class JuliaView extends JFrame implements Observer {
	public static final String ACTION_Zeichnen = "Zeichnen";
	public static final String ACTION_Quit = "Beenden";
	public double TF_reC = 0.0;
	public double TF_imC = 0.0;
	
    JTextField tfImC = new JTextField(3);
    JTextField tfReC = new JTextField(3);

	
	private JuliaModel model;
	private JuliaController controller;
	
	  public JuliaView( JuliaModel model, String titel)
	  {
	// Titelzeile
	    super( titel);
	// Model
	    this.model = model;
	    this.model.addObserver( this);      // Ueberwachung
	// Controller
	    controller = makeController();
	// View
	    makeView();
	  }
	
	  private JuliaController makeController()
	  {
	    return new JuliaController( model, this);
	  }
	
	  private void makeView()
	  {
	// ContentPane
	    setContentPane( createContentPane());

	// Fenster mit Controller als Listener
	    addWindowListener( controller);
	    pack();
	    setVisible( true);
	  }
	  
	  private JPanel createContentPane()
	  {
	    JPanel contentPane = new JPanel();

	             // Button Next mit Controller als Listener
	    JButton btDraw = new JButton( ACTION_Zeichnen);
	    contentPane.add( btDraw);
	    btDraw.addActionListener( controller);

	    

	             // Button Quit mit Controller als Listener
	    JButton btQuit = new JButton( ACTION_Quit);
	    contentPane.add( btQuit);
	    btQuit.addActionListener( controller);
	    btDraw.addActionListener( controller);
	    contentPane.add(new JLabel("("));
	    contentPane.add( tfReC);
	    contentPane.add(new JLabel(") + ("));
	    contentPane.add( tfImC);
	    contentPane.add(new JLabel("i)"));
	    
	    return contentPane;
	  }

	  double getReC(){
		  return Double.parseDouble(tfReC.getText()); // TODO Find better way of casting to double
	  }
	  
	  double getImC(){
		  return Double.parseDouble(tfImC.getText()); // TODO Find better way of casting to double
	  }
	  
	  
	public void zeichnen(ArrayList<Point> Punkteliste) {
		  JPanel Zeichenflaeche = new Zeichnen(Punkteliste);
		  Zeichenflaeche.setBackground(Color.white);
		  setContentPane(Zeichenflaeche);
		  pack();
		  Zeichenflaeche.setVisible(true);
	  }

	  public void release()
	  {
	// View (Fenster)
	    dispose();
	// Controller
	    controller.release();
	    controller = null;
	// Model
	    model.deleteObserver( this);
	    model = null;
	  }
	
	public void update(Observable o, Object arg) {
		
	}
	

	public class Zeichnen extends JPanel {
		ArrayList<Point> PunkteListe = null;
		
		Zeichnen(ArrayList<Point> PunkteListe)
		{
			setPreferredSize( new Dimension( 1024, 768));
			this.PunkteListe = PunkteListe;
			
		}
		
		@Override
		public void paintComponent( Graphics g)
		{
			for(int i = 0; i < PunkteListe.size()-1; i++)
			{
				g.drawLine(PunkteListe.get(i).x, PunkteListe.get(i).y, PunkteListe.get(i+1).x, PunkteListe.get(i+1).y);
			}
		}
	}
}


