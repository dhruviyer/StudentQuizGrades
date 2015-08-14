package diyer.apjava.studentquizgrades;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class StudentTester {
	
	/**
	 * @author Dhruv
	 * 
	 * In this class we create the GUI and interface with the rest of the program
	 */
	
	static JFrame mainFrame;
	static JButton addStudent;
	static JButton getStudentGradeReport;
	static JButton addQuiz;
	static JList roster;
	static JScrollPane scrollpane; 
	static Container contentPane;
		
	public static void main(String[] args) {
		
		//Student rosters
		Vector<Student> students = new Vector<Student>();
		Vector<String> studentNames = new Vector<String>();

		//format frame elements
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = mainFrame.getContentPane();
		contentPane.setLayout(new GridLayout(0,2));
		
		//initialize components
		roster = new JList<String>(studentNames);
		scrollpane = new JScrollPane(roster);
		addStudent = new JButton("Add a student");
		getStudentGradeReport = new JButton("Get student grade report");
		addQuiz = new JButton("Add Quiz Score");
		//add listeners
		addStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = JOptionPane.showInputDialog("Name?");
				students.addElement(new Student(temp));
				studentNames.add(temp);
				roster.updateUI();
				roster.setSelectedIndex(0);
			}
		});
		
		getStudentGradeReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float sum = 0;
				int count = 0 ;
				String output = "*******GRADE REPORT*******\nStudent: "+ studentNames.elementAt(roster.getSelectedIndex());
				for (QuizScore quiz : students.elementAt(roster.getSelectedIndex()).quizzes){
					output += "\n"+quiz.getName()+": "+quiz.getPercentScore()+"%";
					sum+=quiz.getPercentScore();
					count+=1;
				}
				output+="\n\nAverage Score: "+(sum/count)+"%";
				JOptionPane.showMessageDialog(null, output);
			}
		});
		
		addQuiz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempName = JOptionPane.showInputDialog("What is the name of this quiz?");
				float tempScore = Float.parseFloat(JOptionPane.showInputDialog("What did "+studentNames.elementAt(roster.getSelectedIndex())+" get on this quiz?"));
				students.elementAt(roster.getSelectedIndex()).addQuizScore(tempName, tempScore);
				JOptionPane.showMessageDialog(null, "Quiz added!");
			}
		});
		
		//add content
		contentPane.add(scrollpane);
		contentPane.add(addStudent);
		contentPane.add(getStudentGradeReport);
		contentPane.add(addQuiz);
		
		//show mainFrame
		mainFrame.setSize(640, 480);
		mainFrame.setVisible(true);
	}

}
