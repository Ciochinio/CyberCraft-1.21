package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class CybercraftPlayerStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Health" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftHealth)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Movement Speed " + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMovementSpeed)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Armor" + (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Intelligence" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftHackDamage)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Toughness" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftToughness)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("HP Regen" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftPassiveHealthRegeneration)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Mitigation Chance" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMitigationChance)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Attack Speed" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftAttackSpeed)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Crit Rate" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritChance)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Crit Damage" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritDamage)), false);
	}
}
