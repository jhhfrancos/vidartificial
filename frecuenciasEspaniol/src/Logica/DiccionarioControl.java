/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import modelo.Cadena;
import modelo.Diccionario;

/**
 *
 * @author Jhh
 */
public class DiccionarioControl {
    
    public static ArrayList<Cadena> generarFrecuencias(Diccionario diccionario){
        String texto = diccionario.texto;
        int espaciosBlancos = 0;
        ArrayList<String> textoSplit = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(texto);
        while (st.hasMoreTokens()) {
            textoSplit.add(st.nextToken());
            espaciosBlancos++;
        }
        diccionario.blancos = espaciosBlancos;
        ArrayList<Cadena> letras = new ArrayList<>();
        ArrayList<Cadena> digramas= new ArrayList<>();
        ArrayList<Cadena> trigramas= new ArrayList<>();
        ArrayList<Cadena> cuatrigramas= new ArrayList<>();
        ArrayList<Cadena> pentagramas= new ArrayList<>();
        
        for(String text: textoSplit){
            for(String cadena: obtenerLetras(text)){
                sumarContadorCadena(cadena, letras);
                diccionario.tamañoTotal++;
            }
        }
        for(String text: textoSplit){
            for(String cadena: obtenerDigramas(text)){
                sumarContadorCadena(cadena, digramas);
                diccionario.tamañoTotal++;
            }
        }
        for(String text: textoSplit){
            for(String cadena: obtenerTrigramas(text)){
                sumarContadorCadena(cadena, trigramas);
                diccionario.tamañoTotal++;
            }
        }
        for(String text: textoSplit){
            for(String cadena: obtenerCuatrigramas(text)){
                sumarContadorCadena(cadena, cuatrigramas);
                diccionario.tamañoTotal++;
            }
        }
        for(String text: textoSplit){
            for(String cadena: obtenerPentagramas(text)){
                sumarContadorCadena(cadena, pentagramas);
                diccionario.tamañoTotal++;
            }
        }
        diccionario.letras = letras;
        diccionario.digrama = digramas;
        diccionario.trigrama = trigramas;
        diccionario.tetragrama = cuatrigramas;
        diccionario.pentagrama = pentagramas;
        diccionario.actualizarDiccionario();
        return diccionario.cadenas;
    }
    private static void sumarContadorCadena(String cadena, ArrayList<Cadena> listaCadenas){
        for(Cadena item: listaCadenas){
            if(item.cadena.equals(cadena)){
                item.contador = item.contador + 1;
                
                return;
            }
        }
        
        Cadena nueva = new Cadena(cadena);
        nueva.contador = nueva.contador + 1;
        listaCadenas.add(nueva);
    }
    private static ArrayList<String> obtenerLetras(String cadena){
        ArrayList<String> resultado = new ArrayList<>();
        resultado.addAll(Arrays.asList(cadena.split("")));
        return resultado;
    }
    private static ArrayList<String> obtenerDigramas(String cadena){
        ArrayList<String> resultado = new ArrayList<>();
        if(cadena.length() >= 2){    
            String[] arregloCadena = cadena.split("");
            for(int i =0; i < arregloCadena.length-1; i++)
                resultado.add(arregloCadena[i] + arregloCadena[i+1]);
        }
        return resultado;
    }
    private static ArrayList<String> obtenerTrigramas(String cadena){
        ArrayList<String> resultado = new ArrayList<>();
        if(cadena.length() >= 3){    
            String[] arregloCadena = cadena.split("");
            for(int i =0; i < arregloCadena.length-2; i++)
                resultado.add(arregloCadena[i] + arregloCadena[i+1] + arregloCadena[i+2]);
        }
        return resultado;
    }
    private static ArrayList<String> obtenerCuatrigramas(String cadena){
        ArrayList<String> resultado = new ArrayList<>();
        if(cadena.length() >= 4){    
            String[] arregloCadena = cadena.split("");
            for(int i =0; i < arregloCadena.length-3; i++)
                resultado.add(arregloCadena[i] + arregloCadena[i+1] + arregloCadena[i+2] + arregloCadena[i+3]);
        }
        return resultado;
    }
    private static ArrayList<String> obtenerPentagramas(String cadena){
        ArrayList<String> resultado = new ArrayList<>();
        if(cadena.length() >= 4){    
            String[] arregloCadena = cadena.split("");
            for(int i =0; i < arregloCadena.length-4; i++)
                resultado.add(arregloCadena[i] + arregloCadena[i+1] + arregloCadena[i+2] + arregloCadena[i+3] + arregloCadena[i+4]);
        }
        return resultado;
    }
}
