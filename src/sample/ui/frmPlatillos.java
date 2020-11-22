package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class frmPlatillos extends Stage {
    private TextField txtPlatillo, txtPrecio;
    private ComboBox<TipoPlatilloDAO> cbxTipo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private PlatillosDAO objPlatillo;
    private TableView<PlatillosDAO> tbvplatillos;

    public  frmPlatillos(TableView<PlatillosDAO> tbvPlatillos,PlatillosDAO objPlatillo){

        if (objPlatillo != null)
            this.objPlatillo = objPlatillo;
        else
            this.objPlatillo = new PlatillosDAO();

        CrearUI();
        this.setTitle("Gestion de Platillos");
        this.setScene(escena);
        this.show();

        this.tbvplatillos = tbvPlatillos;
    }

    private void CrearUI() {
        txtPlatillo = new TextField();
        txtPlatillo.setText(objPlatillo.getNombre_platillo());
        txtPrecio = new TextField();
        txtPrecio.setText(objPlatillo.getPrecio()+"");

        cbxTipo = new ComboBox<>();
        cbxTipo.setItems(new TipoPlatilloDAO().getAllTipo());

        btnGuardar = new Button("Guardar Platillo");
        btnGuardar.setOnAction(actionEvent -> Guardar());
        vBox = new VBox();
        vBox.getChildren().addAll(txtPlatillo,txtPrecio,cbxTipo,btnGuardar);
        escena = new Scene(vBox, 250,250);
    }
    private void Guardar(){
        objPlatillo.setNombre_platillo(txtPlatillo.getText());
        objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objPlatillo.setId_tipo(1);  // Valor fijo temporalmente

        if (objPlatillo.getId_platillo() >= 1) { //nuevo platillo
            objPlatillo.upPlatillo();
        } else {                    //actualiza platillo
            objPlatillo.insPlatillo();
        }
        tbvplatillos.setItems(objPlatillo.getAllPlatillo());
        tbvplatillos.refresh();
        this.close();
    }
}
