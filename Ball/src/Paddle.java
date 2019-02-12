import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Paddle {
	private Color paddleFillColor = Color.BLACK;
	private Color paddleBorderColor = Color.BLACK;
	private double paddleX=0;
	private double paddleY=0;
	private int paddleWidth=0;
	private int paddleHeight=0;
	
	public Paddle(double x,double y, int w, int h,JLayeredPane lp) {
		paddleX=x;
		paddleY=y;
		this.setHeight(h);
		this.setWidth(w);
        this.drawPaddle(lp);
		//paddleWidth=w;
		//paddleHeight=h;
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
	public void drawPaddle(JLayeredPane layeredPane) {
        layeredPane.add(new MyComponent2(),2);
    }
	private class MyComponent2 extends JComponent{
		private static final long serialVersionUID = 2L;
		public void paint(Graphics g){
                //g.setColor(getFillColor());
                //g.fillRect((int)paddleX,(int)paddleY, getHeight(),getWidth());
                g.setColor(getpaddleBorderColor());
                g.drawRect((int)paddleX,(int)paddleY, getHeight(),getWidth());
                
		}
	}
}