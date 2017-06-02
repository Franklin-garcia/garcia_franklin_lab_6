/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_garcia_franklin;

import java.util.ArrayList;

/**
 *
 * @author Franklin Garcia
 */
public class Clientes {
    private int edad;
    private String nombre;
    private ArrayList<Productos>listaProductos=new ArrayList();

    public Clientes() {
    }

    public Clientes(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
