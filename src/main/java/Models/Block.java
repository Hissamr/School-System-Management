package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for the no of classRoom, floors, name of the block information.
 */

public class Block {

    private String name;
    private final List<ClassGroup> classList = new ArrayList<>();
    private int floors;
    private int totalClasses;

    public Block(String name, int floors){
        this.name = name;
        this.floors = floors;
    }

    /**
     * To get the name of the block
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * To set the name of the block
     * @param name name of the block.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * To get the floors of the block
     * @return floors.
     */
    public int getFloors() {
        return floors;
    }

    /**
     * To set the floors of the block
     * @param floors floors of the block.
     */
    public void setFloors(int floors){
        this.floors = floors;
    }

    /**
     * To get the classRoom list of the block
     * @return classList.
     */
    public List<ClassGroup> getClassGroupList() {
        return classList;
    }

    /**
     * To get the total number of classRoom in the block
     * @return totalClasses.
     */
    public int getTotalClasses(){
        return totalClasses;
    }

    /**
     * To add the classRoom to the block
     * @param classRoom object.
     */
    public void addClasses(ClassGroup classRoom) {
        classList.add(classRoom);// add the classRoom to the list
        classRoom.setBlock(this);// set the block to the classRoom. two-way pointing
        this.totalClasses = classList.size() ;//update the totalClasses
    }


    /**
     * To return the information of the Block.
     * @return String.
     */
    @Override
    public String toString() {

        return "Block {\n" +
                "\tname: '" + name + "',\n" +
                "\tclasses: " + classList + ",\n" +
                "\tfloors: " + floors + ",\n" +
                "\ttotalClasses: " + totalClasses + "\n" +
                '}';
    }
}
