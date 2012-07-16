import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;


public class JuliaController extends WindowAdapter implements ActionListener {

	private JuliaModel model;
	private JuliaView view;
	
	JuliaController(JuliaModel model, JuliaView view){
		this.model = model;
		this.view = view;
	}
	
	void paint(){

	}
	
	void release() {
		model = null;
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	    String command = ae.getActionCommand();
	    
	    if( command.equals( JuliaView.ACTION_Zeichnen))
	    {
	    	view.paint(model.berechnen(view.getReC(), view.getImC()));
	    }

	 // Programmabbruch durch Button 'Quit'
	     if( command.equals( JuliaView.ACTION_Quit))
	       view.release();              // Programm  beenden
	}

	public void windowClosing( WindowEvent we)
	{
	    view.release();
	}

}
