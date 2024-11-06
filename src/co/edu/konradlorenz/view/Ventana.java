package co.edu.konradlorenz.view;

import java.util.Scanner;

public class Ventana {
    static Scanner sc = new Scanner(System.in);
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    } 
    
    public static String pedirString(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }
    
    public static byte menu(){
        System.out.println("<><><><><><><><><><><><><><><>"
                + "\n<> 1. Agregar contacto      <>"
                + "\n<> 2. Modificar contacto    <>"
                + "\n<> 3. Mostrar contactos     <>"
                + "\n<> 4. Eliminar contacto     <>"
                + "\n<> 5. Salir                 <>"
                + "\n<><><><><><><><><><><><><><><>");
        return sc.nextByte();
    }
    
    public static long pedirLong(String mensaje){
        System.out.println(mensaje);
        return sc.nextLong();
    }
}
