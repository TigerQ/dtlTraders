package net.dandielo.citizens.traders_v3.traits;

import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;
import net.dandielo.citizens.traders_v3.tNpcManager;
import net.dandielo.citizens.traders_v3.bukkit.DtlTraders;
import net.dandielo.citizens.traders_v3.traders.setting.Settings;
import net.dandielo.citizens.traders_v3.traders.stock.Stock;
import net.dandielo.citizens.traders_v3.traders.stock.StockTrader;

public class TraderTrait extends Trait {

	// tNpc manager
	private tNpcManager manager = DtlTraders.tNPCManager();
	
	//settings
	private Settings settings = new Settings(this.npc);
	private Stock stock;
	
	protected TraderTrait() {
		super("trader");
	}
	
	//get settings for this Trader NPC
	public Settings getSettings() {
		return settings;
	}

	public String getType() {
		return settings.getType();
	}
	
	public Stock getStock() {
		return stock;
	}

	//events
	@Override
	public void onRemove()
	{
		
	}
	
	@Override
	public void onAttach()
	{
		
	}
	
	@Override
	public void load(DataKey data)
	{
		//load all settings
		settings.load(data);
		
		//create and load the stock
		stock = new StockTrader(settings.getStockName(this.npc.getName()), settings.getStockSize());
		stock.load(data);
	}

	public void save(DataKey data)
	{
		//save settings
		settings.save(data);
		
		//save the stock
		stock.save(data);
	}
}
