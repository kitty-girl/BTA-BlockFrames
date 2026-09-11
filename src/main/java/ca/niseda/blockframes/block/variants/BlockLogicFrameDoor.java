package ca.niseda.blockframes.block.variants;

import ca.niseda.blockframes.block.IBlockLogicFrame;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BlockLogicFrameDoor extends BlockLogicDoor implements IBlockLogicFrame {
	public BlockLogicFrameDoor(@NotNull Block<?> block, boolean isTop, boolean ironLike, @Nullable Supplier<@NotNull Item> droppedItem) {
		super(block, ironLike ? Materials.METAL : Materials.IRON,isTop,true,droppedItem);
		IBlockLogicFrame.super.init(block);
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		return IBlockLogicFrame.super.onInteracted(world,tilePos,player,side,xHit,yHit) || super.onInteracted(world,tilePos,player,side,xHit,yHit);
	}
}
