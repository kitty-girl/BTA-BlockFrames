package ca.niseda.blockframes.client.blockmodels;

import ca.niseda.blockframes.block.BlockLogicVerticalSlab;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
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
		return super.renderWithOverrideTexture(tessellator,worldSource,tilePos, getBlockTexture(worldSource, tilePos, Side.TOP));
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
