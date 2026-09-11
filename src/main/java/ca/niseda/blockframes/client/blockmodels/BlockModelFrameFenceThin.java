package ca.niseda.blockframes.client.blockmodels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelFenceThin;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFenceThin;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BlockModelFrameFenceThin<T extends BlockLogicFenceThin> extends BlockModelFenceThin<T> implements IBlockModelFrame {
	public BlockModelFrameFenceThin(@NotNull Block<T> block) {
		super(block, IBlockModelFrame.framedTexture, null, null, IBlockModelFrame.framedTexture);
	}
	@Override
	public boolean render(@NotNull TessellatorGeneral t, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos) {
		IconCoordinate tex = getBlockTexture(worldSource, tilePos, Side.TOP);
		if (tex != null) {
			texIndex = tex;
			columnTexIndex = tex;
			boolean a = super.render(t, worldSource, tilePos);
			texIndex = IBlockModelFrame.framedTexture;
			columnTexIndex = IBlockModelFrame.framedTexture;
			return a;
		} else {
			return super.render(t, worldSource, tilePos);
		}
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(@NotNull Side side, int data) {
		return IBlockModelFrame.super.getBlockTextureFromSideAndMetadata(side,data);
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
