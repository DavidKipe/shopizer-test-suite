import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import recheck.implicit.*;

@RunWith(JUnitPlatform.class)
@SelectClasses({
		RegistrationTests.class,
		LoginTests.class,
		ItemsTests.class,
		ShoppingCartTests.class,
		CheckoutTests.class,
		SubmitOrderTests.class,
		ItemReviewTests.class,
		AccountManagementTests.class
})
public class RecheckImplicitTestSuite {

}
