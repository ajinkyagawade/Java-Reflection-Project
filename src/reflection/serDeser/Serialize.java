package reflection.serDeser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;

public class Serialize
{

	public static BufferedWriter bw;

	/**
	 * 
	 * @return void
	 */
	public void serializeObjects(String fileName)
	{
		try
		{
			File file = new File(fileName);
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);

			for (int i = 0; i < Deserialize.objectList.size(); i++)
			{
				Object o = Deserialize.objectList.get(i);
				if (o instanceof MyAllTypesFirst)
				{

					serializeStrategy(o, new StrategyFirst());

				}
				else if (o instanceof MyAllTypesSecond)
				{
					serializeStrategy(o, new StrategySecond());
				}
			}

			bw.close();
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}

	}

	public void serializeStrategy(Object obj, Strategy strat)
	{
		strat.serialize(bw, obj);
	}

}
