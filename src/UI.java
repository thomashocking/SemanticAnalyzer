import java.io.IOException;

import source.ParseSource;
import source.ProcessText;
import source.Voca;
import token.Word;
import setup.Crawler;

public class UI {
	public static void main(String[] args){
		
		Voca.clearWord();
		try {
			Crawler.getSynonyms(new Word("right",3));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String text=ProcessText.getString();
		ParseSource source=new ParseSource(text);
		System.out.println(source.toString());
		
		Voca.clearWord();
	}
}
