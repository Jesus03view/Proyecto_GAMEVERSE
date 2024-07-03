package Models.Nodos;

public class Nodo_Usuario {

    private String nombre;
    private String identificacion;
    private String celular;
    private String correo;
    private String nombreJugador;
    private String clave;
    private String amigos;
    private Nodo_Usuario sig, ant;

    public Nodo_Usuario(String nombre, String identificacion, String celular, String correo, String nombreJugador, String clave, String amigos) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.celular = celular;
        this.correo = correo;
        this.nombreJugador = nombreJugador;
        this.clave = clave;
        this.amigos = amigos;
        this.sig = null;
        this.ant = null;
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

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAmigos() {
        return amigos;
    }

    public void setAmigos(String amigos) {
        this.amigos = amigos;
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
