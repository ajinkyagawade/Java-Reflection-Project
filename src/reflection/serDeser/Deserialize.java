package reflection.serDeser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

import reflection.util.Debug;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;

public class Deserialize
{
	public static ArrayList<Object> objectList = new ArrayList<Object>();
	private static ArrayList<Object> objectListFrst = new ArrayList<Object>();
	private static ArrayList<Object> objectListSnd = new ArrayList<Object>();

	public static ArrayList<Object> getObjectListFrst()
	{
		return objectListFrst;
	}

	public static void setObjectListFrst(ArrayList<Object> objectListFrst)
	{
		Deserialize.objectListFrst = objectListFrst;
	}

	public static ArrayList<Object> getObjectListSnd()
	{
		return objectListSnd;
	}

	public static void setObjectListSnd(ArrayList<Object> objectListSnd)
	{
		Deserialize.objectListSnd = objectListSnd;
	}

	/**
	 * 
	 * @return void
	 */
	public void deserializeFile(String fileName)
	{

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int i = 0;
			String parts[];
			String parts1[];
			String parts2[];
			String parts3[];
			String parts4[];

			String tag;
			String val;
			String type;
			String className;
			String methodName;
			while ((line = br.readLine()) != null)
			{
				line = line.trim();
				if (line.equals("") || line.equals("</complexType>") || line.equals("</DPSerialization>"))
					continue;
				if (line.equals("<DPSerialization>"))
				{
					line = br.readLine().trim();
					if (line.contains("reflection.util.MyAllTypesFirst"))
					{
						parts = line.split("\"");
						className = parts[1].trim();
						Class<?> cls = Class.forName(className);
						Object obj = cls.newInstance();
						Method method;
						for (i = 0; i < 5; i++)
						{
							line = br.readLine().trim();
							parts1 = line.split(" ");
							parts1[0] = parts1[0].trim();
							tag = parts1[0].replace("<", "");
							parts2 = line.split("\"");
							type = parts2[1].trim();
							type = type.replace("xsd:", "");
							parts3 = line.split(">");
							parts4 = parts3[1].trim().split("<");
							val = parts4[0].trim();
							methodName = "set" + Character.toUpperCase(tag.charAt(0)) + tag.substring(1);

							// System.out.println(tag + " " + type + " " + val);

							if (type.equalsIgnoreCase("int"))
							{
								method = cls.getDeclaredMethod(methodName, int.class);
								int intVal = Integer.parseInt(val);
								method.invoke(obj, intVal);
							}
							else if (type.equalsIgnoreCase("string"))
							{
								method = cls.getDeclaredMethod(methodName, String.class);
								method.invoke(obj, val);
							}
							else if (type.equalsIgnoreCase("double"))
							{
								method = cls.getDeclaredMethod(methodName, double.class);
								double doubleVal = Double.parseDouble(val);
								method.invoke(obj, doubleVal);
							}
							else if (type.equalsIgnoreCase("long"))
							{
								method = cls.getDeclaredMethod(methodName, long.class);
								long longVal = Long.parseLong(val);
								method.invoke(obj, longVal);
							}
							else if (type.equalsIgnoreCase("char"))
							{
								method = cls.getDeclaredMethod(methodName, char.class);
								char c = val.charAt(0);
								method.invoke(obj, c);
							}

						}

						objectListFrst.add(obj);
						objectList.add(obj);

					}
					else if (line.contains("reflection.util.MyAllTypesSecond"))
					{
						parts = line.split("\"");
						className = parts[1].trim();
						Class<?> cls2 = Class.forName(className);
						Object obj2 = cls2.newInstance();
						Method method;
						for (i = 0; i < 5; i++)
						{
							line = br.readLine().trim();
							parts1 = line.split(" ");
							parts1[0] = parts1[0].trim();
							tag = parts1[0].replace("<", "");
							parts2 = line.split("\"");
							type = parts2[1].trim();
							type = type.replace("xsd:", "");
							parts3 = line.split(">");
							parts4 = parts3[1].trim().split("<");
							val = parts4[0].trim();

							// System.out.println(tag + " " + type + " " + val);

							if (type.equalsIgnoreCase("int"))
							{
								method = cls2.getDeclaredMethod("setMyIntS", int.class);
								int intVal = Integer.parseInt(val);
								method.invoke(obj2, intVal);
							}
							else if (type.equalsIgnoreCase("string"))
							{
								method = cls2.getDeclaredMethod("setMyStringS", String.class);
								method.invoke(obj2, val);
							}
							else if (type.equalsIgnoreCase("float"))
							{
								method = cls2.getDeclaredMethod("setMyFloatS", float.class);
								float floatVal = Float.parseFloat(val);
								method.invoke(obj2, floatVal);
							}
							else if (type.equalsIgnoreCase("short"))
							{
								method = cls2.getDeclaredMethod("setMyShortS", short.class);
								short shortVal = Short.parseShort(val);
								method.invoke(obj2, shortVal);
							}
							else if (type.equalsIgnoreCase("char"))
							{
								method = cls2.getDeclaredMethod("setMyCharS", char.class);
								char c = val.charAt(0);
								method.invoke(obj2, c);
							}

						}

						objectListSnd.add(obj2);
						objectList.add(obj2);

					}
				}
			}
			br.close();
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}

	}

	/**
	 * 
	 * @return void
	 */
	public void checkEqual()
	{
		int i = 0, j = 0;
		int size1 = objectListFrst.size();
		int size2 = objectListSnd.size();

		for (i = 0; i < objectListFrst.size(); i++)
		{
			MyAllTypesFirst frst1 = (MyAllTypesFirst) objectListFrst.get(i);
			for (j = i + 1; j < objectListFrst.size(); j++)
			{

				MyAllTypesFirst frst2 = (MyAllTypesFirst) objectListFrst.get(j);
				if (frst1.equals(frst2))
				{
					size1--;
					break;
				}

			}
		}

		for (i = 0; i < objectListSnd.size(); i++)
		{
			MyAllTypesSecond snd1 = (MyAllTypesSecond) objectListSnd.get(i);
			for (j = i + 1; j < objectListSnd.size(); j++)
			{
				MyAllTypesSecond snd2 = (MyAllTypesSecond) objectListSnd.get(j);
				if (snd1.equals(snd2))
				{
					size2--;
					break;
				}

			}
		}

		if (Debug.getDebugValue() >= 0)
		{
			System.out.println("Unique MyAllTypesFirst=" + size1);
			System.out.println("Unique MyAllTypesSecond=" + size2);
		}

	}

}
