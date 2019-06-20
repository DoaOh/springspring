package kr.or.ddit.typeConvert;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDateRegister implements PropertyEditorRegistrar {
	private static final Logger logger = LoggerFactory.getLogger(CustomDateRegister.class);

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	
		logger.debug("CustomDateRegister {}","실행" );
	}

	
	
	
}
