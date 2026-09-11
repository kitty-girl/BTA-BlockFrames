package ca.niseda.blockframes.block.variants;

import ca.niseda.blockframes.block.IBlockLogicFrame;
import ca.niseda.blockframes.registry.BFBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLayerBase;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicFrameLayer extends BlockLogicLayerBase implements IBlockLogicFrame {
	public BlockLogicFrameLayer(@NotNull Block<BlockLogicFrameLayer> block) {
		super(block, BFBlocks.FRAME, Materials.IRON);
		IBlockLogicFrame.super.init(block);
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		return IBlockLogicFrame.super.onInteracted(world,tilePos,player,side,xHit,yHit) || super.onInteracted(world,tilePos,player,side,xHit,yHit);
	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {

		return switch (dropCause) {
			case PICK_BLOCK -> new ItemStack[]{new ItemStack(this)};
			case SILK_TOUCH, EXPLOSION, PROPER_TOOL -> new ItemStack[]{new ItemStack(this, data + 1)};
			default -> null;
		};
	}
}
