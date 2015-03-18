package net.noxinc.inventory;

import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;

public class Inventory 
{
	private Cell[] inventory;
	
	public Inventory(int inventorySize)
	{
		inventory = new EmptyCell[inventorySize];
		createCells();
	}
	
	public void openInventory()
	{
		String tmp = "";
		tmp += " ";
		for(int x = 0; x < inventorySize(); x++)
		{
			tmp += "_ ";
		}
		tmp += "\n";
		for(int x = 0; x < inventorySize(); x++)
		{
			tmp += "|" + inventory[x].getSymbol();
		}
		tmp += "|";
		System.out.println(tmp);
	}
	
	public int inventorySize()
	{
		return inventory.length;
	}
	
	private void createCells()
	{
		for(int x = 0; x < inventorySize(); x++)
		{
			inventory[x] = new EmptyCell();
		}
	}

}
