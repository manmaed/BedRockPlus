package manmaed.bedrockplus;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

/**
 * Created by manmaed on 03/07/2017.
 */
public class ConfigManager {
    public static ConfigManager instance;
    public final boolean enablerecipes;

    public static  void loadConfig(Configuration configuration) {
        instance = new ConfigManager(configuration);
    }

    public final Configuration config;

    public ConfigManager(Configuration configuration)
    {
        this.config = configuration;


        configuration.addCustomCategoryComment("Recipes", "Settings for the Adding Recipes");
        Property p_enablerecipes = configuration.get("Recipes", "EnableRecipes", false);

        configuration.load();

        enablerecipes = p_enablerecipes.getBoolean();


        boolean anyDefault = !p_enablerecipes.wasRead();

        if (anyDefault)
            configuration.save();
    }

}
