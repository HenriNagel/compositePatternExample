import figuren.*;

/**
 * Abstrakte Klasse Moebel
 * 
 * @author Claus Albowski
 * @version (okt 2014)
 */
public abstract class Moebel
{
    protected int xPosition;
    protected int yPosition;
    protected int orientierung;
    protected String farbe;
    protected boolean istSichtbar;
    protected int breite;
    protected int tiefe;    
    protected Object grafikObjekt;
    protected Figur figur;

    /**
     * abstrakte Methode
     * setzeGrundform
     * definiert die verwendete Grundform
     */
    protected abstract void setzeGrundform();

    /**
     * Mache dies Objekt sichtbar.
     * Wenn es bereits sichtbar ist, tue nichts.
     */
    public void zeige() {
        if (!istSichtbar) {
            istSichtbar = true;
            zeichne();
        }
    }
    
    /**
     * Mache dies Objekt unsichtbar.
     * Wenn es bereits unsichtbar ist, tue nichts.
     */
    public void verberge() {
        loesche(); // "tue nichts" wird in loesche() abgefangen.
        istSichtbar = false;
    }
    
    /**
     * Drehe dies Objekt auf den angegebenen Winkel
     */
    public void dreheAuf(int neuerWinkel) {
        loesche();
        orientierung = neuerWinkel;
        zeichne();
    }
    
    /**
     * Bewege dies Objekt horizontal um 'entfernung' Bildschirmpunkte.
     */
    public void bewegeHorizontal(int entfernung) {
        loesche();
        xPosition = xPosition + entfernung;
        zeichne();
    }
    
    /**
     * Bewege dies Objekt vertikal um 'entfernung' Bildschirmpunkte.
     */
    public void bewegeVertikal(int entfernung) {
        loesche();
        yPosition = yPosition + entfernung;
        zeichne();
    }    
    
    /**
     * Aendere die Farbe dieses Objektes in 'neueFarbe'.
     * Muster "rot", "gelb" usw.
     */
    public void aendereFarbe(String neueFarbe) {
        loesche();
        farbe = neueFarbe;
        zeichne();
    }
    
    /**
     * Zeichne das Grafikobjekt mit seinen aktuellen Werten auf den Bildschirm.
     */
    private void zeichne() {
        if (istSichtbar) {
            Zeichnung zeichnung = Zeichnung.gibZeichnung();
            grafikObjekt =
            zeichnung.zeichne (   // gibt das Objekt zurueck
              figur.gibForm(xPosition, yPosition, orientierung),    // definiert seinen grafischen Aspekt    
              farbe,              // definiert seine Zeichenfarbe
              false);          // keine Fuellung
            zeichnung.warte(10);
        }
}
    
    /**
     * Loesche das Grafikobjekt vom Bildschirm.
     */
    private void loesche() {
        if (istSichtbar){
            Zeichnung zeichnung = Zeichnung.gibZeichnung();
            zeichnung.loesche(grafikObjekt);
        }
    }
    
    protected Figur gibFigur() {
        return this.figur;
    }
    
    protected int gibBreite() {
        return this.breite;
    }

    protected int gibTiefe() {
        return this.tiefe;
    }

    protected int gibX(){
        return this.xPosition;
    }

    protected int gibY(){
        return this.yPosition;
    }

    protected int gibOrientierung(){
        return this.orientierung;
    }
}
