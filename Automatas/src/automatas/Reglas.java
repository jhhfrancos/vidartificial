/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.Arrays;

/**
 *
 * @author JIMENO
 */
public class Reglas {
    

    public Reglas(){
    }
    
    private int[] integerToBinary(int rule) {
        int[] ruleBin = new int[8]; //positions: 0 => 111; 1 => 110....7 => 000
        for (int i = 7; i >= 0; i--) {
            ruleBin[i] = rule % 2;
            rule = rule / 2;
        }
        return ruleBin;
    }
    
    public int[] nextGeneration(int[] actualGeneration, int rule){
        int[] ruleBin = integerToBinary(rule); //positions: 0 => 111; 1 => 110....7 => 000
        int[] nextGeneration = new int[actualGeneration.length];
        int rightPos,leftPos;
        int lenghtPopulation = actualGeneration.length;
        for(int pos = 0; pos < lenghtPopulation; pos++){
            rightPos = (((pos + 1) % lenghtPopulation) + lenghtPopulation) % lenghtPopulation;
            leftPos = (((pos - 1) % lenghtPopulation) + lenghtPopulation) % lenghtPopulation;
            String location = actualGeneration[leftPos] + "" + actualGeneration[pos] +""+ actualGeneration[rightPos];
            switch(location){
                case "111":
                    nextGeneration[pos] = ruleBin[0];
                    break;
                case "110":
                    nextGeneration[pos] = ruleBin[1];
                    break;
                case "101":
                    nextGeneration[pos] = ruleBin[2];
                    break;
                case "100":
                    nextGeneration[pos] = ruleBin[3];
                    break;
                case "011":
                    nextGeneration[pos] = ruleBin[4];
                    break;
                case "010":
                    nextGeneration[pos] = ruleBin[5];
                    break;
                case "001":
                    nextGeneration[pos] = ruleBin[6];
                    break;
                case "000":
                    nextGeneration[pos] = ruleBin[7];
                    break;
            }
        }
        return nextGeneration;
    }
    
    public static void main(String[] args) {
        Reglas reglas = new Reglas();
        int[] baseCase = new int[100];
        int[] generation;
        for(int i = 0; i< baseCase.length; i++){baseCase[i]=0;}
        baseCase[baseCase.length/2] = 1;
        generation = baseCase;
        for(int i = 0; i<=20; i++){
            for(int pos : generation){System.out.print(pos);}
            System.out.println("");
            generation = reglas.nextGeneration(generation, 90);
        }
    }

}
