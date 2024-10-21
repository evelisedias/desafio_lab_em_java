package Etapa_3_Lista_estaticas;

import java.util.Stack;

public class Etapa3 {

    public static void main(String[] args) {
        Etapa3 etapa3 = new Etapa3();

        // Expressões de teste
        String[] expressions = {
                "((A+B)-(C+D))",  // Correto
                "((A+B)",        // Incorreto, falta um parêntese de fechamento
                "A+B(",          // Incorreto, falta um parêntese de fechamento
                ")A+B(",         // Incorreto, parêntese de fechamento no início
                "(A+B))",        // Incorreto, parêntese de fechamento extra
                "(A+B)-(C+D))",  // Incorreto, parêntese de fechamento extra
                "(A+B)-(C+D)",   // Correto
                "A+B",           // Correto, sem parênteses
                "((",            // Incorreto, falta fechamento para ambos os parênteses
                "(()",           // Incorreto, falta um fechamento
                "())",           // Incorreto, parêntese de fechamento extra
        };


        System.out.println("==== Resultado das Verificações de Parênteses ====\n");

        // Itera sobre as expressões ordenadas
        for (int i = 0; i < expressions.length; i++) {
            // Cria uma pilha para cada expressão
            Stack<Character> stack = new Stack<>();
            String expression = expressions[i];

            // Preenche a pilha com a expressão da direita para a esquerda
            for (int j = expression.length() - 1; j >= 0; j--) {
                stack.push(expression.charAt(j));
            }

            // Verifica se os parênteses estão corretos
            boolean isValid = etapa3.checkBrackets(stack);

            // Imprime o resultado com índice numérico
            System.out.printf("%d. Expressão: %-15s | Parênteses corretos? %s%n",
                    i + 1,
                    expression,
                    isValid ? "Sim" : "Não");
        }
    }

    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> stack = new Stack<>();

        while (!s1.isEmpty()) {
            char c = s1.pop();

            if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                if (stack.isEmpty()) {
                    return false; // Parêntese de abertura sem correspondente
                }
                stack.pop(); // Desempilha um fechamento
            }
        }

        return stack.isEmpty(); // Se a pilha estiver vazia, os parênteses estão equilibrados
    }
}