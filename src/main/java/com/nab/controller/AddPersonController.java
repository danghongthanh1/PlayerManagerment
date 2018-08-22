package com.nab.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nab.entities.Person;
import com.nab.service.PersonService;

@Controller
@RequestMapping("/person")
public class AddPersonController {
	@Autowired
	private PersonService personService;
	@RequestMapping(value = "/add-person-by-excel", method = RequestMethod.GET)
	public ModelAndView addPersonEx() {
		ModelAndView mav = new ModelAndView("add-person-by-excel");
		return mav;
	}

	@RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
	public ModelAndView doAddPersonEx(@RequestParam("file") MultipartFile file) {
		ModelAndView mav = new ModelAndView("upload_persons");

		List<Person> list = new ArrayList<Person>();
		try {
			list = readExcel(file.getInputStream(), file.getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Person person : list) {
//			System.out.println(
//					p.getId() + "  " + p.getName() + "  " + p.getAge() + "  " + p.getSex() + "  " + p.getTypecode());
			personService.save(person);
			
		}
		mav.addObject("numberOfPerson", list.size());
		return mav;
	}

	public static List<Person> readExcel(InputStream inputStream, String excelFilePath) {

		List<Person> list = new ArrayList<>();
		// get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
		// get Sheet in workbook
		Sheet sheet = workbook.getSheetAt(0);
		// get all rows in sheet
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			if (row.getRowNum() == 0) {
				// Ignore header
				continue;
			}
			// get all cells in row
			Iterator<Cell> cellIterator = row.cellIterator();

			// Read cells and set value for Person object
			Person person = new Person();
			while (cellIterator.hasNext()) {
				// read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					break;
				}
				// get propertis of Person object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case 0:
					person.setName(cellValue.toString());
					break;
				case 1:
					person.setAge((new BigDecimal((double) cellValue).intValue()));
					break;
				case 2:
					person.setSex(cellValue.toString());
					break;
				case 3:
					person.setTypecode(cellValue.toString());
					break;
				default:
					break;
				}
			}
			// Check person and add person to list
			if (person.getName() != null && person.getAge() != 0 && person.getSex() != null
					&& person.getTypecode() != null) {
				list.add(person);
			}
		}
		return list;
	}

	// get Workbook
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			try {
				workbook = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (excelFilePath.endsWith("xls")) {
			try {
				workbook = new HSSFWorkbook(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workbook;
	}

	// get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case _NONE:
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}
}
