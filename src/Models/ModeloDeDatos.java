package Models;

import Models.EstructurasDeDatos.ListaDobleUsuario;
import Models.EstructurasDeDatos.PilaStack_Juego;

public class ModeloDeDatos {

    private static ModeloDeDatos instance;
    private final ListaDobleUsuario listaU;
    private final PilaStack_Juego pilaJ;

    private ModeloDeDatos() {
        listaU = new ListaDobleUsuario();
        pilaJ = new PilaStack_Juego();
    }

    public static ModeloDeDatos obtenerInstancia() {
        if (instance == null) {
            instance = new ModeloDeDatos();
        }
        return instance;
    }

    public ListaDobleUsuario getListaU() {
        return listaU;
    }

    public PilaStack_Juego getPilaJ() {
        return pilaJ;
    }
    
}
