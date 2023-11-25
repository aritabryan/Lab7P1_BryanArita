//FILA 1 AIENTO 11
package lab7p1_bryanarita;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_BryanArita {

    static Random rndm = new Random();
    static Scanner duki = new Scanner(System.in);

    /*public static void imprimir(char[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + matriz[i][j] + " ");
                if ((j==0 )){
                    System.out.print("[");
                }
                
               if(j==2){
                    System.out.print("]");
                }
                if (j>1){
                    System.out.print("");
                }
                else{
                    System.out.print(",");
                } 
            }
            System.out.println();
        }

    }*/
    public static void generarTablero(char[][] size) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((j == 0)) {
                    System.out.print("[");
                }
                System.out.print(size[i][j] + "");
                if (j == 2) {
                    System.out.print("]");
                }
                if (j > 1) {
                    System.out.print("");
                } else {
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
    }

    public static boolean verificarPosicionValida(char[][] size) {
        boolean verificar = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (size[i][j] == i || size[i][j] == j) {
                    verificar = true;
                } else {
                    verificar = false;
                }
            }
        }
        return verificar;
    }



    public static boolean verificarVictoria(char[][] matriz, char letra) {
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == letra && matriz[i][1] == letra && matriz[i][2] == letra) {
                return true;
            }
            if (matriz[0][i] == letra && matriz[1][i] == letra && matriz[2][i] == letra) {
                return true;
            }
        }
        if (matriz[0][0] == letra && matriz[1][1] == letra && matriz[2][2] == letra) {
            return true;
        }
        if (matriz[0][2] == letra && matriz[1][1] == letra && matriz[2][0] == letra) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("[1]Tres en rayas \n[2]Puntos de silla \n[3]Salir del programa");
        int opcion = duki.nextInt();
        char matrices[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrices[i][j] = ' ';
            }
        }

        while (opcion != 3) {
            switch (opcion) {
                case 1:

                    int fila = 0;
                    int columna = 0;

                    char posx = 'X';
                    char pos0 = '0';
                    boolean win = false;
                    boolean empate = false;
                    char resp = 's';
                    System.out.println("***Bienvenido al tres en raya**");

                    while (resp == 's' || resp == 'S') {

                        generarTablero(matrices);
                        int controndas = 1;
                        while (win == false || controndas <= 9) {
                            System.out.println("\nEs el turno de X");
                            
                           while (true) {
                System.out.print("Ingrese la fila (0,1,2): ");
                fila = duki.nextInt();
                System.out.print("Ingrese la columna (0,1,2): ");
                columna = duki.nextInt();
                if ((fila >= 0 && fila < 3) && (columna >= 0 && columna < 3) && matrices[fila][columna] == ' ') {
                    break;
                } else {
                    System.out.println("Posicion invalida. Ingrese solo 0, 1 o 2 y asegurese que la posicion no este ocupada!!");
                }
            }
            matrices[fila][columna] = 'X';
            generarTablero(matrices);
            controndas++;
            if (verificarVictoria(matrices, posx)) {
                win = true;
                System.out.println("Has ganado!!!");
                break;
            }
                            if (win == false) {
                                System.out.println("");
                                System.out.println("Es el turno de 0");
                                controndas++;
                                int fila1 = rndm.nextInt(3);
                                int columna2 = rndm.nextInt(3);

                                while (matrices[fila1][columna2] != ' ') {
                                    fila1 = rndm.nextInt(3);
                                    columna2 = rndm.nextInt(3);
                                }

                                matrices[fila1][columna2] = '0';
                                System.out.println("Tablero actual");
                                generarTablero(matrices);
                                controndas++;

                                if (verificarVictoria(matrices, pos0) == true) {
                                    win = true;
                                    System.out.println("El sistema te ha ganado");
                                    break;
                                }
                            }

                        }
                            if (controndas < 9) {
                                System.out.println("EMPATE!!");
                            }
                        System.out.println("\nDesea volver a jugar??[s/n]");
                        resp = duki.next().charAt(0);

                        if (resp == 's' || resp == 'S') {

                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    matrices[i][j] = ' ';
                                }
                            }
                            win = false;
                        } else if (resp == 'n' || resp == 'N') {
                            System.out.println("¡Gracias por jugar!");
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    matrices[i][j] = ' ';
                                }
                            }
                            win = false;
                            break;
                        }

                    }
                    break;

                case 2:
                    System.out.println("Ingrese tamano de la fila de la matriz");
                    int tamaf=duki.nextInt();
                    System.out.println("Ingrese tamano de la columna de la matriz");
                    int tamac=duki.nextInt();
                    System.out.println("Matriz generada: ");
                    int [][]matriz=Random(tamaf,tamac);
                    imprimir(matriz);
                    
                    break;

                default:
                    System.out.println("Opcion no valida, ingrese 1 o 2");
            }
            System.out.println("[1]Tres en rayas \n[2]Puntos de silla \n[3]Salir del programa");
            opcion = duki.nextInt();
        }
    }
    
    public static int[][] Random(int fila, int columna) {

        int[][] temporal = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = rndm.nextInt(100);
            }
        }

        return temporal;
    }

    public static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }

}
