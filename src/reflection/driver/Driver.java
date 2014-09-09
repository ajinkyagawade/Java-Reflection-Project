package reflection.driver;

import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialize;
import reflection.util.Debug;

public class Driver
{

	public static void main(String[] args)
	{
		try
		{
			String inputFileName = args[0];
			String outputFileName = args[1];
			int debugValue = Integer.parseInt(args[2]);
			Debug.setDebugValue(debugValue);
			Deserialize desr = new Deserialize();
			desr.deserializeFile(inputFileName);
			desr.checkEqual();
			new Serialize().serializeObjects(outputFileName);
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}
	}

}
