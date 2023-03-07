package Basic3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Basic3D extends JFrame 
{
    static Arwing Cuete = new Arwing();
    static Update Actualizar = new Update();
    static int Escena = 1;
    static  BufferedImage Buffer;  
            BufferedImage LimpiarBuffer; 
            BufferedImage Fondo; 
    
    int ResX = 1200, ResY = 700;
    int Humo = 0;
    
    static Basic3D Main = new Basic3D(); 
    public Basic3D()
    {
        setTitle("Parcial 3: Animación");
        this.setSize(ResX, ResY);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Buffer          = new BufferedImage(ResX,ResY,BufferedImage.TYPE_INT_RGB);
        LimpiarBuffer   = new BufferedImage(ResX,ResY,BufferedImage.TYPE_INT_RGB);        
        Arwing Cuete    = new Arwing();
        Cuete.Inicializar();
        
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Actualizar.start();
        Cuete.start();
    }     

    @Override
    public void paint(Graphics g)   //Print Graphics on Screen
    {     
        Buffer.setData(LimpiarBuffer.getData());
        Buffer.getGraphics().drawImage(Fondo, 1, 30, ResX, ResY, this);
        Cuete.Dibujar(Buffer);   
        this.getGraphics().drawImage(Buffer, 0, 0, this);        
    } 
    public static void update()
    {              
        Main.repaint();
    }
    
    public void Renderer()
    {
        
    }

}