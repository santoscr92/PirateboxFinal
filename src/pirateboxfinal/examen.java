/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pirateboxfinal;

/**
 *
 * @author santoscr92
 */
// davidmartinez aka le Sheku1
//tonyStark
//thechosenjuan
import javax.swing.JFrame;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class examen extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private Image dbImage;      // Imagen a proyectar  
    private Image gameover;
    private Image fondo;
    private Image pausee;
    private Image howto;
    private Image settings;
    private Image menu;
    private Image inicio;
    private Image howdoi;
    private SoundClip cancionF; //Cancion de Fondo

    private Graphics dbg;       // Objeto grafico
    private SoundClip sonido;    // Objeto AudioClip
    private SoundClip rat;    // Objeto AudioClip
    private SoundClip bomb;    //Objeto AudioClip
    private SoundClip teleport;
    private Bueno jack;    // Objeto de la clase Bueno
    private Malo davidj;    //Objeto de la clase Malo
    private Ship ship;
    private Ship ship2;
    private Ship ship3;
    private int ancho;  //Ancho del jackimage
    private int alto;   //Alto del jackimage
    private ImageIcon jackimage; // Imagen del jackimage.
    private boolean clic;
    private int random;
    private int incX, incY, inx, iny;
    private long tiempoActual;
    private boolean move;
    private boolean start;
    private boolean howt;
    private boolean back;

    private double tiemporeal;
    private SoundClip shot;
    private SoundClip guncock;
    private boolean muerto, nootravez;

    //bala
    private Bala bala; //objeto bala
    private int jackcurrentstate; // saber en que direccion se quedo jack
    private int ammo;
    private boolean bal, balaviva, movbala;
    private int velocidadbalax, velocidadbalay;
    private int randomo;
    private final int MIN = -5;    //Minimo al generar un numero al azar.
    private final int MAX = 6;    //Maximo al generar un numero al azar.
    //malos
    private int x1; // posicion del mouse en x
    private int y1; // posicion del mouse en y
    private int vidas;
    private LinkedList lista, listo;
    private int score;
    private boolean pausa;
    private boolean bsettings;
    private boolean bhowto;
    private boolean bmenu;
    private boolean chocoabajo;
    private boolean chocoalado;
    private boolean creo, creu;
    private int vidatbr, vidamala, vidamalo2;
    private boolean up, down, left, right;
    private boolean activado;
    private boolean valp, valh, valm, vals;

    // variables para vida
    private int vida;
    private boolean espaciovida;

    //palmeras
    private LinkedList listapalmeras;
    private Palmera palma;
    private boolean ammopalma;
    private int tiempoammo, randomammo, ammoposx, ammoposy;

    //ammo
    private Ammo objetoammo;

    private boolean llego, mov;
    private int random2;
    private int random3;

    //TBR THA BOSS
    private boolean tbr, inicializaciontbr, inicializacionmalo, inicializacionmalo2,
            tbrbalaviva, tbrbalaviva1, tbrbalaviva2, tbrbalaviva3, tbrbalaviva4, tbrbalaviva5, tbrbala, malobr, malo2br;
    private TBR tonybr;
    private Malo2 malo;
    private boss3 Boss;
    private int timer;
    private Balathermo balathermo, balathermo1, balathermo2, balathermo3, balathermo4, balathermo5;

    //variables para el manejo de archivos
    private Vector vec;    // Objeto vector para agregar el puntaje.
    private String nombreArchivo;    //Nombre del archivo.
    private String[] arr;    //Arreglo del archivo divido.

    private JFrameScore jframeScore;    //Frame para desplegar el puntaje.
    private JList listaScore;    //Lista para desplegar el puntaje.

    public examen() {
        init();
        start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {
        tbr = false;
        inicializaciontbr = false;
        inicializacionmalo = false;
        inicializacionmalo2 = true;
        tbrbalaviva = false;
        tbrbalaviva1 = false;
        tbrbalaviva2 = false;
        tbrbalaviva3 = false;
        tbrbalaviva4 = false;
        tbrbalaviva5 = false;

        tbrbala = false;
        malobr = false;
        malo2br = false;
        tiemporeal = 0;
        clic = false;
        ammo = 10;
        vidas = 5;
        score = 0;
        pausa = false;
        bsettings = false;
        bhowto = false;
        bmenu = false;
        chocoabajo = false;
        chocoalado = false;
        vidatbr = 20;
        vidamala = 40;
        vidamalo2 = 70;
        creo = false;
        creu = false;
        activado = false;
        valp = true;
        valh = true;
        valm = true;
        vals = true;
        llego = false;
        this.setSize(1200, 700);
        move = false;
        start = false;
        howt = false;
        back = false;

        int posX = getWidth() / 2;    // posicion en x es un cuarto del applet
        int posY = getHeight() / 2;    // posicion en y es un cuarto del applet  
        guncock = new SoundClip("Sonidos/guncock.wav");
        shot = new SoundClip("Sonidos/shot.wav");
        jack = new Bueno(posX, posY, 1);
        URL bURL = this.getClass().getResource("Imagenes/balab.png");
        cancionF = new SoundClip("Sonidos/piratesong.wav");
        //jack.setPosX((int) (getWidth()/2));
        //jack.setPosY(getHeight());
        int posrX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;    //posision x es tres cuartos del applet
        int posrY = 100;    //posision y es tres cuartos del applet
        URL rURL = this.getClass().getResource("Imagenes/muerto.png");
        davidj = new Malo(posrX, posrY, 1);
        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
        davidj.setPosY(davidj.getPosY() - davidj.getAlto());

        setBackground(Color.white);
        addKeyListener(this);

        //imagenes
        URL goURL = this.getClass().getResource("Imagenes/palmera.png");
        gameover = Toolkit.getDefaultToolkit().getImage(goURL);

        URL geURL = this.getClass().getResource("Imagenes/gameover.png");
        gameover = Toolkit.getDefaultToolkit().getImage(geURL);

        URL fondoURL = this.getClass().getResource("Imagenes/fondo.jpg");
        fondo = Toolkit.getDefaultToolkit().createImage(fondoURL);

        URL pauseURL = this.getClass().getResource("Imagenes/pause.jpg");
        pausee = Toolkit.getDefaultToolkit().createImage(pauseURL);

        URL menuURL = this.getClass().getResource("Imagenes/menu.jpg");
        menu = Toolkit.getDefaultToolkit().createImage(menuURL);

        URL howtoURL = this.getClass().getResource("Imagenes/howto.png");
        howdoi = Toolkit.getDefaultToolkit().createImage(howtoURL);

        URL settingsURL = this.getClass().getResource("Imagenes/settings.jpg");
        settings = Toolkit.getDefaultToolkit().createImage(settingsURL);

        URL startURL = this.getClass().getResource("Imagenes/pantalla_inicio.png");
        inicio = Toolkit.getDefaultToolkit().createImage(startURL);

        //Se crea vector
        nombreArchivo = "Puntaje.txt";
        vec = new Vector();

        //Se cargan los sonidos.
        sonido = new SoundClip("Sonidos/mice.wav");
        bomb = new SoundClip("Sonidos/Explosion.wav");
        teleport = new SoundClip("Sonidos/teleport.wav");
        cancionF.setLooping(true);
        cancionF.play();

        //jackimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(eURL));
        //ancho = jackimage.getIconWidth();
        //alto = jackimage.getIconHeight();
        //ancho2 = davidj.getIconWidth();
        // alto2 = davidj.getIconHeight();
        addMouseListener(this);
        addMouseMotionListener(this);
        //creamos los 3 barcos
        int possX1 = 240;
        int possY1 = 100;
        ship = new Ship(possX1, possY1, 1);
        ship.setPosX(ship.getPosX() - ship.getAncho());
        ship.setPosY(ship.getPosY() - ship.getAlto());
        int possX2 = 735;
        int possY2 = 110;
        ship2 = new Ship(possX2, possY2, 1);
        ship2.setPosX(ship2.getPosX() - ship2.getAncho());
        ship2.setPosY(ship2.getPosY() - ship2.getAlto());
        int possX3 = 1100;
        int possY3 = 105;
        ship3 = new Ship(possX3, possY3, 1);
        ship3.setPosX(ship3.getPosX() - ship3.getAncho());
        ship3.setPosY(ship3.getPosY() - ship3.getAlto());

        // creamos los malos
        lista = new LinkedList();
        for (int k = 0; k < 12; k++) {

            random = ((int) ((Math.random() * (129 - 76)) + 76));
            random2 = ((int) ((Math.random() * (632 - 576)) + 576));
            random3 = ((int) ((Math.random() * (1007 - 948)) + 948));
            int posaY = 0;    //posision x es tres cuartos del applet
            //int posaY = (int) (Math.random() * (getHeight() / 4)) + getHeight() / 2;    //posision y es tres cuartos del applet
            int posaX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;
            URL aURL = this.getClass().getResource("Imagenes/muerto.png");
            if (k == 0 || k == 1 || k == 2 || k == 3) {
                davidj = new Malo(random, posrY, 1);
                davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                lista.addLast(davidj);
            }

            if (k == 4 || k == 5 || k == 6 || k == 7) {
                davidj = new Malo(random2, posrY, 1);
                davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                lista.addLast(davidj);

            }
            if (k == 8 || k == 9 || k == 10 || k == 11) {
                davidj = new Malo(random3, posrY, 1);
                davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                lista.addLast(davidj);
            }
        }

        //creacion de palmeras
        listapalmeras = new LinkedList();
        for (int k = 0; k < 4; k++) {
            if (k == 0) {
                palma = new Palmera(70, 220, 1);
                listapalmeras.addLast(palma);
            } else if (k == 1) {
                palma = new Palmera(70, 570, 1);
                listapalmeras.addLast(palma);
            } else if (k == 2) {
                palma = new Palmera(1030, 220, 1);
                listapalmeras.addLast(palma);
            } else if (k == 3) {
                palma = new Palmera(1030, 570, 1);
                //palma.setPosX(palma.getPosX() - palma.getAncho());
                //palma.setPosY(palma.getPosY() - palma.getAlto());
                listapalmeras.addLast(palma);
            }

        }

        jackcurrentstate = 2;
        vida = 5;
        espaciovida = false;
        velocidadbalax = 30;
        velocidadbalay = 30;

        try {

            leeArchivo();    //lee el contenido del archivo

        } catch (IOException e) {

            System.out.println("Error en " + e.toString());
        }

    }

    public void start() {
        // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    public void TBR() {
        tonybr = new TBR(600, 30, 1);
    }

    public void Malo2() {
        malo = new Malo2(600, 30, 1);

    }

    public void Malo3() {
        Boss = new boss3(600, 30, 1);
    }

    public void run() {
        while (vida > 0) {
            if (start && !pausa) {
                actualiza();
                checaColision();
            }
            repaint();
            // Se actualiza el <code>Applet</code> repintando el contenido.
            try {
                // El thread se duerme.
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }

        }
    }

    public void actualiza() {
        if (vida == 1) {
            Muerto();
            vida--;
        }
        if (vidamala == 0) {
            int posrX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;    //posision x es tres cuartos del applet
            int posrY = 100;    //posision y es tres cuartos del applet
            // crear la nueva lista
            //quitar el boss
            malo = null;
            balathermo1 = null;
            if (!creu) {
                for (int k = 0; k < 12; k++) {

                    random = ((int) ((Math.random() * (129 - 76)) + 76));
                    random2 = ((int) ((Math.random() * (632 - 576)) + 576));
                    random3 = ((int) ((Math.random() * (1007 - 948)) + 948));
                    int posaY = 0;    //posision x es tres cuartos del applet
                    //int posaY = (int) (Math.random() * (getHeight() / 4)) + getHeight() / 2;    //posision y es tres cuartos del applet
                    int posaX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;
                    URL aURL = this.getClass().getResource("Imagenes/muerto.png");
                    if (k == 0 || k == 1 || k == 2 || k == 3) {
                        davidj = new Malo(random, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);
                    }

                    if (k == 4 || k == 5 || k == 6 || k == 7) {
                        davidj = new Malo(random2, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);

                    }
                    if (k == 8 || k == 9 || k == 10 || k == 11) {
                        davidj = new Malo(random3, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);
                    }
                }
                creu = true;
                inicializacionmalo2 = false;
                //tbrbalaviva = false;
            }

        }
        if (vidatbr == 0) {
            int posrX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;    //posision x es tres cuartos del applet
            int posrY = 100;    //posision y es tres cuartos del applet
            // crear la nueva lista
            //quitar el boss
            tonybr = null;
            balathermo = null;
            if (!creo) {
                for (int k = 0; k < 12; k++) {

                    random = ((int) ((Math.random() * (129 - 76)) + 76));
                    random2 = ((int) ((Math.random() * (632 - 576)) + 576));
                    random3 = ((int) ((Math.random() * (1007 - 948)) + 948));
                    int posaY = 0;    //posision x es tres cuartos del applet
                    //int posaY = (int) (Math.random() * (getHeight() / 4)) + getHeight() / 2;    //posision y es tres cuartos del applet
                    int posaX = (int) (Math.random() * (getWidth() / 4)) + getWidth() / 2;
                    URL aURL = this.getClass().getResource("Imagenes/muerto.png");
                    if (k == 0 || k == 1 || k == 2 || k == 3) {
                        davidj = new Malo(random, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);
                    }

                    if (k == 4 || k == 5 || k == 6 || k == 7) {
                        davidj = new Malo(random2, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);

                    }
                    if (k == 8 || k == 9 || k == 10 || k == 11) {
                        davidj = new Malo(random3, posrY, 1);
                        davidj.setPosX(davidj.getPosX() - davidj.getAncho());
                        davidj.setPosY(davidj.getPosY() - davidj.getAlto());
                        lista.addLast(davidj);
                    }
                }
                creo = true;
                //tbrbalaviva = false;
            }

        }

        //para que el ammo salga cada 15 segundos
        if (((int) tiemporeal) % 15 == 0) {
            randomammo = ((int) ((Math.random() * (5 - 1)) + 1));
            if (randomammo == 1) {
                ammoposx = 70;
                ammoposy = 220;
            } else if (randomammo == 2) {
                ammoposx = 70;
                ammoposy = 570;
            } else if (randomammo == 3) {
                ammoposx = 1030;
                ammoposy = 220;
            } else if (randomammo == 4) {
                ammoposx = 1030;
                ammoposy = 570;
            }
            ammopalma = true;
        }

        if (!pausa) {
            tiemporeal += .020;
        }

        //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;

        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;

        //inicializa TBR tha Boss
        if (lista.size() == 0 && !inicializaciontbr) {
            tbr = true;
        }

        if (tbr) {
            TBR();
            tbr = false;
            inicializaciontbr = true;
        }

        if (lista.size() == 0 && tonybr == null && !inicializacionmalo) {
            malobr = true;
        }

        if (lista.size() == 0 && tonybr == null && !inicializacionmalo2) {
            malo2br = true;
        }

        if (malo2br) {
            Malo3();
            malo2br = false;
            inicializacionmalo2 = true;
        }

        if (malobr) {
            Malo2();
            malobr = false;
            inicializacionmalo = true;
        }
        if (malo != null) {
            malo.actualizaAnimacion(tiempoActual);
            inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
            iny = ((int) (Math.random() * (MAX - MIN))) + MIN;

            if (jack.getPosX() > malo.getPosX()) {
                incX = 1;
                malo.setFlechitas(3);
                malo.setPosX(malo.getPosX() + incX + inx);
            } else {

                incX = -1;
                malo.setFlechitas(4);
                malo.setPosX(malo.getPosX() + incX + inx);
            }

            if (jack.getPosY() > malo.getPosY()) {

                incY = 1;
                malo.setFlechitas(1);
                malo.setPosY(malo.getPosY() + incY + iny);
            } else {
                incY = -1;
                malo.setFlechitas(2);
                malo.setPosY(malo.getPosY() + incY + iny);
            }

            if (!tbrbalaviva1) {
                balathermo1 = new Balathermo(malo.getPosX() + (malo.getAncho() / 2), malo.getPosY() + 25, 4);
                shot.play();
                tbrbalaviva1 = true;
            }
            if (balathermo1 != null) {
                balathermo1.setPosY(balathermo1.getPosY() + 30);
                balathermo1.actualizaAnimacion(tiempoActual);
            }
        }

        if (tonybr != null) {
            tonybr.actualizaAnimacion(tiempoActual);
            inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
            iny = ((int) (Math.random() * (MAX - MIN))) + MIN;

            if (jack.getPosX() > tonybr.getPosX()) {
                incX = 1;
                tonybr.setFlechitas(3);
                tonybr.setPosX(tonybr.getPosX() + incX + inx);
            } else {

                incX = -1;
                tonybr.setFlechitas(4);
                tonybr.setPosX(tonybr.getPosX() + incX + inx);
            }

            if (jack.getPosY() > tonybr.getPosY()) {

                incY = 1;
                tonybr.setFlechitas(1);
                tonybr.setPosY(tonybr.getPosY() + incY + iny);
            } else {
                incY = -1;
                tonybr.setFlechitas(2);
                tonybr.setPosY(tonybr.getPosY() + incY + iny);
            }

            if (!tbrbalaviva) {
                balathermo = new Balathermo(tonybr.getPosX() + (tonybr.getAncho() / 2), tonybr.getPosY() + 25, 4);
                shot.play();
                tbrbalaviva = true;
            }
            if (balathermo != null) {
                balathermo.setPosY(balathermo.getPosY() + 30);
                balathermo.actualizaAnimacion(tiempoActual);
            }

        }

        if (Boss != null) {
            Boss.actualizaAnimacion(tiempoActual);
            inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
            iny = ((int) (Math.random() * (MAX - MIN))) + MIN;

            if (jack.getPosX() > Boss.getPosX()) {
                incX = 1;
                Boss.setFlechitas(3);
                Boss.setPosX(Boss.getPosX() + incX + inx);
            } else {

                incX = -1;
                Boss.setFlechitas(4);
                Boss.setPosX(Boss.getPosX() + incX + inx);
            }

            if (jack.getPosY() > Boss.getPosY()) {

                incY = 1;
                Boss.setFlechitas(1);
                Boss.setPosY(Boss.getPosY() + incY + iny);
            } else {
                incY = -1;
                Boss.setFlechitas(2);
                Boss.setPosY(Boss.getPosY() + incY + iny);
            }

            // bala abajo
            if (!tbrbalaviva2) {
                balathermo2 = new Balathermo(Boss.getPosX() + (Boss.getAncho() / 2), Boss.getPosY() + Boss.getAlto(), 4);
                shot.play();
                tbrbalaviva2 = true;
            }
            if (balathermo2 != null) {
                balathermo2.setPosY(balathermo2.getPosY() + 30);
                balathermo2.actualizaAnimacion(tiempoActual);
            }

            // bala derecha
            if (!tbrbalaviva3) {
                balathermo3 = new Balathermo(Boss.getPosX() + Boss.getAncho(), Boss.getPosY() + (Boss.getAlto() / 2), 1);
                shot.play();
                tbrbalaviva3 = true;
            }
            if (balathermo3 != null) {
                balathermo3.setPosX(balathermo3.getPosX() + 30);
                balathermo3.actualizaAnimacion(tiempoActual);
            }

            // bala arriba
            if (!tbrbalaviva4) {
                balathermo4 = new Balathermo(Boss.getPosX() + (Boss.getAncho() / 2), Boss.getPosY(), 2);
                shot.play();
                tbrbalaviva4 = true;
            }
            if (balathermo4 != null) {
                balathermo4.setPosY(balathermo4.getPosY() - 30);
                balathermo4.actualizaAnimacion(tiempoActual);
            }

            // bala izquierda
            if (!tbrbalaviva5) {
                balathermo5 = new Balathermo(Boss.getPosX(), Boss.getPosY() + (Boss.getAlto() / 2), 3);
                shot.play();
                tbrbalaviva5 = true;
            }
            if (balathermo5 != null) {
                balathermo5.setPosX(balathermo5.getPosX() - 30);
                balathermo5.actualizaAnimacion(tiempoActual);
            }

        }

        //objetoammo.actualizaAnimacion(tiempoActual);
        //actualizacion de jack si esta en movimiento
        if (move == true) {
            jack.actualizaAnimacion(tiempoActual);
        }
        //actualizacion de animacion de barcos
        ship.actualizaAnimacion(tiempoActual);
        ship2.actualizaAnimacion(tiempoActual);
        ship3.actualizaAnimacion(tiempoActual);
        //actualizacion de animaicion de malos
        for (int x = 0; x < lista.size(); x++) {
            Malo davidj = (Malo) lista.get(x);
            davidj.actualizaAnimacion(tiempoActual);
        }

        //actualizacion de animaicion de malos
        for (int x = 0; x < listapalmeras.size(); x++) {
            Palmera palma = (Palmera) listapalmeras.get(x);
            palma.actualizaAnimacion(tiempoActual);
        }

        // movimiento de jack        
        if (up) {
            jack.setPosY(jack.getPosY() - 20);
            up = false;
            move = false;
            jackcurrentstate = 2;
        }
        if (down) {
            jack.setPosY(jack.getPosY() + 20);
            down = false;
            move = false;
            jackcurrentstate = 4;
        }
        if (left) {
            jack.setPosX(jack.getPosX() - 20);
            left = false;
            move = false;
            jackcurrentstate = 3;
        }
        if (right) {
            jack.setPosX(jack.getPosX() + 20);
            right = false;
            move = false;
            jackcurrentstate = 1;
        }

        // cruzar el puente
        for (int i = 0; i < lista.size(); i++) {
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                Malo davidj = (Malo) lista.get(i);
                if (!davidj.getllego()) {
                    incY = 1;
                    davidj.setFlechitas(1);
                    davidj.setPosY(davidj.getPosY() + incY);
                    if (davidj.getPosY() == 164) {
                        davidj.setllego(true);
                    }

                }
            }
            if (i == 4 || i == 5 || i == 6 || i == 7) {
                Malo davidj = (Malo) lista.get(i);
                if (!davidj.getllego()) {
                    incY = 1;
                    davidj.setFlechitas(1);
                    davidj.setPosY(davidj.getPosY() + incY);
                    if (davidj.getPosY() == 172) {
                        davidj.setllego(true);
                    }
                }
            }
            if (i == 8 || i == 9 || i == 10 || i == 11) {
                Malo davidj = (Malo) lista.get(i);
                if (!davidj.getllego()) {
                    incY = 1;
                    davidj.setFlechitas(1);
                    davidj.setPosY(davidj.getPosY() + incY);
                    if (davidj.getPosY() == 165) {
                        davidj.setllego(true);
                    }
                }
            }
        }

        // actualiza posicion de los malos
        // una vez que cruzo el puente se empiezan a actualizar
        for (int i = 0; i < lista.size(); i++) {
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                Malo davidj = (Malo) lista.get(i);
                if (davidj.getllego()) {
                    inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    iny = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    if (jack.getPosX() > davidj.getPosX()) {
                        incX = 1;
                        davidj.setFlechitas(3);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    } else {

                        incX = -1;
                        davidj.setFlechitas(4);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    }

                    if (jack.getPosY() > davidj.getPosY()) {

                        incY = 1;
                        davidj.setFlechitas(1);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    } else {
                        incY = -1;
                        davidj.setFlechitas(2);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    }
                }

            }
            if (i == 4 || i == 5 || i == 6 || i == 7) {
                Malo davidj = (Malo) lista.get(i);
                if (davidj.getllego()) {
                    inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    iny = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    if (jack.getPosX() > davidj.getPosX()) {
                        incX = 1;
                        davidj.setFlechitas(3);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    } else {

                        incX = -1;
                        davidj.setFlechitas(4);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    }

                    if (jack.getPosY() > davidj.getPosY()) {

                        incY = 1;
                        davidj.setFlechitas(1);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    } else {
                        incY = -1;
                        davidj.setFlechitas(2);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    }
                }
            }
            if (i == 8 || i == 9 || i == 10 || i == 11) {
                Malo davidj = (Malo) lista.get(i);
                if (davidj.getllego()) {
                    inx = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    iny = ((int) (Math.random() * (MAX - MIN))) + MIN;
                    if (jack.getPosX() > davidj.getPosX()) {
                        incX = 1;
                        davidj.setFlechitas(3);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    } else {

                        incX = -1;
                        davidj.setFlechitas(4);
                        davidj.setPosX(davidj.getPosX() + incX + inx);
                    }

                    if (jack.getPosY() > davidj.getPosY()) {

                        incY = 1;
                        davidj.setFlechitas(1);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    } else {
                        incY = -1;
                        davidj.setFlechitas(2);
                        davidj.setPosY(davidj.getPosY() + incY + iny);
                    }
                }

            }

        }

        //crea el objeto ammo
        if (ammopalma) {
            objetoammo = new Ammo(ammoposx, ammoposy, 1);
        }

        //crea una nueva bala
        if (bal && !balaviva && ammo > 0) {
            if (jackcurrentstate == 1) {
                bala = new Bala(jack.getPosX() + jack.getAncho(), jack.getPosY() + 25, jackcurrentstate);
                bala.setDireccion(jackcurrentstate);

            } else if (jackcurrentstate == 2) {
                bala = new Bala(jack.getPosX() + 10, jack.getPosY(), jackcurrentstate);
            } else if (jackcurrentstate == 3) {
                bala = new Bala(jack.getPosX(), jack.getPosY() + 25, jackcurrentstate);
            } else if (jackcurrentstate == 4) {
                bala = new Bala(jack.getPosX() + 10, jack.getPosY() + jack.getAlto(), jackcurrentstate);
            }
            bala.setDireccion(jackcurrentstate);
            shot.play();
            bal = false;
            balaviva = true;

            if (ammo > 0) {
                ammo--;
            }

        }

        //acutaliza animacion de la bala si no es null
        if (bala != null) {
            bala.actualizaAnimacion(tiempoActual);

            if (bala.getDireccion() == 1) {
                bala.setPosX(bala.getPosX() + velocidadbalax);
            } else if (bala.getDireccion() == 2) {
                bala.setPosY(bala.getPosY() - velocidadbalay);
            } else if (bala.getDireccion() == 3) {
                bala.setPosX(bala.getPosX() - velocidadbalax);
            } else if (bala.getDireccion() == 4) {
                bala.setPosY(bala.getPosY() + velocidadbalay);
            }
            movbala = true;

        }
    }

    public void checaColision() {

        //jack no sale del frame
        if (jack.getPosX() + jack.getAncho() > getWidth()) {
            jack.setPosX(getWidth() - jack.getAncho());
        }
        if (jack.getPosX() < 0) {
            jack.setPosX(0);
        }
        if (jack.getPosY() + jack.getAlto() > getHeight()) {
            jack.setPosY(getHeight() - jack.getAlto());
        }
        if (jack.getPosY() < 0) {
            jack.setPosY(0);
        }

        // si la bala sale del frame balaviva = false
        if (bala != null) {
            if (bala.getPosX() > getWidth()) {
                balaviva = false;
                //bala = null;
            }

            if (bala.getPosX() < 0) {
                balaviva = false;
                //bala = null;
            }

            if (bala.getPosY() > getHeight()) {
                balaviva = false;
                //bala = null;
            }

            if (bala.getPosY() < 0) {
                balaviva = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo != null) {
            if (balathermo.getPosX() > getWidth()) {
                tbrbalaviva = false;
                //bala = null;
            }

            if (balathermo.getPosX() < 0) {
                tbrbalaviva = false;
                //bala = null;
            }

            if (balathermo.getPosY() > getHeight()) {
                tbrbalaviva = false;
                //bala = null;
            }

            if (balathermo.getPosY() < 0) {
                tbrbalaviva = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo1 != null) {
            if (balathermo1.getPosX() > getWidth()) {
                tbrbalaviva1 = false;
                //bala = null;
            }

            if (balathermo1.getPosX() < 0) {
                tbrbalaviva1 = false;
                //bala = null;
            }

            if (balathermo1.getPosY() > getHeight()) {
                tbrbalaviva1 = false;
                //bala = null;
            }

            if (balathermo1.getPosY() < 0) {
                tbrbalaviva1 = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo2 != null) {
            if (balathermo2.getPosX() > getWidth()) {
                tbrbalaviva2 = false;
                //bala = null;
            }

            if (balathermo2.getPosX() < 0) {
                tbrbalaviva2 = false;
                //bala = null;
            }

            if (balathermo2.getPosY() > getHeight()) {
                tbrbalaviva2 = false;
                //bala = null;
            }

            if (balathermo2.getPosY() < 0) {
                tbrbalaviva2 = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo3 != null) {
            if (balathermo3.getPosX() > getWidth()) {
                tbrbalaviva3 = false;
                //bala = null;
            }

            if (balathermo3.getPosX() < 0) {
                tbrbalaviva3 = false;
                //bala = null;
            }

            if (balathermo3.getPosY() > getHeight()) {
                tbrbalaviva3 = false;
                //bala = null;
            }

            if (balathermo3.getPosY() < 0) {
                tbrbalaviva3 = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo4 != null) {
            if (balathermo4.getPosX() > getWidth()) {
                tbrbalaviva4 = false;
                //bala = null;
            }

            if (balathermo4.getPosX() < 0) {
                tbrbalaviva4 = false;
                //bala = null;
            }

            if (balathermo4.getPosY() > getHeight()) {
                tbrbalaviva4 = false;
                //bala = null;
            }

            if (balathermo4.getPosY() < 0) {
                tbrbalaviva4 = false;
                //bala = null;
            }
        }

        // si la bala sale del frame balaviva = false
        if (balathermo5 != null) {
            if (balathermo5.getPosX() > getWidth()) {
                tbrbalaviva5 = false;
                //bala = null;
            }

            if (balathermo5.getPosX() < 0) {
                tbrbalaviva5 = false;
                //bala = null;
            }

            if (balathermo5.getPosY() > getHeight()) {
                tbrbalaviva5 = false;
                //bala = null;
            }

            if (balathermo5.getPosY() < 0) {
                tbrbalaviva5 = false;
                //bala = null;
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            Malo davidj = (Malo) lista.get(i);

            if (jack.intersecta(davidj)) {

                bomb.play();    //sonido al colisionar
                vida--;
                if ((davidj.getPosY() + davidj.getAlto() - 3) < jack.getPosY()) {
                    davidj.setPosY(davidj.getPosY() - 50);
                }

                if ((davidj.getPosY() + 3) > jack.getPosY()) {
                    davidj.setPosY(davidj.getPosY() + 50);
                }

                if ((davidj.getPosX() + davidj.getAncho() - 3) < jack.getPosX()) {
                    davidj.setPosX(davidj.getPosX() - 50);
                }

                if ((davidj.getPosX() + 3) > jack.getPosX()) {
                    davidj.setPosX(davidj.getPosX() + 50);
                }

            }
            if (bala != null) {
                if (bala.intersecta(davidj)) {

                    score += 5;
                    //Los asteroides aparecen en un rando random

                    bala = null;
                    balaviva = false;
                    movbala = false;
                    lista.remove(i);
                    randomo = ((int) (Math.random() * (4 - 1) + 1));

                }
            }

        }

        if (tonybr != null) {
            if (jack.intersecta(tonybr)) {
                vidatbr--;
                vida = 0;
                Muerto();
                if ((tonybr.getPosY() + tonybr.getAlto() - 3) < jack.getPosY()) {
                    tonybr.setPosY(tonybr.getPosY() - 500);
                }

                if ((tonybr.getPosY() + 3) > jack.getPosY()) {
                    tonybr.setPosY(tonybr.getPosY() + 500);
                }

                if ((tonybr.getPosX() + tonybr.getAncho() - 3) < jack.getPosX()) {
                    tonybr.setPosX(tonybr.getPosX() - 500);
                }

                if ((tonybr.getPosX() + 3) > jack.getPosX()) {
                    tonybr.setPosX(tonybr.getPosX() + 500);
                }
            }

            if (balathermo != null) {
                if (balathermo.intersecta(jack)) {
                    vida--;
                    tbrbalaviva = false;
                }
            }

            if (bala != null) {
                if (bala.intersecta(tonybr)) {

                    score += 5;
                    //Los asteroides aparecen en un rando random
                    vidatbr--;
                    bala = null;
                    balaviva = false;
                    movbala = false;
                }
            }
        }
        if (malo != null) {
            if (jack.intersecta(malo)) {
                vidamala--;
                vida = 0;
                Muerto();
                if ((malo.getPosY() + malo.getAlto() - 3) < jack.getPosY()) {
                    tonybr.setPosY(tonybr.getPosY() - 500);
                }

                if ((malo.getPosY() + 3) > jack.getPosY()) {
                    malo.setPosY(malo.getPosY() + 500);
                }

                if ((malo.getPosX() + malo.getAncho() - 3) < jack.getPosX()) {
                    malo.setPosX(malo.getPosX() - 500);
                }

                if ((malo.getPosX() + 3) > jack.getPosX()) {
                    malo.setPosX(malo.getPosX() + 500);
                }
            }

            if (balathermo1 != null) {
                if (balathermo1.intersecta(jack)) {
                    vida--;
                    tbrbalaviva1 = false;
                }
            }

            if (bala != null) {
                if (bala.intersecta(malo)) {

                    score += 5;
                    //Los asteroides aparecen en un rando random
                    vidamala--;
                    bala = null;
                    balaviva = false;
                    movbala = false;
                }
            }
        }

        if (Boss != null) {
            if (jack.intersecta(Boss)) {
                vidamalo2--;
                vida = 0;
                Muerto();
                if ((Boss.getPosY() + Boss.getAlto() - 3) < jack.getPosY()) {
                    Boss.setPosY(Boss.getPosY() - 500);
                }

                if ((Boss.getPosY() + 3) > jack.getPosY()) {
                    Boss.setPosY(Boss.getPosY() + 500);
                }

                if ((Boss.getPosX() + Boss.getAncho() - 3) < jack.getPosX()) {
                    Boss.setPosX(Boss.getPosX() - 500);
                }

                if ((Boss.getPosX() + 3) > jack.getPosX()) {
                    Boss.setPosX(Boss.getPosX() + 500);
                }

            }

            if (balathermo2 != null) {
                if (balathermo2.intersecta(jack)) {
                    vida--;
                    tbrbalaviva2 = false;
                }
            }

            if (balathermo3 != null) {
                if (balathermo3.intersecta(jack)) {
                    vida--;
                    tbrbalaviva3 = false;
                }
            }

            if (balathermo4 != null) {
                if (balathermo4.intersecta(jack)) {
                    vida--;
                    tbrbalaviva4 = false;
                }
            }

            if (balathermo5 != null) {
                if (balathermo5.intersecta(jack)) {
                    vida--;
                    tbrbalaviva5 = false;
                }
            }

            if (bala != null) {
                if (bala.intersecta(Boss)) {

                    score += 5;
                    //Los asteroides aparecen en un rando random
                    vidamala--;
                    bala = null;
                    balaviva = false;
                    movbala = false;
                }

            }
        }

        if (objetoammo != null) {
            if (jack.intersecta(objetoammo)) {
                ammo += 15;
                objetoammo = null;
                ammopalma = false;
                guncock.play();
            }
        }

        /* if(tonybr != null){
         if(bala.intersecta(tonybr)){
         tonybr.setVida(tonybr.getVida() - 1);
         }
         }*/
    }

    public void Muerto() {
        creaJFrame();

        String nombre = JOptionPane.showInputDialog("Cual es tu nombre?");
        JOptionPane.showMessageDialog(null,
                "El puntaje de " + nombre + " es: " + score, "PUNTAJE",
                JOptionPane.PLAIN_MESSAGE);
        //reinicio = true;

        try {

            //leeArchivo();    //lee el contenido del archivo
            //Agrega el contenido del nuevo puntaje al vector.
            vec.add(new Puntaje(nombre, score));
            ordenaVector();
            //Graba el vector en el archivo.
            grabaArchivo();

        } catch (IOException e) {

            System.out.println("Error en " + e.toString());
        }
    }

    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paint1(Graphics g) {
        if (vida > 0) {
            if (!start) {
                g.drawImage(inicio, 0, 0, null);

            }
            if (howt) {
                g.drawImage(howdoi, 0, 22, null);
            }

            if (start && (jack != null && davidj != null && ship != null && ship2 != null && ship3 != null)) {
                //Dibuja la imagen en la posicion actualizada
                g.drawImage(fondo, 0, 0, null);
                g.drawImage(jack.getImagenI(), jack.getPosX(), jack.getPosY(), this);
                g.drawImage(ship.getImagenI(), ship.getPosX(), ship.getPosY(), this);
                g.drawImage(ship2.getImagenI(), ship2.getPosX(), ship2.getPosY(), this);
                g.drawImage(ship3.getImagenI(), ship3.getPosX(), ship3.getPosY(), this);

                for (int i = 0; i < listapalmeras.size(); i++) {
                    Palmera palma = (Palmera) listapalmeras.get(i);
                    g.drawImage(palma.getImagenI(), palma.getPosX(), palma.getPosY(), this);
                }
                for (int i = 0; i < lista.size(); i++) {
                    Malo davidj = (Malo) lista.get(i);
                    g.drawImage(davidj.getImagenI(), davidj.getPosX(), davidj.getPosY(), this);
                }
                if (objetoammo != null) {
                    g.drawImage(objetoammo.getImagenI(), objetoammo.getPosX(), objetoammo.getPosY(), this);
                }
                if (bala != null) {
                    g.drawImage(bala.getImagenI(), bala.getPosX(), bala.getPosY(), this);
                }

                if (tonybr != null) {
                    g.drawImage(tonybr.getImagenI(), tonybr.getPosX(), tonybr.getPosY(), this);
                }

                if (malo != null) {
                    g.drawImage(malo.getImagenI(), malo.getPosX(), malo.getPosY(), this);
                }

                if (Boss != null) {
                    g.drawImage(Boss.getImagenI(), Boss.getPosX(), Boss.getPosY(), this);
                }

                if (balathermo != null) {
                    g.drawImage(balathermo.getImagenI(), balathermo.getPosX(), balathermo.getPosY(), this);
                }

                if (balathermo1 != null) {
                    g.drawImage(balathermo1.getImagenI(), balathermo1.getPosX(), balathermo1.getPosY(), this);
                }

                if (balathermo2 != null) {
                    g.drawImage(balathermo2.getImagenI(), balathermo2.getPosX(), balathermo2.getPosY(), this);
                }
                if (balathermo3 != null) {
                    g.drawImage(balathermo3.getImagenI(), balathermo3.getPosX(), balathermo3.getPosY(), this);
                }

                if (balathermo4 != null) {
                    g.drawImage(balathermo4.getImagenI(), balathermo4.getPosX(), balathermo4.getPosY(), this);
                }

                if (balathermo5 != null) {
                    g.drawImage(balathermo5.getImagenI(), balathermo5.getPosX(), balathermo5.getPosY(), this);
                }

                g.drawString("Score: " + score, 250, 50);
                g.drawString("ammo: " + ammo, 400, 50);
                g.drawString("tiempo: " + (int) tiemporeal, 780, 50);
                g.drawString("Vida: " + (vida - 1), jack.getPosX(), jack.getPosY() - 10);

            } else {
                //Da un mensaje mientras se carga el dibujo
                g.drawString("No se cargo la imagen..", 20, 20);
            }
        } else {
            setBackground(Color.black);
            pausa = true;
            g.drawImage(gameover, 150, 0, this);
        }
    }

    /**
     * Metodo que lee a informacion de un archivo y lo agrega a un vector.
     *
     * @throws IOException
     */
    public void leeArchivo() throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(nombreArchivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            //fileOut.println("100,demo");
            fileOut.println("");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        }
        String dato = fileIn.readLine();

        if (!dato.equals("")) {
            while (dato != null) {
                arr = dato.split(",");
                int num = (Integer.parseInt(arr[0]));
                String nom = arr[1];
                vec.add(new Puntaje(nom, num));
                dato = fileIn.readLine();
            }
        }
        fileIn.close();
    }

    /**
     * Metodo que agrega la informacion del vector al archivo.
     *
     * @throws IOException
     */
    public void grabaArchivo() throws IOException {

        //if(guardar) {
        PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));
        for (int i = 0; i < vec.size(); i++) {
            Puntaje x;
            x = (Puntaje) vec.get(i);
            fileOut.println(x.toString());
        }
        fileOut.close();

    }

    /**
     * Metodo que ordena el vector
     */
    public void ordenaVector() {
        for (int i = 0; i < vec.size() - 1; i++) {
            for (int j = i; j < vec.size(); j++) {
                if (((Puntaje) vec.get(i)).getPuntaje() < ((Puntaje) vec.get(j)).getPuntaje()) {
                    Puntaje p = (Puntaje) vec.get(i);
                    vec.set(i, vec.get(j));
                    vec.set(j, p);
                }
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        int x = jack.getPosX();
        int y = jack.getPosY();

        if (e.getKeyCode() == KeyEvent.VK_P) //Presiono flecha arriba
        {
            pausa = !pausa;
        }

        if (e.getKeyCode() == KeyEvent.VK_R) //Presiono flecha arriba
        {
            init();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!balaviva) {
                bal = true;
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_H) //Presiono flecha arriba
        {
            jframeScore.setVisible(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) //Presiono flecha arriba
        {
            jack = new Bueno(x, y, 1);
            up = true;
            move = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) //Presiono flecha abajo
        {
            jack = new Bueno(x, y, 2);
            down = true;
            move = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) //Presiono flecha izquierda
        {
            jack = new Bueno(x, y, 3);
            left = true;
            move = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) //Presiono flecha derecha
        {
            jack = new Bueno(x, y, 4);
            right = true;
            move = true;
        }

    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Rectangle play = new Rectangle(337, 583, 198, 69);
        Rectangle how = new Rectangle(576, 583, 246, 69);
        x1 = e.getX();
        y1 = e.getY();
        if (play.contains(x1, y1) && !howt) {
            start = true;
        } else if (how.contains(x1, y1)) {
            howt = true;

        }

        if (howt) {
            Rectangle atras = new Rectangle(483, 627, 207, 53);
            if (atras.contains(x1, y1)) {
                howt = false;
            }

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Metodo que crea el frame para desplegar el score.
     */
    public void creaJFrame() {
        jframeScore = new JFrameScore();
    }

    private class JFrameScore extends JFrame {

        public JFrameScore() {
            JButton boton = new JButton("SALIR");
            listaScore = new JList(vec);
            add(listaScore, BorderLayout.CENTER);
            add(boton, BorderLayout.SOUTH);
            setSize(200, 500);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //pause = false;
                    //musica.play();
                    setVisible(false);
                    repaint();
                }
            });

        }
    }

}
