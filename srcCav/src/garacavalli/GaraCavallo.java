/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * è la classe principale del programma, che contiene tutte 
 * le altre classi, e si occupa di organizzarle in modo da
 * mostrarle tutte
 * @author Fossi Mirco
 */
public class GaraCavallo extends JFrame
{
    int posizione;
    Cavallo[] partecipanti;      //creare un array per i cavalli
    CavalloDuranteGara[] thread_partecipanti;      //array per la corsa dei cavalli
    Pista CampoDiGara;             //creare il campo della gara
    Graphics offscreen;            //gestione doppio buffering
    Image buffer_virtuale;
    int totcavalli = 0;
    public GaraCavallo(int x) throws InterruptedException
    {
        //posiziono e disegno il tracciato del cavallo
        super("Gara Cavallo");
        totcavalli = x;
        setSize(1000,840);
        setLocation(10,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CampoDiGara = new Pista();
        partecipanti = new Cavallo[totcavalli];
        thread_partecipanti = new CavalloDuranteGara[totcavalli];
        posizione = 1;
        //aggiungo le immagini dei cavalli, e associo le immagini ai thread
        int partenza = 10;                   //posizione della prima corsia
        for(int i = 0; i < totcavalli; i++)
        {
            partecipanti[i] = new Cavallo(partenza, i+1);
            thread_partecipanti[i] = new CavalloDuranteGara(partecipanti[i], this);
            partenza = partenza + 80;         //creare la posizione del prossimo concorrente in verticale
        }
        //visualizzare la gara
        this.add(CampoDiGara);
        setVisible(true);
    }
    /**
     * assegnare la posizione finale al cavallo che arriva al traguardo
     * @return la posizione del cavallo arrivato
     */
    public synchronized int getPosizione()
    {
        return posizione++;
    }
    /**
     * controllare che tutti i cavalli abbiano tagliato il traguardo
     * così da generare la classifica finale
     */
    public synchronized void controlloArrivi()
    {
        boolean arrivati=true;
        for(int i=0; i< totcavalli; i++)
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
    /**
     * metodo che fa visualizzare la classifica finale quando il metodo controlloArrivi
     * richiama questo metodo
     */
    public void visualizzaClassifica()
    {
        //creare la tabella per la classifica
        JLabel[] arrivi = new JLabel[8];
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(600,600);
        classifica.setLocation(280,180);
        classifica.setBackground(Color.red);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(8,1));
        //visualizzare la classifica
        for(int i=0; i<totcavalli+1;i++)
        {
            for(int j=0; j<totcavalli; j++)
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
    /**
     * metodo per il disegno sullo schermo
     * @param g grafica che passiamo al paint
     */
    public void update(Graphics g)
    {
        paint(g);
    }
    /**
     * disegnare sullo schermo tutte le immagini relative 
     * alla gara dei cavalli
     * @param g grafica che passiamo per la rappresentazione sullo
     * schermo
     */
    public void paint(Graphics g)
    {
        if(partecipanti != null)
        {
            Graphics2D screen = (Graphics2D)g;
            buffer_virtuale = createImage(1000,840);
            offscreen = buffer_virtuale.getGraphics();
            Dimension d = getSize();
            CampoDiGara.paint(offscreen);
            for(int i=0; i<totcavalli; i++)
            {
                partecipanti[i].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 20, this);
            offscreen.dispose();
        }
    }
    /**
     * main per la creazione dei tutto il programma
     * @param args
     * @throws InterruptedException per il controllo degli errori
     */
    public static void main(String[] args) throws InterruptedException 
    {
        int ncavalli = 0;
        do{
            System.out.println(" Inserisci quanti cavalli devono correre da 2 a 10 ");
            Scanner input = new Scanner(System.in);
            ncavalli = input.nextInt();
            if(ncavalli<2 || ncavalli>10)
            {
                System.out.println(" Hai inserito un valore inferiore a 2 o maggiore di 10");
            }
        }while(ncavalli<2 || ncavalli>10);
        System.out.println(" Hai inserito " + ncavalli + " cavalli");
        Scanner input = new Scanner(System.in);
        GaraCavallo c = new GaraCavallo(ncavalli);
    }  
}
