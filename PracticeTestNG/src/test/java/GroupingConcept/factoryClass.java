package GroupingConcept;

import org.testng.annotations.Factory;

public class factoryClass {
	
	@Factory
	public Object[] factory() {
		test1 t1=new test1();
		second s2=new second();
	
		return new Object[]{t1,s2};
	}

}
