package edu.hfnu.temporaryTest;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.JsonFormat;
import edu.hfnu.model.Minister;

/**
 * 用来测试json-core-2.9.0.jar包能不能正常转化java对象为JSON字符串
 * @author a
 *
 */

public class JsonTest {
	public static void main(String[] args) throws JsonProcessingException {
		ArrayList<Object> data = new ArrayList<Object>();
		Minister m1 = new Minister(1,"张三","1234","办公室");
		Minister m2 = new Minister(2,"王五","1234","办公室");
		Minister m3 = new Minister(3,"萧十三郎","1234","会员工作部");
		Minister m4 = new Minister(4,"李四","1234","组织部");
		data.add(m1);
		data.add(m2);
		data.add(m3);
		data.add(m4);
		//1.实例化一个Layui数据表格规范json格式类
		JsonFormat format = new JsonFormat(0,"",100,data);
		//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(format);
		//3.打印后端控制台，查看是否转化正确
		System.out.println(json);
	}
}
