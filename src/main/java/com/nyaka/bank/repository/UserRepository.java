package com.nyaka.bank.repository;

import com.nyaka.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    //Select * from User where firstname = 'lulu'
    List<User> findAllByFirstname(String firstname);

    //Select * from UserBank where firstname ilike '%lulu%' //firstname contient le mot lulu ou les caractères lulu
    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);
    Optional<User> findByEmail(String email);

    //Select * from UserBank where firstname like '%lulu%' and email = 'mm@tot.fr'
    Optional<User> findByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);

    //la liste des utilisateurs ayant un iban specifique
    //Spring Data va faire une jointure avec User car dans l'entité Account il  y a un user
    // select u.* from UserBank u inner join account a on u.id = a.id_user and a.iban = '123456'
    List<User> findAllByAccountIban(String iban);

    //Select * from UserBank where firstname = 'lulu' equivalent en JPQL
    @Query("from User where firstname = :firstname")  //JPQL methode 1 = même nom du paramètre
    List<User> searchByFirstname(String firstname);

    @Query("from User where firstname = :fn")  //JPQL  methode  = nom du paramètre différent
    List<User> searchByFirstname2(@Param("fn")String firstname);

    //Select * from UserBank where firstname ilike '%lulu%'
    @Query("from User where firstname = '%:firstname%'")
    List<User> searchByFirstnameContaining(String firstname);

    //select u.* from UserBank u inner join account a on u.id = a.id_user and a.iban = '123456'
    @Query("from User u inner join Account a on u.id = a.user.id where a.iban = :iban")
    List<User> searchAllByAccountIban(String iban);

    //select u.* from UserBank u inner join account a on u.id = a.id_user and a.iban = '123456'
    @Query(value = "select u.* from UserBank u inner join account a on u.id = a.id_user and a.iban = '123456'", nativeQuery = true)
    List<User> searchAllByAccountIbanNative(String iban);

}
