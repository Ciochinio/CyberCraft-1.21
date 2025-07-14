package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMenus;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SaveProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.frontalcortex1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(0).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.frontalcortex2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(1).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.operatingsystem1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(2).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.arms1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(3).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.face1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(4).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(4).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.skeleton1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(5).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(5).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.skeleton2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(6).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(6).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.hands1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(7).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(7).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.nervoussystem1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(8).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(8).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.nervoussystem2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(9).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(9).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.circulatorysystem1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(10).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(10).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.circulatorysystem2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(11).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(11).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.integumentarysystem1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(12).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(12).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.integumentarysystem2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(13).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(13).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.legs1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(14).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof CybercraftModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(14).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.save = true;
			_vars.syncPlayerVariables(entity);
		}
		CybercrafPlayerStatCheckProcedure.execute(world, entity);
	}
}