package token;

public class Word {
	private int priority;
	private String word;
	
	public Word(String input){
		this.word=this.trimWord(input);
		this.priority=0;
		
	}
	
	private String trimWord(String input){
		String temp="";
		for(int index=0; index<input.length();index++){
			if((input.charAt(index)>='a'&&input.charAt(index)<='z')
			||(input.charAt(index)>='A'&&input.charAt(index)<='Z')){
				temp+=input.charAt(index);
			}
		}
		return temp;
	}
	
	public Word(String input,int num){
		this.word=input;
		this.priority=num;
	}
	
	public void setPriority(int i){
		priority=i;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public String getWord(){
		return word;
	}
	
	public boolean equals(String text){
		return this.word.equalsIgnoreCase(text);
	}
}
