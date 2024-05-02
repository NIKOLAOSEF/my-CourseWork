public class Gadget
{
    private String model;
    private double price;
    private int weight;
    private String size;
    
    private int displayNumber;
    
    public Gadget(String model, double price, int weight, String size, int displayNumber)
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.displayNumber = displayNumber;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public String getSize()
    {
        return size;
    }
    
    public int getDisplayNumber()
    {
        return displayNumber;
    }
    
    public void print()
    {
        System.out.println("Display Number: " + displayNumber);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
    }
}