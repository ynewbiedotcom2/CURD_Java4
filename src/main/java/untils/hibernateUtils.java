package untils;


import Repositories.ChiTietSanPhamRepo;
import Repositories.KhachHangRepo;
import Repositories.NhanVienRepo;
import domain_model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class hibernateUtils {


    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();


        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);

        conf.addAnnotatedClass(KhachHangEntity.class);
        conf.addAnnotatedClass(NhanVienEntity.class);
        conf.addAnnotatedClass(MauSacEntity.class);
        conf.addAnnotatedClass(HoaDonEntity.class);
        conf.addAnnotatedClass(NsxEntity.class);
        conf.addAnnotatedClass(HoaDonChiTietEntity.class);
        conf.addAnnotatedClass(DongSpEntity.class);
        conf.addAnnotatedClass(ChucVuEntity.class);
        conf.addAnnotatedClass(CuaHangEntity.class);
        conf.addAnnotatedClass(SanPhamEntity.class);
        conf.addAnnotatedClass(ChiTietSpEntity.class);
        conf.addAnnotatedClass(GioHangChiTietEntity.class);
        conf.addAnnotatedClass(GioHangEntity.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        KhachHangRepo x=  new KhachHangRepo();

        System.out.println(x.findAll().get(0));

    }
}



