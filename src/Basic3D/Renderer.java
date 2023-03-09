package Basic3D;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Renderer 
{   
    int ResX;       int ResY;
    int CentroGravedadX, CentroGravedadY, CentroGravedadZ;    
    //Ajustes de Camara
    int CamCentroX = 450, CamCentroY = 350, CamCentroZ = -500, CamPlanoX = 450, CamPlanoY = 350, CamPlanoZ = 500, CamResX = 1200, CamResY = 700;
    Cara    caras[]    = new Cara[1000] ;    int NumCaras    = 0;
    public  void AjustarCamara( int CentroX, int CentroY, int CentroZ, int PlanoX, int PlanoY, int PlanoZ, int ResolucionX, int ResolucionY)
    {
        CamCentroX = CentroX;    CamCentroY = CentroY;    CamCentroZ = CentroZ;
        CamPlanoX  = PlanoX;     CamPlanoY  = PlanoY;     CamPlanoZ  = PlanoZ;
        ResX       = ResolucionX;ResY = ResolucionY;
    }
    public  void drawCuerpo(BufferedImage buffer)
    {
        bubbleSort();        
        for ( int i = 0 ; i<NumCaras ; i++)
        {
            drawCara ( buffer, caras[i]);
        }
    }
    private void drawCara( BufferedImage buffer,Cara cara)
    {
        int CoorX1, CoorY1, CoorX2, CoorY2, CoorX3, CoorY3;
                
        CoorX1 = CalcularX( cara.CoordenadaX1, cara.CoordenadaY1, cara.CoordenadaZ1);
        CoorY1 = CalcularY( cara.CoordenadaX1, cara.CoordenadaY1, cara.CoordenadaZ1);
        
        CoorX2 = CalcularX( cara.CoordenadaX2, cara.CoordenadaY2, cara.CoordenadaZ2);
        CoorY2 = CalcularY( cara.CoordenadaX2, cara.CoordenadaY2, cara.CoordenadaZ2);
        
        CoorX3 = CalcularX( cara.CoordenadaX3, cara.CoordenadaY3, cara.CoordenadaZ3);
        CoorY3 = CalcularY( cara.CoordenadaX3, cara.CoordenadaY3, cara.CoordenadaZ3);

        ScanLine(buffer, CoorX1, CoorY1, CoorX2, CoorY2, CoorX3, CoorY3, cara.Color );
        ScanLine(buffer, CoorX2, CoorY2, CoorX3, CoorY3, CoorX1, CoorY1, cara.Color );

        Line(buffer, CoorX1, CoorY1, CoorX2, CoorY2, Color.black );  
        Line(buffer, CoorX3, CoorY3, CoorX2, CoorY2, Color.black );  
        Line(buffer, CoorX1, CoorY1, CoorX3, CoorY3, Color.black );  
         
    }
    private void ActualizarCentroZ ( Cara cara)
    {
        cara.CentroZ = (     ( cara.CoordenadaZ1 + cara.CoordenadaZ2 + cara.CoordenadaZ3 )     / 3  );
    }
    public  void setRes(int X, int Y)
    {        
        ResX = X;
        ResY = Y;
    }
    private int CalcularX( double X, double Y, double Z)
    {
        double Dx = X - CamCentroX;
        double Dz = Z - CamCentroZ;
        double Bx = ( (CamPlanoZ / Dz ) * Dx ) + CamPlanoX;
        return      (int) Bx;    
    }
    private int CalcularY( double X, double Y, double Z)
    {     
        double Dy = Y - CamCentroY;
        double Dz = Z - CamCentroZ;        
        double By = ( (CamPlanoZ / Dz ) * Dy ) + CamPlanoY;
        return      (int) By;
    }
    private void Line(BufferedImage buffer, int x1, int y1, int x2, int y2, Color cc)
    {
        int dx=Math.abs(x2 - x1);
        int dy=Math.abs(y2 - y1);

        int sx=(x1<x2) ? 1 : -1;
        int sy=(y1<y2) ? 1 : -1;

        int p0=dx-dy;

        while(true){            
            if ( x1 > 0 && y1 > 0 && x1 < ResX && y1 < ResY) //IF para evitar pintar fuera de coordenadas
            {
                buffer.setRGB(x1, y1, cc.getRGB());
            }            
            if (x1==x2 && y1==y2){
                break;
            }
            int e2 = 2*p0;
            if (e2>-dy){
                p0 =p0-dy;
                x1 =x1+sx;
            }
            if (e2<dx) {
                p0 = p0+dx;
                y1 = y1+sy;
            }
            
            
        }
    }
    private void ScanLine(BufferedImage buffer, int x1, int y1, int x2, int y2, int x3, int y3, Color cc)
    {
        int XA = x1,    YA = y1,        XB = x2,    YB = y2;        
        int XD = x3,    YD = y3;        
        int dx1 =    Math.abs(XB - XA);
        int dy1 =    Math.abs(YB - YA);
        int sx1=(XA<XB) ? 1 : -1;
        int sy1=(YA<YB) ? 1 : -1;
        int p1=dx1-dy1;

        while(true){ 
            
            Line(buffer,  XA,  YA,  XD,  YD,cc);            
            if (XA==XB && YA==YB )
            {          
               break;
            }
            int e1 = 2*p1;
            if (e1>-dy1){
                p1 =p1-dy1;
                XA =XA+sx1;
            }
            if (e1<dx1) {
                p1 = p1+dx1;
                YA = YA+sy1;
            } 
        }
    }
    private void bubbleSort()
    {
        int n = NumCaras;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (caras[j].CentroZ < caras[j+1].CentroZ)
                {
                    Cara temp = caras[j];
                    caras[j] = caras[j+1];
                    caras[j+1] = temp;
                }
    }
    public void addObject(Objeto3D Object)
    {
        caras = Object.caras;
    }   
    
}