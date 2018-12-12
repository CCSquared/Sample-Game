import java.awt.Color;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
 
public class MainApp extends JFrame{
     

	private static final long serialVersionUID = 1L;
	static JFrame window = new JFrame();
    static Ball blueBall = new Ball(0,0,25,25,Color.black,window);
    static int nanoDeltaFixed = 0;
    static long prevNanoFixed = 0;
    static double deltaFixed = 0;
    static int nanoDelta = 0;
    static long prevNano = 0;
    static double delta = 0;
    static boolean toggle = false;
    public static void main(String[] args) {
        blueBall.setBallFillColor(Color.black);
        blueBall.drawBall(window);
        createWindow();
         
       	SwingUtilities.updateComponentTreeUI(window);

        while(true){
        	nanoDeltaFixed += System.nanoTime()-prevNanoFixed;
        	if (nanoDeltaFixed>16666667) {
        		deltaFixed = nanoDeltaFixed/1000000.0;
        		prevNanoFixed = System.nanoTime();
        		fixedProcess(deltaFixed);
        		nanoDeltaFixed = 0;
        	}
        }
    }
    /*
    private static void process(double delta){ //Not working yet
    	
    }*/
    private static void fixedProcess(double delta){ //will be called every 1/60 of a second, delta is time in sec from last call
		if(blueBall.getBallX()>375 && toggle == false)
			toggle = true;
		else if(blueBall.getBallX()<0 && toggle == true)
			toggle = false;
        if(toggle == false){
        	blueBall.setBallX((blueBall.getBallX()+0.01));
        	blueBall.setBallY((blueBall.getBallY()+0.01));
        	window.repaint();

        }
        if(toggle == true){
        	blueBall.setBallX((blueBall.getBallX()-0.01));
        	blueBall.setBallY((blueBall.getBallY()-0.01));
        	window.repaint();
        }
    }
    
    public static void createWindow()
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(406,428);
        window.setResizable(false);
        window.setVisible(true);
    }
}