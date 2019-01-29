import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
public class Paddle {
	private Color paddleFillColor;
	private Color paddleBorderColor = Color.BLACK;
	private double paddleX=0;
	private double paddleY=0;
	private int paddleWidth=0;
	private int paddleHeight=0;
	
	public Color getFillColor() {
	   return paddleFillColor;
	}
	public void setpaddleFillColor(Color paddleFillColor) {
	   this.paddleFillColor = paddleFillColor;
	}
	public Color getpaddleBorderColor() {
	   return paddleBorderColor;
	}
	public void setpaddleBorderColor(Color paddleBorderColor) {
	   this.paddleBorderColor = paddleBorderColor;
	}
	public double getX() {
	   return paddleX;
	}
	public void setX(double paddleX) {
	   this.paddleX = paddleX;
	}
	public double getY() {
	   return paddleY;
	}
	public void setY(double paddleY) {
	   this.paddleY = paddleY;
	}
	public int getWidth() {
	   return paddleWidth;
	}
	public void setWidth(int paddleWidth) {
	   this.paddleWidth = paddleWidth;
	}
	public int getHeight() {
       return paddleHeight;
	}
	public void setHeight(int paddleHeight) {
		 this.paddleHeight = paddleHeight;
	}
	private class MyComponent extends JComponent{

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
                g.setColor(Color.BLACK);
                g.fillRect((int)getX(),(int)getY(), getHeight(),getWidth());
                g.setColor(Color.BLACK);
                g.drawRect((int)getX(),(int)getY(), getHeight(),getWidth());
		}
	}
}