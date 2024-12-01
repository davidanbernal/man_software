/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor_arbol;

/**
 *
 * @author david
 */
public class Nodos {
   int Dato;
    String Nombre, Type;
    Nodos HijoIzq, HijoDer;
    
    public Nodos (int Dato,String nom,String type) {
        this.Dato = Dato;//id
        this.Nombre=nom;//nombre
        this.Type=type;
        this.HijoDer = null;
        this.HijoIzq = null;
    }
    
    public String tostring()
    {
      return Nombre +"Su datos es "+ Dato;
    } 
}
