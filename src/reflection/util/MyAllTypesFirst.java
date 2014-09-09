package reflection.util;

public class MyAllTypesFirst
{

	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	public int getMyInt()
	{
		return myInt;
	}

	public void setMyInt(int myInt)
	{
		this.myInt = myInt;
	}

	public String getMyString()
	{
		return myString;
	}

	public void setMyString(String myString)
	{
		this.myString = myString;
	}

	public double getMyDouble()
	{
		return myDouble;
	}

	public void setMyDouble(double myDouble)
	{
		this.myDouble = myDouble;
	}

	public long getMyLong()
	{
		return myLong;
	}

	public void setMyLong(long myLong)
	{
		this.myLong = myLong;
	}

	public char getMyChar()
	{
		return myChar;
	}

	public void setMyChar(char myChar)
	{
		this.myChar = myChar;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (Debug.getDebugValue() >= 1)
		{
			System.out.println("In equals Method of MyAllTypesFirst");

		}
		MyAllTypesFirst frst = (MyAllTypesFirst) obj;
		return ((this.myInt == frst.myInt) && (this.myString.equals(frst.myString)) && (this.myDouble == frst.myDouble)
				&& (this.myLong == frst.myLong) && (this.myChar == frst.myChar));
	}

	@Override
	public int hashCode()
	{
		if (Debug.getDebugValue() >= 1)
		{
			System.out.println("In hashCode Method of MyAllTypesFirst");

		}
		return (myInt * 13 + myString.hashCode() * 17 + (int) myDouble * 19 + (int) myLong * 23 + (int) myChar * 29);
	}

	@Override
	public String toString()
	{
		return getMyInt() + " " + getMyString() + " " + getMyDouble() + " " + getMyLong() + " " + getMyChar();
	}
}
