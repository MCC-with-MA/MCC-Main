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
        mp.setParameter(Profile.MAIN_PORT, "1002");
        mp.setParameter(Profile.PLATFORM_ID, "P1");
        ContainerController mcc = rt.createMainContainer(mp);
//         Create Containers and Agents
        Profile cp1 = new ProfileImpl();
        cp1.setParameter(Profile.MAIN_HOST, "localhost");
        cp1.setParameter(Profile.GUI, "true");
        ContainerController cc1 = rt.createAgentContainer(cp1);
        for (int i = 0; i <= 9; i++) {
            AgentController ac;
            try {
                ac = mcc.createNewAgent("Agent0" + i, "FirstAgent", null);
                ac.start();
                ac = cc1.createNewAgent("Agent1" + i, "FirstAgent", null);
                ac.start();
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }
    }
}