/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioBO;

import modelo.Continente;
import persistenciaDAO.ContinentesDAO;

/**
 *
 * @author leonardodavod
 */
public class ContinenteBO
{
    
    private final ContinentesDAO continentesDao = new ContinentesDAO();
    
    
     public int getSize()
     {
         return continentesDao.getSize();
     }
     
     public Object getElementAt(int index)
     {
         return continentesDao.getElementAt(index);
     }
    
     public void agregarContinente(Continente c)
     {
         continentesDao.agregarContinente(c);
     }
     
     public void eliminarContiente(int index)
     {
         continentesDao.eliminarContiente(index);
     }
     
     public Continente buscarContienente(int index)
     {
         return continentesDao.buscarContienente(index);
     }
     
     public void editarContinente(Continente c)
     {
         continentesDao.editarContinente(c);
     }
     
    
    
}
