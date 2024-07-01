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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller_View_GAME_VERSE implements Initializable {

    private ListaDobleUsuario listU = ModeloDeDatos.obtenerInstancia().getListaU();
    private PilaStack_Juego pila = ModeloDeDatos.obtenerInstancia().getPilaJ();

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
    public Text labelNick;
    @FXML
    private Label txt_btn_P;
    @FXML
    private ImageView ImaLogo;
    @FXML
    private FlowPane flowpaneGames;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane anchorP;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button btn_game7;
    @FXML
    private Button btn_game8;
    @FXML
    private Button btn_game9;
    @FXML
    private Button btn_game10;
    @FXML
    private Button btn_game11;
    @FXML
    private Button btn_game12;
    @FXML
    private Button btn_game13;
    @FXML
    private Button btn_game14;
    @FXML
    private Button btn_game15;
    @FXML
    private Label labelModoO;
    @FXML
    private ImageView navFriends;
    @FXML
    private ImageView navAddFriends;
    @FXML
    private Button btn_Tarjeta;
    @FXML
    private Button btn_Nequi;
    @FXML
    private Button btn_Daviplata;
    @FXML
    private Pane datos_tarjeta;
    @FXML
    private Pane datos_nequi;
    @FXML
    private Pane datos_daviPlata;
    @FXML
    private Button cerrar_VPago;
    @FXML
    private Button btn_Pagar;
    @FXML
    private AnchorPane panelDePago;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO      
        anchorP.prefWidthProperty().bind(scrollPane.widthProperty());
        anchorP.prefHeightProperty().bind(scrollPane.heightProperty());
        flowpaneGames.prefWidthProperty().bind(anchorP.widthProperty());
        flowpaneGames.prefHeightProperty().bind(anchorP.heightProperty());

        listU.cargarDatosDesdeArchivoUsuarios();

        pila.cargarJuegos();
        Nodo_Juego juego = pila.getJuegoNick(labelNick.getText());

        if (juego != null) {
            cargarjuegos(juego.getNickUser());
        }
    }

    public Label getTxt_btn_P() {
        return txt_btn_P;
    }

    public void apagarVideo() {
        webView.getEngine().load(null);
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

    private void toggleStylesheets() {
        Image image = new Image(getClass().getResourceAsStream("/Images/Logo.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/Images/Logo2.png"));
        Image imagenav = new Image(getClass().getResourceAsStream("/Images/Icono_amigos2.png"));
        Image imagenav2 = new Image(getClass().getResourceAsStream("/Images/Icono_amigos1.png"));
        Image imagenavA = new Image(getClass().getResourceAsStream("/Images/Icono_add_Amigo1.png"));
        Image imagenavA2 = new Image(getClass().getResourceAsStream("/Images/Icono_add_Amigo2.png"));

        String hoja = AnchorPane.getStylesheets().get(0);
        String[] nombre = hoja.split("/");
        int n = nombre.length;

        String comparador = nombre[n - 1];
        String comparador2 = "Styles.css";

        if (comparador.equals(comparador2) == true) {

            AnchorPane.getStylesheets().clear();
            AnchorPane.getStylesheets().add(getClass().getResource("/Style/Styles_Dark.css").toExternalForm());

            ImaLogo.setImage(image2);
            navFriends.setImage(imagenav2);
            navAddFriends.setImage(imagenavA2);
            labelModoO.setText("Activado");

        } else {

            AnchorPane.getStylesheets().clear();
            AnchorPane.getStylesheets().add(getClass().getResource("/Style/Styles.css").toExternalForm());

            ImaLogo.setImage(image);
            navFriends.setImage(imagenav);
            navAddFriends.setImage(imagenavA);
            labelModoO.setText("Desactivado");
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
        } else if (e.getSource().equals(btn_Shop)) {
            cargarjuegos(labelNick.getText());
        } else if (e.getSource().equals(btn_CerrarS)) {
            webView.getEngine().load(null);
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
        } else if (e.getSource().equals(btn_ModO)) {
            toggleStylesheets();
        }
    }

    @FXML
    private void EventAction2(ActionEvent e) {

        if (e.getSource().equals(btn_game1)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/NnyCWsA6KSI?si=9fRLdvVaOesBKBik ");

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

    public void cargarjuegos(String NickUser) {

        if (!flowpaneGames.getChildren().isEmpty()) {
            flowpaneGames.getChildren().clear();
        }

        Stack<Nodo_Juego> pilaJT = pila.getJuegosNick(NickUser);

        for (Nodo_Juego juego : pilaJT) {

            crearJuegos(juego.getNombre(), juego.getPrecio(), juego.getURL_ima());
        }
    }

    private void crearJuegos(String getNombre, Float getPrecio, String getURL_ima) {

        Pane pane = new Pane();
        pane.getStyleClass().add("juegos");
        pane.prefWidth(180);
        pane.prefHeight(300);
        pane.setFocusTraversable(false);
        pane.setId(getNombre);

        Image image = new Image(getClass().getResourceAsStream(getURL_ima));
        ImageView imageV = new ImageView(image);
        imageV.preserveRatioProperty().set(true);
        imageV.setFitWidth(140);
        imageV.setFitHeight(180);
        imageV.setLayoutX(10);
        imageV.setLayoutY(10);

        Pane pane2 = new Pane();
        pane2.prefWidth(140);
        pane2.prefHeight(100);
        pane2.setFocusTraversable(false);
        pane2.setLayoutX(10);
        pane2.setLayoutY(200);

        Label text1 = new Label("Juego Base");
        text1.setLayoutX(0);
        text1.setLayoutY(11);
        text1.setStyle("-fx-font-family: 'System'; -fx-font-weight: bold; -fx-font-size: 8.0;");
        Label text2 = new Label(getNombre);
        text2.setLayoutX(0);
        text2.setLayoutY(35);
        Label text3 = new Label("Precio:");
        text3.setLayoutX(0);
        text3.setLayoutY(80);
        Label text4 = new Label("COP $ " + getPrecio);
        text4.setLayoutX(70);
        text4.setLayoutY(80);

        pane2.getChildren().addAll(text1, text2, text3, text4);
        pane.getChildren().addAll(imageV, pane2);
        flowpaneGames.getChildren().add(pane);

        System.out.println("Devió guardarse:" + getNombre);
    }

    @FXML
    private void btn_VCompra_Action(ActionEvent event) {

        if (event.getSource().equals(btn_Tarjeta)) {

            if (!datos_tarjeta.isVisible()) {
                datos_tarjeta.setVisible(true);
                datos_nequi.setVisible(false);
                datos_daviPlata.setVisible(false);
                btn_Nequi.setLayoutY(390);
                btn_Daviplata.setLayoutY(450);
            } else {
                datos_tarjeta.setVisible(false);
                btn_Nequi.setLayoutY(210);
                btn_Daviplata.setLayoutY(270);
            }
        } else if (event.getSource().equals(btn_Nequi)) {

            if (!datos_nequi.isVisible()) {
                datos_nequi.setVisible(true);
                datos_tarjeta.setVisible(false);
                datos_daviPlata.setVisible(false);
                btn_Nequi.setLayoutY(210);
                btn_Daviplata.setLayoutY(445);
            } else {
                datos_nequi.setVisible(false);
                btn_Daviplata.setLayoutY(270);
            }
        } else if (event.getSource().equals(btn_Daviplata)) {

            if (!datos_daviPlata.isVisible()) {
                datos_daviPlata.setVisible(true);
                datos_nequi.setVisible(false);
                datos_tarjeta.setVisible(false);
                btn_Daviplata.setLayoutY(270);
            } else {
                datos_daviPlata.setVisible(false);
            }
        } else if (event.getSource().equals(cerrar_VPago)) {
            panelDePago.setVisible(!panelDePago.isVisible());
        }
    }
}
