package ca.niseda.blockframes.client.blockmodels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLever;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.block.StaticBlockModel;

@Environment(EnvType.CLIENT)
public class BlockModelFrameLever<T extends BlockLogicLever> extends BlockModelGeneric<T> implements IBlockModelFrame {
	public @NotNull StaticBlockModel active = BlockModelDispatcher.loadDataModel("blockframes:block/frame_lever_active").asModel();

	public BlockModelFrameLever(@NotNull Block<T> block) {
		super(block, BlockModelDispatcher.loadDataModel("blockframes:block/frame_lever_idle"));
	}
	public boolean renderAttached(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos, boolean cullFaces, @Nullable IconCoordinate overrideTexture) {
		int data = worldSource.getBlockData(tilePos);
		int rotation = data & 15;
		boolean var10000;
		switch (rotation) {
			case 1 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 1, 1, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 2 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 1, 3, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 3 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 1, 0, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 4 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 1, 2, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 5 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 6 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 0, 1, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 7 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 2, 0, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			case 8 -> var10000 = this.getModel(worldSource, tilePos).renderAttached(this, tessellator, worldSource, tilePos, 2, 1, 0, 0.0F, 0.0F, 0.0F, false, cullFaces, overrideTexture);
			default -> var10000 = super.renderAttached(tessellator, worldSource, tilePos, cullFaces, overrideTexture);
		}

		return var10000;
	}

	public @NotNull StaticBlockModel getModelFromData(int data) {
		boolean powered = (data & 16) != 0;
		return powered ? this.active : this.staticModel;
	}

	@Override
	public boolean render(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos) {
		return super.renderWithOverrideTexture(tessellator,worldSource,tilePos, getBlockTexture(worldSource, tilePos, Side.TOP));
	}
	public IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		return IBlockModelFrame.super.getBlockTexture(source,tilePos,side);
	}
}
