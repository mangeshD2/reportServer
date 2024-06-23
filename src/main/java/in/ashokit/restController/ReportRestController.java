package in.ashokit.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
import in.ashokit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlans() {
		List<String> uniquePlanNames = reportService.getUniquePlanNames();
		return new ResponseEntity<>(uniquePlanNames, HttpStatus.OK);
	}

	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getStatuses() {
		List<String> uniquePlanStatuses = reportService.getUniquePlanStatuses();
		return new ResponseEntity<>(uniquePlanStatuses, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest searchRequest) {

		List<SearchResponse> search = reportService.search(searchRequest);
		return new ResponseEntity<>(search, HttpStatus.OK);
	}

	@GetMapping("/downloadExcel")
	public void excelReport(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;fileName=data.xls";

		response.setHeader(headerKey, headerValue);

		reportService.generateExcel(response);
	}

	@GetMapping("/downloadPdf")
	public void exportToPDF(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=data.pdf";
		response.setHeader(headerKey, headerValue);

		reportService.generatePdf(response);

	}
}
