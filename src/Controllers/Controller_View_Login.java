package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller_View_Login implements Initializable {

    @FXML
    private TextField txt_User;
    @FXML
    private TextField txt_Password;
    @FXML
    private Hyperlink btn_Registrar;
    @FXML
    private Button btn_Login;
    @FXML
    private Text txt_error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EventAction(ActionEvent event) {
        if (event.getSource() == btn_Login) {

            if (txt_User.getText().isEmpty() && txt_Password.getText().isEmpty()) {

                txt_error.setVisible(true);
                txt_error.setText("*El usuario y contraseña son incorrectos");
            } else if (txt_User.getText().isEmpty() || txt_Password.getText().isEmpty()) {

                txt_error.setVisible(true);
                txt_error.setText("*Debe llenar todos los campos");
            } else {

                txt_error.setVisible(false);

            }

        } else if (event.getSource() == btn_Registrar) {
            
        }
    }

}
