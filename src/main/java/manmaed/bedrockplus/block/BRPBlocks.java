package manmaed.bedrockplus.block;

import manmaed.bedrockplus.BedRockPlus;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BRPBlocks {

    public static BRPBlockBase brpglass;
    public static BRPBlockBase brpstonebricks;
    public static BRPBlockBase brpglowstone;
    public static BRPBlockBase brpcglass;
    public static BlockLadder brpladder;
	
	public static void load() {
		//Init'ing
        brpglass = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockglass");
        brpstonebricks = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockstonebrick");
        brpglowstone = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockglowstone");
        brpcglass = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockclearglass");
        brpladder = new BRPLadder();


        BedRockPlus.getRegistryHelper().registerBlock(brpglass);
        BedRockPlus.getRegistryHelper().registerBlock(brpstonebricks);
        BedRockPlus.getRegistryHelper().registerBlock(brpglowstone);
        BedRockPlus.getRegistryHelper().registerBlock(brpcglass);
        BedRockPlus.getRegistryHelper().registerBlock(brpladder);

        //THing?
        /*brpglass.setRegistryName("bedrockglass");
        brpstonebricks.setRegistryName("bedrockstonebrick");
        brpglowstone.setRegistryName("bedrockglowstone");
        brpcglass.setRegistryName("bedrockclearglass");*/
        brpladder.setRegistryName("bedrockladder");
	}
}
