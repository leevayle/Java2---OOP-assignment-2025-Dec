public class PartTimeLecturer implements Payable {
    private int hours;
    private double rate;

    public PartTimeLecturer(int hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePayment() {
        return hours * rate;
    }
}