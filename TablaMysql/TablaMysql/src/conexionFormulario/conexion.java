
package conexionFormulario;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ariel
 */
public class conexion {
    
    //variables de conexion
    private static String db = "bdprueba2";
    private static String user = "root";
    private static String pass = "12345";
    private static String host = "localhost:3306";
    private static String server = "jdbc:mysql://"+host+"/"+db;
    
    public static Connection conectar(){
        
//metodo que permite la conexion a la BD
        //por medio del conector JDBC
        Connection cn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(server, user, pass);
JOptionPane.showMessageDialog(null, "Conexion correcta a la BD: " +db, "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
JOptionPane.showMessageDialog(null, "No se logro realizar la conexion a la BD", "Informacion", JOptionPane.WARNING_MESSAGE);
        System.out.println(String.valueOf(e));
        }
        return cn;
    }//fin del metodo conectar
    
    public static ResultSet getTable(String Consulta){
        
        Connection cn = conectar();
        Statement st;
        ResultSet datos = null;
        
        try{
            st = cn.createStatement();
            datos = st.executeQuery(Consulta);
        }catch (Exception e){
            System.out.print(e.toString());
        }
        
        return datos;
    }//fin del metodo getTable
}
