package co.edu.konradlorenz.model;

import java.util.HashMap;

public class ArbolBinario {
    private Nodo raiz;
    private HashMap<String, Contacto> listaContactos;

    public ArbolBinario() {
    }

    public ArbolBinario(Nodo raiz, HashMap<String, Contacto> listaContactos) {
        this.raiz = null;
        this.listaContactos = new HashMap<>();
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
    
    public void agregarContacto(Contacto contacto){
        if(!listaContactos.containsKey(contacto.getNombre())){
            raiz = agregarRecursivo(raiz, contacto);
            listaContactos.put(contacto.getNombre(), contacto);
        }
    }
    
    private Nodo agregarRecursivo(Nodo nodo, Contacto contacto){
        if(nodo == null){
            return new Nodo(contacto);
        }
        
        if(contacto.getNombre().compareToIgnoreCase(nodo.contacto.getNombre()) < 0){
            nodo.izquierdo = agregarRecursivo(nodo.izquierdo, contacto);
        }else if(contacto.getNombre().compareToIgnoreCase(nodo.contacto.getNombre()) > 0){
            nodo.derecho = agregarRecursivo(nodo.derecho, contacto);
        }
        return nodo;
    }
    
    public Contacto buscarContacto(String nombre){
        return listaContactos.get(nombre);
    }
    
    //submenu editar todo:)
    public void editarNombre(Contacto contacto, String dato){
        contacto.setNombre(dato);
    }
    
    public void editarTelefono(Contacto contacto, String dato){
        contacto.setTelefono(dato);
    }
    
    public void editarDireccion(Contacto contacto, String dato){
        contacto.setDireccion(dato);
    }
    
    public void editarCorreo(Contacto contacto, String dato){
        contacto.setCorreo(dato);
    }
    
    public void eliminarContacto(String nombre){
        if(listaContactos.containsKey(nombre)){
            raiz = eliminarRecursivo(raiz, nombre);
            listaContactos.remove(nombre);
        }
    }
    
    private Nodo eliminarRecursivo(Nodo nodo, String nombre){
        if(nodo==null){
            return null;
        }
        if (nombre.compareToIgnoreCase(nodo.contacto.getNombre())<0) {
            nodo.izquierdo= eliminarRecursivo(nodo.izquierdo, nombre);
        }else if(nombre.compareToIgnoreCase(nodo.contacto.getNombre())>0){
            nodo.derecho=eliminarRecursivo(nodo.derecho, nombre);
        }else{
            if (nodo.izquierdo==null) {
                return nodo.derecho;
            }
            if (nodo.derecho==null) {
                return nodo.izquierdo;
            }
            Nodo nodoTemp= encontrarMinimo(nodo.derecho);
            nodo.contacto= nodoTemp.contacto;
            nodo.derecho= eliminarRecursivo(nodo.derecho, nodoTemp.contacto.getNombre());
        }
        return nodo;
    }
    
    private Nodo encontrarMinimo(Nodo nodo){
        while (nodo.izquierdo!=null) {            
           nodo= nodo.izquierdo;
        }
        return nodo;
    }
    
    public void mostrarContactos(){
        mostrarInOrder(raiz);
    }
    
    private String mostrarInOrder(Nodo nodo){
        String imprimir="";
        if (nodo != null) {
            mostrarInOrder(nodo.izquierdo);
            imprimir= nodo.contacto.toString();
            mostrarInOrder(nodo.derecho);
        }
        return imprimir;
    }
    
}
