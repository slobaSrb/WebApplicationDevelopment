package rs.ac.ni.pmf.web.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AdsSearchOptions {
	private String title_filter;
	private LocalDate start_date_filter;
	
	private Integer page;
	private Integer page_size;

}
