package pageUIs.nopCommerce;

public class ComputersPageUI {
	
	public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
	public static final String PRODUCTS_SORT_BY_NAME_A_FRIST = "//div[@class='item-grid']/div[1]//a[contains(.,'Apple')]";
	public static final String PRODUCTS_SORT_BY_NAME_Z_FRIST = "//div[@class='item-grid']/div[1]//a[contains(.,'Samsung')]";
	public static final String PRODUCTS_SORT_BY_PRICE = "//span[@class='price actual-price']";
	public static final String DISPLAY_DROPDOWN = "//select[@id='products-pagesize']";
	public static final String PRODUCT_DISPLAYED = "//div[@class='product-item']";
	
	public static final String NEXT_PAGINATION = "//li[@class='next-page']/a[text()='Next']";
	public static final String PREVIOUS_PAGINATION = "//li[@class='previous-page']/a[text()='Previous']";
	public static final String PAGINATION_FIELD = "//div[@class='pager']";
	public static final String PAGE_TWO_PAGINATION = "//li[@class='individual-page']";
	public static final String PRODUCT_NAME_BY_INDEX = "//div[@class='item-grid']/div[%s]//div[@class='picture']/a";
}
