/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat1u3;

import java.io.IOException;

/**
 *
 * @author Eric
 */
public class Activitat1u3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Caracters c = new Caracters();
        c.copiarFichero(c.file1, c.file2);
        c.copiarFicheroComprimit(c.file1, c.file2);
        c.cercarText("Hola Jorge", c.file1);
        c.descarregarUrl("http://www.google.es", c.file1);
    }

}
