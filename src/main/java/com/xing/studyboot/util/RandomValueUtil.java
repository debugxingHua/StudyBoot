package com.xing.studyboot.util;

import org.springframework.boot.env.RandomValuePropertySource;

/**
 *  随机数工具类
 *  使用的时候 直接new获取
 * @author xing
 * @createTime 2021年5月11日 
 */
public class RandomValueUtil {

	public static void main(String[] args) {
		// 自定义的一个随机值属性源,起名叫做 myRandom
        RandomValuePropertySource random = new RandomValuePropertySource("myRandom");
        // 随机生成一个整数
        System.out.println("random int:->"+random.getProperty("random.int"));
        // 随机生成一个整数，指定上边界，不大于等于5
        System.out.println("random int(5):->"+random.getProperty("random.int(5)"));
        // 使用()包围,2个字符 前闭后开=>比如 random.int(0,1)只能是0
        // 只要时两个符号就可以，不一定非要用()
        System.out.println("random int(0,1):->"+random.getProperty("random.int(0,1)"));
        System.out.println("random int(0,10):->"+random.getProperty("random.int(0,10)"));
        // ! 也行
        System.out.println("random int[0,1]:->"+random.getProperty("random.int!0,2!"));
        // !0,5& 也行
        System.out.println("random int[0,1]:->"+random.getProperty("random.int!0,5&"));
        // 前后各一个空格 也行 
        System.out.println("random int(1,3):->"+random.getProperty("random.int 1,3 "));
        // 使用汉字包围,2个字符，前后各一个汉字 也行
        System.out.println("random int(3,4):->"+random.getProperty("random.int底3,4顶"));
        // 使用英文字母包围,2个字符，前后各一个英文字母 也行
        System.out.println("random int(5,6):->"+random.getProperty("random.intL5,6U"));
        // 使用数字包围,2个字符，前一个数字5，后一个数字6 也行
        System.out.println("random int(5,6):->"+random.getProperty("random.int55,66"));

        // 随机生成一个长整数 
        System.out.println("random long:->"+random.getProperty("random.long"));
        // 随机生成一个整数，使用区间[100,101),前闭后开=>只能是100
        System.out.println("random long(100,101):->"+random.getProperty("random.long(100,101)"));

        // 随机生成一个 uuid
        System.out.println("random uuid:->"+random.getProperty("random.uuid"));
	}

}
