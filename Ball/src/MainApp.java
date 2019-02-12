import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainApp extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static JFrame window = new JFrame("Pong");
	
    static long lastLoopTime=System.nanoTime();
    static long lastFpsTime=0;
    static final int TARGET_FPS = 60;
    static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    static long updateLength = 0;
    
    static boolean toggle = false;
    static Ball blueBall = new Ball(0,0,25,25,Color.black,window);
    static Paddle testPaddle = new Paddle(200,200);
    public static void main(String[] args) {
    	
    	window.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					System.out.println("Hello ");
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("World");
					break;
					/*
				case KeyEvent.VK_LEFT:
					game.move(-1);
					break;
				case KeyEvent.VK_RIGHT:
					game.move(+1);
					break;
				case KeyEvent.VK_SPACE:
					game.dropDown();
					game.score += 1;
					break;*/
				} 
			}
			
			public void keyReleased(KeyEvent e) {
			}
		});
    	
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
}