package net.noxinc.world.cells;

import net.noxinc.dialogs.StatusText;
import net.noxinc.units.Player;

public class TeleportCell extends Cell
{
	public TeleportCell()
	{
		setSymbol('0');
		setStepOn(true);
	}
	
	@Override
	public void onSteppedOn(Player player)
	{
		player.teleport(1, 1);
		StatusText.printText("You have ben ported!");
	}

}
