package ua.com.goit.group1.admytruk.blabla;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

public class Main {

	
	private static final String CMD_OPT_PRINT_CATEGORIES = "printCategories";
	
	private static final String CMD_OPT_PRINT_PRODUCTS = "printProducts";

	private static final HelpFormatter HELP_FORMATTER = new HelpFormatter();

	private static Options createOptions() {
		final Options options = new Options();
		options.addOption(CMD_OPT_PRINT_CATEGORIES, false, "Print all available categories.");
		options.addOption(CMD_OPT_PRINT_PRODUCTS, true, "Print category's products.");
		return options;
	}

	public static void printCategories(final List<Category> categoryList) {
		if (categoryList == null || categoryList.isEmpty()) {
			System.err.println("The service does not contain any category.");
			return;
		}
		for (Category category : categoryList) {
			System.out.println(category);
		}
	}
	
	public static void printProducts(final List<Product> productList) {
		if (productList == null || productList.isEmpty()) {
			System.err.println("The products does not found.");
			return;
		}
		for (Product product : productList) {
			System.out.println(product);
		}
	}


	
	public static void main(String[] args) throws Exception {
		final BlablaService service = new BlaBlaServiceImpl();
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(createOptions(), args);
		
		if (cmd.hasOption(CMD_OPT_PRINT_CATEGORIES)) {
			printCategories(service.getCategoryList());
		} if (cmd.hasOption(CMD_OPT_PRINT_PRODUCTS)) {
			int categoryId = Integer.parseInt(cmd.getOptionValue(CMD_OPT_PRINT_PRODUCTS));
			printProducts(service.getProductList(categoryId));
		} else {
			HELP_FORMATTER.printHelp("java -jar blabla.jar", createOptions());
		}
		
		
	}
}
