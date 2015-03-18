package net.noxinc.units;

import net.noxinc.inventory.Inventory;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Player extends Cell
{
	private int x;
	private int y;
	private Inventory playerInventory;
	
	public Player(Map map, int x, int y, int invSize)
	{
		this.x = x;
		this.y = y;
		
		playerInventory = new Inventory(invSize);
		
		setSymbol('P');
		spawnPlayer(map);
	}
	
	public void spawnPlayer(Map map)
	{
		map.getBoard()[x][y] = this;
	}
	
	public Inventory getInventory()
	{
		return playerInventory;
	}
}
