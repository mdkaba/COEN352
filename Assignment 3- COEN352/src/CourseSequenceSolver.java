import java.io.*;
import java.util.*;

public class CourseSequenceSolver  {
	public GraphS subGraph;
	public StringBuffer out=new StringBuffer() ;
	public Maps m=new Maps();
	public GraphS mainGraph;
	
	static final int UNVISITED = 0;
	static final int VISITED = 1;
	
	CourseSequenceSolver(GraphS g)
	{
		mainGraph=g;
		subGraph=new GraphS (g.n());
	}
	public CourseSequenceSolver() {
		// TODO Auto-generated constructor stub
	}
	public void GetSubGraph(String s)
	{	
		
		int x=m.getCourseMark(s);
		subGraph.Mark[x]=1;
		for (int w = mainGraph.firstIn(x); w < mainGraph.n();w = mainGraph.nextIn(x, w))
		{
			subGraph.Mark[w]=1;
			GetSubGraphHelper(w);
		}
	}
	
	
	public void GetSubGraphHelper(int x)
	{
		for (int w = mainGraph.firstIn(x); w < mainGraph.n();w = mainGraph.nextIn(x, w))
		{
			subGraph.Mark[w]=1;
			GetSubGraphHelper(w);
		}
	}
	
	 public String getPrerequisite(String courseCode) {
	        // Ensure the provided courseCode is valid
	        int courseIndex = m.getCourseMark(courseCode);
	        if (courseIndex == Integer.MAX_VALUE) {
	            return "Invalid CourseCode";
	        }

	        // Use BFS to find direct prerequisites
	        StringBuilder prerequisites = new StringBuilder();
	        Queue<Integer> queue = new ArrayDeque<>();
	        int[] visited = new int[mainGraph.n()];

	        // Enqueue the current course index
	        queue.add(courseIndex);
	        visited[courseIndex] = 1;

	        while (!queue.isEmpty()) {
	            int currentCourse = queue.poll();

	            // Iterate over the neighbors (prerequisites)
	            for (int neighbor = mainGraph.firstIn(currentCourse); neighbor < mainGraph.n(); neighbor = mainGraph.nextIn(currentCourse, neighbor)) {
	                // Check if the neighbor hasn't been visited
	                if (visited[neighbor] == 0) {
	                    visited[neighbor] = 1;
	                    queue.add(neighbor);

	                    // Only include direct prerequisites
	                    if (currentCourse == courseIndex) {
	                        String prerequisiteCourse = m.getCourseName(neighbor);
	                        prerequisites.append(prerequisiteCourse).append(" ");
	                    }
	                }
	            }
	        }

	        return prerequisites.toString().trim();
	    }

	 public String getCourseSequence(String courseCode) {
		    out = new StringBuffer();
		    GetSubGraph(courseCode);
		    Queue<Integer> Q = new ArrayDeque<>(mainGraph.n());
		    int[] Count = new int[mainGraph.n()];
		    int v, w;
		    
		    // Initialize Count array
		    for (v = 0; v < mainGraph.n(); v++)
		        Count[v] = 0;
		    
		    // Count prerequisites for each node
		    for (v = 0; v < mainGraph.n(); v++)
		        for (w = mainGraph.first(v); w < mainGraph.n(); w = mainGraph.next(v, w))
		            Count[w]++;
		    
		    // Initialize queue with vertices having no prerequisites
		    for (v = 0; v < mainGraph.n(); v++)
		        if (Count[v] == 0)
		            Q.add(v);
		    
		    while (!Q.isEmpty()) {
		        v = Q.remove().intValue();
		        
		        if (subGraph.Mark[v] == 1) {
		            out.append(m.getCourseName(v)).append("  ");
		            if (m.getCourseName(v).equals(courseCode)) {
		                // Stop traversal when the specified course code is reached
		                break;
		            }
		        }
		        
		        for (w = mainGraph.first(v); w < mainGraph.n(); w = mainGraph.next(v, w)) {
		            Count[w]--;
		            if (Count[w] == 0)
		                Q.add(w); // enqueue the next level vertex
		        }
		    }
		    
		    return out.toString();
		}
	 
	 
	 public boolean isPrerequisite(String sourceCourse, String destinationCourse )
	 {
		 String temp=getPrerequisite(destinationCourse);
		 if(temp.contains(sourceCourse))return true;
		 else return false;
		 
	 }
	 
	    public boolean getCourseSequence(String[] courseSequence) {
	        // Check if the provided course sequence is valid
	        for (String course : courseSequence) {
	            int courseIndex = m.getCourseMark(course);
	            if (courseIndex == Integer.MAX_VALUE) {
	                return false; // Invalid courseCode in the sequence
	            }
	        }

	        // Iterate through the course sequence and check prerequisites
	        for (int i = 1; i < courseSequence.length; i++) {
	            String currentCourse = courseSequence[i];

	            // Check if any of the prerequisites is satisfied
	            boolean prerequisitesSatisfied = false;
	            for (int j = 0; j < i; j++) {
	                String prerequisiteCourse = courseSequence[j];
	                if (isPrerequisite(prerequisiteCourse, currentCourse)) {
	                    prerequisitesSatisfied = true;
	                    break;
	                }
	            }

	            if (!prerequisitesSatisfied) {
	                return false; // Prerequisites not satisfied
	            }
	        }

	        return true; // All prerequisites are satisfied for the entire sequence
	    }

}
