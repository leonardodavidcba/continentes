/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.Continente;

/**
 *
 * @author leonardodavod
 */
interface IContinenteDAO 
{
    public void agregarContinente(Continente c);
    
    public void eliminarContiente(int a);
    
    public Continente mostrarContienente(int b);
    
    public void editarContinente(Continente c);
    
}
