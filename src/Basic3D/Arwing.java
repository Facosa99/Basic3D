package Basic3D;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arwing extends Thread
{
    static Objeto3D Cuete;
    static int Fase = 1;
    
    public void Inicializar()
    {
        Cuete = new Objeto3D();
        Cuete.setRes(1200, 700);
        Cuete.setCentroGravedad(150, 60, 25); //Eje de rotación
        
        //--------------------------------------------------------------FUSELAJE
        int pFA[]  =   { 150,  10,   20 };   //Nariz
        int pFB[]  =   { 140,  100,  30 };   //Esquina Cabina derecha
        int pFC[]  =   { 160,  100,  30 };   //Esquina Cabina izquierda
        int pFD[]  =   { 150,  100,  15 };   //Base de fuselaje
        int pFE[]  =   { 150,  150,  30 };   //Cola
        int pFF[]  =   { 150,  110,  35 };   //Cupula Fuselaje
        
        Cuete.addCara(pFA, pFB, pFC, Color.white); //Panel Superior
        Cuete.addCara(pFA, pFB, pFD, Color.white); //Panel Frontal Inferior derecha
        Cuete.addCara(pFA, pFC, pFD, Color.white); //Panel Frontal Inferior izquierda
        Cuete.addCara(pFB, pFC, pFF, Color.cyan);  //Windshield
        Cuete.addCara(pFB, pFE, pFF, Color.cyan);  //Cristal Derecho
        Cuete.addCara(pFC, pFE, pFF, Color.cyan);  //Cristal Izquierdo
        Cuete.addCara(pFB, pFD, pFE, Color.white);  //Panel Trasero Derecho
        Cuete.addCara(pFC, pFD, pFE, Color.white);  //Panel Trasero Izquierdo
        
        //---------------------------------------------------------MOTOR DERECHO
        int pMDA[]  =   { 170,  40,   30 };   //Nariz
        int pMDB[]  =   { 180,  100,  30 };   //Izquierda
        int pMDC[]  =   { 160,  100,  30 };   //Derecha
        int pMDD[]  =   { 170,  100,  35 };   //Centro Superior
        int pMDE[]  =   { 170,  100,  20 };   //Centro Inferior
        int pMDF[]  =   { 170,  120,  35 };   //Cola
        
        Cuete.addCara(pMDA, pMDD, pMDB, Color.blue); //Panel Frontal Superior Izquierdo
        Cuete.addCara(pMDA, pMDD, pMDC, Color.blue); //Panel Frontal Superior Derecho
        Cuete.addCara(pMDA, pMDE, pMDB, Color.blue); //Panel Frontal Inferior Izquierdo
        Cuete.addCara(pMDA, pMDE, pMDC, Color.blue); //Panel Frontal Inferior Derecho        
        Cuete.addCara(pMDB, pMDD, pMDF, Color.blue); //Panel Trasero Superior Izquierdo
        Cuete.addCara(pMDC, pMDD, pMDF, Color.blue); //Panel Trasero Superior Derecho
        Cuete.addCara(pMDB, pMDE, pMDF, Color.blue); //Panel Trasero Inferior Izquierdo
        Cuete.addCara(pMDC, pMDE, pMDF, Color.blue); //Panel Trasero Inferior Derecho
        
        //-------------------------------------------------------MOTOR IZQUIERDO
        int pMIA[]  =   { 130,  40,   30 };   //Nariz
        int pMIB[]  =   { 140,  100,  30 };   //Izquierda
        int pMIC[]  =   { 120,  100,  30 };   //Derecha
        int pMID[]  =   { 130,  100,  35 };   //Centro Superior
        int pMIE[]  =   { 130,  100,  20 };   //Centro Inferior
        int pMIF[]  =   { 130,  120,  35 };   //Cola
        
        Cuete.addCara(pMIA, pMID, pMIB, Color.blue); //Panel Frontal Superior Izquierdo
        Cuete.addCara(pMIA, pMID, pMIC, Color.blue); //Panel Frontal Superior Derecho
        Cuete.addCara(pMIA, pMIE, pMIB, Color.blue); //Panel Frontal Inferior Izquierdo
        Cuete.addCara(pMIA, pMIE, pMIC, Color.blue); //Panel Frontal Inferior Derecho        
        Cuete.addCara(pMIB, pMID, pMIF, Color.blue); //Panel Trasero Superior Izquierdo
        Cuete.addCara(pMIC, pMID, pMIF, Color.blue); //Panel Trasero Superior Derecho
        Cuete.addCara(pMIB, pMIE, pMIF, Color.blue); //Panel Trasero Inferior Izquierdo
        Cuete.addCara(pMIC, pMIE, pMIF, Color.blue); //Panel Trasero Inferior Derecho
        
        //---------------------------------------------------------ALA IZQUIERDA
        int pADA[]  =   { 290,  140,   20 };   //Punta
        int pADB[]  =   { 200,  70,    30 };   //Punta Frontal
        int pADC[]  =   { 200,  120,   30 };   //Trasero Superior
        int pADD[]  =   { 200,  120,   20 };   //Trasero Inferior
        int pADE[]  =   { 180,  100,   30 };   //Raiz
        
        Cuete.addCara(pADB, pADC, pADE, Color.white); //Panel Superior Raiz 
        Cuete.addCara(pADA, pADB, pADC, Color.white); //Panel Superior Externo  
        Cuete.addCara(pADB, pADE, pADD, Color.white); //Panel Inferior Raiz 
        Cuete.addCara(pADA, pADB, pADD, Color.white); //Panel Inferior Externo         
        Cuete.addCara(pADC, pADD, pADE, Color.white); //Panel Trasero Raiz  
        Cuete.addCara(pADA, pADC, pADD, Color.white); //Panel Trasero Externo
        //-----------------------------------------------------------ALA DERECHA
        int pAIA[]  =   { 10,  140,   20 };   //Punta
        int pAIB[]  =   { 100,  70,    30 };   //Punta Frontal
        int pAIC[]  =   { 100,  120,   30 };   //Trasero Superior
        int pAID[]  =   { 100,  120,   20 };   //Trasero Inferior
        int pAIE[]  =   { 120,  100,   30 };   //Raiz
        
        Cuete.addCara(pAIB, pAIC, pAIE, Color.white); //Panel Superior Raiz 
        Cuete.addCara(pAIA, pAIB, pAIC, Color.white); //Panel Superior Externo  
        Cuete.addCara(pAIB, pAIE, pAID, Color.white); //Panel Inferior Raiz 
        Cuete.addCara(pAIA, pAIB, pAID, Color.white); //Panel Inferior Externo         
        Cuete.addCara(pAIC, pAID, pAIE, Color.white); //Panel Trasero Raiz  
        Cuete.addCara(pAIA, pAIC, pAID, Color.white); //Panel Trasero Externo
               
        Cuete.Traslacion( 0,0,0);
        Cuete.Rotacion(0,90,90);
        Cuete.Escalacion(5,5,5); 
        
    }
    public void Dibujar (BufferedImage Buffer)
    {
        Cuete.drawCuerpo(Buffer);
    }
    @Override
    public void run()
    {          
        do
        {
            if ( Fase <= 115)
            {
                Cuete.Escalacion( 0.98,0.98,0.98);
                Cuete.Traslacion( 0, -19, 0);
                Cuete.Rotacion(   0,  20, 0);
                
            }
            else if ( Fase == 116)
            {
                Basic3D.Escena = 2;
                Cuete.Traslacion(1000, 2000, 0);
                Cuete.Escalacion(2,2,2);
                Cuete.Rotacion(0, 30, 0);
                Cuete.setCentroGravedad(1000, 500, 74);
            }
            else
            {
                Cuete.Rotacion(0, 0, -1);
            }
            System.out.println(Fase);
            Fase++;
            
            

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Arwing.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        while (true);
    }    
}