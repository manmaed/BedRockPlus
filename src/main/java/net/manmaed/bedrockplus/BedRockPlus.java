package net.manmaed.bedrockplus;

import net.manmaed.bedrockplus.blocks.BRPBlocks;
import net.manmaed.bedrockplus.items.BRPItems;
import net.manmaed.bedrockplus.libs.LogHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(BedRockPlus.MOD_ID)
public class BedRockPlus {
	public static final String MOD_ID = "bedrockplus";

	public BedRockPlus() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BRPBlocks.BLOCKS.register(eventBus);
		BRPItems.ITEMS.register(eventBus);
		eventBus.addListener(this::createTabs);
		eventBus.addListener(this::putMyStuffInOtherTabs);
	}

	public void putMyStuffInOtherTabs(CreativeModeTabEvent.BuildContents event) {
		for (Item item : ForgeRegistries.ITEMS.getValues()) {
			if (item.getCreatorModId(item.getDefaultInstance()).equals(MOD_ID)) {
				//LogHelper.warn("This item is form this mod" + item.toString());
				//event.registerSimple(CreativeModeTabs.SEARCH, item);
			}
		}
	}

	public void createTabs(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "creative_tab"), builder -> builder
				.icon(() -> new ItemStack(Blocks.BEDROCK))
				.title(Component.translatable("itemGroup." + MOD_ID))
				.displayItems((features, output, hasPrems) -> {
					/*output.accept(BRPItems.BR_STONEBRICKS.get());
					output.accept(BRPItems.BR_GLASS.get());
					output.accept(BRPItems.BR_CLEARGLASS.get());
					output.accept(BRPItems.BR_GLOWSTONE.get());
					output.accept(BRPItems.BR_LADDER.get());
					output.accept(BRPItems.BR_STAIRS.get());
					output.accept(BRPItems.BR_SB_STAIRS.get());
					output.accept(BRPItems.BR_SLAB.get());
					output.accept(BRPItems.BR_SB_SLAB.get());*/
					for (Item item : ForgeRegistries.ITEMS.getValues()) {
						if (item.getCreatorModId(item.getDefaultInstance()).equals(MOD_ID)) {
							//LogHelper.warn("This item is form this mod" + item.toString());
							output.accept(item);
						}
					}
				})
		);
	}

}