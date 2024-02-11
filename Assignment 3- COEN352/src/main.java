import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException  {
		new tool();
		new StringBuffer();
		BufferedReader f;
		f=new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
		GraphS G=new GraphS();
		tool.createGraph(f,G);
		
		CourseSequenceSolver c=new CourseSequenceSolver(G);
		System.out.println("Mamadou Diao Kaba (27070179) and Lifu Zhang (40081513)");
		System.out.println(c.getCourseSequence("COEN 352"));
		System.out.println(c.getCourseSequence("COEN 490"));
		System.out.println(c.getCourseSequence("COEN 346"));
		System.out.println(c.getPrerequisite("COEN 346"));
		System.out.println(c.isPrerequisite("COEN 352", "MATH 204"));
		System.out.println(c.isPrerequisite("COEN 231", "COEN 352"));
		String[] courseSequence1 = {"MATH 204", "COEN 390", "COEN 311"};
		boolean isValidSequence1 = c.getCourseSequence(courseSequence1);
		System.out.println("Is the first sequence valid? " + isValidSequence1);

		String[] courseSequence2 = {"MATH 204", "COEN 231", "COEN 243", "COEN 244", "COEN 352"};
		boolean isValidSequence2 = c.getCourseSequence(courseSequence2);
		System.out.println("Is the second sequence valid? " + isValidSequence2);
	}
	
}
