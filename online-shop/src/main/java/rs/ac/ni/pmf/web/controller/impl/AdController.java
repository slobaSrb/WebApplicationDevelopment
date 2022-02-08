package rs.ac.ni.pmf.web.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.controller.IAdController;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.api.AdDTO;
import rs.ac.ni.pmf.web.service.AdService;

@RestController
@RequiredArgsConstructor
public class AdController implements IAdController {
	
	private final AdService adService;
	
	@Override
	public List<AdDTO> getAllAds() {
		// TODO Auto-generated method stub
		//return null;
		return adService.getAllAds();
	}

	@Override
	public AdDTO getAd(int adID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return adService.getAd(adID);
	}

	@Override
	public AdDTO createAd(AdDTO adDto) throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		return adService.createAd(adDto);
	}

	@Override
	public AdDTO updateAd(int adID, AdDTO adDto) throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		return adService.updateAd(adID, adDto);
	}

	@Override
	public void deleteAd(int adID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		adService.deleteAd(adID);
	}

}
