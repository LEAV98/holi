package cinquillo;

public class Main {

    public static void main(String[] args) {
        
        Baraja b = new Baraja();
        Mesa m = new Mesa(b);
        
        m.Jugar(m);
        
    }
    
}
