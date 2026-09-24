package ca.niseda.blockframes.mixin;

import ca.niseda.blockframes.client.blockcolor.BlockColorFrame;
import ca.niseda.blockframes.registry.BFBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.util.dispatch.Dispatcher;
import net.minecraft.core.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BlockColorDispatcher.class)
public abstract class BlockColorDispatcherMixin extends Dispatcher<Block<?>, BlockColor> {
	@Inject(method = "reload()V", at = @At("TAIL"))
	public void reload(CallbackInfo ci) {
		for (Block<?> block : BFBlocks.FRAME_BLOCKS)
			this.addDispatch(block, new BlockColorFrame());
	}
}
