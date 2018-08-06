package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest implements InvocationHandler{

	private Object origiObj;
	
	public Object bind(Object obj) {
		this.origiObj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if(method.getName().startsWith("begin")) {
			System.out.println("fucker");
			result = method.invoke(this.origiObj, args);
			System.out.println("$%^&*()_");
		}
		return result;
	}

}
