import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", "/c", "netsh wlan start hostednetwork");
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) { break; }
				System.out.println(line);
				
			}
				
	}
	
	
}
