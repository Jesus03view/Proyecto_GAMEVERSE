package Controllers;

import Models.EstructurasDeDatos.ListaDobleUsuario;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Usuario;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller_View_Login implements Initializable {

    private ListaDobleUsuario listU = ModeloDeDatos.obtenerInstancia().getListaU();

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
        listU.cargarDatosDesdeArchivoUsuarios();
    }

    @FXML
    private void EventAction(ActionEvent event) {
        if (event.getSource() == btn_Login) {

            iniciarSesion();

        } else if (event.getSource() == btn_Registrar) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Sign_in.fxml"));
                Parent root = loader.load();

                Controller_View_Sign_in controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

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

    public void iniciarSesion() {

        if (txt_User.getText().isEmpty() && txt_Password.getText().isEmpty()) {

            txt_error.setVisible(true);
            txt_error.setText("*No se puede verificar\nLos campos están vacios");

        } else if (txt_User.getText().isEmpty()) {

            txt_error.setVisible(true);
            txt_error.setText("*No se puede verificar\nDebe ingresar un correo o usuario");

        } else if (txt_Password.getText().isEmpty()) {

            txt_error.setVisible(true);
            txt_error.setText("*No se puede verificar\nDebe ingresar una contraseña");

        } else {

            Nodo_Usuario buscar = listU.BuscarNick(txt_User.getText());
            Nodo_Usuario buscar2 = listU.BuscarEmail(txt_User.getText());

            if (buscar != null && buscar.getClave().equals(txt_Password.getText())) {
                listU.Alert(Alert.AlertType.CONFIRMATION, "Bienvenido", "GAME_VERSE le da la Bienvenida..!");
                txt_error.setVisible(false);

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_GAME_VERSE.fxml"));
                    Parent root = loader.load();

                    Controller_View_GAME_VERSE controller = loader.getController();
                    controller.labelNick.setText(buscar.getNombreJugador());
                    
                    String PL = buscar.getNombreJugador();                     
                    controller.getTxt_btn_P().setText(PL.substring(0, 1));
                    controller.cargarjuegos(controller.getTxt_btn_P().getText());

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent value) -> {
                        controller.closeWindow();
                        controller.apagarVideo();
                    });
                    stage.show();

                    Stage miStage = (Stage) this.btn_Login.getScene().getWindow();
                    miStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                txt_User.setText("");
                txt_Password.setText("");

            } else if (buscar2 != null && buscar2.getClave().equals(txt_Password.getText())) {

                listU.Alert(Alert.AlertType.CONFIRMATION, "Bienvenido", "GAME_VERSE le da la Bienvenida..!");
                txt_error.setVisible(false);

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_GAME_VERSE.fxml"));
                    Parent root = loader.load();

                    Controller_View_GAME_VERSE controller = loader.getController();
                    controller.labelNick.setText(buscar2.getNombreJugador());
                    
                    String PL = buscar2.getNombreJugador();
                    controller.getTxt_btn_P().setText(PL.substring(0, 1));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent value) -> {
                        controller.closeWindow();
                        controller.apagarVideo();
                    });
                    stage.show();

                    Stage miStage = (Stage) this.btn_Login.getScene().getWindow();
                    miStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                txt_User.setText("");
                txt_Password.setText("");

            } else {
                txt_error.setVisible(true);
                txt_error.setText("*Contraseña incorrecta");
                txt_Password.setText("");
                txt_Password.requestFocus();
            }

            if (buscar == null && buscar2 == null) {
                txt_error.setVisible(true);
                txt_error.setText("*El Correo o Usuario\nno está registrado o es erroneo, por favor verifique");
                txt_User.setText("");
                txt_Password.setText("");
                txt_User.requestFocus();
            }
        }
    }
}
