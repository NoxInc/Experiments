package net.noxinc.inventory;

import net.noxinc.Input;
import net.noxinc.dialogs.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;

public class Inventory 
{
	private Cell[] inventory;
	private Player player;
	private Input myInput = new Input();
	private int slotCounter = 0;
	private int tmpInt;
	
	public Inventory(int inventorySize, Player player)
	{
		this.player = player;
		inventory = new Cell[inventorySize];
		createCells();
	}
	
	public void openInventory()
	{
		player.getMap().redraw();
		
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
				Dialogs.cellSelection();
				tmpInt = myInput.getNextInt();
				if(tmpInt > 0 && inventory[tmpInt - 1] != null && inventory[tmpInt - 1].isConsumable())
				{
					inventory[tmpInt - 1].consume();
					inventory[tmpInt - 1] = new EmptyCell();
					slotCounter--;
				}
				break;
			case 2:
				Dialogs.cellSelection();
				tmpInt = myInput.getNextInt();
				if(tmpInt > 0 && inventory[tmpInt - 1] != null)
				{
					player.placeCell(inventory[tmpInt - 1]);
					inventory[tmpInt - 1] = new EmptyCell();
					slotCounter--;
				}
				break;
			default:
				break;
		}
	}
	
	public int inventorySize()
	{
		return inventory.length;
	}
	
	public Player getOwner()
	{
		return player;
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
		for(int x = 0; x < inventory.length; x++)
		if(inventory[x].getSymbol() == ' ')
		{
			inventory[x] = cell.collect(player);
			break;
		}
	}

}
