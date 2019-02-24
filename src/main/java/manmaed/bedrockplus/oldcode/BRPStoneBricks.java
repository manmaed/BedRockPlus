package manmaed.bedrockplus.oldcode;

import manmaed.bedrockplus.BedRockPlus;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by manmaed on 16/08/2015.
 */
public class BRPStoneBricks extends Block {

    public BRPStoneBricks() {
        super(Material.ROCK);
        setSoundType(SoundType.STONE);
        setCreativeTab(BedRockPlus.tabsBRP);
        disableStats();
        setHardness(6000000.0F);
        setBlockUnbreakable();
        setUnlocalizedName("bedrockstonebrick");
/*        setBlockTextureName(Reference.MOD_ID + ":" + getUnlocalizedName().substring(5));*/

    }
    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {


        return !(entity instanceof EntityWither);
        //return false;
        //return this;
        /*this != this;*/
    }
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
    }

    @Override
    public boolean canDropFromExplosion(Explosion p_1496591) {
        return false;
    }
}
