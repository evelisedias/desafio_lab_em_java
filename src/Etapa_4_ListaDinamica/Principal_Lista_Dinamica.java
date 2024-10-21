package Etapa_4_ListaDinamica;

public class Principal_Lista_Dinamica {

    public static void main(String[] args) {
        try {
            Stack<Integer> stack = new LinkedStack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Topo da pilha: " + stack.top()); // Deve imprimir 3
            System.out.println("Tamanho da pilha: " + stack.numElements()); // Deve imprimir 3
            System.out.println("Removido da pilha: " + stack.pop()); // Deve imprimir 3
            System.out.println("Topo da pilha após remoção: " + stack.top()); // Deve imprimir 2
        } catch (OverflowException | UnderflowException e) {
            e.printStackTrace();
        }
    }

}
