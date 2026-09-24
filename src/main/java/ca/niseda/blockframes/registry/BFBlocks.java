package ca.niseda.blockframes.registry;

import ca.niseda.blockframes.BlockFrames;
import ca.niseda.blockframes.block.variants.*;
import ca.niseda.blockframes.block.TileEntityFrame;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;

import java.util.ArrayList;
import java.util.List;

public class BFBlocks {
	public static int blockId = BlockFrames.CFG.getInt("IDs.starting_block_id");

	public static final Tag<Block<?>> FRAME_BLOCK_TAG = Tag.of("frame_block");

	public static List<Block<?>> FRAME_BLOCKS = new ArrayList<>();

	public static BlockBuilder blockFrameBuilder = new BlockBuilder(BlockFrames.MOD_ID)
		.addTags(BlockTags.MINEABLE_BY_PICKAXE)
		.addTags(FRAME_BLOCK_TAG)
		.setHardness(2)
		.setBlockSound(BlockSounds.METAL)
		.setCreativeInventoryPlacement(BlockFrames.CREATIVE_PLACEMENT);

	public static BlockBuilder doorBuilder = new BlockBuilder(BlockFrames.MOD_ID)
		.addTags(BlockTags.MINEABLE_BY_PICKAXE)
		.addTags(FRAME_BLOCK_TAG)
		.setHardness(2)
		.setBlockSound(BlockSounds.METAL);

	public static Block<BlockLogicFrameStandard> FRAME;
	public static Block<BlockLogicFrameSlab> FRAME_SLAB;
	public static Block<BlockLogicFrameStairs> FRAME_STAIRS;
	public static Block<BlockLogicFrameLayer> FRAME_LAYER;
	public static Block<BlockLogicFrameFence> FRAME_FENCE;
	public static Block<BlockLogicFrameFenceThin> FRAME_FENCE_THIN;
	public static Block<BlockLogicFrameFenceGate> FRAME_FENCE_GATE;
	public static Block<BlockLogicFrameDoor> FRAME_DOOR_WOOD_TOP;
	public static Block<BlockLogicFrameDoor> FRAME_DOOR_WOOD_BOTTOM;
	public static Block<BlockLogicFrameDoor> FRAME_DOOR_IRON_TOP;
	public static Block<BlockLogicFrameDoor> FRAME_DOOR_IRON_BOTTOM;
	public static Block<BlockLogicFrameTrapDoor> FRAME_TRAPDOOR_WOOD;
	public static Block<BlockLogicFrameTrapDoor> FRAME_TRAPDOOR_IRON;
	public static Block<BlockLogicFrameButtonWood> FRAME_BUTTON_WOOD;
	public static Block<BlockLogicFrameButtonStone> FRAME_BUTTON_STONE;
	public static Block<BlockLogicFramePressurePlate<Entity>> FRAME_PRESSURE_PLATE_ENTITY;
	public static Block<BlockLogicFramePressurePlate<Mob>> FRAME_PRESSURE_PLATE_MOB;
	public static Block<BlockLogicFramePressurePlate<Player>> FRAME_PRESSURE_PLATE_PLAYER;
	public static Block<BlockLogicFrameLever> FRAME_LEVER;
	public static Block<BlockLogicFrameStandardGhost> FRAME_GHOST;
	public static Block<BlockLogicFrameVerticalSlab> FRAME_SLAB_VERTICAL;

	public static void registerBlocks() {
		FRAME = blockFrameBuilder.build("frame", blockId++, BlockLogicFrameStandard::new).withLitInteriorSurface(true);
		FRAME_SLAB = blockFrameBuilder.build("frame_slab", blockId++, BlockLogicFrameSlab::new);
		FRAME_STAIRS = blockFrameBuilder.build("frame_stairs", blockId++, BlockLogicFrameStairs::new);
		FRAME_LAYER = blockFrameBuilder.build("frame_layer", blockId++, BlockLogicFrameLayer::new);
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_slab"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_stairs"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_layer"));
		FRAME_BLOCKS.add(FRAME);
		FRAME_BLOCKS.add(FRAME_SLAB);
		FRAME_BLOCKS.add(FRAME_STAIRS);
		FRAME_BLOCKS.add(FRAME_LAYER);

		FRAME_FENCE = blockFrameBuilder.build("frame_fence", blockId++, BlockLogicFrameFence::new).withTags(BlockTags.FENCES_CONNECT);
		FRAME_FENCE_THIN = blockFrameBuilder.build("frame_fence_thin", blockId++, BlockLogicFrameFenceThin::new).withTags(BlockTags.CHAINLINK_FENCES_CONNECT);
		FRAME_FENCE_GATE = blockFrameBuilder.build("frame_fence_gate", blockId++, BlockLogicFrameFenceGate::new).withTags(BlockTags.FENCES_CONNECT);
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_fence"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_fence_thin"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_fence_gate"));
		FRAME_BLOCKS.add(FRAME_FENCE);
		FRAME_BLOCKS.add(FRAME_FENCE_THIN);
		FRAME_BLOCKS.add(FRAME_FENCE_GATE);

		FRAME_DOOR_WOOD_TOP = doorBuilder.build("frame_door_wood_top", blockId++, (block) -> new BlockLogicFrameDoor(block,true,false,() -> BFItems.FRAME_DOOR_WOOD));
		FRAME_DOOR_WOOD_BOTTOM = doorBuilder.build("frame_door_wood_bottom", blockId++, (block) -> new BlockLogicFrameDoor(block,false,false,() -> BFItems.FRAME_DOOR_WOOD));
		FRAME_DOOR_IRON_TOP = doorBuilder.build("frame_door_iron_top", blockId++, (block) -> new BlockLogicFrameDoor(block,true,true,() -> BFItems.FRAME_DOOR_IRON));
		FRAME_DOOR_IRON_BOTTOM = doorBuilder.build("frame_door_iron_bottom", blockId++, (block) -> new BlockLogicFrameDoor(block,false,true,() -> BFItems.FRAME_DOOR_IRON));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_door_wood_top"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_door_wood_bottom"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_door_iron_top"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_door_iron_bottom"));
		FRAME_BLOCKS.add(FRAME_DOOR_WOOD_TOP);
		FRAME_BLOCKS.add(FRAME_DOOR_WOOD_BOTTOM);
		FRAME_BLOCKS.add(FRAME_DOOR_IRON_TOP);
		FRAME_BLOCKS.add(FRAME_DOOR_IRON_BOTTOM);

		FRAME_TRAPDOOR_WOOD = blockFrameBuilder.build("frame_trapdoor_wood", blockId++, (block) -> new BlockLogicFrameTrapDoor(block, false));
		FRAME_TRAPDOOR_IRON = blockFrameBuilder.build("frame_trapdoor_iron", blockId++, (block) -> new BlockLogicFrameTrapDoor(block, true));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_trapdoor_wood"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_trapdoor_iron"));
		FRAME_BLOCKS.add(FRAME_TRAPDOOR_WOOD);
		FRAME_BLOCKS.add(FRAME_TRAPDOOR_IRON);

		FRAME_BUTTON_WOOD = blockFrameBuilder.build("frame_button_wood", blockId++, BlockLogicFrameButtonWood::new);
		FRAME_BUTTON_STONE = blockFrameBuilder.build("frame_button_stone", blockId++, BlockLogicFrameButtonStone::new);
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_button_wood"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_button_stone"));
		FRAME_BLOCKS.add(FRAME_BUTTON_WOOD);
		FRAME_BLOCKS.add(FRAME_BUTTON_STONE);

		FRAME_PRESSURE_PLATE_ENTITY = blockFrameBuilder.build("frame_pressure_plate_entity", blockId++, (block) -> new BlockLogicFramePressurePlate<>(block, Entity.class));
		FRAME_PRESSURE_PLATE_MOB = blockFrameBuilder.build("frame_pressure_plate_mob", blockId++, (block) -> new BlockLogicFramePressurePlate<>(block, Mob.class));
		FRAME_PRESSURE_PLATE_PLAYER = blockFrameBuilder.build("frame_pressure_plate_player", blockId++, (block) -> new BlockLogicFramePressurePlate<>(block, Player.class));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_pressure_plate_entity"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_pressure_plate_mob"));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_pressure_plate_player"));
		FRAME_BLOCKS.add(FRAME_PRESSURE_PLATE_ENTITY);
		FRAME_BLOCKS.add(FRAME_PRESSURE_PLATE_MOB);
		FRAME_BLOCKS.add(FRAME_PRESSURE_PLATE_PLAYER);

		FRAME_LEVER = blockFrameBuilder.build("frame_lever", blockId++, (block) -> new BlockLogicFrameLever(FRAME_LEVER));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_lever"));
		FRAME_BLOCKS.add(FRAME_LEVER);

		FRAME_GHOST = blockFrameBuilder.build("frame_ghost", blockId++, (block) -> new BlockLogicFrameStandardGhost(FRAME_GHOST));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_ghost"));
		FRAME_BLOCKS.add(FRAME_GHOST);

		FRAME_SLAB_VERTICAL = blockFrameBuilder.build("frame_vertical_slab", blockId++, (block) -> new BlockLogicFrameVerticalSlab(FRAME_SLAB_VERTICAL));
		EntityHelper.addMapping(TileEntityFrame.class, new NamespaceID(BlockFrames.MOD_ID, "frame_vertical_slab"));
		FRAME_BLOCKS.add(FRAME_SLAB_VERTICAL);

	}
}
