package ua.com.goit.gojava.andriidnikitin.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.service.util.FlatDataBuilder;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class StorageFlat extends StorageAbstract{
	private List<Category> categoryList;
	private List<Good> goodList;
	
	private final String filepath = new String("resourses/file" + 
			+ this.hashCode() + ".csv");
	FlatDataBuilder generator = new FlatDataBuilder("resources/sample.csv"); 
	
	public StorageFlat() throws ShopException{
		generator = new FlatDataBuilder(filepath); 
		init();
		for (Good good: getGoodList()){
			if (!categoryList.contains(good.getCategory())){
				categoryList.add(good.getCategory());
			}
		}
	}
	
	private void init() throws ShopException {
		categoryList = new ArrayList<Category>();
		goodList = new ArrayList<Good>();
		FlatDataBuilder initor = new FlatDataBuilder("resources/sample.csv");
		try {
			List<ArrayList<String>> readList = initor.getCSVElementsFromFile();
			for(ArrayList<String> sublist: readList) {
				goodList.add(readGood(sublist));
			}
		} catch (FileNotFoundException e) {
			throw new ShopException("Resource file not found.");
		}
	}
	
	@SuppressWarnings("unused")
	private void generate() throws ShopException{
		StorageImpl store = new StorageImpl();
		FlatDataBuilder generator = new FlatDataBuilder("resources/sample.csv"); 
		List<String[]> list = new ArrayList<String[]>();
		for (Good good: store.getGoodList()){
			list.add(writeGood(good));
		}
		generator.writeRecordsToCSV(list);
	}
	
	protected StorageFlat setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
		return this;
	}

	protected StorageFlat setGoodList(List<Good> goodList) {
		this.goodList = goodList;
		return this;
	}
	
	protected List<Good> getGoodList() {
		return goodList != null ? goodList : new ArrayList<Good>();		
	}	
	
	@Override
	public List<Category> getCategoryList() {
		return categoryList != null ? categoryList : new ArrayList<Category>();
	}
	
	@Override
	public List<Good> getGoodList(Category category) {
		final List<Good> result = new ArrayList<Good>();
		if (category == null || category.getName() == null) { 
				return result;   
		}  
		for (Good good : goodList){
			if (category.getId().equals(good.getCategory().getId())) { 
					result.add(good);
			}
		}
		return result;
	}

	@Override
	public void save (Category category) {
		if (category.getId() == null) {
			categoryList.add(setId(category));
		}
		else {
			for (int index = 0; index < categoryList.size(); index++) {
				if (category.getId().equals(categoryList.get(index).getId())) {
					categoryList.set(index, category);
					break;
				}
			
			}		
		}
	}

	@Override
	public void save (Good good) {
		if (good.getId() == null) {
			goodList.add(setId(good));
		}
		else {
			for (int index = 0; index < goodList.size(); index++) {
				if (good.getId().equals(goodList.get(index).getId())) {
					goodList.set(index, good);
					break;
				}
			
			}		
		}
		try {
			generator.append(generator.makeCSVElement(writeGood(good)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Category setId (Category category) {
		if (category == null) {
			return null;
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + category.getName().hashCode();
		return category.setId(result);
	}
	
	public static Good setId(Good good) {
		final int prime = 31;
		int result = 1;
		Category category = good.getCategory();
		result = prime * result + category.getId();
		result = prime * result + good.getName().hashCode();
		return good.setId(result);
	}
	
	private Good readGood(List<String> CSVStrings) {
		Good good = new Good();
		good.setId(new Integer(CSVStrings.get(0)));
		good.setName(CSVStrings.get(1));
		Category category = new Category();
		category.setId(new Integer(CSVStrings.get(2)));
		category.setName(CSVStrings.get(3));
		good.setCategory(category);
		good.setPrice(new BigDecimal(CSVStrings.get(4)));
		return good;
	}
	
	private String[] writeGood(Good good){
		String[] result = new String[5];
		result[0] = good.getId().toString();
		result[1] = good.getName();
		result[2] = good.getCategory().getId().toString();
		result[3] = good.getCategory().getName();
		result[4] = good.getPrice().toPlainString();
		return result;
	}

}
