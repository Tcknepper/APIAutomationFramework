package pojoClasses;

public class CreateRepoPOJO {

	//class for creating a POJO to be used with objectmapper to generate a POJO payload
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
