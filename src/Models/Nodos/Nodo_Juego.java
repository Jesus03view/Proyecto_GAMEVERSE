package Models.Nodos;

public class Nodo_Juego {
 
    private String nickUser;
    private String nombre;
    private float precio;
    private String URL_ima;

    public Nodo_Juego() {
    }

    public Nodo_Juego(String nombre, float precio, String URL_ima) {
        this.nombre = nombre;
        this.precio = precio;
        this.URL_ima = URL_ima;
    }
    
    public Nodo_Juego(String nickUser, String nombre, float precio, String URL_ima) {
        this.nickUser = nickUser;
        this.nombre = nombre;
        this.precio = precio;
        this.URL_ima = URL_ima;
    }

    public String getNickUser() {
        return nickUser;
    }

    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getURL_ima() {
        return URL_ima;
    }

    public void setURL_ima(String URL_ima) {
        this.URL_ima = URL_ima;
    }    
}
