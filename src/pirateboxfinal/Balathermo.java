package pirateboxfinal;

/**
 * Clase Balathermo
 *
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

/**
 * @author Sheku1
 *@author thechosejuan
 * @author Santoscr92
 * @author ton-mm
 */
public class Balathermo extends Base {

	/**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 * @param posX es la <code>posiscion en x</code> del objeto balathermo.
	 * @param posY es el <code>posiscion en y</code> del objeto balathermo.
	 * @param image es la <code>imagen</code> del objeto balathermo.
         * @param flechitas es la <code>image</code> del objeto balathermo.
	 */
    
         private static int conteo = 0;
         private int direccion = 4;
         private int velocidad = 3;
         
    /**
     * Recibe como parametro la variable dir para asignarla a direccion
     * @param dir
     */
    public void setDireccion(int dir){
             direccion = dir;
         }
         
    /**
     * Metodo regresa el valor de la variable direccion
     * @return direccion
     */
    public int getDireccion(){
             return direccion;
         }
         
    /**
     *Metodo recibe como parametro vel para asignarlo a la variable velocidad
     * @param vel
     */
    public void setVelocidad(int vel){
             velocidad = vel;
         }
         
    /**
     * Metodo regresa el valor de la variable velocidad
     * @return velocidad
     */
    public int getVelocidad(){
             return velocidad;  
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
         
    /**
     * Clase BalaThermo asigna valores de flechitas, posX y PosY de los bosses 
     * del juego
     * @param posX
     * @param posY
     * @param flechitas
     */
    public Balathermo(int posX,int posY,int flechitas){
		
                super(posX,posY,flechitas);	
                
                //
                if(flechitas==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/thermoright.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balader.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balader.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 //anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                 
                }
                
                else if(flechitas==2){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/thermoup.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balaup.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balaup.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                // anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                }
                
                
                else if(flechitas==3){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/thermoleft.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balaizq.png"));
                 //bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/balaizq.png"));
                
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                // anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                
                }
                
                else if(flechitas==4){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/thermodown.png"));
                 //bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/baladown.png"));
                // bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/baladown.png")); 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                // anim.sumaCuadro(bomba2, 100);
                 //anim.sumaCuadro(bomba3, 100);
                }
                
	}
}