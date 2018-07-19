package typhoon.merchant.util;


import java.util.List;

public interface JsonParse<T> {

	public String parseObjectToJson(Object object);
	
	public String parseListToJson(List<T> list);
	
	public List<T> parseJsonToList(Class<T> clazz,String json);

	public T parseJsonToObject(Class<T> clazz,String json);
}
