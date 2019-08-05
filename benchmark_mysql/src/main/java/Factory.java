public class Factory {
    private int number;
    private int distributorNumber;

    public final String REGEX = "distributor-%d-factory-%d";

    public Factory(int distributorNumber) {
        this.distributorNumber = distributorNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getId() {
        return String.format(REGEX, distributorNumber, number);
    }

    public int getDistributorNumber() {
        return distributorNumber;
    }
}
