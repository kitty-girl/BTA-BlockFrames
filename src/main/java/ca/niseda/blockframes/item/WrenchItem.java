package ca.niseda.blockframes.item;

import ca.niseda.blockframes.block.TileEntityFrame;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrenchItem extends Item {
	public WrenchItem(@NotNull String translationKey, @NotNull String namespaceId, int id) {
		super(translationKey, namespaceId, id);
	}

	public boolean onUseOnBlock(@NotNull ItemStack selfStack, @NotNull World world, @Nullable Player player, @NotNull TilePosc blockPos, @NotNull Side side, double xHit, double yHit) {
		if (player == null) {return false;}
		ItemStack item = player.getHeldItem();
		TileEntity tile = world.getTileEntity(blockPos);
		if (item != null && tile instanceof TileEntityFrame tileFrame) {
			tileFrame.textureId += player.isSneaking() ? 1 : -1;
			world.notifyBlockChange(blockPos, world.getBlockType(blockPos));
			return true;
		}
		return false;
	}
}
