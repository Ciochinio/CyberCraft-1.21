package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class ReadProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).frontalcortex1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).frontalcortex1.getCount());
			((Slot) _slots.get(0)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).frontalcortex2.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).frontalcortex2.getCount());
			((Slot) _slots.get(1)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).operatingsystem1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).operatingsystem1.getCount());
			((Slot) _slots.get(2)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).arms1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).arms1.getCount());
			((Slot) _slots.get(3)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).face1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).face1.getCount());
			((Slot) _slots.get(4)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton1.getCount());
			((Slot) _slots.get(5)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton2.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton2.getCount());
			((Slot) _slots.get(6)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).hands1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).hands1.getCount());
			((Slot) _slots.get(7)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem1.getCount());
			((Slot) _slots.get(8)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem2.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem2.getCount());
			((Slot) _slots.get(9)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem1.getCount());
			((Slot) _slots.get(10)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem2.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem2.getCount());
			((Slot) _slots.get(11)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getCount());
			((Slot) _slots.get(12)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getCount());
			((Slot) _slots.get(13)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).legs1.copy();
			_setstack.setCount(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).legs1.getCount());
			((Slot) _slots.get(14)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}
