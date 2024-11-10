package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.ArbolBinario;
import co.edu.konradlorenz.model.Contacto;
import co.edu.konradlorenz.view.Ventana;

public class Controlador {

    private ArbolBinario arbol = new ArbolBinario();

    public void run() {
        boolean salir = false;
        while (!salir) {
            int opcion = Ventana.menu();
            switch (opcion) {
                case 1: //Agregar Contacto
                    Contacto nuevoContacto = new Contacto();
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
                    break;
                case 2: // Modificar contacto
                    if (arbol.getListaContactos().isEmpty()) {
                        Ventana.mostrarMensaje("No hay contactos para editar.");
                    } else {
                        String nombreModificar = Ventana.pedirString("Ingrese el nombre del contacto a editar");
                        if (arbol.buscarContacto(nombreModificar) != null) {
                            Contacto contactoModificar = arbol.buscarContacto(nombreModificar);
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
                    break;

                case 3: // Mostrar Contactos
                    if (arbol.getListaContactos().isEmpty()) {
                        Ventana.mostrarMensaje("No hay contactos creados.");
                    } else {
                        arbol.mostrarContactos();
                    }
                    break;
                case 4: // Buscar contacto
                    if (arbol.getListaContactos().isEmpty()) {
                        Ventana.mostrarMensaje("No hay contactos para buscar.");
                    } else {
                        String nombreBusqueda = Ventana.pedirString("Ingrese el nombre del contacto que desea buscar");
                        Contacto contactoBusqueda = arbol.buscarContacto(nombreBusqueda);
                        if (contactoBusqueda != null) {
                            Ventana.mostrarMensaje(contactoBusqueda.toString());
                        } else {
                            Ventana.mostrarMensaje("Contacto no encontrado.");
                        }
                    }
                    break;
                case 5: // Eliminar contacto
                    if (arbol.getListaContactos().isEmpty()) {
                        Ventana.mostrarMensaje("No hay contactos para eliminar.");
                    } else {
                        String nombreEliminar = Ventana.pedirString("Ingrese el nombre del contacto que desea eliminar");
                        if (arbol.buscarContacto(nombreEliminar) != null) {
                            arbol.eliminarContacto(nombreEliminar);
                            Ventana.mostrarMensaje("Contacto eliminado correctamente");
                        } else {
                            Ventana.mostrarMensaje("Contacto no encontrado.");
                        }
                    }
                    break;
                case 6://salir
                    salir = true;
                    Ventana.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    Ventana.mostrarMensaje("Opcion invalida, por favor intente de nuevo;");
            }
        }

    }
}
