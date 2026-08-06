package com.benbenlaw.colors.data;

import com.benbenlaw.colors.util.ColorList;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FusionConnectedTextureOverridesProvider implements DataProvider {

    private static final List<String> CONNECTED_TYPES = List.of("road", "encased", "mosaic", "polished");

    private final PackOutput output;

    public FusionConnectedTextureOverridesProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        Path root = this.output.getOutputFolder().resolve("fusion-overrides");

        CompletableFuture<?>[] futures = ColorList.COLORS.stream()
                .flatMap(color -> CONNECTED_TYPES.stream()
                        .flatMap(type -> Stream.of(
                                DataProvider.saveStable(cachedOutput, buildModelJson(color, type),
                                        root.resolve("assets/colors/models/block/" + color + "_" + type + ".json")),
                                DataProvider.saveStable(cachedOutput, buildTextureMetaJson(),
                                        root.resolve("assets/colors/textures/block/" + color + "_" + type + "_connected.png.mcmeta"))
                        )))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures);
    }

    private JsonObject buildModelJson(String color, String type) {
        JsonObject model = new JsonObject();
        model.addProperty("loader", "fusion:model");
        model.addProperty("type", "connecting");
        model.addProperty("parent", "minecraft:block/cube_all");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", "colors:block/" + color + "_" + type + "_connected");
        textures.addProperty("particle", "colors:block/" + color + "_" + type);
        model.add("textures", textures);

        JsonObject connections = new JsonObject();
        connections.addProperty("type", "is_same_block");
        model.add("connections", connections);

        return model;
    }

    private JsonObject buildTextureMetaJson() {
        JsonObject root = new JsonObject();
        JsonObject fusion = new JsonObject();
        fusion.addProperty("type", "connecting");
        fusion.addProperty("layout", "pieced");
        root.add("fusion", fusion);
        return root;
    }

    @Override
    public String getName() {
        return "Fusion Connected Texture Overrides";
    }
}