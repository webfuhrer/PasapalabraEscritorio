/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasapalabraescritorio;

/**
 *
 * @author luis
 */
public class Pregunta {
    private String posicion, letra, definicion, solucion;

    public Pregunta(String posicion, String letra, String definicion, String solucion) {
        this.posicion = posicion;
        this.letra = letra;
        this.definicion = definicion;
        this.solucion = solucion;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getLetra() {
        return letra;
    }

    public String getDefinicion() {
        return definicion;
    }

    public String getSolucion() {
        return solucion;
    }
    public String crearPreguntaCompleta()
    {
        String aux=posicion+" "+letra+": "+definicion;
        return aux;
    }
    
}
