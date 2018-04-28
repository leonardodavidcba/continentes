package util;
import java.sql.*;

public class ConexionBD
{

    Connection cn;
    private boolean flag = true;

    public Connection conexion()
    
    {
        try    
        {    // aca tienen que editar con las cosas de firebase
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAI21", "root", "root");
            flag = true;
        } catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
            flag = false;
        }
        return cn;
    }

    public boolean conection() 
    {
        Connection conexion = conexion();
        return flag;
    }

    Statement createStatement() 
    {
        throw new UnsupportedOperationException("Operacion No Soportada.");
    }
}
