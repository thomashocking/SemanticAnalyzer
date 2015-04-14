package source;

import token.Paragraph;
import token.Sentence;
import java.util.ArrayList;

public class ParseSource {
	ArrayList<Paragraph> paragraphs;
	
	public ParseSource(ArrayList<String> temp){
		paragraphs=this.createParagraph(temp);
		this.sort();
	}
	
	protected ArrayList<Paragraph> createParagraph(ArrayList<String> texts){
		ArrayList<Paragraph> temp=new ArrayList<Paragraph>();
		int num=1;
		for(String text:texts){
			temp.add(new Paragraph(text,num++));
		}
		return temp;
	}
	
	public void sort(){
		for(int index=1; index<paragraphs.size();index++){
			Paragraph temp=paragraphs.get(index);
			int aux=index-1;
			while((aux>=0)&&(paragraphs.get(aux).getPriority()<temp.getPriority())){
				paragraphs.set(aux+1, paragraphs.get(aux));
				aux--;
			}
			paragraphs.set(aux+1, temp);
		}
	}
	@Override
	public String toString(){
		String temp="";
		for(Paragraph p:paragraphs){
			if(p.getPriority()>0)
				temp+=p.toString();
		}
		return temp;
	}
}
