package cinquillo;

import java.util.Objects;

class Carta {

    Integer num;
    
    String palo;

    public Carta(int num, String palo) {
        this.num = num;
        this.palo = palo;
    }

    public Carta() {
        this.num = 0;
    }

    public Integer getNum() {
        return num;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public boolean equals(Object o) {
        Carta c = (Carta) o;
        try {
            return Objects.equals(c.getNum(), num) && c.getPalo().equals(palo);
        } catch (Exception e) {
            return false;
        }
        

    }

    public String ToString() {
        return num + " " + palo;
    }
}
