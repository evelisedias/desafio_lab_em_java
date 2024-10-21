package Etapa_3_Lista_estaticas;

import Etapa_3_Lista_estaticas.StaticList;

import java.util.Random;

public class PrincipalStaticList {
    public static void main(String[] args) {
        Random random = new Random();

        try {
            // Cria uma lista estática com tamanho máximo de 10 elementos
            StaticList<Integer> lista = new StaticList<>(10);

            // Popula parte da lista estática
            lista.insert(random.nextInt(50) + 1, 0); // Inserção na posição 0
            lista.insert(random.nextInt(50) + 1, 1); // Inserção na posição 1
            lista.insert(random.nextInt(50) + 1, 2); // Inserção na posição 2
            lista.insert(20, 3); // Inserção na posição 3

            System.out.println("------------------------------------------------------------------");
            System.out.println("Lista Inicial:");
            System.out.println(lista);
            System.out.println("------------------------------------------------------------------\n");

            // Insere um elemento no meio
            lista.insert(15, 1); // Inserção no meio
            System.out.println("Inserindo 15 na posição 1:");
            System.out.println(lista);
            System.out.println("------------------------------------------------------------------\n");

            // Testa a contagem de elementos específicos
            int count20 = lista.contaElementos(20);
            int count15 = lista.contaElementos(15);
            int count30 = lista.contaElementos(30); // Elemento que ainda não foi inserido

            System.out.println("Procurando elementos:");
            System.out.println("O elemento 20 aparece " + count20 + " vez(es) na lista.");
            System.out.println("O elemento 15 aparece " + count15 + " vez(es) na lista.");
            System.out.println("O elemento 30 aparece " + count30 + " vez(es) na lista.");
            System.out.println("------------------------------------------------------------------\n");

            // Testa a remoção de um elemento
            lista.remove(1); // Remoção do segundo elemento
            System.out.println("Após remover o elemento na posição 1:");
            System.out.println(lista);
            System.out.println("------------------------------------------------------------------\n");

            // Testa a remoção de um elemento no final
            lista.remove(lista.numElements() - 1); // Remoção do último elemento
            System.out.println("Após remover o último elemento:");
            System.out.println(lista);
            System.out.println("------------------------------------------------------------------\n");

            // Testa exceções ao tentar inserir além do limite
            lista.insert(40, 7);
            lista.insert(50, 6);
            System.out.println("Após novas inserções:");
            System.out.println(lista);
            System.out.println();

        } catch (Exception e) {
            System.out.println();
            System.err.println("Exceção encontrada: " + e.getMessage());
            System.out.println();
        }
    }
}
