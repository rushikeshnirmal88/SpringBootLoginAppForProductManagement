package com.login.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.Product;
import com.login.entity.User;
import com.login.service.ProdcutService;
import com.login.service.RegistrationService;


@RestController
@CrossOrigin("http://localhost:4200")

//@RequestMapping("/app/v1")

public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private ProdcutService productService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailid();
		if(tempEmailId!=null && !"".equals(tempEmailId))
		{
			User u=registrationService.fetchUserByEmailId(tempEmailId);
			
			if(u!=null)
			{
				throw new Exception("User with "+tempEmailId+" is already present" );
			}
		}
		
		User u=null;
		u=registrationService.registerUser(user);
		return u;
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailid=user.getEmailid();
		String tempPassword=user.getPassword();
		User u=null;
		if(tempEmailid!=null && tempPassword!=null)
		{
			u=registrationService.fetchUserByEmailIdAndPassword(tempEmailid, tempPassword);
		}
		if(u==null)
		{
			throw new Exception("Bad Credentials");
		}
		return u;
	}
	
	
	
	//@RequestMapping(path = "/getprodcutlist",method = RequestMethod.GET)
	@GetMapping("/getproductlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> getAllProduct()
	{
		List<Product> products=new ArrayList<>();
		//logic to get all products
		products=productService.getAllProduct();
		return products;
	}
	@PostMapping("/addProduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	@GetMapping("/getProduct/{id}")
	public Product getProdcutById(@PathVariable int id)
	{
		return productService.findProduct(id).get();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String DeleteProdcutById(@PathVariable int id)
	{
		return productService.deleteProductById(id);
	}
}
