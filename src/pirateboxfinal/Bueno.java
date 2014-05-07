package pirateboxfinal;

/**
 * Clase Bueno
 *

 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

         /**
	 * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
	 * @param posY es el <code>posiscion en y</code> del objeto bueno.
	 */
public class Bueno extends Base{

	
         
        private static final String desaparece = "DESAPARECE";
        private static final String pausado = "PAUSADO";  
        
    /**
     * Metodo que crea a Bueno donde indica que variables se le asignaran 
     * @param posX
     * @param posY
     * @param caso
     */
    public Bueno(int posX,int posY,int caso){
		super(posX,posY,caso);	
                //
                
                
                if(caso==1 ){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/espalda1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/espalda2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/espalda3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                 
                }
                
                else if(caso==2){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/frente1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/frente2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/frente3.png"));
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                }
                
                
                else if(caso==3){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/izquierda1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/izquierda2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/izquierda3.png"));
                
                anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                
                }
                
                else if(caso==4){
                 Image bomba1,bomba2,bomba3;
                 bomba1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/derecha1.png"));
                 bomba2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/derecha2.png"));
                 bomba3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/derecha3.png")); 
                 
                 anim = new Animacion();
                 anim.sumaCuadro(bomba1, 100);
                 anim.sumaCuadro(bomba2, 100);
                 anim.sumaCuadro(bomba3, 100);
                }
                
                //Se crea la animación
                
               
	}

    boolean tiene(int x1, int y1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
}