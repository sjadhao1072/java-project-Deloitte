package hashmapPackage;
import java.util.*;
public class StudentDao {
	private Map<Integer,Student> mapstudent;
	private Scanner sc;
	public StudentDao()
	{
		sc=new Scanner(System.in);
		mapstudent=new HashMap<>();
	}
	public void insertStudent()
	{
		System.out.println("Enter no of students");
		int noofstudent=sc.nextInt();
		for(int x=1;x<=noofstudent;x++)
		{
			Student s=new Student();
			System.out.println("Enter Student id ");
			int studentid=sc.nextInt();
			s.setStudentCode(noofstudent);
			System.out.println("Enter Student Name");
			s.setStudentName(sc.next());
			System.out.println("Enter score");
			s.setScore(sc.nextInt());
			mapstudent.put(studentid, s);
		}
	}
	public void deleteStudent()
	{
		System.out.println("Enter student Id to delete ");
		int studentId = sc.nextInt();
		mapstudent.remove(studentId);
		
	}
	public void updateStudent()
	{
		System.out.println("Enter student Id to update ");
		int studentId = sc.nextInt();
		Student studObj =  mapstudent.get(studentId);
		System.out.println("Enter new score");
		studObj.setScore(sc.nextInt());
	}
	public void displayData()
	{
		
		Set<Map.Entry<Integer, Student>> mapset=mapstudent.entrySet();
		for(Map.Entry<Integer, Student> maps:mapset)
		{
			System.out.println("Key is "+maps.getKey());
			Student s=maps.getValue();
			System.out.println("Student Name is "+s.getStudentName());
			System.out.println("Score is "+s.getScore());
			
		}
	}
	
 
}
 
