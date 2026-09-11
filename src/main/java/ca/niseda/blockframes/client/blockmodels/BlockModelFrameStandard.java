package ca.niseda.blockframes.client.blockmodels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelTransparent;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BlockModelFrameStandard<T extends BlockLogic> extends BlockModelTransparent<T> implements IBlockModelFrame {
	public BlockModelFrameStandard(@NotNull Block<T> block) {
		super(block, false);
	}
	public IconCoordinate getBlockTextureFromSideAndMetadata(@NotNull Side side, int data) {
		return IBlockModelFrame.super.getBlockTextureFromSideAndMetadata(side,data);
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
