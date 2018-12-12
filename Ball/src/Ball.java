import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JComponent;
import javax.swing.JFrame;

 
public class Ball
{
 
    private Color ballFillColor;
    private Color ballBorderColor;
     
    private double ballX = 0;
    private double ballY = 0;
    private int ballWidth = 0;
    private int ballHeight = 0;
     
    public boolean fillBall = true;
 
    Ball(){ //Constructor
        ballBorderColor = Color.black;
    }
 
    Ball(double ballX, double ballY, int ballWidth, int ballHeight, Color ballBorderColor, JFrame window){ //Constructor
        // X , Y , Width, Height, Border Colour, container
        this.setBallBorderColor(ballBorderColor);
        this.setBallWidth(ballWidth);
        this.setBallHeight(ballHeight);
        this.setBallX(ballX);
        this.setBallY(ballY);
        this.drawBall(window);
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
 
 
    public void drawBall(JFrame frame) 
    {
        frame.getContentPane().add(new MyComponent());
    }
 
 
    private class MyComponent extends JComponent{
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