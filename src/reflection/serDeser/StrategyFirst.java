package reflection.serDeser;

import java.io.BufferedWriter;

import reflection.util.Debug;
import reflection.util.MyAllTypesFirst;

public class StrategyFirst implements Strategy
{

	/**
	 * 
	 * @return void
	 */
	@Override
	public void serialize(BufferedWriter bw, Object o)
	{

		try
		{
			if (Debug.getDebugValue() >= 2)
			{
				System.out.println("In serialize method of StrategyFirst");
			}
			MyAllTypesFirst frst = (MyAllTypesFirst) o;
			String content = "<DPSerialization>" + "\n" + " <complexType xsi:type=" + "\"reflection.util.MyAllTypesFirst\">"
					+ "\n";

			content = content + "  <myInt xsi:type=\"xsd:int\">" + frst.getMyInt() + "</myInt>" + "\n";
			content = content + "  <myString xsi:type=\"xsd:string\">" + frst.getMyString() + "</myString>" + "\n";
			content = content + "  <myDouble xsi:type=\"xsd:double\">" + frst.getMyDouble() + "</myDouble>" + "\n";
			content = content + "  <myLong xsi:type=\"xsd:long\">" + frst.getMyLong() + "</myLong>" + "\n";
			content = content + "  <myChar xsi:type=\"xsd:char\">" + frst.getMyChar() + "</myChar>" + "\n";
			content = content + " </complexType>" + "\n" + "</DPSerialization>" + "\n";

			bw.write(content);
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}

	}

}
