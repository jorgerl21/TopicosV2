package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.PlatillosDAO;
import sample.ui.frmPlatillos;

import java.sql.SQLOutput;
import java.util.Optional;

public class ButtonCostume extends TableCell<PlatillosDAO,String> {
//celda personalizada de tipo boton
    private Button btnCelda;
    private PlatillosDAO objPlatillo;

    public ButtonCostume(int opc){
        if (opc == 1) {
            btnCelda = new Button("Editar");
            btnCelda.setOnAction(actionEvent -> {
                objPlatillo = ButtonCostume.this.getTableView().getItems().get(ButtonCostume.this.getIndex());
                new frmPlatillos(ButtonCostume.this.getTableView(),objPlatillo);

            });
        }
        else {
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(actionEvent -> {

                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Mensaje del sistema");
                alerta.setHeaderText("Confirmando accion");
                alerta.setContentText("¿realmente deseas borrar el registro?");
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    //ontenemos el objeto de tio platillos de acuerdo al renglon seleccionado
                    objPlatillo = ButtonCostume.this.getTableView().getItems().get(ButtonCostume.this.getIndex());//regersa primero la tabla y luego toda la lista observable
                    objPlatillo.delPlatillo();

                    //actualizamos tableview
                    ButtonCostume.this.getTableView().setItems(objPlatillo.getAllPlatillo());
                    ButtonCostume.this.getTableView().refresh();
                }
            });
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            setGraphic(btnCelda);
    }
}
