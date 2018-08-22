//package com.nab.controller;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.nab.entities.Employee;
//import com.nab.service.EmployeeService;
//
//@Controller
//public class EmployeeController {
//	@Autowired
//	EmployeeService employeeService;
//
//	@RequestMapping(value = { "/", "employee/homepage" })
//	public ModelAndView homepage() {
//		ModelAndView mav = new ModelAndView("homepage");
//		mav.addObject("message", "Welcome");
//		return mav;
//	}
//
//	@RequestMapping(value = "/employee/view-list")
//	public ModelAndView listEmployee() {
//		ModelAndView mal = new ModelAndView("list-employee");
//		mal.addObject("ListEmployee", employeeService.getAll());
//		return mal;
//	}
//
//	@RequestMapping(value = "employee/viewAvatar/{id}")
//	public ModelAndView viewAvatar(@PathVariable int id) {
//		ModelAndView mav = new ModelAndView("viewAvatar");
//		Employee employee = employeeService.getByID(id);
//		mav.addObject("avatar", employee.getAvatar());
//		mav.addObject("name", employee.getName());
//		return mav;
//	}
//
//	
//
//	@RequestMapping(value = "employee/delete/{id}")
//	public ModelAndView doDeleteEmployee(@PathVariable int id) {
//		ModelAndView mav = new ModelAndView("list-employee");
//		employeeService.delete(id);
//		return mav;
//	}
//
//	@RequestMapping(value = "employee/add-avatar")
//	public ModelAndView addAvatar() {
//		ModelAndView mav = new ModelAndView("add-avatar");
//		return mav;
//	}
//
//	@RequestMapping(value = "employee/addAvatar")
//	public ModelAndView doAddAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
//		ModelAndView mav = new ModelAndView("add-done");
//		String dir = uploadImage1(file);
//		employeeService.updateAvatar(id, dir);
//		return mav;
//	}
//
//	@RequestMapping(value = "employee/search-employee")
//	public ModelAndView searchEmployee() {
//		ModelAndView mav = new ModelAndView("search-employee");
//		mav.addObject("ListEmployee", employeeService.getAll());
//		return mav;
//	}
//
//	// static private String uploadImage(MultipartFile file) {
//	// String directory;
//	// if (!file.isEmpty()) {
//	// try {
//	// String name = String.valueOf(new Date().getTime() + ".jpg");
//	// byte[] bytes = file.getBytes();
//	// // Create directory to store this file
//	// File dir = new File("C:" + File.separator + "images");
//	// if (!dir.exists())
//	// dir.mkdirs();
//	// // Create the file on server
//	// File serverFile = new File(dir.getPath() + File.separator + name);
//	// directory=serverFile.getAbsolutePath();
//	// BufferedOutputStream stream = new BufferedOutputStream(new
//	// FileOutputStream(serverFile));
//	// stream.write(bytes);
//	// stream.close();
//	// return directory;
//	//
//	// } catch (IOException e) {
//	// e.printStackTrace();
//	// }
//	// } else {
//	// System.out.println("File is Empty");
//	// }
//	// return null;
//	// }
//	static private String uploadImage1(MultipartFile file) {
//		String image;
//		if (!file.isEmpty()) {
//			try {
//				byte imageData[] = file.getBytes();
//				image = Base64.getEncoder().encodeToString(imageData);
//				return image;
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("File is Empty");
//		}
//		return null;		
//	}
//}
