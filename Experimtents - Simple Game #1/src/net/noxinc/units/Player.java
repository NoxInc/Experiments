package net.noxinc.units;

import net.noxinc.inventory.Inventory;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;
import net.noxinc.world.cells.TeleportCell;

public class Player extends Cell
{
	private Map map;
	private Cell tmpCell = new EmptyCell();
	private int x;
	private int y;
	private int health = 10;
	private Inventory playerInventory;
	
	public Player(Map map, int x, int y, int invSize)
	{
		this.map = map;
		this.x = x;
		this.y = y;
		
		playerInventory = new Inventory(invSize, this);
		
		setSymbol('P');
		spawnPlayer(map);
	}
	
	public void spawnPlayer(Map map)
	{
		map.getBoard()[x][y] = this;
	}
	
	public void decreseHealth(int value)
	{
		health -= value;
	}
	
	public void heal(int value)
	{
		health += value;
	}
	
	public void openInventory()
	{
		getInventory().openInventory();
	}
	
	private void setTmpCell(Cell cell)
	{
		tmpCell = cell;
	}
	
	public void teleport(Map dest,int x, int y)
	{
		map.getBoard()[this.x][this.y] = new EmptyCell();
		this.x = x;
		this.y = y;
		map = dest;
		setTmpCell(dest.getCellAtPosition(x, y));
		dest.getBoard()[x][y] = this;
	}
	
	public void input(int direction)
	{
		switch(direction)
		{
		case 1:
			if(!(y - 1 < 1))
		    {
				if(map.getCellAtPosition(x, y - 1) instanceof TeleportCell)
				{
					tmpCell = map.getCellAtPosition(x, y - 1);
					checkTmpCell();
					
				}else if(!(map.getCellAtPosition(x, y - 1).isSolid()))
		        {
			        map.getBoard()[x][y] = tmpCell;
			        tmpCell = map.getCellAtPosition(x, y - 1);
			        map.getBoard()[x][y - 1] = this;
			        y--;
		        	checkTmpCell();
		        }
		    }
			break;
		case 2:
			if(!(y + 1 > map.getYLength() - 2))
		    {
				if(map.getCellAtPosition(x, y + 1) instanceof TeleportCell)
				{
					tmpCell = map.getCellAtPosition(x, y + 1);
					checkTmpCell();
					
		    	}else if(!(map.getCellAtPosition(x, y + 1).isSolid()))
		        {
		            map.getBoard()[x][y] = tmpCell;
		            tmpCell = map.getCellAtPosition(x, y + 1);
		            map.getBoard()[x][y + 1] = this;
		            y++;
		            checkTmpCell();
		        }
		    }
			break;
		case 3:
			if(!(x + 1 > map.getXLength() - 2))
		    {
				if(map.getCellAtPosition(x + 1, y) instanceof TeleportCell)
				{
					tmpCell = map.getCellAtPosition(x + 1, y);
					checkTmpCell();
					
		    	}else if(!(map.getCellAtPosition(x + 1, y).isSolid()))
		        {
		            map.getBoard()[x][y] = tmpCell;
		            tmpCell = map.getCellAtPosition(x + 1, y);
		            map.getBoard()[x + 1][y] = this;
		            x++;
		            checkTmpCell();
		        }
		    }
			break;
		case 4:
			if(!(x - 1 < 1))
		    {
				if(map.getCellAtPosition(x - 1, y) instanceof TeleportCell)
				{
					tmpCell = map.getCellAtPosition(x - 1, y);
					checkTmpCell();
					
		    	}else if(!(map.getCellAtPosition(x - 1, y).isSolid()))
		        {
		            map.getBoard()[x][y] = tmpCell;
		            tmpCell = map.getCellAtPosition(x - 1, y);
		            map.getBoard()[x - 1][y] = this;
		            x--;
		            checkTmpCell();
		        }
		    }
			break;
		case 5:
			openInventory();
			break;
		default:
			break;
		}
	}
	
	private void checkTmpCell()
	{
		if(tmpCell.isCollectable())
		{
			playerInventory.addToInventory(tmpCell);
			tmpCell = new EmptyCell();
		}else if(tmpCell.canStepOn())
		{
			tmpCell.onSteppedOn(this);
		}
	}
	
	public Inventory getInventory()
	{
		return playerInventory;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public Cell getTmpCell()
	{
		return tmpCell;
	}
}
