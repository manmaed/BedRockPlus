package manmaed.bedrockplus.creativetab;

import manmaed.bedrockplus.libs.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class BRPCreativeTab extends CreativeTabs {

    public BRPCreativeTab(int id)
    {
        super(Reference.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
    }

    public String getTranslatedTabLabel()
    {
        return I18n.translateToLocal("creativeBedRockPlus.name");
    }

}