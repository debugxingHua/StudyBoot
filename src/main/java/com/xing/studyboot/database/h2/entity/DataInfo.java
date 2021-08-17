package com.xing.studyboot.database.h2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *  实体对象
 * @author xing
 * @createTime
 */
@Entity
@Data
public class DataInfo {
	@Id 
	@GeneratedValue
    private long id;
    private String name;
    private String age;
    
    public DataInfo() {
    }
    public DataInfo(String name, String age) {
    	this.name = name;
    	this.age = age;
    }
}
