public class MP3 extends Gadget
{
    private int memory;
    
    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }
    
    public int getMemory()
    {
        return memory;
    }
    
    public void downloadMusic(int downloadSize)
    {
        if (memory > downloadSize)
        {
            memory = memory - downloadSize;
        } else {
            System.out.println("Insufficient space");
        }
    }
    
    public void deleteMusic(int downloadSize)
    {
        memory = memory + downloadSize;
    }
    
    public void print()
    {
        super.print();
        System.out.println("Available memory :" + memory);
    }
}