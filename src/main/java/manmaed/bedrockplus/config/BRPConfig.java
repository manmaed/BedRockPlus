package manmaed.bedrockplus.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Created by manmaed on 25/07/2021.
 */
public class BRPConfig {

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static final String CAT_CRAFTING = "Crafting";
    public static ForgeConfigSpec.BooleanValue ENABLE_CRAFTING;

    static {
        COMMON_BUILDER.comment("Crafting Settings").push(CAT_CRAFTING);
        ENABLE_CRAFTING = COMMON_BUILDER.comment("Enable Crafting? [DEFAULT: FALSE]").define("enable_crafting", false);
        COMMON_BUILDER.pop();


        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}
