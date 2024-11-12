package co.edu.konradlorenz.view;

import java.util.Scanner;

public class Ventana {

    static Scanner sc = new Scanner(System.in);

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static byte menu() {
        System.out.println("<><><><><><><><><><><><><><><>"
                + "\n<> 1. Agregar contacto      <>"
                + "\n<> 2. Modificar contacto    <>"
                + "\n<> 3. Mostrar contactos     <>"
                + "\n<> 4. Buscar contacto       <>"
                + "\n<> 5. Realizar llamada      <>"
                + "\n<> 6. Enviar mensaje        <>"
                + "\n<> 7. Eliminar contacto     <>"
                + "\n<> 8. Salir                 <>"
                + "\n<><><><><><><><><><><><><><><>");
        byte opcion = sc.nextByte();
        sc.nextLine();
        return opcion;
    }

    public static byte menuEditar() {
        System.out.println("<><><><><><><><><><><><><><><>"
                + "\n<> 1. Editar nombre         <>"
                + "\n<> 2. Editar telefono       <>"
                + "\n<> 3. Editar direccion      <>"
                + "\n<> 4. Editar correo         <>"
                + "\n<> 5. Volver                <>"
                + "\n<><><><><><><><><><><><><><><>");
        byte opcion = sc.nextByte();
        sc.nextLine();
        return opcion;
    }
    
    public static byte menuLlamada(){
        System.out.println("<><><><><><><><><><><><><><><><><><><><>"
                + "\n<> 1. Llamar por nombre               <>"
                + "\n<> 2. Llamar por número telefonico   <>"
                + "\n<> 3. Volver                          <>"
                + "\n<><><><><><><><><><><><><><><><><><><><>");
        byte opcion= sc.nextByte();
        sc.nextLine();
        return opcion;
    }
    
    public static byte menuMensaje(){
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>"
                + "\n<> 1. Enviar mensaje por nombre              <>"
                + "\n<> 2. Enviar mensaje por número telefonico   <>"
                + "\n<> 3. Volver                                 <>"
                + "\n<><><><><><><><><><><><><><><><><><><><><><><><>");
        byte opcion= sc.nextByte();
        sc.nextLine();
        return opcion;
    }
}
