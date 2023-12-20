import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile mp = new ProfileImpl();
        mp.setParameter(Profile.MAIN_HOST, "localhost");
        mp.setParameter(Profile.GUI, "true");
        mp.setParameter(Profile.MAIN_PORT, "1099");
        ContainerController mcc = rt.createMainContainer(mp);
        for (int i = 0; i <= 9; i++) {
            AgentController ac;
            try {
                ac = mcc.createNewAgent("Agent0" + i, "FirstAgent", null);
                ac.start();
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }
    }
}