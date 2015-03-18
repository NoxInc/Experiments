package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.Map;

public class Main 
{
	Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args)
	{
		Map map  = new Map(10, 10);
		Player player = new Player(map, 2, 3, 5);
		
		map.redraw();
		player.getInventory().openInventory();
		
	}

}
