package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Juego;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaStack_Juego {

    private final Stack<Nodo_Juego> pilaJB;
    private final Stack<Nodo_Juego> pilaJL;
    private final Stack<Nodo_Juego> pilaJC;

    public PilaStack_Juego() {
        pilaJB = new Stack<>();
        pilaJL = new Stack<>();
        pilaJC = new Stack<>();
    }

    public Stack<Nodo_Juego> getPilaJB() {
        return pilaJB;
    }

    public Stack<Nodo_Juego> getPilaJL() {
        return pilaJL;
    }

    public Stack<Nodo_Juego> getPilaJC() {
        return pilaJC;
    }

    //Metodos PilaJB
    public void setPushJuego(Nodo_Juego j) {
        int pos = pilaJB.indexOf(j);
        if (pos == -1) {
            pilaJB.push(j);
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public Stack<Nodo_Juego> getJuegosNick(String NickUser) {
        Stack<Nodo_Juego> pila = new Stack<>();
        for (Nodo_Juego aux : pilaJB) {
            if (aux.getNickUser().equals(NickUser)) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Juego getJuegoNick(String NickUser) {
        for (Nodo_Juego aux : pilaJB) {
            if (aux.getNickUser().equals(NickUser)) {
                return aux;
            }
        }
        return null;
    }

    public void setPopJuegoNick(String nick) {
        Nodo_Juego aux = null;
        if (!pilaJB.empty()) {
            aux = getJuegoNick(nick);
            if ((aux != null) && (pilaJB.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se hay juegos registrado!");
        }
    }

    public Stack<Nodo_Juego> getClonarJB() {
        Stack<Nodo_Juego> caux = new Stack<>();
        int i;
        Nodo_Juego aux = null;
        if (this.pilaJB == null) {
            return null;
        } else {
            for (i = 0; i < pilaJB.size(); i++) {
                aux = pilaJB.get(i);
                caux.add(i, aux);
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

    //Metodos pilaJL
    public void setPushJuego2(Nodo_Juego j) {
        int pos = pilaJL.indexOf(j);
        if (pos == -1) {
            pilaJL.push(j);
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public boolean limpiar2() {
        pilaJL.clear();

        return pilaJL.isEmpty();
    }
    
    public Stack<Nodo_Juego> getJuegosNick2(String NickUser) {
        Stack<Nodo_Juego> pila = new Stack<>();
        for (Nodo_Juego aux : pilaJL) {
            if (aux.getNickUser().equals(NickUser)) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Juego getJuegoNick2(String NickUser) {
        for (Nodo_Juego aux : pilaJL) {
            if (aux.getNickUser().equals(NickUser)) {
                return aux;
            }
        }
        return null;
    }

    public void setPopJuegoNick2(String nick) {
        Nodo_Juego aux = null;
        if (!pilaJL.empty()) {
            aux = getJuegoNick(nick);
            if ((aux != null) && (pilaJL.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se hay juegos registrado!");
        }
    }

    public Stack<Nodo_Juego> getClonarJL() {
        Stack<Nodo_Juego> caux = new Stack<>();
        int i;
        Nodo_Juego aux = null;
        if (this.pilaJL == null) {
            return null;
        } else {
            for (i = 0; i < pilaJL.size(); i++) {
                aux = pilaJL.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar2(Stack<Nodo_Juego> pila, String nombre, String nick) {
        Stack<Nodo_Juego> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo_Juego juego = pila.pop();
            String[] nom = juego.getNombre().split(" ");
            String[] nic = juego.getNickUser().split(" ");
            if (!nom[0].equals(nombre) || !nic[0].equals(nick)) {
                temp.push(juego);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    //Metodos pilaJC
    public void setPushJuego3(Nodo_Juego j) {
        int pos = pilaJC.indexOf(j);
        if (pos == -1) {
            pilaJC.push(j);
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public boolean limpiar3() {
        pilaJC.clear();

        return pilaJC.isEmpty();
    }

    public Stack<Nodo_Juego> getJuegosNick3(String NickUser) {
        Stack<Nodo_Juego> pila = new Stack<>();
        for (Nodo_Juego aux : pilaJC) {
            if (aux.getNickUser().equals(NickUser)) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Juego getJuegoNick3(String NickUser) {
        for (Nodo_Juego aux : pilaJC) {
            if (aux.getNickUser().equals(NickUser)) {
                return aux;
            }
        }
        return null;
    }

    public void setPopJuegoNick3(String nick) {
        Nodo_Juego aux = null;
        if (!pilaJC.empty()) {
            aux = getJuegoNick(nick);
            if ((aux != null) && (pilaJC.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se hay juegos registrado!");
        }
    }

    public Stack<Nodo_Juego> getClonarJC() {
        Stack<Nodo_Juego> caux = new Stack<>();
        int i;
        Nodo_Juego aux = null;
        if (this.pilaJC == null) {
            return null;
        } else {
            for (i = 0; i < pilaJC.size(); i++) {
                aux = pilaJC.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar3(Stack<Nodo_Juego> pila, String nombre, String nick) {
        Stack<Nodo_Juego> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo_Juego juego = pila.pop();
            String[] nom = juego.getNombre().split(" ");
            String[] nic = juego.getNickUser().split(" ");
            if (!nom[0].equals(nombre) || !nic[0].equals(nick)) {
                temp.push(juego);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    public void guardarJuegos(Stack<Nodo_Juego> pila) {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_Biblioteca.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Nodo_Juego> proAux = pila;

            for (Nodo_Juego juego : proAux) {
                writer.write(juego.getNickUser() + ", ");
                writer.write(juego.getNombre() + ", ");
                writer.write(juego.getURL_ima());
                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en: Archivo_Juegos_Biblioteca.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: Archivo_Juegos_Biblioteca.txt: " + e.getMessage());
        }
    }

    public void cargarJuegos() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_Biblioteca.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaJB.isEmpty()) {
                pilaJB.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String NickUser = atributos[0];
                String nombre = atributos[1];
                String URL = atributos[2];

                Nodo_Juego juego = new Nodo_Juego(NickUser, nombre, URL);

                setPushJuego(juego);
            }

            System.out.println("Datos cargados correctamente desde Archivo_Juegos_Biblioteca.txt.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Juegos_Biblioteca.txt: " + e.getMessage());
        }
    }

    public void guardarJuegos2(Stack<Nodo_Juego> pila) {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_LDeseos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Nodo_Juego> proAux = pila;

            for (Nodo_Juego juego : proAux) {
                writer.write(juego.getNickUser() + ", ");
                writer.write(juego.getNombre() + ", ");
                writer.write(juego.getURL_ima());
                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en: Archivo_Juegos_LDeseos.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: Archivo_Juegos_LDeseos.txt: " + e.getMessage());
        }
    }

    public void cargarJuegos2() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_LDeseos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaJL.isEmpty()) {
                pilaJL.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String NickUser = atributos[0];
                String nombre = atributos[1];
                String URL = atributos[2];

                Nodo_Juego juego = new Nodo_Juego(NickUser, nombre, URL);

                setPushJuego2(juego);
            }

            System.out.println("Datos cargados correctamente desde Archivo_Juegos_LDeseos.txt.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Juegos_LDeseos.txt: " + e.getMessage());
        }
    }

    public void guardarJuegos3(Stack<Nodo_Juego> pila) {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_Carrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Nodo_Juego> proAux = pila;

            for (Nodo_Juego juego : proAux) {
                writer.write(juego.getNickUser() + ", ");
                writer.write(juego.getNombre() + ", ");
                writer.write(juego.getURL_ima());
                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en: Archivo_Juegos_Carrito.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: Archivo_Juegos_Carrito.txt: " + e.getMessage());
        }
    }

    public void cargarJuegos3() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Juegos_Carrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaJC.isEmpty()) {
                pilaJC.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String NickUser = atributos[0];
                String nombre = atributos[1];
                String URL = atributos[2];

                Nodo_Juego juego = new Nodo_Juego(NickUser, nombre, URL);

                setPushJuego3(juego);
            }

            System.out.println("Datos cargados correctamente desde Archivo_Juegos_Carrito.txt.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Juegos_Carrito.txt: " + e.getMessage());
        }
    }
}
