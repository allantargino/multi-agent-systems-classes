package professores;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class CriarAgente {

    static ContainerController containerController;
    static AgentController agentController;

    public static void main(String[] args) throws InterruptedException 
    {
        startMainContainer("127.0.0.1", Profile.LOCAL_PORT, "UFABC");

        //Professores
        addAgent(containerController, "Sistemas Multiagentes", Professor.class.getName(), new String[]{ "Tirar dúvidas da disciplina de SMA" });
        addAgent(containerController, "Computação Gráfica", Professor.class.getName(), new String[]{ "Tirar dúvidas da disciplina CG" });
        addAgent(containerController, "Algoritmos e Estruturas de Dados", Professor.class.getName(), new String[]{ "Tirar dúvidas da disciplina AED" });
        addAgent(containerController, "Inteligência Artificial", Professor.class.getName(), new String[]{ "Tirar dúvidas da disciplina IA" });

        //Aluno
        addAgent(containerController, "Allan Targino", Aluno.class.getName(), null);

        //Adicionando agente RMA
        addAgent(containerController, "RMA", jade.tools.rma.rma.class.getName(), null);
    }

    public static void startMainContainer(String host, String port, String name) {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, host);
        profile.setParameter(Profile.MAIN_PORT, port);
        profile.setParameter(Profile.PLATFORM_ID, name);
        
        containerController = runtime.createMainContainer(profile);
    }

    public static void addAgent(ContainerController cc, String agent, String classe, Object[] args) {
        try {
            agentController = cc.createNewAgent(agent, classe, args);
            agentController.start();
        } catch (StaleProxyException s) {
            s.printStackTrace();
        }
    }
}