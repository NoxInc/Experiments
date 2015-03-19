package net.noxinc.world.cells;

public class Cell 
{
	private char symbol;
	private boolean collectable;
	private boolean solidness;
	
	public Cell()
	{
		
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public boolean isCollectable()
	{
		return collectable;
	}
	
	public boolean isSolid()
	{
		return solidness;
	}
	
	public Cell setSolidness(boolean value)
	{
		solidness = value;
		collectable = false;
		return this;
	}
	
	public Cell setCollectable(boolean value)
	{
		collectable = value;
		return this;
	}
	
	public Cell setSymbol(char symbol)
	{
		this.symbol = symbol;
		return this;
	}
	
}
