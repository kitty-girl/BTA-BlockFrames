package ca.niseda.blockframes.client.blockmodels.frame;

import ca.niseda.blockframes.block.types.BlockLogicVerticalSlab;
import ca.niseda.blockframes.client.blockmodels.BlockModelGenericVerticalSlab;
import ca.niseda.blockframes.client.blockmodels.IBlockModelFrame;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.data.block.BlockModelData;

@Environment(EnvType.CLIENT)
public class BlockModelFrameVerticalSlab<T extends BlockLogicVerticalSlab> extends BlockModelGenericVerticalSlab<T> implements IBlockModelFrame {
	public BlockModelFrameVerticalSlab(@NotNull Block<T> block, @NotNull BlockModelData staticModel, @NotNull BlockModelData fullBlockModel) {
		super(block, staticModel, fullBlockModel);
	}
	@Override
	public boolean render(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos) {
		return super.renderWithOverrideTexture(tessellator, worldSource, tilePos, getBlockTexture(worldSource, tilePos));
	}
}
