package net.noxinc.world.cells;

import net.noxinc.dialogs.StatusText;


public class DebugCell extends Cell
{
	public DebugCell()
	{
		setSymbol('D');
		setCollectable(true);
		setConsumability(true);
	}
	
	@Override
	public void consume()
	{
		getPlayer().heal(5);
		StatusText.printText("You have been healed to " + getPlayer().getHealth() + "HP (+5)");
	}
}
