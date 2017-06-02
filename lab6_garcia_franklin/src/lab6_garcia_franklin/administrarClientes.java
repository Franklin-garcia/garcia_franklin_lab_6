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
public class administrarClientes {
    private ArrayList<Clientes> listaClientes = new ArrayList();
    private File archivo = null;

    public administrarClientes(String Path) {
        archivo = new File(Path);
    }

    public ArrayList<Clientes> getListaPersonas() {
        return listaClientes;
    }

    public void setListaPersonas(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "listaPersonas" + listaClientes;
    }

    //mutador extra
    public void setCliente(Clientes p) {
        this.listaClientes.add(p);
    }

     public void escribirPersonas() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Clientes t : listaClientes) {
                bw.write(t.getNombre() + ";");
                bw.write(t.getEdad() + ";");
                for (Productos h : t.getListaProductos()) {
                    bw.write(h.getCategoria() + ",");
                    bw.write(h.getNombre() + ",");
                    bw.write(h.getPrecio()); 
                }
                bw.write(";");
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {

            }
        }

    } 
     
         public void cargarArchivo() {
        Scanner sc=null;
        listaClientes = new ArrayList();
        try {
            sc = new Scanner(archivo);
            sc.useDelimiter(";");
            while (sc.hasNext()) {
                int e;
                String n;
                ArrayList<Productos> temp = new ArrayList();
                n = sc.next();
                e =sc.nextInt();
                Scanner s2 = new Scanner(sc.next());
                s2.useDelimiter(",");
                listaClientes.add(new Clientes(e,n));
                while (s2.hasNext()) {
                    temp.add(new Productos(s2.next(),s2.next(),s2.nextInt(),s2.nextDouble()));  
                }
                listaClientes.get(listaClientes.size()-1).setListaProductos(temp); 

            }
        } catch (Exception ex) {
        } finally {
            sc.close();
        }
    }
}
