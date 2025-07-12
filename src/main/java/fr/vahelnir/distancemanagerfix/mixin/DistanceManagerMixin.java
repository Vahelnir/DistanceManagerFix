package fr.vahelnir.distancemanagerfix.mixin;

import net.minecraft.server.level.DistanceManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(DistanceManager.class)
public class DistanceManagerMixin {
    @Final
    @Shadow
    @Mutable
    Set<?> chunksToUpdateFutures;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(CallbackInfo ci) {
        this.chunksToUpdateFutures = ConcurrentHashMap.newKeySet();
    }
}

