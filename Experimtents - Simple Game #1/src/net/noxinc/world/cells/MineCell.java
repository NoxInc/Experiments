package net.noxinc.world.cells;

import net.noxinc.dialogs.StatusText;
import net.noxinc.units.Player;

public class MineCell extends Cell
{
	private int dmg;
	
	public MineCell(int x, int y)
	{
		setStepOn(true);
		setSymbol('x');
		dmg = 5;
	}
	
	@Override
	public void onSteppedOn(Player player)
	{
		player.setTmpCell(new EmptyCell());
		player.decreseHealth(dmg);
		StatusText.printText("You're down to " + (player.getHealth()) + " (-" + dmg + ")");
	}


}
