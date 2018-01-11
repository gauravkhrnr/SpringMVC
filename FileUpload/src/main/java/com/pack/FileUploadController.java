package com.pack;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * Description FileUploadController handles request for upload file
 * @author gaurav
 *
 */
@Controller
public class FileUploadController {

	/* Directory Name */
	private static final String UPLOAD_DIRECTORY ="/images";
	 
	
	/**
	 * Description show the fileUpload page
	 * @return ModelAndView to be tested
	 */
	@RequestMapping("/showform")
	public ModelAndView showForm() {
		
		return new ModelAndView("upload");
	}
	
	
	/**
	 * 
	 * Description Store Image in specified path
	 * @param file
	 * @param session
	 * @return ModelAndView to be tested
	 * @throws IOException 
	 * @throws Exception FileNotFoundException SecurityException
	 */
	@RequestMapping(value="/savefile",method=RequestMethod.POST)  
    public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,HttpSession session) throws IOException{ 
		
	  BufferedOutputStream stream = null;
	  ServletContext context = session.getServletContext();  
	  String path = context.getRealPath(UPLOAD_DIRECTORY);  
	  String filename = file.getOriginalFilename();
	  
	  /* store file path */ 
	  String filePath = path+File.separator+filename;
	  
	  
	  try {
		
		   File theDir = new File(path);
		    /* if the directory does not exist, create it */
		    if (!theDir.exists()) {
		    	
		   	     try {
			         theDir.mkdir();
		
			     } 
			     catch(SecurityException se){
			         //handle it
			     }        
			   
		    }
		    
		    //System.out.println(path+File.separator+filename);        
		  
		    byte[] bytes = file.getBytes(); 
		    
		    /* write file in specified path */
		    try {
		    
		    	stream =new BufferedOutputStream(new FileOutputStream(filePath,false));  
		    	stream.write(bytes);  
		    	stream.flush();  
		    }catch(FileNotFoundException e) {
		    	
		    	e.printStackTrace();
		    }
		    
		    
	  }finally {
		  
		  try {
			
			  stream.close();
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }  
	  }
	    
	    ModelAndView modelAndView = new ModelAndView("upload");
	    modelAndView.addObject("filesuccess","File successfully saved!");
	    modelAndView.addObject("filepath",filePath);
	    
	    return modelAndView;  
    }  
}