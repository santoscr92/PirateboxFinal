/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pirateboxfinal;

/**
 *
 * @author tonystark
 */

import java.awt.Image;
import java.util.ArrayList;

/**
	La clase Animacion maneja una serie de imágenes (cuadros)
	y la cantidad de tiempo que se muestra cada cuadro.
*/

public class Animacion{
	
	private ArrayList cuadros;
	private int indiceCuadroActual;
	private long tiempoDeAnimacion;
	private long duracionTotal;
	
	/**
		Crea una nueva Animacion vacía
	*/
	public Animacion(){
		cuadros = new ArrayList();
		duracionTotal = 0;
		iniciar();
	}
	
	/**
		Añade una cuadro a la animación con la duración
		indicada (tiempo que se muestra la imagen).
     * @param imagen
     * @param duracion
	*/	
	public synchronized void sumaCuadro(Image imagen, long duracion){
		duracionTotal += duracion;
		cuadros.add(new cuadroDeAnimacion(imagen, duracionTotal));
	}
	
	// Inicializa la animación desde el principio. 

    /**
     * Inicializa las variables en cero de tiempoDeAnimacion en 0 y el
     * indiceCuadoActual en 0
     */
    	public synchronized void iniciar(){
		tiempoDeAnimacion = 0;
		indiceCuadroActual = 0;
	}
	
	/**
		Actualiza la imagen (cuadro) actual de la animación,
		si es necesario.
     * @param tiempoTranscurrido
	*/
	public synchronized void actualiza(long tiempoTranscurrido){
		if (cuadros.size() > 1){
			tiempoDeAnimacion += tiempoTranscurrido;
			
			if (tiempoDeAnimacion >= duracionTotal){
				tiempoDeAnimacion = tiempoDeAnimacion % duracionTotal;
				indiceCuadroActual = 0; 
			}
			
			while (tiempoDeAnimacion > getCuadro(indiceCuadroActual).tiempoFinal){
				indiceCuadroActual++;
			}
		}
	}
	
	/**
		Captura la imagen actual de la animación. Regeresa null
		si la animación no tiene imágenes.
     * @return 
	*/
	public synchronized Image getImagen(){
		if (cuadros.size() == 0){
			return null;
		}
		else {
			return getCuadro(indiceCuadroActual).imagen;
		}
	}
	
	private cuadroDeAnimacion getCuadro(int i){
		return (cuadroDeAnimacion)cuadros.get(i);
	}
	
    /**
     *La clase cuardoDeAnimacion obtiene las imagenes y realiza las animaciones
     */
    public class cuadroDeAnimacion{
		
		Image imagen;
		long tiempoFinal;
		
            /**
             *
             */
            public cuadroDeAnimacion(){
			this.imagen = null;
			this.tiempoFinal = 0;
		}
		
            /**
             *
             * @param imagen
             * @param tiempoFinal
             */
            public cuadroDeAnimacion(Image imagen, long tiempoFinal){
			this.imagen = imagen;
			this.tiempoFinal = tiempoFinal;
		}
		
            /**
             *
             * @return
             */
            public Image getImagen(){
			return imagen;
		}
		
            /**
             *
             * @return
             */
            public long getTiempoFinal(){
			return tiempoFinal;
		}
		
            /**
             *
             * @param imagen
             */
            public void setImagen (Image imagen){
			this.imagen = imagen;
		}
		
            /**
             *
             * @param tiempoFinal
             */
            public void setTiempoFinal(long tiempoFinal){
			this.tiempoFinal = tiempoFinal;
		}
	}
		
}