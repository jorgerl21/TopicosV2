package sample.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class taquimecanografo extends Stage implements EventHandler <KeyEvent>
{

    Boolean banColor = false;
    //arreglos para etiquetar los botones del teclado

    private String[] arlblbtn1 = {"ESC","f1","f2","f3","f4","f5","f6","f7","f8","f9","f10","f11","f12"};

    private String[] arlblbtn2 = {"|","1","2","3","4","5","6","7","8","9","0","'","¿","BS"};

    private String[] arlblbtn3 = {"TAB","Q","W","E","R","T","Y","I","I","O","P","´","+","}"};

    private String[] arlblbtn4 = {"BM","A","S","D","F","G","H","I","J","K","L","Ñ","ENTER"};

    private String[] arlblbtn5 = {"↑","↔","Z","X","C","V","B","N","M",",",".","-","↑"};

    //private String[] arlblbtn6 = {"as","ad","af","ag","ah"};
    private String[] arlblbtn6 = {"ctrl","alt","espace","altgr","ctrl","left","rigth"};

    //elementos para el toolbar
    private ToolBar tlbMenu;
    private Button btnAbrir;

    //elementos para laescritura
    private TextArea txaContenido, txaEscritura;

    //elementos para el teclado
    private HBox[] arHBTeclas = new HBox[6];
    private VBox  vbTeclado;
    private Button[] arBtnTeclado1 = new Button[13];
    private Button[] arBtnTeclado2 = new Button[14];
    private Button[] arBtnTeclado3 = new Button[14];
    private Button[] arBtnTeclado4 = new Button[13];
    private Button[] arBtnTeclado5 = new Button[13];
    private Button[] arBtnTeclado6 = new Button[7];
    //private Button[] arBtnTeclado6 = new Button[7];


    private FileChooser flcArchivos;

    //elementos de agrupacio gloobal
    private VBox vboxPrincipal;
    private Scene escena;


    public taquimecanografo()
    {

        CrearUI();

        this.setTitle("tutor de mecanografia");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI()
    {
        CrearToolbar();
        CrearEscritura();
        CrearTeclado();

        vboxPrincipal = new VBox();
        vboxPrincipal.getChildren().addAll(tlbMenu, txaContenido,txaEscritura,vbTeclado);
        vboxPrincipal.setSpacing(10);
        vboxPrincipal.setPadding(new Insets(10));
        escena = new Scene(vboxPrincipal, 800,500);
    }

    private void CrearTeclado()
    {
        vbTeclado = new VBox();
        vbTeclado.setSpacing(8);

        for (int i = 0; i < arHBTeclas.length; i++)
        {
            arHBTeclas[i] = new HBox();
            arHBTeclas[i].setSpacing(10);
        }

        for (int i = 0; i < arBtnTeclado1.length; i++)
        {
            arBtnTeclado1[i] = new Button(arlblbtn1[i]);
            arBtnTeclado1[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[0].getChildren().add(arBtnTeclado1[i]);
            //arBtnTeclado2[i] = new Button(arlblbtn2[i]);
            //arBtnTeclado2[i].setStyle("-fx-background-color: #85D4D6;");
            //arBtnTeclado3[i] = new Button(arlblbtn3[i]);
            //arBtnTeclado4[i] = new Button(arlblbtn4[i]);
            //arBtnTeclado5[i] = new Button(arlblbtn5[i]);

            //arBtnTeclado6[i] = new Button(arlblbtn6[i]);

            //arBtnTeclado6[i] = new Button(arlblbtn6[i]);
            //arBtnTeclado3[i] = new Button(arlblbtn4[i]);
            //arBtnTeclado3[i] = new Button(arlblbtn5[i]);
            //arBtnTeclado3[i] = new Button(arlblbtn6[i]);

            //arHBTeclas[0].getChildren().add(arBtnTeclado1[i]);
            //arHBTeclas[1].getChildren().add(arBtnTeclado2[i]);
            //arHBTeclas[2].getChildren().add(arBtnTeclado3[i]);
            //arHBTeclas[3].getChildren().add(arBtnTeclado4[i]);
            //arHBTeclas[4].getChildren().add(arBtnTeclado5[i]);

            //arHBTeclas[5].getChildren().add(arBtnTeclado6[i]);

            //arHBTeclas[5].getChildren().add(arBtnTeclado6[i]);

            //arHBTeclas[3].getChildren().add(arBtnTeclado4[i]);
            //arHBTeclas[4].getChildren().add(arBtnTeclado5[i]);
            //arHBTeclas[5].getChildren().add(arBtnTeclado6[i]);
        }
        for (int i = 0; i < arBtnTeclado2.length; i++) {
            arBtnTeclado2[i] = new Button(arlblbtn2[i]);
            arBtnTeclado2[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[1].getChildren().add(arBtnTeclado2[i]);
        }
        for (int i = 0; i < arBtnTeclado3.length; i++) {
            arBtnTeclado3[i] = new Button(arlblbtn3[i]);
            arBtnTeclado3[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[2].getChildren().add(arBtnTeclado3[i]);
        }
        for (int i = 0; i < arBtnTeclado4.length; i++) {
            arBtnTeclado4[i] = new Button(arlblbtn4[i]);
            arBtnTeclado4[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[3].getChildren().add(arBtnTeclado4[i]);
        }
        for (int i = 0; i < arBtnTeclado5.length; i++) {
            arBtnTeclado5[i] = new Button(arlblbtn5[i]);
            arBtnTeclado5[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[4].getChildren().add(arBtnTeclado5[i]);
        }
        for (int i = 0; i < arBtnTeclado6.length; i++) {
            arBtnTeclado6[i] = new Button(arlblbtn6[i]);
            arBtnTeclado6[i].setStyle("-fx-background-color: #85D4D6;");
            arHBTeclas[5].getChildren().add(arBtnTeclado6[i]);
        }



        vbTeclado.getChildren().addAll(arHBTeclas[0],arHBTeclas[1],arHBTeclas[2],arHBTeclas[3],arHBTeclas[4],arHBTeclas[5]);
    }

    private void CrearEscritura()
    {
        txaContenido = new TextArea();
        txaContenido.setEditable(false);
        txaContenido.setPrefRowCount(6);
        txaEscritura = new TextArea();
        txaEscritura.setPrefRowCount(6);
        txaEscritura.setOnKeyPressed(this);
        txaEscritura.setOnKeyReleased(this);
        //addEventHandler(KeyEvent.KEY_TYPED, this);
    }

    private void CrearToolbar()
    {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();
        btnAbrir.setOnAction(actionEvent -> eventoTaqui(1));
        btnAbrir.setPrefSize(64,64);

        Image img = new Image("assets/keyboard.png");
        ImageView imv = new ImageView(img);
        imv.setFitHeight(64);
        imv.setPreserveRatio(true);
        btnAbrir.setGraphic(imv);
        tlbMenu.getItems().addAll(btnAbrir);
    }

    private void eventoTaqui( int opc)
    {
        switch (opc)
        {
            case 1:
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("abrir archivo");
                File file =  fileChooser.showOpenDialog(this);
        }
    }

    @Override
    public void handle(KeyEvent event)
    {
        switch (event.getCode().toString())
        {
            case "BACK_SPACE":
                if (banColor == false)
                    arBtnTeclado2[14].setStyle("-fx-background-color: #1d1d1d;");
                else
                    arBtnTeclado2[14].setStyle("-fx-background-color: #85D4D6;");
                break;
        }
        banColor = !banColor;
    }
}