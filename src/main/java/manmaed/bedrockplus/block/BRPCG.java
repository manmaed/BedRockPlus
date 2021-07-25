package manmaed.bedrockplus.block;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by manmaed on 25/07/2021.
 */
public class BRPCG extends Block {
    public BRPCG(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> list, TooltipFlag flag) {
        list.add(Component.nullToEmpty("This only works when the Connected Textures Mod is installed"));
    }
}
