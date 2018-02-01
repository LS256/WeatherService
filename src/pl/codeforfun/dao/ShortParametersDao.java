package pl.codeforfun.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ShortParametersDao {
	List<ShortParameters> shortParametersList = new ArrayList<ShortParameters>();
	
	public void putElement(ShortParameters shortParameters) {
		shortParametersList.add(shortParameters);
	}
	
	public ShortParameters getElement(int id) {
		return shortParametersList.get(id);
	}
	
	public List<ShortParameters> getShortParametersList(){
		return shortParametersList;
	}
	
}
