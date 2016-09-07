/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import modelo.Cadena;
import modelo.Diccionario;

/**
 *
 * @author Jhh
 */
public class GeneradorTexto {
    
    public static String generarTexto(Diccionario diccionario){
        String stringGenerado="";
        int numeroCaracteres=1000;
        Map<String, Double> frecuenciasTotales = diccionario.frecuenciasTotalesXgrama;
        ArrayList<Cadena> letras = diccionario.letras;
        ArrayList<Cadena> digramas = diccionario.digrama;
        ArrayList<Cadena> trigramas = diccionario.trigrama;
        ArrayList<Cadena> tetragramas = diccionario.tetragrama;
        ArrayList<Cadena> pentagramas = diccionario.pentagrama;
        
        Random random = new Random();
        double randomNum = 0;
        double desde = 0;
        double hasta = 0;
        String tempGenerado = "";
        for(int i=0; i<numeroCaracteres;i++){
            randomNum = random.nextDouble();
            desde = 0;
            hasta = desde;
            for(int j = 0; j<frecuenciasTotales.size();j++){
                desde = hasta;
                hasta = hasta + (double) frecuenciasTotales.values().toArray()[j];
                if(randomNum>=desde && randomNum<=hasta){
                    String tipo = (String) frecuenciasTotales.keySet().toArray()[j];

                    switch (tipo){
                        case "letras":
                            tempGenerado = obtenerStringAleatorio(letras);
                            break;
                        case "digramas":
                            tempGenerado = obtenerStringAleatorio(digramas);
                            break;
                        case "trigramas":
                            tempGenerado = obtenerStringAleatorio(trigramas);
                            break;
                        case "tetragrama":
                            tempGenerado = obtenerStringAleatorio(tetragramas);
                            break;
                        case "pentagramas":
                            tempGenerado = obtenerStringAleatorio(pentagramas);
                            break;
                    }
                    stringGenerado = stringGenerado + tempGenerado;
                }
            }
                
        }
        return stringGenerado;
    }

    private static String obtenerStringAleatorio(ArrayList<Cadena> cadenasGrama) {
        if(cadenasGrama.isEmpty()) return "";
        String resultado="";
        Random rand = new Random();
        double numero = rand.nextDouble();
        double desde = 0;
        double hasta = cadenasGrama.get(0).frecuencia;
        
        for(int i = 0; i<cadenasGrama.size(); i++){
            if(numero>=desde && numero<hasta)
                return cadenasGrama.get(i).cadena;
            desde = hasta;
            hasta = hasta + cadenasGrama.get(i+1).frecuencia;
        }
        return resultado;
    }
}
