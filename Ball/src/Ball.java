import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

 
public class Ball
{
 
    private Color ballFillColor;
    private Color ballBorderColor;
     
    private double ballX = 0;
    private double ballY = 0;
    private int ballWidth = 0;
    private int ballHeight = 0;
    public double[] velocity = { 3f, 3f };
     
    public boolean fillBall = true;
 
    Ball(){ //Constructor
        ballBorderColor = Color.black;
    }
 
    Ball(double ballX, double ballY, int ballWidth, int ballHeight, Color ballBorderColor, JLayeredPane lp){ //Constructor
        // X , Y , Width, Height, Border Colour, container
        this.setBallBorderColor(ballBorderColor);
        this.setBallWidth(ballWidth);
        this.setBallHeight(ballHeight);
        this.setBallX(ballX);
        this.setBallY(ballY);
        this.drawBall(lp);
    }
     
    public Color getBallFillColor() {
        return ballFillColor;
    }
    public void setBallFillColor(Color BallFillColor) {
        this.ballFillColor = BallFillColor;
    }
     
    public Color getBallBorderColor() {
        return ballBorderColor;
    }
    public void setBallBorderColor(Color BallBorderColor) {
        this.ballBorderColor = BallBorderColor;
    }
 
    public double getBallX() {
        return ballX;
    }
    public void setBallX(double ballX) {
        this.ballX = ballX;
    }
 
    public double getBallY() {
        return ballY;
    }
    public void setBallY(double ballY) {
        this.ballY = ballY;
    }
 
    public int getBallWidth() {
        return ballWidth;
    }
    public void setBallWidth(int ballWidth) {
        this.ballWidth = ballWidth;
    }
 
     
    public int getBallHeight() {
        return ballHeight;
    }
    public void setBallHeight(int ballHeight) {
        this.ballHeight = ballHeight;
    }
 
 
    public void drawBall(JLayeredPane lp) 
    {
        lp.add(new MyComponent(),0);
    }
    
    //Move the ball.
    public void move() {
    	
    	ballX += velocity[0];
    	ballY += velocity[1];
    	
    }
    
    //Toggle horizontal direction.
    public void toggleHorizontal() {
    	
    	velocity[0] *= -1;
    	
    }
    
    //Toggle vertical direction.
    public void toggleVertical() {
    	
    	velocity[1] *= -1;
    	
    }
     
    private class MyComponent extends JComponent{

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
             
            if (fillBall) //Fill first, and then draw outline.
            {
                g.setColor(ballFillColor);
                g.fillOval((int)getBallX(),(int)getBallY(), getBallHeight(),getBallWidth());
            }
             
            g.setColor(getBallBorderColor());
            g.drawOval((int)getBallX(),(int)getBallY(), getBallHeight(),getBallWidth());
             
        }
    }
 
 
}