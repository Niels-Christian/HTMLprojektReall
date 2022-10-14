import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XMLpatient
{
    public static void main(String[]args) throws IOException {
        Patient pt = new Patient();
        pt.setCPR("250981");
        pt.setFornavn("Endeavour");
        XmlMapper xmlMapper = new XmlMapper();
        //xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String s = xmlMapper.writeValueAsString(pt);
        System.out.println(s);

        s = s.replace("Endeavour", "Robert");
        System.out.println(s);

        Patient readPt = xmlMapper.readValue(s, Patient.class);
        System.out.println(("CPR: " + readPt.getCPR() + ", fornavn: " + readPt.getFornavn()));

        String s2 = "<Patient><cpr>241200</cpr><fornavn>Jesus</fornavn></Patient>";
        Patient jesPt = xmlMapper.readValue(s2, Patient.class);
        System.out.println(("CPR: " + jesPt.getCPR() + ", fornavn: " + jesPt.getFornavn()));
    }
}
