package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//자바파일을 설정파일로 만드는 annotaion
@Configuration
@ComponentScan(basePackages= {"kr.or.ddit.board","kr.or.ddit.aop"})
//defaultfilter controller Service repository component
//useDefaultFilters false로 선언시 원하는 어노테이션만 스캔가능
public class ApplicationBeanScanConfig {

}
