package proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void delete(String name) {
        System.out.println("删除成功！");
    }
}
