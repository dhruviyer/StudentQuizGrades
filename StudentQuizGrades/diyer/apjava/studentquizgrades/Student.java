package diyer.apjava.studentquizgrades;

import java.util.Vector;

public class Student {
	String name;
	Vector<QuizScore> quizzes = new Vector<>();
	
	public Student(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addQuizScore(String name, float score){
		quizzes.addElement(new QuizScore(name, score));
	}
	
	public float getQuizScore(int index){
		return quizzes.get(index).getPercentScore();
	}
	
}
