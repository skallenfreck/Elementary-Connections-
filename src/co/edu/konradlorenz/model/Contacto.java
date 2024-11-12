
package co.edu.konradlorenz.model;

public class Contacto {
    private String nombre, direccion, correo, telefono;
    private int cantLlamadas;

    public Contacto() {
    }

    public Contacto(String nombre, String direccion, String correo, String telefono, int cantLLamadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.cantLlamadas= cantLLamadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantLlamadas() {
        return cantLlamadas;
    }

    public void setCantLlamadas(int cantLlamadas) {
        this.cantLlamadas = cantLlamadas;
    }
    public String llamar(){
        String llamado = "Llamando a "+nombre
                +"\n"+telefono;
        return llamado;
    }
    
    public String enviarMensaje(String mensaje){
        String envio = "Mensaje: "+mensaje
                +"\nEnviado exitosamente a "+nombre;
        return envio;
    }
    
    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", cantLlamadas=" + cantLlamadas + '}';
    } 
}
