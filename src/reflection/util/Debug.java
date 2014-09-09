package reflection.util;

public class Debug
{
	private static int DEBUG_VALUE;

	/**
	 * 
	 * @return int
	 */
	public static int getDebugValue()
	{
		return DEBUG_VALUE;
	}

	/**
	 * 
	 * @return void
	 */
	public static void setDebugValue(int debugValue)
	{
		DEBUG_VALUE = debugValue;
	}
}