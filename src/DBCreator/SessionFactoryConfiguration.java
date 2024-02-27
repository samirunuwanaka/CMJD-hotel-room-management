package DBCreator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(DBCreator.entity.AdminData.class)
                .addAnnotatedClass(DBCreator.entity.CustomerData.class)
                .addAnnotatedClass(DBCreator.entity.RoomPackages.class)
                .addAnnotatedClass(DBCreator.entity.DinningPackages.class)
                .addAnnotatedClass(DBCreator.entity.RoomsData.class)
                .addAnnotatedClass(DBCreator.entity.PurchaseDetail.class)
                .addAnnotatedClass(DBCreator.entity.PurchaseData.class)
                .addAnnotatedClass(DBCreator.entity.CheckInData.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        if (sessionFactoryConfiguration == null) {
            sessionFactoryConfiguration = new SessionFactoryConfiguration();
        }

        return sessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
