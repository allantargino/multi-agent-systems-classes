package compradorLivros;

import jade.core.Agent;
import jade.core.AID;

public class CompradorDeLivros extends Agent
{
    private String livrosComprar; 
    
    protected void setup()
    {
        //imprime mensagem de Bem-Vindo
        System.out.println("Olá!!! Eu sou o Agente Comprador "+ getLocalName() +" e estou pronto para comprar!");
    
        //Mostra o estado atual do agente, de seu ciclo de vida    
        System.out.println("Meu estado atual é: " + getAgentState());
    
        //captura o titulo do livro que comprara, que foi passado como argumento de inicializacao
        Object[] args = getArguments();
        if(args != null && args.length>0)
        {
           livrosComprar = (String) args[0];
           System.out.println("Pretendo comprar o livro: "+ livrosComprar);            
        }else {
           //finaliza o agente
           System.out.println("Não tenho livros para comprar!");
           doDelete(); //invoca a execucao do metodo takeDown()
        }
    }
    
    protected void takeDown() {
           System.out.println("Agente Comprador com nome global " + getAID().getName() + " está finalizado");
    }
}