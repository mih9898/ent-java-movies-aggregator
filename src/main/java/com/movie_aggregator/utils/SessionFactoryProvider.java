package com.movie_aggregator.utils;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.movie_aggregator.enity.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * This file provides a SessionFactory for use with DAOs using Hibernate
 *
 * @author paulawaite
 * @version 2.0 1/27/18.
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    /**
     * private constructor prevents instantiating this class anywhere else
     */

    private SessionFactoryProvider() {

    }

    /**
     * Create session factory.
     */
    public static void createSessionFactory() {

        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

//        sessionFactory = new MetadataSources(standardRegistry).buildMetadata().buildSessionFactory();
        Metadata metaData =
                new MetadataSources(standardRegistry)
                        .getMetadataBuilder()
                        .build();
        sessionFactory = metaData.getSessionFactoryBuilder().build();
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;

    }
}