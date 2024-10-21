package Etapa_1_Labirinto;

import java.io.IOException;

public class PrincipalLabirinto {
    public static void main(String[] args) throws IOException {

        System.out.println("================ 1º Etapa ================");
        System.out.println();
        System.out.print("O código encontrou a Saída? True(Sim) | False (Não): ");
        String filename = "texto.txt";
        Labirinto.criaLabirinto(filename);
        System.out.println(Labirinto.percorreLabirinto());
        System.out.println();


    }


}