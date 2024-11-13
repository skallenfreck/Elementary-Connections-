package co.edu.konradlorenz.model;

public class HistorialCambios {
    private String campoModificado, valorAnterior, valorNuevo;

    public HistorialCambios() {
    }

    public HistorialCambios(String campoModificado, String valorAnterior, String valorNuevo) {
        this.campoModificado = campoModificado;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
    }

    public String getCampoModificado() {
        return campoModificado;
    }

    public void setCampoModificado(String campoModificado) {
        this.campoModificado = campoModificado;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    @Override
    public String toString() {
        return "CampoModificado=" + campoModificado + ", valorAnterior=" + valorAnterior + ", valorNuevo=" + valorNuevo + '.';
    }
    
    
}
