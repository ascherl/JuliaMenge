
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;


public class JuliaModel extends Observable {
	public double reC;
	public double imC;
	public ArrayList<Point> PunkteListe;
	   
	

	    

	    // Zo-Werte checken nach Zn+1 = Zn^2 + C, C = const.
	    public int checkZo(double reZ_minus1,double imZ_minus1) {
	        double reZ,imZ;
	        int i;
	        for (i=0;i<10;i++) {
	            imZ=2*reZ_minus1*imZ_minus1+imC;
	            reZ=reZ_minus1*reZ_minus1-imZ_minus1*imZ_minus1+reC;
	            if (reZ*reZ+imZ*imZ>4) return i;
	            reZ_minus1=reZ;
	            imZ_minus1=imZ;
	        }
	        return i;
	    }

	   
		public void berechnen (double reC, double imC){
	    	int x,y;
	        double imZo=-5,zelle=0.0065;
	        ;// oberer Rand
	        for (y=0;y<1000;y++) {
	             double reZo=-5; // linker Rand
	             //System.out.println("gogohj");
	            for (x=0;x<1000;x++) {
	            	//System.out.println("ahoi");
	                if (checkZo(reZo,imZo)==10) {
	                	System.out.println("gogo");
	                    Point punkt = new Point(x,y);
	                    //System.out.println("gogo1");
	                    
	                    PunkteListe = new ArrayList<Point>();
	                    PunkteListe.add(punkt);
	                    System.out.println("gogo2");
	                   System.out.println(x+" "+y);
	                }
	                reZo=reZo+zelle;
	            }
	            imZo=imZo+zelle;
	        }
	    
	    
}}
