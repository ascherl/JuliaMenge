import java.awt.*;
import java.applet.*;

public class Julia extends Applet {

    double reC, imC;

    public void init() {
        setBackground(new Color(255,0,255));
    }

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

    // Punkte berechnen und setzen
    public void paint (Graphics g) {
        double reZo, imZo, zelle=0.0065; // Ein Pixel = 0.0065
        int x,y,iterationenZo;
        Color colJulia = new Color(0,0,200); // Farbe Juliamenge
        reC = -0.5;
        imC = 0.5;

        imZo=-5; // oberer Rand
        for (y=0;y<1000;y++) {
            reZo=-5; // linker Rand
            for (x=0;x<1000;x++) {
                if (checkZo(reZo,imZo)==10) {
                    g.setColor(colJulia);
                    g.drawLine(x,y,x,y);
                }
                reZo=reZo+zelle; // nŠchste Spalte
            }
            imZo=imZo+zelle; // nŠchste Zeile
        }
    }
}
