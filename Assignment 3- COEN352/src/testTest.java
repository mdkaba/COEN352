import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class testTest {static String Out;

@BeforeEach
public void setUp()
{
  Out = null;
}


@Test
public void testgetCourseSequence() throws IOException {
	
	try {
    	new tool();
        new StringBuffer();
    	BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
        GraphS G = new GraphS();
        CourseSequenceSolver c = new CourseSequenceSolver(tool.createGraph(f, G));
        Out = c.getCourseSequence("COEN 490");
        System.out.println(Out);

        assertEquals(Out, "MATH 204  ENGR 301  ENGR 371  ENCS 282  COEN 212  "
                + "COEN 231  COEN 243  ENGR 290  SOEN 341  "
                + "COEN 244  COEN 311  COEN 352  COEN 390  COEN 490  ");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Test
public void testGetPrerequisite() {

    try {
    	new tool();
        new StringBuffer();
    	BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
        GraphS G = new GraphS();
        CourseSequenceSolver c = new CourseSequenceSolver(tool.createGraph(f, G));

        Out = c.getPrerequisite("COEN 490");
        assertEquals(Out, "SOEN 341 ENGR 301 ENGR 371 COEN 390");

        Out = c.getPrerequisite("COEN 352");
        assertEquals(Out, "COEN 231 COEN 244");

    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Test
public void testIsPrerequisite() {

    try {
    	new tool();
    	new StringBuffer();
    	BufferedReader f;
    	f = new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
        GraphS G = new GraphS();
        CourseSequenceSolver c = new CourseSequenceSolver(tool.createGraph(f, G));

        assertTrue(c.isPrerequisite("COEN 231", "COEN 352"));
        assertTrue(c.isPrerequisite("COEN 244", "COEN 352"));
        assertFalse(c.isPrerequisite("COEN 490", "COEN 212"));

    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Test
public void testIsCourseSequenceValid() {

    try {
    	new tool();
        new StringBuffer();
    	BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
        GraphS G = new GraphS();
        CourseSequenceSolver c = new CourseSequenceSolver(tool.createGraph(f, G));

        assertTrue(c.getCourseSequence(new String[]{"MATH 204", "COEN 212", "COEN 243", "COEN 311"}));
        assertTrue(c.getCourseSequence(new String[]{"MATH 204", "COEN 231", "COEN 243", "COEN 244", "COEN 352"}));
        assertFalse(c.getCourseSequence(new String[]{"MATH 204", "COEN 311", "COEN 243", "COEN 212"}));

    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
