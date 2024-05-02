public class MP3 extends Gadget
{
    private int memory;
    
    public MP3(String model, double price, int weight, String size, int displayNumber, int memory)
    {
        super(model, price, weight, size, displayNumber);
        this.memory = memory;
    }
    
    // setter method for memory
    public void setMemory(int memory) {
        this.memory = memory;
    }

    // getter method for memory
    public int getMemory() {
        return memory;
    }

    // this method simulates a music download
    public void downloadMusic(int downloadSize) {
        if (memory > downloadSize) {
            memory -= downloadSize;
            System.out.println("Download successful");
            System.out.println("Remaining available memory: " + memory);
        } else {
            System.out.println("Insufficient space");
            System.out.println("Available memory: " + memory);
        }
    }
    
    public void print()
    {
        super.print();
        System.out.println("Available memory :" + memory);
    }
}