package reflection.util;

public class MyAllTypesSecond
{
	private int myIntS;
	private String myStringS;
	private float myFloatS;
	private short myShortS;
	private char myCharS;

	public int getMyIntS()
	{
		return myIntS;
	}

	public void setMyIntS(int myIntS)
	{
		this.myIntS = myIntS;
	}

	public String getMyStringS()
	{
		return myStringS;
	}

	public void setMyStringS(String myStringS)
	{
		this.myStringS = myStringS;
	}

	public float getMyFloatS()
	{
		return myFloatS;
	}

	public void setMyFloatS(float myFloatS)
	{
		this.myFloatS = myFloatS;
	}

	public short getMyShortS()
	{
		return myShortS;
	}

	public void setMyShortS(short myShortS)
	{
		this.myShortS = myShortS;
	}

	public char getMyCharS()
	{
		return myCharS;
	}

	public void setMyCharS(char myCharS)
	{
		this.myCharS = myCharS;
	}

	public boolean equals(Object obj)
	{
		if (Debug.getDebugValue() >= 1)
		{
			System.out.println("In equals Method of MyAllTypesSecond");

		}
		MyAllTypesSecond snd = (MyAllTypesSecond) obj;
		return ((this.myIntS == snd.myIntS) && (this.myStringS.equals(snd.myStringS)) && (this.myFloatS == snd.myFloatS)
				&& (this.myShortS == snd.myShortS) && (this.myCharS == snd.myCharS));
	}

	/**
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		if (Debug.getDebugValue() >= 1)
		{
			System.out.println("In hashCode Method of MyAllTypesSecond");

		}
		return (myIntS * 13 + myStringS.hashCode() * 17 + (int) myFloatS * 19 + myShortS * 23 + (int) myCharS * 29);
	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return getMyIntS() + " " + getMyStringS() + " " + getMyFloatS() + " " + getMyShortS() + " " + getMyCharS();
	}

}
