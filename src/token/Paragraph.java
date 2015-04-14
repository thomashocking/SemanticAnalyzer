package token;

import java.util.ArrayList;

public class Paragraph {
	private ArrayList<Sentence> sentences;
	private int priority;
	private int number;
	
	public Paragraph(String text,int num){
		sentences=this.parseText(text);
		priority=this.collectPriority();
		number=num;
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
	
	protected int collectPriority(){
		int temp=0;
		for(Sentence s: sentences){
			temp+=s.getPriority();
		}
		return temp;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	@Override
	public String toString(){
		String temp="\n\t"+ number +"-Paragraph: "+priority+"\n";
		for(Sentence s:sentences){
			if(s.getPriority()>0)
				temp+=s.toString();
		}
		return temp+"\n";
	}
}
