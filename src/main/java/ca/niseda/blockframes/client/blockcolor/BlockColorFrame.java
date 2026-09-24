package ca.niseda.blockframes.client.blockcolor;

import ca.niseda.blockframes.block.TileEntityFrame;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.color.*;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class BlockColorFrame extends BlockColor {
	public static List<Class<?>> allowedBlockColors = new ArrayList<>();

	static {
		allowedBlockColors.add(BlockColorCustom.class);
		allowedBlockColors.add(BlockColorTallGrass.class);
		allowedBlockColors.add(BlockColorLeavesOak.class);
		// you can mixin into this if you want your mod's colored blocks to have support (careful with colorizers that check blockstates though!)
	}

	public BlockColorFrame() {
	}

	public int getFallbackColor(int meta, int tintIndex) {
		return (new Color()).setRGB(255, 255, 255).value;
	}

	public int getWorldColor(@NotNull WorldSource source, @NotNull TilePosc tilePos, int tintIndex) {
		TileEntityFrame tile = (TileEntityFrame) source.getTileEntity(tilePos);
		if (tile == null || tile.item == null)
			return 0xFFFFFFFF;
		ItemBlock<?> item = (ItemBlock<?>) tile.item.getItem();
		BlockColor color = BlockColorDispatcher.getInstance().getDispatch(item.getBlock());
		if (color == null)
			return 0xFFFFFFFF;
		for (Class<?> colorClass : allowedBlockColors) {
			if (colorClass.isInstance(color))
				return color.getWorldColor(source,tilePos,tintIndex);
		}
		return 0xFFFFFFFF;
	}
}
