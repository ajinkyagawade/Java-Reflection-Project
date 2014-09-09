package reflection.serDeser;

import java.io.BufferedWriter;

public interface Strategy
{
	public void serialize(BufferedWriter bw, Object o);

}
