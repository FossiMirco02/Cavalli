/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.event.*;
import javax.swing.*;
/**
 *classe che serve per la scelta di quanti cavalli devono esserci nella gara
 * @author Fossi Mirco
 */
public class PreparazioneGara extends JFrame implements ActionListener
{
    JButton cavalli2 = new JButton("2 Cavalli"); // Creazione dei pulsanti per il tot cavalli della gara
    
    JButton cavalli3 = new JButton("3 Cavalli");
    JButton cavalli4 = new JButton("4 Cavalli");
    JButton cavalli5 = new JButton("5 Cavalli");
    JButton cavalli6 = new JButton("6 Cavalli");
    JButton cavalli7 = new JButton("7 Cavalli");
    JButton cavalli8 = new JButton("8 Cavalli");
    JButton cavalli9 = new JButton("9 Cavalli");
    JButton cavalli10 = new JButton("10 Cavalli");
    int cavalli = 0;
    /**
     * costruttore della classe PreparazioneGara nel quale sono presenti bottoni
     * che contengono il valore dei cavalli che vuoi far correre, da 2 a 10
     */
    public PreparazioneGara() 
    {
        super("Prova pulsanti");
        setSize(300, 200);
        setLocation(450,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cavalli2.addActionListener(this);    //aggiungere l'ascolto del click sul pulsante
        cavalli3.addActionListener(this);
        cavalli4.addActionListener(this);
        cavalli5.addActionListener(this);
        cavalli6.addActionListener(this);
        cavalli7.addActionListener(this);
        cavalli8.addActionListener(this);
        cavalli9.addActionListener(this);
        cavalli10.addActionListener(this);
        JPanel pannello = new JPanel(); // Creazione del pannello che conterrà i pulsanti
        pannello.add(cavalli2); // Aggiunta dei pulsanti al pannello
        pannello.add(cavalli3);
        pannello.add(cavalli4);
        pannello.add(cavalli5);
        pannello.add(cavalli6);
        pannello.add(cavalli7);
        pannello.add(cavalli8);
        pannello.add(cavalli9);
        pannello.add(cavalli10);
        setContentPane(pannello); // Trasforma il pannello nel contenuto del frame
        
        show(); // Visualizza l'intero frame
    }

    @Override
    /**
     * metodo che percepisce il click sui diversi bottoni
     * con il click richiama la classe AspettaGara e asspegna il numero di cavalli che corrono
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == cavalli2)
        {
            cavalli = 2;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli3)
        {
            cavalli = 3;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli4)
        {
            cavalli = 4;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli5)
        {
            cavalli = 5;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli6)
        {
            cavalli = 6;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli7)
        {
            cavalli = 7;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli8)
        {
            cavalli = 8;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli9)
        {
            cavalli = 9;
            AspettaGara a = new AspettaGara(cavalli);
        }
        if(src == cavalli10)
        {
            cavalli = 10;
            AspettaGara a = new AspettaGara(cavalli);
        }
    }
    /**
     * metodo che visualizza quanti cavalli hai inserito premendo su uno dei bottoni
     * @return cavalli, numero di cavalli che hai inserito
     */
    public int getCavalli()
    {
        return cavalli;
    }
}
