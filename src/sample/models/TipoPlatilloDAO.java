package sample.models;

import java.sql.Statement;

public class TipoPlatilloDAO {

    private int id_tipo;
    private String desc_tipo;

    public int getId_tipo() { return id_tipo; }
    public void setId_tipo(int id_tipo) { this.id_tipo = id_tipo; }
    public String getDesc_tipo() { return desc_tipo; }
    public void setDesc_tipo(String desc_tipo) { this.desc_tipo = desc_tipo; }

    public void insTipo(){
        try{
            String query = "INSERT INTO tbl_tipoplatillo (desc_tipo) VALUES ('"+desc_tipo+"')";
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void upTipo(){
        try{
            String query = "UPDATE tbl_tipoplatillo SET desc_tipo ='"+desc_tipo+"' WHERE id_tipo = "+id_tipo;
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delTipo(){
        try {
            String query = "DELETE FROM tbl_tipoplatillo WHERE id_tipo = "+id_tipo;
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getAllTipo(){}
    public void getTipo(){}
}
