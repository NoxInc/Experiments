package net.noxinc;

import java.util.Scanner;

import net.noxinc.dialogs.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.DebugCell;

public class Main 
{
	private static Scanner myScanner = new Scanner(System.in);
	private static Map map  = new Map(10, 10);
	private static Player player = new Player(map, 1, 1, 5);
	
	public static void main(String[] args)
	{
		
		map.createCellAtPosistion(4, 4, new DebugCell());
		map.createCellAtPosistion(4, 5, new DebugCell().setCollectable(false));
		while(true)
		{
			map.redraw();
			Dialogs.moveDialog();
			
			player.input(myScanner.nextInt());
		}
	}
}
