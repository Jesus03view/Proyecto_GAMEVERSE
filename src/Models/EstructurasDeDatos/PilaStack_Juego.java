package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Juego;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaStack_Juego {
    
    private final Stack<Nodo_Juego> pilaJT;
    private final Stack<Nodo_Juego> pilaJB;
    private final Stack<Nodo_Juego> pilaJL;

    public PilaStack_Juego() {
        pilaJT = new Stack<>();
        pilaJB = new Stack<>();
        pilaJL = new Stack<>();
    }

    public Stack<Nodo_Juego> getPilaJT() {
        return pilaJT;
    }

    public Stack<Nodo_Juego> getPilaJB() {
        return pilaJB;
    }

    public Stack<Nodo_Juego> getPilaJL() {
        return pilaJL;
    }
    
    //Metodos PilaJT
    public void setPushJuego(Nodo_Juego j) {
        int pos = pilaJT.indexOf(j);
        if (pos == -1) {
            pilaJT.push(j);
            System.out.println("Se registró el juego");
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public Stack<Nodo_Juego> getJuegosNick(String NickUser) {
        Stack<Nodo_Juego> pila = new Stack<>();
        for (Nodo_Juego aux : pilaJT) {
            if (aux.getNickUser().equals(NickUser)) {
                pila.push(aux);
            }
        }
        return pila;
    }
    
    public Nodo_Juego getJuegoNick(String NickUser) {
        for (Nodo_Juego aux : pilaJT) {
            if (aux.getNickUser().equals(NickUser)) {
                return aux;
            }
        }
        return null;
    }

    public void setPopJuegoNick(String nick) {
        Nodo_Juego aux = null;
        if (!pilaJT.empty()) {
            aux = getJuegoNick(nick);
            if ((aux != null) && (pilaJT.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se hay juegos registrado!");
        }
    }

    public PilaStack_Juego getClonar() {
        PilaStack_Juego caux = new PilaStack_Juego();
        int i;
        Nodo_Juego aux = null;
        if (this.pilaJT == null) {
            return null;
        } else {
            for (i = 0; i < pilaJT.size(); i++) {
                aux = pilaJT.get(i);
                caux.pilaJT.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar(Stack<Nodo_Juego> pila, String Nick) {
        Stack<Nodo_Juego> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo_Juego juego = pila.pop();
            if (juego.getNickUser().equals(Nick)) {
                temp.push(juego);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    //Metodos pilaJB
    //Metodos pilaJL
 
    public void guardarJuegos(Stack<Nodo_Juego> pila) {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Compras.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Nodo_Juego> proAux = pila;

            for (Nodo_Juego juego : proAux) {
                writer.write(juego.getNickUser() + ", ");
                writer.write(juego.getNombre() + ", ");
                writer.write(juego.getPrecio() + ", ");
                writer.write(juego.getURL_ima());
                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en: Archivo_Juegos_Tienda.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: Archivo_Juegos_Tienda.txt: " + e.getMessage());
        }
    }

    public void cargarJuegos() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_Tienda.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaJT.isEmpty()) {
                pilaJT.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String NickUser = atributos[0];
                String nombre = atributos[1];
                Float precio = Float.valueOf(atributos[2]);
                String URL = atributos[3];
                

                Nodo_Juego juego = new Nodo_Juego(NickUser, nombre, precio, URL);

                setPushJuego(juego);
            }

            System.out.println("Datos cargados correctamente desde Archivo_Juegos_Tienda.txt.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Juegos_Tienda.txt: " + e.getMessage());
        }
    }

}
