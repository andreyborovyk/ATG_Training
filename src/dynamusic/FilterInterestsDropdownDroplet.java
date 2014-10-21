package dynamusic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

public class FilterInterestsDropdownDroplet extends DynamoServlet {
	private List<String> dropdownList = new ArrayList<String>();

	public void setDropdownList(List<String> dropdownList) {
		this.dropdownList = dropdownList;
	}

	public List<String> getDropdownList() {
		return dropdownList;
	}

	@Override
	public void service(DynamoHttpServletRequest req,
			DynamoHttpServletResponse res) throws ServletException, IOException {
		List<String> dropdownList = new ArrayList<String>();

		dropdownList.add("all");
		dropdownList.add("even");
		dropdownList.add("odd");

		this.setDropdownList(dropdownList);

		req.setParameter("dropdownList ", dropdownList);
		req.serviceParameter("output", req, res);
	}
	
	
}
