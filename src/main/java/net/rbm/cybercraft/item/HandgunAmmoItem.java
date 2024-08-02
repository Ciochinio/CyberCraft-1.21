
package net.rbm.cybercraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HandgunAmmoItem extends Item {
	public HandgunAmmoItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
