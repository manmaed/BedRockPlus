package manmaed.bedrockplus;

import manmaed.bedrockplus.config.BRPConfig;
import manmaed.bedrockplus.libs.Reference;
import manmaed.bedrockplus.libs.RegisterHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class BedRockPlus {

	public static RegisterHandler registerHandler;
	public static final CreativeModeTab itemGroup = new CreativeModeTab(Reference.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Blocks.BEDROCK.asItem());
		}
	};

	public BedRockPlus() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(BedRockPlusClient::doClientStuff);
		registerHandler = new RegisterHandler();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BRPConfig.COMMON_CONFIG);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void init(final FMLCommonSetupEvent event) {

	}

	public static RegisterHandler getRegisteryHandler() {
		return registerHandler;
	}

}
//OLD CODE
//TODO: Remove
/*@Mod.Instance(Reference.MOD_ID)
	public static BedRockPlus instance;
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
    private static RegistryHelper registryHelper;
    private static final String FINGERPRINT = "@FINGERPRINT@";
	private static boolean devenvsign = false;
	private static boolean invalsign = false;

	//@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.PROXY_COMMON)
	public static CommonProxy proxy;

	public static CreativeTabs tabsBRP = new BRPCreativeTab(CreativeTabs.getNextID());


	@Mod.EventHandler
	public void onInvalidFingerprint(FMLFingerprintViolationEvent event)
	{
		if(event.isDirectory()){
			iChun.setdev();
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
		iChun.RuniChunMagic();
		if(devenvsign) {
			LogHelper.info(Reference.NO_FINGERPRINT_MESSAGE);
		}
		if(invalsign) {
			LogHelper.warn(Reference.INVALID_FINGERPRINT_MESSAGE);
		}
	}

	public static RegistryHelper getRegistryHelper() {
		return registryHelper;
	}*/
