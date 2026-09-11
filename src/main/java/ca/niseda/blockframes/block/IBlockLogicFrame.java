package ca.niseda.blockframes.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IBlockLogicFrame {
	default void init(Block<?> block) {
		block.withEntity(TileEntityFrame::new);
	}

	default boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		ItemStack item = player.getHeldItem();
		TileEntityFrame tile = (TileEntityFrame) world.getTileEntity(tilePos);
		if (tile != null && item != null) {
			if (item.getItem() instanceof ItemBlock<?> itemBlock && !(itemBlock.getBlock().getLogic() instanceof IBlockLogicFrame) && itemBlock.getBlock().getLogic().isCubeShaped()) {
				tile.item = item.copy();
				tile.item.stackSize = 1;
				item.consumeItem(player);
				world.notifyBlockChange(tilePos, world.getBlockType(tilePos));
				return true;
			}
		}
		return false;
	}
}
