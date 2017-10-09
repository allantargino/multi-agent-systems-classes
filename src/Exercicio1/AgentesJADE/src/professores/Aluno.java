package professores;

import jade.core.Agent;
import java.util.Iterator;

public class Aluno extends Agent {

    private String servicoDuvida;

    protected void setup() {
        //Imprime mensagem de Bem-Vindo
        System.out.println("Olá!!! Eu sou o aluno " + getLocalName() + " e estou pronto para aprender!");

        //Relatório
        Relatorio.Print(this);
    }

    protected void takeDown() {
        System.out.println("O aluno " + getAID().getName() + " foi finalizado.");
    }
}
