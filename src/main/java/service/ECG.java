package service;

import model.ECGSample;
import java.util.ArrayList;
import java.util.List;

public class ECG {
    List<ECGSample> samples = new ArrayList<>();

    public List<ECGSample> getSamples() {
        return samples;
    }

    public void setSamples(List<ECGSample> samples) {
        this.samples = samples;
    }
}
