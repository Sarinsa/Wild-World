package com.cookiejar.wildworld.common.block;

import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;

public class BaseLargeMelonSliceBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;

    public BaseLargeMelonSliceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM));
    }

    protected static Direction getFacing(UseOnContext context) {
        float f = Mth.wrapDegrees(context.getRotation()) / 45.0F;

        if (f > -2 && f <= 0) {
            return Direction.NORTH;
        }
        else if (f > 0 && f <= 2) {
            return Direction.EAST;
        }
        else if (f > 2) {
            return Direction.SOUTH;
        }
        else {
            return Direction.WEST;
        }
    }

    protected static boolean canCarve(Direction hitFace, Direction facing) {
        return hitFace == facing || hitFace == facing.getCounterClockWise();
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        Direction.Axis axis = state.getValue(FACING).getAxis();

        if (mirror == Mirror.NONE) return state;

        if ((mirror == Mirror.FRONT_BACK && axis == Direction.Axis.X) || (mirror == Mirror.LEFT_RIGHT && axis == Direction.Axis.Z)) {
            return state.rotate(Rotation.COUNTERCLOCKWISE_90);
        }
        else {
            return state.rotate(Rotation.CLOCKWISE_90);
        }
    }
}
