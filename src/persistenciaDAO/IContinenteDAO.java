/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaDAO;

import modelo.Continente;

/**
 *
 * @author leonardodavod
 */
interface IContinenteDAO 
{
    public void agregarContinente(Continente c);
    
    public void eliminarContiente(int a);
    
    public Continente buscarContienente(int b);
    
    public void editarContinente(Continente c);
    
}
