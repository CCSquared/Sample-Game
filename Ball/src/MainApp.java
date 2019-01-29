import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainApp extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	static JFrame window = new JFrame();
   
    
    static long lastLoopTime=System.nanoTime();
    static long lastFpsTime=0;
    static final int TARGET_FPS = 60;
    static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    static long updateLength = 0;
    
    static boolean toggle = false;
    static Ball blueBall = new Ball(0,0,25,25,Color.black,window);
    public static void main(String[] args) {

    	//initialization here
        blueBall.setBallFillColor(Color.black);
        blueBall.drawBall(window);
        createWindow();
       	SwingUtilities.updateComponentTreeUI(window);
       	Keys key = new Keys();
       	//This is not the main loop!
        while(true){
        	long now = System.nanoTime();
        	long updateLength = now-lastLoopTime;
        	lastLoopTime=now;
        	lastFpsTime+=updateLength;
        	double delta = updateLength/((double)OPTIMAL_TIME);
            process(delta);
        	try{
            	Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }catch(Exception e){
            }
        }
    }
    //This is the main loop, delta is the time in msec between each call
    //Multiply each frame sensitive action by it
    private static void process(double delta){ 
		if(blueBall.getBallX()>375 && toggle == false)
			toggle = true;
		else if(blueBall.getBallX()<0 && toggle == true)
			toggle = false;
        if(toggle == false){
        	blueBall.setBallX((blueBall.getBallX()+(1*delta)));
        	blueBall.setBallY((blueBall.getBallY()+(1*delta)));
        	window.repaint();
        }
        if(toggle == true){
        	blueBall.setBallX((blueBall.getBallX()-(1*delta)));
        	blueBall.setBallY((blueBall.getBallY()-(1*delta)));
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
	@Override
	public void keyPressed(KeyEvent e) {
		Keys.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		Keys.keyReleased(e);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		Keys.keyTyped(e);
	}
}