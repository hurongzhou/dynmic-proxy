package proxy;

public class Main {
    public static void main(String[] args){
        DynamicProxy dynamicProxy=new DynamicProxy();
        UserDao dao= (UserDao) dynamicProxy.bind(new UserDaoImpl());
        dao.delete("hu");
    }
}
