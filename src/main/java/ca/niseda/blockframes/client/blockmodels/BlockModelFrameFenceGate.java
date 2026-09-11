package ca.niseda.blockframes.client.blockmodels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelFenceGate;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFenceGate;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BlockModelFrameFenceGate<T extends BlockLogicFenceGate> extends BlockModelFenceGate<T> implements IBlockModelFrame {
	public BlockModelFrameFenceGate(@NotNull Block<T> block) {
		super(block);
	}
	public IconCoordinate getBlockTextureFromSideAndMetadata(@NotNull Side side, int data) {
		return IBlockModelFrame.super.getBlockTextureFromSideAndMetadata(side,data);
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
