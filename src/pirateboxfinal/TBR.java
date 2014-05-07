package pirateboxfinal;

/**
 * Clase TBR
 *
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Santoscr92
 */
public class TBR extends Base {

	/**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 * @param posX es la <code>posiscion en x</code> del objeto TBR.
	 * @param posY es el <code>posiscion en y</code> del objeto TBR.
	 * @param image es la <code>imagen</code> del objeto TBR.
         * @param flechitas es la <code>image</code> del objeto TBR.
	 */
    
         private static int conteo = 0;
         private int vida = 50,velocidad = 5;
         
    /**
     *
     * @param vel
     */
    public void setVelocidad(int vel){
             velocidad = vel;
         }
         
    /**
     *
     * @return
     */
    public int getVelocidad(){
             return velocidad;  
         }
         
    /**
     *
     * @param v
     */
    public void setVida(int v){
             vida = v;
         }
         
    /**
     *
     * @return
     */
    public int getVida(){
             return vida;
         }
         
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
    public TBR(int posX,int posY,int flechitas){
		
                super(posX,posY,flechitas);	
                
                //
                if(flechitas==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b2d1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b2d2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/b2d3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                 
                }
                
                else if(flechitas==2){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tbrup.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mespalda2.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mespalda3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 //anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                }
                
                
                else if(flechitas==3){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tbrleft.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mizquierda2.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mizquierda3.png"));
                
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 //anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                
                }
                
                else if(flechitas==4){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/tbrright.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mderecha2.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/mderecha3.png")); 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 //anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                }
                
	}
}