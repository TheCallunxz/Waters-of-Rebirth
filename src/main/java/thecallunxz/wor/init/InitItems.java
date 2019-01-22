package thecallunxz.wor.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import thecallunxz.wor.ItemModelProvider;
import thecallunxz.wor.Reference;
import thecallunxz.wor.items.ItemBase;
import thecallunxz.wor.items.ItemWings;

@ObjectHolder(Reference.MOD_ID)
public class InitItems {

	public static final ItemWings test_wings_early = new ItemWings("test_wings_early", 50, 0.03D, 0.25F);
	public static final ItemWings test_wings_late = new ItemWings("test_wings_late", 1000, 0.06D, 0.5F);
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] items = {
					test_wings_early,
					test_wings_late,
			};
			final IForgeRegistry<Item> registry = event.getRegistry();
			for (final Item item : items) {
				if (item instanceof ItemModelProvider) {
					((ItemModelProvider) item).registerItemModel(item);
				}
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
