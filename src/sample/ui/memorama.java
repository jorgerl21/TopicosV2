package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.eventomemorama;

import javax.swing.*;

public class memorama extends Stage implements EventHandler {

    private String[] arImagenes ={"blastoise.png","blaziken.png","charizard.png","chesnaught.png","decidueye.png","delphox.png","emboar.png","empoleon.png","feraligatr.png","greninja.png","infernape.png","meganium.png","pikachu.png","primarina.png","samurott.png","sceptie.png","serperior.png","swampert.png","torterra.png","typhlosion.png","venasaur.png"};

    private Label lblConteo;
    private int cont;
    private Label lblTarjetas;
    private TextField txtNoTarjetas;
    private Button btnAceptar, btnAceptar2;
    private HBox hbox;
    private VBox vbox;
    private GridPane gdpMesa;
    private int noPares;
    private int[][] arEstados;
    private Button[][] arTarjetas;
    private String[][] arAsignacion;
    private ScrollPane sc;
    private Scene escena;
    private int par,noPar,anterior1,anterior2,anterior3,anterior4;
    private String ant1,ant2;

    public memorama(){

        crearui();
        this.setTitle("Memorama :)");
        this.setScene(escena);
        this.show();

    }

    private void crearui() {
        lblConteo= new Label("Numero de movimientos: "+cont);
        cont=0;
        lblTarjetas = new Label("Numero de pares: ");
        txtNoTarjetas = new TextField();
        btnAceptar = new Button("Voltear y revolver");
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        sc= new ScrollPane();
        hbox = new HBox();
        hbox.getChildren().addAll(lblTarjetas,txtNoTarjetas,btnAceptar,lblConteo);
        hbox.setSpacing(10);

        gdpMesa = new GridPane();
        vbox= new VBox();
        vbox.getChildren().addAll(hbox,gdpMesa);
        sc.setContent(vbox);
        escena = new Scene(sc, 550, 400);


    }

    @Override
    public void handle(Event event) {
        cont=0;
        noPar=0;
        anterior1 = 0;
        anterior2 = 0;
        anterior3=0;
        anterior4=0;
        ant1 = "";
        ant2 = "";
        par=0;
        noPar=0;
        lblConteo.setText("Numero de movimientos: "+cont);
        noPares = Integer.parseInt(txtNoTarjetas.getText());

        vbox.getChildren().remove(gdpMesa);

        gdpMesa = new GridPane();
        arAsignacion= new String[2][noPares];
        revolver();

        arTarjetas= new Button[2][noPares];
        arEstados= new int[2][noPares];
        for (int i = 0; i < 2; i++) {
            for (int j=0; j<noPares; j++){


                Image img = new Image("assets/pokemoncard.jpg");
                ImageView imv = new ImageView(img);
                imv.setFitHeight(120);
                imv.setPreserveRatio(true);
                arEstados[i][j]=0;
                arTarjetas[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                arTarjetas[i][j].setStyle("-fx-Color: #333333");
                arTarjetas[i][j].setOnAction(event1->verTarjeta(finalI,finalJ));
                arTarjetas[i][j].setGraphic(imv);
                arTarjetas[i][j].setPrefSize(80,120);

                gdpMesa.add(arTarjetas[i][j],j,i);
            }
        }

        vbox.getChildren().add(gdpMesa);

    }

    private void verTarjeta(int finalI, int finalJ) {
        if (arEstados[finalI][finalJ] == 0){
            ant1 = "" + arAsignacion[finalI][finalJ];

            Image img = new Image("assets/" + arAsignacion[finalI][finalJ]);
            ImageView imv = new ImageView(img);
            imv.setFitHeight(120);
            imv.setFitWidth(87);
            imv.setPreserveRatio(true);
            arTarjetas[finalI][finalJ].setGraphic(imv);
            if (par == 0) {

                if(noPar==1){

                    Image img2 = new Image("assets/pokemoncard.jpg");
                    ImageView imv2 = new ImageView(img2);
                    imv2.setFitHeight(120);
                    imv2.setPreserveRatio(true);

                    Image img3 = new Image("assets/pokemoncard.jpg");
                    ImageView imv3 = new ImageView(img3);
                    imv3.setFitHeight(120);
                    imv3.setPreserveRatio(true);

                    arTarjetas[anterior1][anterior2].setGraphic(imv2);

                    arTarjetas[anterior3][anterior4].setGraphic(imv3);
                    anterior3 = 0;
                    anterior4 = 0;
                    noPar=0;
                }
                par = 1;
                anterior1 = finalI;
                anterior2 = finalJ;
                ant2 = "" + arAsignacion[finalI][finalJ];
                Image img4 = new Image("assets/" + arAsignacion[finalI][finalJ]);
                ImageView imv4 = new ImageView(img4);
                imv4.setFitHeight(120);
                imv4.setFitWidth(80);
                imv4.setPreserveRatio(true);
                arTarjetas[finalI][finalJ].setGraphic(imv4);

            } else if (par == 1) {
                par = 0;
                cont++;
                lblConteo.setText("Numero de movimientos: " + cont);
                if (ant1.equals(ant2)) {
                    if (finalI == anterior1 && finalJ == anterior2) {
                        noPar=1;
                        anterior3=finalI;
                        anterior4=finalJ;
                        ant1 = "";
                        ant2 = "";
                        par=0;
                    } else{
                        arEstados[finalI][finalJ] = 1;
                        arEstados[anterior1][anterior2] = 1;
                        anterior1 = 0;
                        anterior2 = 0;
                        anterior3 = 0;
                        anterior4 = 0;
                        ant1 = "";
                        ant2 = "";
                        par = 0;
                        noPar = 0;
                        int suma = 0;
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < noPares; j++) {
                                suma = suma + arEstados[i][j];
                            }

                        }
                        if (suma == (noPares * 2)) {
                            JOptionPane.showMessageDialog(null, "¡FELICIDADES! completo el memorama en " + cont + " movimientos");
                        }
                    }
                } else {
                    noPar=1;
                    anterior3=finalI;
                    anterior4=finalJ;
                    ant1 = "";
                    ant2 = "";
                    par=0;

                }

            }
        }
    }

    private void revolver() {
        for(int i=0; i<2; i++)
            for(int j=0; j<noPares; j++){
                arAsignacion[i][j] = new String();
            }

        int posx, posy, cont = 0;
        for(int i=0; i<noPares;){
            posx = (int)(Math.random() * 2);
            posy = (int)(Math.random() * noPares);
            if( arAsignacion[posx][posy].equals("") ){
                arAsignacion[posx][posy] = arImagenes[i];
                cont++;
            }

            if(cont == 2){ // Sirve para comprobar que la imagen se asignó 2 veces
                i++;
                cont = 0;
            }
        }
    }
}