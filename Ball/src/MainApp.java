import java.awt.Color;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
 
public class MainApp extends JFrame{
     
	private static final long serialVersionUID = 1L;
	static JFrame window = new JFrame();
    static Ball blueBall = new Ball(0,0,25,25,Color.black,window);
    static long lastLoopTime=System.nanoTime();
    static long lastFpsTime=0;
    static final int TARGET_FPS =5;
    static final long OPTIMAL_TIME=1000000000 / TARGET_FPS;
    static long updateLength = 0;
    static int nanoDeltaFixed = 0;
    static long prevNanoFixed = 0;
    static double deltaFixed = 0;
    static double prevNanoFixedWhile = 0;
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
        	long now = System.nanoTime();
        	long updateLength = now-lastLoopTime;
        	lastLoopTime=now;
        	double delta = updateLength/((double)OPTIMAL_TIME);
        	
        	lastFpsTime+=updateLength;
        	if(lastFpsTime >= 1000000000) {
        		lastFpsTime=0;
        	}
        	
        	
            try{
                long gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                System.out.println(gameTime);
                Thread.sleep(gameTime);
                fixedProcess(gameTime);
            }catch(Exception e){
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
        	blueBall.setBallX((blueBall.getBallX()+(0.1*delta)));
        	blueBall.setBallY((blueBall.getBallY()+(0.1*delta)));
        	window.repaint();

        }
        if(toggle == true){
        	blueBall.setBallX((blueBall.getBallX()-(0.1*delta)));
        	blueBall.setBallY((blueBall.getBallY()-(0.1*delta)));
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