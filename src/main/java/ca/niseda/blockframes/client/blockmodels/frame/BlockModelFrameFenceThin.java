package ca.niseda.blockframes.client.blockmodels.frame;

import ca.niseda.blockframes.client.blockmodels.IBlockModelFrame;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.generic.BlockModelGenericFenceThin;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFenceThin;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BlockModelFrameFenceThin<T extends BlockLogicFenceThin> extends BlockModelGenericFenceThin<T> implements IBlockModelFrame {
	public BlockModelFrameFenceThin(@NotNull Block<T> block) {
		super(block, "blockframes:block/fence_thin/frame");
	}
	@Override
	public boolean render(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos) {
		return super.renderWithOverrideTexture(tessellator,worldSource,tilePos, getBlockTexture(worldSource, tilePos));
	}
}
