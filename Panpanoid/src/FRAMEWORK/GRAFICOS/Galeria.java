/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Galeria {
   //private final static String RUTA=System.getProperty("user.dir")+System.getProperty("file.separator")+"Assets"+System.getProperty("file.separator");
   //private final static String RUTA="../../Assets/";
   private final static String RUTA="";
   private HashMap<String,Image> hashMap;
   private static Galeria galeria;   
   private float escalaX, escalaY;
   
   private Galeria(float escalaX, float escalaY){
       System.out.println("RUTA ES :"+RUTA);
       this.escalaX=escalaX;
       this.escalaY=escalaY;
       hashMap=new HashMap<String,Image>();
   }
   public static Galeria crearGaleria(float escalaX, float escalaY){       
       if (galeria==null) galeria=new Galeria(escalaX, escalaY);
       return galeria;    
   }
   public static Galeria getGaleria(){       
       if (galeria==null) galeria=new Galeria(1,1);
       return galeria;    
   }

   private Image cargarFichero(String fichero) {      
        URL url;
        Image img=null;
        try {
            url=this.getClass().getResource(RUTA+fichero);
            img = ImageIO.read(url);
            img=redimensionarImg(img);
         } catch (Exception ex) {}
        return img;
    }
   private Image redimensionarImg(Image img){
       Image imagen;
       int width=(int)(img.getWidth(null)*escalaX);
       int height=(int)(img.getHeight(null)*escalaY);
       imagen=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       return imagen;
   }
    
   private void descargar(){           
   }
   public Image getImage(String nombre){
       Image img;
       if (hashMap.containsKey(nombre)){
           img=hashMap.get(nombre);
       }   
       else{ 
           img=cargarFichero(nombre);
           hashMap.put(nombre, img);  
       }
       return img;
   }
}
