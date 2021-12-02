package net.manmaed.bedrockplus;

import net.manmaed.bedrockplus.blocks.BRPBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Created by net.manmaed on 25/07/2021.
 */
public class BedRockPlusClient
{

    public static void doClientStuff(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_STONEBRICKS.get(), renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_CLEARGLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_GLOWSTONE.get(), renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_LADDER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BRPBlocks.BR_SB_STAIRS.get(), renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
    }
}
