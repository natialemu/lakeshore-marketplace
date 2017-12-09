package Service.Representation;

import java.util.List;

public interface AbstractRepresentationInterface {
	void setLinks(LinkImpl...links);
	List<LinkImpl> getLinks();

}
