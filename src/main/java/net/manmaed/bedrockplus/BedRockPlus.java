package net.manmaed.bedrockplus;

import net.manmaed.bedrockplus.blocks.BRPBlocks;
import net.manmaed.bedrockplus.items.BRPItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BedRockPlus.MOD_ID)
public class BedRockPlus {
	public static final String MOD_ID = "bedrockplus";

	public static final CreativeModeTab itemGropup = new CreativeModeTab(MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Blocks.BEDROCK.asItem());
		}
	};

	public BedRockPlus() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BRPBlocks.BLOCKS.register(eventBus);
		BRPItems.ITEMS.register(eventBus);
		eventBus.addListener(BedRockPlusClient::doClientStuff);

	}
}