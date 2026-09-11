package ca.niseda.blockframes.block.variants;

import ca.niseda.blockframes.block.IBlockLogicFrame;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFenceThin;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicFrameFenceThin extends BlockLogicFenceThin implements IBlockLogicFrame {
	public BlockLogicFrameFenceThin(@NotNull Block<BlockLogicFrameFenceThin> block) {
		super(block, Materials.IRON);
		IBlockLogicFrame.super.init(block);
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		return IBlockLogicFrame.super.onInteracted(world,tilePos,player,side,xHit,yHit) || super.onInteracted(world,tilePos,player,side,xHit,yHit);
	}

	@Override
	public boolean canConnectTo(@NotNull WorldSource worldSource, @NotNull TilePosc tilePosc, @NotNull Side side) {
		TilePos queryPos = new TilePos();
		Block<?> b = worldSource.getBlockType(tilePosc.add(side.direction(), queryPos));
		return Blocks.hasTag(b, BlockTags.CHAINLINK_FENCES_CONNECT) || b.getAttachedSide(worldSource, tilePosc.add(side.direction(), queryPos)) == side.opposite();
	}
}
