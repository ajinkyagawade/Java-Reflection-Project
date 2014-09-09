package reflection.serDeser;

import java.io.BufferedWriter;

import reflection.util.Debug;
import reflection.util.MyAllTypesSecond;

public class StrategySecond implements Strategy
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
				System.out.println("In serialize method of StrategySecond");
			}
			MyAllTypesSecond snd = (MyAllTypesSecond) o;
			String content = "<DPSerialization>" + "\n" + " <complexType xsi:type=\"reflection.util.MyAllTypesSecond\">" + "\n";

			content = content + "  <myIntS xsi:type=\"xsd:int\">" + snd.getMyIntS() + "</myIntS>" + "\n";
			content = content + "  <myStringS xsi:type=\"xsd:string\">" + snd.getMyStringS() + "</myStringS>" + "\n";
			content = content + "  <myFloatS xsi:type=\"xsd:float\">" + snd.getMyFloatS() + "</myFloatS>" + "\n";
			content = content + "  <myShortS xsi:type=\"xsd:short\">" + snd.getMyShortS() + "</myShortS>" + "\n";
			content = content + "  <myCharS xsi:type=\"xsd:char\">" + snd.getMyCharS() + "</myCharS>" + "\n";
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
