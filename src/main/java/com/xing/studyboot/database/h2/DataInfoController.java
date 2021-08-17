package com.xing.studyboot.database.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xing.studyboot.database.h2.entity.DataInfo;
import com.xing.studyboot.database.h2.repository.DataInfoRepository;

/**
 * SpringBoot 的h2内存数据库
 * @author xing
 * @createTime
 */
@RestController
@RequestMapping("/h2")
public class DataInfoController {

	@Autowired
    private DataInfoRepository dataInfoRepository;
	
	/**
	 * 保存数据
	 * @return
	 */
    @RequestMapping("/save")
    public String save(){
    	dataInfoRepository.save(new DataInfo("xing", "18"));
    	dataInfoRepository.save(new DataInfo("hua", "18"));
    	dataInfoRepository.save(new DataInfo("留言", "18"));
        dataInfoRepository.save(new DataInfo("苍劲空", "18"));
        dataInfoRepository.save(new DataInfo("小伊", "18"));
        return"save ok";
    }

    /**
     * 获取所有数据
     * @return
     */
    @RequestMapping("/findAll")
    public Iterable<DataInfo> findAll(){
        // 内存数据库操作 
       return dataInfoRepository.findAll();
    }
}
