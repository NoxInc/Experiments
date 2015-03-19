package net.noxinc.inventory;

import net.noxinc.Input;
import net.noxinc.dialogs.Dialogs;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;

public class Inventory 
{
	private Cell[] inventory;
	private Input myInput = new Input();
	private int slotCounter = 0;
	
	public Inventory(int inventorySize)
	{
		inventory = new Cell[inventorySize];
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
		
		Dialogs.inventoryDialog();
		
		switch(myInput.getNextInt())
		{
			case 0:
				break;
			case 1:
				
				break;
			default:
				break;
		}
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
	
	public void addToInventory(Cell cell)
	{
		inventory[slotCounter] = cell;
		slotCounter++;
	}

}
