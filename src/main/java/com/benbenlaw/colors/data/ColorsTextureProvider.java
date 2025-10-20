package com.benbenlaw.colors.data;

import com.benbenlaw.core.block.colored.util.ColorMap;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ColorsTextureProvider implements DataProvider {

    private final PackOutput packOutput;

    public ColorsTextureProvider(PackOutput output) {
        this.packOutput = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return CompletableFuture.runAsync(() -> {

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "apple", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "sapling", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_door", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_door", "item");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_sign", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_hanging_sign", "item");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_sign", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_hanging_sign", "item");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_sign", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_hanging_sign", "item");



            generateTintedTextures(cache, ColorMap.COLOR_MAP, "asteroid", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "asteroid_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "asteroid_tiles", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_door_bottom", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_door_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_trapdoor", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_planks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_door_bottom", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_door_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_trapdoor", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "braid", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "chaotic", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "cobblestone", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "cobblestone_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "cracked_stone_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "crafting_table", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "crafting_table_side", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "crafting_table_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "dandelion", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "dark_prismarine", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "dirt", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "encased", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "encased_connected", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "grass_block_side", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "grass_block_side_snow", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "grass_block_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "grass_block_top_snow", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "leaves", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "log", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "log_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "marble", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "marble_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "mosaic", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "planks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_door_bottom", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_door_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_door", "item");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_trapdoor", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "polished", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "poppy", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "prismarine", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "prismarine_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "road", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "sapling", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "short_grass", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stone", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stone_bricks", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stripped_bamboo", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stripped_bamboo_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stripped_log", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "stripped_log_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "tall_grass_bottom", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "tall_grass_top", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "tiles", "block");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "triple", "block");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_sign", "entity/signs/hanging");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_sign", "entity/signs/hanging");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_sign", "entity/signs/hanging");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_sign", "entity/signs");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_sign", "entity/signs");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_sign", "entity/signs");

            generateTintedTextures(cache, ColorMap.COLOR_MAP, "plank_sign", "gui/hanging_signs");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_plank_sign", "gui/hanging_signs");
            generateTintedTextures(cache, ColorMap.COLOR_MAP, "bamboo_mosaic_sign", "gui/hanging_signs");






        });
    }

    private void generateTintedTextures(CachedOutput cache, Map<? extends StringRepresentable, Integer> values, String baseTexture, String type) {
        // Load base PNG
        BufferedImage baseImage;
        try (InputStream is = ColorsTextureProvider.class.getClassLoader()
                .getResourceAsStream("assets/colors/textures/" + type + "/" + baseTexture + ".png")) {

            if (is == null) {
                throw new RuntimeException("Base texture not found at assets/colors/textures/" + type + "/" + baseTexture + ".png");
            }

            baseImage = ImageIO.read(is);

            if (baseImage == null) {
                throw new RuntimeException("Failed to read base texture as an image.");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading base texture", e);
        }

        // Generate tinted images
        for (Map.Entry<? extends StringRepresentable, Integer> entry : values.entrySet()) {
            var dyeColor = entry.getKey();
            int tint = entry.getValue();

            BufferedImage tintedImage = new BufferedImage(baseImage.getWidth(), baseImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

            for (int x = 0; x < baseImage.getWidth(); x++) {
                for (int y = 0; y < baseImage.getHeight(); y++) {
                    int pixel = baseImage.getRGB(x, y);

                    int alpha = (pixel >> 24) & 0xFF;
                    int red = (pixel >> 16) & 0xFF;
                    int green = (pixel >> 8) & 0xFF;
                    int blue = pixel & 0xFF;

                    int tintRed = (tint >> 16) & 0xFF;
                    int tintGreen = (tint >> 8) & 0xFF;
                    int tintBlue = tint & 0xFF;

                    int newRed = red * tintRed / 255;
                    int newGreen = green * tintGreen / 255;
                    int newBlue = blue * tintBlue / 255;

                    tintedImage.setRGB(x, y, (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue);
                }
            }

            // Correct output path (no duplicate assets folder)
            Path outputPath = packOutput.getOutputFolder()
                    .resolve("assets\\colors\\textures\\" + type + "\\" + dyeColor.getSerializedName() + "_" + baseTexture + ".png");

            // Ensure directory exists
            Path parent = outputPath.getParent();
            if (!parent.toFile().exists() && !parent.toFile().mkdirs()) {
                throw new RuntimeException("Failed to create output folder: " + parent);
            }

            try {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                HashingOutputStream hashingoutputstream = new HashingOutputStream(Hashing.sha1(), bytearrayoutputstream);

               try (var stream = hashingoutputstream) {
                   ImageIO.write(tintedImage, "png", stream);
               }

               cache.writeIfNeeded(outputPath, bytearrayoutputstream.toByteArray(), hashingoutputstream.hash());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getName() {
        return "Colors Texture Provider";
    }
}