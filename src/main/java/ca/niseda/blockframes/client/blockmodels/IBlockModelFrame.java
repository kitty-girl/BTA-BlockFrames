package ca.niseda.blockframes.client.blockmodels;

import ca.niseda.blockframes.block.TileEntityFrame;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.models.block.mojang.StaticBlockModelMojang;

import java.util.List;

@Environment(EnvType.CLIENT)
public interface IBlockModelFrame {
	IconCoordinate framedTexture = TextureRegistry.getTexture("blockframes:block/block_frame");

	default IconCoordinate getBlockTextureFromSideAndMetadata(@NotNull Side side, int data) {
		return framedTexture;
	}

	default IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos, @NotNull Side side) {
		if (source.getTileEntity(tilePos) instanceof TileEntityFrame tileEntityFrame && tileEntityFrame.item != null && tileEntityFrame.item.getItem() instanceof ItemBlock<?> itemBlock) {
			BlockModel<?> blockModel = BlockModelDispatcher.getInstance().getDispatch(itemBlock.getBlock());
			if (blockModel instanceof BlockModelGeneric<?> blockModelGeneric) {
				if (blockModelGeneric.getModelFromData(tileEntityFrame.item.getMetadata()) instanceof StaticBlockModelMojang staticBlockModelMojang) {
					List<IconCoordinate> texList = staticBlockModelMojang.compiled.textures.values().stream().toList();
					return texList.get(0);
				}
			} else if (blockModel instanceof BlockModelStandard<?> blockModelStandard && !(blockModelStandard instanceof IBlockModelFrame)) {
				return blockModelStandard.getBlockTexture(source, tilePos, Side.TOP);
			}
		}
		return framedTexture;
	}
}
