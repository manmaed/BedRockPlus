package manmaed.bedrockplus.libs.util.events;

import manmaed.bedrockplus.BedRockPlus;
import manmaed.bedrockplus.libs.Reference;
import manmaed.bedrockplus.libs.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by manmaed on 03/07/2017.
 */
public class EventModelRender
{

    public EventModelRender()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderModels(ModelRegistryEvent event)
    {
        //LogHelper.info("Starting Block rendering for " + Reference.MOD_ID + "...");
        LogHelper.info(Reference.MOD_LOG + " " + "I'm on a Client! Loading renders for blocks");
        for (Block block : BedRockPlus.getRegistryHelper().getRegisteredBlocks()) {
            //LogHelper.debug("Rendering Block... " + block.getUnlocalizedName());
            ResourceLocation rl = block.getRegistryName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(rl, "inventory"));
        }
        LogHelper.info(Reference.MOD_LOG + " " + "I gave up and just spawned it!");
        //LogHelper.info("Finished Block rendering for " + Reference.MOD_ID + "...");
    }
}