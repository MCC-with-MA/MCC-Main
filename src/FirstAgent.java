import jade.core.Agent;

public class FirstAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Hello Jade! Agent " + getAID().getName() + " is ready.");
        System.out.println("I'm the first agent.");
    }
}