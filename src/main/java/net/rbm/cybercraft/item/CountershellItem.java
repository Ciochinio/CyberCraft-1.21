
package net.rbm.cybercraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CountershellItem extends Item {
	public CountershellItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
