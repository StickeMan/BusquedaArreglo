package busquedaarreglo2022;

import java.util.Scanner;

public class BusquedaArreglo2022 {

    static public int[] ordenamientoSeleccion(int valores[]){
        int min;
        int aux;
        for (int i = 0; i < valores.length; i++) {
            min=i;
            for(int j=i+1; j<valores.length; j++){
                if(valores[j]<valores[min])
                    min=j;                
            }
            if (i!=min) {
                aux=valores[i];
                valores[i]=valores[min];
                valores[min]=aux;
            }            
        }
        return valores;
    }
            
    static public int buscarValor(int valores[], int DatoBuscar){
        valores = ordenamientoSeleccion(valores);
        
        int inicio = 0;
        int fin = valores.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( valores[pos] == DatoBuscar )
                return pos;
            else 
                if ( valores[pos] < DatoBuscar ) {
                    inicio = pos+1;
                }else {
                    fin = pos-1;
                }
        }
        return -1;                                 
    }
    
    static public int[] leerArreglo(){        
        Scanner in = new Scanner (System.in);               
        System.out.println("Introduce el tamaño del arreglo a utilizar");
        int tamanio = in.nextInt();
                
        int arreglo[]= new int[tamanio];
                
        System.out.println("Introduce los "+tamanio+" valores necesarios");
        for(int i=0; i<arreglo.length; i++){
            System.out.print("Valor "+(i+1)+" : ");
            arreglo[i]= in.nextInt();
        }           
                    
        return arreglo;
    }
            
    public static void main(String[] args) {                        
        int arreglo[] = leerArreglo();
        int posicion;
        Scanner in = new Scanner (System.in);               
        System.out.println("Introduce el valor a buscar");
        int valorBuscar = in.nextInt();
        
        
        posicion=buscarValor(arreglo,valorBuscar);
        if(posicion<0)
            System.out.println("No se encontró el dato");
        else
            System.out.println("El dato se encuentra en la pos: "+(posicion+1));
    }
    
}
