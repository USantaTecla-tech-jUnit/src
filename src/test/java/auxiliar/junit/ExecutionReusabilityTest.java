package auxiliar.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutionReusabilityTest {
	
	private static int staticMember = 0;
	static {
		staticMember++;
		System.out.println("static code: " + staticMember);
	}
	
	private int instanceMember;
	
	public ExecutionReusabilityTest(){
		staticMember++;
		instanceMember++;
		System.out.println("constructor: " + staticMember + " and " +  instanceMember);
	}
	
	@BeforeClass
	public static void beforeClass(){
		staticMember++;
		System.out.println("before class: " + staticMember);
	}
	
	@Before
	public void before(){
		staticMember++;
		instanceMember++;
		System.out.println("before: " + staticMember + " and " +  instanceMember);
	}
	
	@Test
	public void testA(){
		staticMember++;
		instanceMember++;
		System.out.println("test A: " + staticMember + " and " +  instanceMember);
	}
	
	@Test
	public void testB(){
		staticMember++;
		instanceMember++;
		System.out.println("test B: " + staticMember + " and " +  instanceMember);
	}
	
	@Test
	public void testC(){
		staticMember++;
		instanceMember++;
		System.out.println("test C: " + staticMember + " and " +  instanceMember);
	}
	
	@After
	public void after(){
		staticMember++;
		instanceMember++;
		System.out.println("after: " + staticMember + " and " +  instanceMember);
	}
	
	@AfterClass
	public static void afterClass(){
		staticMember++;
		System.out.println("after class: " + staticMember);
	}
	
}
