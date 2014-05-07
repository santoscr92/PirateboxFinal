package pirateboxfinal;

/**
 * Clase Malo
 *
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

         /**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 */
public class Malo extends Base {

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
         
         private boolean llego;
         
    /**
     * Metodo que recibe como parametro a que se le asigna a la variable llego
     * , el cual indica si un malo llego a tierra
     * @param a
     */
    public void setllego(boolean a){
             llego=a;
         }

    /**
     *Metodo regresa el valor de la variable llego
     * @return llego
     */
    public boolean getllego(){
             return llego;
         }
         
    /**
     * Metodo Malo donde se le asignan valores a los objetos de flechitas y posx y posy
     * @param posX
     * @param posY
     * @param flechitas
     */
    public Malo(int posX,int posY,int flechitas){
		
                super(posX,posY,flechitas);	
                
                //
                if(flechitas==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mfrente1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mfrente2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mfrente3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                 
                }
                
                else if(flechitas==2){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mespalda1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mespalda2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mespalda3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                }
                
                
                else if(flechitas==3){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mizquierda1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mizquierda2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mizquierda3.png"));
                
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                
                }
                
                else if(flechitas==4){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mderecha1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mderecha2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mderecha3.png")); 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                }
                
	}
}