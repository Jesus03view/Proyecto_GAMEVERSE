package Controllers;

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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_GAME_VERSE.fxml"));
                    Parent root = loader.load();

                    Controller_View_GAME_VERSE controller = loader.getController();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent value) -> {
                        controller.closeWindow();
                    });
                    stage.show();

                    Stage miStage = (Stage) this.btn_Login.getScene().getWindow();
                    miStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (event.getSource() == btn_Registrar) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Sign_in.fxml"));
                Parent root = loader.load();

                Controller_View_Sign_in controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow();
                });
                stage.show();

                Stage miStage = (Stage) this.btn_Login.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
