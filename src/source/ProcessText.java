package source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ProcessText {
	public static ArrayList<String> getString(){
		System.out.println("\n<ProcessText>");
		ArrayList<String> text=new ArrayList<String>();
		Scanner stdIn=new Scanner(System.in);
		System.out.print("Where is the file? ");
		try {
			Pattern p=Pattern.compile("\n");
			Scanner file=new Scanner(new FileReader(stdIn.nextLine()));
			file.useDelimiter(p);
			while(file.hasNext()){
				String temp=file.next();
				text.add(temp);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;
	}
}
