package watchdog.temp;

import java.io.*;

public class temp_check {

	private float temprature = 0;

	public void temp_check() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		InputStream stdout = null;
		String[] cmd = {"/opt/vc/bin/vcgencmd", "measure_temp"};
		String[] ret;
		String s = null;

		try {
			processBuilder.command(cmd);
			Process process = processBuilder.start();
			stdout = process.getInputStream();
			BufferedReader out = new BufferedReader(new InputStreamReader(stdout));
			s = out.readLine();
			this.temprature = Float.parseFloat(s.replaceAll("[^\\d.]", ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public float get_temp() {
		return this.temprature;
	}

}
