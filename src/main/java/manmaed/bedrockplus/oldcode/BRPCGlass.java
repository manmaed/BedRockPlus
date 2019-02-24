package manmaed.bedrockplus.oldcode;

import manmaed.bedrockplus.BedRockPlus;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by manmaed on 16/08/2015.
 */
public class BRPCGlass extends BlockBreakable {

    public BRPCGlass() {
        super(Material.GLASS, false);
        setSoundType(SoundType.GLASS);
        setCreativeTab(BedRockPlus.tabsBRP);
        disableStats();
        setHardness(6000000.0F);
        setBlockUnbreakable();
        setUnlocalizedName("bedrockclearglass");
/*        setBlockTextureName(Reference.MOD_ID + ":" + getUnlocalizedName().substring(5));*/
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

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
        public boolean isFullCube() {
        return false;
    }

    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add("This only works when the Connected Textures Mod is installed");
    }

}
