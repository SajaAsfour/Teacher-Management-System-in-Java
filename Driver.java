package saja;
//saja asfour
//1210737
//lab sec7
import java.util.Scanner;
//class to test the program
public class Driver {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter number of teachers");//ask the user to enter the number of teacher
		int num=in.nextInt();//read the number of teacher that user enter it
		Teacher []t=new Teacher[num];/*array of teacher with size=num where num enter by user as number of teachers
		where t is an object of class Teacher
		*/
		//fill the array(t):
		for(int i=0;i<t.length;i++) {
			//ask the user to enter Enter teacher’s name, id, basic salary, and extra payment rate:
			System.out.println("Enter teachers name, id, basic salary, and extra payment rate for teacher NO "+(i+1));
			// read the date for teacher number (i+1):
			String name=in.next();
			int id=in.nextInt();
			double basicSalary=in.nextDouble();
			double extraPayment=in.nextDouble();
			//ask the user to enter number of course that teacher number (i+1)taught it:
			System.out.println("Enter number of courses teacher NO "+(i+1)+" taught");
			//read the number of course:
			int number=in.nextInt();
			//make an array of object from class Course:
			Course []c=new Course[number];
			//fill the array of course:
			for(int k=0;k<c.length;k++) {
				//ask the user to enter name and id for the course:
				System.out.println("Enter name (from 4char) and id for Course No "+(k+1));
				//read the data for course:
				String Name=in.next();
				int Id=in.nextInt();
				c[k]=new Course(Name,Id);
			}
			t[i]=new Teacher(name,id,basicSalary,extraPayment,c);
		}
		System.out.println("The information was fill");
		int op=0;
		do {
		System.out.println("Choise operation you want to do from 1 to 5:");
		//1-displays all attributes and their values for a teacher based on his/her id entered by the user:
		System.out.println("1-Print Teacher Information: ");
		//2-displays the name of each teacher and his/her total salary:
		System.out.println("2-Display teachers total salaries: ");
		//3-Allows the user to enter a teacher’s id number and then modify his/her basic salary:
		System.out.println("3-Change basicSalary for a teacher: ");
		//4-Displays the sum of all total Salaries for all teachers:
		System.out.println("4-Display sum of Total Salaries:  ");
		//5-End the program:
		System.out.println("5- Exit: ");
		 op=in.nextInt();
		 switch(op) {
		 case 1://1-displays all attributes and their values for a teacher based on his/her id entered by the user:
			    System.out.println("Enter the ID of the teacher you want to know his/her Info:");
		 		int id=in.nextInt();//read id that user want to search
		 		int valid=0;//use as counter to know the id does not exist(valid)
		 		//loop to find the teacher have the id that user enter it:
		 		for(int j=0;j<t.length;j++) {
		 			if(t[j].getTeacherId()==id) 
		 				t[j].printInfo();//if the id exist print the info for teacher with this id 
		 			else
		 				valid++;//if id does not exist increment
		 			}
		 		if(valid==num)//check if the valid equal to the number of teacher entered by user
		 			System.out.println("This id is valid, try again");
		 		break;
		 case 2://2-displays the name of each teacher and his/her total salary:
			     for(int k=0;k<t.length;k++) {
			 	 double totalSalary=t[k].getBasicSalary()+t[k].calculateExtraPayment();
			 	 System.out.println("The teacher NO "+(k+1)+" has total salary= "+totalSalary);
		 		}
		 		break;
		 case 3://3-Allows the user to enter a teacher’s id number and then modify his/her basic salary:
			    System.out.println("Enter the ID of the teacher you want to modify his/her basic salary:");
	 			int ID=in.nextInt();//read id that user want to modify his/her basic salary
	 			int validId=0;
	 			for(int x=0;x<t.length;x++) {
	 				if(t[x].getTeacherId()==ID) {
	 					//if the id enter by user is Existing make this:
	 					System.out.println("Enter new basic Salary:");
	 					double newBasicSalary=in.nextDouble();
	 					t[x].setBasicSalary(newBasicSalary);//here we modify the basic salary
	 					System.out.println("The basic salary is change");
	 				}
		 			else 
		 				validId++;//if id does not exist increment
	 				}
	 			if(validId==num)//check if the validId equal to the number of teacher entered by user
	 			System.out.println("This ID is Valid");
	 			break;
		 case 4://4-Displays the sum of all total Salaries for all teachers:
			     double sum=0;
		 		 for(int s=0;s<t.length;s++) {
		 			 double totalSalary=t[s].getBasicSalary()+t[s].calculateExtraPayment();
		 			 sum=sum+totalSalary;
		 		 }
		 		 System.out.println("The sum of total salary is: "+sum);
		 		 break;
		 case 5://5-End the program:
			   System.out.println(" The program End,Good BYE");

			 break;
		default: System.out.println("Try again with new number in list");//use it when user enter number not from (1-5)
			break;
		 }
		 }while(op!=5);//the menu should keep print until the user selects 5 (Exit )
		in.close();
		}

}
