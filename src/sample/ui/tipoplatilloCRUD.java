package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.ButtonCostume;
import sample.components.ButtonCustometp;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class tipoplatilloCRUD extends Stage {
    private VBox vBox;
    private TableView<TipoPlatilloDAO> tbvtipoPlatillos;
    private Button btnNuevotp;
    private Scene escena;
    private TipoPlatilloDAO objTPDAO;

    public tipoplatilloCRUD(){
        objTPDAO = new TipoPlatilloDAO();
        CrearUI();

        this.setTitle("administracion de platillos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvtipoPlatillos = new TableView<>();
        CrearTabla();
        btnNuevotp = new Button("nuevo tipo de platillo");
        btnNuevotp.setOnAction(actionEvent -> {new frmTipoPlatillos(tbvtipoPlatillos, null);});
        vBox = new VBox();
        vBox.getChildren().addAll(tbvtipoPlatillos,btnNuevotp);
        //vBox.getChildren().addAll(tbvtipoPlatillos,btnNuevotp);
        escena = new Scene(vBox, 300,250);
    }

    private void CrearTabla() {
        TableColumn<TipoPlatilloDAO, Integer> tbcIdTipo = new TableColumn<>("ID");
        tbcIdTipo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));

        TableColumn<TipoPlatilloDAO, String> tbcDescTipo = new TableColumn<>("Descripcion");
        tbcDescTipo.setCellValueFactory(new PropertyValueFactory<>("desc_tipo"));

        /*TableColumn<PlatillosDAO, Float> tbcPrecioPlatillo = new TableColumn<>("Precio");
        tbcPrecioPlatillo.setCellValueFactory(new PropertyValueFactory<>("precio"));*/

        TableColumn<TipoPlatilloDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
            @Override
            public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                return new ButtonCustometp(1);
            }
        });

        TableColumn<TipoPlatilloDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
            @Override
            public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                return new ButtonCustometp(2);
            }
        });

        tbvtipoPlatillos.getColumns().addAll(tbcIdTipo, tbcDescTipo, tbcEditar, tbcBorrar);
        tbvtipoPlatillos.setItems(objTPDAO.getAllTipo());
    }
}
