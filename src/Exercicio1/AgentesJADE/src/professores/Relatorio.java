package professores;

import jade.core.Agent;
import java.util.Iterator;

public class Relatorio {

    public static void Print(Agent agent) {
        System.out.println("Meu nome local é: " + agent.getAID().getLocalName());
        System.out.println("Meu nome global é: " + agent.getAID().getName());
        System.out.println("Meu estado atual é: " + agent.getAgentState());
        System.out.println("Meus endereços são: ");
        Iterator it = agent.getAID().getAllAddresses();
        while (it.hasNext()) {
            System.out.println("- " + it.next());
        }
    }
}
