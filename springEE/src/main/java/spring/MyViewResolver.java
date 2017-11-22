package spring;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Component
public class MyViewResolver extends InternalResourceViewResolver {

	public MyViewResolver(){
		setViewClass(JstlView.class);
		setPrefix("/WEB-INF/views/");
		setSuffix(".jsp");
	}
}
