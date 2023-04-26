package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AttendanceVO;
import com.demo.model.EmployeeVO;
import com.demo.model.LeaveVO;
import com.demo.model.LoginVO;
import com.demo.service.AttendanceService;
import com.demo.service.EmployeeService;
import com.demo.service.LoginService;
import com.demo.utils.BaseMethods;


@Controller
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	LoginService loginService;
	
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="admin/loadAttendance",method=RequestMethod.GET)
	public ModelAndView loadAttendance(){
		return new ModelAndView("admin/addAttendance","AttendanceVO",new AttendanceVO());
	}
		
	@SuppressWarnings("resource")
	@RequestMapping(value="admin/insertAttendance",method=RequestMethod.POST)
	public ModelAndView insertAttendance(HttpServletRequest request, 
			@RequestParam("AttendanceFileToUpload") MultipartFile attendancefile,
			@RequestParam String attendanceFileMonth){
		
			String path = request.getSession().getServletContext().getRealPath("/");
			String attendanceFileMonthToInsert = attendancefile.getOriginalFilename();
			String attendanceFilePath = path + "documents\\attendance\\"; 
			
			System.out.println(attendanceFileMonthToInsert);
			System.out.println(attendanceFilePath);
			
			try {
				byte barr[]=attendancefile.getBytes();  
				
		        BufferedOutputStream bout=new BufferedOutputStream(  
		                 new FileOutputStream(attendanceFilePath+"/"+attendanceFileMonthToInsert));  
		        
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();

		        
		        try
		        {
		            FileInputStream file = new FileInputStream(new File(attendanceFilePath+"/"+attendanceFileMonthToInsert));
		 
		            //Create Workbook instance holding reference to .xlsx file
		            XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		            //Get first/desired sheet from the workbook
		            XSSFSheet sheet = workbook.getSheetAt(0);
		 
		            //Iterate through each rows one by one
		            Iterator<Row> rowIterator = sheet.iterator();
		            while (rowIterator.hasNext())
		            {
		            	
		            	
		            	
		                Row row = rowIterator.next();
		                //For each row, iterate through all the columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                
		                if (row.getRowNum() >= 1 ){
		                
		                	AttendanceVO attendanceVO = new AttendanceVO(); 
			            	attendanceVO.setStatus(true);
			            	attendanceVO.setAttendanceFileMonth(attendanceFileMonth);
			            	
		                	
		                while (cellIterator.hasNext())
		                {
		                    Cell cell = cellIterator.next();
		                    
		                    //Check the cell type and format accordingly
		                     switch (cell.getColumnIndex())
		                    {
		                        case 0:
		                            System.out.print(cell.getStringCellValue()+ "\t");
		                        	attendanceVO.setEmployeeIDno(cell.getStringCellValue());
		                            break;
		                        case 1:
		                            System.out.print(cell.getNumericCellValue()+ "\t");
		                            attendanceVO.setNumberOfWorkingDays(cell.getNumericCellValue());
		                            break;
		                        case 2:
		                            System.out.print(cell.getNumericCellValue() + "\t");
		                            attendanceVO.setPresentDays(cell.getNumericCellValue());
		                            break;
		                        case 3:
		                            System.out.print(cell.getNumericCellValue() + "\t");
		                            double leaveTypeId = cell.getNumericCellValue();
		                            LeaveVO leaveVO = new LeaveVO();
		                            leaveVO.setId((int)leaveTypeId);
		                            attendanceVO.setLeaveVO(leaveVO);
		                            break;
		                        case 4:
		                            System.out.print(cell.getNumericCellValue() + "\t");
		                            attendanceVO.setNoOfLeavesTaken(cell.getNumericCellValue());
		                            break;
		                    }
		                }

				        this.attendanceService.insert(attendanceVO);
		                System.out.println("");

		                }
		            }
		            file.close();
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}

		return new ModelAndView ("redirect:/admin/loadAttendance");
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewAttendance",method=RequestMethod.GET)
	public ModelAndView viewAttendance(){
		List attendanceList = this.attendanceService.search();
		
		System.out.println(attendanceList.size());
		return new ModelAndView("admin/viewAttendance","attendanceList",attendanceList);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/viewEmployeeAttendance",method=RequestMethod.GET)
	public ModelAndView viewEmployeeAttendance(@ModelAttribute EmployeeVO  employeeVO){
		
		/************ LOGIN ID ************/
		
		String userName = BaseMethods.getCurrentUser();  
		
		System.out.println("userName : "  + userName);
		
		List loginList = this.loginService.searchByUserName(userName);
		
		LoginVO loginVO = (LoginVO)loginList.get(0);
		
		employeeVO.setLoginVO(loginVO);
		
		System.out.println("LOGIN ID ::: " + loginVO.getId());
		System.out.println("LOGIN ID ::::: " + employeeVO.getLoginVO().getId());
		
		/************ EMPLOYEE ID ************/
		
		List employeeList = this.employeeService.searchByLoginId(employeeVO);
		
		EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
		
		String employeeIdNumber = employeeVO2.getEmployeeIDno();
		
		List attendanceList = this.attendanceService.searchByEmpId(employeeIdNumber);
		
		return new ModelAndView("employee/viewEmployeeAttendance","attendanceList",attendanceList);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/deleteAttendance",method=RequestMethod.GET)
	public ModelAndView deleteAttendance(@RequestParam String attendanceId,@ModelAttribute AttendanceVO attendanceVO){

		attendanceVO.setId(Integer.parseInt(attendanceId));
		List attendanceList = attendanceService.delete(attendanceVO);

		AttendanceVO attendanceVO2 = (AttendanceVO) attendanceList.get(0);
		attendanceVO2.setStatus(false);
		
		attendanceService.update(attendanceVO2);
		
		return new ModelAndView("redirect:/admin/viewAttendance");	
	}


}
