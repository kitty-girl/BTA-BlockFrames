package ca.niseda.blockframes.block;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TileEntityFrame extends TileEntity {
	public ItemStack item = null;

	public TileEntityFrame() {}

	@Override
	public void readAdditionalData(@NotNull CompoundTag compoundTag) {
		item = ItemStack.readItemStackFromNbt(compoundTag.getCompound("Item"));
	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {
		if (item != null)
			compoundTag.putCompound("Item", item.writeToNBT(new CompoundTag()));
	}
}
