package ca.niseda.blockframes.registry;

import ca.niseda.blockframes.client.blockmodels.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;

@Environment(EnvType.CLIENT)
public class BFModels {
	 public static void initBlockModels(BlockModelDispatcher dispatcher) {
		 dispatcher.addDispatch(BFBlocks.FRAME, new BlockModelFrameStandard<>(BFBlocks.FRAME));
		 dispatcher.addDispatch(BFBlocks.FRAME_SLAB, new BlockModelFrameSlab<>(BFBlocks.FRAME_SLAB));
		 dispatcher.addDispatch(BFBlocks.FRAME_STAIRS, new BlockModelFrameStairs<>(BFBlocks.FRAME_STAIRS));
		 dispatcher.addDispatch(BFBlocks.FRAME_LAYER, new BlockModelFrameLayer<>(BFBlocks.FRAME_LAYER));

		 dispatcher.addDispatch(BFBlocks.FRAME_DOOR_WOOD_TOP, new BlockModelFrameDoor<>(BFBlocks.FRAME_DOOR_WOOD_TOP, "blockframes:block/door/frame", false));
		 dispatcher.addDispatch(BFBlocks.FRAME_DOOR_WOOD_BOTTOM, new BlockModelFrameDoor<>(BFBlocks.FRAME_DOOR_WOOD_BOTTOM, "blockframes:block/door/frame", true));
		 dispatcher.addDispatch(BFBlocks.FRAME_DOOR_IRON_TOP, new BlockModelFrameDoor<>(BFBlocks.FRAME_DOOR_IRON_TOP, "blockframes:block/door/frame", false));
		 dispatcher.addDispatch(BFBlocks.FRAME_DOOR_IRON_BOTTOM, new BlockModelFrameDoor<>(BFBlocks.FRAME_DOOR_IRON_BOTTOM, "blockframes:block/door/frame", true));

		 dispatcher.addDispatch(BFBlocks.FRAME_FENCE, new BlockModelFrameFence<>(BFBlocks.FRAME_FENCE));
		 dispatcher.addDispatch(BFBlocks.FRAME_FENCE_THIN, new BlockModelFrameFenceThin<>(BFBlocks.FRAME_FENCE_THIN));
		 dispatcher.addDispatch(BFBlocks.FRAME_FENCE_GATE, new BlockModelFrameFenceGate<>(BFBlocks.FRAME_FENCE_GATE));

		 dispatcher.addDispatch(BFBlocks.FRAME_TRAPDOOR_WOOD, new BlockModelFrameTrapDoor<>(BFBlocks.FRAME_TRAPDOOR_WOOD));
		 dispatcher.addDispatch(BFBlocks.FRAME_TRAPDOOR_IRON, new BlockModelFrameTrapDoor<>(BFBlocks.FRAME_TRAPDOOR_IRON));

		 dispatcher.addDispatch(BFBlocks.FRAME_BUTTON_WOOD, new BlockModelFrameButton<>(BFBlocks.FRAME_BUTTON_WOOD));
		 dispatcher.addDispatch(BFBlocks.FRAME_BUTTON_STONE, new BlockModelFrameButton<>(BFBlocks.FRAME_BUTTON_STONE));

		 dispatcher.addDispatch(BFBlocks.FRAME_PRESSURE_PLATE_ENTITY, new BlockModelFramePressurePlate<>(BFBlocks.FRAME_PRESSURE_PLATE_ENTITY));
		 dispatcher.addDispatch(BFBlocks.FRAME_PRESSURE_PLATE_MOB, new BlockModelFramePressurePlate<>(BFBlocks.FRAME_PRESSURE_PLATE_MOB));
		 dispatcher.addDispatch(BFBlocks.FRAME_PRESSURE_PLATE_PLAYER, new BlockModelFramePressurePlate<>(BFBlocks.FRAME_PRESSURE_PLATE_PLAYER));

		 dispatcher.addDispatch(BFBlocks.FRAME_LEVER, new BlockModelFrameLever<>(BFBlocks.FRAME_LEVER).render3D(false));

		 dispatcher.addDispatch(BFBlocks.FRAME_GHOST, new BlockModelFrameStandard<>(BFBlocks.FRAME_GHOST));

		 dispatcher.addDispatch(BFBlocks.FRAME_SLAB_VERTICAL, new BlockModelFrameVerticalSlab<>(
			 BFBlocks.FRAME_SLAB_VERTICAL,
			 BlockModelDispatcher.loadDataModel("blockframes:block/vertical_slab/frame/single"),
			 BlockModelDispatcher.loadDataModel("blockframes:block/vertical_slab/frame/double")
		 ));
	 }
	public static void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(BFItems.HAMMER, new ItemModelStandard(BFItems.HAMMER)
			.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
			.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
			.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
			.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(BFItems.WRENCH, new ItemModelStandard(BFItems.WRENCH)
			.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
			.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
			.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
			.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND));

		dispatcher.addDispatch(BFItems.FRAME_DOOR_WOOD, new ItemModelStandard(BFItems.FRAME_DOOR_WOOD));
		dispatcher.addDispatch(BFItems.FRAME_DOOR_IRON, new ItemModelStandard(BFItems.FRAME_DOOR_IRON));
	}
}
