package manmaed.bedrockplus.libs;

import manmaed.bedrockplus.BedRockPlus;
import manmaed.bedrockplus.block.BRPBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by manmaed on 24/03/2020
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        BRPBlocks.load();
        for (Block block : BedRockPlus.getRegisteryHandler().getRegisteredBlocks()) {
            event.getRegistry().registerAll(block);
        }
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        /*BRPItems.load();*/
        for (Block block : BedRockPlus.getRegisteryHandler().getRegisteredBlocks()) {
            /*event.getRegistry().register(new BlockItem(new Block.Properties.from(block).setRegistryName(block.getRegistryName())));*/
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(BedRockPlus.itemGroup)).setRegistryName(block.getRegistryName()));
        }
        for (Item item : BedRockPlus.getRegisteryHandler().getRegisteredItems()) {
            event.getRegistry().register(item);
        }
    }
}