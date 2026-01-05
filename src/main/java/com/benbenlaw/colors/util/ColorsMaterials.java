package com.benbenlaw.colors.util;

import com.benbenlaw.colors.Colors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;

import java.util.ArrayList;
import java.util.List;

public class ColorsMaterials {
    public static final List<Material> COPPER_CHEST_LOCATION = new ArrayList<>();
    public static final List<Material> COPPER_CHEST_LOCATION_LEFT = new ArrayList<>();
    public static final List<Material> COPPER_CHEST_LOCATION_RIGHT = new ArrayList<>();

    public static void bootstrap() {

        for (String color : ColorList.COLORS) {
            COPPER_CHEST_LOCATION.add(Sheets.CHEST_MAPPER.apply(Colors.identifier(color + "_chest")));
            COPPER_CHEST_LOCATION_LEFT.add(Sheets.CHEST_MAPPER.apply(Colors.identifier(color + "_chest_left")));
            COPPER_CHEST_LOCATION_RIGHT.add(Sheets.CHEST_MAPPER.apply(Colors.identifier(color + "_chest_right")));
        }
    }
}