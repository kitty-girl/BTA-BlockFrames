package ca.niseda.blockframes;

import ca.niseda.blockframes.registry.BFModels;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

public class BlockFramesClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(BlockFrames.MOD_ID+"|client");

	@Override
	public void onInitializeClient() {
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(BlockFrames.MOD_ID), BFModels::initBlockModels);
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(BlockFrames.MOD_ID), BFModels::initItemModels);
	}
}
