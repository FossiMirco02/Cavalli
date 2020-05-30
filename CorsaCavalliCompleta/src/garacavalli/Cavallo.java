/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * La classe cavallo comprende l'immagine del cavallo e si
 * occupa di posizionare l'immagine sul campo, passandogli
 * le cordinate x e y, che servono per il posizionamento
 * @author Mirco Fossi
 */
public class Cavallo extends JPanel
{
    int cordinateX;
    int cordinateY;
    BufferedImage img = null;
    public Cavallo( int y, int x) throws InterruptedException, IOException
    {
        cordinateX = 0;
        cordinateY = y;
        setSize(70,70);
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker mt = new MediaTracker(this);     //gestire un numero per la grafica
        switch(x)
        {
            //tutti i cavalli sono diversi
            //posiziono ogni cavallo nella sua posizione
            case 1: {img = ImageIO.read(getClass().getResource("Immagini/cavalloBianco.jpg"));break;}
            case 2: {img = ImageIO.read(getClass().getResource("Immagini/cavalloCorsa1.jpg"));break;}
            case 3: {img = ImageIO.read(getClass().getResource("Immagini/cavalloCorsa2.jpg"));break;}
            case 4: {img = ImageIO.read(getClass().getResource("Immagini/cavalloCorsa3.jpg"));break;}
            case 5: {img = ImageIO.read(getClass().getResource("Immagini/cavalloCorsa4.jpg"));break;}
            case 6: {img = ImageIO.read(getClass().getResource("Immagini/cavalloDentato.jfif"));break;}
            case 7: {img = ImageIO.read(getClass().getResource("Immagini/cavalloElegante.jpg"));break;}
            case 8: {img = ImageIO.read(getClass().getResource("Immagini/cavalloLinguaccia.jfif"));break;}
            case 9: {img = ImageIO.read(getClass().getResource("Immagini/cavalloMarrone.jpg"));break;}
            case 10: {img = ImageIO.read(getClass().getResource("Immagini/cavalloNero.jpg"));break;}
            /*case 2: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloCorsa1.jpg");break;}
            case 3: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloCorsa2.jpg");break;}
            case 4: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloCorsa3.jpg");break;}
            case 5: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloCorsa4.jpg");break;}
            case 6: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloElegante.jpg");break;}
            case 7: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloMarrone.jpg");break;}
            case 8: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloNero.jpg");break;}
            case 9: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloLinguaccia.jfif");break;}
            case 10: {img = tk.getImage("C:/Users/Famiglia/Desktop/GaraCavalli/src/garacavalli/Immagini/cavalloDentato.jfif");break;}*/
        }
        ThreadDormi.sleep(1, "sec");
        mt.addImage(img, 0);                          //per le immagini messe in parallelo
        try
        {
            mt.waitForID(0);
        }
        catch(InterruptedException e){}
    }
    /**
     * metodo per modificare la cordinata X
     * @param n valore con cui vogliamo sostituire X
     */
    public void setCordX(int n)
    {
        cordinateX = n;
    }
    /**
     * metodo per visualizzare la cordinata X
     * @return della cordinata X
     */
    public int getCordx()
    {
        return cordinateX;
    }
    /**
     * metodo che inserisce l'immagine nella
     * posizione corretta
     * @param g è la grafica da passargli in cui inserire
     * l'immagine e la sua posizione
     */
    public void paint(Graphics g)
    {
        g.drawImage(img, cordinateX, cordinateY, null);
    }
}
