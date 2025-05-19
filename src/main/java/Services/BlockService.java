package Services;

import Exceptions.DuplicateResourceException;
import Exceptions.ResourceNotFoundException;
import Models.Block;
import Models.ClassGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping track of the add/Remove block, addClassToBlock, getBlockByName
 * functions
 */

public class BlockService {

    /**
     * This is the list of blocks
     */
    private final List<Block> blockLists = new ArrayList<>();

    /**
     * This method is used to add a block to the list
     * @param block the block to be added
     */
    public void addBlock(Block block){
        for(Block existingblock : blockLists){  //check block is already exists or not.
            if(existingblock.getName().equalsIgnoreCase(block.getName())){
                throw new DuplicateResourceException("Block with name: "+ block.getName()+" is already exists.");
            }
        }
        blockLists.add(block);
    }

    /**
     * This method is used to remove a block from the list
     * @param block the block to be removed
     */
    public void removeBlock(Block block){
        for(Block existingblock : blockLists){  //To check whether the block is existing or not.
            if(existingblock.getName().equalsIgnoreCase(block.getName())){
                blockLists.remove(existingblock);
            }
        }
        throw new ResourceNotFoundException("Block with name: "+ block.getName() + " is not exists.");
    }

    /**
     * This method is used to get a block by name
     * @param name the name of the block
     * @return the block with the given name
     */
    public Block getBlockByName(String name){
        for(Block block: blockLists){
            if(block.getName().equals(name)){
                return block;
            }
        }
        throw new ResourceNotFoundException("Block with name: "+ name + " is not exists.");
    }

    /**
     * This method is used to add a classRoom to a block
     * @param classRoom the classRoom to be added
     * @param block the block to be added to
     */
    public void addClassToBlock(ClassGroup classRoom, Block block){

        //To check whether the block is existing or not.
        for(ClassGroup existingClassRoom : block.getClassGroupList()){
            if(existingClassRoom.getGrade() == classRoom.getGrade() && existingClassRoom.getSection() == classRoom.getSection()){
                throw new DuplicateResourceException("Class with Grade: "+ classRoom.getGrade() + "and Section: " + classRoom.getSection() + "is already exists in this block");
            }
        }
        block.addClasses(classRoom);
    }

    /**
     * This method is used to get all blocks
     * @return the list of all blocks
     */
    public List<Block> getBlockLists() {
        return blockLists;
    }
}
