/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enclase.tareagui37danielnavarro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class MetodosFicheros {

    public static HashMap leerCsv() {
        String[] tokens = null;
        String linea = "";
        String ruta = "usuarios.csv";
        HashMap archivo = new HashMap();
        try (Scanner datosFichero = new Scanner(new File(ruta), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                //for (String string : tokens) {
                archivo.put(tokens[0], tokens[1]);
                //}
                //System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return archivo;
    }

    public static void addUsuario(String usuario, String pass) {
        String idFichero = "usuarios.csv";
//        String tmp;
//        
//        HashMap mapFichero =leerCsv();

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(idFichero, true);
            bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(usuario + ";" + pass);
            JOptionPane.showMessageDialog(null, "añadido");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void cambiarUsuario(String usuario, String pass) {
        HashMap mapFichero = leerCsv();
        String idFichero = "usuarios.csv";
        String tmp;

        File fichero = new File(idFichero);
        fichero.delete();
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            Iterator it1 = mapFichero.keySet().iterator();
            Iterator it2 = mapFichero.values().iterator();

            while (it1.hasNext()) {
                String it1Texto = it1.next().toString();
                String it2Texto= it2.next().toString();
                System.out.println("prueba it1: " + it1Texto);
                

                if (!it1Texto.equals(usuario)) {
                    tmp = it1Texto + ";" + it2Texto;
                    flujo.write(tmp);
                    if (it1.hasNext()) {
                        flujo.newLine();
                    }

                } else {
                    tmp = usuario + ";" + pass;
                    flujo.write(tmp);
                    if (it1.hasNext()) {
                        flujo.newLine();
                    }
                }

            }
//           
            flujo.flush();
            JOptionPane.showMessageDialog(null, "Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //addUsuario(usuario, pass);

    }

}
