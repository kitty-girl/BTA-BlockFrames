package ca.niseda.blockframes.registry;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;

public class BFRecipes {
	public static RecipeNamespace BLOCKFRAMES = new RecipeNamespace();
	public static RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH;

	public static void initNamespaces() {
		WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Blocks.WORKBENCH)));
		BLOCKFRAMES.register("workbench", WORKBENCH);
		Registries.RECIPES.unregister("blockframes");
		Registries.RECIPES.register("blockframes", BLOCKFRAMES);
	}

	public static void initRecipes() {
		RecipeBuilder.Shaped("blockframes")
			.setShape(
				"f f",
				" i ",
				" i ")
			.addInput('i', Items.INGOT_IRON)
			.addInput('f', BFBlocks.FRAME)
			.create("Frame Wrench", new ItemStack(BFItems.WRENCH, 1));

		RecipeBuilder.Shaped("blockframes")
			.setShape(
				"fff",
				"fi ",
				" i ")
			.addInput('i', Items.INGOT_IRON)
			.addInput('f', BFBlocks.FRAME)
			.create("Frame Hammer", new ItemStack(BFItems.HAMMER, 1));

		RecipeBuilder.Shaped("blockframes")
			.setShape(
				" i ",
				"i i",
				" i ")
			.addInput('i', Items.INGOT_IRON)
			.create("Frame Block", new ItemStack(BFBlocks.FRAME, 16));

		RecipeBuilder.Shaped("blockframes")
			.setShape(
				"i  ",
				"ii ",
				"iii")
			.addInput('i', BFBlocks.FRAME)
			.create("Frame Stairs", new ItemStack(BFBlocks.FRAME_STAIRS, 4));

		RecipeBuilder.Shaped("blockframes")
			.setShape("iii")
			.addInput('i', BFBlocks.FRAME)
			.create("Frame Slab", new ItemStack(BFBlocks.FRAME_SLAB, 6));

		RecipeBuilder.Shaped("blockframes")
			.setShape("i")
			.addInput('i', BFBlocks.FRAME)
			.create("Frame Layer", new ItemStack(BFBlocks.FRAME_LAYER, 8));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput("minecraft:fences_planks")
			.create("Frame Fence", new ItemStack(BFBlocks.FRAME_FENCE, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.FENCE_PAPER_WALL)
			.create("Frame Fence Thin", new ItemStack(BFBlocks.FRAME_FENCE_THIN, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.FENCE_CHAINLINK)
			.create("Frame Fence Thin2", new ItemStack(BFBlocks.FRAME_FENCE_THIN, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.FENCE_STEEL)
			.create("Frame Fence Thin3", new ItemStack(BFBlocks.FRAME_FENCE_THIN, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput("minecraft:fence_gates_planks")
			.create("Frame Fence Gate", new ItemStack(BFBlocks.FRAME_FENCE_GATE, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput("minecraft:trapdoor_planks")
			.create("Frame Trapdoor Wood", new ItemStack(BFBlocks.FRAME_TRAPDOOR_WOOD, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.TRAPDOOR_GLASS)
			.create("Frame Trapdoor Wood2", new ItemStack(BFBlocks.FRAME_TRAPDOOR_WOOD, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.TRAPDOOR_IRON)
			.create("Frame Trapdoor Iron", new ItemStack(BFBlocks.FRAME_TRAPDOOR_IRON, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.TRAPDOOR_STEEL)
			.create("Frame Trapdoor Iron2", new ItemStack(BFBlocks.FRAME_TRAPDOOR_IRON, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.BUTTON_PLANKS_OAK)
			.create("Frame Button Wood", new ItemStack(BFBlocks.FRAME_BUTTON_WOOD, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.BUTTON_STONE)
			.create("Frame Button Stone", new ItemStack(BFBlocks.FRAME_BUTTON_STONE, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.PRESSURE_PLATE_PLANKS_OAK)
			.create("Frame Pressure Plate Entity", new ItemStack(BFBlocks.FRAME_PRESSURE_PLATE_ENTITY, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.PRESSURE_PLATE_STONE)
			.create("Frame Pressure Plate Mob", new ItemStack(BFBlocks.FRAME_PRESSURE_PLATE_MOB, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.PRESSURE_PLATE_COBBLE_STONE)
			.create("Frame Pressure Plate Player", new ItemStack(BFBlocks.FRAME_PRESSURE_PLATE_PLAYER, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Blocks.LEVER_COBBLE_STONE)
			.create("Frame Lever", new ItemStack(BFBlocks.FRAME_LEVER, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Items.CHAINLINK)
			.create("Frame Ghost", new ItemStack(BFBlocks.FRAME_GHOST, 1));

		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Items.DOOR_OAK)
			.create("Frame Door Wood", new ItemStack(BFItems.FRAME_DOOR_WOOD, 1));
		RecipeBuilder.Shapeless("blockframes")
			.addInput(BFBlocks.FRAME)
			.addInput(Items.DOOR_IRON)
			.create("Frame Door Iron", new ItemStack(BFItems.FRAME_DOOR_IRON, 1));

		RecipeBuilder.Shaped("blockframes")
			.setShape(
				"i",
				"i",
				"i")
			.addInput('i', BFBlocks.FRAME)
			.create("Frame Vertical Slabs", new ItemStack(BFBlocks.FRAME_SLAB_VERTICAL, 6));
	}
}
