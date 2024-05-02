public class Mobile extends Gadget
{
    private int credit;
    private int phoneNumber;
    private int callDuration;
    
    public Mobile(String model, double price, int weight, String size, int displayNumber, int credit)
    {
        super(model, price, weight, size, displayNumber);
        this.credit = credit;
    }
    
    public void addCredit(int cred)
    {
        if (credit <= 0) {
            System.out.println("Please enter a positive amount");
        } else {
            credit += cred;
        }
    }
    
    public int getRemainingCredit()
    {
        return credit;
    }
    
    // setter method for credits
    public void setCredit(int credit) {
        this.credit = credit;
    }

    // getter method for credits
    public int getCredit() {
        return credit;
    }

    // Method to make a call
    public void setCall(int phoneNumber, int duration) {
        if (credit > 0) {
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Duration: " + duration);
            System.out.println("Credits: " + credit);
            
            // Deduct call duration from available credits
            credit -= duration;
            if (credit >= 0) {
                System.out.println("Remaining Credits: " + credit);
            } else {
                System.out.println("Insufficient Credit");
                System.out.println("Credits: " + credit + duration); // showing how much more needed to make the call
            }
        } else {
            System.out.println("Insufficient Credit");
            System.out.println("Credits: " + credit);
        }
    }
    
    public void print()
    {
        super.print();
        System.out.println("Calling credit remaining :" + credit);
    }
}