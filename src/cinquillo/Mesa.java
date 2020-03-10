package cinquillo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mesa {

    Baraja b;

    public Mesa(Baraja b) {
        this.b = b;
    }

    public String ToString() {
        String a = "\n";

        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Oro.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Espada.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Corazon.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Trebol.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + " ";
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        return a;
    }

    public void Jugar(Mesa m) {
        List<Player> players = new ArrayList<>();
        Player z;
        int j=1;
        int s;
        boolean endgame = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Cantidad de jugadores: ");
        int ps = scan.nextInt();
        for (int i = 0; i < ps; i++) {
            System.out.printf("Jugador %s\n", i+1);
            System.out.println("1. Persona");
            System.out.println("2. COM");
            s = scan.nextInt();
            if (s == 1) {
                z = new Jugador();
            }else{
                z = new COM();
            }
            players.add(z);
            players.get(i).Repartir(b, ps);
        }
        
        Mostrar();
        while (endgame == false) {
            j=1;
            for (Player p : players) {
                System.out.printf("Turno jugador %s:\n", j);
                p.turno(m);
                if (p.mano.isEmpty()) {
                    endgame = true;
                }
                j++;
            }
        }
        System.out.printf("Gana Jugador %d : ", j-1);
    }

    public void terminarJuego() {
        
    }

    public void Mostrar() {
        String a = "Diamante: ";
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Oro.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + "\t";
            }
        }
        a = a + "\nEspada: ";
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Espada.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + "\t";
            }
        }
        a = a + "\nTrebol: ";
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Trebol.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + "\t";
            }
        }
        a = a + "\nCorazon: ";
        for (int i = 0; i < 13; i++) {
            try {
                a = a + "|" + b.Corazon.get(i).ToString();
            } catch (Exception e) {
                a = a + "|" + "\t";
            }
        }
        System.out.println(a);
    }

}
