package kr.or.ddit.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

import kr.or.ddit.user.model.UserVo;

public class ProfileView implements View {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileView.class);
	
	
	@Override
	public String getContentType() {
		return "img";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.debug("@^@ profileView  ");
		UserVo userVo = (UserVo) model.get("userVo");
		
		//path 정보로 file을 읽어서 
		ServletOutputStream sos = response.getOutputStream();
		FileInputStream fis = null;
		String filePath = null;
		
		//사진 존재하는 경우
		if(userVo.getPath() != null){
			filePath = userVo.getPath();
		//사진이 없는경우
		}else{
			filePath = request.getServletContext().getRealPath("/img/sally.png");
		}
		
		//화면에 띄워주는 부분!
		File file = new File(filePath);
		fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		
		
		while(fis.read(buffer, 0, 512) != -1){
			sos.write(buffer);
		}
		fis.close();
		sos.close();
		
		
	}

}
