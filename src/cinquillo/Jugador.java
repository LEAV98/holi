package cinquillo;

import java.util.Scanner;

public class Jugador extends Player {

    Scanner scan = new Scanner(System.in);

    public Jugador() {
        super();
    }

    @Override
    public void Repartir(Baraja b, int n) {
        int j = 0;
        int palo;
        int num;

        while (j < 52/n) {
            Carta c = null;
            palo = (int) (Math.random() * 4) + 1;
            num = (int) (Math.random() * (13));
            //num = num - 1;
            //System.out.println(num);

            switch (palo) {
                case 1:
                    c = b.Oro.get(num);
                    b.Oro.set(num, null);
                    break;
                case 2:
                    c = b.Corazon.get(num);
                    b.Corazon.set(num, null);
                    break;
                case 3:
                    c = b.Espada.get(num);
                    b.Espada.set(num, null);
                    break;
                case 4:
                    c = b.Trebol.get(num);
                    b.Trebol.set(num, null);
                    break;
            }
            if (c != null) {
                this.mano.add(j, c);
                j++;
            }
        }
    }

    public String ToString() {
        String a = "\n";

        for (int i = 0; i < 26; i++) {
            try {
                a = a + "|" + mano.get(i).ToString();
            } catch (Exception e) {
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        return a;
    }

    @Override
    public void turno(Mesa m) {
        System.out.println("1. Jugar");
        System.out.println("2. Ver mano");
        System.out.println("3. Ver mesa");
        System.out.println("4. Saltar");
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                jugar(m);
                break;
            case 2:
                verMano(m);
                break;
            case 3:
                m.Mostrar();
                turno(m);
                break;
            case 4:
                saltar();
                break;
            default:
                turno(m);
                break;
        }
    }

    public void jugar(Mesa m) {
        Integer op;
        String d = "";
        do {
            System.out.print("Numero: ");
            op = scan.nextInt();
        } while (op < 1 || op > 13);
        System.out.println("1. Diamante");
        System.out.println("2. Espada");
        System.out.println("3. Corazon");
        System.out.println("4. Trebol");
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                d = "♦";
                break;
            case 2:
                d = "♠";
                break;
            case 3:
                d = "♥";
                break;
            case 4:
                d = "♣";
                break;
            default:
                jugar(m);
        }
        Carta c = new Carta(op, d);

        if (mano.contains(c)) {
            if (c.getNum() == 5) {
                switch (d) {
                    case "♦":
                        m.b.Oro.set(c.getNum() - 1, c);
                        break;
                    case "♠":
                        m.b.Espada.set(c.getNum() - 1, c);
                        break;
                    case "♥":
                        m.b.Corazon.set(c.getNum() - 1, c);
                        break;
                    case "♣":
                        m.b.Trebol.set(c.getNum() - 1, c);
                        break;
                }
            } else if (c.getNum() > 5) {
                if (m.b.Corazon.get(c.getNum() - 2) != null && "♥".equals(d)) {
                    m.b.Corazon.set(c.getNum() - 1, c);
                } else if (m.b.Oro.get(c.getNum() - 2) != null && "♦".equals(d)) {
                    m.b.Oro.set(c.getNum() - 1, c);
                } else if (m.b.Espada.get(c.getNum() - 2) != null && "♠".equals(d)) {
                    m.b.Espada.set(c.getNum() - 1, c);
                } else if (m.b.Trebol.get(c.getNum() - 2) != null && "♣".equals(d)) {
                    m.b.Trebol.set(c.getNum() - 1, c);
                }
            } else if (c.getNum() < 5) {
                if (m.b.Corazon.get(c.getNum()) != null && "♥".equals(d)) {
                    m.b.Corazon.set(c.getNum() - 1, c);
                } else if (m.b.Oro.get(c.getNum()) != null && "♦".equals(d)) {
                    m.b.Oro.set(c.getNum() - 1, c);
                } else if (m.b.Espada.get(c.getNum()) != null && "♠".equals(d)) {
                    m.b.Espada.set(c.getNum() - 1, c);
                } else if (m.b.Trebol.get(c.getNum()) != null && "♣".equals(d)) {
                    m.b.Trebol.set(c.getNum() - 1, c);
                }
            }
            System.out.println(c.ToString());
            if (m.b.Corazon.contains(c) || m.b.Oro.contains(c)
                    || m.b.Trebol.contains(c) || m.b.Espada.contains(c)) {
                mano.remove(c);
                m.Mostrar();
            } else {
                System.out.println("No puedes colocar la carta");
                turno(m);
            }

        } else {
            System.out.println("No se encuentra en tu mano");
            turno(m);
        }

    }

    public void verMano(Mesa m) {
        String a = "\n";

        for (int i = 0; i < mano.size(); i++) {
            try {
                a = a + "|" + mano.get(i).ToString();
            } catch (Exception e) {
            }
            if ((i + 1) % 13 == 0) {
                a = a + "|\n";
            }
        }
        System.out.println(a);
        turno(m);
    }

    public void saltar() {

    }

}
