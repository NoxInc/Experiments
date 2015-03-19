package net.noxinc.world.cells;

import net.noxinc.units.Player;
import net.noxinc.world.Map;


public class Cell 
{
	private Player player;
	private Map map;
	private char symbol;
	private boolean collectable;
	private boolean solidness;
	private boolean consumable;
	private boolean onSteppedOn;
	
	public Cell()
	{
		
	}
	
	public void consume()
	{
		onConsumtion();
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public boolean isCollectable()
	{
		return collectable;
	}
	
	public boolean isSolid()
	{
		return solidness;
	}
	
	public boolean isConsumable()
	{
		return consumable;
	}
	
	public boolean canStepOn()
	{
		return onSteppedOn;
	}
	
	public Cell setStepOn(boolean value)
	{
		onSteppedOn = value;
		return this;
	}
	
	public Cell setPlayer(Player player)
	{
		this.player = player;
		return this;
	}
	
	public Cell setMap(Map map)
	{
		this.map = map;
		return this;
	}
	
	public Cell setConsumability(boolean value)
	{
		consumable = value;
		return this;
	}
	
	public Cell setSolidness(boolean value)
	{
		solidness = value;
		collectable = false;
		return this;
	}
	
	public Cell setCollectable(boolean value)
	{
		collectable = value;
		return this;
	}
	
	public Cell setSymbol(char symbol)
	{
		this.symbol = symbol;
		return this;
	}
	
	public Cell collect(Player player)
	{
		this.player = player;
		onCollection();
		return this;
	}
	
	public void onCollection()
	{
		
	}
	
	public void onConsumtion()
	{
		
	}
	
	public void onSteppedOn(Player player)
	{
		
	}
}
