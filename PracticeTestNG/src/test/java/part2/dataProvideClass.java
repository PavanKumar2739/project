package part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;


public class dataProvideClass {
	
	@DataProvider//(indices = {3,1,2,5})
	public Iterator<Object[]> Data()
	{
		List<Object[]> data= new ArrayList<>();
		data.add(new Object[] {"Adm2in","admin123"});
		data.add(new Object[] {"ADMIN","Admin123"});
		data.add(new Object[] {"admin","admin123"});
		data.add(new Object[] {"Admin",2423532});
		data.add(new Object[] {"Admin","admin13"});
		data.add(new Object[] {423423,"admin123"});
		data.add(new Object[] {"Admin","dmin123"});
		
		return data.iterator();
	}
	

}
