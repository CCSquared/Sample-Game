import java.awt.Color;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
 
public class MainApp extends JFrame{
     
    static JFrame window = new JFrame();
     
    public static void main(String[] args) {
         
        createWindow();
         
        Ball blueBall = new Ball(0,0,25,25,Color.black,window);
        blueBall.setBallFillColor(Color.black);
        blueBall.drawBall(window);
        
       	SwingUtilities.updateComponentTreeUI(window);
        double x = 0;
        double y = 0;
        //delta is milliseconds between each loop
        int nanoDelta = 0;
        long prevNano = 0;
        double delta = 0;
        boolean toggle = false;
        while(true){
        	nanoDelta += System.nanoTime()-prevNano;
        	if (nanoDelta>16666667) { //restricts loop to only loop every 1/60 of a second
        		delta = nanoDelta/1000000.0;
        		System.out.println(delta);
        		prevNano = System.nanoTime();
        		nanoDelta = 0;
        		if(x>375 && toggle == false)
        			toggle = true;
        		else if(x<0 && toggle == true)
        			toggle = false;
		        if(toggle == false){
		        	x+=0.01;
		        	y+=0.01;
		        	blueBall.setBallX((int)x);
		        	blueBall.setBallY((int)y);
		        	window.repaint();
	
		        }
		        if(toggle == true){
		        	x-=0.01;
		        	y-=0.01;
		        	blueBall.setBallX((int)x);
		        	blueBall.setBallY((int)y);
		        	window.repaint();
		        }
        	}
	        
        }
    }
    public static void createWindow()
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(406,428);
        window.setResizable(false);
        window.setVisible(true);
        //System.out.println(window.getContentPane().getSize());
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }
}
