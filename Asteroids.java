package asteroids;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
Modified by Megan Owen
 */
import java.awt.*;
import java.awt.Graphics;

import java.awt.event.*;

public class Asteroids extends Game {
	private int counter = 0;
	//Create varibale that will increment with counter and set to 0 when a collision occurs. one variable for ship collisions one for asteroid collisions
	public int lives = 3;
	Point [] pointArray = {new Point(300,300), new Point(320,305), new Point(300,310), new Point(300,300)};
	Polygon poly = new Polygon(pointArray,new Point(300,300),0);
	Ship spaceShip = new Ship(pointArray,new Point(400,300),0);
	
	Point [] asteroidPoint = {new Point(100,100), new Point(110,90), 
							  new Point(130,75), new Point(120,120),new Point(110,110)};
	Asteroid a1 = new Asteroid(asteroidPoint,new Point(100,100),0);
	Asteroid a2 = new Asteroid(asteroidPoint,new Point(200,200),0);
	Asteroid a3 = new Asteroid(asteroidPoint,new Point(400,400),0);
	Asteroid a4 = new Asteroid(asteroidPoint,new Point(50,50),0);
	

	
	public Asteroids() {
		super("Asteroids!",800,600);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(spaceShip);
	}

	public void paint(Graphics brush) {
		
		int score = counter / 10;
		int directionChange = -1;// changes direction objects by changing sign
		int multiplier = score / 100;
		if (lives<0)// if lives go below zero we run into problems
			lives = 0;
		
		if (score/100 < 1)// so we do not end up multiplying the speed by zero
			multiplier = 1;
		
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);
		
		brush.setColor(Color.red);
		if (lives == 3){
			
			brush.drawOval(730,10,20,20);
			brush.fillOval(730,10,20,20);
			
			brush.drawOval(750,10,20,20);
			brush.fillOval(750,10,20,20);
			
			brush.drawOval(770,10,20,20);
			brush.fillOval(770,10,20,20);
		}
		else
		if (lives == 2){
				
				brush.drawOval(730,10,20,20);
				brush.fillOval(730,10,20,20);
				
				brush.drawOval(750,10,20,20);
				brush.fillOval(750,10,20,20);
				
				brush.drawOval(770,10,20,20);
			}
		else
		if (lives == 1){
				
				brush.drawOval(730,10,20,20);
				brush.fillOval(730,10,20,20);
				
				brush.drawOval(750,10,20,20);
				
				brush.drawOval(770,10,20,20);
			}
		else 
		if (lives <= 0){	
			brush.drawOval(730,10,20,20);	
			brush.drawOval(750,10,20,20);	// when user dies
			brush.drawOval(770,10,20,20);
			brush.drawString("You have died, your score is " + score ,300,300);
			spaceShip.paintShip(brush);
		}

		brush.setColor(Color.white);
		brush.drawString("Your score is " + score ,10,10);

		if ((spaceShip.contains(a1.position)) || (spaceShip.contains(a2.position)) ||
			(spaceShip.contains(a3.position)) || (spaceShip.contains(a4.position)) ||
			(spaceShip.contains(a4.position)))
			{ lives--; }
		
		if (!(lives <= 0)){
			counter++;// located here so counter will not continue when user has died
			spaceShip.paintShip(brush);//paints ship
	
			spaceShip.move();//moves ship
		
			brush.setColor(Color.gray);
		
			a1.paintAsteroid(brush);
			a2.paintAsteroid(brush);// paints asteroids
			a3.paintAsteroid(brush);
			a4.paintAsteroid(brush);
		
			if(score / 100 >= 1){
					a1.asteroidMove(-1*multiplier,1*multiplier,1*multiplier);//This if else allows for the spaceships 
					a2.asteroidMove(1*multiplier,-1*multiplier,5*multiplier);//to speed up as the game progresses
					a3.asteroidMove(2*multiplier,1*multiplier,10*multiplier);
					a4.asteroidMove(1*multiplier,-2*multiplier,15*multiplier);
								}
		
			else{
				a1.asteroidMove(-1,1,1);
				a2.asteroidMove(1,-1,5);//Starting speed for asteroids
				a3.asteroidMove(2,1,10);
				a4.asteroidMove(1,-2,15);
				}//asteroid else
		
		///////////////////////////////Changes Direction of Asteroids if they collide///////////////////////////////
		if(a1.contains((a2.position))){
			a1.asteroidMove(-1*multiplier*directionChange,1*multiplier*directionChange,1*multiplier);//Block changes directions of asteroids
			a2.asteroidMove(1*multiplier*directionChange,-1*multiplier*directionChange,5*multiplier);//when they collide
		}//a1 and a2 collide																		 
		if(a1.contains((a3.position))){
			a1.asteroidMove(-1*multiplier*directionChange,1*multiplier*directionChange,1*multiplier);
			a3.asteroidMove(2*multiplier*directionChange,1*multiplier*directionChange,10*multiplier);
		}//a1 and a3 collide
		if(a1.contains((a4.position))){
			a1.asteroidMove(-1*multiplier*directionChange,1*multiplier*directionChange,1*multiplier);
			a4.asteroidMove(1*multiplier*directionChange,-2*multiplier*directionChange,15*multiplier);
		}//a1 and a4 collide
		if(a2.contains((a3.position))){
			a2.asteroidMove(1*multiplier*directionChange,-1*multiplier*directionChange,5*multiplier);
			a3.asteroidMove(2*multiplier*directionChange,1*multiplier*directionChange,10*multiplier);
		}//a2 and a3 collide
		if(a2.contains((a4.position))){
			a2.asteroidMove(1*multiplier*directionChange,-1*multiplier*directionChange,5*multiplier);
			a4.asteroidMove(1*multiplier*directionChange,-2*multiplier*directionChange,15*multiplier);
		}//a2 and a4 collide
		if(a3.contains((a4.position))){
			a3.asteroidMove(2*multiplier*directionChange,1*multiplier*directionChange,10*multiplier);
			a4.asteroidMove(1*multiplier*directionChange,-2*multiplier*directionChange,15*multiplier);
		}//a3 and a4 collide*/
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
	}
}