package Controllers;

import Models.EstructurasDeDatos.ListaDobleUsuario;
import Models.EstructurasDeDatos.PilaStack_Juego;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_View_Sign_in implements Initializable {

    private ListaDobleUsuario listU = ModeloDeDatos.obtenerInstancia().getListaU();
    private PilaStack_Juego pilaJ = ModeloDeDatos.obtenerInstancia().getPilaJ();
    
    @FXML
    private TextField txt_Nombre;
    @FXML
    private TextField txt_Identificacion;
    @FXML
    private TextField txt_Celular;
    @FXML
    private TextField txt_Correo;
    @FXML
    private TextField txt_Nombre_jugador;
    @FXML
    private PasswordField txt_Password_1;
    @FXML
    private PasswordField txt_Password_2;
    @FXML
    private Button btn_cancelar;
    @FXML
    private Button btn_aceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        pilaJ.cargarJuegos();
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btn_cancelar.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Sign_in.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EventAction(ActionEvent event) throws IOException {

        if (event.getSource() == btn_cancelar) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btn_cancelar.getScene().getWindow();
            miStage.close();

        } else if (event.getSource() == btn_aceptar) {

            AgregarUsuarios(txt_Nombre, txt_Identificacion, txt_Celular, txt_Correo, txt_Nombre_jugador, txt_Password_1, txt_Password_2);
        }
    }

    public void AgregarUsuarios(TextField txtNombre, TextField txtIden, TextField txtCell, TextField txtGmail, TextField txtNickName, PasswordField txtPassword_1, PasswordField txtPassword_2) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Mensaje de informacion");
        a.setTitle("Dialogo de advertencia");

        if (!"".equals(txtNombre.getText())) {

            if (!"".equals(txtIden.getText())) {

                if (!"".equals(txtCell.getText())) {

                    if (!"".equals(txtGmail.getText())) {

                        if (!"".equals(txtNickName.getText())) {

                            if (!"".equals(txtPassword_1.getText())) {

                                if (txtPassword_1.getText().equals(txtPassword_2.getText())) {

                                    listU.addUsuarioInicio(txtNombre, txtIden, txtCell, txtGmail, txtNickName, txtPassword_1);
                                    listU.guardarDatosEnArchivoUsuarios(listU);                                    
                                    if (listU.getnUsuarios() != 0) {
                                        txtPassword_2.setText("");
                                        closeWindow();
                                    }
                                    
                                } else {
                                    a.setContentText("Verifique su contraseña");
                                    a.showAndWait();
                                }

                            } else {

                                a.setContentText("Es necesario que se escriba una contraseña");
                                a.showAndWait();
                            }
                        } else {

                            a.setContentText("Es necesario que se escriba un nombre de jugador");
                            a.showAndWait();
                        }
                    } else {

                        a.setContentText("Es necesario que se escriba un correo");
                        a.showAndWait();
                    }
                } else {

                    a.setContentText("Es necesario que se escriba un"
                            + "\nnumero de numero de telefono");
                    a.showAndWait();
                }

            } else {

                a.setContentText("Es necesario que se escriba un numero de identificacion");
                a.showAndWait();
            }
        } else {

            a.setContentText("Es necesario que se escriba un nombre");
            a.showAndWait();
        }
    }
}
