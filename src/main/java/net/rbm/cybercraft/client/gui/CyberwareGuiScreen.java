package net.rbm.cybercraft.client.gui;

import net.rbm.cybercraft.world.inventory.CyberwareGuiMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CyberwareGuiScreen extends AbstractContainerScreen<CyberwareGuiMenu> {
	private final static HashMap<String, Object> guistate = CyberwareGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CyberwareGuiScreen(CyberwareGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 294;
		this.imageHeight = 235;
	}

	private static final ResourceLocation texture = new ResourceLocation("cybercraft:textures/screens/cyberware_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("cybercraft:textures/screens/test.png"), this.leftPos + 104, this.topPos + 9, 0, 0, 85, 140, 85, 140);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_operating_system"), 173, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_frontal_cortex"), 38, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_face"), 181, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_arms"), 65, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_hands"), 191, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_skeleton"), 56, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_circulatory_system"), 200, 86, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_nervous_s_ystem"), 29, 86, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_legs"), 173, 113, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cybercraft.cyberware_gui.label_integumentary_system"), 2, 113, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
