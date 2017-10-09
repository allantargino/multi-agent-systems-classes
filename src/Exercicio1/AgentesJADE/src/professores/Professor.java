package professores;

import jade.core.Agent;

public class Professor extends Agent
{
    private String servicoDuvida; 
    
    protected void setup()
    {
        //Imprime mensagem de Bem-Vindo
        System.out.println("Olá!!! Eu sou o professor de "+ getLocalName() +" e estou pronto para ensinar!");
        
        //Relatório
        Relatorio.Print(this);
        
        //Captura argumentos:
        Object[] args = getArguments();
        if(args != null && args.length>0)
        {
           servicoDuvida = (String) args[0];
           System.out.println("Meu serviço é: " + servicoDuvida);            
        }else {
           //Finaliza o agente
           System.out.println("Não gosto de alunos!");
           doDelete(); //Invoca a execucao do metodo takeDown()
        }
    }
    
    protected void takeDown() {
        System.out.println("O professor da disciplina de " + getAID().getName() + " foi finalizado.");
    }
}