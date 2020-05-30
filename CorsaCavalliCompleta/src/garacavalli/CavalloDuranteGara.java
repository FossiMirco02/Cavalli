/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

/**
 * classe che si occupa della corsa del cavallo, dalla partenza all'arrivo
 * @author Fossi Mirco
 */
public class CavalloDuranteGara implements Runnable
{
    Cavallo cavallo;
    GaraCavallo pista;
    int velocita;           //spostamento con un numero di pixel
    Thread t;
    int conta;              //ogni 10 spostamenti cambio la velocita, conta gli spostamenti fatti
    int posizione;          //coordinata x con valore in pixel
    /**
     * costruttore 
     * @param c cavallo per il  movimento
     * @param g campo della gara dei cavalli
     */
    public CavalloDuranteGara(Cavallo c, GaraCavallo g)
    {
        cavallo = c;           // per identificare un cavallo
        pista = g;             // campo della gara
        conta = 0;
        velocita = 2;
        t = new Thread(this);
        t.start();
        posizione = 0;
    }
    /**
     * metodo presente nella classe Runnable
     * serve per far partire le istanze della classe CavalloDuranteGara
     */
    public void run()
    {
        //muovere il cavallo durante il percorso , e cambiare la velocita
        int dimImmagine = 70;       //dimensione immagine del cavallo
        int dimPista = 960;
        while((cavallo.getCordx() + dimImmagine) < dimPista)     //finche corsa non è finita
        {
            if((conta % 10) == 0)                          // ogni volta che sono 10 spostamenti
            {
                velocita = (int)(Math.random()*4 + 1);     //modificare la velocita del cavallo
            }
            cavallo.setCordX(cavallo.getCordx() + velocita);
            conta ++;
            try
            {
                Thread.sleep(75);    //delay
            }
            catch(Exception e){}
            pista.repaint();
        }
        //per far vedere la posizione finale nella classifica
        posizione = pista.getPosizione();
        pista.controlloArrivi();
    }
}
