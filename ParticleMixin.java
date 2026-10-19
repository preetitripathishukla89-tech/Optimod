package com.mj.mobileopti.mixin;

import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Particle.class)
public class ParticleMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void reduceParticles(CallbackInfo ci) {
        if (Math.random() < 0.5) {
            ci.cancel();
        }
    }
}