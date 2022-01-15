/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalgoritmos;

/**
 *
 * @author Camila
 */
public class Satelite {
    private int codigo;
    private String nombre;
    private int altitud;
    private TipoOrbita orbita;
    
    public Satelite(int codigo, String nombre, int altitud){
        this.codigo = codigo;
        this.nombre = nombre;
        this.altitud = altitud;
        if(altitud <= 2000){
            this.orbita = TipoOrbita.Baja;
        } else if (altitud <= 35000){
            this.orbita = TipoOrbita.Media;
        } else {
            this.orbita = TipoOrbita.Alta;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public TipoOrbita getOrbita() {
        return orbita;
    }

    public void setOrbita(TipoOrbita orbita) {
        this.orbita = orbita;
    }
    
    @Override
    public String toString(){
        return "Satélite: [Código: " + this.codigo + "], [Nombre: " + this.nombre + "], [Altitud: " + this.altitud + "], [Orbita: " + this.orbita + "]";
    }
}
