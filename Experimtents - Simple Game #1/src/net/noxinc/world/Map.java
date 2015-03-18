package net.noxinc.world;

import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.EmptyCell;

public class Map 
{
	Cell[][] board;
	
	private int xLength;
	private int yLength;
	
	public Map()
	{
		this(5, 5);
	}
	
	public Map(int x, int y)
	{
		xLength = x;
		yLength = y;
		
		board = new Cell[x][y];
		fillBoard();
	}
	
	public void redraw()
	{
		String tmp = "";
		for(int y = 0; y < board[0].length; y++)
		{
			for(int x = 0; x < board.length; x++)
			{
				if(getCellAtPosition(x, y) == null)
				{
					tmp += '.';
				}else{
					tmp += getCellAtPosition(x, y).getSymbol();
				}
			}
			tmp += "\n";
		}
		System.out.println(tmp);
	}
	
	private void fillBoard()
	{
		for(int y = 1; y < board[0].length - 1; y++)
		{
			for(int x = 1; x < board.length - 1; x++)
			{
				board[x][y] = new EmptyCell();
			}
		}
	}
	
	public Cell getCellAtPosition(int x, int y)
	{
		return board[x][y];
	}
	
	public void createCellAtPosistion(int x, int y, Cell cell)
	{
		board[x][y] = cell;
	}
	
	public int getXLength()
	{
		return xLength;
	}
	
	public int getYLength()
	{
		return yLength;
	}
	
	public Cell[][] getBoard()
	{
		return board;
	}

}
