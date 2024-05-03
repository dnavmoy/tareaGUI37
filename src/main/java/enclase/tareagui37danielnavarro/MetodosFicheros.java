/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enclase.tareagui37danielnavarro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class MetodosFicheros {

    public static HashMap leerCsv() {
        String[] tokens = null;
        String linea="";
        String ruta="usuarios.csv";
        HashMap archivo= new HashMap();
        try (Scanner datosFichero = new Scanner(new File(ruta), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                //for (String string : tokens) {
                    archivo.put(tokens[0],tokens[1]);
                //}
                //System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return archivo;
    }
}
