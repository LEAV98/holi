package cinquillo;

import java.util.List;
import java.util.ArrayList;

public class Baraja {

    List<Carta> Oro;
    List<Carta> Espada;
    List<Carta> Corazon;
    List<Carta> Trebol;
    List<String> palos = new ArrayList<>();
    String f;
    /*List<Carta> j1;
    List<Carta> j2;
    List<Carta> j3;
    List<Carta> j4;*/
    
    int random;
    int j=0;
    
    public Baraja() {
        palos.add("♦");
        palos.add("♠");
        palos.add("♥");
        palos.add("♣");
        Carta carta;
        this.Oro = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            carta = new Carta(i+1, palos.get(0));
            this.Oro.add(i, carta);
        }
        this.Espada = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            carta = new Carta(i+1, palos.get(1));
            this.Espada.add(i, carta);
        }
        this.Corazon = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            carta = new Carta(i+1, palos.get(2));
            this.Corazon.add(i, carta);
        }
        this.Trebol = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            carta = new Carta(i+1, palos.get(3));
            this.Trebol.add(i, carta);
        }
    }
    
    
    
    public String ToString(){
        String a="\n";
        
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + Oro.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i+1) % 13 == 0) a = a + "|\n";
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + Espada.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i+1) % 13 == 0) a = a + "|\n";
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + Corazon.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i+1) % 13 == 0) a = a + "|\n";
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + Trebol.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i+1) % 13 == 0) a = a + "|\n";
        }
        return a;
    }
    
    public void Mostrar(){
        String a="Oro: ";
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + Oro.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i+1) % 13 == 0) a = a + "|\n";
        }
    }
    
    
}
