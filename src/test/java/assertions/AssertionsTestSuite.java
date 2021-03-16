package assertions;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
		RegistrationTests.class,
		LoginTests.class,
		ItemsTests.class,
		ShoppingCartTests.class,
		CheckoutTests.class,
		SubmitOrderTests.class,
		AccountManagementTests.class
})
public class AssertionsTestSuite {

}
