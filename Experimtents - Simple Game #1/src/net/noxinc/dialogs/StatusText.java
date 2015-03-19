package net.noxinc.dialogs;

public class StatusText 
{
	public static void printText(String value)
	{
		String tmp = "\n ";
		for(int x = 0; x < value.length(); x++)
		{
			tmp += "_";
		}
		tmp += "\n|";
		tmp += value;
		tmp += "|\n ";
		for(int x = 0; x < value.length(); x++)
		{
			tmp += "-";
		}
		tmp += "\n";
		System.out.println(tmp);
	}
}
