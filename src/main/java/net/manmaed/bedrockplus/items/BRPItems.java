package net.manmaed.bedrockplus.items;

import net.manmaed.bedrockplus.BedRockPlus;
import net.manmaed.bedrockplus.blocks.BRPBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Created by manmaed on 01/12/2021.
 */
public class BRPItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BedRockPlus.MOD_ID);

    public static final RegistryObject<Item> BR_STONEBRICKS = ITEMS.register(name("stonebricks"), () -> new BlockItem(BRPBlocks.BR_STONEBRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_GLASS = ITEMS.register(name("clear_glass"), () -> new BlockItem(BRPBlocks.BR_GLASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_CLEARGLASS = ITEMS.register(name("glass"), () -> new BlockItem(BRPBlocks.BR_CLEARGLASS.get(), new Item.Properties()));

    public static final RegistryObject<Item> BR_GLOWSTONE = ITEMS.register(name("glowstone"), () -> new BlockItem(BRPBlocks.BR_GLOWSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_LADDER = ITEMS.register(name("ladder"), () -> new BlockItem(BRPBlocks.BR_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_STAIRS = ITEMS.register(name("stairs"), () -> new BlockItem(BRPBlocks.BR_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_SB_STAIRS = ITEMS.register(name("stonebrick_stairs"), () -> new BlockItem(BRPBlocks.BR_SB_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_SLAB = ITEMS.register(name("slab"), () -> new BlockItem(BRPBlocks.BR_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BR_SB_SLAB = ITEMS.register(name("stonebrick_slab"), () -> new BlockItem(BRPBlocks.BR_SB_SLAB.get(), new Item.Properties()));

    //Lazy way to get the name of the block with bedrock prefix
    private static String name(String name) {
        return "bedrock_" + name;
    }
}
