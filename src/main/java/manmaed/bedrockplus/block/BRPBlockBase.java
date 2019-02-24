package manmaed.bedrockplus.block;

import manmaed.bedrockplus.BedRockPlus;
import net.minecraft.block.BlockBreakable;
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
 * Created by manmaed on 24/02/2019.
 */
public class BRPBlockBase extends BlockBreakable {
    public BRPBlockBase(Material material, SoundType soundType, Boolean light, String name) {
        super(material, false);
        setSoundType(soundType);
        setCreativeTab(BedRockPlus.tabsBRP);
        disableStats();
        setHardness(6000000.0F);
        setBlockUnbreakable();
        if(light) {
            setLightLevel(1F);
        }
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
        return !(entity instanceof EntityWither);
    }
    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
    }

    @Override
    public boolean canDropFromExplosion(Explosion p_1496591) {
        return false;
    }
}
