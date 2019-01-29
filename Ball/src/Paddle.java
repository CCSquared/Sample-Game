import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
public class Paddle {
	private Color paddleFillColor = Color.BLACK;
	private Color paddleBorderColor = Color.BLACK;
	private double paddleX=0;
	private double paddleY=0;
	private int paddleWidth=0;
	private int paddleHeight=0;
	
	public Paddle(double x,double y) {
		paddleX=x;
		paddleY=y;
	}
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
	public void move(int v) {
		paddleY+=v;
	}
	private class MyComponent extends JComponent{
		private static final long serialVersionUID = 1L;
		public void paint(Graphics g){
                g.setColor(getFillColor());
                g.fillRect((int)paddleX,(int)paddleY, getHeight(),getWidth());
                g.setColor(getpaddleBorderColor());
                g.drawRect((int)paddleX,(int)paddleY, getHeight(),getWidth());
		}
	}
}