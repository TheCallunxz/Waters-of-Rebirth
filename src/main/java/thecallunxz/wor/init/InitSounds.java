package thecallunxz.wor.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import thecallunxz.wor.Reference;

@ObjectHolder(Reference.MOD_ID)
public final class InitSounds {
	
	public static SoundEvent register(String name) {
		final ResourceLocation loc = new ResourceLocation(Reference.MOD_ID, name);
		return new SoundEvent(loc).setRegistryName(loc);
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<SoundEvent> event) {
			final IForgeRegistry<SoundEvent> registry = event.getRegistry();
			
			final SoundEvent[] sounds = {
					
			};

			registry.registerAll(sounds);
			
		}
	}
	
}