/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jhh
 */
public class Automatas {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        int[][] grilla = new int[10][10];
        int[][] remplazoGrilla = new int[10][10];
        int iteraciones = 5;
        grilla = inicializar(grilla);
        remplazoGrilla = grilla;
        for(int j = 0; j<iteraciones; j++){
            remplazoGrilla = iteracion(grilla);
            for(int i = 0; i<grilla.length; i++){
                for(int k = 0; k <grilla.length; k++){
                    System.out.println(grilla[i][k]);
                }
            }
        }
    }

    private static int[][] inicializar(int[][] grilla) {
        
        Random rand = new Random();
        int numero;
        for(int i = 0; i < grilla.length; i++){
            for(int j = 0; j < grilla.length; j++){
                numero = (rand.nextInt(3));
                grilla[i][j] = numero;
            }
            
        }
        return grilla;
    }

    private static int[][] iteracion(int[][] grilla) {
        int colorActual;
        int numVecinos;
        int[][] nuevaGrilla = new int[grilla.length][grilla.length];
        for(int i = 0; i < grilla.length; i++){
            for(int j = 0; j <grilla.length; j++){
                colorActual = grilla[i][j];
                if(colorActual != 0){
                    numVecinos = calcularVecinos(grilla,i,j);
                }
            }
        }
        return nuevaGrilla;
    }

    private static int calcularVecinos(int[][] grilla, int i, int j) {
        int colorActual = grilla[i][j];
        int tamGrilla = grilla.length;
        int numVecinos = 0;
        int iSig = (((i + 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int jSig = (((j + 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int iAtr = (((i - 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int jAtr = (((j - 1) % tamGrilla) + tamGrilla) % tamGrilla;
        // derecha
        
    }
    
    
}
