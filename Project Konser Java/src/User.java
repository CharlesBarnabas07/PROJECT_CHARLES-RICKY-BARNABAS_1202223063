public class User {

    // TODO: Create Private Attribute of User (Name and Phone Number) then Create Setter method for each attribute

    private String name;
    private String phoneNumber;

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // TODO: Create Method to Register User and Display User's Name and Phone Number and success message
    public void RegisterDisplayUser() {
        System.out.println("Register berhasil");
        System.out.println("Nama: " + name);
        System.out.println("No Handphone: " + phoneNumber);
    }
}
