package net.manmaed.bedrockplus;

import net.manmaed.bedrockplus.block.BRPBlocks;
import net.manmaed.bedrockplus.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod(Reference.MOD_ID)
public class BedRockPlus {

	private static RegisteryHandler registeryHandler;

	public static final ItemGroup itemGroup = new ItemGroup(Reference.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
		}
	};

	public BedRockPlus() {
		/*FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);*/
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInvalidFingerprint);
		registeryHandler = new RegisteryHandler();
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static RegisteryHandler getRegisteryHandler() {
		return registeryHandler;
	}

	/*@SubscribeEvent
	public void onInvalidFingerprint(final FMLFingerprintViolationEvent event) {
		LogHelper.info("Hello");
		if(event.isDirectory()) {
		    LogHelper.error(Reference.NO_FINGERPRINT_MESSAGE);
		}
		if(!event.isDirectory()) {
		    LogHelper.fatal(Reference.INVALID_FINGERPRINT_MESSAGE);
		}
	}*/

	public static class RegisteryHandler {
		private final ArrayList<Block> blocks = new ArrayList<>();
		private final ArrayList<Item> items = new ArrayList<>();
		public ArrayList<Block> getRegisteredBlocks()

		{
			return blocks;
		}
		public void registerBlock(Block block)
		{
			blocks.add(block);
		}
		public ArrayList<Item> getRegisteredItems()
		{
			return items;
		}
		public void registerItem(Item item)
		{
			this.items.add(item);
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            BRPBlocks.load();
			for (Block block : BedRockPlus.getRegisteryHandler().getRegisteredBlocks()) {
				event.getRegistry().registerAll(block);
			}
		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			/*BRPItems.load();*/
			for (Block block : BedRockPlus.getRegisteryHandler().getRegisteredBlocks()) {
				/*event.getRegistry().register(new BlockItem(new Block.Properties.from(block).setRegistryName(block.getRegistryName())));*/
				event.getRegistry().register(new BlockItem(block, new Item.Properties().group(BedRockPlus.itemGroup)).setRegistryName(block.getRegistryName()));
			}
			/*for (Item item : BedRockPlus.getRegisteryHandler().getRegisteredItems()) {
				event.getRegistry().register(item);
			}*/
		}
	}
}
/*public class BedRockPlus {

	@Mod.Instance(Reference.MOD_ID)
	public static BedRockPlus instance;
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
    private static RegistryHelper registryHelper;
    private static final String FINGERPRINT = "@FINGERPRINT@";
	private static boolean devenv = false;
	private static boolean alpha = false;
	private static boolean beta = false;
	private static boolean release = true;
	private static boolean devenvsign = true;
	private static boolean invalsign = false;

	//@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.PROXY_COMMON)
	public static CommonProxy proxy;

	public static CreativeTabs tabsBRP = new BRPCreativeTab(CreativeTabs.getNextID());


	@Mod.EventHandler
	public void onInvalidFingerprint(FMLFingerprintViolationEvent event)
	{
		if(event.isDirectory()){
			devenv = true;
			alpha = false;
			beta = false;
			release = false;
			devenvsign = true;
		}
		if(!event.isDirectory()) {
			invalsign = true;
		}
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ConfigManager.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
		if (ConfigManager.instance.enablerecipes) {
			LogHelper.info(Reference.MOD_LOG + " " + "Adding Recipes #Why?");
		}
		registryHelper = new RegistryHelper(event);
		LogHelper.info(Reference.MOD_LOG + " " + "Trying to make BedRock!");
        BRPBlocks.load();
		if(event.getSide().isServer()){
			LogHelper.info(Reference.MOD_LOG + " " + "Is this a Server?");
		}
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
	//Add thins
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//TODO: Move To iChun Class
		if (release) {
			LogHelper.info("Lets hope it does not shoot fire and blow up");
			LogHelper.info("-iChun 2015");
			LogHelper.info("yes that is in evey mod manmaed makes!");
		}
		if (beta) {
			LogHelper.info("Lets hope it does not shoot fire and blow up");
			LogHelper.info("-iChun 2015");
			LogHelper.warn("This is a Beta Release so it may shoot fire and blow up!");
		}
		if (alpha) {
			LogHelper.info("Lets hope it does not shoot fire and blow up");
			LogHelper.info("-iChun 2015");
			LogHelper.warn("This is a Alpha Release so it will shoot fire and blow up!");
		}
		if (devenv) {
			LogHelper.fatal("If you can see this msg in a Release build manmaed forgot to turn the boolean off");
			LogHelper.fatal("Please Report This!");
			if(devenvsign) {
				LogHelper.info(Reference.NO_FINGERPRINT_MESSAGE);
			}
		}
		if(invalsign) {
			LogHelper.warn(Reference.INVALID_FINGERPRINT_MESSAGE);
		}
	}

	public static RegistryHelper getRegistryHelper() {
		return registryHelper;
	}
}*/

