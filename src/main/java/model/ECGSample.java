package model;

public class    ECGSample {
    private double voltage;
    private double time;
    String cpr;

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ECGSample{" +
                "CPR='" + cpr + '\'' +
                "voltage=" + voltage +
                ", time=" + time +
                '}';
    }
}
