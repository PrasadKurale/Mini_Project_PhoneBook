package in.ashokit.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.binding.CitizenPlan;
import in.ashokit.binding.SeachRequest;
import in.ashokit.repo.CitizenPlanRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	CitizenPlanRepository citizenPlanRepository;

	@Override
	public List<CitizenPlan> getCitizenPlans(SeachRequest request) throws Exception {

		CitizenPlan entity = new CitizenPlan();

		if (request.getPlaneName() != null && !request.getPlaneName().equals("")) {
			entity.setPlanName(request.getPlaneName());
			// exportExcelForSearch(entity);
		}
		
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (request.getGender() != null && !request.getGender().equals("")) {
			entity.setGender(request.getGender());
		}

		Example<CitizenPlan> example = Example.of(entity);

		List<CitizenPlan> records = citizenPlanRepository.findAll(example);

		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse httpServletResponse) throws Exception {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Citizen Info"); // sheetName

		XSSFRow headRow = sheet.createRow(0); // firstRow

		headRow.createCell(0).setCellValue("Id");
		headRow.createCell(1).setCellValue("Name");
		headRow.createCell(1).setCellValue("SSN");
		headRow.createCell(1).setCellValue("Gender");
		headRow.createCell(1).setCellValue("Plan Name");
		headRow.createCell(1).setCellValue("Plan status");

		List<CitizenPlan> records = citizenPlanRepository.findAll();

		int dataRowIndex = 1;

		for (CitizenPlan record : records) {
			XSSFRow dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(record.getCid());
			dataRow.createCell(0).setCellValue(record.getCname());
			dataRow.createCell(0).setCellValue(record.getSsn());
			dataRow.createCell(0).setCellValue(record.getGender());
			dataRow.createCell(0).setCellValue(record.getPlanName());
			dataRow.createCell(0).setCellValue(record.getPlanStatus());

			dataRowIndex++;
		}

		ServletOutputStream outputStream = httpServletResponse.getOutputStream();

		workbook.write(outputStream);

		workbook.close();

		outputStream.close();

	}

	@Override
	public void exportPdf(HttpServletResponse httpServletResponse) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4); // create doc

		PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

		document.open();

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph paragraph = new Paragraph("Citizen Plans Info", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragraph);

		PdfPTable pdfTable = new PdfPTable(6); // cell means one complete row 6

		pdfTable.setWidthPercentage(100f);
		pdfTable.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f });
		pdfTable.setSpacingBefore(10);

		document.add(pdfTable);

		// set Table header data
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);

		Font f = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Id", f));
		pdfTable.addCell(cell);

		cell.setPhrase(new Phrase("Name", f));
		pdfTable.addCell(cell);

		cell.setPhrase(new Phrase("SSN", f));
		pdfTable.addCell(cell);

		cell.setPhrase(new Phrase("Gender", f));
		pdfTable.addCell(cell);

		cell.setPhrase(new Phrase("Plan Name", f));
		pdfTable.addCell(cell);

		cell.setPhrase(new Phrase("Plan Status", font));
		pdfTable.addCell(cell);

		// set table data
		List<CitizenPlan> records = citizenPlanRepository.findAll();

		for (CitizenPlan record : records) {
			pdfTable.addCell(String.valueOf(record.getCid())); // String.valueOf we used because cell is string type and
			// cid is integer type to convert into str
			pdfTable.addCell(record.getCname());
			pdfTable.addCell(String.valueOf(record.getSsn()));
			pdfTable.addCell(record.getGender());
			pdfTable.addCell(record.getPlanName());
			pdfTable.addCell(record.getPlanStatus());

		}

		document.add(pdfTable);
		document.close();
	}

	@Override
	public void exportExcelForSearch(CitizenPlan entity) throws Exception {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Citizen Info"); // sheetName

		XSSFRow headRow = sheet.createRow(0); // firstRow

		headRow.createCell(0).setCellValue("Id");
		headRow.createCell(1).setCellValue("Name");
		headRow.createCell(1).setCellValue("SSN");
		headRow.createCell(1).setCellValue("Gender");
		headRow.createCell(1).setCellValue("Plan Name");
		headRow.createCell(1).setCellValue("Plan status");

		List<CitizenPlan> records = citizenPlanRepository.findAll();

		int dataRowIndex = 1;

		for (CitizenPlan record : records) {
			XSSFRow dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(record.getCid());
			dataRow.createCell(0).setCellValue(record.getCname());
			dataRow.createCell(0).setCellValue(record.getSsn());
			dataRow.createCell(0).setCellValue(record.getGender());
			dataRow.createCell(0).setCellValue(record.getPlanName());
			dataRow.createCell(0).setCellValue(record.getPlanStatus());

			dataRowIndex++;
		}

		ServletResponse httpServletResponse = null;

		ServletOutputStream outputStream = httpServletResponse.getOutputStream();

		workbook.write(outputStream);

		workbook.close();

		outputStream.close();

	}

	@Override
	public List<String> getPlanNames() {

		return citizenPlanRepository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenPlanRepository.getPlanStatus();
	}

}
