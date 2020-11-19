package com.mycompany.proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ventana extends JPanel implements ActionListener{
    // ventana
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc;
    public JButton b,b1,b2,b3,b4,b5,b6,b7,b8;
    public JButton btn4;
    public JMenu uno; 
    public JMenuItem u,u1,u2,u3,u4,u5,u6,u7,u8;
    public MouseListener mouse;
    public JButton  btAumentar,btDisminuir,btInformacion;

    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(1200, 1200);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        u  = new JMenuItem("Escalar");
        u1 = new JMenuItem("Trasladar");
        u2 = new JMenuItem("Rotacion");
        u3 = new JMenuItem("Rotacion negativa");
        u4 = new JMenuItem("Reflexion en x");
        u5 = new JMenuItem("Reflexion en y");
        u6 = new JMenuItem("Reflexion en xy");
        u7 = new JMenuItem("Deformacion");
        u8 = new JMenuItem("Repintar");
        
        arc.add(uno);
        uno.add(u);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        uno.add(u8);
        u.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        
        b  = new JButton("Escalar");
        b1 = new JButton("Trasladar");
        b2 = new JButton("Rotacion");
        b3 = new JButton("Rotacion negativa");
        b4 = new JButton("Reflexion en x");
        b5 = new JButton("Reflexion en y");
        b6 = new JButton("Reflexion en xy");
        b7 = new JButton("Deformacion");
        b8 = new JButton("Repintar");
        btAumentar = new JButton("+");
        btDisminuir = new JButton("-");
        btInformacion = new JButton("INFO");
          
        add(arc);
  
        
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
                
  
        
        arc.add(b);
        arc.add(b1);
        arc.add(b2);
        arc.add(b3);
        arc.add(b4);
        arc.add(b5);
        arc.add(b6);
        arc.add(b7);
        arc.add(b8);
        arc.add(btInformacion);
        arc.add(btDisminuir);
        arc.add(btAumentar);
        
            
    //-----------------------------------------------------------------------------------------
    //------------------------------------- Mause --------------------------------------------
        mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==btAumentar) {
                escalar(2.0,2.0);
                repaint();
                }else if(e.getSource()==btDisminuir){
                escalar(.5,.5);
                repaint();
                 }else if(e.getSource()==btInformacion){
                 JOptionPane.showMessageDialog(null, "Uso mouse: \n"+
                                                     "Click sobre boton con icono + : Hace que la figura aumente \n"+
                                                     "Click sobre boton con icono - : Hace que la figura disminuya  \n"+
                                                     "Click sobre boton con icono 'i' : Muestra la pantalla de informacion sobre los controles e utilizacion del programa\n\n"+
                                                     "Uso del teclado:   \n"+
                                                     "Tecla de la flechita hacia arriba : Agrandar figura \n "+
                                                     "Tecla de la flechita hacia abajo : Disminuir la figura \n "+
                                                     "Tecla 'T' : Realiza una traslacion \n "+ 
                                                     "Tecla 'E' : Realiza una rotacion de 15º positiva \n "+
                                                     "Tecla 'Q' : Realiza una rotacion de 15º negativa \n "+
                                                     "Tecla 'X' : Realiza una reflexion X \n "+
                                                     "Tecla 'Y' : Realiza una reflexion Y  \n "+
                                                     "Tecla 'B' : Realiza una reflexion XY  \n "+
                                                     "Tecla 'Z' : Restablece la figura a su forma normal  \n "
                                                        );           
            }}

            @Override
            public void mousePressed(MouseEvent e) {
             }

            @Override
            public void mouseReleased(MouseEvent e) {
             }

            @Override
            public void mouseEntered(MouseEvent e) {
             }

            @Override
            public void mouseExited(MouseEvent e) {
             }
        };
        btAumentar.addMouseListener(mouse);
        btDisminuir.addMouseListener(mouse);
        btInformacion.addMouseListener(mouse);
   
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.addMouseListener(mouse);
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
        ventana.addKeyListener(new Listener(this));        
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.blue);
        this.dibujar(g);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==u || e.getSource()==b){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.escalar(x,y);
            repaint();
        }
        if(e.getSource()==u1 || e.getSource()==b1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u2 || e.getSource()==b2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.Rotacion(angulo);
            repaint();
        }
        if(e.getSource()==u3 || e.getSource()==b3){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.rotacionneg(angulo);
            repaint();
        }
        if(e.getSource()==u4 || e.getSource()==b4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==u5 || e.getSource()==b5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==u6 || e.getSource()==b6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==u7 || e.getSource()==b7){
            double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en Y"));
            this.deformacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u8 || e.getSource()==b8){
            this.redibujar();
            repaint();
        }
    }
        
    public void escalar(double fx, double fy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((x – tx) * fx) + tx
        //punto y:((y – ty) * fy) + ty
            punto.setX((int)(((punto.getX() - tx)* fx) + tx));
            punto.setY((int)(((punto.getY() - ty)* fy) + ty));
        }
    }
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:(x - tx) * cos – (b – ty) * sin + tx
        //punto y: (x - ty) * sin + (b – ty) * cos + ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void rotacionneg(double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((a-tx)cos + (b-ty)(sen)) +tx
        //punto y: (-(a-tx)(sen) + (b-ty)(cos))+ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)(-(punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void reflexionx(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) (punto.getY()-ty)+ty);
        }
    }public void reflexiony(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) (punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void reflexionxy(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((x - tx) + (b - ty) * dx) + tx
        //punto y: ((y - ty) * dy + (b – ty )) + ty
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),//punto A
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),//punto B
                    this.figura[i+1].getY()
            );
        }
    }
    
    public void setFigura(Punto figura[]){
        this.figura=figura;
    }
    
    public void redibujar(){
        Punto fig[] = {
            new Punto (500,100), //1
            new Punto (500,120), //2
            new Punto (480,120),  //3
            new Punto (480,140), //4
            new Punto (460,140), //5
            new Punto (460,160), //6
            new Punto (440,160), //7
            new Punto (440,180), //8
            new Punto (420,180), //9
            new Punto (420,200), //10
            new Punto (400,200), //11
            new Punto (400,220), //12
            new Punto (380,220), //13
            new Punto (380,240), //14
            new Punto (360,240), //15
            new Punto (360,260), //16
            new Punto (340,260), //17
            new Punto (340,280), //18
            new Punto (320,280), //19
            new Punto (320,300), //20
            new Punto (300,300), //21
            new Punto (300,320), //22
            new Punto (280,320), //23
            new Punto (280,340), //24
            new Punto (260,340), //25
            new Punto (260,360), //26
            new Punto (240,360), //27
            new Punto (240,380), //28
            new Punto (760,380), //29
            new Punto (760,360), //30
            new Punto (740,360), //31
            new Punto (740,340), //32
            new Punto (720,340), //33
            new Punto (720,320), //34
            new Punto (700,320), //35
            new Punto (700,300), //36
            new Punto (680,300), //37
            new Punto (680,280), //38
            new Punto (660,280), //39
            new Punto (660,260), //40
            new Punto (640,260), //41
            new Punto (640,240), //42
            new Punto (620,240), //43
            new Punto (620,220), //44
            new Punto (600,220), //45
            new Punto (600,200), //46
            new Punto (580,200), //47
            new Punto (580,180), //48
            new Punto (560,180), //49
            new Punto (560,160), //50
            new Punto (540,160), //21
            new Punto (540,140), //52
            new Punto (520,140), //53
            new Punto (520,120), //54
            new Punto (500,120)  //55
        };
        setFigura(fig);
        repaint();
    }
    
    //-----------------------------------------------------------------------------------------
    //------------------------------------- Teclado --------------------------------------------
    class Listener implements KeyListener{
        Ventana ventana;

        
        public Listener(Ventana ventana){
        this.ventana = ventana;
        }
        @Override
        public void keyTyped(KeyEvent e) {
          }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode()== KeyEvent.VK_UP) {
                ventana.escalar(1.5, 1.5);
                repaint();
            } else if(ke.getKeyCode()== KeyEvent.VK_T) {
            ventana.traslacion(50, 50);
                repaint();
            } else if(ke.getKeyCode()== KeyEvent.VK_DOWN) {
                ventana.escalar(0.75, 0.75);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_E){
                ventana.Rotacion(15);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_Q){
                ventana.rotacionneg(15);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_X){
                ventana.reflexionx();
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_Y){
                ventana.reflexiony();
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_B){
                ventana.reflexionxy();
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_Z){
                ventana.redibujar();
                repaint();  
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            }
    }
}