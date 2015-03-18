package net.noxinc.units;

import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Player extends Cell
{
	private int x;
	private int y;
	
	public Player(Map map, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		setSymbol('P');
		spawnPlayer(map);
	}
	
	public void spawnPlayer(Map map)
	{
		map.getBoard()[x][y] = this;
	}
}
