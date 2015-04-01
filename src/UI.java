import source.ParseSource;
import source.ProcessText;
import source.Voca;
import token.Word;

public class UI {
	public static void main(String[] args){
		
		Voca.inseartWord(new Word("illegal",100));
		Voca.inseartWord(new Word("limited",3));
		Voca.inseartWord(new Word("right",1));
		
		String text=ProcessText.getString();
		ParseSource source=new ParseSource(text);
		System.out.println(source.toString());
		
		Voca.deleteWord(new Word("illegal",5));
		Voca.deleteWord(new Word("limited",3));
		Voca.deleteWord(new Word("right",1));
	}
}
