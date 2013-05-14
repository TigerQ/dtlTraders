package net.dandielo.citizens.traders_v3.traders.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.citizensnpcs.api.util.DataKey;

import org.bukkit.inventory.InventoryHolder;

public abstract class Stock implements InventoryHolder {
	protected final int size;
	protected final String name;
	
	protected final Map<String, List<StockItem>> stock = new HashMap<String, List<StockItem>>();
	
	protected Stock(String name, int size)
	{
        if( size <= 0 || size > 6 ){
        	throw new IllegalArgumentException("Size must be between 1 and 6");}
        
		this.name = name;
		this.size = size;
        
        stock.put("sell", new ArrayList<StockItem>());
        stock.put("buy", new ArrayList<StockItem>());
	}
	
	//inventory size
	public final int getFinalInventorySize()
	{
		return size*9;
	}

	public void load(DataKey data) {
	}

	public void save(DataKey data) {
	}
}
