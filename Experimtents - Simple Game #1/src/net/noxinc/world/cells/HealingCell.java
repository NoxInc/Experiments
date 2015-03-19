package net.noxinc.world.cells;

import net.noxinc.dialogs.StatusText;

public class HealingCell extends Cell
{
	private int amount;
	
	public HealingCell()
	{
		this(5);
	}
	
	public HealingCell(int amount)
	{
		setConsumability(true);
		setCollectable(true);
		setSymbol('H');
		this.amount = amount;
	}
	
	@Override
	public void consume()
	{
		getPlayer().heal(amount);
		StatusText.printText("You have been healed to " + getPlayer().getHealth() + "HP (+" + amount + ")");
	}
}
