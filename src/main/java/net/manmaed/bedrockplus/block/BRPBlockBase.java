package net.manmaed.bedrockplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Created by manmaed on 24/02/2019.
 */
public class BRPBlockBase extends Block {
    private boolean isglass = false;
    public BRPBlockBase(Block.Properties properties, String name, Boolean isglass) {
        super(properties);
        /*setSoundType(soundType);
        setCreativeTab(BedRockPlus.tabsBRP);
        disableStats();
        setHardness(6000000.0F);
        setBlockUnbreakable();*/
        setRegistryName(name);
        this.isglass = isglass;
    }


    @Override
    public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
        return !(entity instanceof WitherEntity);
    }

    @Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {

    }

    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        if (isglass) {
            return BlockRenderLayer.CUTOUT;
        } else {
            return BlockRenderLayer.SOLID;
        }
    }
}
