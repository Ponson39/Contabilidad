//@author Diego Alexander Gaviria Jimenez
package componentes;
//librerias
//------Conexion a la base de datos------\\
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


//------ingrseando datos  a la base de datos------\\
import java.util.ArrayList;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;

      
/**
 * 
 * @author Diego Alexander Gaviria Jimenez
 * En esta Clase permite la conección con la base de datos
 * se encontrara con metodos para insert delete select y conectar desconectar
 */
public class connection_mysql {
    
private static Connection conexion;
     
      
    private  String usuario_mysql;
    private  String password_mysql;
    private  String nombre_baseD;
    private  String tabla;
      
    //costructores 2
    public  connection_mysql(){}
       
    /**
     * @param usuario_mysql usuario de la base de datos -> ejemplo root
     * @param password_mysql contraseña de la base de daros -> ejemplo 1234  
     * @param nombre_baseD  nombre de la base de datos -> escuela
    */  
    public  connection_mysql(String usuario_mysql,String password_mysql, String nombre_baseD){
         
        this.usuario_mysql = usuario_mysql;
        this.password_mysql = password_mysql;
        this.nombre_baseD = nombre_baseD;
      
    }
    public  connection_mysql(String tabla){
    this.tabla = tabla;
    }
    public  connection_mysql(String usuario_mysql,String password_mysql, String nombre_baseD,String tabla){
    
        this.usuario_mysql = usuario_mysql;
        this.password_mysql = password_mysql;
        this.nombre_baseD = nombre_baseD;
        this.tabla = tabla;
    } 
    
    //metodos conexion a la base de datos 3
    /**
     * se conecta a la base de datos
     * @param usuario_mysql
     * @param nombre_baseD
     * @param password_mysql 
     * 
     */
    public void MySQL_connection(String usuario_mysql, String nombre_baseD, String password_mysql){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + nombre_baseD,usuario_mysql,password_mysql);
            System.out.println("Se ha iniciado la conexión de forma exitosa");
        }catch(ClassNotFoundException | SQLException ex ){
            Logger.getLogger(connection_mysql.class.getName()).log(Level.SEVERE, null, ex );   
        }      
    }
    
    /** 
    se conecta a la base de datos con ayuda del contructor 
    */
    public void MySQL_connection(){
        
        
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + nombre_baseD,usuario_mysql,password_mysql);
            System.out.println("Se ha iniciado la conexión de forma exitosa");
        }catch(ClassNotFoundException | SQLException ex ){
            Logger.getLogger(connection_mysql.class.getName()).log(Level.SEVERE, null, ex );   
        }      
    }
    
    /**
     * @return Connetion
    */
    public Connection conectar(){
        Connection con = null;
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + nombre_baseD,usuario_mysql,password_mysql);
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return conexion;
    }
    
    //metodos cerrar conexion 1
    /**
    * cierra la conección
    */
    public void cerrar_connection(){
        try{
            conexion.close();
        }catch(SQLException ex){
            Logger.getLogger(connection_mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //9 metodos trae los datos usand select * from datos 
   
    /**
     * trae los datos de la base de datos -> localidades
     * @param nombreTabla
     * @return 
    */
    public datosp getUser(String nombreTabla) {
        datosp loc = null; // El usuario no existe en esta base de datos
        try {
            String Query = "SELECT * FROM " + nombreTabla;
            Statement st = conexion.createStatement();
            ResultSet resultSet;
            resultSet = st.executeQuery(Query);
             while (resultSet.next()) {
                    loc = new datosp();
                    int ID=0;
                    loc.setCodigo(resultSet.getInt("ID"));
                    loc.setNombre(resultSet.getString("Nombre"));
                    loc.setValor(resultSet.getDouble("Valor"));
                    loc.setFecha(resultSet.getString("fecha"));
                    loc.setCuenta(resultSet.getString("Cuenta"));
            }       
               
        } catch (SQLException ex) {
            loc = null; // Error al intentar adquirir los datos
        }
        return loc;
    }
   
   /**
     * inserta datos -> tabla localidades
     * @param Nom_tabla
     * @param ID
     * @param Localidad
     * @param dificultad_loc
     * @param porcentaje
     * @param fech
     * @return int
    */
   public int insertdato(String Nom_tabla, int ID, String Localidad,String dificultad_loc, double porcentaje,String fech){
  
        int estatus = 0;
   
        try{
            String Query = "INSERT INTO " + Nom_tabla + " VALUES("
                + "\"" + ID + "\", "
                + "\"" + Localidad + "\", "
                + "\"" + dificultad_loc + "\", "
                + "\"" + porcentaje + "\", "
                + "\"" + fech + "\")";
                Statement st = conexion.createStatement();
                st.executeUpdate(Query);
                estatus=1; //el dato se agrego exitosamente
        }catch(SQLException ex){
            estatus=0; //error al agredar el dato
            System.out.print(estatus);
        }   
        return estatus;
    }
     
    //metos mostrar datos 1 
    /**
     * Metodo utilizado para visualizar los datos 
     * ADVERTENCIA debe realizar la conexion a la base de datos con el metodo MySQL_connection
     * @param tabla nombre de la tabla
     * @return si retorna null no se puedo visualizar los datos
    */
    public ResultSet visualizar(String tabla){
        
        ResultSet rs = null;
        try{
          //  PreparedStatement ps = conexion.prepareStatement("select * from localidades");
          PreparedStatement ps = conexion.prepareStatement("select * from " + tabla);
            rs = ps.executeQuery();
        }catch(Exception ex){
            System.out.println("Error de consulta");
            System.err.println("error");
        }
        return rs;
    }
    //metodos eliminar datos 1
    
    /** 
    * Metodo utilizado para eliminar datos 
    * @param name nombre de la llave primaria
    * @param tabla nombre de la tabla que perenece la llave primaria
    */
    public void Delete(String name,String tabla){
   
    try {  
       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + nombre_baseD,usuario_mysql,password_mysql);
        PreparedStatement st = connection.prepareStatement("DELETE FROM " + tabla + " WHERE ID = ?");
       
        st.setString(1,name);
        st.executeUpdate(); 
        System.out.println("se eliminno el dato "+name);
        JOptionPane.showMessageDialog(null,"se eliminno el dato "+name);
    } catch(ClassNotFoundException | SQLException e) {
        System.out.println(e);
        System.out.println("no se pudo eliminar el dato "+name);
        JOptionPane.showMessageDialog(null,"no se pudo eliminar el dato "+name);
    }
    
    
}
 
  
}
