/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalgoritmos;
import java.util.*;
/**
 *
 * @author Camila
 */
public class ParcialAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        GestoraSatelites gestoraSatelites = GestoraSatelites.getInstancia();
        int opcion;
        do{
            System.out.println("//MENU//\n 1)Agregar satélite.\n 2)Buscar satélite.\n 3)Eliminar satélite.\n 4)Listar satélites desde más reciente.\n 5)Listar satélites desde más antiguo.\n 0)Salir.");
            opcion = scanner.nextInt();
            if(opcion == 1){
                System.out.println("Ingresar código.");
                int codigo = scanner.nextInt();
                System.out.println("Ingresar nombre.");
                String nombre = scanner.next();
                System.out.println("Ingresar altitud.");
                int altitud = scanner.nextInt();
                gestoraSatelites.agregarSatelite(codigo, nombre, altitud);
                System.out.println("Satélite ingresado con éxito!");
            } else if (opcion == 2){
                System.out.println("Ingresar código.");
                int codigo = scanner.nextInt();
                System.out.println(gestoraSatelites.buscarSatelite(codigo));
            } else if (opcion == 3){
                System.out.println("Ingresar código.");
                int codigo = scanner.nextInt();
                if(gestoraSatelites.eliminarSatelite(codigo)){
                    System.out.println("Satélite eliminado con éxito.");
                } else {
                    System.out.println("No se encuentra satelite de codigo " + codigo + ".");
                }
            } else if (opcion == 4){
                gestoraSatelites.listarSatelitesPila();
            } else if (opcion == 5){
                gestoraSatelites.listarSatelitesCola();
            } else if (opcion != 0){
                System.out.println("El comando recibido es erroneo.");
            }
        } while (opcion != 0);
    }
}
