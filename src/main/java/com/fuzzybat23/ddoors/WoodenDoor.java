package com.fuzzybat23.ddoors;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WoodenDoor
{
    public static final Logger logger = LogManager.getLogger();

    public static boolean isWoodenDoor(Block block, IBlockState state)
    {
        if(state.getBlock() instanceof BlockDoor && state.getMaterial() == Material.WOOD)
        {
            return true;
        }
        return false;
    }

    public static void checkForDoors(World world, IBlockState state, BlockPos pos)
    {
        Block target = world.getBlockState(pos).getBlock();

        for(EnumFacing facing : EnumFacing.HORIZONTALS)
        {
            Block offset = world.getBlockState(pos.offset(facing)).getBlock();

            if(target == offset)
            {

                //Check if upper or lower door
                logger.info("Eureka!!!");
                logger.info("You clicked on:  " + state.getValue(BlockDoor.HALF) + " part of the door.");
                logger.info("Doors are mirror:" + isDoubleDoor(world, pos, facing));
            }
        }
    }

    public static boolean isDoubleDoor(World world, BlockPos pos, EnumFacing offsetPos)
    {
        String RIGHT = "RIGHT";
        String LEFT = "LEFT";
        boolean flag = false;
        IBlockState targetState = world.getBlockState(pos);
        Block targetBlock = targetState.getBlock();

        IBlockState offsetState = world.getBlockState(pos.offset(offsetPos));
        Block offsetBlock = offsetState.getBlock();

        //Get correct blockState, including hinge, for targeted door.

        if(targetState.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER)
            if(targetState.getBlock() == targetBlock)
                targetState = world.getBlockState(pos.up());
        BlockDoor.EnumHingePosition targetHinge = targetState.getValue(BlockDoor.HINGE);

        //get correct blockState, including hinge, for offset door.

        if(offsetState.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER)
            if(offsetState.getBlock() == offsetBlock)
                offsetState = world.getBlockState(pos.offset(offsetPos).up());
        BlockDoor.EnumHingePosition offsetHinge = offsetState.getValue(BlockDoor.HINGE);

        logger.info("(targetHinge)(name)" + targetHinge.name() + "=? (offsetHinge)(name)" + offsetHinge.name() );

        if(((targetHinge.name() == RIGHT) && (offsetHinge.name() == LEFT)) || ((targetHinge.name() == LEFT) && (offsetHinge.name() == RIGHT)))
            flag = true;

        return flag;
    }
}
