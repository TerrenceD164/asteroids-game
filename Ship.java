package asteroids;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Canvas;

public class Ship extends Polygon implements KeyListener {
	boolean isKeyUp = false;
	boolean isKeyDown = false;
	boolean isKeyLeft = false;
	boolean isKeyRight = false;
	boolean isAnotherKey = false;

	
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);

	}
	public void move(){
		if (isKeyUp){
			position.addToY(-5);
	}
		if (isKeyLeft){
			rotate(-5);			
	}
		if (isKeyRight){
			rotate(5);
		}
			if(position.getX() > 800)
				position.addToX(-800);
			
			if(position.getX() < 0)
				position.addToX(800);
			
			if(position.getY() > 600)
				position.addToY(-600);
			
			if(position.getY() < 0)
				position.addToY(600);
		}	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch (keyCode){
			case KeyEvent.VK_UP:
				isKeyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				isKeyDown = true;
				break;
			case KeyEvent.VK_LEFT:
				isKeyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				isKeyRight = true;
				break;
			default:
				isAnotherKey = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch (keyCode){
		case KeyEvent.VK_UP:
			isKeyUp = false;
			break;
		case KeyEvent.VK_DOWN:
			isKeyDown = false;
			break;
		case KeyEvent.VK_LEFT:
			isKeyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			isKeyRight = false;
			break;
		default:
			isAnotherKey = false;
	}
	}
	//Ignore this one
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
