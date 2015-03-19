package net.noxinc.units;

import net.noxinc.inventory.Inventory;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;

public class Player extends Cell
{
	private Map map;
	private Cell tmpCell = new EmptyCell();
	private Cell tmpPlayer;
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
	
	public Inventory getInventory()
	{
		return playerInventory;
	}
	
	public int getHealth()
	{
		return health;
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
	
	public void input(int direction)
	{
		tmpPlayer = map.getBoard()[x][y];
		switch(direction)
		{
		case 1:
			moveUp();
			break;
		case 2:
			moveDown();
			break;
		case 3:
			moveRight();
			break;
		case 4:
			moveLeft();
			break;
		case 5:
			openInventory();
			break;
		default:
			break;
		}
	}
	private void moveUp()
	{
		tmpPlayer = map.getBoard()[x][y];
		if(!(y - 1 < 1))
		{
			if(map.getCellAtPosition(x, y - 1).isCollectable())
			{
				map.getBoard()[x][y] = tmpCell;
				playerInventory.addToInventory(map.getCellAtPosition(x, y - 1));//.collect(this)); /*map.getBoard()[x][y - 1])*/;
				tmpCell = new EmptyCell();
				map.getBoard()[x][y - 1] = tmpPlayer;
				y--;
			}else if((map.getCellAtPosition(x, y - 1).isSolid()))
			{
			}else{
				map.getBoard()[x][y] = tmpCell;
				tmpCell = map.getBoard()[x][y - 1];
				map.getBoard()[x][y - 1] = tmpPlayer;
				y--;
			}
		}
	}
	
	private void moveDown()
	{
		tmpPlayer = map.getBoard()[x][y];
		if(!(y + 1 > map.getYLength() - 2))
		{
			if(map.getCellAtPosition(x, y + 1).isCollectable())
			{
				map.getBoard()[x][y] = tmpCell;
				playerInventory.addToInventory(map.getCellAtPosition(x, y + 1));
				tmpCell = new EmptyCell();
				map.getBoard()[x][y + 1] = tmpPlayer;
				y++;
			}else if((map.getCellAtPosition(x, y + 1).isSolid()))
			{
			}else{
				map.getBoard()[x][y] = tmpCell;
				tmpCell = map.getBoard()[x][y + 1];
				map.getBoard()[x][y + 1] = tmpPlayer;
				y++;
			}
		}
	}
	
	private void moveRight()
	{
		tmpPlayer = map.getBoard()[x][y];
		if(!(x + 1 > map.getXLength() - 2))
		{
			if(map.getCellAtPosition(x + 1, y).isCollectable())
			{
				map.getBoard()[x][y] = tmpCell;
				playerInventory.addToInventory(map.getCellAtPosition(x + 1, y));
				tmpCell = new EmptyCell();
				map.getBoard()[x + 1][y] = tmpPlayer;
				x++;
			}else if((map.getCellAtPosition(x + 1, y).isSolid()))
			{
			}else{
				map.getBoard()[x][y] = tmpCell;
				tmpCell = map.getBoard()[x + 1][y];
				map.getBoard()[x + 1][y] = tmpPlayer;
				x++;
			}
		}
	}
	
	private void moveLeft()
	{
		tmpPlayer = map.getBoard()[x][y];
		if(!(y - 1 < 1))
		{
			if(map.getCellAtPosition(x - 1, y).isCollectable())
			{
				map.getBoard()[x][y] = tmpCell;
				playerInventory.addToInventory(map.getCellAtPosition(x - 1, y));
				tmpCell = new EmptyCell();
				map.getBoard()[x - 1][y] = tmpPlayer;
				x--;
			}else if((map.getCellAtPosition(x - 1, y).isSolid()))
			{
			}else{
				map.getBoard()[x][y] = tmpCell;
				tmpCell = map.getBoard()[x - 1][y];
				map.getBoard()[x - 1][y] = tmpPlayer;
				x--;
			}
		}
	}
}
