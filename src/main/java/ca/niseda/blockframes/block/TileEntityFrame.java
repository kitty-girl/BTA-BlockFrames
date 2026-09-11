package ca.niseda.blockframes.block;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

public class TileEntityFrame extends TileEntity {
	public ItemStack item = null;
	public int textureId = 0;

	public TileEntityFrame() {}

	@Override
	public void readAdditionalData(@NotNull CompoundTag compoundTag) {
		item = ItemStack.readItemStackFromNbt(compoundTag.getCompound("Item"));
		textureId = compoundTag.getInteger("Texture");
	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {
		if (item != null)
			compoundTag.putCompound("Item", item.writeToNBT(new CompoundTag()));
		compoundTag.putInt("Texture", textureId);
	}
	public void dropItem(World world, TilePosc tileposc) {
		if (item != null) {
			EntityItem itemEntity = world.dropItem(tileposc, item);
			itemEntity.xd *= 0.5F;
			itemEntity.yd *= 0.5F;
			itemEntity.zd *= 0.5F;
			itemEntity.pickupDelay = 0;
			item = null;
			textureId = 0;
			world.notifyBlockChange(tilePos, world.getBlockType(tilePos));
		}
	}

	public void dropContents(World world, int x, int y, int z) {
		super.dropContents(world, x, y, z);
		dropItem(world, new TilePos(x,y,z));
	}
}
