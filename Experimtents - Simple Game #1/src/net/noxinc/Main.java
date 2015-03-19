package net.noxinc;

import java.util.Scanner;

import net.noxinc.dialogs.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.Map;
import net.noxinc.world.cells.HealingCell;
import net.noxinc.world.cells.MineCell;
import net.noxinc.world.cells.SolidCell;
import net.noxinc.world.cells.TeleportCell;

public class Main 
{
	private static Scanner myScanner = new Scanner(System.in);
	private static Map map  = new Map(10, 10);
	private static Map home = new Map(7, 7);
	private static Player player = new Player(map, 1, 1, 5);
	
	public static void main(String[] args)
	{
		map.createCellAtPosistion(4, 4, new SolidCell());
		map.createCellAtPosistion(8, 1, new TeleportCell(home, 2, 2));
		home.createCellAtPosistion(2, 1, new TeleportCell(map, 8, 2));
		map.createCellAtPosistion(3, 3, new HealingCell());
		map.createCellAtPosistion(4, 3, new HealingCell(10));
		home.createCellAtPosistion(1, 3, new MineCell(1, 3));
		
		player.getInventory().addToInventory(new SolidCell());
		
		while(player.getHealth() > 0)
		{
			player.getMap().redraw();
			Dialogs.moveDialog();
			
			player.input(myScanner.nextInt());
		}
	}
}
