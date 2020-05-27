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
public class GaraCavallo extends JFrame
{
    int posizione;
    Cavallo[] partecipanti;
    CavalloDuranteGara[] thread_partecipanti;
    Pista CampoDiGara;
    Graphics offscreen;            //gestione doppio buffering
    Image buffer_virtuale;
    public GaraCavallo()
    {
        //posiziono e disegno il tracciato del cavallo
        super("Gara Cavallo");
        setSize(1000,680);
        setLocation(10,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CampoDiGara = new Pista();
        partecipanti = new Cavallo[8];
        thread_partecipanti = new CavalloDuranteGara[8];
        posizione = 1;
        //aggiungo le immagini dei cavalli, e associo le immagini ai thread
        int partenza = 15;                   //posizione della prima corsia
        for(int i = 0; i < 8; i++)
        {
            partecipanti[i] = new Cavallo(partenza, i+1);
            thread_partecipanti[i] = new CavalloDuranteGara(partecipanti[i], this);
            partenza = partenza + 80;         //creare la posizione del prossimo concorrente in verticale
        }
        //visualizzare la gara
        this.add(CampoDiGara);
        setVisible(true);
    }
    //assegnare la posizione al cavallo che ha tagliato il traguardo
    public synchronized int getPosizione()
    {
        return posizione++;
    }
    //controllo che tutti i cavalli siano arrivati al traguardo
    public synchronized void controlloArrivi()
    {
        boolean arrivati=true;
        for(int i=0; i< 8; i++)
        {
            if(thread_partecipanti[i].posizione==0)
            {
                arrivati = false;
            }     
        }
        if(arrivati)
        {
            visualizzaClassifica();
        }
    }
    //visualizzare la classifica dei cavalli quando sono arrivati
    public void visualizzaClassifica()
    {
        //creare la tabella per la classifica
        JLabel[] arrivi = new JLabel[8];
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(500,500);
        classifica.setLocation(280,180);
        classifica.setBackground(Color.red);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(8,1));
        //visualizzare la classifica
        for(int i=0; i<9;i++)
        {
            for(int j=0; j<8; j++)
            {
                if(thread_partecipanti[j].posizione==i)
                {
                    arrivi[j]=new JLabel(i + " classificato cavallo in " + (j+1) + " corsia");
                    arrivi[j].setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
                    arrivi[j].setForeground(Color.red);
                    classifica.getContentPane().add(arrivi[j]);
                }
            }
        }
        classifica.setVisible(true);
    }
    //metodi per il disegno sullo schermo
    public void update(Graphics g)
    {
        paint(g);
    }
    public void paint(Graphics g)
    {
        if(partecipanti != null)
        {
            Graphics2D screen = (Graphics2D)g;
            buffer_virtuale = createImage(1000,645);
            offscreen = buffer_virtuale.getGraphics();
            Dimension d = getSize();
            CampoDiGara.paint(offscreen);
            for(int i=0; i<8; i++)
            {
                partecipanti[i].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 20, this);
            offscreen.dispose();
        }
    }
    //main per la creazione della gara
    public static void main(String[] args) 
    {
        GaraCavallo c = new GaraCavallo();
    }  
}
