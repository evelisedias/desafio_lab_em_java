package Etapa_2_Canditatos;

import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner ler = new Scanner(System.in);


        // Criando array de candidatos de tamanho aleatório
        int tamanhoArray = random.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[tamanhoArray];

        // Nomes e partidos
        String[] nomes = {"JOSE CARLOS DUTRA DOS SANTOS", "CLEBER RACHEL", "VERIDIANA FERNANDES PACHECO", "MIRIAM RAQUEL MORAES DA SILVA",
                "GABRIELA ORTIZ ABENEL", "EVANDRO SALERMO DA SILVA", "JORGE BARBOSA DE SOUZA", "LORECY FLORES",
                "NOELI MACHADO", "NELSON BRAMBILA", "CLAUDIONOR BAPTISTA TAVARES", "LUIS GABRIEL DALBERTO RODRIGUES",
                "GERVÁSIO SANT' ANA DE FREITAS", "ADÃO DA SILVA", "MARCO ANTONIO DA ROSA", "LEANDRO PEDROSO DA SILVA",
                "MAGDA INACIO DOS ANJOS", "PAULO SÉRGIO DA SILVA GOMES", "RUBENS MARCELO DA SILVA", "AVELINO MAZZUCHELLO",
                "VILMAR BALLIN", "JEAN CARLO GRISA PROENÇA", "CLÓVIS DE ALMEIDA CESAR", "GIOVANNI RYSDYK",
                "WILSON MENDES DE AZEVEDO", "LUCIANO DE MOURA VERARDO", "ADRIANO LUIZ DA TRINDADE", "ANISIO RODRIGUES DE ARAUJO",
                "OSÉIAS OLIVEIRA OSÓRIO", "JOSÉ MARCIO MARTINS DA SILVA", "ATILA VLADIMIR ANDRADE", "PAULO DE OLIVEIRA DOS SANTOS",
                "MARLI RUBASKI DA ROSA", "ROGER ERIDSON DORNELES", "PAULO RICARDO CORREA VALIM", "CLAUDIOMIRO SANTOS DOS SANTOS",
                "TIAGO CARVALHO MACHADO", "VALDECIR DAVI DA SILVA", "ANTÔNIO CARLOS DE BARROS VIEIRA", "GLADEMIR BUSI"};
        String[] partidos = {"MDB", "PP", "PRTB", "PDT", "PSD", "REPUBLICANOS", "PSB", "PL", "PC do B", "PTB", "PT", "DEM", "CIDADANIA", "PV", "PSOL", "PSL"};

        // Criando candidatos

        String nomeAleatorio = null;
        for (int i = 0; i < tamanhoArray; i++) {
            nomeAleatorio = nomes[random.nextInt(nomes.length)];
            String nomePartido = partidos[random.nextInt(partidos.length)];
            int votosAleatorios = random.nextInt(50);

            candidatos[i] = new Candidato(nomeAleatorio, nomePartido, votosAleatorios);
        }

        // Ordenação por nome (Selection Sort)
        ordenaCandidatosPorNome(candidatos);

        // Ordenação por votos onde houver nomes iguais (Insertion Sort)
        ordenaCandidatosPorVotos(candidatos);

        // Ordenação por partido onde houver empate de nome e votos (Insertion Sort)
        ordenaCandidatosPorPartido(candidatos);


 //     System.out.println("===================== Candidatos =======================:");
        for (Candidato candidato : candidatos) {
            if (candidato != null) {
                // Imprimir apenas o primeiro nome
                String primeiroNome = candidato.getNome().split(" ")[0];
               //System.out.println("\nNome: " + primeiroNome + ", Partido: " + candidato.getPartido() + ", Intenções de Votos: " + candidato.getIntencoesVotos());
            }
        }
        System.out.println();
        System.out.println("===================== Procurar Canditatos.Candidato =======================:");
        System.out.print("Digite o primeiro nome do candidato para pesquisa: ");
        String nomeParaProcurar = ler.nextLine();

        int resultadoPesquisa = pesquisaBinariaCandidatos(candidatos, nomeParaProcurar);

        if (resultadoPesquisa != -1){
            Candidato candidatoEncontrado = candidatos[resultadoPesquisa];
            System.out.println("Canditatos.Candidato encontrado:");
            System.out.println("Nome: " + candidatoEncontrado.getNome() + ", Partido: " + candidatoEncontrado.getPartido() + ", Votos: " + candidatoEncontrado.getIntencoesVotos());
        } else {
            //ajustar para retornar o -1
        }

    }



    // Ordenação por nome (Selection Sort)
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        if (candidatos == null || candidatos.length == 0) {
            System.out.println("Erro: Array de candidatos está nulo ou vazio.");
            return;
        }

        // Selection Sort para ordenar por nome
        for (int i = 0; i < candidatos.length - 1; i++) {
            int indexMinimo = i;

            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j] != null && candidatos[indexMinimo] != null) {
                    if (candidatos[j].getNome().compareToIgnoreCase(candidatos[indexMinimo].getNome()) < 0) {
                        indexMinimo = j;
                    }
                }
            }

            // Troca os elementos se necessário
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[indexMinimo];
            candidatos[indexMinimo] = temp;
        }
    }

    // Ordenação por votos onde houver nomes iguais (Insertion Sort)
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        if (candidatos == null || candidatos.length == 0) {
            System.out.println("Erro: Array de candidatos está nulo ou vazio.");
            return;
        }

        // Insertion Sort para ordenar por votos em ordem decrescente
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && candidatos[j] != null &&
                    candidatos[j].getNome().equalsIgnoreCase(chave.getNome()) &&
                    candidatos[j].getIntencoesVotos() < chave.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }

            candidatos[j + 1] = chave;
        }
    }

    // Ordenação por partido onde houver empate de nome e votos (Insertion Sort)
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        if (candidatos == null || candidatos.length == 0) {
            System.out.println("Erro: Array de candidatos está nulo ou vazio.");
            return;
        }

        // Insertion Sort para ordenar por partido em ordem alfabética, se nomes e votos forem iguais
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && candidatos[j] != null &&
                    candidatos[j].getNome().equalsIgnoreCase(chave.getNome()) &&
                    candidatos[j].getIntencoesVotos() == chave.getIntencoesVotos() &&
                    candidatos[j].getPartido().compareToIgnoreCase(chave.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }

            candidatos[j + 1] = chave;
        }
    }

    public static int pesquisaBinariaCandidatos(Candidato [] candidatos, String nome){
        if (candidatos == null || candidatos.length == 0){
            System.out.println("Erro: Array de candidatos está nulo ou vazio.");
            return 0;
        }
        for ( int i= 0; i < candidatos.length; i++){
            if (candidatos[i].getNome().split(" ")[0].equalsIgnoreCase(nome)){
                return i;

            }
        }
        return -1;
    }
}