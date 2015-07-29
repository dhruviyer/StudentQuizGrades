package diyer.apjava.studentquizgrades;

public class QuizScore{
	private String name;
	private float percentScore;
	
	public QuizScore(String aName, float aScore){
		name = aName;
		percentScore = aScore;
	}
	
	public String getName(){
		return name;
	}
	
	public float getScore(){
		return percentScore;
	}
	
	public void setName(String quizName){
		name = quizName;
	}
	
	public void setScore(String quizName){
		name = quizName;
	}
}
