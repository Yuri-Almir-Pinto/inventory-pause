package com.yipeekiyaay.inventorypause.mixin;

import com.yipeekiyaay.inventorypause.Inventorypausemod;
import com.yipeekiyaay.inventorypause.utils.ScreenHelper;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {

    @Inject(method = "shouldPause", at = @At("HEAD"), cancellable = true)
    public void isPauseScreen(CallbackInfoReturnable cir) {
        isPauseScreenDebugMethod(cir);
    }

    @Unique
    public void isPauseScreenDebugMethod(CallbackInfoReturnable cir) {
        if (ScreenHelper.isConfiguredScreen(this)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

}
