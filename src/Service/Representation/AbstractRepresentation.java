package Service.Representation;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public abstract class AbstractRepresentation implements AbstractRepresentationInterface {
	
	@XmlElement(name="link", namespace="")
	protected List<LinkImpl> links;
	
	public List<LinkImpl> getLinks() {
		return links;
	}
	
	public void setLinks(LinkImpl...links) {
		this.links = Arrays.asList(links);
	}

}
