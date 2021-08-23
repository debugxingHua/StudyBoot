package com.xing.studyboot.rest.dao.impl;

import org.springframework.stereotype.Service;

import com.xing.studyboot.rest.dao.CommonDao;

@Service
public class CommonDaoImpl implements CommonDao {

	@Override
	public String get() {
		return "ok！奥里给";
	}

}
