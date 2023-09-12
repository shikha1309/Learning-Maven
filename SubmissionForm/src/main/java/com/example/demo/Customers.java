package com.example.demo;


import org.springframework.stereotype.Component;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity 
@Table(name="newSignUp")
 
public class Customers {  
	@Id


	public int uid;
	
	

     private String uname ;
	
	
   	private String uemail;
   	
   	
   	public Customers()
    {
        
    }
    public  Customers(int uid, String uname, String uemail) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.uemail= uemail;
    }
   	
   	
   	
	
	public String getName() {
		return uname;
	}
	public void setName(String uname) {
		this.uname = uname;
	} 
	
	public int getId() {
		return uid;
	}
	public void setId(int uid) {
		this.uid = uid;
	} 
	
	
	public String getEmail() {
		return uemail;
	}
	public void setEmail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "Customers [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + "]";
	}
	

}
