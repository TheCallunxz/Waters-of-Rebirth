package thecallunxz.wor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thecallunxz.wor.creativetabs.WORTab;
import thecallunxz.wor.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]", dependencies = "required-after:llibrary@[" + Reference.LLIB_VERSION + ",);required-after:baubles@[1.5.2,)")

public class Main {
	@Instance(Reference.MOD_ID)
	public static Main instance;
	
	public static final CreativeTabs tabWORBlocks = new WORTab(Item.getItemFromBlock(Blocks.STONE), "worblocks");
	public static final CreativeTabs tabWORMaterials = new WORTab(Items.PAPER, "wormaterials");
	public static final CreativeTabs tabWORItems = new WORTab(Items.IRON_SWORD, "woritems");
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
