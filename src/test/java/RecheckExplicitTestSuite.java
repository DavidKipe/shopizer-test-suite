import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import recheck.explicit.*;

@RunWith(JUnitPlatform.class)
@SelectClasses({
		A_RegistrationTests.class,
		B_LoginTests.class,
		C_ItemsTests.class,
		D_ShoppingCartTests.class,
		E_CheckoutTests.class,
		F_SubmitOrderTests.class,
		G_ItemReviewTests.class,
		H_AccountManagementTests.class
})
public class RecheckExplicitTestSuite {

}
