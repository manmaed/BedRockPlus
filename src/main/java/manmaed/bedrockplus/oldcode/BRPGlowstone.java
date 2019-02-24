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
 * Created by manmaed on 03/12/2015.
 */
public class BRPGlowstone extends Block {

    public BRPGlowstone() {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setCreativeTab(BedRockPlus.tabsBRP);
        disableStats();
        setResistance(6000001.0F);
        setBlockUnbreakable();
        setUnlocalizedName("bedrockglowstone");
        //setBlockName("BedRockGlowstone");
        //setBlockTextureName(Reference.MOD_ID + ":" + getUnlocalizedName().substring(5));
        setLightLevel(1F);


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
