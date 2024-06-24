package Models.Nodos;

public class Nodo_Usuario {
 
    private String nombre;
    private String identificacion;
    private String celular;
    private String correo;
    private String nombreJugardor;
    private String clave;
    private Nodo_Usuario sig, ant;

    public Nodo_Usuario(String nombre, String identificacion, String celular, String correo, String nombreJugardor, String clave, Nodo_Usuario sig, Nodo_Usuario ant) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.celular = celular;
        this.correo = correo;
        this.nombreJugardor = nombreJugardor;
        this.clave = clave;
        this.sig = sig;
        this.ant = ant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreJugardor() {
        return nombreJugardor;
    }

    public void setNombreJugardor(String nombreJugardor) {
        this.nombreJugardor = nombreJugardor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Nodo_Usuario getSig() {
        return sig;
    }

    public void setSig(Nodo_Usuario sig) {
        this.sig = sig;
    }

    public Nodo_Usuario getAnt() {
        return ant;
    }

    public void setAnt(Nodo_Usuario ant) {
        this.ant = ant;
    }
        
}
