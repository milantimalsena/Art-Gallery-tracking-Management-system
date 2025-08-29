/**
 A graphical user interface (GUI) for managing art gallery visitors and their activities.
 Provides input fields, buttons, and an output area for interacting with visitor data.
  @author Milan Timalsena
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
class ArtGalleryGUI {
    // LA GUI Banaidim nata

    private JFrame frame;
    private JPanel mainPanel, buttonPanel, formPanel,aarkoformPanel, outputPanel;
    private JLabel visitoridlabel, nameLabel, registrationdatLabel, tickettype, ticketpricLabel, artworknameLabel, artworkpricLabel, cancelationLabel, phoneLabel;
    private JTextField visitoridField, nameField,  phoneField,ticketpriceField;
    private JTextArea cancelationField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton addvisitorButton, logButton, buyButton, checkupgradeButton,
            AssignpersonaladviserButton, calculatediscountButton, rewardButton, cancelButton,
            clearButton, saveButton, ReadButton,detailsButton, generatebillButton;
    
    private JComboBox<String> ticketTypeComboBox;
    
    private JTextArea outputArea;
    private String[] ticketTypes = {"Standard", "Elite"};

    private List<ArtGalleryVisitor> visitorList = new ArrayList<>(); // Added visitorList

     private JComboBox<String> dayComboBox, monthComboBox, yearComboBox;
    private String[] months = {"Baisakh", "Jestha", "Asar", "Shrawan", "Bhadra", "Ashwin", "Kartik", "Mangsir", "Poush", "Magh", "Falgun", "Chaitra"};
   
    private String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                             "11", "12", "13", "14", "15", "16", "17", "18",
                             "19", "20", "21", "22", "23", "24", "25", "26",
                             "27", "28", "29", "30", "31","32"};


//Index ganera kina hairan garnu final-initial+1 garda aaihalxa ni (saugat sir le vannu vako lazy harle naya kuro khojxan re)

   int years[]= new int[2082-1990+1];{

for (int i = 1990; i <= 2082; i++) {
    years[i - 1990] = i;
}

   }


   /**
      Constructs the Art Gallery GUI, setting up the frame, panels, and components.
     */
   public  ArtGalleryGUI(){

   frame= new JFrame("Art Gallery");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(1400, 800);
   frame.setIconImage(Toolkit.getDefaultToolkit().getImage("me.png")); // Set the icon image
    // frame.setResizable(false); // Disable resizing
    frame.setLocationRelativeTo(null); 
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(BorderFactory.createTitledBorder("Art Gallery Management System"));
    frame.add(mainPanel);

    buttonPanel = new JPanel();
    // buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4 rows, 4 columns with gaps
    buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

    buttonPanel.setPreferredSize(new Dimension(800, 200));
    buttonPanel.setBackground(Color.LIGHT_GRAY);
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons"));
    addvisitorButton = new JButton("Add Visitor");
    logButton = new JButton("Log Visit");
    buyButton = new JButton("Buy Product");
    checkupgradeButton = new JButton("Check Upgrade");
    AssignpersonaladviserButton = new JButton("Assign Personal Adviser");
    calculatediscountButton = new JButton("Calculate Discount");
    rewardButton = new JButton("Reward points");
    cancelButton = new JButton("Cancel product");
    clearButton = new JButton("Clear All");
    saveButton = new JButton("Save to file");
    ReadButton = new JButton("Read from file");
    detailsButton = new JButton("Visitor Details");
    generatebillButton = new JButton("Generate Bill");
    



    // Button add garako screen ma dekhine
    buttonPanel.add(addvisitorButton);
    buttonPanel.add(logButton);
    buttonPanel.add(buyButton);
    buttonPanel.add(checkupgradeButton);
    buttonPanel.add(AssignpersonaladviserButton);
    buttonPanel.add(calculatediscountButton);
    buttonPanel.add(rewardButton);
    buttonPanel.add(cancelButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(ReadButton);
    buttonPanel.add(detailsButton);
    buttonPanel.add(generatebillButton);


      // Form panel for input fields
    formPanel = new JPanel();
    formPanel.setLayout(new GridBagLayout());
    formPanel.setBorder(BorderFactory.createTitledBorder("Form Panel"));
 
    formPanel = new JPanel();
    formPanel.setLayout(new GridBagLayout());
    formPanel.setBorder(BorderFactory.createTitledBorder("Visitor Information"));
   


       GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(15, 10, 20, 10); //
    gbc.ipady = 10; //padding deko
   
    
    


     //registration date ko lagi.
        registrationdatLabel = new JLabel("Registration Date:");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(registrationdatLabel, gbc);


     JPanel DatePanel = new JPanel();
     DatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
     DatePanel.setBackground(Color.lightGray);
    // Date ko lagi combo boxes
    
    //  DatePanel.add(dayComboBox);
    // DatePanel.add(monthComboBox);
    // DatePanel.add(yearComboBox);
    dayComboBox = new JComboBox<>(days);
    dayComboBox.setSelectedIndex(0); 
    monthComboBox = new JComboBox<>(months);
    monthComboBox.setSelectedIndex(0); 
    yearComboBox = new JComboBox<>();
    for (int year : years) {
        yearComboBox.addItem(String.valueOf(year));
    }
    yearComboBox.setSelectedIndex(92); 
    DatePanel.add(dayComboBox);
    DatePanel.add(monthComboBox);
    DatePanel.add(yearComboBox);
   
    gbc.gridx = 5;
    gbc.gridy = 0;
    formPanel.add(DatePanel, gbc);





    // formPanel.add(visitoridlabel, gbc);
    visitoridlabel = new JLabel("Visitor Id:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(visitoridlabel, gbc);

    visitoridField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;// Text field lai left align garne (suru bata)

    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    gbc.weightx = 1.0; // Text field lai extra space dinchha
    formPanel.add(visitoridField, gbc);


    // Name ko lagi label ra text field
    nameLabel = new JLabel("Name:");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(nameLabel, gbc);
    nameField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 2;
    
    formPanel.add(nameField, gbc);

   

    //contact no ko lagi
    phoneLabel= new JLabel("Contact number:");
    gbc.gridx=4;
    gbc.gridy=3;
    gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneLabel,gbc);

   phoneField = new JTextField(15);
   gbc.gridx=5;
   gbc.gridy=3;
   gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneField,gbc);

    

    //Gender ko lagi label ra radio buttons
    JLabel genderLabel = new JLabel("Gender:");
       gbc.gridx=0;
       gbc.gridy= 3;

       formPanel.add(genderLabel, gbc);


    JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        
       

        genderPanel.setBackground(Color.lightGray);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        maleRadioButton.setBackground(Color.lightGray);
        femaleRadioButton.setBackground(Color.lightGray);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Span two columns to accommodate both radio buttons
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(genderPanel, gbc);








    //ticket type ko lagi label ra combo box
    tickettype = new JLabel("Ticket Type:");
    gbc.gridx = 4;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(tickettype, gbc);
    ticketTypeComboBox = new JComboBox<>(ticketTypes);
    ticketTypeComboBox.setSelectedIndex(0); // Default to "Standard"
    gbc.gridx = 5;
    gbc.gridy = 1;
    formPanel.add(ticketTypeComboBox, gbc);



    


    
    //Ticket price ko lagi label
    ticketpricLabel = new JLabel("Ticket price:");
    gbc.gridx = 4;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpricLabel, gbc);


    ticketpriceField =new JTextField(15);
    ticketpriceField.setText("Rs 1000"); 
    gbc.gridx =5;
    gbc.gridy =2;
     gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpriceField, gbc);
    ticketpriceField.setEditable(false);
    
     /**
             * Updates ticket price field based on selected ticket type.
             * @param e Action event triggered by combo box selection
             */


    ticketTypeComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedType = (String) ticketTypeComboBox.getSelectedItem();
            if (selectedType != null) {
                if (selectedType.equals("Standard")) {
                    ticketpriceField.setText("Rs 1000");
                } else if (selectedType.equals("Elite")) {
                    ticketpriceField.setText("Rs 2000");
                }
            }
        }
    });

    //Artwork name ko lagi label ra text field
    artworknameLabel = new JLabel("Artwork Name:");
    gbc.gridx =0;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworknameLabel, gbc);
    JTextField artworkNameField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkNameField, gbc);

    //Artwork price ko lagi label ra text field
    artworkpricLabel = new JLabel("Artwork Price:");
    gbc.gridx = 4;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkpricLabel, gbc);
    JTextField artworkPriceField = new JTextField(15);
    gbc.gridx = 5;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkPriceField, gbc);




 


    aarkoformPanel = new JPanel();
    aarkoformPanel.setLayout(new GridBagLayout());
    
     

    // Cancelation reason ko lagi label ra text field
    cancelationLabel = new JLabel("Cancelation Reason");
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.anchor = GridBagConstraints.LINE_START;
    
    formPanel.add(cancelationLabel, gbc);

    cancelationField = new JTextArea(4, 15);
    cancelationField.setLineWrap(true); // Line wrap for better readability
    cancelationField.setWrapStyleWord(true); // Wrap at word boundaries
    cancelationField.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Add border for better visibility
    gbc.gridx = 1;
    gbc.gridy = 6;
  
    gbc.anchor = GridBagConstraints.LINE_START; // Text field lai left align garne
    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    formPanel.add(cancelationField, gbc);





   


            /**
             * Adds a new visitor to the visitor list based on input fields.
             * @param e Action event triggered by button click
             */
        addvisitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve input values
                    String idString = visitoridField.getText().trim();
                    int visitorId = Integer.parseInt(idString);
                    String fullName = nameField.getText().trim();
                    String contactNumber = phoneField.getText().trim();
                    String ticketType = (String) ticketTypeComboBox.getSelectedItem();
                    String ticketPriceText = ticketpriceField.getText().trim().replace("Rs ", "");
                    double ticketCost = Double.parseDouble(ticketPriceText);
                    String registrationDate = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                    String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "";

                    // Validate inputs
                    if (fullName.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Full Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (gender.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (contactNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Contact Number is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Check for Visitor ID duplication
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            JOptionPane.showMessageDialog(frame, "Error: Visitor ID " + visitorId + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    // Create visitor object based on ticket type
                    ArtGalleryVisitor visitor;
                    if (ticketType.equals("Standard")) {
                        visitor = new StandardVisitor(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
                    } else {
                        visitor = new EliteVisitor(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
                    }

                    // Add to visitorList
                    visitorList.add(visitor);
                    outputArea.append("New Visitor added: " + fullName + " (ID: " + visitorId + ")\n");

                    JOptionPane.showMessageDialog(frame, ticketType + " Visitor added successfully: " + fullName + " with ID: " + visitorId, "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a valid Visitor ID or Ticket Price (numeric).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });









        /**
             * Logs a visit for the specified visitor ID and updates the output area.
             * @param e Action event triggered by button click
             */

      logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                try {
                    int visitorId = Integer.parseInt(idString);
                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            visitor.logVisit();
                            visitorFound = true;
                            // Display in output panel
                            outputArea.setText("");
                            outputArea.append("Visit logged for:\n");
                            outputArea.append("Visitor ID: " + visitorId + "\n");
                            outputArea.append("Visit Count: " + visitor.getVisitCount() + "\n");
                            JOptionPane.showMessageDialog(frame, 
                                "Visit logged for Visitor ID: " + visitorId + ", Name: " + visitor.getFullName(), 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                                
                                

                                outputArea.append("Visit logged successfully for Visitor ID: " + visitorId + "\n");
                                outputArea.append("Visitor Name: " + visitor.getFullName() + "\n");
                                outputArea.append("Total Visits: " + visitor.getVisitCount() + "\n");
                                

                            break;
                        }
                    }
                    if (!visitorFound) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter a valid Visitor ID (numeric).\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });


/**
             * Cancels a purchased product for the specified visitor ID.
             * @param e Action event triggered by button click
             */
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                String artworkName = artworkNameField.getText().trim();
                String cancellationReason = cancelationField.getText().trim();

                if (idString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a Visitor ID.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (artworkName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Artwork Name is required.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int visitorId = Integer.parseInt(idString);
                    if (visitorList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No visitors registered. Please add a visitor first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            String result = visitor.cancelProduct(artworkName, cancellationReason);
                            visitorFound = true;
                            if (result.startsWith("Error")) {
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Success", 
                                    JOptionPane.INFORMATION_MESSAGE);

                                // Clear output area and display cancellation details
                                outputArea.setText("Cancellation successful for Visitor ID: " + visitorId + "\n");
                                outputArea.append("Artwork Name: " + artworkName + "\n");
                                outputArea.append("Cancellation Reason: " + cancellationReason + "\n");
                                outputArea.append("Refundable Amount: Rs " + visitor.getRefundableAmount() + "\n");
                            }
                            break;
                        }
                    }
                    if (!visitorFound) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });




  /**
             * Processes a product purchase for the specified visitor ID.
             * @param e Action event triggered by button click
             */
         buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                String artworkName = artworkNameField.getText().trim();
                String artworkPriceString = artworkPriceField.getText().trim();

                try {
                    int visitorId = Integer.parseInt(idString);
                    if (artworkName.isEmpty()) {
                        outputArea.setText("Error: Artwork Name is required.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Artwork Name is required.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double artworkPrice = Double.parseDouble(artworkPriceString);
                    if (artworkPrice <= 0) {
                        outputArea.setText("Error: Artwork Price must be a positive number.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Artwork Price must be a positive number.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            String result = visitor.buyProduct(artworkName, artworkPrice);
                            visitorFound = true;
                            if (result.startsWith("Error")) {
                                outputArea.setText(result + "\n");
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Clear output area and display purchase details
                                outputArea.setText("");
                                outputArea.append("Purchase Details:\n");
                                outputArea.append("Visitor ID: " + visitorId + "\n");
                                outputArea.append("Visitor Name: " + visitor.getFullName() + "\n");
                                outputArea.append("Artwork Name: " + artworkName + "\n");
                                outputArea.append("Artwork Price: Rs " + artworkPrice + "\n");
                                
                                // Show thank you message with visitor's name
                                JOptionPane.showMessageDialog(frame, 
                                    "Thank you " + visitor.getFullName() + " for your purchase", 
                                    "Success", 
                                    JOptionPane.INFORMATION_MESSAGE);
                            }
                            outputArea.append(artworkName + " purchased successfully by " + visitor.getFullName() + "\n");
                            break;
                        }
                    }
                    if (!visitorFound) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter a valid Visitor ID or Artwork Price (numeric).\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID or Artwork Price (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });




/**
 * Displays details of all visitors in a new frame with a table.
 * @param e Action event triggered by button click
 */
detailsButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (visitorList.isEmpty()) {
            outputArea.setText("Error: No visitors registered to display.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: No visitors registered to display.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Define table columns
        String[] columnNames = {
            "ID", "Name", "Gender", "Contact", "Reg. Date", "Ticket", "Price", "Visits",
            "Reward Pts", "Cancels", "Refund Amt", "Artwork Name", "Art Price", "Discount",
            "Final Price", "Active", "Bought", "Cancel Reason", "Visitor Type"
        };
        Object[][] tableData = new Object[visitorList.size()][columnNames.length];
        
        // Populate table data
        int row = 0;
        for (ArtGalleryVisitor visitor : visitorList) {
            String artworkName = visitor.getArtworkName() != null ? visitor.getArtworkName() : "None";
            String cancellationReason = visitor.getCancellationReason() != null ? visitor.getCancellationReason() : "None";
            String visitorTypeDetails = "";
            if (visitor instanceof StandardVisitor) {
                StandardVisitor stdVisitor = (StandardVisitor) visitor;
                visitorTypeDetails = String.format("Standard, Eligible for Upgrade: %s, Discount Percent: %.0f%%", 
                    stdVisitor.isEligibleForDiscountUpgrade(), stdVisitor.getDiscountPercent() * 100);
            } else if (visitor instanceof EliteVisitor) {
                EliteVisitor eliteVisitor = (EliteVisitor) visitor;
                visitorTypeDetails = String.format("Elite, Advisor Assigned: %s, Event Access: %s", 
                    eliteVisitor.getAssignedPersonalArtAdvisor(), eliteVisitor.getExclusiveEventAccess());
            }
            tableData[row] = new Object[] {
                visitor.getVisitorId(),
                visitor.getFullName(),
                visitor.getgender(),
                visitor.getContactNumber(),
                visitor.getRegistrationDate(),
                visitor.getTicketType(),
                String.format("%.2f", visitor.getTicketCost()),
                visitor.getVisitCount(),
                String.format("%.2f", visitor.getRewardPoints()),
                visitor.getCancelCount(),
                String.format("%.2f", visitor.getRefundableAmount()),
                artworkName,
                String.format("%.2f", visitor.getArtworkPrice()),
                String.format("%.2f", visitor.getDiscountAmount()),
                String.format("%.2f", visitor.getFinalPrice()),
                String.valueOf(visitor.isActive()),
                String.valueOf(visitor.isBought()),
                cancellationReason,
                visitorTypeDetails
            };
            row++;
        }

        // Create new frame for displaying data
        JFrame displayFrame = new JFrame("All Visitor Details");
        displayFrame.setSize(1200, 400);
        displayFrame.setLocationRelativeTo(frame);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create table
        JTable table = new JTable(tableData, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Allow horizontal scrolling
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Adjust column widths
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
        table.getColumnModel().getColumn(11).setPreferredWidth(150); // Artwork Name
        table.getColumnModel().getColumn(17).setPreferredWidth(150); // Cancel Reason
        table.getColumnModel().getColumn(18).setPreferredWidth(200); // Visitor Type

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        displayFrame.add(scrollPane, BorderLayout.CENTER);

        // Show frame
        displayFrame.setVisible(true);

        outputArea.setText("All visitor details displayed in a new window.\n");
        JOptionPane.showMessageDialog(frame, 
            "All visitor details displayed in a new window.", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
    }
});







        /**
             * Clears all input fields and resets selections upon user confirmation.
             * @param e Action event triggered by button click
             */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, 
                    "Do you really want to clear all fields?", 
                    "Confirm Clear", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    // Clear text fields
                    visitoridField.setText("");
                    nameField.setText("");
                    phoneField.setText("");
                    artworkNameField.setText("");
                    artworkPriceField.setText("");
                    cancelationField.setText("");
                    
                    // Clear radio buttons
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                    
                    // Reset combo boxes to default
                    dayComboBox.setSelectedIndex(0);
                    monthComboBox.setSelectedIndex(0);
                    yearComboBox.setSelectedIndex(92); // Default to 2082
                    ticketTypeComboBox.setSelectedIndex(0); // Default to Standard
                    
                    // Ticket price updates automatically via ticketTypeComboBox listener
                    System.out.println("All input fields cleared.");
                    JOptionPane.showMessageDialog(frame, 
                        "All fields cleared successfully.", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("Clear operation cancelled by user.");
                }
            }
        });
        


            /**
             * Generates a bill for the specified visitor ID and displays it in the output area.
             * @param e Action event triggered by button click
             */

      generatebillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                if (idString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a Visitor ID.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(idString);
                    if (visitorList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No visitors registered. Please add a visitor first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            outputArea.setText("");
                            if (!visitor.isBought() || visitor.getArtworkName() == null) {
                                outputArea.append("No purchase made to generate a bill.\n");
                                JOptionPane.showMessageDialog(frame, 
                                    "Error: No purchase made for Visitor ID: " + visitorId, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            StringBuilder bill = new StringBuilder();
                            bill.append("Bill Details:\n");
                            bill.append("-------------\n");
                            if (visitor instanceof EliteVisitor) {
                                bill.append("Thank you ").append(visitor.getFullName()).append(" for visiting hamro art gallery\n");
                            }
                            bill.append("Visitor ID: ").append(visitor.getVisitorId()).append("\n");
                            bill.append("Visitor Name: ").append(visitor.getFullName()).append("\n");
                            bill.append("Artwork Name: ").append(visitor.getArtworkName()).append("\n");
                            bill.append("Artwork Price: Rs ").append(visitor.getArtworkPrice()).append("\n");
                            bill.append("Discount Amount: Rs ").append(visitor.getDiscountAmount()).append("\n");
                            bill.append("Final Price: Rs ").append(visitor.getFinalPrice()).append("\n");
                            bill.append("-------------\n");
                            outputArea.append(bill.toString());
                            visitorFound = true;
                            JOptionPane.showMessageDialog(frame, 
                                "Bill generated for Visitor ID: " + visitorId + " in the output area.", 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if (!visitorFound) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });



   /**
             * Calculates and displays the discount for the specified visitor ID.
             * @param e Action event triggered by button click
             */
        calculatediscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idText = visitoridField.getText().trim();
                    if (idText.isEmpty()) {
                        outputArea.setText("Error: Please enter a Visitor ID.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Please enter a Visitor ID.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int visitorId;
                    try {
                        visitorId = Integer.parseInt(idText);
                        // calculate discount shown in outputArea
                      
                    } catch (NumberFormatException ex) {
                        outputArea.setText("Error: Invalid Visitor ID. Please enter a numeric ID.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Invalid Visitor ID. Please enter a numeric ID.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ArtGalleryVisitor visitor = null;
                    for (ArtGalleryVisitor v : visitorList) {
                        if (v.getVisitorId() == visitorId) {
                            visitor = v;
                            break;
                        }
                    }
                    
                    if (visitor == null) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (!visitor.isBought() || visitor.getArtworkName() == null) {
                        outputArea.setText("Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    double discount = visitor.calculateDiscount();
                    StringBuilder details = new StringBuilder();
                    details.append("Discount calculated for Visitor ID: ").append(visitorId).append("\n");
                    details.append("Visitor Type: ").append(visitor.getClass().getSimpleName()).append("\n");
                    details.append("Full Name: ").append(visitor.getFullName()).append("\n");
                    details.append("Artwork Name: ").append(visitor.getArtworkName()).append("\n");
                    details.append("Artwork Price: ").append(visitor.getArtworkPrice()).append("\n");
                    details.append("Discount Amount: ").append(discount).append("\n");
                    details.append("Final Price: ").append(visitor.getFinalPrice()).append("\n");
                    
                    if (visitor instanceof StandardVisitor) {
                        StandardVisitor standard = (StandardVisitor) visitor;
                        details.append("Eligible for Discount Upgrade: ").append(standard.isEligibleForDiscountUpgrade()).append("\n");
                        details.append("Discount Percent: ").append(standard.getDiscountPercent() * 100).append("%\n");
                    } else if (visitor instanceof EliteVisitor) {
                        EliteVisitor elite = (EliteVisitor) visitor;
                        details.append("Assigned Personal Art Advisor: ").append(elite.getAssignedPersonalArtAdvisor()).append("\n");
                        details.append("Exclusive Event Access: ").append(elite.getExclusiveEventAccess()).append("\n");
                    }

                    outputArea.setText(details.toString());
                    JOptionPane.showMessageDialog(frame, 
                        "You have received a discount of " + discount, 
                        "Discount Applied", 
                        JOptionPane.INFORMATION_MESSAGE);

                        outputArea.append("Discount applied successfully for Visitor ID: " + visitorId +  "\n");
                        outputArea.append("Artwork Name: " + visitor.getArtworkName() + "\n");
                        outputArea.append("Discount Amount: " + discount + "\n");
                        outputArea.append("New Final Price: " + visitor.getFinalPrice() + "\n");

                } catch (Exception ex) {
                    outputArea.setText("Error calculating discount: " + ex.getMessage());
                    JOptionPane.showMessageDialog(frame, 
                        "Error calculating discount: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        /**
 * Calculates and displays reward points for the specified visitor ID.
 * @param e Action event triggered by button click
 */
rewardButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String idString = visitoridField.getText().trim();
        if (idString.isEmpty()) {
            outputArea.setText("Error: Please enter a Visitor ID.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a Visitor ID.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int visitorId = Integer.parseInt(idString);
            if (visitorList.isEmpty()) {
                outputArea.setText("Error: No visitors registered. Please add a visitor first.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: No visitors registered. Please add a visitor first.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean visitorFound = false;
            for (ArtGalleryVisitor visitor : visitorList) {
                if (visitor.getVisitorId() == visitorId) {
                    if (!visitor.isBought() || visitor.getArtworkName() == null) {
                        outputArea.setText("Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double rewardPoints = visitor.calculateRewardPoint();
                    visitorFound = true;
                    outputArea.setText("");
                    outputArea.append("Reward Points Calculated:\n");
                    outputArea.append("Visitor ID: " + visitorId + "\n");
                    outputArea.append("Visitor Name: " + visitor.getFullName() + "\n");
                    outputArea.append("Ticket Type: " + visitor.getTicketType() + "\n");
                    outputArea.append("Reward Points: " + rewardPoints + "\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Reward Points calculated for Visitor ID: " + visitorId + ": " + rewardPoints, 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!visitorFound) {
                outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: Visitor ID " + visitorId + " not found.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Please enter a valid Visitor ID (numeric).\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a valid Visitor ID (numeric).", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
});


/**
 * Checks if the specified visitor is eligible for a discount upgrade (StandardVisitor only).
 * @param e Action event triggered by button click
 */
checkupgradeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String idString = visitoridField.getText().trim();
        if (idString.isEmpty()) {
            outputArea.setText("Error: Please enter a Visitor ID.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a Visitor ID.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int visitorId = Integer.parseInt(idString);
            if (visitorList.isEmpty()) {
                outputArea.setText("Error: No visitors registered. Please add a visitor first.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: No visitors registered. Please add a visitor first.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean visitorFound = false;
            for (ArtGalleryVisitor visitor : visitorList) {
                if (visitor.getVisitorId() == visitorId) {
                    visitorFound = true;
                    if (!(visitor instanceof StandardVisitor)) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " is not a Standard Visitor.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " is not a Standard Visitor.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    StandardVisitor standardVisitor = (StandardVisitor) visitor;
                    boolean isEligible = standardVisitor.checkDiscountUpgrade();
                    outputArea.setText("");
                    outputArea.append("Discount Upgrade Check:\n");
                    outputArea.append("Visitor ID: " + visitorId + "\n");
                    outputArea.append("Visitor Name: " + standardVisitor.getFullName() + "\n");
                    outputArea.append("Visitor Type: Standard\n");
                    outputArea.append("Visit Count: " + standardVisitor.getVisitCount() + "\n");
                    outputArea.append("Visit Limit: " + standardVisitor.getVisitLimit() + "\n");
                    outputArea.append("Eligible for Discount Upgrade: " + isEligible + "\n");
                    outputArea.append("Discount Percent: " + (standardVisitor.getDiscountPercent() * 100) + "%\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Visitor ID: " + visitorId + " is " + (isEligible ? "eligible" : "not eligible") + 
                        " for discount upgrade. Current discount: " + (standardVisitor.getDiscountPercent() * 100) + "%", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!visitorFound) {
                outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: Visitor ID " + visitorId + " not found.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Please enter a valid Visitor ID (numeric).\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a valid Visitor ID (numeric).", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
});


/**
 * Assigns a personal art advisor to the specified visitor (EliteVisitor only).
 * @param e Action event triggered by button click
 */
AssignpersonaladviserButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String idString = visitoridField.getText().trim();
        if (idString.isEmpty()) {
            outputArea.setText("Error: Please enter a Visitor ID.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a Visitor ID.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int visitorId = Integer.parseInt(idString);
            if (visitorList.isEmpty()) {
                outputArea.setText("Error: No visitors registered. Please add a visitor first.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: No visitors registered. Please add a visitor first.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean visitorFound = false;
            for (ArtGalleryVisitor visitor : visitorList) {
                if (visitor.getVisitorId() == visitorId) {
                    visitorFound = true;
                    if (!(visitor instanceof EliteVisitor)) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " is not an Elite Visitor.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " is not an Elite Visitor.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    EliteVisitor eliteVisitor = (EliteVisitor) visitor;
                    boolean advisorAssigned = eliteVisitor.assignPersonalArtAdvisor();
                    outputArea.setText("");
                    outputArea.append("Personal Art Advisor Assignment:\n");
                    outputArea.append("Visitor ID: " + visitorId + "\n");
                    outputArea.append("Visitor Name: " + eliteVisitor.getFullName() + "\n");
                    outputArea.append("Visitor Type: Elite\n");
                    outputArea.append("Reward Points: " + eliteVisitor.getRewardPoints() + "\n");
                    outputArea.append("Personal Art Advisor Assigned: " + advisorAssigned + "\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Visitor ID: " + visitorId + " - Personal Art Advisor " + 
                        (advisorAssigned ? "successfully assigned." : "not assigned. Insufficient reward points (> 5000 required)."), 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!visitorFound) {
                outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: Visitor ID " + visitorId + " not found.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Please enter a valid Visitor ID (numeric).\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Please enter a valid Visitor ID (numeric).", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
});


/**
 * Saves all visitor details to a text file named VisitorDetails.txt.
 * @param e Action event triggered by button click
 */
saveButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (visitorList.isEmpty()) {
            outputArea.setText("Error: No visitors registered to save.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: No visitors registered to save.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("VisitorDetails.txt"))) {
            // Write header
            writer.println(String.format("%-5s %-20s %-10s %-15s %-15s %-10s %-10s %-10s %-15s %-10s %-15s %-20s %-15s %-15s %-10s %-10s %-20s %-15s",
                "ID", "Name", "Gender", "Contact", "Reg. Date", "Ticket", "Price", "Visits", "Reward Pts", "Cancels", "Refund Amt", 
                "Artwork Name", "Art Price", "Discount", "Final Price", "Active", "Bought", "Cancel Reason", "Visitor Type"));
            writer.println("-".repeat(200)); // Separator line

            // Write visitor details
            for (ArtGalleryVisitor visitor : visitorList) {
                String artworkName = visitor.getArtworkName() != null ? visitor.getArtworkName() : "None";
                String cancellationReason = visitor.getCancellationReason() != null ? visitor.getCancellationReason() : "None"; 
                String visitorTypeDetails = "";
                if (visitor instanceof StandardVisitor) {
                    StandardVisitor stdVisitor = (StandardVisitor) visitor;
                    visitorTypeDetails = String.format("Standard, Eligible for Upgrade: %s, Discount Percent: %.0f%%", 
                        stdVisitor.isEligibleForDiscountUpgrade(), stdVisitor.getDiscountPercent() * 100);
                } else if (visitor instanceof EliteVisitor) {
                    EliteVisitor eliteVisitor = (EliteVisitor) visitor;
                    visitorTypeDetails = String.format("Elite, Advisor Assigned: %s, Event Access: %s", 
                        eliteVisitor.getAssignedPersonalArtAdvisor(), eliteVisitor.getExclusiveEventAccess());
                }
                writer.println(String.format("%-5d %-20s %-10s %-15s %-15s %-10s %-10.2f %-10d %-15.2f %-10d %-15.2f %-20s %-15.2f %-15.2f %-10.2f %-10s %-10s %-20s %-15s",
                    visitor.getVisitorId(), visitor.getFullName(), visitor.getgender(), visitor.getContactNumber(),
                    visitor.getRegistrationDate(), visitor.getTicketType(), visitor.getTicketCost(), visitor.getVisitCount(),
                    visitor.getRewardPoints(), visitor.getCancelCount(), visitor.getRefundableAmount(), artworkName,
                    visitor.getArtworkPrice(), visitor.getDiscountAmount(), visitor.getFinalPrice(), 
                    visitor.isActive(), visitor.isBought(), cancellationReason, visitorTypeDetails));
            }
            outputArea.setText("Visitor details successfully saved to VisitorDetails.txt.\n");
            JOptionPane.showMessageDialog(frame, 
                "Visitor details successfully saved to VisitorDetails.txt.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            outputArea.setText("Error: Failed to save visitor details to file: " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Failed to save visitor details to file: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
});

/**
 * Reads visitor details from VisitorDetails.txt and displays them in a new frame with a table.
 * @param e Action event triggered by button click
 */
ReadButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File("VisitorDetails.txt");
        if (!file.exists() || !file.canRead()) {
            outputArea.setText("Error: VisitorDetails.txt not found or cannot be read.\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: VisitorDetails.txt not found or cannot be read.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<String[]> visitorData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Skip header and separator lines
            reader.readLine(); // Header
            reader.readLine(); // Separator
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line by whitespace, accounting for multi-word fields like Name, Artwork Name, Cancel Reason, and Visitor Type
                String[] parts = parseLine(line);
                if (parts == null || parts.length < 18) {
                    outputArea.setText("Error: Invalid data format in VisitorDetails.txt.\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Invalid data format in VisitorDetails.txt.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                visitorData.add(parts);
            }

            if (visitorData.isEmpty()) {
                outputArea.setText("Error: No visitor data found in VisitorDetails.txt.\n");
                JOptionPane.showMessageDialog(frame, 
                    "Error: No visitor data found in VisitorDetails.txt.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Define table columns
            String[] columnNames = {
                "ID", "Name", "Gender", "Contact", "Reg. Date", "Ticket", "Price", "Visits",
                "Reward Pts", "Cancels", "Refund Amt", "Artwork Name", "Art Price", "Discount",
                "Final Price", "Active", "Bought", "Cancel Reason", "Visitor Type"
            };
            Object[][] tableData = new Object[visitorData.size()][columnNames.length];
            for (int i = 0; i < visitorData.size(); i++) {
                String[] data = visitorData.get(i);
                tableData[i][0] = data[0]; // ID
                tableData[i][1] = data[1]; // Name
                tableData[i][2] = data[2]; // Gender
                tableData[i][3] = data[3]; // Contact
                tableData[i][4] = data[4]; // Reg. Date
                tableData[i][5] = data[5]; // Ticket Type
                tableData[i][6] = data[6]; // Price
                tableData[i][7] = data[7]; // Visits
                tableData[i][8] = data[8]; // Reward Points
                tableData[i][9] = data[9]; // Cancels
                tableData[i][10] = data[10]; // Refund Amount
                tableData[i][11] = data[11]; // Artwork Name
                tableData[i][12] = data[12]; // Art Price
                tableData[i][13] = data[13]; // Discount
                tableData[i][14] = data[14]; // Final Price
                tableData[i][15] = data[15]; // Active
                tableData[i][16] = data[16]; // Bought
                tableData[i][17] = data[17]; // Cancel Reason
                tableData[i][18] = data[18]; // Visitor Type Details
            }

            // Create new frame for displaying data
            JFrame displayFrame = new JFrame("Visitor Details from File");
            displayFrame.setSize(1200, 400);
            displayFrame.setLocationRelativeTo(frame);
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Create table
            JTable table = new JTable(tableData, columnNames);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Allow horizontal scrolling
            table.setFillsViewportHeight(true);
            table.setFont(new Font("Arial", Font.PLAIN, 12));
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

            // Adjust column widths
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setPreferredWidth(100);
            }
            table.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
            table.getColumnModel().getColumn(11).setPreferredWidth(150); // Artwork Name
            table.getColumnModel().getColumn(17).setPreferredWidth(150); // Cancel Reason
            table.getColumnModel().getColumn(18).setPreferredWidth(200); // Visitor Type

            // Add table to scroll pane
            JScrollPane scrollPane = new JScrollPane(table);
            displayFrame.add(scrollPane, BorderLayout.CENTER);

            // Show frame
            displayFrame.setVisible(true);

            outputArea.setText("Visitor details successfully loaded from VisitorDetails.txt.\n");
            JOptionPane.showMessageDialog(frame, 
                "Visitor details successfully loaded from VisitorDetails.txt and displayed in a new window.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            outputArea.setText("Error: Failed to read VisitorDetails.txt: " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(frame, 
                "Error: Failed to read VisitorDetails.txt: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper method to parse a line from VisitorDetails.txt, handling multi-word fields.
     * @param line The line to parse
     * @return Array of parsed fields, or null if invalid
     */
    private String[] parseLine(String line) {
        // Trim leading/trailing whitespace
        line = line.trim();
        if (line.isEmpty()) return null;

        // Define expected field widths based on String.format in saveButton
        int[] widths = {5, 20, 10, 15, 15, 10, 10, 10, 15, 10, 15, 20, 15, 15, 10, 10, 20};
        List<String> fields = new ArrayList<>();
        int currentIndex = 0;

        // Parse fixed-width fields
        for (int i = 0; i < widths.length; i++) {
            if (currentIndex >= line.length()) return null;
            int endIndex = Math.min(currentIndex + widths[i], line.length());
            String field = line.substring(currentIndex, endIndex).trim();
            fields.add(field);
            currentIndex = endIndex;
            // Skip extra spaces between fields
            while (currentIndex < line.length() && line.charAt(currentIndex) == ' ') {
                currentIndex++;
            }
        }

        // Handle Cancel Reason (multi-word, width 20)
        if (currentIndex >= line.length()) return null;
        int cancelReasonEnd = Math.min(currentIndex + 20, line.length());
        String cancelReason = line.substring(currentIndex, cancelReasonEnd).trim();
        fields.add(cancelReason);
        currentIndex = cancelReasonEnd;
        while (currentIndex < line.length() && line.charAt(currentIndex) == ' ') {
            currentIndex++;
        }

        // Handle Visitor Type Details (remaining text)
        if (currentIndex < line.length()) {
            String visitorTypeDetails = line.substring(currentIndex).trim();
            fields.add(visitorTypeDetails);
        } else {
            fields.add("");
        }

        return fields.toArray(new String[0]);
    }
});


        
    



    



   


    










// Output panel
    outputPanel = new JPanel();
    outputPanel.setLayout(new BorderLayout());
    outputPanel.setBorder(BorderFactory.createTitledBorder("Display "));
    outputArea = new JTextArea(20, 50);
    outputArea.setEditable(false); 

    //css deko 
    outputArea.setBackground(Color.WHITE);
    outputArea.setForeground(Color.BLACK);
    outputArea.setFont(new Font("Arial", Font.PLAIN, 17));
   
 
    JScrollPane scrollPane = new JScrollPane(outputArea);
    outputPanel.add(scrollPane, BorderLayout.CENTER);
    outputPanel.setPreferredSize(new Dimension(640, 640));
    outputPanel.setBackground(Color.gray);

   


     // mainPanel vitra aru panel lai arrange garya
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    mainPanel.add(formPanel, BorderLayout.WEST);
    //  formPanel.setPreferredSize(new Dimension(540, 640));
    formPanel.setBackground(Color.lightGray);
    

    // formPanel.add(aarkoformPanel, BorderLayout.SOUTH);
 

    mainPanel.add(outputPanel, BorderLayout.EAST);














    







  



   
 frame.setVisible(true);
}

public static void main(String[] args) {
        // Call constructor to execute above code
        new ArtGalleryGUI();
    }
}


