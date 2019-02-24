package manmaed.bedrockplus;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;


/**
 * Created by manmaed on 03/07/2017.
 */
public class ConfigurationCondition implements IConditionFactory {

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json)
    {
        JsonPrimitive categoryName = json.getAsJsonPrimitive("category");
        JsonPrimitive keyName = json.getAsJsonPrimitive("key");

        ConfigCategory category = ConfigManager.instance.config.getCategory(categoryName.getAsString());
        Property property = category.get(keyName.getAsString());

        return property::getBoolean;
    }
}
