package com.cookiejar.wildworld.common.block;

import com.cookiejar.wildworld.common.block.property.CarvedSide;
import com.cookiejar.wildworld.common.block.property.WWStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;

import javax.annotation.Nullable;

public class CarvedLargeMelonSliceBlock extends BaseLargeMelonSliceBlock {

    public static final EnumProperty<CarvedSide> CARVED_SIDE = WWStateProperties.CARVED_SIDE;

    public CarvedLargeMelonSliceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(CARVED_SIDE, CarvedSide.X));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState bottomBlock = context.getLevel().getBlockState(pos.below());
        BlockState topBlock = context.getLevel().getBlockState(pos.above());
        CarvedSide carvedSide = context.getClickedFace().getAxis() == Direction.Axis.X ? CarvedSide.X : CarvedSide.Z;

        if (bottomBlock.getBlock() instanceof BaseLargeMelonSliceBlock && bottomBlock.getValue(HALF) == Half.BOTTOM) {
            return defaultBlockState()
                    .setValue(FACING, bottomBlock.getValue(FACING))
                    .setValue(HALF, Half.TOP).setValue(CARVED_SIDE, carvedSide);
        }
        else if (topBlock.getBlock() instanceof BaseLargeMelonSliceBlock && topBlock.getValue(HALF) == Half.TOP) {
            return defaultBlockState()
                    .setValue(FACING, topBlock.getValue(FACING))
                    .setValue(HALF, Half.BOTTOM)
                    .setValue(CARVED_SIDE, carvedSide);
        }
        Half half = context.getPlayer() == null ? Half.BOTTOM :
                (Mth.sin(context.getPlayer().getViewXRot(1.0F) * ((float) Math.PI / 180F)) > 0 ? Half.BOTTOM : Half.TOP);

        return defaultBlockState()
                        .setValue(FACING, getFacing(context))
                        .setValue(HALF, half)
                        .setValue(CARVED_SIDE, carvedSide);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
            return super.rotate(state, rot).setValue(CARVED_SIDE, state.getValue(CARVED_SIDE) == CarvedSide.X ? CarvedSide.Z : CarvedSide.X);
        }
        return super.rotate(state, rot);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, CARVED_SIDE);
    }
}
