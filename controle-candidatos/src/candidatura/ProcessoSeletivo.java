package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {    
    //    selecaoCandidatos();
    //    imprimirSelecionados();
        String[] candidatos = {"MIRIA","HIAGO","EMILLY","HELLEN","EMANUELLY"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    };

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{

            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVAS");
        } else {
            System.out.println(" NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO DE TENTATIVAS 3");
        }
    }

    // metodo auxiliar
    static boolean atender(){
        // esse metodo fica alterando numeros aleatorios entre 1 e 3, até da 1.
        return new Random().nextInt(3)==1; // se o valor entre 1 e 3, for igual a 1. Quer dizer que ele atendeu
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"MIRIA","HIAGO","EMILLY","HELLEN","EMANUELLY"};
        System.out.println("Imprimindo a lista dos candidatos selecionados");
        for(int i = 0; i < candidatos.length; i++){
            System.out.println("O candidato de Nº "+ (i+1) + " é: " +  candidatos[i]);
        }
        System.out.println(" ");
        System.out.println("Forma abreviada de interacão for each");
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String[] candidatos = {"FELIPE","MIRIA", "MARCIA","MIRELA","DANIELA","JORGE","HIAGO","EMILLY","HELLEN","EMANUELLY"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual]; // passando o candidatoAtula como index
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou esse valor de salário R$" + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }else {
                System.out.println("O candidato " + candidato + " não foi selecionado para vaga");
            }
            candidatoAtual++;
        }
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO OU CONTRA POPOSTA");
        }else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATO");
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
