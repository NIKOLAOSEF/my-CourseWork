//This program implements a GUI with text boxes which the user can input values
//and click on various buttons which simulate a gadget shop with mobile and MP3 gadgets respectively.
//The user can add a mobile, add mp3, make a call, and even download music. All of which are being simulated
//on a print screen

//import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener //action listener needed for buttons to work
{
    //declare labels
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
    
    //declare buttons
    private JButton AddMobileBtn;
    private JButton AddMP3Btn;
    private JButton ClearBtn;
    private JButton DisplayAllBtn;
    private JButton MakeACallBtn;
    private JButton DownloadMusicBtn;
    
    //declare textfields
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
    ArrayList<Gadget> item = new ArrayList<Gadget>();
    
    //declare variables
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
    
    //the main method which runs first and creates an object of type "GadgetShop" (GUI)
    public static void main(String[] args)
    {
        GadgetShop item = new GadgetShop();
    }
    
    public GadgetShop() //gui container
    {
        //create new frame with title "Gadget Shop"
        frame = new JFrame("Gadget Shop");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7,4)); //gridlayout (7 rows, 4 columns)
        
        //instantiate labels
        modelLabel = new JLabel("Model:");
        priceLabel = new JLabel("Price:");
        weightLabel = new JLabel("Weight:");
        sizeLabel = new JLabel("Size:");
        creditLabel = new JLabel("Credit (Mobile):");
        memoryLabel = new JLabel("Memory (MP3):");
        PhoneNoLabel = new JLabel("Phone No:");
        durationLabel = new JLabel("Duration (Minutes):");
        downloadLabel = new JLabel("Download (MB):");
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
        
        //if "Add Mobile" button pressed: check if display number is non-positive
        //if it is: call the AddMobile method, and increment the display number by 1
        //otherwise: do nothing
        if (command.equals("Add Mobile")) {
            if (displayNumber != -1) {
               try {
                    // retrieve variables
                    String model = getModel();
                    double price = getPrice();
                    double weight = getWeight();
                    String size = getSize();
                    int credit = getCredit();
                    int disNum = getDisplayNumber();
                    
                    // check if any required field is empty
                    if (model.isEmpty() || Double.isNaN(price) || Double.isNaN(weight)
                    || size.isEmpty() || credit == 0 || disNum == 0) {
                        // do nothing
                    } else {
                        addMobile();
                        displayNumber += 1;
                    }
                } catch (NumberFormatException ex) {
                    //handle the error in case of exception
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number in text fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    
            displayNumberTextField.setText(Integer.toString(displayNumber));
        }
        
        //if "Add MP3" button pressed: check if display number is non-positive
        //if it is: call the AddMP3 method, and increment the display number by 1
        //otherwise:  do nothing
        if (command.equals("Add MP3")) {
            if (displayNumber != -1) {
                try {
                    // retrieve variables
                    String model = getModel();
                    double price = getPrice();
                    double weight = getWeight();
                    String size = getSize();
                    int memory = getMemory();
                    int disNum = getDisplayNumber();
                    
                    // check if any required field is empty
                    if (model.isEmpty() || Double.isNaN(price) || Double.isNaN(weight)
                    || size.isEmpty() || memory == 0 || disNum == 0) {
                        // do nothing
                    } else {
                        addMP3();
                        displayNumber += 1;
                    }
                } catch (NumberFormatException ex) {
                    //handle the error in case of exception
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number in text fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    
            displayNumberTextField.setText(Integer.toString(displayNumber));
        }
        
        //when "Clear" button pressed:
        //call the clear method
        if (command.equals("Clear")) 
        {
            clear();
        }
        
        //when "Display All" button clicked:
        //call the DisplayAll method
        if (command.equals("Display All")) {
            displayAll();
        }
        
        //calls the makeACall method
        if (command.equals("Make A Call")) {
            makeCall();
        }
        
        //calls the downloadMusic method
        if (command.equals("Download Music")) {
            downloadMusic();
        }
    }
    
    //this method adds a mobile to gadgets array list if the required text fields are filled properly
    public void addMobile()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getSize();
        credit = getCredit();

        Mobile gadget = new Mobile(model, price, weight, size, displayNumber, credit);
        item.add(gadget);
    }
    
    //this method adds a mp3 to gadgets array list if the required text fields are filled properly
    public void addMP3()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getSize();
        memory = getMemory();
        
        MP3 gadget = new MP3(model, price, weight, size, displayNumber, memory);
        item.add(gadget);
    }
    
    //this method prints a screen of every variable of a gadget
    //for every gadget in the gadgets array list
    public void displayAll()
    {
        for (Gadget gadget : item) {
            System.out.println("Display Number: " + (gadget.getDisplayNumber() + 1));
            System.out.println("Model: " + gadget.getModel());
            System.out.println("Price: " + gadget.getPrice());
            System.out.println("Weight: " + gadget.getWeight());
            System.out.println("Size: " + gadget.getSize());
        }
    }
    
    //this method takes the specified variables (displayNumber, phoneNumber, duration)
    //and invokes the "makeCall" method in the mobile class from this class
    //based on the variable names given
    public void makeCall()
    {
        if (item.size() <= 0) {
            JOptionPane.showMessageDialog(frame, "Add a mobile first");
        } else {
            try {
                Gadget gadget = item.get(getDisplayNumber());
                if (getDisplayNumber() != -1 && gadget instanceof Mobile) {
                    Mobile mobile = (Mobile) item.get(getDisplayNumber());
                    mobile.setCall(getPhoneNumber(),getDuration());
                } else {
                    JOptionPane.showMessageDialog(frame, "This item is not a Mobile");
                }
            } catch (IndexOutOfBoundsException exception)
            {
                //display appropriate error dialog
            }
        }
    }
    
    //this method takes the inputs of display number and download size text fields
    //and invokes the download music method in the MP3 class from this class
    public void downloadMusic()
    {
        if (item.size() <= 0) {
            JOptionPane.showMessageDialog(frame, "Add a MP3 first");
        } else {
            try {
                Gadget gadget = item.get(getDisplayNumber());
                if (getDisplayNumber() != -1 && gadget instanceof MP3) {
                    MP3 mp3 = (MP3) item.get(getDisplayNumber());
                    mp3.downloadMusic(getDownloadSize());
                } else {
                    JOptionPane.showMessageDialog(frame, "This item is not a MP3");
                }
            } catch (IndexOutOfBoundsException exception)
            {
                //display appropriate error dialog
            }
        }
    }
    
    //this method makes every text field empty
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
        displayNumberTextField.setText("");
    }
    
    
    
    //get model method
    public String getModel()
    {
        String modelInputText = modelTextField.getText();
        try {
            if (modelInputText.equals("")) {
                JOptionPane.showMessageDialog(frame, "Model text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(modelInputText instanceof String)) {
                JOptionPane.showMessageDialog(frame, "Model must be a string", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(frame, "Model text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return modelInputText;
    }
    
    //get price method
    public double getPrice()
    {
        //get the text field and make it a variable
        String priceInputText = priceTextField.getText();
    
        // check if priceInputText is empty
        if (priceInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Price text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0.0;
        }
        
        try {
            //attempt to return the correct value
            return Double.parseDouble(priceInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Price must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0.0;
        }
    }
    
    //get weight method
    public int getWeight()
    {
        //get the text field and make it a variable
        String weightInputText = weightTextField.getText();
    
        // check if priceInputText is empty
        if (weightInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Weight text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(weightInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Weight must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get size method
    public String getSize()
    {
        String sizeInputText = sizeTextField.getText();
        try {
            if (sizeInputText.equals("")) {
                JOptionPane.showMessageDialog(frame, "Size text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(frame, "Size text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sizeInputText;
    }
    
    //get credit method
    public int getCredit()
    {
        //get the text field and make it a variable
        String creditInputText = creditTextField.getText();
    
        // check if priceInputText is empty
        if (creditInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Credit text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(creditInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Credit must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get memory method
    public int getMemory()
    {
        //get the text field and make it a variable
        String memoryInputText = memoryTextField.getText();
    
        // check if priceInputText is empty
        if (memoryInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Memory text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(memoryInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Memory must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get phone number method
    public int getPhoneNumber()
    {
        //get the text field and make it a variable
        String phoneNumberInputText = phoneNoTextField.getText();
    
        // check if priceInputText is empty
        if (phoneNumberInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Phone number text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(phoneNumberInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Phone number must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get duration method
    public int getDuration()
    {
        //get the text field and make it a variable
        String durationInputText = durationTextField.getText();
    
        // check if priceInputText is empty
        if (durationInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Duration text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(durationInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Duration must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get download size method
    public int getDownloadSize()
    {
        //get the text field and make it a variable
        String downloadSizeInputText = downloadSizeTextField.getText();
    
        // check if priceInputText is empty
        if (downloadSizeInputText.isEmpty()) {
            //display an error message
            JOptionPane.showMessageDialog(frame, "Download size text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
        
        try {
            //attempt to return the correct value
            return Integer.parseInt(downloadSizeInputText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "DownloadSize must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            // return a default value in case of error
            return 0;
        }
    }
    
    //get display number method
    public int getDisplayNumber()
    {
        int displayNumber = -1;
        
        try {
            displayNumber = Integer.parseInt(displayNumberTextField.getText());
            
            if (displayNumber < 0 || displayNumber >= item.size()) {
                JOptionPane.showMessageDialog(frame, "Display number is not within the correct range", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(frame, "Display number must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return displayNumber;
    }
}