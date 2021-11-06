
package componentes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * @author Diego Alexander Gaviria Jimenez
 * permite visualizar datos en un jtable
 * Advertencian relizar la coexion con conectar() de la clase connection_mysql
 */
public class VerTabla {
    
    //muestra los datos de la tabla localidades     
    public void visualizar_tabla(JTable tabla){
        connection_mysql conn = new connection_mysql();
        Connection con = conn.conectar(); //se conecta a la base de datos
        ResultSet rs = conn.visualizar("localidades"); //muestra los datos 
     
        DefaultTableModel dt = new DefaultTableModel();//
        //nombre de la columna
        dt.addColumn("Numero Localidad");
        dt.addColumn("Nombre Localidad");
        dt.addColumn("Dificultad Localidad");
        dt.addColumn("porcentaje");
        dt.addColumn("Fecha");
    
        try{
        
            while(rs.next()){ //itera los datos asta que no hallan datos que mostrar
               /* Object[] fila = new Object[3]; //cantida de datos a mostrar en el jtablet 
               //posicion en la tabla fila[0] // ubicacion en la base de datos rs.getObject(2)
               
                fila[0] = rs.getInt(1);
                fila[1] = rs.getObject(2);
                fila[2] = rs.getObject(3); 
                fila[3] = rs.getDouble(4);
                fila[4] = rs.getObject(5); */
               
                
                Vector vt = new Vector();
                //agrega los datos en la columna
                vt.add(rs.getInt(1));  //-> pocisiones en la base de datos
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getDouble(4));
                vt.add(rs.getString(5));

             
                
                dt.addRow(vt);  //agrega los datos en la tabla
            }
        
        tabla.setModel(dt);
        tabla.setRowHeight(64);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();   //envia los datos a la tabla
    }  
}
    
    //muestra los datos de la tabla usuario login
    public void tabla_usuario(JTable tabla){
        connection_mysql conn = new connection_mysql();
        Connection con = conn.conectar(); //se conecta a la base de datos
        ResultSet rs = conn.visualizar("usuarios"); //muestra los datos 
     
        DefaultTableModel dt = new DefaultTableModel();//
        //nombre de la columna
        dt.addColumn("Correo electronico");
        dt.addColumn("Password");
        dt.addColumn("Nombre usuario");
        dt.addColumn("Nombre apellido");
        dt.addColumn("Edad usuario");
        dt.addColumn("Genero usuario");
       dt.addColumn("fecha de nacimoento");
    
        try{
        
            while(rs.next()){ //itera los datos asta que no hallan datos que mostrar
               /* Object[] fila = new Object[3]; //cantida de datos a mostrar en el jtablet 
               //posicion en la tabla fila[0] // ubicacion en la base de datos rs.getObject(2)
               
                fila[0] = rs.getInt(1);
                fila[1] = rs.getObject(2);
                fila[2] = rs.getObject(3); 
                fila[3] = rs.getDouble(4);
                fila[4] = rs.getObject(5); */
               
                
                Vector vt = new Vector();
                
                vt.add(rs.getString(1)); //-> pocisiones en la base de datos
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getInt(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                

             
                
                dt.addRow(vt);  
            }
        
            tabla.setModel(dt);
            tabla.setRowHeight(64);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();   //envia los datos a la tabla
        }  
    }

    public void tabla_use(JTable tabla){
        connection_mysql conn = new connection_mysql();
        Connection con = conn.conectar(); //se conecta a la base de datos
        ResultSet rs = conn.visualizar("usuarios"); //muestra los datos 
     
        DefaultTableModel dt = new DefaultTableModel();//
        //nombre de la columna
        dt.addColumn("C.C");
        dt.addColumn("Nombre");
        dt.addColumn("apellido");
        dt.addColumn("Telefono");
        dt.addColumn("Correo");
        dt.addColumn("Direccion");
        dt.addColumn("Genero");
    
    try{
        
        while(rs.next()){ //itera los datos asta que no hallan datos que mostrar
               /* Object[] fila = new Object[3]; //cantida de datos a mostrar en el jtablet 
               //posicion en la tabla fila[0] // ubicacion en la base de datos rs.getObject(2)
               
                fila[0] = rs.getInt(1);
                fila[1] = rs.getObject(2);
                fila[2] = rs.getObject(3); 
                fila[3] = rs.getDouble(4);
                fila[4] = rs.getObject(5); */
               
                
                Vector vt = new Vector();
                
               vt.add(rs.getInt(1)); //-> pocisiones en la base de datos
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
               vt.add(rs.getInt(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                
                dt.addRow(vt);  
            }
        
        tabla.setModel(dt);
        tabla.setRowHeight(64);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();   //envia los datos a la tabla
    }  
}
    
    
    public void tabla_encuesta(JTable tabla){
        connection_mysql conn = new connection_mysql();
        Connection con = conn.conectar(); //se conecta a la base de datos
        ResultSet rs = conn.visualizar("encuestas"); //muestra los datos 
     
        DefaultTableModel dt = new DefaultTableModel();//
        //nombre de la columna
        dt.addColumn("Cedula");
        dt.addColumn("Nombre");
        dt.addColumn("Correo");
        dt.addColumn("Telefono");
        dt.addColumn("Localidad");
        dt.addColumn("problema");
    
        try{
        
            while(rs.next()){ //itera los datos asta que no hallan datos que mostrar
            /*    Object[] fila = new Object[3]; //cantida de datos a mostrar en el jtablet 
               //posicion en la tabla fila[0] // ubicacion en la base de datos rs.getObject(2)
               
   
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getObject(3); 
                fila[3] = rs.getDouble(4);
                fila[4] = rs.getObject(5); */
               
                
                Vector vt = new Vector();
                //agrega los datos en la columna
               
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getInt(4));
                vt.add(rs.getInt(5));
                vt.add(rs.getInt(6));
               

             
                
                dt.addRow(vt);  //agrega los datos en la tabla
            }
        
        tabla.setModel(dt);
        tabla.setRowHeight(64);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();   //envia los datos a la tabla
    }  
}
}
