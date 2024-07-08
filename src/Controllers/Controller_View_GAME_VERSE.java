package Controllers;

import Models.EstructurasDeDatos.ListaDobleUsuario;
import Models.EstructurasDeDatos.PilaStack_Juego;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Juego;
import Models.Nodos.Nodo_Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller_View_GAME_VERSE implements Initializable {

    private final ListaDobleUsuario listU = ModeloDeDatos.obtenerInstancia().getListaU();
    private final PilaStack_Juego pila = ModeloDeDatos.obtenerInstancia().getPilaJ();
    private ObservableList<Pane> amigos;
    private ObservableList<Pane> filtroAmigos;
    private ObservableList<Pane> jugadores;
    private ObservableList<Pane> filtroJugadores;
    private ObservableList<Pane> enCarrito;

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
    @FXML
    private FlowPane flowRelacionado;
    @FXML
    private FlowPane flowAmigos;
    @FXML
    private TextField txtFiltroAmigo;
    @FXML
    private Pane Red;
    @FXML
    private Pane FC;
    @FXML
    private Pane Hogwarts;
    @FXML
    private Pane Grand;
    @FXML
    private Pane God;
    @FXML
    private Pane GhostRunner;
    @FXML
    private Pane Fornite;
    @FXML
    private Pane MultiVersus;
    @FXML
    private Pane FallOut;
    @FXML
    private Pane Valorant;
    @FXML
    private Pane Fall;
    @FXML
    private Pane TheHunter;
    @FXML
    private Pane Genshin;
    @FXML
    private Pane F1;
    @FXML
    private Pane Spider;
    @FXML
    private Pane PanelAddAmigos;
    @FXML
    private TextField txtFiltroAddAmigo;
    @FXML
    private FlowPane flowAddAmigos;
    @FXML
    private Pane PanelAmigos;
    @FXML
    private ScrollPane scrollPane_2;
    @FXML
    private AnchorPane anchorP2;
    @FXML
    private Pane M_Red;
    @FXML
    private Pane M_FC;
    @FXML
    private Pane M_Hogwarts;
    @FXML
    private Pane M_Grand;
    @FXML
    private Pane M_God;
    @FXML
    private Pane M_GhostRunner;
    @FXML
    private Pane M_Fornite;
    @FXML
    private Pane M_MultiVersus;
    @FXML
    private Pane M_FallOut;
    @FXML
    private Pane M_Valorant;
    @FXML
    private Pane M_Fall;
    @FXML
    private Pane M_TheHunter;
    @FXML
    private Pane M_Genshin;
    @FXML
    private Pane M_F1;
    @FXML
    private Pane M_Spider;
    @FXML
    private ScrollPane scrollPaneCarrito;
    @FXML
    private AnchorPane anchorP1;
    @FXML
    private Pane Panel_Cambiar_Clave;
    @FXML
    private Pane PanelValidacion;
    @FXML
    private TextField txt_NewNickName;
    @FXML
    private Button btn_ValidarClave;
    @FXML
    private PasswordField txt_VPassWord;
    @FXML
    private Pane PanelCambiar;
    @FXML
    private TextField txt_NewPassword;
    @FXML
    private Button btn_AceptarCalve;
    @FXML
    private PasswordField txt_VNewPassword;
    @FXML
    private Text txt_Texto;
    @FXML
    private FlowPane flowpaneGamesCarrito;
    @FXML
    private Button btn_IrComrprar;
    @FXML
    private ScrollPane scrollPaneListaD;
    @FXML
    private AnchorPane anchorP3;
    @FXML
    private FlowPane flowpaneGamesListaD;
    @FXML
    private Button btn_CERRAR;
    @FXML
    private HBox contenedorApartados;
    @FXML
    private Button IrAhora;
    @FXML
    private Pane PanelInfo_Red;
    @FXML
    private FlowPane FlowAcomprar;
    @FXML
    private Label txtPrecioPagar;
    @FXML
    private Label txtTotalPagar;
    @FXML
    private TextField txtMetodoNequi;
    @FXML
    private TextField txtMetodoTarjeta;
    @FXML
    private TextField txtMetodoDaviPlata;
    @FXML
    private Pane unicoAcomprar;
    @FXML
    private ScrollPane scrollPaneBiblioteca;
    @FXML
    private AnchorPane anchorP4;
    @FXML
    private FlowPane flowpaneGamesBiblioteca;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO      
        amigos = FXCollections.observableArrayList();
        filtroAmigos = FXCollections.observableArrayList();
        jugadores = FXCollections.observableArrayList();
        filtroJugadores = FXCollections.observableArrayList();

        anchorP.prefWidthProperty().bind(scrollPane.widthProperty());
        anchorP.prefHeightProperty().bind(scrollPane.heightProperty());
        flowpaneGames.prefWidthProperty().bind(anchorP.widthProperty());
        flowpaneGames.prefHeightProperty().bind(anchorP.heightProperty());

        anchorP1.prefWidthProperty().bind(scrollPaneCarrito.widthProperty());
        anchorP1.prefHeightProperty().bind(scrollPaneCarrito.heightProperty());
        flowpaneGamesCarrito.prefWidthProperty().bind(anchorP1.widthProperty());
        flowpaneGamesCarrito.prefHeightProperty().bind(anchorP1.heightProperty());

        anchorP4.prefWidthProperty().bind(scrollPaneBiblioteca.widthProperty());
        anchorP4.prefHeightProperty().bind(scrollPaneBiblioteca.heightProperty());
        flowpaneGamesBiblioteca.prefWidthProperty().bind(anchorP4.widthProperty());
        flowpaneGamesBiblioteca.prefHeightProperty().bind(anchorP4.heightProperty());

        listU.cargarDatosDesdeArchivoUsuarios();

        pila.cargarJuegos();
        pila.cargarJuegos2();
        pila.cargarJuegos3();
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

    public void cargarAmigos() {
        if (listU == null) {
            System.err.println("Error: listU es null.");
            return;
        }
        ObservableList<Nodo_Usuario> aux = listU.getUsuarios();

        for (Nodo_Usuario amigo : aux) {
            if (!amigo.getAmigos().isEmpty()) {

                crearAmigos(amigo);

            }

        }
    }

    private void assignRandomColor(Button button) {
        Random random = new Random();
        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        button.setStyle("-fx-background-color: " + toHexString(randomColor) + ";");
    }

    private String toHexString(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    private void crearJugadores() {
        Image image = new Image(getClass().getResourceAsStream("/Images/Icono_add_Amigo2.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/Images/Icono_add_Amigo1.png"));
        ObservableList<Nodo_Usuario> obsAux = FXCollections.observableArrayList();
        obsAux = listU.getUsuarios();

        if (!obsAux.isEmpty()) {
            jugadores.clear();
            Nodo_Usuario activo = listU.BuscarNick(labelNick.getText());
            String[] amigosAux = activo.getAmigos().split(". ");

            for (Nodo_Usuario usuario : obsAux) {
                if (usuario == null || usuario.getNombreJugador().equals(labelNick.getText())) {
                    continue;
                }

                boolean isAmigo = false;
                for (String amigo : amigosAux) {
                    if (amigo.equals(usuario.getNombreJugador())) {
                        isAmigo = true;
                        break;
                    }
                }

                if (isAmigo) {
                    continue;
                }

                Pane pane = new Pane();
                pane.getStyleClass().add("paneAmigos");
                pane.setPrefWidth(200);
                pane.setPrefHeight(40);

                Pane pane2 = new Pane();
                pane2.setPrefWidth(160);
                pane2.setPrefHeight(30);
                pane2.setLayoutX(36);
                pane2.setLayoutY(5);
                pane2.setId("pane");

                ImageView ima = new ImageView(image);
                ima.setPreserveRatio(true);
                ima.setFitWidth(30);
                ima.setFitHeight(25);
                ima.setLayoutX(120);
                ima.setLayoutY(2);

                Label label = new Label(usuario.getNombreJugador());
                label.setLayoutX(21);
                label.setLayoutY(6);
                label.setId("labelNick");
                label.setFont(Font.font("System", FontWeight.BOLD, 14));

                ima.setOnMouseClicked(event -> {
                    String nombreJugador = label.getText();
                    Nodo_Usuario newUser = listU.BuscarNick(labelNick.getText());
                    String LAmigos = newUser.getAmigos();
                    if (!LAmigos.isEmpty()) {
                        newUser.setAmigos(LAmigos + ". " + nombreJugador);
                        listU.eliminarUsuario(labelNick.getText());
                        listU.addUsuario(newUser.getNombre(), newUser.getIdentificacion(), newUser.getCelular(),
                                newUser.getCorreo(), newUser.getNombreJugador(), newUser.getClave(), newUser.getAmigos());
                        listU.guardarDatosEnArchivoUsuarios(listU);
                    }
                    flowAddAmigos.getChildren().remove(pane);

                });

                ima.setOnMouseEntered(value -> {
                    ima.setImage(image2);
                });

                ima.setOnMouseExited(value -> {
                    ima.setImage(image);
                });
                Label label1 = new Label(usuario.getNombreJugador().substring(0, 1));
                label1.setPrefWidth(20);
                label1.setLayoutX(0);
                label1.setLayoutY(0);
                label1.setId("label2");
                label1.setTextFill(Color.WHITE);
                label1.setFont(Font.font("System", FontWeight.BOLD, 25));

                Button button = new Button("", label1);
                button.setPrefWidth(44);
                button.setPrefHeight(44);
                button.setLayoutX(0);
                button.setLayoutY(0);
                button.setId("button");
                assignRandomColor(button);

                Circle circle = new Circle(6);
                circle.setFill(Color.FORESTGREEN);
                circle.setLayoutX(38);
                circle.setLayoutY(35);

                pane2.getChildren().addAll(label, ima);
                pane.getChildren().addAll(pane2, button, circle);
                jugadores.add(pane);
            }

            flowAddAmigos.getChildren().clear();
            flowAddAmigos.getChildren().addAll(jugadores);
        }
    }

    private void crearAmigos(Nodo_Usuario user) {
        String[] nAmigos = user.getAmigos().split("\\. ");

        Nodo_Usuario buscar = listU.BuscarNick(labelNick.getText());

        if (buscar.equals(user)) {
            amigos.clear();
            for (String nAmigo : nAmigos) {
                if (!nAmigo.isEmpty()) {
                    Pane pane = new Pane();
                    pane.getStyleClass().add("paneAmigos");
                    pane.setPrefWidth(200);
                    pane.setPrefHeight(40);

                    Pane pane2 = new Pane();
                    pane2.setPrefWidth(160);
                    pane2.setPrefHeight(30);
                    pane2.setLayoutX(36);
                    pane2.setLayoutY(5);
                    pane2.setId("pane");

                    Label label = new Label(nAmigo);
                    label.setLayoutX(21);
                    label.setLayoutY(6);
                    label.setId("labelNick");
                    label.setFont(Font.font("System", FontWeight.BOLD, 14));

                    Label label1 = new Label(label.getText().substring(0, 1));
                    label1.setPrefWidth(20);
                    label1.setLayoutX(0);
                    label1.setLayoutY(0);
                    label1.setId("label2");
                    label1.setTextFill(Color.WHITE);
                    label1.setFont(Font.font("System", FontWeight.BOLD, 25));

                    Button button = new Button("", label1);
                    button.setPrefWidth(44);
                    button.setPrefHeight(44);
                    button.setLayoutX(0);
                    button.setLayoutY(0);
                    button.setId("button");
                    assignRandomColor(button);

                    Circle circle = new Circle(6);
                    circle.setFill(Color.FORESTGREEN);
                    circle.setLayoutX(38);
                    circle.setLayoutY(35);
                    pane2.getChildren().add(label);
                    pane.getChildren().addAll(pane2, button, circle);
                    amigos.add(pane);
                }
            }
            flowAmigos.getChildren().clear();
            flowAmigos.getChildren().addAll(amigos);
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
            cargarAmigos();
        } else if (e.getSource().equals(btn_Friends)) {
            btn_Friends.getStyleClass().add("btnAfter");
            btn_addF.getStyleClass().removeAll("btnAfter");
            PanelAmigos.setVisible(true);
            PanelAddAmigos.setVisible(false);
            cargarAmigos();
        } else if (e.getSource().equals(btn_addF)) {
            btn_addF.getStyleClass().add("btnAfter");
            btn_Friends.getStyleClass().removeAll("btnAfter");
            PanelAmigos.setVisible(false);
            PanelAddAmigos.setVisible(true);
            crearJugadores();
        } else if (e.getSource().equals(btn_Shop)) {
            webView.getEngine().load(null);
            
            if (!scrollPane.isVisible()) {
                scrollPane.setVisible(true);
                contenedorApartados.setVisible(false);

                scrollPaneBiblioteca.setVisible(false);
                scrollPaneCarrito.setVisible(false);
                scrollPaneListaD.setVisible(false);
            }
            mostrarJuegosB();
            mostrarJuegos();
            mostrarJuegosC();
            mostrarJuegosLD();
        } else if (e.getSource().equals(btn_Biblioteca)) {
            webView.getEngine().load(null);

            if (!scrollPaneBiblioteca.isVisible()) {
                scrollPaneBiblioteca.setVisible(true);
                contenedorApartados.setVisible(false);

                scrollPane.setVisible(false);
                scrollPaneCarrito.setVisible(false);
                scrollPaneListaD.setVisible(false);
            }
            mostrarJuegosB();
            mostrarJuegos();
            mostrarJuegosC();
            mostrarJuegosLD();
        } else if (e.getSource().equals(btn_carrito)) {
            webView.getEngine().load(null);
            if (!scrollPaneCarrito.isVisible()) {
                scrollPaneCarrito.setVisible(true);
                scrollPane.setVisible(false);
                scrollPaneBiblioteca.setVisible(false);
                contenedorApartados.setVisible(false);
                scrollPaneListaD.setVisible(false);
            }
            mostrarJuegosB();
            mostrarJuegos();
            mostrarJuegosC();
            mostrarJuegosLD();
        } else if (e.getSource().equals(btn_ListD)) {
            webView.getEngine().load(null);
            if (!scrollPaneListaD.isVisible()) {
                scrollPaneCarrito.setVisible(false);
                scrollPane.setVisible(false);
                scrollPaneBiblioteca.setVisible(false);
                contenedorApartados.setVisible(false);
                scrollPaneListaD.setVisible(true);
            }
            mostrarJuegosB();
            mostrarJuegos();
            mostrarJuegosC();
            mostrarJuegosLD();
        } else if (e.getSource().equals(btn_IrComrprar)) {
            webView.getEngine().load(null);
            if (!panelDePago.isVisible()) {
                scrollPane.setVisible(false);
                scrollPaneCarrito.setVisible(false);
                panelDePago.setVisible(true);
                scrollPaneBiblioteca.setVisible(false);
                contenedorApartados.setVisible(false);
                scrollPaneListaD.setVisible(false);
            }
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
        } else if (e.getSource().equals(btn_CClave)) {

            txt_NewNickName.setText(labelNick.getText());
            Panel_Cambiar_Clave.setVisible(!Panel_Cambiar_Clave.isVisible());
            txt_Texto.setText("Hola " + labelNick.getText() + ", aquí puedes cambiar tu clave :)");

        } else if (e.getSource().equals(btn_ValidarClave)) {

            Alert a = new Alert(Alert.AlertType.NONE);

            String user = txt_NewNickName.getText();
            String pass = txt_VPassWord.getText();

            Nodo_Usuario usuario = listU.BuscarNick(user);

            if (usuario != null) {

                if (!usuario.getNombreJugador().equals(user) && !usuario.getClave().equals(pass)) {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Tanto el usuario como la contraseña son invalidos" + "\n"
                            + "Debe ingresar un usuario y una contraseña validas..!");
                    a.setTitle("Advertencia..!");
                    a.show();
                    txt_NewNickName.setText("");
                    txt_VPassWord.setText("");
                    txt_NewNickName.requestFocus();
                } else if (usuario.getNombreJugador().equals(user)) {

                    if (usuario.getClave().equals(pass)) {
                        txt_NewNickName.setText("");
                        txt_VPassWord.setText("");
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setContentText("Proceda a cambiar su contraseña");
                        a.setTitle("Información");
                        a.show();
                        PanelValidacion.setVisible(false);
                        PanelCambiar.setVisible(true);
                        txt_Texto.setText(labelNick.getText() + ", procede a cambiar tu clave...!! :)");
                    } else {
                        a.setAlertType(Alert.AlertType.WARNING);
                        a.setContentText("Contraseña incorrecta" + "\n"
                                + "Debe ingresar una contraseña valida");
                        a.setTitle("Advertencia..!");
                        a.show();
                        txt_VPassWord.setText("");
                        txt_VPassWord.requestFocus();
                    }
                } else {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Debe ingresar un nombre de usuario" + "\n"
                            + "O un correo valido");
                    a.setTitle("Advertencia..!");
                    a.show();
                    txt_NewNickName.setText("");
                    txt_NewNickName.requestFocus();
                }
            } else {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Usuario no encontrado..!");
                a.setTitle("Advertencia..!");
                a.show();
                txt_NewNickName.setText("");
                txt_VPassWord.requestFocus();
            }
        } else if (e.getSource().equals(btn_AceptarCalve)) {
            Alert a = new Alert(Alert.AlertType.NONE);

            String user = labelNick.getText();

            Nodo_Usuario usuario = listU.BuscarNick(user);

            if (!txt_NewPassword.getText().isEmpty() || !txt_VNewPassword.getText().isEmpty()) {

                if (txt_NewPassword.getText().equals(txt_VNewPassword.getText())) {

                    boolean listo = listU.eliminarUsuario(labelNick.getText());

                    usuario.setClave(txt_NewPassword.getText());

                    if (listo) {
                        txt_Texto.setText(labelNick.getText() + " Cambio de clave exitoso...!! :)");
                        listU.addUsuario(usuario.getNombre(), usuario.getIdentificacion(), usuario.getCelular(),
                                usuario.getCorreo(), usuario.getNombreJugador(), usuario.getClave(), usuario.getAmigos());

                        a.setAlertType(Alert.AlertType.CONFIRMATION);
                        a.setContentText("Cambio de clave exitoso..!");
                        a.setTitle("Información..!");
                        a.showAndWait();
                    }

                    listU.guardarDatosEnArchivoUsuarios(listU);

                    txt_NewNickName.setText("");
                    txt_VNewPassword.setText("");
                    txt_NewPassword.setText("");
                    txt_VPassWord.setText("");
                    PanelValidacion.setVisible(true);
                    PanelCambiar.setVisible(false);
                    Panel_Cambiar_Clave.setVisible(false);
                } else {
                    txt_VNewPassword.setText("");
                    txt_VNewPassword.requestFocus();
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Ups.. Parce que su contraseña no coincide\n"
                            + "Verifique y vuelva a intentar");
                    a.setTitle("Advertencia..!");
                    a.show();
                }
            }
        } else if (e.getSource().equals(btn_CERRAR)) {
            txt_NewNickName.setText("");
            txt_VNewPassword.setText("");
            txt_NewPassword.setText("");
            txt_VPassWord.setText("");
            PanelValidacion.setVisible(true);
            PanelCambiar.setVisible(false);
            Panel_Cambiar_Clave.setVisible(false);
        } else if (e.getSource().equals(IrAhora)) {
            panelDePago.setVisible(true);
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
        } else if (e.getSource().equals(btn_game7)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/HLUY1nICQRY?si=bMi5hUJPn0CRLT8q");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game8)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/b70uw0XxeLg?si=NGy38YrIYCd1uTIx");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game9)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/lGh8ZemDGek?si=HZOspT6NfUwEm8kc");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game10)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/dNYaEmIr_gs?si=JULnXTb_KCJV6Jce");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game11)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/gmA6MrX81z4?si=6ux6_6rUUgBVCtcn");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game12)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/VGOTYfGMyoE?si=4cQk_z9mMsliQZmS");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game13)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/QkkoHAzjnUs?si=hw3OafGS1bUq61tj");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game14)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/1O6Qstncpnc?si=n9KMnQvYgCWoBxyq");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        } else if (e.getSource().equals(btn_game15)) {
            webView.getEngine().load(null);
            webView = new WebView();
            WebEngine webEng = webView.getEngine();

            webEng.load("https://youtu.be/e_E9W2vsRbQ?si=rOsnmo2mVyf0YpCK");

            webEng.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    webEng.executeScript("document.body.style.overflow = 'hidden';");
                }
            });

            panePresent.getChildren().clear();
            panePresent.getChildren().add(webView);
        }
    }

    public void mostrarJuegos() {
        try {
            Nodo_Juego juego1 = pila.getJuegoNick(labelNick.getText());

            if (juego1 == null) {

                System.out.println("No se encontró ningún juego para el usuario: " + labelNick.getText());
                return;
            }

            if (!flowpaneGames.getChildren().isEmpty()) {
                Stack<Nodo_Juego> pilaJT = pila.getJuegosNick(juego1.getNickUser());

                for (Nodo_Juego juego : pilaJT) {
                    for (int a = 0; a < flowpaneGames.getChildren().size(); a++) {
                        Pane newPane = (Pane) flowpaneGames.getChildren().get(a);
                        String[] nombre = juego.getNombre().split(" ");
                        if (newPane.getId().equals(nombre[0])) {
                            flowpaneGames.getChildren().remove(a);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    public void mostrarJuegosB() {
        try {
            Nodo_Juego juego1 = pila.getJuegoNick(labelNick.getText());

            if (juego1 == null) {

                System.out.println("No se encontró ningún juego para el usuario: " + labelNick.getText());
                return;
            }

            if (!flowpaneGamesBiblioteca.getChildren().isEmpty()) {
                Stack<Nodo_Juego> pilaJB = pila.getJuegosNick(juego1.getNickUser());

                for (Nodo_Juego juego : pilaJB) {
                    for (int a = 0; a < flowpaneGamesBiblioteca.getChildren().size(); a++) {
                        Pane newPane = (Pane) flowpaneGamesBiblioteca.getChildren().get(a);
                        String[] nombre = juego.getNombre().split(" ");
                        if (!newPane.getId().equals(nombre[0])) {
                            flowpaneGamesBiblioteca.getChildren().remove(a);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    public void mostrarJuegosLD() {
        try {
            Nodo_Juego juego1 = pila.getJuegoNick2(labelNick.getText());

            if (juego1 == null) {

                System.out.println("No se encontró ningún juego para el usuario: " + labelNick.getText());
                return;
            }

            if (!flowpaneGamesListaD.getChildren().isEmpty()) {
                Stack<Nodo_Juego> pilaJL = pila.getJuegosNick2(juego1.getNickUser());

                for (Nodo_Juego juego : pilaJL) {
                    for (int a = 0; a < flowpaneGamesListaD.getChildren().size(); a++) {
                        Pane newPane = (Pane) flowpaneGamesListaD.getChildren().get(a);
                        String[] nombre = juego.getNombre().split(" ");
                        if (newPane.getId().equals(nombre[0])) {
                            flowpaneGamesListaD.getChildren().remove(a);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    public void mostrarJuegosC() {
        try {
            Nodo_Juego juego1 = pila.getJuegoNick3(labelNick.getText());

            if (juego1 == null) {

                System.out.println("No se encontró ningún juego para el usuario: " + labelNick.getText());
                return;
            }

            if (!flowpaneGamesCarrito.getChildren().isEmpty()) {
                Stack<Nodo_Juego> pilaJC = pila.getJuegosNick3(juego1.getNickUser());

                for (Nodo_Juego juego : pilaJC) {
                    for (int a = 0; a < flowpaneGamesCarrito.getChildren().size(); a++) {
                        Pane newPane = (Pane) flowpaneGamesCarrito.getChildren().get(a);
                        String[] nombre = juego.getNombre().split(" ");
                        if (newPane.getId().equals(nombre[0])) {
                            flowpaneGamesCarrito.getChildren().remove(a);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
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
            panelDePago.setVisible(false);
            scrollPane.setVisible(true);
        } else if (event.getSource().equals(btn_Pagar)) {

            if (!txtMetodoNequi.getText().isEmpty() || !txtMetodoTarjeta.getText().isEmpty() || !txtMetodoDaviPlata.getText().isEmpty()) {

                FlowAcomprar.getChildren().remove(unicoAcomprar);
                String titular = "";
                if (!txtMetodoNequi.getText().isEmpty()) {
                    titular = txtMetodoNequi.getText();
                } else if (!txtMetodoDaviPlata.getText().isEmpty()) {
                    titular = txtMetodoDaviPlata.getText();
                } else {
                    titular = labelNick.getText();
                }
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Advertencia..!");
                a.setContentText("Compra exitosa..!!\n"
                        + "Precio: " + txtPrecioPagar.getText() + "\n"
                        + "Total: " + txtTotalPagar.getText() + "\n\n"
                        + titular + "ya puedes encontrar tu juego en la biblioteca..!");
                txtPrecioPagar.setText("$0,0");
                txtTotalPagar.setText("$0,0");
                a.showAndWait();

                Stack<Nodo_Juego> aux = pila.getClonarJB();
                Stack<Nodo_Juego> aux2 = pila.getClonarJC();
                Nodo_Juego juegoAux = new Nodo_Juego(labelNick.getText(), "Red Dead", "/Images/Games_images/Ima_Red_Dead.png");
                aux.add(juegoAux);
                aux2.add(juegoAux);
                
                pila.guardarJuegos(aux);
                pila.guardarJuegos3(aux2);
                pila.cargarJuegos();
                mostrarJuegosB();
                mostrarJuegos();
                mostrarJuegosC();
                mostrarJuegosLD();
                panelDePago.setVisible(false);
                scrollPaneBiblioteca.setVisible(false);
                scrollPane.setVisible(true);

            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Advertencia..!");
                a.setContentText("Debes selecionar un metodo de pago...!");
                a.show();
            }
        }
    }

    @FXML
    private void filtrarAmigos(KeyEvent e) {

        if (e.getSource().equals(txtFiltroAmigo)) {
            String filtroNick = txtFiltroAmigo.getText().toLowerCase();

            if (filtroNick.isEmpty()) {

                cargarAmigos();

            } else {

                filtroAmigos.clear();

                for (Pane p : amigos) {

                    Label labelNickN = (Label) p.lookup("#labelNick");

                    if (labelNickN != null && labelNickN.getText().toLowerCase().contains(filtroNick)) {

                        filtroAmigos.add(p);
                    }
                }

                flowAmigos.getChildren().clear();
                flowAmigos.getChildren().addAll(filtroAmigos);

            }
        } else if (e.getSource().equals(txtFiltroAddAmigo)) {
            String filtroNick = txtFiltroAddAmigo.getText().toLowerCase();

            if (filtroNick.isEmpty()) {

                crearJugadores();

            } else {

                filtroJugadores.clear();

                for (Pane p : jugadores) {

                    Label labelNickN = (Label) p.lookup("#labelNick");

                    if (labelNickN != null && labelNickN.getText().toLowerCase().contains(filtroNick)) {

                        filtroJugadores.add(p);
                    }
                }

                flowAddAmigos.getChildren().clear();
                flowAddAmigos.getChildren().addAll(filtroJugadores);

            }
        }

    }

    @FXML
    private void MostrarJuego(MouseEvent event) {
        ImageView ima = (ImageView) event.getSource();

        switch (ima.getParent().getId()) {
            case "Red":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());

                scrollPane.setVisible(false);

                contenedorApartados.setVisible(true);
                M_Red.setVisible(true);
                PanelInfo_Red.setVisible(true);
                break;
            case "FC":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Hogwarts":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Grand":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "God":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "GhostRunner":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Fornite":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "MultiVersus":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "FallOut":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Valorant":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Fall":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "TheHunter":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Genshin":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "F1":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            case "Spider":

                webView.getEngine().load(null);
                System.out.println(ima.getParent().getId());
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void mandarListaD(ActionEvent event) {

        Button btnAux = (Button) event.getSource();

        switch (btnAux.getParent().getId()) {
            case "Red":
                Stack<Nodo_Juego> aux1 = pila.getClonarJC();

                Nodo_Juego juego = new Nodo_Juego(labelNick.getText(), "Red Dead", "/Images/Games_images/Ima_Red_Dead.png");
                aux1.add(juego);

                pila.guardarJuegos3(aux1);

                pila.cargarJuegos3();

                mostrarJuegosC();
                break;

            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void mandarCarrito(ActionEvent event) {

        Button btnAux = (Button) event.getSource();
        switch (btnAux.getParent().getId()) {
            case "Red":
                Stack<Nodo_Juego> aux1 = pila.getClonarJC();
                Stack<Nodo_Juego> aux2 = pila.getClonarJL();

                Nodo_Juego juego = new Nodo_Juego(labelNick.getText(), "Red Dead", "/Images/Games_images/Ima_Red_Dead.png");
                aux2.add(juego);

                pila.eliminar3(aux1, "Red", labelNick.getText());

                pila.guardarJuegos3(aux1);
                pila.guardarJuegos2(aux2);

                if (pila.limpiar2()) {
                    pila.cargarJuegos2();
                }

                if (pila.limpiar3()) {
                    pila.cargarJuegos3();
                }

                mostrarJuegosC();
                mostrarJuegosLD();
                break;

            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void agrgarCarrito(ActionEvent event) {

        if (M_Red.isVisible()) {
            Stack<Nodo_Juego> aux = pila.getClonarJC();
            pila.eliminar3(aux, "Red", labelNick.getText());

            pila.guardarJuegos3(aux);

            pila.cargarJuegos3();
            flowpaneGamesCarrito.getChildren().clear();
            mostrarJuegosC();
        }
    }
}
