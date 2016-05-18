import java.io.*;

public class Nuke2 {

	public static void main(String[] args) throws Exception{
		// read input
		BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
		String keybdInput = keybd.readLine();
		
		// delete char
		StringBuilder sb = new StringBuilder(keybdInput);
		sb.deleteCharAt(1);
		String resultString = sb.toString();
		
		// print result
		System.out.println(resultString);
	}

}
