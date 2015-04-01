package source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ProcessText {
	public static String getString(){
		String text="";
		Scanner stdIn=new Scanner(System.in);
		System.out.print("Where is the file? ");
		try {
			Scanner file=new Scanner(new FileReader(stdIn.nextLine()));
			while(file.hasNextLine()){
				text+=file.nextLine();
			}
		} catch (FileNotFoundException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
}
