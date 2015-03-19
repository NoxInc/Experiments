package net.noxinc;

import java.util.Scanner;

import net.noxinc.dialogs.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.Map;
import net.noxinc.world.cells.DebugCell;
import net.noxinc.world.cells.HealingCell;
import net.noxinc.world.cells.SolidCell;
import net.noxinc.world.cells.TeleportCell;

public class Main 
{
	private static Scanner myScanner = new Scanner(System.in);
	private static Map map  = new Map(10, 10);
	private static Player player = new Player(map, 1, 1, 5);
	
	public static void main(String[] args)
	{
		map.createCellAtPosistion(4, 4, new SolidCell());
		map.createCellAtPosistion(7, 2, new TeleportCell());
		map.createCellAtPosistion(4, 5, new DebugCell());
		map.createCellAtPosistion(3, 3, new HealingCell());
		map.createCellAtPosistion(4, 3, new HealingCell(10));
		
		while(true)
		{
			map.redraw();
			Dialogs.moveDialog();
			
			player.input(myScanner.nextInt());
		}
	}
}
