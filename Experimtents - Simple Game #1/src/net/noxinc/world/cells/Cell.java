package net.noxinc.world.cells;

public class Cell 
{
	private char symbol;
	private boolean collectable;
	
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
