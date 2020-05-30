/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

/**
 * classe per decidere quando tempo deve dormire un thread
 * @author Fossi Mirco
 */
public class ThreadDormi {
    /**
     * permette di mettere un thread in sleep, passandogli il tempo e il tipo
     * @param time numero che indica il tempo che il thread deve dormire
     * @param type unità di misura, secondi o millisecondi
     * @throws InterruptedException se sleep viene interrotto
     */
    public static void sleep (int time, String type) throws InterruptedException
	{
	    switch (type)
	    {
               	case "microsec":
		    Thread.sleep(time);
		    break;
	        case "sec":
		    Thread.sleep((1000*time));
	       	    break;
		default:
		    Thread.sleep(time);
		    break;
	    }
        }
	
}
