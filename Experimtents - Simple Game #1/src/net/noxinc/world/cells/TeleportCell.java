package net.noxinc.world.cells;

import net.noxinc.dialogs.StatusText;
import net.noxinc.units.Player;
import net.noxinc.world.Map;

public class TeleportCell extends Cell
{
	private Map destination;
	private int x;
	private int y;
	
	public TeleportCell()
	{
		setSymbol('0');
		setStepOn(true);
	}
	
	public TeleportCell(Map destination, int x, int y)
	{
		setSymbol('o');
		setStepOn(true);
		this.x = x;
		this.y = y;
		this.destination = destination;
	}
	
	@Override
	public void onSteppedOn(Player player)
	{
		player.teleport(destination, x, y);
		StatusText.printText("You have ben ported!");
	}

}
