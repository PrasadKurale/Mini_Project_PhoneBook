package in.ashokit.service;

import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import in.ashokit.binding.CitizenPlan;
import in.ashokit.binding.SeachRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	 
	public List<CitizenPlan> getCitizenPlans(SeachRequest request) throws Exception;
	
	public void exportExcel(HttpServletResponse httpServletResponse) throws Exception;
	
	public void exportPdf(HttpServletResponse httpServletResponse) throws DocumentException, IOException;

	void exportExcelForSearch(CitizenPlan entity) throws Exception;


	
}
