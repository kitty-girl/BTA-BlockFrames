package ca.niseda.blockframes;

import ca.niseda.blockframes.registry.BFBlocks;
import ca.niseda.blockframes.registry.BFItems;
import ca.niseda.blockframes.registry.BFRecipes;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.dependency.Key;
import turniplabs.halplibe.util.toml.Toml;

public class BlockFrames implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("blockframes", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static TomlConfigHandler CFG;
	private static final Toml TOML = new Toml();
	public static final CreativeInventoryPlacement.Category CREATIVE_PLACEMENT = new CreativeInventoryPlacement.Category(CreativeInventoryCategory.PLACEABLES);

	@Override
	public void onInitialize() {
		CommonEvents.AFTER_BLOCK_INIT.listen(Key.of(MOD_ID), BFBlocks::registerBlocks);
		CommonEvents.AFTER_ITEM_INIT.listen(Key.of(MOD_ID), BFItems::registerItems);

		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID), BFRecipes::initRecipes);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID), BFRecipes::initNamespaces);

		TOML.addCategory("IDs")
			.addEntry("starting_block_id", 5100)
			.addEntry("starting_item_id", 30100);

		CFG = new TomlConfigHandler(MOD_ID, TOML);
	}
}
