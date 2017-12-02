package Service.Representation;

public interface Link {

	void setUrl(String url);
	String getUrl();
	void setAction(String action);
	String getAction();
	String getRel();
	String getType();
	void setRel(String rel);
	void setType(String type);
}
