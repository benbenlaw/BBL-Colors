package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.core.block.brightable.BrightCraftingTable;
import com.benbenlaw.core.block.brightable.BrightDoublePlantBlock;
import com.benbenlaw.core.block.brightable.BrightTallGrassBlock;
import com.benbenlaw.core.block.colored.*;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Map;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsBlockStatesProvider extends BlockStateProvider {

    public ColorsBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Colors.MOD_ID, existingFileHelper);

    }

    @Override
    protected void registerStatesAndModels() {

        for (String color : ColorList.COLORS) {

            //Sapling
            saplingWithElements((SaplingBlock) SAPLINGS.get(color + "_sapling").get(), "colors:block/sapling");


            //Wood
            logBlockWithElement(LOGS.get(color + "_log").get(), "colors:block/log");
            strippedLogBlockWithElement((RotatedPillarBlock) LOGS.get(color + "_stripped_log").get(), "colors:block/stripped_log");
            woodBlockWithElement((RotatedPillarBlock) WOOD.get(color + "_wood").get(), "colors:block/log");
            strippedWoodBlockWithElement((RotatedPillarBlock) WOOD.get(color + "_stripped_wood").get(), "colors:block/stripped_log");

            //Bamboo
            logBlockWithElement(BAMBOO.get(color + "_bamboo").get(), "colors:block/bamboo_block");
            strippedLogBlockWithElement((RotatedPillarBlock) BAMBOO.get(color + "_stripped_bamboo").get(), "colors:block/stripped_bamboo_block");

            //Leaves
            simpleBlockWithElements(LEAVES.get(color + "_leaves").get(), "colors:block/leaves");

            //Short Grass
            tallGrassWithElements((BrightTallGrassBlock) SHORT_GRASS.get(color + "_short_grass").get(), "colors:block/short_grass");
            //Tall Plant
            doublePlantWithElements((BrightDoublePlantBlock) TALL_GRASS.get(color + "_tall_grass").get(), "colors:block/tall_grass");
            //Poppy
            flowerWithElements((FlowerBlock) POPPY.get(color + "_poppy").get(), "colors:block/poppy");
            simpleBlock(POTTED_POPPY.get(color + "_potted_poppy").get(), models().singleTexture("potted_poppy",
                    ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "tintable_flower_pot_cross"), "plant",
                    ResourceLocation.parse("colors:block/poppy")).renderType("cutout"));
            //Dandelion
            flowerWithElements((FlowerBlock) DANDELION.get(color + "_dandelion").get(), "colors:block/dandelion");
            simpleBlock(POTTED_DANDELION.get(color + "_potted_dandelion").get(), models().singleTexture( "potted_dandelion",
                    ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "tintable_flower_pot_cross"), "plant",
                    ResourceLocation.parse("colors:block/dandelion")).renderType("cutout"));
            //Dirt
            simpleBlockWithElements(DIRT.get(color + "_dirt").get(), "colors:block/dirt");
            //Grass
            grassBlockWithElements((GrassBlock) GRASS_BLOCK.get(color + "_grass_block").get(), "colors:block/dirt", "colors:block/grass_block");
            //Crafting Table
            craftingTableBlock((BrightCraftingTable) CRAFTING_TABLE.get(color + "_crafting_table").get(), "colors:block/planks", "colors:block/crafting_table");


            //Stone Blocks
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                simpleBlockWithElements(STONE_BLOCKS.get(color + "_" + type).get(), "colors:block/" + type);
                slabWithElements((SlabBlock) STONE_BLOCKS.get(keyPrefix + "_slab").get(), "colors:block/" + type);
                stairsWithElements((StairBlock) STONE_BLOCKS.get(keyPrefix + "_stairs").get(), "colors:block/" + type);
                wallWithElements((WallBlock) STONE_BLOCKS.get(keyPrefix + "_wall").get(), "colors:block/" + type);
                pressurePlateWithElements((PressurePlateBlock) STONE_BLOCKS.get(keyPrefix + "_pressure_plate").get(), "colors:block/" + type);
                buttonWithElements((ButtonBlock) STONE_BLOCKS.get(keyPrefix + "_button").get(), "colors:block/" + type);

            }

            //Plank Blocks
            for (String type : PlankLikeBlocksList.PLANKS) {
                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                simpleBlockWithElements(PLANKS.get(color + "_" + type).get(), "colors:block/" + type);
                slabWithElements((SlabBlock) PLANKS.get(keyPrefix + "_slab").get(), "colors:block/" + type);
                stairsWithElements((StairBlock) PLANKS.get(keyPrefix + "_stairs").get(), "colors:block/" + type);
                pressurePlateWithElements((PressurePlateBlock) PLANKS.get(keyPrefix + "_pressure_plate").get(), "colors:block/" + type);
                buttonWithElements((ButtonBlock) PLANKS.get(keyPrefix + "_button").get(), "colors:block/" + type);
                fenceWithElements((FenceBlock) PLANKS.get(keyPrefix + "_fence").get(), "colors:block/" + type);
                fenceGateWithElements((FenceGateBlock) PLANKS.get(keyPrefix + "_fence_gate").get(), "colors:block/" + type);
                doorWithElements((DoorBlock) PLANKS.get(keyPrefix + "_door").get(), "colors:block/" + singularType);
                trapDoorWithElements((TrapDoorBlock) PLANKS.get(keyPrefix + "_trapdoor").get(), "colors:block/" + singularType + "_trapdoor", true);
            }



        }
    }

    private void strippedWoodBlockWithElement(RotatedPillarBlock strippedWoodBlock, String defaultTexture) {

        ResourceLocation woodBlockRegistryName = BuiltInRegistries.BLOCK.getKey(strippedWoodBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture);

        ModelFile log = models().withExistingParent(woodBlockRegistryName.getPath(), "colors:block/tintable_cube_column")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        ModelFile logHorizontal = models().withExistingParent(woodBlockRegistryName.getPath(), "colors:block/tintable_cube_column_horizontal")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        getVariantBuilder(strippedWoodBlock)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(log).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(logHorizontal).rotationX(90).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(logHorizontal).rotationX(90).rotationY(90)
                .addModel();

        simpleBlockItem(strippedWoodBlock, new ModelFile.UncheckedModelFile("colors:block/" + woodBlockRegistryName.getPath()));
    }

    private void woodBlockWithElement(RotatedPillarBlock woodBlock, String defaultTexture) {
        ResourceLocation woodBlockRegistryName = BuiltInRegistries.BLOCK.getKey(woodBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture);

        ModelFile log = models().withExistingParent(woodBlockRegistryName.getPath(), "colors:block/tintable_cube_column")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        ModelFile logHorizontal = models().withExistingParent(woodBlockRegistryName.getPath(), "colors:block/tintable_cube_column_horizontal")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        getVariantBuilder(woodBlock)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(log).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(logHorizontal).rotationX(90).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(logHorizontal).rotationX(90).rotationY(90).addModel();

        simpleBlockItem(woodBlock, new ModelFile.UncheckedModelFile("colors:block/" + woodBlockRegistryName.getPath()));

    }
    private void logBlockWithElement(Block block, String defaultTexture) {
        ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture + "_top");

        ModelFile log = models().withExistingParent(blockRegistryName.getPath(), "colors:block/tintable_cube_column")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        ModelFile logHorizontal = models().withExistingParent(blockRegistryName.getPath(), "colors:block/tintable_cube_column_horizontal")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        getVariantBuilder(block)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(log).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(logHorizontal).rotationX(90).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(logHorizontal).rotationX(90).rotationY(90).addModel();

        simpleBlockItem(block, new ModelFile.UncheckedModelFile("colors:block/" + blockRegistryName.getPath()));

    }

    private void strippedLogBlockWithElement(RotatedPillarBlock strippedLogBlock, String defaultTexture) {
        ResourceLocation strippedLogBlockRegistryName = BuiltInRegistries.BLOCK.getKey(strippedLogBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture + "_top");

        ModelFile log = models().withExistingParent(strippedLogBlockRegistryName.getPath(), "colors:block/tintable_cube_column")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        ModelFile logHorizontal = models().withExistingParent(strippedLogBlockRegistryName.getPath(), "colors:block/tintable_cube_column_horizontal")
                .texture("side", texture).texture("end", textureTop).renderType("cutout");

        getVariantBuilder(strippedLogBlock)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(log).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(logHorizontal).rotationX(90).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(logHorizontal).rotationX(90).rotationY(90).addModel();

        simpleBlockItem(strippedLogBlock, new ModelFile.UncheckedModelFile("colors:block/" + strippedLogBlockRegistryName.getPath()));


    }

    private void tallGrassWithElements(BrightTallGrassBlock flowerBlock, String defaultTexture) {

        ResourceLocation saplingBlockRegistryName = BuiltInRegistries.BLOCK.getKey(flowerBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile sapling = models().withExistingParent(saplingBlockRegistryName.getPath(), "colors:block/tintable_cross")
                .texture("cross", texture).renderType("cutout");

        getVariantBuilder(flowerBlock).forAllStatesExcept(state ->
                ConfiguredModel.builder().modelFile(sapling).build(), ColoredTallGrassBlock.LIT, ColoredTallGrassBlock.COLOR);
    }

    private void doublePlantWithElements(BrightDoublePlantBlock flowerBlock, String defaultTexture) {

        ResourceLocation saplingBlockRegistryName = BuiltInRegistries.BLOCK.getKey(flowerBlock);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture + "_top");
        ResourceLocation textureBottom = ResourceLocation.parse(defaultTexture + "_bottom");

        ModelFile doubleTop = models().withExistingParent(saplingBlockRegistryName.getPath() + "_top", "colors:block/tintable_cross")
                .texture("cross", textureTop).renderType("cutout");

        ModelFile doubleBottom = models().withExistingParent(saplingBlockRegistryName.getPath() + "_bottom", "colors:block/tintable_cross")
                .texture("cross", textureBottom).renderType("cutout");

        getVariantBuilder(flowerBlock).forAllStatesExcept(state -> {

            boolean top = state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER);
            boolean lower = state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.LOWER);
            return ConfiguredModel.builder().modelFile(top ? doubleTop : doubleBottom).build();

        }, ColoredDoublePlantBlock.LIT, ColoredDoublePlantBlock.COLOR);
    }

    private void saplingWithElements(SaplingBlock saplingBlock, String defaultTexture) {

        ResourceLocation saplingBlockRegistryName = BuiltInRegistries.BLOCK.getKey(saplingBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile sapling = models().withExistingParent(saplingBlockRegistryName.getPath(), "colors:block/tintable_cross")
                .texture("cross", texture).renderType("cutout");

        getVariantBuilder(saplingBlock).forAllStatesExcept(state ->
                ConfiguredModel.builder().modelFile(sapling).build(), ColoredSapling.LIT, ColoredSapling.COLOR);
    }

    private void flowerWithElements(FlowerBlock flowerBlock, String defaultTexture) {

        ResourceLocation saplingBlockRegistryName = BuiltInRegistries.BLOCK.getKey(flowerBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile sapling = models().withExistingParent(saplingBlockRegistryName.getPath(), "colors:block/tintable_cross")
                .texture("cross", texture).renderType("cutout");

        getVariantBuilder(flowerBlock).forAllStatesExcept(state ->
                ConfiguredModel.builder().modelFile(sapling).build(), ColoredFlower.LIT, ColoredFlower.COLOR);
    }

    private void craftingTableBlock(BrightCraftingTable craftingTable, String defaultTexture, String craftingTableTexture) {

        ResourceLocation craftingTableRegistryName = BuiltInRegistries.BLOCK.getKey(craftingTable);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureFront = ResourceLocation.parse(craftingTableTexture);
        ResourceLocation textureTop = ResourceLocation.parse(craftingTableTexture + "_top");
        ResourceLocation textureSide = ResourceLocation.parse(craftingTableTexture + "_side");


        ModelFile cubeSides = models().withExistingParent(craftingTableRegistryName.getPath(), "colors:block/tintable_cube")
                .texture("down", texture)
                .texture("up", textureTop)
                .texture("north", textureFront)
                .texture("south", textureSide)
                .texture("west", textureFront)
                .texture("east", textureSide)
                .texture("particle", textureFront)
                .renderType("cutout");

        simpleBlockItem(craftingTable, cubeSides);

        getVariantBuilder(craftingTable).forAllStatesExcept(state ->
                ConfiguredModel.builder().modelFile(cubeSides).build(), ColoredSapling.LIT, ColoredSapling.COLOR);


    }


    private void grassBlockWithElements(GrassBlock coloredGrassBlock, String defaultTexture, String grassBlockTexture) {

        ResourceLocation grassBlockRegistryName = BuiltInRegistries.BLOCK.getKey(coloredGrassBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(grassBlockTexture + "_top");
        ResourceLocation textureSide = ResourceLocation.parse(grassBlockTexture + "_side");
        ResourceLocation textureTopSnow = ResourceLocation.parse(grassBlockTexture + "_top_snow");
        ResourceLocation textureSideSnow = ResourceLocation.parse(grassBlockTexture + "_side_snow");

        ModelFile grass = models().withExistingParent(grassBlockRegistryName.getPath(), "colors:block/tintable_cube_bottom_top")
                .texture("bottom", texture)
                .texture("top", textureTop)
                .texture("side", textureSide)
                .texture("particle", textureSide)
                .renderType("cutout");

        ModelFile grassSnowed = models().withExistingParent(grassBlockRegistryName.getPath() + "_snow", "colors:tintable_cube_bottom_top")
                .texture("bottom", texture)
                .texture("top", textureTopSnow)
                .texture("side", textureSideSnow)
                .texture("particle", textureSideSnow)
                .renderType("cutout");

        simpleBlockItem(coloredGrassBlock, grass);

        getVariantBuilder(coloredGrassBlock).forAllStatesExcept(state -> {
            boolean snowy = state.getValue(SnowyDirtBlock.SNOWY);
            return ConfiguredModel.allYRotations(snowy ? grassSnowed : grass, 0, false);
        }, ColoredSapling.LIT);

    }


    private void doorWithElements(DoorBlock doorBlock, String defaultTexture) {

        ResourceLocation doorBlockRegistryName = BuiltInRegistries.BLOCK.getKey(doorBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);
        ResourceLocation textureTop = ResourceLocation.parse(defaultTexture + "_door_top");
        ResourceLocation textureBottom = ResourceLocation.parse(defaultTexture + "_door_bottom");

        ModelFile doorTopRightOpen = models().withExistingParent(doorBlockRegistryName.getPath() + "_top_right_open",
                "colors:block/door/tintable_door_top_right_open").texture("top", textureTop).renderType("cutout");

        ModelFile doorTopLeftOpen = models().withExistingParent(doorBlockRegistryName.getPath() + "_top_left_open",
                "colors:block/door/tintable_door_top_left_open").texture("top", textureTop).renderType("cutout");

        ModelFile doorTopRight = models().withExistingParent(doorBlockRegistryName.getPath() + "_top_right",
                "colors:block/door/tintable_door_top_right").texture("top", textureTop).renderType("cutout");

        ModelFile doorTopLeft = models().withExistingParent(doorBlockRegistryName.getPath() + "_top_left",
                "colors:block/door/tintable_door_top_left").texture("top", textureTop).renderType("cutout");

        ModelFile doorBottomRight = models().withExistingParent(doorBlockRegistryName.getPath() + "_bottom_right",
                "colors:block/door/tintable_door_bottom_right").texture("bottom", textureBottom).renderType("cutout");

        ModelFile doorBottomLeft = models().withExistingParent(doorBlockRegistryName.getPath() + "_bottom_left",
                "colors:block/door/tintable_door_bottom_left").texture("bottom", textureBottom).renderType("cutout");

        ModelFile doorBottomRightOpen = models().withExistingParent(doorBlockRegistryName.getPath() + "_bottom_right_open",
                "colors:block/door/tintable_door_bottom_right_open").texture("bottom", textureBottom).renderType("cutout");

        ModelFile doorBottomLeftOpen = models().withExistingParent(doorBlockRegistryName.getPath() + "_bottom_left_open",
                "colors:block/door/tintable_door_bottom_left_open").texture("bottom", textureBottom).renderType("cutout");

        getVariantBuilder(doorBlock).forAllStatesExcept(state -> {
            int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 90;
            boolean right = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
            boolean open = state.getValue(DoorBlock.OPEN);
            boolean lower = state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER;
            if (open) {
                yRot += 90;
            }
            if (right && open) {
                yRot += 180;
            }
            yRot %= 360;

            ModelFile model = null;
            if (lower && right && open) {
                model = doorBottomRightOpen;
            } else if (lower && !right && open) {
                model = doorBottomLeftOpen;
            }
            if (lower && right && !open) {
                model = doorBottomRight;
            } else if (lower && !right && !open) {
                model = doorBottomLeft;
            }
            if (!lower && right && open) {
                model = doorTopRightOpen;
            } else if (!lower && !right && open) {
                model = doorTopLeftOpen;
            }
            if (!lower && right && !open) {
                model = doorTopRight;
            } else if (!lower && !right && !open) {
                model = doorTopLeft;
            }

            return ConfiguredModel.builder().modelFile(model)
                    .rotationY(yRot)
                    .build();
        }, DoorBlock.POWERED, ColoredDoor.LIT);
    }

    private void trapDoorWithElements(TrapDoorBlock trapDoorBlock, String defaultTexture,  boolean orientable) {
        ResourceLocation trapDoorBlockRegistryName = BuiltInRegistries.BLOCK.getKey(trapDoorBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile trapDoorTop = models().withExistingParent(trapDoorBlockRegistryName.getPath() + "_top",
                "colors:block/trapdoor/tintable_orientable_trapdoor_top").texture("texture", texture).renderType("cutout");

        ModelFile trapDoorBottom = models().withExistingParent(trapDoorBlockRegistryName.getPath() + "_bottom",
                "colors:block/trapdoor/tintable_orientable_trapdoor_bottom").texture("texture", texture).renderType("cutout");

        ModelFile trapDoorOpen = models().withExistingParent(trapDoorBlockRegistryName.getPath() + "_open",
                "colors:block/trapdoor/tintable_orientable_trapdoor_open").texture("texture", texture).renderType("cutout");

        getVariantBuilder(trapDoorBlock).forAllStatesExcept(state -> {
            int xRot = 0;
            int yRot = ((int) state.getValue(TrapDoorBlock.FACING).toYRot()) + 180;
            boolean isOpen = state.getValue(TrapDoorBlock.OPEN);
            if (orientable && isOpen && state.getValue(TrapDoorBlock.HALF) == Half.TOP) {
                xRot += 180;
                yRot += 180;
            }
            if (!orientable && !isOpen) {
                yRot = 0;
            }
            yRot %= 360;
            return ConfiguredModel.builder().modelFile(isOpen ? trapDoorOpen : state.getValue(TrapDoorBlock.HALF) == Half.TOP ? trapDoorTop : trapDoorBottom)
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        }, TrapDoorBlock.POWERED, TrapDoorBlock.WATERLOGGED, ColoredTrapDoor.LIT);

        simpleBlockItem(trapDoorBlock, new ModelFile.UncheckedModelFile("colors:block/" + trapDoorBlockRegistryName.getPath() + "_bottom"));
    }


    private void fenceWithElements(FenceBlock fenceBlock,  String defaultTexture) {
        ResourceLocation fenceBlockRegistryName = BuiltInRegistries.BLOCK.getKey(fenceBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile fenceInventory = models().withExistingParent(fenceBlockRegistryName.getPath() + "_inventory",
                "colors:block/fence/tintable_fence_inventory").texture("texture", texture).renderType("cutout");

        ModelFile fencePost = models().withExistingParent(fenceBlockRegistryName.getPath() + "_post",
                "colors:block/fence/tintable_fence_post").texture("texture", texture).renderType("cutout");

        ModelFile fenceSide = models().withExistingParent(fenceBlockRegistryName.getPath() + "_side",
                "colors:block/fence/tintable_fence_side").texture("texture", texture).renderType("cutout");

        MultiPartBlockStateBuilder builder = getMultipartBuilder(fenceBlock)
                .part().modelFile(fencePost).addModel().end();
        fourWayMultipart(builder, fenceSide);

        simpleBlockItem(fenceBlock, new ModelFile.UncheckedModelFile("colors:block/" + fenceBlockRegistryName.getPath() + "_inventory"));

    }

    private void fenceGateWithElements(FenceGateBlock fenceGateBlock, String defaultTexture) {

        ResourceLocation fenceGateBlockRegistryName = BuiltInRegistries.BLOCK.getKey(fenceGateBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile fenceGate = models().withExistingParent(fenceGateBlockRegistryName.getPath(),
                "colors:block/fence_gate/tintable_fence_gate").texture("texture", texture).renderType("cutout");

        ModelFile fenceGateOpen = models().withExistingParent(fenceGateBlockRegistryName.getPath() + "_open",
                "colors:block/fence_gate/tintable_fence_gate_open").texture("texture", texture).renderType("cutout");

        ModelFile fenceGateWallOpen = models().withExistingParent(fenceGateBlockRegistryName.getPath() + "_wall_open",
                "colors:block/fence_gate/tintable_fence_gate_wall_open").texture("texture", texture).renderType("cutout");

        ModelFile fenceGateWall = models().withExistingParent(fenceGateBlockRegistryName.getPath() + "_wall",
                "colors:block/fence_gate/tintable_fence_gate_wall").texture("texture", texture).renderType("cutout");

        getVariantBuilder(fenceGateBlock).forAllStatesExcept(state -> {
            ModelFile model = fenceGate;
            if (state.getValue(FenceGateBlock.IN_WALL)) {
                model = fenceGateWall;
            }
            if (state.getValue(FenceGateBlock.OPEN)) {
                model = model == fenceGateWall ? fenceGateWallOpen : fenceGateOpen;
            }
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) state.getValue(FenceGateBlock.FACING).toYRot())
                    .uvLock(true)
                    .build();
        }, FenceGateBlock.POWERED, ColoredFence.LIT);

        simpleBlockItem(fenceGateBlock, new ModelFile.UncheckedModelFile("colors:block/" + fenceGateBlockRegistryName.getPath()));

    }

    private void slabWithElements(SlabBlock slabBlock, String defaultTexture) {
        ResourceLocation slabBlockRegistryName = BuiltInRegistries.BLOCK.getKey(slabBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile slab = models().withExistingParent(slabBlockRegistryName.getPath(), "colors:block/slab/tintable_slab")
                .texture("bottom", texture).texture("top", texture).texture("side", texture).renderType("cutout");

        ModelFile slabTop = models().withExistingParent(slabBlockRegistryName.getPath() + "_top", "colors:block/slab/tintable_slab_top")
                .texture("bottom", texture).texture("top", texture).texture("side", texture).renderType("cutout");

        String path = slabBlockRegistryName.getPath();
        if (slabBlockRegistryName.getPath().contains("brick_slab")) {
            path = slabBlockRegistryName.getPath().replace("_slab", "s");
        }
        else if (slabBlockRegistryName.getPath().contains("tile_slab")) {
            path = slabBlockRegistryName.getPath().replace("_slab", "s");
        }
        else if (slabBlockRegistryName.getPath().contains("plank_slab")) {
            path = slabBlockRegistryName.getPath().replace("_slab", "s");
        } else {
            path = slabBlockRegistryName.getPath().replace("_slab", "");
        }

        ModelFile doubleSlab =  models().withExistingParent(path,
                        ResourceLocation.parse("colors:block/tintable_cube_all"))
                        .texture("all", texture);

        getVariantBuilder(slabBlock)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(slab))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(slabTop))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(doubleSlab));


        simpleBlockItem(slabBlock, new ModelFile.UncheckedModelFile("colors:block/" + slabBlockRegistryName.getPath()));

    }


    private void simpleBlockWithElements(Block block, String defaultTexture) {
        ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile cube = models().withExistingParent(blockRegistryName.getPath(),"colors:block/tintable_cube_all")
                .texture("all",texture)
                .texture("particle", texture);

        simpleBlockItem(block, cube);

        getVariantBuilder(block).forAllStatesExcept(state ->
                ConfiguredModel.builder().modelFile(cube).build(), ColoredBlock.LIT);
    }

    private void buttonWithElements(ButtonBlock buttonBlock, String defaultTexture) {
        ResourceLocation buttonBlockRegistryName = BuiltInRegistries.BLOCK.getKey(buttonBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile button = models().withExistingParent(buttonBlockRegistryName.getPath(),
                "colors:block/button/tintable_button").texture("texture", texture).renderType("cutout");

        ModelFile buttonPressed = models().withExistingParent(buttonBlockRegistryName.getPath() + "_pressed",
                "colors:block/button/tintable_button_pressed").texture("texture", texture).renderType("cutout");

        ModelFile buttonInventory = models().withExistingParent(buttonBlockRegistryName.getPath() + "_inventory",
                "colors:block/button/tintable_button_inventory").texture("texture", texture).renderType("cutout");

        getVariantBuilder(buttonBlock).forAllStatesExcept(state -> {
            Direction facing = state.getValue(ButtonBlock.FACING);
            AttachFace face = state.getValue(ButtonBlock.FACE);
            boolean powered = state.getValue(ButtonBlock.POWERED);

            return ConfiguredModel.builder()
                    .modelFile(powered ? buttonPressed : button)
                    .rotationX(face == AttachFace.FLOOR ? 0 : (face == AttachFace.WALL ? 90 : 180))
                    .rotationY((int) (face == AttachFace.CEILING ? facing : facing.getOpposite()).toYRot())
                    .uvLock(face == AttachFace.WALL)
                    .build();
        });

        simpleBlockItem(buttonBlock, new ModelFile.UncheckedModelFile("colors:block/" + buttonBlockRegistryName.getPath() + "_inventory"));

    }

    private void pressurePlateWithElements(PressurePlateBlock pressurePlateBlock, String defaultTexture) {
        ResourceLocation pressurePlateBlockRegistryName = BuiltInRegistries.BLOCK.getKey(pressurePlateBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile pressurePlate = models().withExistingParent(pressurePlateBlockRegistryName.getPath(),
                "colors:block/pressure_plate/tintable_pressure_plate_up").texture("texture", texture).renderType("cutout");

        ModelFile pressurePlateDown = models().withExistingParent(pressurePlateBlockRegistryName.getPath() + "_down",
                "colors:block/pressure_plate/tintable_pressure_plate_down").texture("texture", texture).renderType("cutout");

        getVariantBuilder(pressurePlateBlock)
                .partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel(pressurePlateDown))
                .partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel(pressurePlate));

        simpleBlockItem(pressurePlateBlock, new ModelFile.UncheckedModelFile("colors:block/" + pressurePlateBlockRegistryName.getPath()));

    }

    private void wallWithElements(WallBlock wallBlock, String defaultTexture) {
        ResourceLocation wallBlockRegistryName = BuiltInRegistries.BLOCK.getKey(wallBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile wallInventory = models().withExistingParent(wallBlockRegistryName.getPath() + "_inventory",
                "colors:block/wall/tintable_wall_inventory").texture("wall", texture).renderType("cutout");

        ModelFile wallPost = models().withExistingParent(wallBlockRegistryName.getPath() + "_post",
                "colors:block/wall/tintable_wall_post").texture("wall", texture).renderType("cutout");

        ModelFile wallSide = models().withExistingParent(wallBlockRegistryName.getPath() + "_side",
                "colors:block/wall/tintable_wall_side").texture("wall", texture).renderType("cutout");

        ModelFile wallSideTall = models().withExistingParent(wallBlockRegistryName.getPath() + "_side_tall",
                "colors:block/wall/tintable_wall_side_tall").texture("wall", texture).renderType("cutout");

        MultiPartBlockStateBuilder builder = getMultipartBuilder(wallBlock)
                .part().modelFile(wallPost).addModel()
                .condition(WallBlock.UP, true).end();
        WALL_PROPS.entrySet().stream()
                .filter(e -> e.getKey().getAxis().isHorizontal())
                .forEach(e -> {
                    wallSidePart(builder, wallSide, e, WallSide.LOW);
                    wallSidePart(builder, wallSideTall, e, WallSide.TALL);
                });

        simpleBlockItem(wallBlock, new ModelFile.UncheckedModelFile("colors:block/" + wallBlockRegistryName.getPath() + "_inventory"));


    }

    private void wallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<WallSide>> entry, WallSide height) {
        builder.part()
                .modelFile(model)
                .rotationY((((int) entry.getKey().toYRot()) + 180) % 360)
                .uvLock(true)
                .addModel()
                .condition(entry.getValue(), height);
    }

    private void stairsWithElements(StairBlock stairsBlock, String defaultTexture) {
        ResourceLocation stairBlockRegistryName = BuiltInRegistries.BLOCK.getKey(stairsBlock);
        ResourceLocation texture = ResourceLocation.parse(defaultTexture);

        ModelFile stairs = models().withExistingParent(stairBlockRegistryName.getPath(), "colors:block/stairs/tintable_stairs")
                .texture("bottom", texture).texture("top", texture).texture("side", texture).renderType("cutout");

        ModelFile innerStairs = models().withExistingParent(stairBlockRegistryName.getPath() + "_inner", "colors:block/stairs/tintable_inner_stairs")
                .texture("bottom", texture).texture("top", texture).texture("side", texture).renderType("cutout");

        ModelFile outerStairs = models().withExistingParent(stairBlockRegistryName.getPath() + "_outer", "colors:block/stairs/tintable_outer_stairs")
                .texture("bottom", texture).texture("top", texture).texture("side", texture).renderType("cutout");

        getVariantBuilder(stairsBlock)
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(StairBlock.FACING);
                    Half half = state.getValue(StairBlock.HALF);
                    StairsShape shape = state.getValue(StairBlock.SHAPE);
                    int yRot = (int) facing.getClockWise().toYRot();
                    if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                        yRot += 270;
                    }
                    if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                        yRot += 90;
                    }
                    yRot %= 360;
                    boolean uvlock = yRot != 0 || half == Half.TOP;
                    return ConfiguredModel.builder()
                            .modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? innerStairs : outerStairs)
                            .rotationX(half == Half.BOTTOM ? 0 : 180)
                            .rotationY(yRot)
                            .uvLock(uvlock)
                            .build();
                }, StairBlock.WATERLOGGED, ColoredStairs.LIT);

        simpleBlockItem(stairsBlock, new ModelFile.UncheckedModelFile("colors:block/" + stairBlockRegistryName.getPath()));


    }
    @Override
    public String getName() {
        return Colors.MOD_ID + " Block States";
    }
}

