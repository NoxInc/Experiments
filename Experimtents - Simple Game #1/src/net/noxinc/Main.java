package net.noxinc;

import java.util.Scanner;

import net.noxinc.dialogs.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.Map;
import net.noxinc.world.cells.DebugCell;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		Map map  = new Map(10, 10);
		Player player = new Player(map, 1, 1, 5);
		
		map.createCellAtPosistion(4, 4, new DebugCell());
		
		while(true)
		{
			map.redraw();
			Dialogs.moveDialog();
			player.move(myScanner.nextInt());
		}
	}

}
