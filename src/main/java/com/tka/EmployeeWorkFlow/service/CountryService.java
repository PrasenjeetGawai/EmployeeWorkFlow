package com.tka.OrganizationWorkFlow.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkFlow.dao.CountryDao;
import com.tka.OrganizationWorkFlow.entity.Country;

@Service
public class CountryService {
	@Autowired
	CountryDao countryDao;

	public String addRecord(Country country) {

		String msg = countryDao.addRecord(country);

		if (Objects.isNull(msg)) {
			msg = "Country is Not added...";
		}

		return msg;
	}

	public String updataRecord(Country country,int c_id) {

		String msg = countryDao.updataRecord(country, c_id);

		if (Objects.isNull(msg)) {
			msg = "Country is Not Updated...";
		}

		return msg;
	}

	public String deleteRecord(int c_id) {

		String msg = countryDao.deleteRecord(c_id);

		if (Objects.isNull(msg)) {
			msg = "Country is Not Deleted...";
		}

		return msg;
	}

	public List<Country> getAllData() {
		List<Country> list = countryDao.getAllData();

		return list;
	}

	public Country getParticular(int c_id) {
		Country country = countryDao.getParticular(c_id);

		return country;
	} 

}
