package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CitizenPlan;
import in.ashokit.binding.SeachRequest;
import in.ashokit.service.ReportServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class ReportController {

	@Autowired
	ReportServiceImpl reportServiceImpl;

	@GetMapping("/PlanNames")
	public ResponseEntity<List<String>> getPlanNames() {
		return ResponseEntity.ok(reportServiceImpl.getPlanNames());

	}

	@GetMapping("/PlanStatus")
	public ResponseEntity<List<String>> getPlanStatus() {
		return ResponseEntity.ok(reportServiceImpl.getPlanStatus());
	}

	@PostMapping("/search")
	public ResponseEntity<List<CitizenPlan>> search(@RequestBody SeachRequest request) throws Exception {
		return ResponseEntity.ok(reportServiceImpl.getCitizenPlans(request));
	}

	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");

		String key = "Content-Disposition";
		String value = "attachment;filename=citizens.xlsx";

		response.setHeader(key, value);

		reportServiceImpl.exportExcel(response);

		response.flushBuffer(); // flushBuffer method is used to send the data completly

	}

	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");

		String key = "Content-Disposition";
		String value = "attachment;filename=plans.pdf";

		response.setHeader(key, value);

		reportServiceImpl.exportPdf(response);

		response.flushBuffer(); // flushBuffer method is used to send the data completly
	}
}
