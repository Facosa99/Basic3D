package Basic3D;

public class Update extends Thread
{
        @Override
    public void run()
    {
        try {
            do
            {                
                Basic3D.update();
                Thread.sleep(1);
            }
        while(true);
        } catch (InterruptedException ex) {            
        }
    } 
}