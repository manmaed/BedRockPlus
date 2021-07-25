package manmaed.bedrockplus;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 25/07/2021.
 */
public class BedRockPlusClient
{

    public static void doClientStuff(FMLClientSetupEvent event) {
            for (Block block : BedRockPlus.getRegisteryHandler().getRegisteredBlocks()) {
                ItemBlockRenderTypes.setRenderLayer(block,
                        renderType -> renderType == RenderType.solid() || renderType == RenderType.translucent());
            }
        }
}
