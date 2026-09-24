package ca.niseda.blockframes.client.blockmodels;

import ca.niseda.blockframes.block.TileEntityFrame;
import ca.niseda.blockframes.mixin.StaticBlockModelMojangAccessor;
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

	private static int wrap(int k, int n) {
		int remainder = k % n;
		return (remainder < 0) ? remainder + n : remainder;
	}

	default IconCoordinate getBlockTexture(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		if (source.getTileEntity(tilePos) instanceof TileEntityFrame tileEntityFrame && tileEntityFrame.item != null && tileEntityFrame.item.getItem() instanceof ItemBlock<?> itemBlock) {
			BlockModel<?> blockModel = BlockModelDispatcher.getInstance().getDispatch(itemBlock.getBlock());
			if (blockModel instanceof BlockModelGeneric<?> blockModelGeneric) {
				if (blockModelGeneric.getModelFromData(tileEntityFrame.item.getMetadata()) instanceof StaticBlockModelMojang staticBlockModelMojang) {
					List<IconCoordinate> texList = ((StaticBlockModelMojangAccessor) staticBlockModelMojang).blockframes$getCompiled().textures.values().stream().toList();
					return texList.get(wrap(tileEntityFrame.textureId, texList.size()-1));
				}
			} else if (blockModel instanceof BlockModelStandard<?> blockModelStandard && !(blockModelStandard instanceof IBlockModelFrame)) {
				return blockModelStandard.getBlockTexture(source, tilePos, Side.fromId(wrap(tileEntityFrame.textureId, 6)));
			}
		}
		return framedTexture;
	}
}
