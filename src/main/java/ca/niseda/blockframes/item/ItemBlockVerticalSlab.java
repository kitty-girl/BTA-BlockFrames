//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.niseda.blockframes.item;

import ca.niseda.blockframes.block.types.BlockLogicVerticalSlab;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.IAccumulatable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemBlockVerticalSlab<T extends BlockLogic> extends ItemBlock<T> implements IAccumulatable<T> {
	public ItemBlockVerticalSlab(@NotNull Block<T> block) {
		super(block);
	}

	public boolean canAccumulateInto(@NotNull ItemStack selfStack, @NotNull Block<?> block, int data, @NotNull Side side, double xHit, double yHit) {
		if (this.block == block && (data & 0b1000) == 0) {
			if (block.getLogic() instanceof BlockLogicVerticalSlab) {
				return side.direction == BlockLogicVerticalSlab.getDirectionFromMeta(data);
			}
		}

		return false;
	}

	public IAccumulatable.@NotNull BlockDataResult getAccumulationResult(@NotNull ItemStack selfStack, @NotNull World world, @Nullable Player player, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit, IAccumulatable.@NotNull BlockDataResult result) {
		result.data = result.data | 8;
		result.bounds.setMin(0.0F, 0.0F, 0.0F).setMax(1.0F, 1.0F, 1.0F);
		return result;
	}

	public void postAccumulate(@NotNull ItemStack selfStack, @NotNull World world, @Nullable Player player, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit, IAccumulatable.@NotNull BlockDataResult result) {
		this.block.onPlacedByWorld(world, tilePos);
	}
}
