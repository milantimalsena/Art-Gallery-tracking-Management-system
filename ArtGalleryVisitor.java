/**
 * This is a parent class which is an Abstract class representing a visitor to an art gallery.
 * Manages visitor details, ticket information, purchases, cancellations, and rewards.
 * @author Milan Timalsena
 */
abstract class ArtGalleryVisitor {
   
    protected int visitorId;
    protected String fullName;
    protected String gender;
    protected String contactNumber;
    protected String registrationDate;
    protected double ticketCost;
    protected String ticketType;
    protected int visitCount;
    protected double rewardPoints;
    protected final int cancelLimit = 3;
    protected int cancelCount;
    protected double refundableAmount;
    protected boolean isActive;
    protected boolean isBought;
    protected int buyCount;
    protected double finalPrice;
    protected double discountAmount;
    protected String artworkName;
    protected double artworkPrice;
    protected String cancellationReason;

    /**
     * Constructor to initialize a visitor with full details.
     * @param  Visitor ID
     * @param  Full name
     * @param  Gender
     * @param  Contact number
     * @param  Registration date
     * @param Ticket cost
     * @param  Ticket type
     * @param  Visit count
     * @param  Reward points
     * @param  Cancel count
     */
    public ArtGalleryVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, double ticketPrice, String ticketType, int visitCount, double rewardPoints, int cancelCount) {
        this.visitorId = visitorId;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
        this.ticketCost = ticketCost;
        this.ticketType = ticketType;
        this.visitCount = visitCount;
        this.rewardPoints = rewardPoints;
        this.cancelCount = cancelCount;
        this.refundableAmount = 0.0;
        this.isActive = false;
        this.isBought = false;
        this.buyCount = 0;
        this.finalPrice = 0.0;
        this.artworkName = "";
        this.artworkPrice = 0.0;
        this.cancellationReason = null;
    }

    /**
     * Constructor to initialize a visitor with basic details.
     * @param  Visitor ID
     * @param  Full name
     * @param  Gender
     * @param Contact number
     * @param  Registration date
     * @param  Ticket cost
     * @param  Ticket type
     */
    public ArtGalleryVisitor(int var1, String var2, String var3, String var4, String var5, double var6, String var8) {
    }

    /**
     * Gets the visitor's unique ID.
     * @return Visitor ID
     */
    public int getVisitorId() {
        return this.visitorId;
    }

    /**
     * Gets the visitor's full name.
     * @return Full name
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Gets the visitor's gender.
     * @return Gender
     */
    public String getgender() {
        return this.gender;
    }

    /**
     * Gets the visitor's contact number.
     * @return Contact number
     */
    public String getContactNumber() {
        return this.contactNumber;
    }

    /**
     * Gets the visitor's registration date.
     * @return Registration date
     */
    public String getRegistrationDate() {
        return this.registrationDate;
    }

    /**
     * Gets the cost of the ticket.
     * @return Ticket cost
     */
    public double getTicketCost() {
        return this.ticketCost;
    }

    /**
     * Gets the type of ticket.
     * @return Ticket type
     */
    public String getTicketType() {
        return this.ticketType;
    }

    /**
     * Gets the number of visits made by the visitor.
     * @return Visit count
     */
    public int getVisitCount() {
        return this.visitCount;
    }

    /**
     * Gets the visitor's reward points.
     * @return Reward points
     */
    public double getRewardPoints() {
        return this.rewardPoints;
    }

    /**
     * Gets the number of cancellations made by the visitor.
     * @return Cancel count
     */
    public int getCancelCount() {
        return this.cancelCount;
    }

    /**
     * Gets the refundable amount for the visitor.
     * @return Refundable amount
     */
    public double getRefundableAmount() {
        return this.refundableAmount;
    }

    /**
     * Checks if the visitor is active.
     * @return True if active, false otherwise
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Checks if the visitor has made a purchase.
     * @return True if bought, false otherwise
     */
    public boolean isBought() {
        return this.isBought;
    }

    /**
     * Gets the number of items purchased by the visitor.
     * @return Buy count
     */
    public int getBuyCount() {
        return this.buyCount;
    }

    /**
     * Gets the final price after discounts.
     * @return Final price
     */
    public double getFinalPrice() {
        return this.finalPrice;
    }

    /**
     * Gets the discount amount applied.
     * @return Discount amount
     */
    public double getDiscountAmount() {
        return this.discountAmount;
    }

    /**
     * Gets the name of the purchased artwork.
     * @return Artwork name
     */
    public String getArtworkName() {
        return this.artworkName;
    }

    /**
     * Gets the price of the purchased artwork.
     * @return Artwork price
     */
    public double getArtworkPrice() {
        return this.artworkPrice;
    }

    /**
     * Sets the visitor's full name.
     * @param var1 New full name
     */
    public void setFullName(String var1) {
        this.fullName = var1;
    }

    /**
     * Sets the visitor's gender.
     * @param var1 New gender
     */
    public void setGender(String var1) {
        this.gender = var1;
    }

    /**
     * Sets the visitor's contact number.
     * @param var1 New contact number
     */
    public void setContactNumber(String var1) {
        this.contactNumber = var1;
    }

    /**
     * Logs a visit by the visitor, incrementing visit count and setting active status.
     */
    public void logVisit() {
        ++this.visitCount;
        this.isActive = true;
    }
     public String getCancellationReason() {
        return this.cancellationReason;
    }
    

    /**
     * Abstract method to handle the purchase of a product.
     * @param Artwork name
     * @param  Artwork price
     * @return Purchase confirmation message
     */
    public abstract String buyProduct(String artworkName, double artworkPrice);
    

    /**
     * Abstract method to calculate the discount for a purchase.
     * @return Discount amount
     */
    public abstract double calculateDiscount();

    /**
     * Abstract method to calculate reward points for a visitor.
     * @return Reward points earned
     */
    public abstract double calculateRewardPoint();

    /**
     * Abstract method to cancel a purchased product.
     * @param  Artwork name
     * @param  Cancellation reason
     * @return Cancellation confirmation message
     */
    public abstract String cancelProduct(String artworkName, String cancellationReason);

    /**
     * Abstract method to generate a bill for the visitor's purchases.
     */
    public abstract void generateBill();

    /**
     * Displays all details of the visitor, including ticket, purchase, and cancellation information.
     */
    public void display() {
        System.out.println("Visitor Details:");
        System.out.println("---------------");
        System.out.println("Visitor ID: " + this.visitorId);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Gender: " + this.gender);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Registration Date: " + this.registrationDate);
        System.out.println("Ticket Type: " + this.ticketType);
        System.out.println("Ticket Cost: " + this.ticketCost);
        System.out.println("Visit Count: " + this.visitCount);
        System.out.println("Reward Points: " + this.rewardPoints);
        System.out.println("Cancel Limit: 3");
        System.out.println("Cancel Count: " + this.cancelCount);
        String var10001 = this.cancellationReason != null ? this.cancellationReason : "None";
        System.out.println("Cancellation Reason: " + var10001);
        System.out.println("Refundable Amount: " + this.refundableAmount);
        System.out.println("Is Active: " + this.isActive);
        System.out.println("Is Bought: " + this.isBought);
        System.out.println("Buy Count: " + this.buyCount);
        System.out.println("Final Price: " + this.finalPrice);
        System.out.println("Discount Amount: " + this.discountAmount);
        var10001 = this.artworkName != null ? this.artworkName : "None";
        System.out.println("Artwork Name: " + var10001);
        System.out.println("Artwork Price: " + this.artworkPrice);
        System.out.println("---------------");
    }
}