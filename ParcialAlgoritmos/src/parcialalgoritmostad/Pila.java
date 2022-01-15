/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalgoritmostad;
/**
 *
 * @author Camila
 * @param <T>
 */
public class Pila <T>{
    private Nodo<T> cabecera;
    private int tamaño;
    
    public Pila(){
        this.cabecera = null;
        this.tamaño = 0;
    }
    
    public void apilar(T Dato) {
        if(this.estaVacio()){
            this.cabecera = new Nodo<>(Dato,null);
        }
        else{
            this.cabecera = new Nodo<>(Dato,this.cabecera);
        }
        this.tamaño++;
    }
    
    public T desapilar() throws Exepcion{
        if(this.estaVacio()){
            throw new Exepcion("No existe ningun elemento");
        }
        
        T res = this.cabecera.dato;
        this.cabecera = this.cabecera.siguiente;
        this.tamaño--;
        return res;
    }
    
    public T cima() throws Exepcion{
        if(this.estaVacio()){
             throw new Exepcion("No existe ningun elemento");
        }
        
        return this.cabecera.dato;
    }
    
    public boolean estaVacio() {
        return this.tamaño == 0;
    }
    
    public void vaciar() {
        this.cabecera = null;
        this.tamaño = 0;
    }
    
    public int tamaño() {
        return this.tamaño;
    }
}
