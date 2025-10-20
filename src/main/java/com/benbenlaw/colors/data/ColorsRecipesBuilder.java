package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorsTags;
import com.benbenlaw.core.item.colored.ColoredItem;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ColorsRecipesBuilder extends RecipeProvider {

    public ColorsRecipesBuilder(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        for (String color : ColorList.COLORS) {

            //Stone
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                //Vanilla to Colored
                if (type.equals("stone_bricks")) {
                    create2x2Recipe(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_stone"), ColorsBlocks.STONE_BLOCKS.get(color + "_stone_bricks"));
                }
                if (type.equals("asteroid")) {
                    create2x2Recipe(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_asteroid"), ColorsBlocks.STONE_BLOCKS.get(color + "_asteroid_bricks"));
                }
                if (type.equals("marble")) {
                    create2x2Recipe(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_marble"), ColorsBlocks.STONE_BLOCKS.get(color + "_marble_bricks"));
                }
                if (type.equals("cobblestone")) {
                    create2x2Recipe(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_cobblestone"), ColorsBlocks.STONE_BLOCKS.get(color + "_cobblestone_bricks"));
                }


                switch (type) {
                    case "prismarine" ->
                            stonecutterResultFromBase(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_prismarine"), Blocks.PRISMARINE, 1);
                    case "prismarine_bricks" ->
                            stonecutterResultFromBase(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_prismarine_bricks"), Blocks.PRISMARINE_BRICKS, 1);
                    case "dark_prismarine" ->
                            stonecutterResultFromBase(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_dark_prismarine"), Blocks.DARK_PRISMARINE, 1);
                    default ->
                            stonecutterResultFromBase(consumer, ColorsBlocks.STONE_BLOCKS.get(color + "_" + type), Blocks.STONE, 1);
                }

                //Colored to Recipes
                ItemLike stone = ColorsBlocks.STONE_BLOCKS.get(color + "_" + type);
                ItemLike stairs = ColorsBlocks.STONE_BLOCKS.get(keyPrefix + "_stairs");
                ItemLike slab = ColorsBlocks.STONE_BLOCKS.get(keyPrefix + "_slab");
                ItemLike wall = ColorsBlocks.STONE_BLOCKS.get(keyPrefix + "_wall");
                ItemLike pressure_plate = ColorsBlocks.STONE_BLOCKS.get(keyPrefix + "_pressure_plate");
                ItemLike button = ColorsBlocks.STONE_BLOCKS.get(keyPrefix + "_button");
                createStoneLikeCraftingRecipes(consumer, stone, stairs, slab, wall, pressure_plate, button);
            }

            //Planks
            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                //Vanilla to Colored
                if (type.equals("bamboo_planks")) {
                    stonecutterResultFromBase(consumer, ColorsBlocks.PLANKS.get(color + "_" + type), Blocks.BAMBOO_PLANKS, 1);
                } else if (type.equals("bamboo_mosaic")) {
                    stonecutterResultFromBase(consumer, ColorsBlocks.PLANKS.get(color + "_" + type), Blocks.BAMBOO_MOSAIC, 1);
                } else {
                    stonecutterResultFromBase(consumer, ColorsBlocks.PLANKS.get(color + "_" + type), Blocks.OAK_PLANKS, 1);
                }

                //Colored to Recipes
                ItemLike plank = ColorsBlocks.PLANKS.get(color + "_" + type);
                ItemLike stairs = ColorsBlocks.PLANKS.get(keyPrefix + "_stairs");
                ItemLike slab = ColorsBlocks.PLANKS.get(keyPrefix + "_slab");
                ItemLike fence = ColorsBlocks.PLANKS.get(keyPrefix + "_fence");
                ItemLike fence_gate = ColorsBlocks.PLANKS.get(keyPrefix + "_fence_gate");
                ItemLike pressure_plate = ColorsBlocks.PLANKS.get(keyPrefix + "_pressure_plate");
                ItemLike button = ColorsBlocks.PLANKS.get(keyPrefix + "_button");
                ItemLike trapdoor = ColorsBlocks.PLANKS.get(keyPrefix + "_trapdoor");
                ItemLike door = ColorsBlocks.PLANKS.get(keyPrefix + "_door");
                ItemLike sign = ColorsItems.PLANKS.get(keyPrefix + "_sign");
                ItemLike hangingSign = ColorsItems.PLANKS.get(keyPrefix + "_hanging_sign");
                createPlankLikeCraftingRecipes(consumer, plank, stairs, slab, fence, fence_gate, pressure_plate, button, trapdoor, door, sign, hangingSign);
            }

            //Sapling
            stonecutterResultFromBase(consumer, ColorsBlocks.SAPLINGS.get(color + "_sapling"), Items.OAK_SAPLING, 1);

            //Grass
            stonecutterResultFromBase(consumer, ColorsBlocks.GRASS_BLOCK.get(color + "_grass_block"), Blocks.DIRT, 1);
            stonecutterResultFromBase(consumer, ColorsBlocks.GRASS_BLOCK.get(color + "_grass_block"), Blocks.GRASS_BLOCK, 1);

            //Dirt
            stonecutterResultFromBase(consumer, ColorsBlocks.DIRT.get(color + "_dirt"), Blocks.DIRT, 1);

            //Spray Cans
            ItemLike sprayCan = ColorsItems.SPRAY_CANS.get(color + "_spray_can");
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, sprayCan, 1)
                    .pattern(" I ")
                    .pattern("IDI")
                    .pattern("IDI")
                    .define('I', Tags.Items.INGOTS_IRON)
                    .define('D', TagKey.create(Registries.ITEM, ResourceLocation.parse("c:dyes/" + color)))
                    .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_spray_can"));

            //Crafting Table
            ItemLike craftingTable = ColorsBlocks.CRAFTING_TABLE.get(color + "_crafting_table");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, craftingTable, 1)
                    .pattern("SS")
                    .pattern("SS")
                    .define('S', ColorsBlocks.PLANKS.get(color + "_planks"))
                    .unlockedBy("has_item", has(ColorsBlocks.PLANKS.get(color + "_planks")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_crafting_table"));

            //Planks from Logs
            ItemLike planks = ColorsBlocks.PLANKS.get(color + "_planks");
            TagKey<Item> logTag = ColorsTags.Items.LOG_TAGS.get(color);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                    .requires(logTag)
                    .unlockedBy("has_item", has(logTag))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_planks_from_logs"));

            //Logs to Wood
            ItemLike wood = ColorsBlocks.WOOD.get(color + "_wood");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wood, 3)
                    .pattern("SS")
                    .pattern("SS")
                    .define('S', ColorsBlocks.LOGS.get(color + "_log"))
                    .unlockedBy("has_item", has(ColorsBlocks.LOGS.get(color + "_log")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_wood"));

            //Stripped Logs to Stripped Wood
            ItemLike strippedWood = ColorsBlocks.WOOD.get(color + "_stripped_wood");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, strippedWood, 3)
                    .pattern("SS")
                    .pattern("SS")
                    .define('S', ColorsBlocks.LOGS.get(color + "_stripped_log"))
                    .unlockedBy("has_item", has(ColorsBlocks.LOGS.get(color + "_stripped_log")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_stripped_wood"));

            //Bamboo Planks from Bamboo
            ItemLike bambooPlanks = ColorsBlocks.PLANKS.get(color + "_bamboo_planks");
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, bambooPlanks, 2)
                    .requires(ColorsBlocks.BAMBOO.get(color + "_bamboo"))
                    .unlockedBy("has_item", has(ColorsBlocks.BAMBOO.get(color + "_bamboo")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_bamboo_planks_from_bamboo"));

            //Flower to Dye
            ItemLike dye = BuiltInRegistries.ITEM.get(ResourceLocation.parse("minecraft:" + color + "_dye"));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, dye, 1)
                    .requires(ColorsBlocks.POPPY.get(color + "_poppy"))
                    .unlockedBy("has_item", has(ColorsBlocks.POPPY.get(color + "_poppy")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_dye_from_poppy"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, dye, 1)
                    .requires(ColorsBlocks.DANDELION.get(color + "_dandelion"))
                    .unlockedBy("has_item", has(ColorsBlocks.DANDELION.get(color + "_dandelion")))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + color + "_dye_from_dandelion"));


        }

        //Glowstone Spray Can
        ItemLike glowstoneSprayCan = ColorsItems.GLOWSTONE_SPRAY_CAN;
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, glowstoneSprayCan, 1)
                .pattern(" G ")
                .pattern("GSG")
                .pattern("GSG")
                .define('G', Tags.Items.DUSTS_GLOWSTONE)
                .define('S', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_item", has(Tags.Items.DUSTS_GLOWSTONE))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/glowstone_spray_can"));


    }

    public void createPlankLikeCraftingRecipes(RecipeOutput consumer, ItemLike plank, ItemLike stairs, ItemLike slab, ItemLike fence, ItemLike fence_gate, ItemLike pressure_plate, ItemLike button, ItemLike trapdoor, ItemLike door, ItemLike sign, ItemLike hangingSign) {
        createStairsRecipe(consumer, plank, stairs);
        createSlabRecipe(consumer, plank, slab);
        createFenceRecipe(consumer, plank, fence);
        createFenceGateRecipe(consumer, plank, fence_gate);
        createPressurePlateRecipe(consumer, plank, pressure_plate);
        createButtonRecipe(consumer, plank, button);
        createTrapdoorRecipe(consumer, plank, trapdoor);
        createDoorRecipe(consumer, plank, door);
        createSignRecipe(consumer, plank, sign);
        createHangingSignRecipe(consumer, plank, hangingSign);
        
    }

    public void createStoneLikeCraftingRecipes(RecipeOutput consumer, ItemLike stone, ItemLike stairs, ItemLike slab, ItemLike wall, ItemLike pressure_plate, ItemLike button) {
        createStairsRecipe(consumer, stone, stairs);
        createSlabRecipe(consumer, stone, slab);
        createWallColoringRecipe(consumer, stone, wall);
        createPressurePlateRecipe(consumer, stone, pressure_plate);
        createButtonRecipe(consumer, stone, button);
        createStonecutterRecipes(consumer, stone, stairs, slab, wall, pressure_plate, button);
    }

    public void createHangingSignRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 3)
                .pattern("I I")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', input)
                .define('I', Items.CHAIN)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createSignRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 3)
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" I ")
                .define('S', input)
                .define('I', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createFenceRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 3)
                .pattern("STS")
                .pattern("STS")
                .define('S', input)
                .define('T', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createFenceGateRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .pattern("WSW")
                .pattern("WSW")
                .define('S', input)
                .define('W', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createTrapdoorRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 2)
                .pattern("SSS")
                .pattern("SSS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createDoorRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 3)
                .pattern("SS")
                .pattern("SS")
                .pattern("SS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createStonecutterRecipes(RecipeOutput consumer, ItemLike stone, ItemLike stairs, ItemLike slab, ItemLike wall, ItemLike pressure_plate, ItemLike button) {
        stonecutterResultFromBase(consumer, stairs, stone, 1);
        stonecutterResultFromBase(consumer, slab, stone, 2);
        stonecutterResultFromBase(consumer, wall, stone, 1);
        stonecutterResultFromBase(consumer, pressure_plate, stone, 1);
        stonecutterResultFromBase(consumer, button, stone, 1);
    }

    protected static void stonecutterResultFromBase(@NotNull RecipeOutput consumer, ItemLike itemLike, ItemLike itemLike1, int i) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(itemLike1), RecipeCategory.BUILDING_BLOCKS, itemLike, i).unlockedBy(getHasName(itemLike1), has(itemLike1)).save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "stonecutting/" + getConversionRecipeName(itemLike, itemLike1)));
    }

    public void createStairsRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createSlabRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .pattern("SSS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }
    public void createPressurePlateRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .pattern("SS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createButtonRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output)
                .requires(input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void createWallColoringRecipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .pattern("SSS")
                .pattern("SSS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }

    public void create2x2Recipe(RecipeOutput consumer, ItemLike input, ItemLike output) {
        String outputPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', input)
                .unlockedBy("has_item", has(input))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "crafting/" + outputPath));
    }




}