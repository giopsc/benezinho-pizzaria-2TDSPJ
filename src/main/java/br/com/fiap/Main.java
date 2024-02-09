package br.com.fiap;

import br.com.fiap.domain.entity.Pizzaria;
import br.com.fiap.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "maria-db" );
        EntityManager manager = factory.createEntityManager();

        Pizzaria dominus = new Pizzaria();
        dominus.setId( null ).setNome( "Dominus" );

        Sabor frangoComCatupiri = new Sabor( null, "Frango com Catupiri", "Deliciosa pizza de frango com o autentico Catupiri" );

        Sabor caipira = new Sabor( null, "Caipira", "Deliciosa caipira com milho macio" );

        manager.getTransaction().begin();
        manager.persist( frangoComCatupiri );
        manager.persist( caipira );
        manager.persist( dominus );
        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}