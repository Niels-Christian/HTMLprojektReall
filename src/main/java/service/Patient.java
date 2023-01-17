package service;
public class Patient {

    String CPR;
    String Name;
    String ECG;
    String Note;

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getECG() {
        return ECG;
    }

    public void setECG(String ECG) {
        this.ECG = ECG;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "CPR='" + CPR + '\'' +
                ", Name='" + Name + '\'' +
                ", ECG='" + ECG + '\'' +
                ", Note='" + Note + '\'' +
                '}';
    }
}

