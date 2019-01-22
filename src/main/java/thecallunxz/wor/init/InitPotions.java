package thecallunxz.wor.init;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import thecallunxz.wor.Reference;

@ObjectHolder(Reference.MOD_ID)
public class InitPotions {

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		
		@SubscribeEvent
		public static void registerPotions(final RegistryEvent.Register<Potion> event) {
			event.getRegistry().registerAll(
					
			);
		}
	}

}