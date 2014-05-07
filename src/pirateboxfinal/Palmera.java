package pirateboxfinal;

/**
 * Clase Palmera
 *
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Santoscr92
 */
public class Palmera extends Base {

	/**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 * @param posX es la <code>posiscion en x</code> del objeto palmera.
	 * @param posY es el <code>posiscion en y</code> del objeto palmera.
	 * @param image es la <code>imagen</code> del objeto palmera.
         * @param flechitas es la <code>image</code> del objeto palmera.
	 */
    
         private static int conteo = 0;
         
    /**
     *
     * @return
     */
    public static int getConteo()
         {
             return conteo;
         }
         
    /**
     *
     * @param a
     */
    public static void setConteo(int a)
         {
             conteo = a;
         }
         
         /**
     * Metodo Palmera donde se le asignan valores a los objetos de flechitas y posx y posy
     * @param posX
     * @param posY
     * @param flechitas
     */
	public Palmera(int posX,int posY,int flechitas){
		
                super(posX,posY,flechitas);	
                
                //
                //if(flechitas==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-0.gif"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-1.gif"));
                 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 2000);
                 anim.sumaCuadro(bomba2, 2000);
                 
                 
                //}
                /*
                else if(flechitas==2){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-0.gif"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-1.gif"));
                 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                }
                
                
                else if(flechitas==3){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-0.gif"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-1.gif"));
                 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                
                }
                
                else if(flechitas==4){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-0.gif"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tmp-1.gif"));
                 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                */
                
	}
}