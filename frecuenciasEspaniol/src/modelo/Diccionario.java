/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author Jhh
 */
public class Diccionario {
    public String texto;
    public ArrayList<Cadena> cadenas;
    public ArrayList<Cadena> letras;
    public ArrayList<Cadena> digrama;
    public ArrayList<Cadena> trigrama;
    public ArrayList<Cadena> tetragrama;
    public ArrayList<Cadena> pentagrama;
    public Map<String, Double> frecuenciasTotalesXgrama;
    public int totalLetras;
    public int totalDigramas;
    public int totalTrigramas;
    public int totalTetragrama;
    public int totalPentagrama;
    public int blancos;
    public int tamañoTotal;
    private ArrayList<frecuencia> frecuencias;
    
    public Diccionario(String texto){ 
        letras = new ArrayList<>();
        digrama = new ArrayList<>();
        trigrama = new ArrayList<>();
        tetragrama = new ArrayList<>();
        pentagrama = new ArrayList<>();
        frecuenciasTotalesXgrama = new LinkedHashMap<>(); //0: letra, 1: digrama, 2: trigrama, 3:tetragrama, 4:pentagrama
        this.texto = texto;
        tamañoTotal = 0;
    }
    
    public void actualizarDiccionario(){
        cadenas = new ArrayList<>();
        this.blancos--;
        Cadena blancos = new Cadena(" ");
        blancos.contador = this.blancos;
        letras.add(blancos);
        totalLetras = 0;
        totalDigramas = 0;
        totalTrigramas = 0;
        totalTetragrama = 0;
        totalPentagrama = 0;
        letras.forEach(l -> totalLetras = totalLetras + l.contador);
        for(Cadena cadena:letras)
            cadena.frecuencia = (double)cadena.contador / totalLetras;
        digrama.forEach(l -> totalDigramas = totalDigramas + l.contador);
        for(Cadena cadena:digrama)
            cadena.frecuencia = (double)cadena.contador / totalDigramas;
        trigrama.forEach(l -> totalTrigramas = totalTrigramas + l.contador);
        for(Cadena cadena:trigrama)
            cadena.frecuencia = (double)cadena.contador / totalTrigramas;
        tetragrama.forEach(l -> totalTetragrama = totalTetragrama + l.contador);
        for(Cadena cadena:tetragrama)
            cadena.frecuencia = (double)cadena.contador / totalTetragrama;
        pentagrama.forEach(l -> totalPentagrama = totalPentagrama + l.contador);
        for(Cadena cadena:pentagrama)
            cadena.frecuencia = (double)cadena.contador / totalPentagrama;
        cadenas.addAll(letras);
        cadenas.addAll(digrama);
        cadenas.addAll(trigrama);
        cadenas.addAll(tetragrama);
        cadenas.addAll(pentagrama);
        
        
        frecuencias = new ArrayList<>();
        frecuencias.add(new frecuencia("letras", (double) totalLetras / tamañoTotal));
        frecuencias.add(new frecuencia("digramas", (double) totalDigramas / tamañoTotal));
        frecuencias.add(new frecuencia("trigramas",(double) totalTrigramas / tamañoTotal));
        frecuencias.add(new frecuencia("tetragrama", (double) totalTetragrama / tamañoTotal));
        frecuencias.add(new frecuencia("pentagramas",(double)totalPentagrama / tamañoTotal));
        
        ordenar();
        for(frecuencia item: frecuencias)
            frecuenciasTotalesXgrama.put(item.tipo,item.valor);
        
        
    }
    private class frecuencia{String tipo; double valor; public frecuencia(String tipo, double valor){this.tipo=tipo;this.valor=valor;}};
    private void ordenar(){
        Collections.sort(letras, (Cadena c1, Cadena c2) -> Double.compare(c1.frecuencia, c2.frecuencia));
        Collections.sort(digrama, (Cadena c1, Cadena c2) -> Double.compare(c1.frecuencia, c2.frecuencia));
        Collections.sort(trigrama, (Cadena c1, Cadena c2) -> Double.compare(c1.frecuencia, c2.frecuencia));
        Collections.sort(tetragrama, (Cadena c1, Cadena c2) -> Double.compare(c1.frecuencia, c2.frecuencia));
        Collections.sort(pentagrama, (Cadena c1, Cadena c2) -> Double.compare(c1.frecuencia, c2.frecuencia));
        //Collections.sort(cadenas, (Cadena c1, Cadena c2) -> c1.frecuencia > c2.frecuencia ? 1:-1);
        Collections.sort(frecuencias, (frecuencia c1, frecuencia c2) -> c1.valor > c2.valor ? 1:-1);
    }
    
}
