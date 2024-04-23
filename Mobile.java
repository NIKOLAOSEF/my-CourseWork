public class Mobile extends Gadget
{
    private int credit;
    
    private int phoneNumber;
    private int callDuration;
    
    public Mobile(String model, double price, int weight, String size, int cred)
    {
        super(model, price, weight, size);
        credit = cred;
    }
    
    public void addCredit(int cred)
    {
        if (credit <= 0)
        {
            System.out.println("Please enter a positive amount");
        } else {
            credit += cred;
        }
    }
    
    public int getRemainingCredit()
    {
        return credit;
    }
    
    public void makeCall(int phone, int duration)
    {
        if (credit > 0)
        {
            System.out.println("Phone Number: " + phone);
            System.out.println("Duration: " + duration);
            
            credit = credit - duration;
        } else {
            System.out.println("Insufficient Credit");
        }
    }
    
    public void print()
    {
        super.print();
        System.out.println("Calling credit remaining :" + credit);
    }
}