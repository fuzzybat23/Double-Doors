package com.fuzzybat23.ddoors;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class WoodenDoor
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

    public static void checkForDoors(PlayerInteractEvent.RightClickBlock event, Block block, BlockPos pos)
    {
        BlockDoor door1;

        for(EnumFacing facing : EnumFacing.HORIZONTALS)
        {
            logger.info("EnumFacing.HORIZONTALS = " + facing);
            Block targetblock = event.getWorld().getBlockState(event.getPos().offset(facing)).getBlock();
            logger.info("(targetblock)" + targetblock + " == (block)" + block);

            IBlockState targetstate = event.getWorld().getBlockState(pos);
                    event.getWorld().getBlockState(pos);
            if(targetblock == block)
            {
                logger.info("Eureka!!");
            }
        }
    }

    public static void WoodenDoorOpener(EntityPlayer player, Block block, BlockPos pos)
    {



    }
}
