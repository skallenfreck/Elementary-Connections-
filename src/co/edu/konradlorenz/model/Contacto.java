
package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Contacto {
    private String nombre, direccion, correo, telefono;
    private int cantLlamadas;
    private ArrayList<HistorialCambios> historialCambios;

    public Contacto() {
    }

    public Contacto(String nombre, String direccion, String correo, String telefono, int cantLLamadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.cantLlamadas= cantLLamadas;
        this.historialCambios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!this.nombre.equalsIgnoreCase(nombre)){
            historialCambios.add(new HistorialCambios("Nombre", this.nombre, nombre));
            this.nombre = nombre;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(!this.direccion.equalsIgnoreCase(direccion)){
            historialCambios.add(new HistorialCambios("Direccion", this.direccion, direccion));
            this.direccion = direccion;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(!this.correo.equalsIgnoreCase(correo)){
            historialCambios.add(new HistorialCambios("Correo", this.correo, correo));
            this.correo = correo;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(!this.telefono.equals(telefono)){
            historialCambios.add(new HistorialCambios("Telefono", this.telefono, telefono));
            this.telefono = telefono;
        }
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
    
    public String mostrarHistorialCambios(){
        String mensaje = "";
        if(historialCambios.isEmpty()){
            mensaje = "No hay cambios registrados para el contacto.";
        }else{
            for(HistorialCambios cambio : historialCambios){
                mensaje = "- "+cambio;
            }
        }
        return mensaje;
    }
    
    public ArrayList<HistorialCambios> getHistorialCambios(){
        return historialCambios;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", cantLlamadas=" + cantLlamadas + ", historialCambios=" + historialCambios + '}';
    }
   
}
