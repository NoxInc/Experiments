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
	private Inventory playerInventory;
	
	public Player(Map map, int x, int y, int invSize)
	{
		this.map = map;
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
			if(y - 1 < 1)
			{
				break;
			}else{
				map.getBoard()[x][y] = tmpCell;
				if(map.getCellAtPosition(x, y - 1).isCollectable())
				{
					playerInventory.addToInventory(map.getBoard()[x][y - 1]);
					tmpCell = new EmptyCell();
				}else{
					tmpCell = map.getBoard()[x][y - 1];
				}
				map.getBoard()[x][y - 1] = tmpPlayer;
				y--;
			}
			break;
		case 2:
			if(y + 1 > map.getYLength() - 2)
			{
				break;
			}else{
				map.getBoard()[x][y] = tmpCell;
				if(map.getCellAtPosition(x, y + 1).isCollectable())
				{
					playerInventory.addToInventory(map.getBoard()[x][y + 1]);
					tmpCell = new EmptyCell();
				}else{
					tmpCell = map.getBoard()[x][y + 1];
				}
				map.getBoard()[x][y + 1] = tmpPlayer;
				y++;
			}
			break;
		case 3:
			if(x + 1 > map.getXLength() - 2)
			{
				break;
			}else{
				map.getBoard()[x][y] = tmpCell;
				if(map.getCellAtPosition(x + 1, y).isCollectable())
				{
					playerInventory.addToInventory(map.getBoard()[x + 1][y]);
					tmpCell = new EmptyCell();
				}else{
					tmpCell = map.getBoard()[x + 1][y];
				}
				map.getBoard()[x + 1][y] = tmpPlayer;
				x++;
			}
			break;
		case 4:
			if(x - 1 < 1)
			{
				break;
			}else{
				map.getBoard()[x][y] = tmpCell;
				if(map.getCellAtPosition(x - 1, y).isCollectable())
				{
					playerInventory.addToInventory(map.getBoard()[x - 1][y]);
					tmpCell = new EmptyCell();
				}else{
					tmpCell = map.getBoard()[x - 1][y];
				}
				map.getBoard()[x - 1][y] = tmpPlayer;
				x--;
			}
			break;
		case 5:
			openInventory();
			break;
		default:
			break;
		}
	}
}
