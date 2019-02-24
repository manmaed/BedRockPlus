package manmaed.bedrockplus.libs.util;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

public class RegistryHelper {

	private final ArrayList<Block> blocks = new ArrayList<>();

	private final EventRegisterHelper eventRegisterHelper;

	public RegistryHelper(FMLPreInitializationEvent event)
	{
		this.eventRegisterHelper = new EventRegisterHelper(event);

	}

	public ArrayList<Block> getRegisteredBlocks()
	{
		return blocks;
	}

	public void registerBlock(Block brpBlocks)
	{
		blocks.add(brpBlocks);
	}

}
