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
        while(true){
	        while(x<375){
	        	x+=0.00001;
	        	y+=0.00001;
	        	blueBall.setBallX((int)x);
	        	blueBall.setBallY((int)y);
	        	window.repaint();

	        }
	        while(x>0){
	        	x-=0.00001;
	        	y-=0.00001;
	        	blueBall.setBallX((int)x);
	        	blueBall.setBallY((int)y);
	        	window.repaint();
	        }
        }
    }
    public static void createWindow()
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(406,428);
        window.setResizable(false);
        window.setVisible(true);
        System.out.println(window.getContentPane().getSize());
    }
}
