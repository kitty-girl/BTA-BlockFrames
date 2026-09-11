package ca.niseda.blockframes.registry;

import ca.niseda.blockframes.BlockFrames;
import ca.niseda.blockframes.item.WrenchItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoor;
import turniplabs.halplibe.helper.ItemBuilder;

public class BFItems {
	public static int itemId = BlockFrames.CFG.getInt("IDs.starting_item_id");

	public static ItemBuilder toolBuilder = new ItemBuilder(BlockFrames.MOD_ID)
		.setCreativeInventoryPlacement(BlockFrames.CREATIVE_PLACEMENT)
		.setStackSize(1);

	public static ItemBuilder doorBuilder = new ItemBuilder(BlockFrames.MOD_ID)
		.setCreativeInventoryPlacement(BlockFrames.CREATIVE_PLACEMENT);


	public static Item WRENCH; // changes texture used by the block
	public static Item HAMMER; // takes blocks off of frames

	public static ItemDoor FRAME_DOOR_WOOD;
	public static ItemDoor FRAME_DOOR_IRON;

	public static void registerItems() {
		WRENCH = toolBuilder.build(new WrenchItem("wrench", BlockFrames.MOD_ID + ":item/wrench", itemId++));
		HAMMER = toolBuilder.build(new Item("hammer", BlockFrames.MOD_ID + ":item/hammer", itemId++));

		FRAME_DOOR_WOOD = doorBuilder.build(new ItemDoor("frame_door_wood", BlockFrames.MOD_ID + ":item/frame_door_wood", itemId++, BFBlocks.FRAME_DOOR_WOOD_BOTTOM, BFBlocks.FRAME_DOOR_WOOD_TOP));
		FRAME_DOOR_IRON = doorBuilder.build(new ItemDoor("frame_door_iron", BlockFrames.MOD_ID + ":item/frame_door_iron", itemId++, BFBlocks.FRAME_DOOR_IRON_BOTTOM, BFBlocks.FRAME_DOOR_IRON_TOP));
	}
}
