package dynamusic;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

public class CustomDroplet extends DynamoServlet {

	@Override
	public void service(DynamoHttpServletRequest req,
			DynamoHttpServletResponse res) throws ServletException, IOException {
		req.setParameter("project", "MyProject");
		System.out.println("CustomDroplet.service() request object is : "+req);
		req.serviceParameter("output1",req, res);
		req.setParameter("module", "myModule");
		System.out.println("CustomDroplet.service() request object is : "+req);
		req.serviceParameter("output2",req, res);
	}
	
}
