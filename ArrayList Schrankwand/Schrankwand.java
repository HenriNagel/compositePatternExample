import figuren.*;
import java.util.ArrayList;

/**
 * Eine Schrankwand, die manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * @author Nicolas Paul
 * @author Henri Nagel
 * @version (Apr 2021)
 */
public class Schrankwand extends Moebel {
  private ArrayList<Schrank> schraenke;
  private int anzahl;

   /**
   * Erzeuge eine neue Schrankwand
   * Hierbei werden auch parameter für die Schreanke als Teil der Schrankwand übergeben (mit der Vorsilbe prot = prototyp)
   */
  public Schrankwand(int xPosition, int yPosition, int orientierung, String farbe, Schrank schrank, int anzahl) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.farbe = farbe; 
    this.orientierung = orientierung;
    this.anzahl = anzahl;
    istSichtbar = false;

    /**
     * Wir erzeugen eine typisierte Sammlungsklasse, die Schrank-Objekte aufnehmen kann.
     * Die einzelnen Schränke werden in der for-Schleife erzeugt und der ArrayList hinzugefügt.
     */
    schraenke = new ArrayList<Schrank>();    
    for (int i=0; i<anzahl; i++){
        schraenke.add(schrank);
    }
    setzeGrundform();
  }
  
  
  /**
   * Definiert die verwendete Grundform
   */
  protected void setzeGrundform() {
      ZusammengesetzteFigur figur = new ZusammengesetzteFigur();
      
      int breite = 0, tiefe = 0;
      
      for (Schrank schrank: schraenke) {
        figur.fuegeHinzu(breite + schrank.gibX(), schrank.gibY(), schrank.gibFigur(), schrank.gibOrientierung());
        breite += schrank.gibBreite() + schrank.gibX();
        tiefe = (tiefe < schrank.gibTiefe() + schrank.gibY()) ? schrank.gibTiefe() + schrank.gibY() : tiefe;
      }
      
      this.breite = breite;   
      this.tiefe = tiefe;
      this.figur = figur;
    }

  protected void aendereAnzahl(int n){
    verberge();
    if(n <= schraenke.size() && n > 0){
      schraenke = new ArrayList<Schrank>(schraenke.subList(0, n));
    }
    else if(n > schraenke.size()){
      for (int i=0; i <= (n - schraenke.size()); i++){
        Schrank prototype = schraenke.get(0);
        schraenke.add(new Schrank(0, 0, prototype.breite, prototype.tiefe, prototype.orientierung, prototype.farbe));
      }
    }
    setzeGrundform();
    zeige();
  }

  protected void hinzufügenSchrank(Schrank schrank){
    verberge();
    schraenke.add(schrank);
    setzeGrundform();
    zeige();
  }

  protected void entferneSchrank(int i, boolean adjust){
    verberge();
    if(schraenke.get(i+1) != null && !adjust){
      schraenke.get(i+1).xPosition += schraenke.get(i).gibBreite();
    }
    schraenke.remove(i);
    setzeGrundform();
    zeige();
  }

  protected void gibSchrank(int index){
    return schraenke.get(index);
  }
}

  


  

