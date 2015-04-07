package setup;

import source.Voca;
import token.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	public static void getSynonyms(Word input) throws IOException{
		
		System.out.println("<Crawler>");
		
		String URL="http://www.thesaurus.com/browse/"+input.getWord()+"?s=t";
		Document file=Jsoup.connect(URL).get();
		
		System.out.println("What is your refered meaning of '"+input.getWord()+"'?");
		int choice=select(file);
		System.out.println("Your Choice is '"+choice+"'\n");
		
		collect(file,input.getPriority(),choice);
		
	}
	
	private static int select(Document file) throws IOException {
		
		Elements result=file.body().select("div.synonym-description > strong");
		ListIterator<Element> t=result.listIterator();
		
		int index=0;
		while(t.hasNext()){
			Element next=t.next();
			String heading=next.text();
			System.out.println((index++)+". "+heading);
		}
		
		System.out.print("\nWhich meaning do you refer to? ");
		Scanner stdIn=new Scanner(System.in);
		return stdIn.nextInt();
	}
	
	private static void collect(Document file,int priority,int choice){
		Elements relevent3=file.body().select("#synonyms-"+choice+" div.relevancy-list "
										+ "a[data-category*=relevant-3] span.text");
		ListIterator<Element> t=relevent3.listIterator();
		System.out.println("Priority= "+(priority-1));
		while(t.hasNext()){
			Element next=t.next();
			String synonym=next.text();
			System.out.println("relevent3: "+synonym);
			
			Voca.inseartWord(new Word(synonym,priority-1));
			
		}
		System.out.println();
		Elements relevent2=file.body().select("#synonyms-"+choice+" div.relevancy-list "
				+ "a[data-category*=relevant-2] span.text");
		t=relevent2.listIterator();
		System.out.println("Priority= "+(priority-2));
		while(t.hasNext()){
			Element next=t.next();
			String synonym=next.text();
			System.out.println("relevent2: "+synonym);
			
			Voca.inseartWord(new Word(synonym,priority-2));

		}
		return;
	}
	
}
