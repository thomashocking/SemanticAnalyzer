package source;

import token.Sentence;
import java.util.ArrayList;

public class ParseSource {
	ArrayList<Sentence> sentences;
	
	public ParseSource(String text){
		System.out.println("<ParseSource>");
		sentences=this.parseText(text);
		this.sort();
	}
	
	protected ArrayList<Sentence> parseText(String text){
		ArrayList<Sentence> temp=new ArrayList<Sentence>();
		String[] sentence=text.split("\\.");
		for(String s:sentence){
			temp.add(new Sentence(s));
		}
		return temp;
	}
	public void sort(){
		for(int index=1; index<sentences.size();index++){
			Sentence temp=sentences.get(index);
			int aux=index-1;
			while((aux>=0)&&(sentences.get(aux).getPriority()<temp.getPriority())){
				sentences.set(aux+1, sentences.get(aux));
				aux--;
			}
			sentences.set(aux+1, temp);
		}
	}
	@Override
	public String toString(){
		String temp="";
		for(Sentence s:sentences){
			if(s.getPriority()>0)
				temp+=s.toString();
		}
		return temp;
	}
}
