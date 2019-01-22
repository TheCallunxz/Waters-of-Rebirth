package thecallunxz.wor.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WORTab extends CreativeTabs {

	private Item icon;
	
	public WORTab(Item icon, String label) {
		super(label);
		this.icon = icon;
	}

	@Override
	public ItemStack getTabIconItem() {
		return icon.getDefaultInstance();
	}

}
