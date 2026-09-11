package ca.niseda.blockframes.block.variants;

import ca.niseda.blockframes.block.IBlockLogicFrame;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTrapDoor;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicFrameTrapDoor extends BlockLogicTrapDoor implements IBlockLogicFrame {
	public BlockLogicFrameTrapDoor(@NotNull Block<BlockLogicFrameTrapDoor> block, boolean ironLike) {
		super(block, ironLike ? Materials.METAL : Materials.IRON);
		IBlockLogicFrame.super.init(block);
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		return IBlockLogicFrame.super.onInteracted(world,tilePos,player,side,xHit,yHit) || super.onInteracted(world,tilePos,player,side,xHit,yHit);
	}
}
