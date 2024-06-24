package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Usuario;

public class ListaDobleUsuario {

    private Nodo_Usuario cab;
    private int nUsuarios;

    public ListaDobleUsuario() {

        this.cab = null;
        this.nUsuarios = 0;
    }

    public Nodo_Usuario getCab() {
        return cab;
    }

    public void setCab(Nodo_Usuario cab) {
        this.cab = cab;
    }

    public int getnUsuarios() {
        return nUsuarios;
    }

    public void setnUsuarios(int nUsuarios) {
        this.nUsuarios = nUsuarios;
    }

    public void vaciarLista() {
        cab = null;
    }
}
