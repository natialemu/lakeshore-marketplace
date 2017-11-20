package Service.Representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class LinkImpl implements Link {
	private String action;
	private String url;
	
	public LinkImpl() {}
	
	public LinkImpl(String action, String url) {
		this.action = action;
		this.url = url;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
