package co.edu.konradlorenz.model;

import java.util.HashMap;

public class ArbolBinario {

    private Nodo raiz;
    private HashMap<String, Contacto> listaContactos = new HashMap<>();

    public ArbolBinario() {
    }

    public ArbolBinario(Nodo raiz, HashMap<String, Contacto> listaContactos) {
        this.raiz = raiz;
        this.listaContactos = listaContactos;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public HashMap<String, Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(HashMap<String, Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public void agregarContacto(Contacto contacto) {
        if (!listaContactos.containsKey(contacto.getNombre())) {
            raiz = agregarRecursivo(raiz, contacto);
            listaContactos.put(contacto.getNombre(), contacto);
        }
    }

    private Nodo agregarRecursivo(Nodo nodo, Contacto contacto) {
        // Si el nodo actual es null, significa que hemos llegado a un punto de inserción
        if (nodo == null) {
            return new Nodo(contacto);
        }

        // Comparar el nombre del contacto a agregar con el del nodo actual
        int comparacion = contacto.getNombre().compareToIgnoreCase(nodo.contacto.getNombre());

        if (comparacion < 0) {
            // Si el nombre del contacto es menor, recorrer hacia el subárbol izquierdo
            nodo.izquierdo = agregarRecursivo(nodo.izquierdo, contacto);
        } else if (comparacion > 0) {
            // Si el nombre del contacto es mayor, recorrer hacia el subárbol derecho
            nodo.derecho = agregarRecursivo(nodo.derecho, contacto);
        } else {
            // Si el nombre ya existe en el árbol (comparacion == 0), no hacemos nada
            // y simplemente retornamos el nodo existente para evitar duplicados
            return nodo;
        }

        return nodo; // Retornar el nodo actual después de la operación
    }

    public Contacto buscarContactoNom(String nombre) {
        return listaContactos.get(nombre);
    }
    
    public Contacto buscarContactoNum(String telefono){
        for (Contacto contacto : listaContactos.values()) {
            if (contacto.getTelefono().equalsIgnoreCase(telefono)) {
                return contacto;
            }
        }
        return null;
    }

    //submenu editar todo:)
    public void editarNombre(Contacto contacto, String nuevoNombre) {
        // Paso 1: Eliminar el contacto del HashMap y del árbol binario con el nombre original
        listaContactos.remove(contacto.getNombre());
        raiz = eliminarRecursivo(raiz, contacto.getNombre());

        // Paso 2: Actualizar el nombre del contacto
        contacto.setNombre(nuevoNombre);

        // Paso 3: Agregar el contacto actualizado al HashMap y al árbol binario
        listaContactos.put(nuevoNombre, contacto);
        raiz = agregarRecursivo(raiz, contacto);
    }

    public void editarTelefono(Contacto contacto, String nuevoTelefono) {
        contacto.setTelefono(nuevoTelefono); // Actualiza solo el teléfono
        // No hace falta eliminar y reinsertar en el HashMap y árbol binario
    }

    public void editarDireccion(Contacto contacto, String nuevaDireccion) {
        contacto.setDireccion(nuevaDireccion); // Actualiza solo la dirección
        // No hace falta eliminar y reinsertar en el HashMap y árbol binario
    }

    public void editarCorreo(Contacto contacto, String nuevoCorreo) {
        contacto.setCorreo(nuevoCorreo); // Actualiza solo el correo
        // No hace falta eliminar y reinsertar en el HashMap y árbol binario
    }

    public void eliminarContacto(String nombre) {
        if (listaContactos.containsKey(nombre)) {
            raiz = eliminarRecursivo(raiz, nombre);
            listaContactos.remove(nombre);
        }
    }

    private Nodo eliminarRecursivo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nombre.compareToIgnoreCase(nodo.contacto.getNombre()) < 0) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, nombre);
        } else if (nombre.compareToIgnoreCase(nodo.contacto.getNombre()) > 0) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, nombre);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            Nodo nodoTemp = encontrarMinimo(nodo.derecho);
            nodo.contacto = nodoTemp.contacto;
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodoTemp.contacto.getNombre());
        }
        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public void mostrarContactos() {
        mostrarInOrder(raiz);
    }

    private void mostrarInOrder(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrder(nodo.izquierdo);
            System.out.println(nodo.contacto.toString());  // Imprimir directamente o usar StringBuilder
            mostrarInOrder(nodo.derecho);
        }
    }
}
