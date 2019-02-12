import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;

public class Keys {

	private static HashMap<Integer, Boolean> keys;
	private static HashMap<Integer, Boolean> keysPushed;
	
	public static void keyPressed(KeyEvent e) {
		keys.put(e.getKeyCode(), true);	
	}

	public static void keyReleased(KeyEvent e) {
		keys.put(e.getKeyCode(), false);	
		keysPushed.put(e.getKeyCode(), true);
	}

	public static void keyTyped(KeyEvent e) {
		
	}
	
	public static boolean IsKeyDown(Integer keyCode) {
		return keys.get(keyCode);
	}
	
	public static boolean IsKeyUp(Integer keyCode) {
		return !keys.get(keyCode);
	}
	
	public static boolean IsKeyPushed(Integer keyCode) {
		boolean pushed = keysPushed.get(keyCode);
		keysPushed.put(keyCode, false);
		return pushed;
	}
	
}