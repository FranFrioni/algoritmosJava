/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalgoritmos;
import parcialalgoritmostad.*;
/**
 *
 * @author Camila
 */
public class GestoraSatelites {
    static GestoraSatelites singleton;
    private final Cola<Satelite> satelitesCola;
    private final Pila<Satelite> satelitesPila;
    
    
    private GestoraSatelites(){
        satelitesCola = new Cola<>();
        satelitesPila = new Pila<>();
    }
    
    public static GestoraSatelites getInstancia(){
        if (singleton == null) {
            singleton = new GestoraSatelites();
        }
        return singleton;
    }
    
    public void agregarSatelite(int codigo, String nombre, int altitud){
        Satelite satelite = new Satelite(codigo, nombre, altitud);
        satelitesCola.encolar(satelite);
        satelitesPila.apilar(satelite);
    }
    
    public boolean eliminarSatelite(int codigo){
        try{
            Pila<Satelite> satelitesPilaCopia = new Pila<>();
            boolean flag = true;
            boolean vacio = false;
            while(flag && !vacio){
                Satelite satelitePila = satelitesPila.desapilar();
                if(satelitePila.getCodigo() != codigo){
                    satelitesPilaCopia.apilar(satelitePila);
                    if (satelitesPila.tamaño() == 0){
                        vacio = true;
                    }
                } else {
                    flag = false;
                }
            }
            while (satelitesPilaCopia.tamaño() > 0){
                Satelite satelite = satelitesPilaCopia.desapilar();
                satelitesPila.apilar(satelite);
            }
            Cola<Satelite> satelitesColaCopia = new Cola<>();
            while (satelitesCola.tamaño() > 0) {
                Satelite sateliteCola = satelitesCola.desencolar();
                if(sateliteCola.getCodigo() != codigo){
                    satelitesColaCopia.encolar(sateliteCola);
                }
            }
            while (satelitesColaCopia.tamaño() > 0){
                Satelite satelite = satelitesColaCopia.desencolar();
                satelitesCola.encolar(satelite);
            }
            if(!flag){
                return true;
            }
        } catch (Exepcion ex){
        }
        return false;
    }

    public String buscarSatelite(int codigo){
        try{
            Pila<Satelite> satelitesPilaCopia = new Pila<>();
            while(satelitesPila.tamaño() > 0){
                Satelite satelite = satelitesPila.desapilar();
                if(satelite.getCodigo() != codigo){
                    satelitesPilaCopia.apilar(satelite);
                    if (satelitesPila.tamaño() == 0){
                        while (satelitesPilaCopia.tamaño() > 0){
                            Satelite sateliteAux = satelitesPilaCopia.desapilar();
                        satelitesPila.apilar(sateliteAux);
                        }
                        return "No se encuentra satelite de codigo " + codigo + ".";
                    }
                } else {
                    System.out.println("Satélite encontrado:");
                    satelitesPilaCopia.apilar(satelite);
                    while (satelitesPilaCopia.tamaño() > 0){
                        Satelite sateliteAux = satelitesPilaCopia.desapilar();
                        satelitesPila.apilar(sateliteAux);
                    }
                    return satelite.toString();
                }
            }
        } catch (Exepcion ex){
        }
        return "No se encuentra satelite de codigo " + codigo + ".";
    }
    
    public void listarSatelitesPila(){
        if(!satelitesPila.estaVacio()){
            try{
                System.out.println("Listando satélites desde más reciente:");
                Pila<Satelite> satelitesPilaCopia = new Pila<>();
                while(satelitesPila.tamaño() > 0){
                    Satelite satelite = satelitesPila.desapilar();
                    satelitesPilaCopia.apilar(satelite);
                    System.out.println(satelite.toString());
                }
                while (satelitesPilaCopia.tamaño() > 0){
                    Satelite satelite = satelitesPilaCopia.desapilar();
                    satelitesPila.apilar(satelite);
                }
            } catch (Exepcion ex){
                System.out.println(ex);
            }
        } else {
            System.out.println("Aún no se agregó ningun satélite al sistema.");
        }
    }
    
    public void listarSatelitesCola(){
        if (!satelitesCola.estaVacio()){
            System.out.println("Listando satélites desde más antiguo:");
            try{
                Cola<Satelite> satelitesColaCopia = new Cola<>();
                while(satelitesCola.tamaño() > 0){
                    Satelite satelite = satelitesCola.desencolar();
                    satelitesColaCopia.encolar(satelite);
                    System.out.println(satelite.toString());
                }
                while (satelitesColaCopia.tamaño() > 0){
                    Satelite satelite = satelitesColaCopia.desencolar();
                    satelitesCola.encolar(satelite);
                }
            } catch (Exepcion ex){
                System.out.println(ex);
            }
        } else {
            System.out.println("Aún no se agregó ningun satélite al sistema.");
        }
    }
}
