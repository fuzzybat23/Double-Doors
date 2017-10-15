package com.fuzzybat23.ddoors;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.init.Blocks;

public class WoodenDoor
{
    public static boolean WoodenDoor(Block block)
    {
        BlockDoor[] doors = {(BlockDoor) Blocks.ACACIA_DOOR, (BlockDoor) Blocks.BIRCH_DOOR, (BlockDoor) Blocks.DARK_OAK_DOOR,
                (BlockDoor) Blocks.JUNGLE_DOOR, (BlockDoor) Blocks.OAK_DOOR, (BlockDoor) Blocks.SPRUCE_DOOR};

        for(BlockDoor door : doors)
        {
            if(block == door)
                return true;
        }
        return false;
    }
}
