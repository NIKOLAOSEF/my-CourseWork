//get library functions
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener
{
    //buttons
    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JLabel creditLabel;
    private JLabel memoryLabel;
    private JLabel PhoneNoLabel;
    private JLabel durationLabel;
    private JLabel downloadLabel;
    private JLabel displayNumberLabel;
    
    //buttons
    private JButton AddMobileBtn;
    private JButton AddMP3Btn;
    private JButton ClearBtn;
    private JButton DisplayAllBtn;
    private JButton MakeACallBtn;
    private JButton DownloadMusicBtn;
    
    //textfields
    private JTextField modelTextField;
    private JTextField priceTextField;
    private JTextField weightTextField;
    private JTextField sizeTextField;
    private JTextField creditTextField;
    private JTextField memoryTextField;
    private JTextField phoneNoTextField;
    private JTextField durationTextField;
    private JTextField downloadSizeTextField;
    private JTextField displayNumberTextField;

    private JFrame frame;
    
    //array list of type "Gadget" to store gadgets
    ArrayList<Gadget> gadgets = new ArrayList<>();
    
    //variables
    private String model;
    private double price;
    private int weight;
    private String size;
    private int credit;
    private int memory;
    private int phoneNumber;
    private int duration;
    private int displayNumber;
    private int downloadSize;
    
    public GadgetShop() //gui container
    {
        frame = new JFrame("Gadget");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7,4)); //gridlayout (7 rows, 4 columns)
        
        //instantiate labels
        modelLabel = new JLabel("Model:");
        priceLabel = new JLabel("Price:");
        weightLabel = new JLabel("Weight:");
        sizeLabel = new JLabel("Size:");
        creditLabel = new JLabel("Credit:");
        memoryLabel = new JLabel("Memory:");
        PhoneNoLabel = new JLabel("Phone No:");
        durationLabel = new JLabel("Duration");
        downloadLabel = new JLabel("Download");
        displayNumberLabel = new JLabel("Display Number:");
        
        //instantiate text fields of character limit "15"
        modelTextField = new JTextField(15);
        priceTextField = new JTextField(15);
        weightTextField = new JTextField(15);
        sizeTextField = new JTextField(15);
        creditTextField = new JTextField(15);
        memoryTextField = new JTextField(15);
        phoneNoTextField = new JTextField(15);
        durationTextField = new JTextField(15);
        downloadSizeTextField = new JTextField(15);
        displayNumberTextField = new JTextField(15);
        
        //sets the text of display number to "-1"
        displayNumberTextField.setText("-1");
        
        //instantiate buttons
        AddMobileBtn = new JButton("Add Mobile");
        AddMP3Btn = new JButton("Add MP3");
        ClearBtn = new JButton("Clear");
        DisplayAllBtn = new JButton("Display All");
        MakeACallBtn = new JButton("Make A Call");
        DownloadMusicBtn = new JButton("Download Music");
        
        //add the gui elements to the frame
        contentPane.add(modelLabel);
        contentPane.add(priceLabel);
        contentPane.add(weightLabel);
        contentPane.add(sizeLabel);
        
        contentPane.add(modelTextField);
        contentPane.add(priceTextField);
        contentPane.add(weightTextField);
        contentPane.add(sizeTextField);
        
        contentPane.add(creditLabel);
        contentPane.add(memoryLabel);
        contentPane.add(AddMobileBtn);
        contentPane.add(AddMP3Btn);
        
        contentPane.add(creditTextField);
        contentPane.add(memoryTextField);
        contentPane.add(ClearBtn);
        contentPane.add(DisplayAllBtn);
        
        contentPane.add(PhoneNoLabel);
        contentPane.add(durationLabel);
        contentPane.add(downloadLabel);
        contentPane.add(displayNumberLabel);
        
        contentPane.add(phoneNoTextField);
        contentPane.add(durationTextField);
        contentPane.add(downloadSizeTextField);
        contentPane.add(displayNumberTextField);
        
        contentPane.add(MakeACallBtn);
        contentPane.add(DownloadMusicBtn);
        
        //add action listeners for each button
        AddMobileBtn.addActionListener(this);
        AddMP3Btn.addActionListener(this);
        ClearBtn.addActionListener(this);
        DisplayAllBtn.addActionListener(this);
        MakeACallBtn.addActionListener(this);
        DownloadMusicBtn.addActionListener(this);
        
        //initiate the frame visibility
        frame.pack();
        frame.setVisible(true);
    }
    
    //this method performs the actions based on specified conditions
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals("Add Mobile")) 
        {
            //add mobile method requires the display number to be of positive value 
            if (displayNumber == -1)
            {
                AddMobileMethod();
                displayNumber = 1;
            } else //if display number is positive: add 1 to it for every method call
            {
                AddMobileMethod();
                displayNumber+=1;
            }
            //convert the display number value to a string and
            //set the display number text to the "display number value"
            displayNumberTextField.setText(Integer.toString(displayNumber));
        }
        if (command.equals("Add MP3"))
        {
            //add mp3 method requires the display number to be of positive value 
            if (displayNumber == -1)
            {
                AddMP3Method();
                displayNumber = 1;
            } else //if display number is positive: add 1 to it for every method call
            {
                AddMP3Method();
                displayNumber+=1;
            }
            //convert the display number value to a string and
            //set the display number text to the "display number value"
            displayNumberTextField.setText(Integer.toString(displayNumber));
        }
        if (command.equals("Clear")) //when clear button pressed:
                                     //clear all text fields (empty text) 
                                     //and reset the
                                     //display number text to "-1"
        {
            clear();
        }
        
        //this method displays the details ( variables ) for each gadget in
        //the array list "Gadgets"
        if (command.equals("Display All")) {
            if (displayNumber < 1)
            {
                //message that shows if display number non-positive
                JOptionPane.showMessageDialog(frame,"Please enter a valid number");
            } else if (displayNumber != (int)displayNumber)
            {
                //message that shows if display number not an integer
                JOptionPane.showMessageDialog(frame,"Please enter an integer");
            } else 
            {
                //shows the display number value and
                //calls the display all method
                getDisplayNumber();
                DisplayAllMethod();
            }
        }
        
        //calls the call method
        if (command.equals("Make A Call")) {
            MakeACallMethod();
        }
        
        //calls the download music method
        if (command.equals("Download Music")) {
            DownloadMusicMethod();
        }

    }
    
    //this method adds a gadget of type "Mobile" to the gadgets array list
    public void AddMobileMethod()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getSize();
        credit = getCredit();
        
        Mobile gadget = new Mobile(model, price, weight, size, credit);
        gadgets.add(gadget);
    }
    
    //this method adds a gadget of type "MP3" to the gadgets array list
    public void AddMP3Method()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getSize();
        memory = getMemory();
        
        MP3 gadget = new MP3(model, price, weight, size, memory);
        gadgets.add(gadget);
    }
    
    //this method prints a screen of every variable of a gadget
    //for every gadget in the gadgets array list
    public void DisplayAllMethod()
    {
        for (Gadget gadget : gadgets)
        {
            System.out.println("Model: " + gadget.getModel());
            System.out.println("Price: " + gadget.getPrice());
            System.out.println("Weight: " + gadget.getWeight());
            System.out.println("Size: " + gadget.getSize());
        }
    }
    
    //this method takes the specified variables (displayNumber, phoneNumber, duration)
    //and invokes the "makeCall" method in the mobile class from this class
    //based on the variable names given
    public void MakeACallMethod()
    {
        displayNumber = getDisplayNumber();
        phoneNumber = getPhoneNumber();
        duration = getDuration();
        
        if (displayNumber != 1)
        {
            //wip
            gadgets.get(displayNumber).makeCall(phoneNumber, duration);
        }
    }
    
    //this method takes the inputs of display number and download size text fields
    //and invokes the download music method in the MP3 class from this class
    public void DownloadMusicMethod()
    {
        displayNumber = getDisplayNumber();
        downloadSize = getDownloadSize();
        
        if (displayNumber != -1)
        {
            gadgets.get(displayNumber).downloadMusic(phoneNumber, duration);
        }
    }
    
    //this method makes every text field, and resets the display number text
    //to "-1"
    public void clear()
    {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNoTextField.setText("");
        durationTextField.setText("");
        downloadSizeTextField.setText("");
        displayNumberTextField.setText("-1");
    }
    
    //get the model from the model text field 
    public String getModel()
    {
        String modelInputText = modelTextField.getText();
        return modelInputText;
    }
    
    //create a variable
    //convert the price text field to type "double"
    //initialise the temporary variable to price text field
    //return the value of this temporary variable
    public double getPrice()
    {
        double priceInputText = Double.parseDouble(priceTextField.getText());
        return priceInputText;
    }
    
    //create a variable
    //convert the weight text field to type "integer"
    //initialise the temporary variable to weight text field
    //return the value of this temporary variable
    public int getWeight()
    {
        int weightInputText = Integer.parseInt(weightTextField.getText());
        return weightInputText;
    }
    
    //create a variable
    //initialise the temporary variable to size text field
    //return the value of this temporary variable
    public String getSize()
    {
        String sizeInputText = sizeTextField.getText();
        return sizeInputText;
    }
    
    //create a variable
    //convert the credit text field to type "integer"
    //initialise the temporary variable to credit text field
    //return the value of this temporary variable
    public int getCredit()
    {
        int creditInputText = Integer.parseInt(creditTextField.getText());
        return creditInputText;
    }
    
    //create a variable
    //convert the memory text field to type "integer"
    //initialise the temporary variable to memory text field
    //return the value of this temporary variable
    public int getMemory()
    {
        int memoryInputText = Integer.parseInt(memoryTextField.getText());
        return memoryInputText;
    }
    
    //create a variable
    //convert the display number text field to type "integer"
    //initialise the temporary variable to display number text field
    //return the value of this temporary variable
    public int getDisplayNumber()
    {
        int displayNumberInputText = Integer.parseInt(displayNumberTextField.getText());
        return displayNumberInputText;
    }
    
    //create a variable
    //convert the phone number text field to type "integer"
    //initialise the temporary variable to phone number text field
    //return the value of this temporary variable
    public int getPhoneNumber()
    {
        int phoneNumberInputText = Integer.parseInt(phoneNoTextField.getText());
        return phoneNumberInputText;
    }
    
   //create a variable
    //convert the duration text field to type "integer"
    //initialise the temporary variable to duration text field
    //return the value of this temporary variable
    public int getDuration()
    {
        int durationInputText = Integer.parseInt(durationTextField.getText());
        return durationInputText;
    }
    
    //create a variable
    //convert the duration text field to type "integer"
    //initialise the temporary variable to duration text field
    //return the value of this temporary variable
    public int getDownloadSize()
    {
        int downloadSizeInputText = Integer.parseInt(downloadSizeTextField.getText());
        return downloadSizeInputText;
    }
}