/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor_arbol;

/**
 *
 * @author david
 */
public class Arbol {
Nodos Raiz;
    
    public Arbol () { 
        Raiz = null;
    }
    
    public boolean estaVacio(){
        return Raiz == null;
    }
 
    
    public void InsertarDatos(int dato,String nom,String type){
        Nodos nuevo = new Nodos(dato,nom,type);
        if (estaVacio())
            Raiz = nuevo;
        else {
            Nodos aux = Raiz, Padre;
            while (true) {
                Padre = aux;
                if (dato < aux.Dato){
                    aux = aux.HijoIzq;
                    if (aux == null){
                        Padre.HijoIzq = nuevo;
                        return;
                    }
                } else {
                    aux = aux.HijoDer;
                    if (aux == null){
                        Padre.HijoDer = nuevo;
                        return;
                    }
                }
            }
        }
    }
 
    public void inOrder (Nodos Nodo) {
        if (Nodo != null){
            inOrder(Nodo.HijoIzq);
            /*System.out.println(Nodo.Dato);*/
            
            System.out.println(Nodo.Dato +" | "+Nodo.Nombre+" | "+Nodo.Type);
            
            /*System.out.println(Nodo.Dato +" "+Nodo.Nombre );*/
            inOrder(Nodo.HijoDer);
        }
    }
 
    public void preOrder (Nodos Nodo) {
        if (Nodo != null){
            //System.out.println(Nodo.Dato);
            
            System.out.print(Nodo.Dato + ", ");
            
            /*System.out.println(Nodo.Dato +" "+Nodo.Nombre );*/
            preOrder(Nodo.HijoIzq);
            preOrder(Nodo.HijoDer);
        }
    }
 
    public void postOrder (Nodos Nodo) {
        if (Nodo != null){
            postOrder(Nodo.HijoIzq);
            postOrder(Nodo.HijoDer);
           
           System.out.print(Nodo.Dato + ", ");
           
        }
    }
    
    public Nodos buscarNodo(int d){
        Nodos aux=Raiz;
        while(aux.Dato!=d)
        {
         if(d<aux.Dato){
            aux=aux.HijoIzq;
            }
          else{
            aux=aux.HijoDer;
            }
           if(aux==null){
               return null;
            }
        }
        return aux;
        }    
    
    //BUsqueda por codigo de libro
     public Nodos buscarLibro(int d){
        Nodos aux=Raiz;
        while(aux.Dato!=d)
        {
         if(d<aux.Dato){
            aux=aux.HijoIzq;
            }
          else{
            aux=aux.HijoDer;
            }
           if(aux==null){
               return null;
            }
        }
        return aux;
        }  
        //Metodo para eliminar un nodo del arbol
        
       public boolean eliminar(int d){
           Nodos auxiliar=Raiz;
           Nodos padre=Raiz;
           boolean esHijoIzq=true;
           
           while(auxiliar.Dato!=d){
             padre=auxiliar;
             if(d<auxiliar.Dato){
                 esHijoIzq=true;
                 auxiliar=auxiliar.HijoIzq;
               }else{
                 esHijoIzq=false;
                 auxiliar=auxiliar.HijoDer;     
                }
               if(auxiliar==null){
                   return false;
                }
            }//Fin del while
            
           if(auxiliar.HijoIzq==null && auxiliar.HijoDer==null){
               if(auxiliar==Raiz){
                   Raiz=null;   
                }else if(esHijoIzq){
                    padre.HijoIzq=null;
                }else{
                    padre.HijoDer=null;                
                }   
               }else if(auxiliar.HijoDer==null){
                
                if(auxiliar==Raiz){
                   Raiz=auxiliar.HijoIzq;   
                }else if(esHijoIzq){
                    padre.HijoIzq=auxiliar.HijoIzq;
                }else{
                    padre.HijoDer=auxiliar.HijoIzq;                
                }   
            
            }else if(auxiliar.HijoIzq==null){
               
                if(auxiliar==Raiz){
                   Raiz=auxiliar.HijoDer;   
                }else if(esHijoIzq){
                    padre.HijoIzq=auxiliar.HijoDer;
                }else{
                    padre.HijoDer=auxiliar.HijoIzq;                
                }    
            
            }else{
                Nodos reemplazo=obtenerNodoReemplazo(auxiliar);
                
                if(auxiliar==Raiz){
                  Raiz=reemplazo;
                } else if(esHijoIzq){
                    padre.HijoIzq=reemplazo;
                }else{
                   padre.HijoDer=reemplazo;
                }
               reemplazo.HijoIzq=auxiliar.HijoIzq; 
            }
           return true;
        }
      
        
        //Metodo encargado de volvernos el nodo reemplazo
        
        public Nodos obtenerNodoReemplazo(Nodos nodoReemp){
         Nodos reemplazarPadre=nodoReemp;
         Nodos reemplazo=nodoReemp;
         Nodos auxiliar=nodoReemp.HijoDer;
         
         while(auxiliar!=null){
              reemplazarPadre=reemplazo;
              reemplazo=auxiliar;
              auxiliar=auxiliar.HijoIzq;
            }
            
            if(reemplazo!=nodoReemp.HijoDer){
               reemplazarPadre.HijoIzq=reemplazo.HijoDer;
               reemplazo.HijoDer=nodoReemp.HijoDer;
            }
            
            System.out.println("El nodo de reemplazo es:  "+ reemplazo);
            
            return reemplazo;
        }
         
}
