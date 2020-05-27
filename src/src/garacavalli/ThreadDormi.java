/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

/**
 *
 * @author Famiglia
 */
public class ThreadDormi {
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
