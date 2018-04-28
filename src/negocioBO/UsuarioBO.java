/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioBO;

import java.util.ArrayList;
import modelo.Usuario;
import persistenciaDAO.UsuarioDAO;

/**
 *
 * @author leonardodavod
 */
public class UsuarioBO 
{
    
    private final UsuarioDAO daoUsuario = new UsuarioDAO();
    
    public ArrayList<Usuario> crearUsuarios(Integer idU,String usuarioo,String clave,String nombre, String apellido)
    {
           return daoUsuario.crearUsuarios(idU, usuarioo, clave, nombre, apellido);
    }

    public Usuario buscarUsuario(Usuario usuario) 
    {
        return daoUsuario.buscarUsuario(usuario);
    }

    public void guardar(Usuario usuario)
    {
        daoUsuario.guardar(usuario);
    }
    
    
    
    
}
