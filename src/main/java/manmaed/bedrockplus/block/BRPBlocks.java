package manmaed.bedrockplus.block;

import manmaed.bedrockplus.BedRockPlus;
import manmaed.bedrockplus.libs.Reference;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.ToIntFunction;

public class BRPBlocks {

    public static final String BEDROCK = "bedrock_";

    @ObjectHolder(Reference.REGISTER + "bedrock_glass")
    public static Block BR_GLASS;

    @ObjectHolder(Reference.REGISTER + "bedrock_glowstone")
    public static Block BR_GLOWSTONE;

    @ObjectHolder(Reference.REGISTER + "bedrock_clear_glass")
    public static Block BR_CLEARGLASS;

    @ObjectHolder(Reference.REGISTER + "bedrock_stonebricks")
    public static Block BR_STONEBRICKS;

    @ObjectHolder(Reference.REGISTER + "bedrock_ladder")
    public static Block BR_LADDER;

    @ObjectHolder(Reference.REGISTER + "bedrock_stairs")
    public static Block BR_STAIRS;

    @ObjectHolder(Reference.REGISTER + "bedrock_stonebrick_stairs")
    public static Block BR_SB_STAIRS;

    public static void load() {
		//Init'ing
        //("bedrock", new Block(BlockBehaviour.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(Blocks::never)));
        BR_GLASS = new HalfTransparentBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(-1.0F, 3600000.0F).noOcclusion().noDrops().isValidSpawn(BRPBlocks::never).isRedstoneConductor(BRPBlocks::never).isSuffocating(BRPBlocks::never).isViewBlocking(BRPBlocks::never));
        BR_GLOWSTONE = new Block(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(-1.0F, 3600000.0F).lightLevel((light)->{
            return 15;
        }).noDrops().isValidSpawn(BRPBlocks::never));
        BR_CLEARGLASS = new HalfTransparentBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(-1.0F, 3600000.0F).noOcclusion().noDrops().isValidSpawn(BRPBlocks::never).isRedstoneConductor(BRPBlocks::never).isSuffocating(BRPBlocks::never).isViewBlocking(BRPBlocks::never));
        BR_STONEBRICKS = new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BRPBlocks::never));
        BR_LADDER = new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.LADDER).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BRPBlocks::never).noOcclusion());
        BR_STAIRS = new StairBlock(Blocks.BEDROCK.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BEDROCK));
        BR_SB_STAIRS = new StairBlock(BR_STONEBRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(BR_STONEBRICKS));

        //NAMES
        BR_GLASS.setRegistryName(sn("glass"));
        BR_GLOWSTONE.setRegistryName(sn("glowstone"));
        BR_CLEARGLASS.setRegistryName(sn("clear_glass"));
        BR_STONEBRICKS.setRegistryName(sn("stonebricks"));
        BR_LADDER.setRegistryName(sn("ladder"));
        BR_STAIRS.setRegistryName(sn("stairs"));
        BR_SB_STAIRS.setRegistryName(sn("stonebrick_stairs"));


        BedRockPlus.getRegisteryHandler().registerBlock(BR_GLASS);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_GLOWSTONE);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_CLEARGLASS);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_STONEBRICKS);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_LADDER);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_STAIRS);
        BedRockPlus.getRegisteryHandler().registerBlock(BR_SB_STAIRS);
	}

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static String sn(String name) {
        return BEDROCK + name;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

}
