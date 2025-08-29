# Art-Gallery-Management-tracking-system

## Overview
** Art-Gallery-Management-tracking-system** is a Java-based desktop application designed to streamline visitor interactions in an art gallery.  
With a user-friendly GUI, it manages visitor details, ticket purchases, artwork transactions, reward points, and cancellations, while ensuring robust file I/O for record-keeping.  

The system supports two visitor types—**Standard** and **Elite**—with tailored features such as discount upgrades and personal art advisor assignments.

---

## Features

- **Visitor Management**  
  Add and manage Standard and Elite visitors with details like ID, name, gender, contact, and registration date.

- **Ticket and Purchase Tracking**  
  Log visits, record artwork purchases, and calculate discounts (10–15% for Standard, 40% for Elite).

- **Reward Points**  
  Earn points on purchases (5 points/₹ for Standard, 10 points/₹ for Elite).

- **Cancellations**  
  Handle artwork cancellations with refund calculations and reasons (maximum of 3 cancellations per visitor).

- **Special Features**
  - *Standard Visitors*: Eligible for discount upgrades (10% → 15%) after 5 visits.  
  - *Elite Visitors*: Assign personal art advisors for those with 5,000+ reward points and grant exclusive event access.

- **File Operations**  
  Save visitor details to `VisitorDetails.txt` and display them in a scrollable `JTable`.

- **Error Handling**  
  Comprehensive validation with clear error messages for invalid inputs, missing visitors, or file I/O issues.

---

## Technical Details

- **Language:** Java  
- **GUI Framework:** Swing (`JFrame`, `JTable`, `JTextField`, `JTextArea`, `JButton`, `JOptionPane`)  
- **Architecture:** Object-Oriented with an abstract parent class and two specialized subclasses.  
- **File I/O:**  
  - Save: `PrintWriter`  
  - Read: `BufferedReader` (fixed-width text format)  

### Key Components
- **ArtGalleryVisitor** – Abstract base class with common attributes and methods.  
- **StandardVisitor** – Implements discount upgrades for standard visitors.  
- **EliteVisitor** – Handles personal art advisors and event access for elite visitors.  
- **ArtGalleryGUI** – Main GUI with interactive buttons for all operations.  

---

## Usage

1. **Run the Application**  
   Launch `ArtGalleryGUI` to open the main interface.

2. **Add Visitors**  
   Enter visitor details (ID, name, gender, contact, etc.) and specify Standard or Elite type.

3. **Manage Interactions**  
   - Log visits to activate visitors  
   - Purchase artworks (discounts & reward points auto-calculated)  
   - Cancel purchases with reasons (limit: 3)  
   - Check discount upgrades (Standard) or assign advisors (Elite)

4. **File Operations**  
   - Save visitor details to `VisitorDetails.txt`  
   - Display saved data in a scrollable JTable in a new window  

5. **Error Feedback**  
   Validation issues appear in the output area or via pop-up dialogs.

---

## Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/ArtTrack.git

# Navigate to project folder
cd ArtTrack

# Compile
javac *.java

# Run
java ArtGalleryGUI
