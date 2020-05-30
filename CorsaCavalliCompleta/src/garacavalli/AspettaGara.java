/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *classe che si genera dopo il click su uno dei pulsanti
 * serve per dire all'utente di aspettare che inizi la gara
 * @author Fossi Mirco
 */
public class AspettaGara extends JFrame
{
    JLabel aspetta;
    /**
     * costruttore della classe
     * @param x valore dei cavalli della gara
     */
    public AspettaGara(int x)
    {
        super("Aspetta la gara");
        setSize(250, 100);
        setLocation(450,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pannello = new JPanel();
        aspetta = new JLabel("Aspetta la gara. Hai scelto " + x +" cavalli");  //scritta che vede l'utente
        pannello.add(aspetta);
        setContentPane(pannello);
        show();
    }
}
