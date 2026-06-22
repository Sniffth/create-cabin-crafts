package net.sniffth.create_cabin_crafts.block.machines;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MachineBlock extends HorizontalDirectionalBlock {
    private final VoxelShape shapeNorth;
    private final VoxelShape shapeEast;
    private final VoxelShape shapeSouth;
    private final VoxelShape shapeWest;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public MachineBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.shapeNorth = shape;
        this.shapeEast = rotateShape(Direction.NORTH, Direction.EAST, shape);
        this.shapeSouth = rotateShape(Direction.NORTH, Direction.SOUTH, shape);
        this.shapeWest = rotateShape(Direction.NORTH, Direction.WEST, shape);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> this.shapeEast;
            case SOUTH -> this.shapeSouth;
            case WEST -> this.shapeWest;
            default -> this.shapeNorth;
        };
    }

    private static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape buffer = shape;
        int times = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            VoxelShape sampled = Shapes.empty();
            for (var box : buffer.toAabbs()) {
                sampled = Shapes.or(sampled, Block.box(
                        16.0 - box.maxZ * 16.0, box.minY * 16.0, box.minX * 16.0,
                        16.0 - box.minZ * 16.0, box.maxY * 16.0, box.maxX * 16.0
                ));
            }
            buffer = sampled;
        }
        return buffer;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
