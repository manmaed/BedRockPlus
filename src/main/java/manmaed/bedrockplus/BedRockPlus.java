package manmaed.bedrockplus;

import manmaed.bedrockplus.block.BRPBlocks;
import manmaed.bedrockplus.creativetab.BRPCreativeTab;
import manmaed.bedrockplus.libs.Reference;
import manmaed.bedrockplus.libs.iChun;
import manmaed.bedrockplus.libs.util.LogHelper;
import manmaed.bedrockplus.libs.util.RegistryHelper;
import manmaed.bedrockplus.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, certificateFingerprint = "@FINGERPRINT@")

public class BedRockPlus {

	@Mod.Instance(Reference.MOD_ID)
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
	}
}

