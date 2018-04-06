package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.Direction;
import naturesimulator.*;
import ui.GridPanel;

public class Herbivore extends Creature{
	
	/**Constructor of the Herbivore class. Sets the herbivore's coordinates and its base health stats
	 * @param x the x coordinate of the Herbivore
	 * @param y the y coordiante of the Herbivore
	 */
	public Herbivore(int x, int y) {
		super(x, y);
		health = 10.0;
		maxHealth = 20.0;
	}
	
	@Override
	public void stay() {
		health-=0.1;
	}
	
	@Override
	public Creature reproduce(Direction direction) {
		Herbivore a;
		if(direction == Direction.UP)
			a = new Herbivore(x,y-1);
		else if(direction == Direction.DOWN)
			a = new Herbivore(x,y+1);
		else if(direction == Direction.LEFT)
			a = new Herbivore(x-1,y);
		else
			a = new Herbivore(x+1,y);
		a.health = health*0.2;
		health = health*0.4;
		return a;
	}
	
	@Override
	public void attack(Creature creature) {
		health+=creature.health;
		if(health > maxHealth)
			health = maxHealth;
		creature.health = 0;
		x = creature.x;
		y = creature.y;
		
	}
	
	@Override
	public void move(Direction direction) {
		if(direction == Direction.UP)
			y--;
		else if(direction == Direction.DOWN)
			y++;
		else if(direction == Direction.LEFT)
			x--;
		else if(direction == Direction.DOWN)
			x++;
		health-=1.0;
	}
	
	@Override
	public Action chooseAction(LocalInformation information) {
		List<Direction> plantDirections = new ArrayList<Direction>();
		if(information.getCreatureDown() instanceof Plant)
			plantDirections.add(Direction.DOWN);
		if(information.getCreatureUp() instanceof Plant)
			plantDirections.add(Direction.UP);
		if(information.getCreatureLeft() instanceof Plant)
			plantDirections.add(Direction.LEFT);
		if(information.getCreatureRight() instanceof Plant)
			plantDirections.add(Direction.RIGHT);
		
		
		if(health == maxHealth && information.getFreeDirections().size()!=0)
			return new Action(Action.Type.REPRODUCE,LocalInformation.getRandomDirection(information.getFreeDirections()));
		if(plantDirections.size()!=0) 
			return new Action(Action.Type.ATTACK,LocalInformation.getRandomDirection(plantDirections));
		if(health>1.0)
			return new Action(Action.Type.MOVE,LocalInformation.getRandomDirection(information.getFreeDirections()));
		else 
			return new Action(Action.Type.STAY);
	}
	
	@Override
	public void draw(GridPanel panel) {
		panel.drawSquare(x, y, new Color(200-(int)(80*health/maxHealth),0,0));
	}
	
	
	
	
	
	
	
	
	
	
}
