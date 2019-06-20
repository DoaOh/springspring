package kr.or.ddit.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class IocCollection {
	
	
	private List<String> list;
	private Map<String,String>map;
	private Set<String> set;
	private Properties proprerties;
	
	
	//settter , getter
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	
	public Properties getProprerties() {
		return proprerties;
	}
	public void setProprerties(Properties proprerties) {
		this.proprerties = proprerties;
	}
	
	
	
	

}
