package br.com.fiap;

import br.com.fiap.domain.entity.Opcional;
import br.com.fiap.domain.entity.Pizzaria;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        //Se o dia for sexta-feira -> "maria-db"
        var dia = LocalDate.now().getDayOfWeek().equals( DayOfWeek.FRIDAY ) ? "maria-db" : "fiap";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( dia );
        EntityManager manager = factory.createEntityManager();

        salvar( manager );

        Pizzaria pizzaria = manager.find( Pizzaria.class, 1 );

        System.out.println( pizzaria );

        manager.close();
        factory.close();

    }

    private static void salvar(EntityManager manager) {


        Sabor frangoComCatupiri = Sabor.builder().nome( "Frango com Catupiri" ).descricao( "Deliciosa pizza de frango com o autentico Catupiri" ).build();


        Sabor caipira = Sabor.builder().nome( "Caipira" ).descricao( "Delicioso sabor da fazenda. O milho muito macio" ).build();


        var opcionais = new LinkedHashSet<Opcional>();

        var bordaDeCatupiri = Opcional.builder()
                .nome( "Borda de Catupiri" )
                .preco( 9.99 )
                .build();

        var cocaCola = Opcional.builder()
                .nome( "Coca de 2L" )
                .preco( 19.99 )
                .build();

        var tortaDeLimao = Opcional.builder()
                .nome( "Torta de Limão" )
                .preco( 6.99 )
                .build();

        opcionais.add( bordaDeCatupiri );
        opcionais.add( cocaCola );
        opcionais.add( tortaDeLimao );

        var pizzaDeFrangoCatu = Produto.builder()
                .nome( "Pizza" )
                .preco( BigDecimal.valueOf( 59.99 ) )
                .sabor( frangoComCatupiri )
                .opcionais( opcionais )
                .build();


        var pizzaCipira = Produto.builder()
                .nome( "Pizza" )
                .preco( BigDecimal.valueOf( 49.99 ) )
                .sabor( caipira )
                .opcionais( opcionais )
                .build();


        var cardapio = new LinkedHashSet<Produto>();

        cardapio.add( pizzaCipira );
        cardapio.add( pizzaDeFrangoCatu );

        Pizzaria dominus = Pizzaria.builder().nome( "Dominus" ).cardapio( cardapio ).build();


        manager.getTransaction().begin();
        manager.persist( dominus );
        manager.getTransaction().commit();
    }
}