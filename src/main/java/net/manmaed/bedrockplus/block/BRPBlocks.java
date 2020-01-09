package net.manmaed.bedrockplus.block;

import net.manmaed.bedrockplus.BedRockPlus;
import net.manmaed.bedrockplus.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ObjectHolder;

public class BRPBlocks {

    /*public static BRPBlockBase brpglass;
    public static BRPBlockBase brpstonebricks;
    public static BRPBlockBase brpglowstone;
    public static BRPBlockBase brpcglass;
    public static BlockLadder brpladder;*/
    //        public static final Block BEDROCK = register("bedrock", new BedrockBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 3600000.0F).noDrops()));
    private static float hard = -1.0F;
    private static float ress = 3600000.0F;
    @ObjectHolder(Reference.REGISTER + "stonebrick")
    public static Block stonebricks;

    @ObjectHolder(Reference.REGISTER + "glowstone")
    public static Block glowstone;

    @ObjectHolder(Reference.REGISTER + "glass")
    public static Block glass;

    @ObjectHolder(Reference.REGISTER + "ladder")
    public static Block ladder;
    public static Block sbstairs;
    public static Block brstairs;

    public static void load() {

        stonebricks = new BRPBlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(hard, ress).sound(SoundType.STONE).noDrops(), "stonebrick", false);
        glowstone = new BRPBlockBase(Block.Properties.create(Material.GLASS).hardnessAndResistance(hard, ress).sound(SoundType.GLASS).noDrops(),"glowstone", false);
        glass  = new BRPBlockBase(Block.Properties.create(Material.GLASS).hardnessAndResistance(hard, ress).sound(SoundType.GLASS).noDrops().lightValue(15),"glass", true);
        ladder = new BRPLadder(Block.Properties.create(Material.ROCK).hardnessAndResistance(hard, ress).sound(SoundType.STONE).noDrops(), "ladder");


        BedRockPlus.getRegisteryHandler().registerBlock(stonebricks);
        BedRockPlus.getRegisteryHandler().registerBlock(glowstone);
        BedRockPlus.getRegisteryHandler().registerBlock(glass);
        BedRockPlus.getRegisteryHandler().registerBlock(ladder);

        //Init'ing
        /*brpglass = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockglass");
        brpstonebricks = new BRPBlockBase(Material.ROCK, SoundType.STONE, false, "bedrockstonebrick");
        brpglowstone = new BRPBlockBase(Material.GLASS, SoundType.GLASS, true, "bedrockglowstone");
        brpcglass = new BRPBlockBase(Material.GLASS, SoundType.GLASS, false, "bedrockclearglass");
        brpcglass.settooltop("This only works when the Connected Textures Mod is installed");
        brpladder = new BRPLadder("bedrockladder");*/


        /*BedRockPlus.getRegisteryHandler().registerBlock(brpglass);
        BedRockPlus.getRegisteryHandler().registerBlock(brpstonebricks);
        BedRockPlus.getRegisteryHandler().registerBlock(brpglowstone);
        BedRockPlus.getRegisteryHandler().registerBlock(brpladder);*/

        //THing?
        /*brpglass.setRegistryName("bedrockglass");
        brpstonebricks.setRegistryName("bedrockstonebrick");
        brpglowstone.setRegistryName("bedrockglowstone");
        brpcglass.setRegistryName("bedrockclearglass");
        brpladder.setRegistryName("bedrockladder");*/
	}
}
