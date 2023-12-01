package hust.soict.hedspi.garbage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Garbage01 {
	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\84355\\Desktop\\Code\\OOLT.VN.20231-20215038.PhanTrungDuc\\Answer .txt";
		byte[] inputBytes = {0};
		long startTime, endtime;

		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		// String outputString = "";		
		// StringBuffer outputString = new StringBuffer();
		StringBuilder outputString = new StringBuilder();
		for (byte b: inputBytes){
			// outputString += (char)b;
			outputString.append((char)b);
		}
		endtime = System.currentTimeMillis();
		System.out.println(endtime - startTime);

	}
}