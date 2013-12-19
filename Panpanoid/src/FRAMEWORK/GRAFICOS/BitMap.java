/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Image;

public class BitMap {
    private Image img;
    private int width,height;
    private static Galeria galeria=Galeria.getGaleria();
    public BitMap(String fichero){
         img=galeria.getImage(fichero);  
         width = img.getWidth(null);
         height = img.getHeight(null);
    }
    public int getWidth() { return width;}
    public int getHeight() { return height;}
    public Image getImage() { return img;}
}
