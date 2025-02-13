package saja;
//saja asfour
//1210737
//lab sec7
public class Course {
	//data field of the Course class
	private String name;//name has default value null
	private int Id;//Id has default value 0
	//default construct a Course object
	public Course() {
		
	}
	//non default construct a Course object
	public Course(String name,int Id) {
		this.Id=Id;
		setCourseName(name);//due to we have a condition for a char name(exactly 4 char)
	}
	//return the course name
	public String getCourseName() {
		return name;
	}
	//set the new course name that enter from a user 
	public void setCourseName(String name) {
		if(name.length()==4)//to have exactly 4 char name 
		this.name = name;
	}
	//return the id of the course
	public int getCourseID() {
		return Id;
	}
	//set a new course enter by the user 
	public void setCourseID(int Id) {
		this.Id= Id;
	}
	//print info for the Course class
	public void printInfo() {
		System.out.println("The course name is : "+name+"\nThe course ID is : "+Id);
	}
}
