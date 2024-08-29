package com.cookiejar.wildworld.common.block.property;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

public enum CarvedSide implements StringRepresentable {

    X("x"),
    Z("z");

    private final String name;

    CarvedSide(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public static CarvedSide getCarvedSide(Direction.Axis axis) {
        return axis == Direction.Axis.X ? CarvedSide.X : CarvedSide.Z;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
