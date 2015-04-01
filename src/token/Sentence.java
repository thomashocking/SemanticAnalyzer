package token;

import java.util.ArrayList;
import source.Voca;

public class Sentence {
	private String origin;
	private ArrayList<Word> words;
	private int priority;
	
	public Sentence(String sentence){
		origin=sentence;
		words=this.createWords();
		priority=this.calPriority();
	}
	
	private ArrayList<Word> createWords(){
		ArrayList<Word> temp=new ArrayList<Word>();
		//tokenize the origin sentence into words
		String[] tokens=origin.split(" ");
		for(String token:tokens){
			temp.add(new Word(token));
		}
		return temp;
	}
	
	//TODO:
	//duplicated words are not counted!!
	private int calPriority(){
		for(int index=0;index<words.size();index++){
			if(Voca.findWord(words.get(index))){
				priority+=words.get(index).getPriority();
			}
		}
		if(priority>0)
			System.out.println("priority: "+priority+"\n"+origin);
		return priority;
	}
	
	public int getPriority(){
		return priority;
	}
	
	@Override
	public String toString(){
			return origin.trim()+".\n";
	}
}
