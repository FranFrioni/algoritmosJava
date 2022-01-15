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
public class Cola <T>{
    Nodo<T> primero;
    Nodo<T> ultimo;
    int tamaño;
    
    public Cola(){
        this.tamaño = 0;
        this.primero = this.ultimo = null;
    }
    
    public void encolar(T dato){
        if(this.estaVacio()){
            this.primero = this.ultimo = new Nodo<>(dato, null);
        } else {
            this.ultimo = this.ultimo.siguiente = new Nodo<>(dato, null);
        }
        this.tamaño++;
    }
    
    public T desencolar() throws Exepcion{
        if(this.estaVacio()){
            throw new Exepcion("No existe ningun elemento");
        }
        T res = this.primero.dato;
        this.primero = this.primero.siguiente;
        this.tamaño--;
        return res;
    }
    
    public T primero() throws Exepcion{
        if(this.estaVacio()){
            throw new Exepcion("No existe ningun elemento");
        }
        return this.primero.dato;
    }
    
    public boolean estaVacio(){
        return this.tamaño == 0;
    }
    
    public void limpiar(){
        this.tamaño = 0;
        this.primero = this.ultimo = null;
    }
    
    public int tamaño(){
        return this.tamaño;
    }
}
