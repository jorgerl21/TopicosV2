package sample.ui;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;

public class Dashboard extends Stage {

    private TableView<PlatillosDAO> id_platillo;



    public Dashboard() {
        CrearUI();
        this.setTitle("panel de administracion del restaurante el antojito");
        this.show();

        new platilloCRUD();
    }

    private void CrearUI() {

    }

}


/*java una clase es una tabla de una base de datos
* un objeto en java es u registro en  una db
* */

//Empleados *
//clientes (domicilio) *
//platillos (precio) *
//tipo de platillo *
//insumos (existencia)
//proveedores
//pedidos *
//sucursales
//tipos de pago
//reservacion
//mesas *
//tipo de pedido (enviar/en restaurante/ llevar)

//                MESA
//                  1
//                  |
//                  N
//empleado 1 - N pedido N - 1 cliente
//                  N
//                  |-------DETALLE_PEDIDO (CANTIDAD/PRECIO/DESCUENTO)
//                  N
//             PALTILLOS N - 1 TIPO PLATILLO

//DAO object acces data 