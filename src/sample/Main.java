package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.models.Conexion;
import sample.ui.Dashboard;
import sample.ui.memorama;
import sample.ui.Dashboard;
import sample.ui.taquimecanografo;

public class Main extends Application implements EventHandler {
//declara las variables del software

    private VBox vPrincipal;

    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmMemrama, itmRestaurante, itmTerminar;
    private Scene escena;

    private ToolBar tlbMenu;
    private Button btnToolBar1;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        CrearUI();
        primaryStage.setTitle("Practicas de Topicos 2020");
        primaryStage.setMaximized(true);
        primaryStage.setScene(escena);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING, this);
        primaryStage.show();

        Conexion.crearConexion();
        
    }

    private void CrearUI() {
        mnbPrincipal = new MenuBar();

        //creacion de los menus
        menCompetencia1= new Menu("competencia 1");
        menCompetencia2 = new Menu("competencia 2");
        menSalir = new Menu("salir");

        //caragar los menus a la barra de menus
        mnbPrincipal.getMenus().addAll(menCompetencia1, menCompetencia2, menSalir);

        //creamos el menu item para el memorama de la primer competencia
        itmMemrama = new MenuItem("memorama");
        itmMemrama.setOnAction(actionEvent -> opcionMenu(1));

        itmMemrama = new MenuItem("taquimecanografo");
        itmMemrama.setOnAction(actionEvent -> opcionMenu(2));

        itmRestaurante = new MenuItem("Restaurante");
        itmRestaurante.setOnAction(actionEvent -> opcionMenu(3));

        itmTerminar= new MenuItem("hasta pronto");
        itmTerminar.setOnAction(actionEvent -> {System.exit(0);});

        //caragr el item memorama a l menu competencia1
        menCompetencia1.getItems().addAll(itmMemrama);
        menCompetencia2.getItems().addAll(itmRestaurante);
        menSalir.getItems().add(itmTerminar);


        //crear una barra de heramientas
        tlbMenu = new ToolBar();
        btnToolBar1 = new Button();
        btnToolBar1.setOnAction(actionEvent -> opcionMenu(1));
        btnToolBar1.setPrefSize(64,64);

        //asignamos la imagen dentro del toolbar
        Image img = new Image("assets/game.png");
        ImageView imv = new ImageView(img);
        imv.setFitHeight(64);
        imv.setPreserveRatio(true);
        btnToolBar1.setGraphic(imv);


        tlbMenu.getItems().addAll(btnToolBar1);


        vPrincipal = new VBox();
        vPrincipal.getChildren().addAll(mnbPrincipal,tlbMenu);
        escena = new Scene(vPrincipal);
        escena.getStylesheets().add("assets/css/main_style.css");
    }

    private void opcionMenu(int opc) {
        switch (opc){
            case 1 :
                new memorama();
                break;
            case 2:
                new taquimecanografo();
                break;
            case 3:
                new Dashboard();
                break;
            case 4:
                //new PistaAtletismo();
                break;
            case 20:
                System.exit(0);
        };

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        System.out.println("quibole");
    }
}
