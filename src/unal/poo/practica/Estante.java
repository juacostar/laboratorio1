package unal.poo.practica;




import becker.robots.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Estante {
    private Thing estante;
    private Producto[] productos;

    public Estante(Producto[] productos) {
        this.productos = new Producto[21];
       
    }
    
    public boolean ingresarProducto(Producto producto){
        for(int i=0;i<this.productos.length;i++){
            if(this.productos[i]==null){
                this.productos[i]=producto;
                return true;
            }
        }
        return false;
    }
    
    public boolean sacarProductoPorNombre(String nombreProducto){
        for(int i=0;i<this.productos.length;i++){
            if(this.productos[i].getNombre()==nombreProducto){
                this.productos[i]=null;
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
}
