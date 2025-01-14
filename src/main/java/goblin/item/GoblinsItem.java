
package goblin.item;

import goblin.Goblins;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class GoblinsItem extends Item {
	public GoblinsItem(String stringName)
	{
		setUnlocalizedName(stringName);
		
		if (!(stringName.contains("icon_"))) //do not add icons as items in the creative tab
    	{
        	setCreativeTab(Goblins.GOBLINS_CREATIVE_TAB);	
    	}
	}
	
	public GoblinsItem()
	{
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("goblin" + getUnlocalizedName().replaceFirst("item.", ":"));
	}
}
