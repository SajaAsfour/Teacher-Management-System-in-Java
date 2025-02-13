package saja;
//saja asfour
//1210737
//labsec 7
public class Teacher {
	//data field of the Teacher class
	private String name;
	private int id;
	private double 	basicSalary ;
	private double extraPaymentRate ;
	private Course[] coursesTaught ;// an array of object from Course class
	//default construct a Teacher object
	public Teacher() {
		
	}
	//non default construct a Teacher object
	public Teacher(String name, int id, double basicSalary, double extraPaymentRate, Course[] coursesTaught) {
		this.name = name;
		this.id = id;
		this.basicSalary = basicSalary;
		this.extraPaymentRate = extraPaymentRate;
		this.coursesTaught = coursesTaught;
	}
	//return the teacher name
	public String getTeacherName() {
		return name;
	}
	//set the new teacher name enter from a user
	public void setTeacherName(String name) {
		this.name = name;
	}
	//return the teacher id
	public int getTeacherId() {
		return id;
	}
	//set the new id enter from the user
	public void setTeacherId(int id) {
		this.id = id;
	}
	//return the basic salary for the teacher
	public double getBasicSalary() {
		return basicSalary;
	}
	//set a new basic salary
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	//return the extraPaymentRate for teacher
	public double getExtraPaymentRate() {
		return extraPaymentRate;
	}
	//set new ExtraPaymentRate that enter by user
	public void setExtraPaymentRate(double extraPaymentRate) {
		this.extraPaymentRate = extraPaymentRate;
	}
	//return array of course called coursesTaught
	public Course[] getCoursesTaught() {
		return coursesTaught;
	}
	//set a new courseTaught
	public void setCoursesTaught(Course[] coursesTaught) {
		this.coursesTaught = coursesTaught;
	}
	//print the teacher class info
	public void printInfo() {
		System.out.println("The Teacher name is: "+name+"\nThe Teacher ID is: "+id+"\nThe basic salary= "+basicSalary);
		System.out.println("The ExtraPaymentRate= "+extraPaymentRate);
		int count=0;
		for(count=0;count<coursesTaught.length;count++) {//we use loop due to the array(to print array info)
			coursesTaught[count].printInfo();
		}
	}
	
	//function to find number of course that are in the same level(1,2,3,4)
	public int countCourseLevel(int levelNo) {
		int num=0;//to count the num of course that are in that in the same level
		int firstdigit=0;//use to compare it with number of level user want 
		for(int i=0;i<coursesTaught.length;i++) {
			int id =coursesTaught[i].getCourseID();
			//find the first digit from id :
			while(id!=0) {
				firstdigit=id%10;
				id/=10;
				}
				if(firstdigit==levelNo)//compare the first digit with levelNo enter by user , if it equal increment the num of course
					num++;
		}
		return num;//return the number of course in level that user want
	}
	//function to find the extra payment rate give for the teacher
	public double calculateExtraPayment() {
		double extrapayment=0;
		for(int i=1;i<=4;i++) {
			extrapayment+=(countCourseLevel(i)*i*extraPaymentRate);//to calculate the extrapaymentrate for the teacher
		}
		return extrapayment;
	}
}
