package cinquillo;

public class COM extends Player {

    public COM() {
        super();
    }

    @Override
    public void Repartir(Baraja b, int n) {
        int j = 0;
        int palo;
        int num;

        while (j < 52 / n) {
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

        for (int i = 0; i < mano.size(); i++) {
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

    /*public void turno(Mesa m) {
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
    }*/
    private boolean validar(Carta c, Mesa m) {
        boolean a = false;
        if (c != null) {
            if (c.getNum() == 5) {
                a = true;
            } else if (c.getNum() > 5) {
                if (m.b.Corazon.get(c.getNum() - 2) != null && "♥".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Oro.get(c.getNum() - 2) != null && "♦".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Espada.get(c.getNum() - 2) != null && "♠".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Trebol.get(c.getNum() - 2) != null && "♣".equals(c.getPalo())) {
                    a = true;
                }
            } else if (c.getNum() < 5) {
                if (m.b.Corazon.get(c.getNum()) != null && "♥".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Oro.get(c.getNum()) != null && "♦".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Espada.get(c.getNum()) != null && "♠".equals(c.getPalo())) {
                    a = true;
                } else if (m.b.Trebol.get(c.getNum()) != null && "♣".equals(c.getPalo())) {
                    a = true;
                }
            }
        }
        return a;
    }

    private void insert(Carta c, Mesa m) {

        if (mano.contains(c)) {
            if (c.getNum() == 5) {
                switch (c.getPalo()) {
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
                if (m.b.Corazon.get(c.getNum() - 2) != null && "♥".equals(c.getPalo())) {
                    m.b.Corazon.set(c.getNum() - 1, c);
                } else if (m.b.Oro.get(c.getNum() - 2) != null && "♦".equals(c.getPalo())) {
                    m.b.Oro.set(c.getNum() - 1, c);
                } else if (m.b.Espada.get(c.getNum() - 2) != null && "♠".equals(c.getPalo())) {
                    m.b.Espada.set(c.getNum() - 1, c);
                } else if (m.b.Trebol.get(c.getNum() - 2) != null && "♣".equals(c.getPalo())) {
                    m.b.Trebol.set(c.getNum() - 1, c);
                }
            } else if (c.getNum() < 5) {
                if (m.b.Corazon.get(c.getNum()) != null && "♥".equals(c.getPalo())) {
                    m.b.Corazon.set(c.getNum() - 1, c);
                } else if (m.b.Oro.get(c.getNum()) != null && "♦".equals(c.getPalo())) {
                    m.b.Oro.set(c.getNum() - 1, c);
                } else if (m.b.Espada.get(c.getNum()) != null && "♠".equals(c.getPalo())) {
                    m.b.Espada.set(c.getNum() - 1, c);
                } else if (m.b.Trebol.get(c.getNum()) != null && "♣".equals(c.getPalo())) {
                    m.b.Trebol.set(c.getNum() - 1, c);
                }
            }
            if (m.b.Corazon.contains(c) || m.b.Oro.contains(c)
                    || m.b.Trebol.contains(c) || m.b.Espada.contains(c)) {
                mano.remove(c);
                m.Mostrar();
            }
        }
    }

    @Override
    public void turno(Mesa m) {
        jugar(m);
    }

    public void jugar(Mesa m) {
        Carta c = null;
        int i = 0;
        do {
            try {
                c = mano.get(i);
                insert(c, m);
            } catch (Exception e) {
                c = null;
            }
            i++;
        } while (validar(c, m) == false && i < mano.size());
        if (validar(c, m) == false) {
            saltar();
        }
    }

    /*public void verMano(Mesa m) {
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
     */
    public void saltar() {

    }
}
