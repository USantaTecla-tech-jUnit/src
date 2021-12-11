package auxiliar.junit.categories;

import org.junit.Test;
import org.junit.Ignore;

@Ignore
public class IgnoredTest {

	@Ignore("Mensaje alternativo con justificación") @Test
	public void testOne() {
		System.out.println("IgnoredTest");
	}
	
	@Test
	public void testTwo() {
		System.out.println("No!!! IgnoredTest");
	}
	
}
