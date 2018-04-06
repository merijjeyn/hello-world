package project;

import java.awt.Color;

import game.Direction;
import naturesimulator.*;
import ui.GridPanel;

public class Plant extends Creature{ 
	
	/**constructor of the Plant class. Sets the plant's coordinates and base health stats
	 * @param x the x coordinate of the plant
	 * @param y the y coordinate of the plant
	 */
	public Plant(int x, int y) {
		super(x,y);
		health = 0.5;
		maxHealth = 1.0;
	}
	
	@Override
	public Creature reproduce(Direction direction) {
		Plant a;
		if(direction == Direction.UP)
			a = new Plant(x,y-1);
		else if(direction == Direction.DOWN)
			a = new Plant(x,y+1);
		else if(direction == Direction.LEFT)
			a = new Plant(x-1,y);
		else
			a = new Plant(x+1,y);
		a.health = health*0.1;
		health = health*0.7;
		return a;
	}
	
	@Override
	public void stay() {
		if(health<=0.95)
			health+=0.05;
	}
	
	@Override
	public Action chooseAction(LocalInformation information) {
		if(information.getFreeDirections().size()!=0 && health>=0.75) 
			return new Action(Action.Type.REPRODUCE,LocalInformation.getRandomDirection(information.getFreeDirections()));
		else 
			return new Action(Action.Type.STAY);
	}
	
	@Override
	public void draw(GridPanel panel) {
		panel.drawSquare(x, y, new Color(0,200-(int)(80*health/maxHealth),0));
	}
}
