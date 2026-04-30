/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import org.lwjgl.glfw.GLFW;

import net.rbm.cybercraft.network.OperatingSystemActivateMessage;
import net.rbm.cybercraft.network.DoubleJumpMessage;
import net.rbm.cybercraft.network.CyberwareMenuMessage;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(Dist.CLIENT)
public class CybercraftModKeyMappings {
	public static final KeyMapping CYBERWARE_MENU = new KeyMapping("key.cybercraft.cyberware_menu", GLFW.GLFW_KEY_F8, "key.categories.cybercraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new CyberwareMenuMessage(0, 0));
				CyberwareMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOUBLE_JUMP = new KeyMapping("key.cybercraft.double_jump", GLFW.GLFW_KEY_SPACE, "key.categories.cybercraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new DoubleJumpMessage(0, 0));
				DoubleJumpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPERATING_SYSTEM_ACTIVATE = new KeyMapping("key.cybercraft.operating_system_activate", GLFW.GLFW_KEY_X, "key.categories.cybercraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OperatingSystemActivateMessage(0, 0));
				OperatingSystemActivateMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(CYBERWARE_MENU);
		event.register(DOUBLE_JUMP);
		event.register(OPERATING_SYSTEM_ACTIVATE);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				CYBERWARE_MENU.consumeClick();
				DOUBLE_JUMP.consumeClick();
				OPERATING_SYSTEM_ACTIVATE.consumeClick();
			}
		}
	}
}