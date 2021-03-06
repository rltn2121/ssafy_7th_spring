import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws Exception {
//		개발자가 직접 호출
//		MyReflection mr = new MyReflection();
//		mr.aboutMe();

		
//		스프링이 대신 할 때
		
		// 1. 하드코딩
//		String className = "MyReflection";
//		Class<?> myClass = Class.forName(className);
		
		// 2. application.properties에서 설정
		InputStream is = new FileInputStream("src/application.properties");
		Properties prop = new Properties();
		prop.load(is);
		
		String className = prop.getProperty("class.name");
		Class<?> myClass = Class.forName(className);
		
		// 객체 생성
		MyReflection mf = (MyReflection)myClass.getDeclaredConstructor().newInstance();
		mf.aboutMe();
		
		// method 호출
		Method m = myClass.getMethod("robot", int.class);
		String str = (String)m.invoke(mf, 80);
		System.out.println(str);
		
		Annotation[] annotations = myClass.getAnnotations();
		for(Annotation annotation : annotations) {
			if(annotation instanceof MyAnnotation) {
				MyAnnotation myAnnotation = (MyAnnotation)annotation;
				System.out.println(myAnnotation.love());
				System.out.println(myAnnotation.hate());
						
			}
		}
	}
}

