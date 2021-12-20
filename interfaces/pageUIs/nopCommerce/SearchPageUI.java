package pageUIs.nopCommerce;

public class SearchPageUI {
	
	public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
	public static final String SEARCH_TEXTBOX = "//input[@id='q']";
	public static final String EMPTY_DATA_MESSAGE = "//div[text()='Search term minimum length is 3 characters']";
	public static final String NO_EXIST_DATA_MESSAGE = "//div[text()='No products were found that matched your criteria.']";
	public static final String RELATIVELY_DATA = "//h2[@class='product-title']/a[contains(.,'Lenovo')]";
	public static final String ABSOLUTELY_DATA = "//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String ADVANCED_CHECKBOX = "//input[@id='advs']";
	public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "//input[@id='isc']";
	public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
	public static final String ADVANCED_SEARCH_MATCH_DATA = "//a[text()='Apple MacBook Pro 13-inch']";
	public static final String PRODUCT_NAME_BY_INDEX = "//div[@class='item-grid']/div[%s]//div[@class='picture']/a";

}
