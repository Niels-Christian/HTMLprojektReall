import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonServlet {
    public static void main(String[]args) throws IOException {
        Patient pt = new Patient();
        pt.setCPR("250981");
        pt.setFornavn("Endeavour");
        ObjectMapper jsonMapper = new ObjectMapper();
        String s = jsonMapper.writeValueAsString(pt);
        System.out.println(s);

        s = s.replace("Endeavour", "Robert");
        System.out.println(s);

        Patient readPt = jsonMapper.readValue(s, Patient.class);
        System.out.println(("CPR: " + readPt.getCPR() + ", fornavn: " + readPt.getFornavn()));

        String s2 = "<Patient><cpr>241200</cpr><fornavn>Jesus</fornavn></Patient>";
        Patient jesPt = jsonMapper.readValue(s2, Patient.class);
        System.out.println(("CPR: " + jesPt.getCPR() + ", fornavn: " + jesPt.getFornavn()));
    }
}


