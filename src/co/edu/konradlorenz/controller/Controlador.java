package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.ArbolBinario;
import co.edu.konradlorenz.model.Contacto;
import co.edu.konradlorenz.view.Ventana;
import java.util.ArrayList;

public class Controlador {
    
    private ArbolBinario arbol = new ArbolBinario();
    
    public void run() {
        boolean salir = false;
        while (!salir) {
            int opcion = Ventana.menu();
            ejemplos();
            switch (opcion) {
                case 1: //Agregar Contacto
                    agregarContacto();
                    break;
                case 2: // Modificar contacto
                    switchEditar(opcion);
                    break;
                
                case 3: // Mostrar Contactos
                    mostrarContacto();
                    break;
                case 4: // Buscar contacto
                    buscarContacto();
                    break;
                case 5: // Llamar
                    realizarLlamada(opcion);
                    break;
                case 6: // Mensaje
                    enviarMensaje(opcion);
                    break;
                case 7: // Eliminar contacto
                    eliminarContacto();
                    break;
                case 8://salir
                    salir = true;
                    Ventana.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    Ventana.mostrarMensaje("Opcion invalida, por favor intente de nuevo;");
            }
        }
        
    }
    
    public void ejemplos() {
        arbol.agregarContacto(new Contacto("Juan Perez", "Calle 123", "juan@example.com", "3001234567", 0));
        arbol.agregarContacto(new Contacto("Maria Gomez", "Carrera 45", "maria@example.com", "3107654321", 0));
        arbol.agregarContacto(new Contacto("Carlos Lopez", "Avenida 9", "carlos@example.com", "3159876543", 0));
        arbol.agregarContacto(new Contacto("Ana Torres", "Calle 8", "ana@example.com", "3201239876", 0));
        arbol.agregarContacto(new Contacto("Luis Ramírez", "Transversal 22", "luis@example.com", "3004567890", 0));
    }
    
    public void switchEditar(int opcion) {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos para editar.");
        } else {
            String nombreModificar = Ventana.pedirString("Ingrese el nombre del contacto a editar");
            if (arbol.buscarContactoNom(nombreModificar) != null) {
                Contacto contactoModificar = arbol.buscarContactoNom(nombreModificar);
                while (true) {
                    opcion = Ventana.menuEditar();
                    switch (opcion) {
                        case 1: // Editar nombre
                            String nuevoNombre = Ventana.pedirString("Por favor ingrese el nuevo nombre del contacto: ");
                            arbol.editarNombre(contactoModificar, nuevoNombre);
                            break;
                        case 2: // Editar teléfono
                            String nuevoTelefono = Ventana.pedirString("Por favor ingrese el número telefónico del contacto: ");
                            arbol.editarTelefono(contactoModificar, nuevoTelefono);
                            break;
                        case 3: // Editar dirección
                            String nuevaDireccion = Ventana.pedirString("Por favor ingrese la nueva dirección del contacto: ");
                            arbol.editarDireccion(contactoModificar, nuevaDireccion);
                            break;
                        case 4: // Editar correo
                            String nuevoCorreo = Ventana.pedirString("Por favor ingrese el correo del contacto: ");
                            arbol.editarCorreo(contactoModificar, nuevoCorreo);
                            break;
                        case 5: // Salir del menú de edición
                            Ventana.mostrarMensaje("Saliendo del menú <><><>Editar Contacto<><><>");
                            break;
                        default:
                            Ventana.mostrarMensaje("Esa opción no está disponible, intenta de nuevo.");
                    }
                    if (opcion == 5) {
                        break;
                    }
                }
            } else {
                Ventana.mostrarMensaje("Contacto no encontrado.");
            }
        }
        
    }
    
    public void agregarContacto() {
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setCantLlamadas(0);
        String var = Ventana.pedirString("Ingrese por favor el nombre del contacto: ");
        nuevoContacto.setNombre(var);
        var = Ventana.pedirString("Ingrese por favor el correo del contacto: ");
        nuevoContacto.setCorreo(var);
        var = Ventana.pedirString("Ingrese por favor la direccion del contacto: ");
        nuevoContacto.setDireccion(var);
        var = Ventana.pedirString("Ingrese por favor el numero telefonico del contacto: ");
        nuevoContacto.setTelefono(var);
        arbol.agregarContacto(nuevoContacto);
        Ventana.mostrarMensaje("Contacto agregado correctamente");
    }
    
    public void mostrarContacto() {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos creados.");
        } else {
            arbol.mostrarContactos();
        }
    }
    
    public void buscarContacto() {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos para buscar.");
        } else {
            String nombreBusqueda = Ventana.pedirString("Ingrese el nombre del contacto que desea buscar");
            Contacto contactoBusqueda = arbol.buscarContactoNom(nombreBusqueda);
            if (contactoBusqueda != null) {
                Ventana.mostrarMensaje(contactoBusqueda.toString());
            } else {
                Ventana.mostrarMensaje("Contacto no encontrado.");
            }
        }
    }
    
    public void eliminarContacto() {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos para eliminar.");
        } else {
            String nombreEliminar = Ventana.pedirString("Ingrese el nombre del contacto que desea eliminar");
            if (arbol.buscarContactoNom(nombreEliminar) != null) {
                arbol.eliminarContacto(nombreEliminar);
                Ventana.mostrarMensaje("Contacto eliminado correctamente");
            } else {
                Ventana.mostrarMensaje("Contacto no encontrado.");
            }
        }
    }
    
    public void realizarLlamada(int opcion) {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos para llamar.");
        } else {
            while (true) {
                opcion = Ventana.menuLlamada();
                switch (opcion) {
                    case 1:
                        contactosFavoritos();
                        String nombre = Ventana.pedirString("Ingrese el nombre del contacto para llamar: ");
                        Contacto contactoUno = arbol.buscarContactoNom(nombre);
                        if (contactoUno != null) {
                            Ventana.mostrarMensaje(contactoUno.llamar());
                            contactoUno.setCantLlamadas(contactoUno.getCantLlamadas() + 1);
                        } else {
                            Ventana.mostrarMensaje("Contacto no encontrado.");
                        }
                        break;
                    case 2:
                        contactosFavoritos();
                        String telefono = Ventana.pedirString("Ingrese el telefono del contacto para llamar: ");
                        Contacto contactoDos = arbol.buscarContactoNum(telefono);
                        if (contactoDos != null) {
                            Ventana.mostrarMensaje(contactoDos.llamar());
                            contactoDos.setCantLlamadas(contactoDos.getCantLlamadas() + 1);
                        }else{
                            Ventana.mostrarMensaje("Contacto no encontrado.");
                        }
                        break;
                    case 3:
                        Ventana.mostrarMensaje("Saliendo del menú <><><>Llamar a un contacto<><><>");
                        break;
                    default:
                        Ventana.mostrarMensaje("Opción invalida, intente otra vez.");
                }
                if (opcion == 3) {
                    break;
                }
            }
        }
    }
    
    public void enviarMensaje(int opcion) {
        if (arbol.getListaContactos().isEmpty()) {
            Ventana.mostrarMensaje("No hay contactos para llamar.");
        } else {
            while (true) {
                opcion = Ventana.menuMensaje();
                switch (opcion) {
                    case 1:
                        contactosFavoritos();
                        String nombre = Ventana.pedirString("Ingrese el nombre del contacto enviar mensaje: ");
                        Contacto contactoUno = arbol.buscarContactoNom(nombre);
                        if (contactoUno != null) {
                            String mensaje= Ventana.pedirString("Ingrese el mensaje que desea enviar");
                            Ventana.mostrarMensaje(contactoUno.enviarMensaje(mensaje));
                            contactoUno.setCantLlamadas(contactoUno.getCantLlamadas() + 1);
                        } else {
                            Ventana.mostrarMensaje("Contacto no encontrado.");
                        }
                        break;
                    case 2:
                        contactosFavoritos();
                        String telefono = Ventana.pedirString("Ingrese el telefono del contacto para enviar mensaje: ");
                        Contacto contactoDos = arbol.buscarContactoNum(telefono);
                        if (contactoDos != null) {
                            String mensaje= Ventana.pedirString("Ingrese el mensaje que desea enviar");
                            Ventana.mostrarMensaje(contactoDos.enviarMensaje(mensaje));
                            contactoDos.setCantLlamadas(contactoDos.getCantLlamadas() + 1);
                        }else{
                            Ventana.mostrarMensaje("Contacto no encontrado.");  
                        }
                        break;
                    case 3:
                        Ventana.mostrarMensaje("Saliendo del menú <><><>Enviar mensaje a un contacto<><><>");
                        break;
                    default:
                        Ventana.mostrarMensaje("Opción invalida, intente otra vez.");
                }
                if (opcion == 3) {
                    break;
                }
            }
        }
    }
    
    public void contactosFavoritos() {
        boolean a=false;
        for (Contacto contacto : arbol.getListaContactos().values()) {
            if (contacto.getCantLlamadas()>0) {
                a =true;
                break;
            }
        }
        if (!a) {
            Ventana.mostrarMensaje("No se ha comunicado con ningún contacto hasta ahora.");
        } else {
            ArrayList<Contacto> contactosComparar = new ArrayList<>(arbol.getListaContactos().values());
            
            for (int i = 0; i < contactosComparar.size() - 1; i++) {
                for (int j = i + 1; j < contactosComparar.size(); j++) {
                    if (contactosComparar.get(i).getCantLlamadas() < contactosComparar.get(j).getCantLlamadas()) {
                        Contacto temp = contactosComparar.get(i);
                        contactosComparar.set(i, contactosComparar.get(j));
                        contactosComparar.set(j, temp);
                    }
                }
            }
            
            Ventana.mostrarMensaje("Tus contactos más frecuentes son: ");
            for (int k = 0; k < contactosComparar.size() && k < 3; k++) {
                if (contactosComparar.get(k).getCantLlamadas()>0) {
                    Ventana.mostrarMensaje("[" + (k + 1) + "] " + contactosComparar.get(k).getNombre()
                        + " con un total de " + contactosComparar.get(k).getCantLlamadas() + " veces que te has comunicado.");
                }
            }
        }
    }
}
