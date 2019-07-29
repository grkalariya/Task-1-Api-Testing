package restAssuredProductApiTests;

import org.apache.commons.lang3.RandomStringUtils;

public class ProductDataUtils {
	
	public static String getName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("TestProductName"+generatedString);
	}
	
	public static String getType()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("TestType"+generatedString);
	}
	
	public static Integer getPrice()
	{
		return(99);
	}
	
	public static Integer getShipping()
	{
		return(0);
	}
	
	public static String getUpc()
	{
		String generatedString = RandomStringUtils.randomNumeric(6);
		return(generatedString);
	}
	
	public static String getDescription()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return("This test product description -"+generatedString);
	}
	
	public static String getManufacturer()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("Energizer"+generatedString);
	}
	
	public static String getModel()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(6);
		return(generatedString);
	}
	
	public static String getUrl()
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return("http://www.bestbuy.com/site/duracell-c-batteries-4-pack/185230.p?id="+generatedString);
	}
	
	public static String getImage()
	{
		return("http://img.bbystatic.com/BestBuy_US/images/products/1852/185230_sa.jpg");
	}

}
