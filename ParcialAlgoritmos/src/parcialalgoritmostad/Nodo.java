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
public class Nodo <T>{
    public T dato;
    public Nodo<T> siguiente;
    
    public Nodo(T dato){
        this(dato,null);
    }
    
    public Nodo(T dato, Nodo<T> siguiente)
    {
        this.dato = dato;
        this.siguiente = siguiente;
    }
}
