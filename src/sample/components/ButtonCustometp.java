package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.TipoPlatilloDAO;
import sample.ui.frmTipoPlatillos;

import java.util.Optional;

public class ButtonCustometp extends TableCell<TipoPlatilloDAO, String> {

    private Button btnCeldatp;
    private TipoPlatilloDAO objTipoPlatillo;

    public ButtonCustometp(int opctp){
        if(opctp == 1 ){
            btnCeldatp = new Button("Editar");
            btnCeldatp.setOnAction(actionEvent -> {
                objTipoPlatillo = ButtonCustometp.this.getTableView().getItems().get(ButtonCustometp.this.getIndex());
                new frmTipoPlatillos(ButtonCustometp.this.getTableView(),objTipoPlatillo);
            });
        }
        else {
            btnCeldatp = new Button("Borrar");
            btnCeldatp.setOnAction(actionEvent -> {

                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Mensaje del sistema");
                alerta.setHeaderText("Confirmando accion");
                alerta.setContentText("¿realmente deseas borrar el registro?");
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    //ontenemos el objeto de tio platillos de acuerdo al renglon seleccionado
                    objTipoPlatillo = ButtonCustometp.this.getTableView().getItems().get(ButtonCustometp.this.getIndex());//regersa primero la tabla y luego toda la lista observable
                    objTipoPlatillo.delTipo();

                    //actualizamos tableview
                    ButtonCustometp.this.getTableView().setItems(objTipoPlatillo.getAllTipo());
                    ButtonCustometp.this.getTableView().refresh();
                }
            });
        }
    }
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            setGraphic(btnCeldatp);
    }
}
