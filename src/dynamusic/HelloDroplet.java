package dynamusic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

public class HelloDroplet extends DynamoServlet {

	private String name;
	private int age;

	public HelloDroplet() {
		System.out.println("InTestDroplet Constructor");
	}

	@Override
	public void service(DynamoHttpServletRequest req,
			DynamoHttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream out = res.getOutputStream();
		out.println("Hello World! My name is " + name);
	}

	public int getAge() {
		return age;
	}

	public void setNamAge(int age) {
		System.out.println("setting name attribute to " + age);
		this.age = age;
	}

}
