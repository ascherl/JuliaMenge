import java.util.*;
import javax.swing.*;

public class JuliaView extends JFrame implements Observer {
	public static final String ACTION_Zeichnen = "Zeichnen";
	public static final String ACTION_Quit = "Beenden";
	public double TF_reC = 0.0;
	public double TF_imC = 0.0;
	
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
	    JButton btNext = new JButton( ACTION_Zeichnen);
	    contentPane.add( btNext);
	    btNext.addActionListener( controller);

	    

	             // Button Quit mit Controller als Listener
	    JButton btQuit = new JButton( ACTION_Quit);
	    contentPane.add( btQuit);
	    btQuit.addActionListener( controller);

	    return contentPane;
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
	
}