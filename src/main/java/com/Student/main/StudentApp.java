
	package com.Student.main;

	import java.util.Iterator;
	import java.util.List;
	import java.util.Scanner;

	import com.Student.DAO.StudentDAO;
	import com.Student.DAO.StudentDAOImp;
	import com.Student.DTO.Student;

	public class StudentApp {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp();
		System.out.println("=====student info=====");
		System.out.println("Enter 1 to insert data");
		System.out.println("Enter 2 to update data");
		System.out.println("Enter 3 to delete data");
		System.out.println("Enter 4 to get student data");
		System.out.println("Enter 5 to get single data ");
		int option=sc.nextInt();
		switch(option){
		case 1: 
			// collecting the data from the user
			System.out.println("enter the student NAME");
			s.setName(sc.next()); // directly passing the user input to the setters.
			System.out.println("enter the phone number");
			s.setPhone(sc.nextLong());
			System.out.println("enter the mail id");
			s.setMailId(sc.next());
			System.out.println("enter the branch");
			s.setBranch(sc.next());
			System.out.println("enter the location");
			s.setLocation(sc.next());
			System.out.println("enter the password");
			String pass=sc.next();
			System.out.println("Confirm password");
			String confirmpass=sc.next();
			//password verification
			if(pass.equals(confirmpass)) {
			s.setPass(pass);
			
			boolean result=sdao.insertStudent(s);
			
			if(result) {
				System.out.println("data added sussessfully");
			}else {
				System.out.println("failed to add data");
			}
			}
			break;
		case 2:
			System.out.println("Enter the id to be update");
			s.setId(sc.nextInt());
			System.out.println("Enter the student name ");
			s.setName(sc.next());
			System.out.println("Enter the password");
			String password=sc.next();
			s.setPass(password);
			if(password.equals(s.getPass())) {
				boolean result=sdao.updateStudent(s);
				if(result) {
					System.out.println("Data updated successfully");
				}
				else {
					System.out.println("Failed to update");
				}
			}else {
				System.out.println("Wrong password");
			}
		   break;
		
		case 3:
	        System.out.println("Enter the student name");
	        s.setName(sc.next());
	        System.out.println("Enter the student password");
	        String pw=sc.next();
	        System.out.println("conforim password");
	        String cpw=sc.next();
	        if(pw.equals(cpw)) {
	        	s.setPass(pw);
	        	boolean result=sdao.deleteStudent(s);
	    		if(result) {
	    			System.out.println("Data deleted successfully");
	    		}
	    		else {
	    			System.out.println("failed to delete");
	    		}
	        }else {
	        	System.out.println("Wrong password");
	        }
			break;
		case 4:
			List<Student> studentlist=sdao.getStudent();
			Iterator<Student> it=studentlist.iterator();
			
			while(it.hasNext()) {
				 s=it.next();
				System.out.println(s);
			}
			break;
		case 5: 
			System.out.println("enter the user name ");
			String mailid1=sc.next();
			 System.out.println("Enter the student password");
		    String pass1=sc.next();
		        Student result=sdao.getStudent(mailid1, pass1);
			   System.out.println(result);
			
			break;
			default: 
				System.out.println("Wrong option");
		}
		
	}
	}



