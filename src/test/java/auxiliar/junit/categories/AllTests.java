package auxiliar.junit.categories;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	auxiliar.junit.categories.pPackage.AllTests.class, 
	auxiliar.junit.categories.qPackage.AllTests.class,
	auxiliar.junit.categories.IgnoredTest.class })
public class AllTests {

}
