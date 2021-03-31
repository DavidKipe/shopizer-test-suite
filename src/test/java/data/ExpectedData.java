package data;

public class ExpectedData {

	public static final String REGISTRATION_UNABLE_TO_COMPLETE = "Unable to complete registration, please try again later";
	public static final String REGISTRATION_USER_NAME_ALREADY_EXISTS = "User with user name already exists for this store.";
	public static final String REGISTRATION_BOTH_PASSWORD_MUST_MATCH = "Both password must match";

	public static final String LOGIN_ERR_FAILED = "Login Failed. Username or Password is incorrect.";

	public static final String ITEMS_ITEM_1_PRICE_STR = "$60.00";
	public static final double ITEMS_ITEM_1_PRICE = 60.0;
	public static final double ITEMS_ITEM_2_PRICE = 62.0;
	public static final double[] ITEMS_PRICES = {ITEMS_ITEM_1_PRICE, ITEMS_ITEM_2_PRICE};

	public static final String ITEMS_COLLECTION_NAME_1 = "Vintage";
	public static final String[] ITEMS_COLLECTION_NAME_1_DISPLAYED_NAMES = {"Multi Use Hand Bag", "Vintage Bag", "Vintage Exotik Carry Bag"};

	public static final double CHECKOUT_SHIPPING_PRICE = 14.0;
	public static final double CHECKOUT_SHIPPING_PRICE_DIFFERENT_ADDRESS = 12.0;

	public static final String CHECKOUT_MSG_FORM_OK = "The order can be completed";
	public static final String CHECKOUT_MSG_FORM_FIRST_NAME_REQUIRED = "First name is required";
	public static final String CHECKOUT_MSG_FORM_LAST_NAME_REQUIRED = "Last name is required";
	public static final String CHECKOUT_MSG_FORM_STREET_ADDRESS_REQUIRED = "Street address is required";
	public static final String CHECKOUT_MSG_FORM_CITY_REQUIRED = "City is required";
	public static final String CHECKOUT_MSG_FORM_POSTAL_CODE_REQUIRED = "Postal code is required";
	public static final String CHECKOUT_MSG_FORM_EMAIL_REQUIRED = "Email address is required";
	public static final String CHECKOUT_MSG_FORM_PHONE_NUMBER_REQUIRED = "Phone number is required";
	public static final String CHECKOUT_MSG_FORM_PASSWORD_REQUIRED = "A password is required";

	public static final String CHECKOUT_SHIPPING_MSG_FORM_FIRST_NAME_REQUIRED = "Shipping first name should not be empty";
	public static final String CHECKOUT_SHIPPING_MSG_FORM_LAST_NAME_REQUIRED = "Shipping last name should not be empty";
	public static final String CHECKOUT_SHIPPING_MSG_FORM_STREET_ADDRESS_REQUIRED = "Shipping street address should not be empty";
	public static final String CHECKOUT_SHIPPING_MSG_FORM_CITY_REQUIRED = "Shipping city should not be empty";
	public static final String CHECKOUT_SHIPPING_MSG_FORM_POSTAL_CODE_REQUIRED = "Shipping postal code should not be empty";

	public static final String CHECKOUT_ERROR_GENERIC = "An error occurred in this request";

	public static final String ORDER_CONFIRMATION_TITLE_OK = "Order completed";
	public static final String ORDER_CONFIRMATION_MSG_ID_REGEX = "Your order id is \\d+.";

	public static final String CHANGE_PASSWORD_MSG_INVALID_PASSWORD = "Invalid password";
	public static final String CHANGE_PASSWORD_MSG_MISMATCH = "Both password must match";
	public static final String CHANGE_PASSWORD_MSG_SHORT_PASSWORD = "Password must be at least 6 characters";

	public static final String ITEM_REVIEW_MSG_OPINION_REQUIRED = "Your opinion is required";
	public static final String ITEM_REVIEW_MSG_RATING_REQUIRED = "Product rating is required";
	public static final String ITEM_REVIEW_MSG_SUCCESSFULLY_CREATED = "You have successfully created a product review";

	public static final String HEADER_MY_ACCOUNT_MESSAGE_NO_LOGIN = "My Account";

}
