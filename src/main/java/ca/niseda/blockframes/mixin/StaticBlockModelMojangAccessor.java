package ca.niseda.blockframes.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.useless.dragonfly.data.block.mojang.CompiledBlockModelMojangData;
import org.useless.dragonfly.models.block.mojang.StaticBlockModelMojang;

@Environment(EnvType.CLIENT)
@Mixin(StaticBlockModelMojang.class)
public interface StaticBlockModelMojangAccessor {
	@Accessor("compiled")
	CompiledBlockModelMojangData blockframes$getCompiled();
}
