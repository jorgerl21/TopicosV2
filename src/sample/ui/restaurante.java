package sample.ui;

import javafx.stage.Stage;

public class restaurante extends Stage {


    public restaurante() {
        CrearUI();
        this.setTitle("restaurante :)");
        this.show();
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