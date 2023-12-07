package mypack;

public class CareerExpert {
	public String getAdvice(String qualification) {
		if (qualification.equalsIgnoreCase("be"))
			return "DAC course";
		else
			return "MS-CIT course";
	}
}
