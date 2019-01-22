package thecallunxz.wor.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thecallunxz.wor.events.CommonEventHandler;
import thecallunxz.wor.init.InitBlocks;
import thecallunxz.wor.init.InitEntities;

public class CommonProxy {
	
	public void preInit(final FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        
        InitBlocks.registerTileEntities();
		InitEntities.register();
    }

    public void init(final FMLInitializationEvent e) {
    	
    }

    public void postInit(final FMLPostInitializationEvent e) {
    	
    }
    
    public void registerItemRenderer(Item item, int meta, String id) {
    	 
    }

    public boolean isClient() {
		return false;
	}
}

