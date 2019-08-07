public class Factory {
    private int number;
    private int distributorNumber;

    public final String IdFormat = "dis-%d-fac-%d";

    public final String NameFormat = "name-dis-%d-fac-%d";

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
        return String.format(IdFormat, distributorNumber, number);
    }

    public int getDistributorNumber() {
        return distributorNumber;
    }

    public String getName() {
        return String.format(NameFormat, distributorNumber, number);
    }
}
