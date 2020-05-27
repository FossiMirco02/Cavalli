/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Famiglia
 */
public class Cavallo extends JPanel
{
    int cordinateX;
    int cordinateY;
    Image img;
    public Cavallo( int y, int x) throws InterruptedException
    {
        cordinateX = 0;
        cordinateY = y;
        setSize(60,61);
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker mt = new MediaTracker(this);     //gestire un numero
        switch(x)
        {
            //tutti i cavalli sono diversi
            //posiziono ogni cavallo nella sua posizione
            case 1: {img = tk.getImage("./cavalloBianco.jpg");break;}
            case 2: {img = tk.getImage("./cavalloMarrone.jpg");break;}
            case 3: {img = tk.getImage("./cavalloNero.jpg");break;}
            case 4: {img = tk.getImage("./cavalloCorsa1.jpg");break;}
            case 5: {img = tk.getImage("./cavalloCorsa2.jpg");break;}
            case 6: {img = tk.getImage("./cavalloCorsa3.jpg");break;}
            case 7: {img = tk.getImage("./cavalloCorsa4.jpg");break;}
            case 8: {img = tk.getImage("./cavalloElegante.jpg");break;}
            
        }
        ThreadDormi.sleep(1, "sec");
        mt.addImage(img, 0);                          //per le immagini messe in parallelo
        try
        {
            mt.waitForID(0);
        }
        catch(InterruptedException e){}
    }
    //metodi per la cordinata x
    public void setCordX(int n)
    {
        cordinateX = n;
    }
    public int getCordx()
    {
        return cordinateX;
    }
    public void paint(Graphics g)
    {
        g.drawImage(img, cordinateX, cordinateY, null);
    }
}
