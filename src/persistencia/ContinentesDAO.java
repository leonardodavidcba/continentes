/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import modelo.Continente;

/**
 *
 * @author leonardodavod
 */
public class ContinentesDAO extends AbstractListModel implements IContinenteDAO
{

    private ArrayList<Continente> lista = new ArrayList<>();
    
    
    @Override
    public int getSize()
    {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        Continente c = lista.get(index);
        return c.getNombre();
    }

    // aca agrego continentes a una lista echa con ArrayList que es un poco mas intuitiva de usar
    @Override
    public void agregarContinente(Continente c) 
    {
         lista.add(c);
         this.fireIntervalAdded(this, getSize(), getSize()+1);
    }

    @Override
    public void eliminarContiente(int index) 
    {
        lista.remove(index);
        this.fireIntervalRemoved(index, getSize(), getSize()+1);
    }

    @Override
    public Continente mostrarContienente(int index) 
    {
        return lista.get(index);
    }

    @Override
    public void editarContinente(Continente c) 
    {
        
        
        
    }
    
    
    
    
    
}
