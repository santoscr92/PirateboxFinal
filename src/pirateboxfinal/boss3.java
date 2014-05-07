package pirateboxfinal;

/**
 * Clase BOSS3
 *
 * @author Codet
 * @version 1.00 2014/5/7
 */
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Santoscr92
 */
public class boss3 extends Base {

	/**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 * @param posX es la <code>posiscion en x</code> del objeto boss3.
	 * @param posY es el <code>posiscion en y</code> del objeto boss3.
	 * @param image es la <code>imagen</code> del objeto boss3.
         * @param flechitas es la <code>image</code> del objeto boss3.
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
     *
     * @param posX
     * @param posY
     * @param flechitas
     */
    public boss3(int posX,int posY,int flechitas){
		
                super(posX,posY,flechitas);	
                
                //
                if(flechitas==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b1d1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b1d2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b1d3.png"));
                 
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