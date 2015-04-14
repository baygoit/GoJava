package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import java.util.List;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;


public class BusinessServiceHandlerImpl implements BusinessServiceHandler{

	private GoodCatalog goodCatalog;
	
	private DeliveryManager deliveryManager;
	
	private WarehouseManager warehouseManager;

	@Override
	public GoodType createType(String name, Integer parentId)
			throws MyShopException {
		return goodCatalog.createType(name, parentId);
	}

	@Override
	public GoodType getGoodTypeById(Integer id) throws MyShopException {
		return goodCatalog.getGoodTypeById(id);
	}

	@Override
	public void deleteGoodType(Integer id) throws MyShopException {
		goodCatalog.deleteGoodType(id);		
	}

	@Override
	public List<GoodType> getAllTypes() throws MyShopException {
		return goodCatalog.getAllTypes();
	}

	@Override
	public GoodType updateGoodType(Integer id, String name, Integer parentId)
			throws MyShopException {
		return goodCatalog.updateGoodType(id, name, parentId);
	}

	@Override
	public Good createGood(String name, Integer typeId) throws MyShopException {
		return goodCatalog.createGood(name, typeId);
	}

	@Override
	public Good getGoodById(Integer id) throws MyShopException {
		return goodCatalog.getGoodById(id);
	}

	@Override
	public Good updateGood(Integer id, String name, Integer typeId)
			throws MyShopException {
		return goodCatalog.updateGood(id, name, typeId);
	}

	@Override
	public void deleteGood(Integer id) throws MyShopException {
		goodCatalog.deleteGood(id);
	}

	@Override
	public List<Good> getAllGoods() throws MyShopException {
		return goodCatalog.getAllGoods();
	}

	@Override
	public List<Good> getGoodsFilteringByName(String query)
			throws MyShopException {
		return goodCatalog.getGoodsFilteringByName(query);
	}

	@Override
	public List<GoodType> getGoodTypesFilteringByName(String query)
			throws MyShopException {
		return goodCatalog.getGoodTypesFilteringByName(query);
	}

	@Override
	public List<GoodType> getGoodTypesByName(String name)
			throws MyShopException {
		return goodCatalog.getGoodTypesByName(name);
	}

	@Override
	public List<GoodRecord> getRecordsOfGood(Good good) throws MyShopException {
		return warehouseManager.getRecordsOfGood(good);
	}

	@Override
	public List<GoodRecord> getAllRecords() throws MyShopException {
		return warehouseManager.getAllRecords();
	}

	@Override
	public GoodRecord getRecord(Integer id) throws MyShopException {
		return warehouseManager.getRecord(id);
	}

	@Override
	public void deleteRecord(Integer id) throws MyShopException {
		warehouseManager.deleteRecord(id);		
	}

	@Override
	public GoodRecord deliverGood(Good good, Integer quantity, Integer price)
			throws MyShopException {
		return deliveryManager.deliverGood(good, quantity, price);
	}

	public void setGoodCatalog(GoodCatalog goodCatalog) {
		this.goodCatalog = goodCatalog;
	}

	public void setDeliveryManager(DeliveryManager deliveryManager) {
		this.deliveryManager = deliveryManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}

}
