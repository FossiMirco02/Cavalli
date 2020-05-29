/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import javax.swing.*;
/**
 * classe per la creazione del tracciato della gara di cavalli
 * @author Fossi Mirco
 */
public class Pista extends JPanel
{
    /**
     * crea le diverse corsie dei cavalli, separandole da linee bianche e 
     * disegnando il traguardo con linee bianche verticali
     * @param g 
     */
    public void paint(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(0, 0, 1000, 800);
        //Linee laterali
        g.setColor(Color.white);
        g.fillRect(0, 0, 1000, 10);
        g.fillRect(0, 80, 1000, 10);
        g.fillRect(0, 160, 1000, 10);
        g.fillRect(0, 240, 1000, 10);
        g.fillRect(0, 320, 1000, 10);
        g.fillRect(0, 400, 1000, 10);
        g.fillRect(0, 480, 1000, 10);
        g.fillRect(0, 560, 1000, 10);
        g.fillRect(0, 640, 1000, 10);
        g.fillRect(0, 720, 1000, 10);
        g.fillRect(0, 800, 1000, 10);
        //traguardo
        g.fillRect(960, 0, 5, 810);
        g.fillRect(970, 0, 5, 810);
        g.fillRect(980, 0, 5, 810);
    }
}
