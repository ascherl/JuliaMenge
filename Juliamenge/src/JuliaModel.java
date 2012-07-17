

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class JuliaModel extends Observable{
	public ArrayList<Point> PunkteListe;
	

    double reC, imC;

   

    // Zo-Werte checken nach Zn+1 = Zn^2 + C, C = const.
    public int checkZo(double reZ_minus1,double imZ_minus1) {
        double reZ,imZ;
        int i;
        for (i=0;i<47;i++) {
            imZ=2*reZ_minus1*imZ_minus1+imC;
            reZ=reZ_minus1*reZ_minus1-imZ_minus1*imZ_minus1+reC;
            if (reZ*reZ+imZ*imZ>4) return i;
            reZ_minus1=reZ;
            imZ_minus1=imZ;
        }
        return i;
    }

    // Punkte berechnen und setzen
    public ArrayList<Point> berechnen(double reC, double imC) {
        double reZo, imZo, zelle=0.01; // Ein Pixel = 0.0065
        int x,y,iterationenZo;
        PunkteListe = new ArrayList<Point>();
       
        this.reC=reC;
        this.imC=imC;

        imZo=-4; // oberer Rand
        for (y=0;y<1024;y++) {
            reZo=-5; // linker Rand
            for (x=0;x<768;x++) {
                if (checkZo(reZo,imZo)==47) {
                    PunkteListe.add(new Point(x,y));
                    //System.out.println(x+"  "+y);
                }
                reZo=reZo+zelle; // nŠchste Spalte
            }
            imZo=imZo+zelle; // nŠchste Zeile
        }
        for(int k=0; k<PunkteListe.size(); k++){
        System.out.println(PunkteListe.get(k));
       }
    return PunkteListe;    
    }
    
    
}
