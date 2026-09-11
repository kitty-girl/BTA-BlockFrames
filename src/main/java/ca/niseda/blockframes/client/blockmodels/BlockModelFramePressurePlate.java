package ca.niseda.blockframes.client.blockmodels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.generic.BlockModelGenericPressurePlate;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicPressurePlate;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BlockModelFramePressurePlate<T extends BlockLogicPressurePlate<?>> extends BlockModelGenericPressurePlate<T> implements IBlockModelFrame {
	public BlockModelFramePressurePlate(@NotNull Block<T> block) {
		super(block, "blockframes:block/pressure_plate/frame");
	}
	@Override
	public boolean render(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos) {
		return super.renderWithOverrideTexture(tessellator,worldSource,tilePos, getBlockTexture(worldSource, tilePos, Side.TOP));
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
