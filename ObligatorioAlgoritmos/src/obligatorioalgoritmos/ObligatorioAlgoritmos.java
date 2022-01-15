/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorioalgoritmos;

import java.util.Scanner;

/**
 *
 * @author Camila
 */
public class ObligatorioAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {1,7,4,6,10};
        obligatorioMetodo(arr, 4);
    }
    
    public static void obligatorioMetodo(int[] arr, int num){
        int i;
        Scanner scanner = new Scanner(System.in);
        listarNumeros(arr, 0);
        if (esAscendente(arr, 0, arr[0])){
            System.out.println("\nEl arreglo obtenido esta ordenado de forma ascendente.");
            i = busquedaBinaria(arr, 0, arr.length-1, num);
        } else if (esDescendente(arr, 0, arr[0])){
            System.out.println("\nEl arreglo obtenido esta ordenado de forma descendente.");
            i = busquedaBinaria(arr, 0, arr.length-1, num);
        } else {
            System.out.println("\nEl arreglo obtenido esta desordenado.");
            System.out.println("¿Como desea ordenar el arreglo? Para ascendente usar A, para descendente usar D.");
            String ordenarComo = scanner.next();
            if ("A".equals(ordenarComo)){
                System.out.println("Se ordenó el arreglo de forma ascendente:");
                insertionSort(arr);
                listarNumeros(arr, 0);
                i = busquedaBinaria(arr, 0, arr.length-1, num);
            } else {
                System.out.println("Se ordenó el arreglo de forma descendente:");
                insertionSort(arr);
                listarNumeros(arr, 0);
                i = busquedaBinaria(arr, 0, arr.length-1, num);
            }
        }
        if (i >= 0){
            System.out.println("\nEl número " + arr[i] + " se encuentra almacenado en la posición " + i + " del arreglo.");
        } else {
            System.out.println("\nEl numero " + num + " no se encuentra almacenado en el arreglo.");   
        }
    }
    
    public static void listarNumeros(int[] arr, int num){
        if(num == arr.length-1){
            System.out.print(arr[num] + " ");
        } else {
            System.out.print(arr[num] + " ");
            listarNumeros(arr, num+1);
        }
    }
    
    public static boolean esAscendente(int[] arr, int index, int aux){
        if(index == arr.length-1){
            return aux < arr[index];
        } else {
            if(aux > arr[index]){
                return false;
            } else {
                return esAscendente(arr, index+1, arr[index]);
            }
        }
    }
    public static boolean esDescendente(int[] arr, int index, int aux){
        if(index == arr.length-1){
            return aux > arr[index];
        } else {
            if(aux < arr[index]){
                return false;
            } else {
                return esDescendente(arr, index+1, arr[index]);
            }
        }
    }
    
    public static void insertionSort (int[] arr){ 
	for (int i = 1; i < arr.length; i++) { 
            int aux = arr[i];
            int j = i - 1;
            if(esAscendente(arr, 0, arr[0])){
                while (j >= 0 && arr[j] > aux){
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = aux;
            } else {
                while (j >= 0 && arr[j] < aux){
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = aux;
            }
	} 
    }
    
    public static int busquedaBinaria(int[] arr, int desde, int hasta, int num){
        if(desde > hasta){
            return -1;
        }
        if(desde == hasta){
            if(arr[desde] == num){
                return desde;
            } else {
                return -1;
            }
        }
        if(arr[(desde+hasta)/2] == num){
            return (desde+hasta)/2;
        } else if (esAscendente(arr, 0, arr[0])){
            if (num < arr[(desde+hasta)/2]){
                return busquedaBinaria(arr, desde, ((desde+hasta)/2)-1, num);
            } else {
                return busquedaBinaria(arr, ((desde+hasta)/2)+1, hasta, num);
            }
        } else {
            if (num > arr[(desde+hasta)/2]){
                return busquedaBinaria(arr, desde, ((desde+hasta)/2)-1, num);
            } else {
                return busquedaBinaria(arr, ((desde+hasta)/2)+1, hasta, num);
            }
        }
    }
}
