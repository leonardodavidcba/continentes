/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import util.ConexionBD;

/**
 *
 * @author leonardodavod
 */
public class UsuarioDAO 
{
    
    ConexionBD con = new ConexionBD();
    Connection cn  = con.conexion();
    

    public ArrayList<Usuario>crearUsuarios(Integer idU,String usuarioo,String clave,String nombre, String apellido) 
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(idU);
                    usuario.setUsuario(usuarioo);
                    usuario.setApellido(apellido);
                    usuario.setNombre(nombre);
                    usuario.setClave(clave);
                    usuario.setEstadoAdmin(true);
                   
                    usuarios.add(usuario);
                
        return usuarios;
    }

    // aca tengo q lograr q busque los usuarios cargados para poder validar el logeo
    public Usuario buscarUsuario(Usuario usuario) 
    {
        
        Usuario user = new Usuario();
       
                    user.getApellido();
                    user.getNombre();
                    user.getClave();
                    user.getEstadoAdmin();
                    
                   
            
        return user;
    }

    public void guardar(Usuario usuario) 
    {
        PreparedStatement pps;
        try 
        {
            pps = cn.prepareStatement("INSERT INTO usuario (idUsuario, usuario, clave, estadoAdmin) VALUES (?,?,?,?)");
    //        pps.setString(1, usuario.getIdUsuario());
            pps.setString(2, usuario.getUsuario());
            pps.setString(3, usuario.getClave());
            if (usuario.getEstadoAdmin())
            {
                pps.setString(4, "Verdadero");
            } else 
            {
                pps.setString(4, "Falso");
            }

            pps.executeUpdate();
            pps.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
