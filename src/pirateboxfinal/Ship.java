/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pirateboxfinal;

/**
 *
 * @author David
 */
import java.awt.Image;
import java.awt.Toolkit;

    /**
     * Metodo constructor que hereda los atributos de la clase <code>Base</code>.
     * @param image es la <code>imagen</code> del objeto ship.
     */
public class Ship extends Base {

    private boolean llega;

    /*
    public void setllega(boolean a) {
        llega = a;
    }

    public boolean getllega() {
        return llega;
    }
    */
    /**
     * Indica al ship los variables que se van a usar para crear los objetos
     * Metodo Malo donde se le asignan valores a los objetos de flechitas y posx y posy
     * @param posX
     * @param posY
     * @param casu
     */
    public Ship(int posX, int posY, int casu) {
        super(posX, posY, casu);
        Image ship1;
        ship1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/pirateship.png"));
        anim = new Animacion();
        anim.sumaCuadro(ship1, 100);

    }
}
