package source;

import java.sql.ResultSet;
import java.sql.SQLException;

import token.Word;

public class Voca {
	
	public static DB db=new DB();
	
	public static boolean findWord(Word target){
		boolean exist=false;
		String sql = "SELECT word, priority FROM words WHERE word ='"+target.getWord()+"';";
		try {
			ResultSet words=db.getResultSet(sql);
			if(words.next()){
				target.setPriority(words.getInt("priority"));
				exist=true;
			}
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}
	
	public static void inseartWord(Word input){
		String sql="INSERT INTO words (word, priority) VALUES ('"+input.getWord()+"', '"+input.getPriority()+"');";
		try {
			db.executeSql(sql);
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteWord(Word input){
		String sql="DELETE FROM words WHERE word='"+input.getWord()+"';";
		try {
			db.executeSql(sql);
		} catch (SQLException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
	}
}
