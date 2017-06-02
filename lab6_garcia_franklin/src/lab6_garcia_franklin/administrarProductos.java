/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_garcia_franklin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Franklin Garcia
 */
public class administrarProductos {
    
    private ArrayList<Productos> listaProductos = new ArrayList();
    private File archivo = null;

    public administrarProductos(String Path) {
        archivo = new File(Path);
    }

    public ArrayList<Productos> getListaPersonas() {
        return listaProductos;
    }

    public void setListaPersonas(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "listaProductos" + listaProductos;
    }

    //mutador extra
    public void setProductos(Productos p) {
        this.listaProductos.add(p);
    }

    //metodos de adiminstracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Productos t : listaProductos) {
                bw.write(t.getNombre() + ";");
                bw.write(t.getCategoria() + ";");
                bw.write(t.getPrecio() + ";"); 
                bw.write(t.getDescuento() +";");
             }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaProductos = new ArrayList();
        try {
            sc = new Scanner(archivo);
            sc.useDelimiter(";");
       
            while (sc.hasNext()) {
                listaProductos.add(new Productos(sc.next(),sc.next(),sc.nextInt(),sc.nextDouble()));
            } 
        } catch (Exception ex) {
        } finally {
            sc.close();
        }
    }
}
