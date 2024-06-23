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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller_View_GAME_VERSE implements Initializable {

    @FXML
    private Button btn_carrito;
    @FXML
    private Button btn_Friends;
    @FXML
    private Button btn_addF;
    @FXML
    private Button btn_Amigos;
    @FXML
    private Button btn_Perfil;
    @FXML
    private Pane panelPerfil;
    @FXML
    private Button btn_CClave;
    @FXML
    private Button btn_ModO;
    @FXML
    private Button btn_CerrarS;
    @FXML
    private Pane panelAmigos;
    @FXML
    private Button btn_ListD;
    @FXML
    private Button btn_Shop;
    @FXML
    private Button btn_Biblioteca;
    @FXML
    private Button btn_game1;
    @FXML
    private Button btn_game2;
    @FXML
    private Button btn_game3;
    @FXML
    private Button btn_game4;
    @FXML
    private Button btn_game5;
    @FXML
    private Button btn_game6;
    @FXML
    private VBox panePresent;
    @FXML
    private WebView webView;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    @FXML
    private AnchorPane anchorP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        anchorP.prefWidthProperty().bind(scrollPane.widthProperty());
        anchorP.prefHeightProperty().bind(scrollPane.heightProperty());
        flowPane.prefWidthProperty().bind(anchorP.widthProperty());
        flowPane.prefHeightProperty().bind(anchorP.heightProperty());    
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btn_carrito.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_GAME_VERSE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ActionEvent(ActionEvent e) {

        if (e.getSource().equals(btn_Perfil)) {
            panelPerfil.setVisible(!panelPerfil.isVisible());
            panelAmigos.setVisible(false);

        } else if (e.getSource().equals(btn_Amigos)) {
            panelAmigos.setVisible(!panelAmigos.isVisible());
            panelPerfil.setVisible(false);
        } else if (e.getSource().equals(btn_Friends)) {
            btn_Friends.getStyleClass().add("btnAfter");
            btn_addF.getStyleClass().removeAll("btnAfter");

        } else if (e.getSource().equals(btn_addF)) {
            btn_addF.getStyleClass().add("btnAfter");
            btn_Friends.getStyleClass().removeAll("btnAfter");
        } else if (e.getSource().equals(btn_CerrarS)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

                Parent roott = loader.load();

                Scene scene = new Scene(roott);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                Stage miStage = (Stage) this.btn_carrito.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_GAME_VERSE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void EventAction2(ActionEvent e) {

        if (e.getSource().equals(btn_game1)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/NnyCWsA6KSI?si=9fRLdvVaOesBKBik");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);

        } else if (e.getSource().equals(btn_game2)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/Wj3dUvGLjNQ?si=pzNhbJ-kjdDtw9HR");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);

        } else if (e.getSource().equals(btn_game3)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/iYZpR51XgW0?si=1P6oqciFBlZoklTh");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game4)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/XhP3Xh4LMA8?si=jcdKbr_50Ulhy-m1");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game5)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/F3jePdO9_jc?si=4LEa6nbkl8cFSxLy");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
            
        } else if (e.getSource().equals(btn_game6)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/cjd00TgL7NQ?si=mV292-Hitc9875Hl");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        }
    }
}
