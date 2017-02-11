/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat1u3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Eric
 */
public class Caracters {
    
    File file1 = new File("C:\\Users\\Eric.DESKTOP-O4VLD9F\\Prueba3.txt");
    File file2 = new File("C:\\Users\\Eric.DESKTOP-O4VLD9F\\Prueba4.txt");
    
    BufferedReader read;
    BufferedWriter write;
    /**
     * Metode que li arriba 2 parametres tipus File.
     * utilitzem els metodes BufferReader i BufferWrite per llegir i escriure lo que te un fitxer a l'altre
     * @param file1
     * @param file2
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void copiarFichero(File file1, File file2) throws FileNotFoundException, IOException{
        read = new BufferedReader(new FileReader(file1));
        write = new BufferedWriter(new FileWriter(file2));
        String linea;
        
        while((linea = read.readLine()) != null){
            write.write(linea + "\n");
            System.out.println(linea);
        }
        read.close();
        write.close();
    }
    /**
     * Metode identic a l'anterior, traient que afegim l'objecte GZIPOutPutStream per podem comprimir lo que escribim
     * @param file1
     * @param file2
     * @throws IOException 
     */
    public void copiarFicheroComprimit(File file1, File file2) throws IOException{
        read = new BufferedReader(new FileReader(file1));
        
        GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream(file2));
        
        write = new BufferedWriter(new OutputStreamWriter(gzip));
        
        String linea;
        
        while((linea = read.readLine()) != null){
            write.write(linea + "\n");
        }
        read.close();
        write.close();
    }
    /**
     * Metode que li arriba per parametre una cadena de text i un tipus File.
     * Compara cada llinea buscant una llinea similar, si la troba la mostra, si no mostra que no la trobat
     * @param cadena
     * @param file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void cercarText(String cadena, File file) throws FileNotFoundException, IOException{
        read = new BufferedReader(new FileReader(file));
        String linea;
        boolean trobat = false;
        while((linea = read.readLine()) != null){
            if(linea.equals(cadena)){
                System.out.println(linea);
                trobat = true;
            } 
        }
        if(!trobat){
            System.out.println("No trobat");
        }
    }
    /**
     * Metode li arriba una url i un tipus file.
     * Cerca amb el bufferReader la url i la escriu al fitxer.
     * @param url
     * @param file
     * @throws MalformedURLException
     * @throws IOException 
     */
    public void descarregarUrl(String url, File file) throws MalformedURLException, IOException{
        URL web = new URL(url);
        read = new BufferedReader(new InputStreamReader(web.openStream()));
        write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        String linea;
        while((linea = read.readLine()) != null){
            write.write(linea + "\n");
        }        
        read.close();
        write.close();             
    }
}
