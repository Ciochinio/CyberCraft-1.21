package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.entity.Entity;

public class CybercraftPlayerBaseStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftHealth = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftMovementSpeed = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftArmor = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftToughness = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftPassiveHealthRegeneration = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftMitigationChance = 10;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftHackDamage = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftAttackSpeed = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftCritChance = 5;
			_vars.syncPlayerVariables(entity);
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.cybercraftCritDamage = 50;
			_vars.syncPlayerVariables(entity);
		}
	}
}
