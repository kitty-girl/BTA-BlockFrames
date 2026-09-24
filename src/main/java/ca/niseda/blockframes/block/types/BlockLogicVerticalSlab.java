package ca.niseda.blockframes.block.types;

import ca.niseda.blockframes.item.ItemBlockVerticalSlab;
import net.minecraft.core.block.*;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

import java.util.Random;

public class BlockLogicVerticalSlab extends BlockLogicRotatable {
	public @NotNull Block<?> modelBlock;
	public int modelBlockMetadata;

	public BlockLogicVerticalSlab(@NotNull Block<?> block, @NotNull Block<?> modelBlock) {
		this(block, modelBlock, 0);
		block.setBlockItem(() -> new ItemBlockVerticalSlab<>(block));
	}

	public BlockLogicVerticalSlab(@NotNull Block<?> block, @NotNull Block<?> modelBlock, int modelBlockMetadata) {
		super(block, modelBlock.getMaterial());
		this.modelBlock = modelBlock;
		this.modelBlockMetadata = modelBlockMetadata;
		block.withLightBlock(1);
	}

	public void initializeBlock() {
		this.block.withHardness(this.modelBlock.blockHardness);
		this.block.withBlastResistance(this.modelBlock.blastResistance / 3.0F);
		this.block.withLightEmission(this.modelBlock.emission);
	}
	public @NotNull Material getMaterial() {
		return this.modelBlock.getMaterial();
	}

	public @NotNull AABBdc getBoundsFromState(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		AABBd var10000;
		int blockData = source.getBlockData(tilePos);
		if ((blockData & 0b1000) == 0b1000) {
			return new AABBd(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		switch (getDirectionFromMeta(blockData)) {
			case SOUTH -> var10000 = new AABBd(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			case WEST  -> var10000 = new AABBd(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			case EAST  -> var10000 = new AABBd(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			default    -> var10000 = new AABBd(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
		}

		return var10000;
	}
	public boolean isSolidRender() {
		return false;
	}

	public boolean renderAsNormalBlockOnCondition(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		int meta = source.getBlockData(tilePos);
		return (meta & 8) == 8;
	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		ItemStack[] result = dropCause != EnumDropCause.IMPROPER_TOOL ? new ItemStack[]{new ItemStack(this.block)} : null;
		if (result != null) {
			for(ItemStack stack : result) {
				stack.setMetadata(data & 240);
				stack.itemID = this.id();
				if ((data & 0b1000) == 0b1000 && dropCause != EnumDropCause.PICK_BLOCK) {
					stack.stackSize = 2;
				} else {
					stack.stackSize = 1;
				}
			}
		}

		return result;
	}

	public void onEntityInside(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Entity entity, @NotNull Vector3d velocityDirection) {
		this.modelBlock.onEntityInside(world, tilePos, entity, velocityDirection);
	}

	public boolean isCollidable() {
		return this.modelBlock.isCollidable();
	}

	public boolean canCollideCheck(int data, boolean shouldCollideWithFluids) {
		return this.modelBlock.canCollideCheck(data, shouldCollideWithFluids);
	}

	public boolean canPlaceAt(@NotNull World world, @NotNull TilePosc tilePos) {
		TilePos queryPos = new TilePos();
		return world.getBlockType(tilePos.down(queryPos)) == this.block || world.getBlockType(tilePos.up(queryPos)) == this.block || super.canPlaceAt(world, tilePos);
	}

	public void onEntityWalkedOn(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Entity walker) {
		this.modelBlock.onEntityWalkedOn(world, tilePos, walker);
	}

	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		this.modelBlock.updateTick(world, tilePos, rand, false);
	}

	public void onDestroyedByExplosion(@NotNull World world, @NotNull TilePosc tilePos) {
		this.modelBlock.onDestroyedByExplosion(world, tilePos);
	}

	public void onPlacedByWorld(@NotNull World world, @NotNull TilePosc tilePos) {
		this.onNeighborChanged(world, tilePos, Blocks.AIR);
		this.modelBlock.onPlacedByWorld(world, tilePos);
	}

	public float getBlastResistance(@Nullable Entity entity) {
		return this.modelBlock.getBlastResistance(entity);
	}

	public float getBrightness(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		return this.modelBlock.getBrightness(source, tilePos);
	}

	public void onAttacked(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @NotNull Side side, double xHit, double yHit) {
		this.modelBlock.onAttacked(world, tilePos, player, side, xHit, yHit);
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		return this.modelBlock.onInteracted(world, tilePos, player, side, xHit, yHit);
	}

	public void animationTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand) {
		this.modelBlock.animationTick(world, tilePos, rand);
	}

	public @NotNull MaterialColor getMaterialColor() {
		return this.modelBlock.getMaterialColor();
	}
}
