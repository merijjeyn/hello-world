package project;

import game.Direction;
import game.Drawable;
import naturesimulator.*;
import ui.GridPanel;


/**
 * @author Meriç Üngör
 * This class is the superclass of Plant and Herbivore classes
 * and it bears the methods that Plant and Herbivore should implement.
 * Also it bears the coordinates of the creatures and their health stats.
 */
public class Creature implements Drawable{
	protected int x;
	protected int y;
	protected double health;
	protected double maxHealth;
	
	/**
	 * The constructor of the Creature class
	 * 
	 * @param x the x coordinate of the creature
	 * @param y the y coordinate of the creature
	 */
	public Creature(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * When called, the creature doesn't move loses some health if it is a herbivore 
	 * and gains some health if its a plant
	 */
	public void stay() {
	}
	
	/**When called a new creature is added to the world.
	 * @param direction states the position of the new creature according to the old one
	 * @return returns the newly created creature
	 */
	public Creature reproduce(Direction direction) {
		return null;
	}
	
	/**This method is like the brain of the Creature. It chooses what action 
	 * to take according to the information gained from its surroundings and its health.
	 * @param information information of the creature's surroundings
	 * @return returns the action that the creature is going to make
	 */
	public Action chooseAction(LocalInformation information) {
		return null;
	}

	/**Changes the current position of the creature
	 * @param direction moves in the direction specified
	 */
	public void move(Direction direction) {
		
	}
	
	/**Attacks a creature and gains the health of the attacked creature.
	 * Also the attacked creature's health is reduced to zero and removed from the world.
	 * @param Creature the creature attacked
	 */
	public void attack(Creature Creature) {
		
	}

	/**getter method of the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**getter method of the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**getter method of the health of the creature
	 */
	public double getHealth() {
		return health;
	}

	@Override
	public void draw(GridPanel panel) {
		
	}
	
}
