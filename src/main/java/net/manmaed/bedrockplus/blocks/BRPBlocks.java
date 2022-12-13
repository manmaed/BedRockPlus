package net.manmaed.bedrockplus.blocks;

import net.manmaed.bedrockplus.BedRockPlus;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.*;

public class BRPBlocks {

    private static BlockBehaviour.Properties getProperties(Material material, SoundType soundType) {
        return BlockBehaviour.Properties.of(material).sound(soundType).strength(-1.0F, 3600000.0F).noLootTable().isValidSpawn(BRPBlocks::never).isRedstoneConductor(BRPBlocks::never).isSuffocating(BRPBlocks::never).isViewBlocking(BRPBlocks::never);
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BedRockPlus.MOD_ID);

    public static final RegistryObject<Block> BR_STONEBRICKS = BLOCKS.register(name("stonebricks"), () -> new Block(getProperties(Material.STONE, SoundType.STONE)));
    public static final RegistryObject<Block> BR_GLASS = BLOCKS.register(name("clear_glass"), () -> new GlassBlock(getProperties(Material.GLASS, SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BR_CLEARGLASS = BLOCKS.register(name("glass"), () -> new GlassBlock(getProperties(Material.GLASS, SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> BR_GLOWSTONE = BLOCKS.register(name("glowstone"), () -> new Block(getProperties(Material.GLASS, SoundType.GLASS).lightLevel((light)->{
        return 15;
    })));
    public static final RegistryObject<Block> BR_LADDER = BLOCKS.register(name("ladder"), () -> new LadderBlock(getProperties(Material.DECORATION, SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> BR_STAIRS = BLOCKS.register(name("stairs"), () -> new StairBlock(Blocks.BEDROCK.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

    public static final RegistryObject<Block> BR_SB_STAIRS = BLOCKS.register(name("stonebrick_stairs"), () -> new StairBlock(BR_STONEBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BR_STONEBRICKS.get())));

    public static final RegistryObject<Block> BR_SLAB = BLOCKS.register(name("slab"), () -> new SlabBlock(getProperties(Material.STONE, SoundType.STONE).noOcclusion()));
    public static final RegistryObject<Block> BR_SB_SLAB = BLOCKS.register(name("stonebrick_slab"), () -> new SlabBlock(getProperties(Material.STONE, SoundType.STONE).noOcclusion()));


    //Lazy way to get the name of the block with bedrock prefix
    private static String name(String name) {
        return "bedrock_" + name;
    }

    //Do not do stuff
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
}
