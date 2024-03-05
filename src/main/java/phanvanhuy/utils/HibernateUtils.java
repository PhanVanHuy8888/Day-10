package phanvanhuy.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import phanvanhuy.entity.Employee;

public class HibernateUtils {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                // Tải cấu hình từ hibernate.cfg.xml
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                
                // Thêm class Employee vào MetadataSources
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(Employee.class);
                
                // Xây dựng Metadata từ MetadataSources
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                
                // Xây dựng SessionFactory từ Metadata
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Không thể khởi tạo SessionFactory. Lỗi: " + ex.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
