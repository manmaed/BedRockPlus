package manmaed.bedrockplus.libs.util.events;

import manmaed.bedrockplus.BedRockPlus;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by manmaed on 03/07/2017.
 */
public class EventBlockRegister {

    public EventBlockRegister()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        //LogHelper.info("Starting Block registering for " + Reference.MOD_ID + "...");
        for (Block block : BedRockPlus.getRegistryHelper().getRegisteredBlocks()) {
            //LogHelper.debug("Registering Block... " + block.getUnlocalizedName());
            event.getRegistry().registerAll(block);
        }
        //LogHelper.info("Finished Block registering for " + Reference.MOD_ID);
    }

}
