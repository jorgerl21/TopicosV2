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

public class frmTipoPlatillos extends Stage {
    private TextField txtDescTipo;
    private ComboBox<TipoPlatilloDAO> cbxTipo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private TipoPlatilloDAO objTipoPlatillo;
    private TableView<TipoPlatilloDAO> tbvtipoPlatillos;

    public frmTipoPlatillos(TableView<TipoPlatilloDAO> tbvtipoPlatillos, TipoPlatilloDAO objTipoPlatillo) {
        if(objTipoPlatillo != null)
            this.objTipoPlatillo = objTipoPlatillo;
        else
            this.objTipoPlatillo = new TipoPlatilloDAO();

        CrearUI();
        this.setTitle("Gestion de Tipos de Platillos");
        this.setScene(escena);
        this.show();

        this.tbvtipoPlatillos = tbvtipoPlatillos;
    }

    private void CrearUI() {
        txtDescTipo = new TextField();
        txtDescTipo.setText(objTipoPlatillo.getDesc_tipo());
        /*txtPrecio = new TextField();
        txtPrecio.setText(objPlatillo.getPrecio()+"");*/

        cbxTipo = new ComboBox<>();
        cbxTipo.setItems(new TipoPlatilloDAO().getAllTipo());

        btnGuardar = new Button("Guardar Platillo");
        btnGuardar.setOnAction(actionEvent -> Guardar());
        vBox = new VBox();
        vBox.getChildren().addAll(txtDescTipo,cbxTipo,btnGuardar);
        escena = new Scene(vBox, 250,250);
    }

    private void Guardar() {
        objTipoPlatillo.setDesc_tipo(txtDescTipo.getText());

        if (objTipoPlatillo.getId_tipo()>=1) { //actualiza tipo de platillo
            objTipoPlatillo.upTipo();
        } else {                    //agregar un nuevo tipo de platillo
            objTipoPlatillo.insTipo();
        }
        tbvtipoPlatillos.setItems(objTipoPlatillo.getTipo());
        tbvtipoPlatillos.refresh();
        this.close();
    }
}















//objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
//objPlatillo.setId_tipo(1);  // Valor fijo temporalmente
//objTipoPlatillo

        /*if (objTipoPlatillo == null) {//proceso nuevo platillo
            objTipoPlatillo.insTipo();
        }else{
            objTipoPlatillo.upTipo();//proceso actualizar platillo
        }*/