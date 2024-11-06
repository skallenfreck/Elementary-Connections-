package co.edu.konradlorenz.model;

public class Nodo {
    public Contacto contacto;
    public Nodo izquierdo, derecho;

    public Nodo(Contacto contacto) {
        this.contacto = contacto;
        this.izquierdo = null;
        this.derecho = null;
    }
}
