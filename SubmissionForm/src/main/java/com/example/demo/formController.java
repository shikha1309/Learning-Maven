package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




// Registration and ViewDetails are the view methods which return view

@Controller
public class formController {
// creating and connecting that repository	

	@Autowired
	CustomersRepo repo;

	@RequestMapping("/")
	public String details() {
		return "Index";
	}

//@GetMapping("index") 
//public String  Registration() 
//    { 
//	  return "Index";
//	}

// after submit button saving the details
	@RequestMapping("/details")
	public String mydetails(Customers customers) {
		
		repo.save(customers);
		return "Index";
	}

	@RequestMapping("/getdetails")
	public String getDetails() {

		return "secondPage";
	}

//@PostMapping ("/details")
//public String  viewDetails(
//		@RequestParam ("uid") String uid,
//		@RequestParam ("uname") String uname,
//		@RequestParam ("uemail") String uemail,

//		ModelMap modelMap)  // creating modelMap object
//    { 
//	  modelMap.put("uid", uid);
//	  modelMap.put("uname", uname);
//	  modelMap.put("email", uemail);

//	  return "secondPage";
//	  }
}

