package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ListaDobleUsuario {

    private Nodo_Usuario cabU;
    private int nUsuarios;

    public ListaDobleUsuario() {
        this.cabU = null;
        this.nUsuarios = 0;
    }

    public Nodo_Usuario getCabU() {
        return cabU;
    }

    public void setCabU(Nodo_Usuario cabU) {
        this.cabU = cabU;
    }

    public int getnUsuarios() {
        return nUsuarios;
    }

    public void setnUsuarios(int nUsuarios) {
        this.nUsuarios = nUsuarios;
    }

    public void vaciarLista() {
        cabU = null;
    }

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
    }

    public Nodo_Usuario BuscarEmail(String gmail) {
        if (getCabU() == null) {
            return null;
        } else {
            Nodo_Usuario aux = getCabU();
            while (aux != null) {
                if (aux.getCorreo().equalsIgnoreCase(gmail)) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public Nodo_Usuario BuscarNick(String nick) {
        if (getCabU() == null) {
            return null;
        } else {
            Nodo_Usuario aux2 = getCabU();
            while (aux2 != null) {
                if (aux2.getNombreJugador().equals(nick)) {
                    return aux2;
                } else {
                    aux2 = aux2.getSig();
                }
            }
            return null;
        }
    }

    public ObservableList<Nodo_Usuario> getUsuarios() {
        ObservableList<Nodo_Usuario> todos = FXCollections.observableArrayList();
        if (cabU == null) {
            System.err.println("Error: cabU es null.");
            return todos;
        }

        Nodo_Usuario actual = cabU;

        do {
            todos.add(actual);
            actual = actual.getSig();

        } while (actual != null && actual != cabU);
        
        return todos;
    }

    public Nodo_Usuario getUltimo() {

        if (cabU == null) {
            return null;
        } else {
            Nodo_Usuario q = cabU;
            while (q.getSig() != null) {
                q = q.getSig();
            }
            return q;
        }
    }

    public Nodo_Usuario getCrearUsuario(TextField txtNombre, TextField txtIdentificacion, TextField txtCell, TextField txtGmail, TextField txtNickName, PasswordField txtPassword) {

        Nodo_Usuario buscar = BuscarEmail(txtGmail.getText());
        Nodo_Usuario buscar2 = BuscarNick(txtNickName.getText());
        try {

            if (buscar != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un usuario con este Correo");
                return null;
            } else if (buscar2 != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un usuario con este NickName");
                return null;
            } else {
                Nodo_Usuario nuevoU = new Nodo_Usuario(txtNombre.getText(), txtIdentificacion.getText(), txtCell.getText(), txtGmail.getText(), txtNickName.getText(), txtPassword.getText(), "");
                Alert(Alert.AlertType.CONFIRMATION, "Dialogo de confirmación",
                        "Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros usuarios :)");
                txtNombre.setText("");
                txtIdentificacion.setText("");
                txtCell.setText("");
                txtNickName.setText("");
                txtGmail.setText("");
                txtPassword.setText("");
                return nuevoU;
            }

        } catch (Exception e) {
            return null;
        }

    }

    public void addUsuario(String nom, String iden, String celu, String gmail, String nick, String clave, String amigos) {

        Nodo_Usuario ch = new Nodo_Usuario(nom, iden, celu, gmail, nick, clave, amigos);
        if (ch != null) {
            if (cabU == null) {
                cabU = ch;
                nUsuarios++;
            } else {
                Nodo_Usuario ultimo = getUltimo();
                ultimo.setSig(ch);
                ch.setAnt(ultimo);
                nUsuarios++;
            }
        }
    }

    public void addUsuarioInicio(TextField txtNombre, TextField txtIden, TextField txtCell, TextField txtGmail, TextField txtNickName, PasswordField txtPassword) {

        Nodo_Usuario ch = getCrearUsuario(txtNombre, txtIden, txtCell, txtGmail, txtNickName, txtPassword);
        if (ch != null) {
            if (getCabU() == null) {
                setCabU(ch);
                nUsuarios++;
                System.out.println("Se ha registrado");
            } else {
                ch.setSig(getCabU());
                getCabU().setAnt(ch);
                setCabU(ch);
                nUsuarios++;
                System.out.println("Se ha registrado al inicio");
            }
        }
    }

    public void guardarDatosEnArchivoUsuarios(ListaDobleUsuario listaU) {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Usuarios.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Nodo_Usuario nodoActual = listaU.getCabU();

            while (nodoActual != null) {
                writer.write(nodoActual.getNombre() + ", ");
                writer.write(nodoActual.getIdentificacion() + ", ");
                writer.write(nodoActual.getCelular() + ", ");
                writer.write(nodoActual.getCorreo() + ", ");
                writer.write(nodoActual.getNombreJugador() + ", ");
                writer.write(nodoActual.getClave());
                writer.write(nodoActual.getAmigos());
                writer.newLine();

                nodoActual = nodoActual.getSig();
            }

            System.out.println("Datos guardados correctamente en el archivo de usuarios.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de usuarios: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoUsuarios() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_Base_TXT\\Archivo_Usuarios.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            vaciarLista();

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String nombre = atributos[0];
                String identificacion = atributos[1];
                String celular = atributos[2];
                String gmail = atributos[3];
                String nick = atributos[4];
                String clave = atributos[5];
                String amigos = atributos[6];

                addUsuario(nombre, identificacion, celular, gmail, nick, clave, amigos);
            }

            System.out.println("Datos cargados correctamente desde archivo de usuasio.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de usuarios: " + e.getMessage());
        }
    }

}
