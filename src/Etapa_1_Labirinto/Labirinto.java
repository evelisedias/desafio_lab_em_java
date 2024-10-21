package Etapa_1_Labirinto;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class Labirinto {
    static char[][] labirinto;

    public Labirinto(char[][] labirinto) {
        this.labirinto = labirinto;
    }

    public static void imprimeLabirinto() {
        if (labirinto != null) {
            System.out.println("----------------------------- Labirinto.Labirinto -----------------------------");
            for (int i = 0; i < labirinto.length; i++) { // Percorre cada linha
                for (int j = 0; j < labirinto[i].length; j++) { // Percorre cada coluna
                    System.out.print(labirinto[i][j]); // Imprime o caractere atual
                }
                System.out.println(); // Quebra de linha após cada linha do labirinto
            }
        } else {
            System.out.println("Labirinto.Labirinto ainda não foi criado.");
        }
    }


    public static Labirinto criaLabirinto(String filename) throws IOException {
        BufferedReader ler = new BufferedReader(new FileReader(filename));
        ArrayList<String> linhas = new ArrayList<>();
        String linha;
        while ((linha = ler.readLine()) != null) {
            linhas.add(linha);
        }
        ler.close();

        int altura = linhas.size();
        int largura = linhas.get(0).length();

        char[][] labirinto = new char[altura][largura];
        for (int i = 0; i < altura; i++) {
            labirinto[i] = linhas.get(i).toCharArray();
        }

        return new Labirinto(labirinto);
    }

    public static boolean percorreLabirinto() {
        int startX = 0; // Início na linha superior
        int startY = 0; // Início na coluna esquerda

        return percorreLabirintoRecursivo(startX, startY);
    }

    private static boolean percorreLabirintoRecursivo(int x, int y) {
        // Limites do labirinto
        if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[x].length) {
            return false; // Fora dos limites
        }

        char current = labirinto[x][y];


        if (current == 'D') {
            return true; // Encontrou a saída
        }

        if (current == 'X' || current == 'O') {
            return false; // Parede ou já visitado
        }

        // Marca como visitado
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                if (labirinto[i][j] == ' ') { // Se for um espaço
                    labirinto[i][j] = 'O'; // Substitui por 'O'

                    // Movimentos possíveis (cima, baixo, esquerda, direita)
                    if (percorreLabirintoRecursivo(x - 1, y) || // Cima
                            percorreLabirintoRecursivo(x + 1, y) || // Baixo
                            percorreLabirintoRecursivo(x, y - 1) || // Esquerda
                            percorreLabirintoRecursivo(x, y + 1)) { // Direita

                        return true;
                    }

                    return false; // Se nenhum dos caminhos funcionar
                }

            }
        }
        return true;
    }
}