import figuren.*;

/**
 * Ein Schrank, der im Grafikfenster angezeigt und
 * dessen Eigenschaften veraendert werden koennen.
 * 
 * @author Nicolas Paul
 * @version (Apr 2020)
 */
public class Schrank extends Moebel
{
    /**
     * Erzeuge einen neuen Schrank. Dieser Kostruktor erwartet die Angabe aller für
     * den Schrank wichtigen Parameter.
     */
    public Schrank(int xPosition, int yPosition, int breite, int tiefe, int orientierung, String farbe) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.breite = breite;
        this.tiefe  = tiefe;
        this.orientierung = orientierung;
        this.farbe = farbe;
        this.istSichtbar = false;
        setzeGrundform();
    }
      
    /**
     * definiert die verwendete Grundform
     */
    protected void setzeGrundform() {
       ZusammengesetzteFigur figur = new ZusammengesetzteFigur();
       figur.fuegeHinzu(0, 0, new Rechteck(breite, tiefe), 0);
       figur.fuegeHinzu(0, 0, new Linie(0, 0, breite,tiefe), 0);
       figur.fuegeHinzu(0, tiefe, new Linie(0, tiefe, breite, 0), 0);
       this.figur = figur;
    } 
}

  

