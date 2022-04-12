package dev.uten2c.fluoritedatagenerator.mixin;

import net.minecraft.server.dedicated.EulaReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EulaReader.class)
public class MixinEulaReader {
    @Inject(method = "isEulaAgreedTo", at = @At("HEAD"), cancellable = true)
    private void alwaysTrue(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
