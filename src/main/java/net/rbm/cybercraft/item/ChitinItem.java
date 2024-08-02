
package net.rbm.cybercraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ChitinItem extends Item {
	public ChitinItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
