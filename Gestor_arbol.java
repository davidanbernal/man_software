/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestor_arbol;
import java.util.Scanner;
//import gestor_arbol.Arbol;
//import gestor_arbol.Nodos;


/**
 *
 * @author david
 */
public class Gestor_arbol {

    /**
     * @param args the command line arguments
     */
     static int numUsers=0,numPres=0,numBooks=0;
    static String[][] usuarios= new String[10][3];
     
     static String[][] libros=new String[10][3];
    static String[][] prestamos=new String[10][3];       

    
  public static void main(String[] args) {
        // TODO code application logic here
         int opcion,m1,m2,m3,s2;
         String     s1,s3;
         Scanner opciones=new Scanner(System.in); 
         Arbol Arbol= new Arbol();
         Arbol Libro= new Arbol();
         Arbol Prestamo= new Arbol();
         Nodos Sal, Lib,Pres;
         
   
     
 do{
     //MENU PRINCIPAL 
      System.out.println("  ");
      System.out.println("Digite una de las siguientes opciones: ");
      System.out.println("1 - Menu Usuarios ");
      System.out.println("2 - Menu Libros ");
      System.out.println("3 - Menu Prestamos ");
      System.out.println("5 - Salir ");
      opcion=opciones.nextInt();
           
      
if(opcion==1){//MENU USUARIOS
          
     
      System.out.println("----Menu Usuarios---- ");
      System.out.println("1 - Agregar usuario ");
      System.out.println("2 - Listar usuarios ");
      System.out.println("3 - Borrar usuario ");
      System.out.println("4 - Buscar usuario ");    
      System.out.println("5 - Salir del programa ");
      m1=opciones.nextInt();
      
            
            if(m1==1){//Agregar usuario
             System.out.println("Digite Nombres y Apellidos: ");
            opciones.nextLine();
            s1=opciones.nextLine();
            System.out.println("Escriba tipo de usuario, (Alumno, Docente): ");
            s3=opciones.nextLine();
            System.out.println("Digite Identificacion: ");
            s2=opciones.nextInt();
            Arbol.InsertarDatos(s2,s1,s3);
            
            }
            else if(m1==2){
               
                if (!Arbol.estaVacio()){

                   System.out.println("Identificacion | Nombre y Apellido | Tipo de Usuario");
                   Arbol.inOrder(Arbol.Raiz);
                }
                else {
                 System.out.println("No hay elementos almacenados...  ");
                }
          
            }//listar usuario
           
            else if(m1==3){//borrar usuario
                System.out.println("Digite Identificacion para borrar: ");
               
                s2=opciones.nextInt();
                 if (!Arbol.estaVacio()){
                   
                    if(Arbol.eliminar(s2)==false){
                      System.out.println("!Usuario no existe! ");
                      }
                      else{
                        System.out.println("!Usuario ha sido eliminado...! "); 
                            } 

                      } else {
                     System.out.println("!No hay Usuarios...! ");
                      }
                 }
            
             else if(m1==4){//buscar usuario
                System.out.println("Digite Identificacion para borrar: ");
                s2=opciones.nextInt();
                if (!Arbol.estaVacio()){
                    if (Arbol.buscarNodo(s2)==null){
                     System.out.println("!Usuario no existe! ");
                    }
                    else{
                    Sal=Arbol.buscarNodo(s2);
                     System.out.println("Usuario encontrado: Identificacion: "+Sal.Dato +" | Nombres y apellidos: "+Sal.Nombre+" | Tipo: "+Sal.Type);
                    
                    }    
                
                }
             }
            else if(m1==5){opcion=5;}//SALIR DEL PROGRAMA 
            }
      
      else if(opcion==2){//MENU LIBROS
   
      System.out.println("----Menu Libros---- ");
      System.out.println("1 - Agregar Libro ");
      System.out.println("2 - Listar Libros ");
      System.out.println("3 - Borrar Libro ");
      System.out.println("4 - Buscar Libro ");
      System.out.println("5 - Salir del programa ");
      m2=opciones.nextInt();
      System.out.println("La opcion escogida es: "+ m2);
      
            if(m2==1){//Agregar libro
            System.out.println("Digite titulo del libro: ");
            opciones.nextLine();
            s1=opciones.nextLine();
            System.out.println("Digite Autor del libro: ");
            s3=opciones.nextLine();
            System.out.println("Digite Codigo del libro: ");
            s2=opciones.nextInt();
             
            Libro.InsertarDatos(s2,s1,s3);
            }
            
            else if(m2==2){//Listar libros
                if (!Libro.estaVacio()){

                   System.out.println("Codigo | Titulo | Autor");
                   Libro.inOrder(Libro.Raiz);
                }
                else {
                 System.out.println("No hay elementos almacenados...  ");
                }
            }
            
            else if(m2==3){//Borrar libro
            System.out.println("Digite Codigo del libro: ");
            s2=opciones.nextInt();
          if (!Libro.estaVacio()){
                   
                    if(Libro.eliminar(s2)==false){
                      System.out.println("!Libro no existe! ");
                      }
                      else{
                        System.out.println("!Libro ha sido eliminado...! "); 
                            } 

                      } else {
                     System.out.println("!No hay Libros...! ");
                      }
            }
            
            else if(m2==4){//buscar libro
                System.out.println("Digite codigo para buscar: ");
                s2=opciones.nextInt();
                if (!Libro.estaVacio()){
                    if (Libro.buscarNodo(s2)==null){
                     System.out.println("!Libro no existe! ");
                    }
                    else{
                    Lib=Libro.buscarNodo(s2);
                     System.out.println("Libro encontrado: Codigo: "+Lib.Dato +" | Titulo: "+Lib.Nombre+" | Autor: "+Lib.Type);
                    
                    }    
                
                }
             }
            else if(m2==5){opcion=5;}//SALIR DEL PROGRAMA 
      }
      else if(opcion==3){//MENU PRESTAMOS
    
      System.out.println("----Menu Prestamos---- ");
      System.out.println("1 - Prestar Libro ");
      System.out.println("2 - Listar Prestamos ");
      System.out.println("3 - Devolver prestamo ");
      System.out.println("4 - Buscar Prestamo por usuario");
      System.out.println("5 - Salir del programa ");
      m3=opciones.nextInt();
      System.out.println("La opcion escogida es: "+ m3);
      
      if(m3==1){//Prestar libro
            System.out.println("Digite Codigo del libro: ");
            opciones.nextLine();
            s1=opciones.nextLine();
            System.out.println("Digite Fecha de prestamo: ");
            s3=opciones.nextLine();
            System.out.println("Digite Identificacion de usuario: ");
            s2=opciones.nextInt();
            Prestamo.InsertarDatos(s2,s1,s3);
            
             }
      else if(m3==2){//listar prestamos
       if (!Prestamo.estaVacio()){
                  
                   System.out.println("Usuario | Codigo libro | Fecha de prestamo");
                   Prestamo.inOrder(Prestamo.Raiz);
                }
                else {
                 System.out.println("No hay elementos almacenados...  ");
                }
      }
      else if(m3==3){//Devolver libro
           System.out.println("Digite Codigo de usuario: ");
            
            s2=opciones.nextInt();
            if (!Prestamo.estaVacio()){
                   
                    if(Prestamo.eliminar(s2)==false){
                      System.out.println("!Prestamo no existe! ");
                      }
                      else{
                        System.out.println("!Libro ha sido regresado...! "); 
                            } 

                      } else {
                     System.out.println("!No hay prestamos...! ");
                      }
            }
       else if(m3==4){//buscar libro
                System.out.println("Digite codigo de usuario para buscar: ");
                s2=opciones.nextInt();
                if (!Prestamo.estaVacio()){
                    if (Prestamo.buscarNodo(s2)==null){
                     System.out.println("!Prestamos no asociados con usuario! ");
                    }
                    else{
                    Pres=Prestamo.buscarNodo(s2);
                     System.out.println("Prestamo encontrado: Usuario: "+Pres.Dato +" | Codigo libro: "+Pres.Nombre+" | Fecha de prestamo   : "+Pres.Type);
                    
                    }    
                
                }
             }
      else if(m3==5){opcion=5;}//SALIR DEL PROGRAMA 
      }
 }while(opcion != 5);    
      
    }//main

    
  
}//gestor

