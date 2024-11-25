
package goblin.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import goblin.entity.projectile.EntityArcaneball;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class ItemStaffArcane extends GoblinsItem {
	public int timer;

	public ItemStaffArcane(String stringName)
	{
		super(stringName);
		maxStackSize = 1;
		setMaxDamage(30);
		timer = 0;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (timer == 0)
		{
			entityPlayer.swingItem();
			
			if (!entityPlayer.capabilities.isCreativeMode)
			{
				itemStack.damageItem(1, (EntityLivingBase) entityPlayer);
			}
			world.playSoundAtEntity((Entity) entityPlayer, "mob.ghast.fireball", 0.5f, 0.4f / (ItemStaffArcane.itemRand.nextFloat() * 0.4f + 0.8f));
			if (!world.isRemote)
			{
				world.spawnEntityInWorld((Entity) new EntityArcaneball(world, (EntityLivingBase) entityPlayer, 2.0f));
				timer = 30;
			}
		}
		return itemStack;
	}

	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag)
	{
		if (timer > 0)
		{
			--timer;
		}
	}
}