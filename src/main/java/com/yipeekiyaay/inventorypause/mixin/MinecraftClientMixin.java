package com.yipeekiyaay.inventorypause.mixin;

import com.yipeekiyaay.inventorypause.utils.ScreenHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.server.integrated.IntegratedServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
	@Shadow
	public abstract SoundManager getSoundManager();
	@Shadow
	public abstract boolean isIntegratedServerRunning();
	@Shadow
	private @Nullable IntegratedServer server;

	@Inject(at = @At("TAIL"), method = "setScreen")
	public void openScreen(Screen screen, CallbackInfo ci) {
		screenDebugMethod(screen, ci);
	}

	@Unique
	public void screenDebugMethod(Screen screen, CallbackInfo ci) {
		if (ScreenHelper.isConfiguredScreen(screen))
		{
			boolean canPauseGame = isIntegratedServerRunning() && !Objects.requireNonNull(this.server).isRemote();
			if(canPauseGame) {
				this.getSoundManager().pauseAll();
			}
		}
	}
}