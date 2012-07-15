import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;


public class JuliaModel extends Observable {
	public double reC;
	public double imC;
	public ArrayList<Point> punkteListe;
	
	ArrayList<Point> berechnen(double reC, double imC) {
		return punkteListe;
	}
	
	ArrayList<Point> getPunkte(){
		return null;
	}
}
