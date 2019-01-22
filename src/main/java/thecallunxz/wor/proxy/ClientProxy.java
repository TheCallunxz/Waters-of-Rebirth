package thecallunxz.wor.proxy;


import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thecallunxz.wor.Reference;
import thecallunxz.wor.events.ClientEventHandler;
import thecallunxz.wor.events.GuiEventHandler;
import thecallunxz.wor.init.InitEntities;
import thecallunxz.wor.init.InitLayers;
import thecallunxz.wor.render.RenderWings;

public class ClientProxy extends CommonProxy {
	
    @Override
    public void preInit(final FMLPreInitializationEvent e) {
        super.preInit(e);
        
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(new GuiEventHandler());
       //MinecraftForge.EVENT_BUS.register(new RenderWings());
        
        InitEntities.initModels();
    }

    @Override
    public void init(final FMLInitializationEvent e) {
        super.init(e);
        InitLayers.registerLayers();
    }

    @Override
    public void postInit(final FMLPostInitializationEvent e) {
        super.postInit(e);
    }  
    
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    	 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
    }
    
    @Override
    public boolean isClient() {
		return true;
	}
}
