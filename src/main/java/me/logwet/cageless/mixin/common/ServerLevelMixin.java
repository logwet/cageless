package me.logwet.cageless.mixin.common;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @ModifyArgs(
            method = "makeObsidianPlatform",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lnet/minecraft/core/BlockPos;betweenClosed(IIIIII)Ljava/lang/Iterable;",
                            ordinal = 0))
    private static void clearCage(Args args) {
        args.set(0, (int) args.get(0) - 3);
        args.set(2, (int) args.get(2) - 3);
        args.set(3, (int) args.get(3) + 3);
        args.set(4, (int) args.get(4) + 16);
        args.set(5, (int) args.get(5) + 3);
    }
}
