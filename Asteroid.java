package asteroids;
import java.awt.Graphics;

public class Asteroid extends Polygon {
	
	public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}
	
	public void asteroidMove(int y, int x, int r){
		
		rotate(r);	;
		
		position.addToY(y);
		position.addToX(x);
		
		if(position.getX() > 800)
			position.addToX(-800);
		
		if(position.getX() < 0)
			position.addToX(800);
		
		if(position.getY() > 600)
			position.addToY(-600);
		
		if(position.getY() < 0)
			position.addToY(600);
	}
}
