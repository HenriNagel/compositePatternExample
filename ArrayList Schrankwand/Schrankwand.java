import figuren.*;
import java.util.ArrayList;

/**
 * Eine Schrankwand, die manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * @author Nicolas Paul
 * @version (Apr 2020)
 */
public class Schrankwand extends Moebel {
  private ArrayList<Schrank> schraenke;
  private int anzahl;

   /**
   * Erzeuge eine neue Schrankwand mit einer Standardfarbe und Standardgroesse
   * an einer Standardposition.
   */
  public Schrankwand(int anzahl) {
    xPosition = 40;
    yPosition = 80;
    farbe = "blau";
    orientierung = 0;
    istSichtbar = false;
    this.anzahl = anzahl;
    /**
     * Um die gesamte breite der Schrankwand zu berechnen, brauchen wir die breite
     * eines Schrankes.
     */
    int schrankbreite = 60; 
    tiefe  = 37;
    /**
     * Wir erzeugen eine typisierte Sammlungsklasse, die Schrank-Objekte aufnehmen kann.
     * Die einzelnen Schränke werden in der for-Schleife erzeugt und der ArrayList hinzugefügt.
     */
    schraenke = new ArrayList<Schrank>();    
    for (int i=0; i<anzahl; i++){
        schraenke.add(new Schrank(0, 0, schrankbreite, tiefe, orientierung, farbe));
    }
    setzeGrundform();
  }
  
  
  /**
   * Definiert die verwendete Grundform
   */
  protected void setzeGrundform() {
      /**
       * Ein ZusammengesetzteFigur Objekt mit dem Namen figur wird definiert.
       * Es verwaltet die figuren der Schrankobjekte.
       */
      ZusammengesetzteFigur figur = new ZusammengesetzteFigur();
      
      /**
       * Mit einer vereinfachten for-Schleife kann man über alle Elemente einer Sammlungsklasse
       * "iterieren". Das bedeutet, dass sie nacheinander durchlaufen werden.
       * 
       * for (<ELEMENT-TYP> <LAUFVARIABLE> : <LISTE>) {
       *    ...
       * }
       * 
       * Wir wollen hier alle Umrisse unserer Schränke die in der ArrayList gespeichert sind,
       * der ZusammengesetzenFigur hinzugeügen.
       * 
       * Wir interieren also über die ArrayList schraenke. In jedem Iterationsschritt wird in
       * der Laufvariable schrank vom Datentyp Schrank das aktuelle Schrankobjekt gespeichert.
       * von diesem Schrankobjekt wird jetzt mit gibtFigur die figur geholt.
       * 
       * Außerdem müssen die Schrankobjekte noch an die richtige Stelle ge stezt werden.
       * Wir berechnen die xPosition folgendermaßen: Jedes Schrankobjekt hat einen Index, den man
       * über die Methode indexOf(i) erhält.
       * Wir multiplizieren den Index mit der breite des Schranks (gibBreite muss in Moebel
       * ergänzt werden) un erhalten die xPosition. Bsp.:
       * 
       * 1. Schrank: Index = 0 => 0*60 = 0 => xPosition = 0
       * 2. Schrank: Index = 1 => 1*60 = 60  => xPosition = 60
       * ...
       * 
       */
      int breite = 0;
      int tiefe = 0;
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

  protected void hinzufügenSchrank(int xPos, int yPos, int breite, int tiefe, int orientierung, String farbe){
    verberge();
    schraenke.add(new Schrank(xPos,yPos,breite,tiefe,orientierung,farbe));
    setzeGrundform();
    zeige();
  }

  protected void entferneSchrank(int i){
    verberge();
    if(schraenke.get(i+1) != null){
      schraenke.get(i+1).xPosition += schraenke.get(i).gibBreite();
    }
    schraenke.remove(i);
    setzeGrundform();
    zeige();
  }

  protected void test(int xPos, int yPos){
    verberge();
    int breite = 50;
    int tiefe = 50;
    int orientierung = 0;
    String farbe = "blau";
    
  }


  protected void test2(){
    ZusammengesetzteFigur figur = new ZusammengesetzteFigur();
    System.out.println(this.figur);
  }
}

  


  

