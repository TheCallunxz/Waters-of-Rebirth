package thecallunxz.wor.init;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import thecallunxz.wor.ItemModelProvider;
import thecallunxz.wor.Reference;


@ObjectHolder(Reference.MOD_ID)
public class InitBlocks {
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			final Block[] blocks = {
					
			};

			registry.registerAll(blocks);
		}
		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					
					
			};
			
			

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				
				if(block instanceof ItemModelProvider) {
					 ((ItemModelProvider)block).registerItemModel(item);
				}
				
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
		}
	}
	
	public static void registerTileEntities() {

	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass) {
		GameRegistry.registerTileEntity(tileEntityClass, Reference.RESOURCE_PREFIX + tileEntityClass.getSimpleName().replaceFirst("TileEntity", ""));
	}
}
