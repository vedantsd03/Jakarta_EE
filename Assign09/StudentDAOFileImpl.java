

package mypack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StudentDAOFileImpl implements StudentDAO 
{
	private static int idctr = 0;
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos=new FileOutputStream("e:\\trial.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.write(++idctr);
			oos.writeObject(student);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}

