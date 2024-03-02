package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller  // to handle the request  //also it is imp to tell that it is spring bean// usedto mark the class as the spring mvc controller
public class SayHelloController {
//	"say-hello" =>"Hello! what are you learning today?" 
	
//	when someone call the /say-hello in the browser then I return this method
//	url:http://localhost:8081/say-hello
//	spring mvc always try to find the view name by default whenever you return the strings 
//	so for explicitly telling that you want to return string(response) you want to return this as a final response , you will use @ResponseBody
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! what are you learning today?" ;
	}
//	here i make the method for the html return 
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHellohtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first Html page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body");
		sb.append("</body>");
		sb.append("</html>");
	return 	sb.toString();
	}
	
//	when you enter the "say-hello-jsp" then you will redirect to the =>sayHello.jsp
//	@ResponseBody --> if i have to redirect to the view then I have to remove this annotation
//	now i use the jsp technology that is used to make the views
	@RequestMapping("say-hello-jsp1")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
