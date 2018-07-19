//package team.typhoon.admin.util;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import team.typhoon.admin.pojo.Admin;
//import team.typhoon.admin.util.impl.Admins;
//import typhoon.merchant.util.JsonParse;
//import typhoon.merchant.util.JsonParseByJackson;
//
//public class JacksonUtilTest {
//
//	@Test
//	public void testParseListToJson() {
//		JsonParse<Admin> jacksonUtil = new JsonParseByJackson<Admin>();
//		List<Admin> admins=new ArrayList<>();
//		admins.add(new Admin(1, "harper", "1234456"));
//		admins.add(new Admin(2, "hugo", "1234456"));
//		admins.add(new Admin(3, "json", "1234456"));
//		String json = jacksonUtil.parseListToJson(admins);
//		System.out.println(json);
//	}
//	@Test
//	public void testParseObjectToJson() {
//		JsonParse<Admin> jacksonUtil = new JsonParseByJackson<Admin>();
//		String json = jacksonUtil.parseObjectToJson(new Admin(1, "harper", "1234456"));
//		System.out.println(json);
//	}
//	@Test
//	public void testParseJsonToObject() {
//		JsonParse<Admin> jacksonUtil = new JsonParseByJackson<Admin>();
//		String json ="{\"id\":1,\"userName\":\"harper\",\"password\":\"1234456\"}";
//		Admin admin=jacksonUtil.parseJsonToObject(Admin.class, json);
//		System.out.println(admin.toString());
//	}
//	@Test
//	public void testParseJsonToList() {
//		JsonParse<Admin> jacksonUtil = new JsonParseByJackson<Admin>();
//		String json ="[{\"id\":1,\"userName\":\"harper\",\"password\":\"1234456\"},{\"id\":2,\"userName\":\"hugo\",\"password\":\"1234456\"},{\"id\":3,\"userName\":\"json\",\"password\":\"1234456\"}]";
//		List<Admin> admin=jacksonUtil.parseJsonToList(Admin.class, json);
//		for(Admin a:admin) {
//			System.out.println(a.toString());
//		}
//	}
//	
//	
//	
//	//以下测试同上，但Admins中含有集合属性users
//	@Test
//	public void testParseListToJson2() {
//		JsonParse<Admins> jacksonUtil = new JsonParseByJackson<Admins>();
//		List<Admins> admins=new ArrayList<>();
//		List<String> users=new ArrayList<>();
//		users.add("har1");
//		users.add("har2");
//		users.add("har3");
//		
//		admins.add(new Admins(1, "harper", "1234456",users));
//		admins.add(new Admins(2, "hugo", "1234456",users));
//		admins.add(new Admins(3, "json", "1234456",users));
//		String json = jacksonUtil.parseListToJson(admins);
//		System.out.println(json);
//	}
//	
//	@Test
//	public void testParseObjectToJson2() {
//		JsonParse<Admins> jacksonUtil = new JsonParseByJackson<Admins>();
//		List<String> users=new ArrayList<>();
//		users.add("har1");
//		users.add("har2");
//		users.add("har3");
//		String json = jacksonUtil.parseObjectToJson(new Admins(1, "harper", "1234456",users));
//		System.out.println(json);
//	}
//	
//	//无法将字符串中对象的集合属性转换成功
//	@Test
//	public void testParseJsonToObject2() {
//		JsonParse<Admins> jacksonUtil = new JsonParseByJackson<Admins>();
//		String json ="{\"id\":1,\"userName\":\"harper\",\"password\":\"1234456\",\"users\":[\"har1\",\"har2\",\"har3\"]}";
//		Admins admin=jacksonUtil.parseJsonToObject(Admins.class, json);
//		System.out.println(admin.toString());
//	}
//	@Test
//	public void testParseJsonToList2() {
//		JsonParse<Admins> jacksonUtil = new JsonParseByJackson<Admins>();
//		String json ="[{\"id\":1,\"userName\":\"harper\",\"password\":\"1234456\",\"users\":[\"har1\",\"har2\",\"har3\"]},{\"id\":2,\"userName\":\"hugo\",\"password\":\"1234456\",\"users\":[\"har1\",\"har2\",\"har3\"]},{\"id\":3,\"userName\":\"json\",\"password\":\"1234456\",\"users\":[\"har1\",\"har2\",\"har3\"]}]";
//		List<Admins> admin=jacksonUtil.parseJsonToList(Admins.class, json);
//		for(Admins a:admin) {
//			System.out.println(a.toString());
//		}
//	}
//}
