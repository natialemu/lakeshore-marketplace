package Service.Representation.Report;
public interface ReportRequest {
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Report")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReportRequestImpl implements ReportRequest{
	
    public ReportRequestImpl() {}
	
}