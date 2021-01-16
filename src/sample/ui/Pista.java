package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.components.ButtonCustometp;
import sample.components.HiloCorredor;

public class Pista extends Stage {

    private String[] arNombres = {"Sonic","Flash","Meteoro","Superman","Quicksilver"};
    private Scene escena;
    private VBox vBox;
    private ProgressBar[] pgbCarril = new ProgressBar[arNombres.length];
    private HiloCorredor[] arHilos = new HiloCorredor[arNombres.length];
    //private Button btnIniciar;


    public Pista(){
     CrearUI();
     this.setTitle("Pista de atletismo");
     this.setScene(escena);
     this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        for (int i = 0; i < arNombres.length; i++) {
            pgbCarril[i] = new ProgressBar(0);
            arHilos[i] = new HiloCorredor(pgbCarril[i]);
            arHilos[i].start();
            vBox.getChildren().add(pgbCarril[i]);
        }
        escena = new Scene(vBox,250,250);
    }
}
