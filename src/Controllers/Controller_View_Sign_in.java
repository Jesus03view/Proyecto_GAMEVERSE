package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller_View_Sign_in implements Initializable {

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

    @FXML
    private void EventAction(ActionEvent event) {

        if (event.getSource() == btn_cancelar) {
        
        } else if (event.getSource() == btn_aceptar) {
        
        }
    }

}
