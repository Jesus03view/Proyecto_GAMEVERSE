package Controllers;

import Models.EstructurasDeDatos.ListaDobleUsuario;
import Models.ModeloDeDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_View_Sign_in implements Initializable {

    
    private ListaDobleUsuario list_U = ModeloDeDatos.obtenerInstancia().getListaU();
    
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

        }
    }

}
