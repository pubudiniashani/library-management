import config.FactoryConfiguration;
import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.Year;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      Session session =  FactoryConfiguration.getInstance().getSession();
      Transaction transaction = session.beginTransaction();

      //Q - 01
        String hql1 = "FROM Book WHERE publicationYear > :year";

        Query query = session.createQuery(hql1);
        query.setParameter("year", Year.of(2010));

       List<Book> books =  query.list();
        for ( Book book:books) {
            System.out.println(book.getTitle());
        }

        //Q-02
        String hql2 = "UPDATE Book SET price = price*1.1 WHERE author.id = id ";
        Query query1 = session.createQuery(hql2);
        query1.setParameter("id",1);
        int i = query1.executeUpdate();

        if(i>0){
            System.out.println("Price updated");
        }

        //Q-03
        Author author = session.get(Author.class,2);
        if(author!= null){
            session.delete(author);
            System.out.println("Deleted");
        }

        //Q-04
        String hql3 = "SELECT AVG(price) FROM Book";
        Query query2 = session.createQuery(hql3);
        Double avgPrice = (Double) query2.uniqueResult();
        System.out.println("Average price" + avgPrice );

        //Q-05
        String hql4 = "SELECT a, COUNT(b) FROM Author a LEFT JOIN a.books b GROUP BY a";
        Query query3 = session.createQuery(hql4);
        List<Object[]> result = query3.list();
        for (Object[] results : result) {
            Author author1 = (Author) results[0];
            Long count = (Long) results[1];
            System.out.println("Author " + author1.getName() + "Count " + count);

        }

        //Q-06
        String hql5 = "SELECT b FROM Book b WHERE author.country = :country";
        Query query4 = session.createQuery(hql5);
        query4.setParameter("country","Sri Lanka");
        List<Book> bookList = query4.list();
        for (Book book: bookList) {
            System.out.println(book.getTitle());
        }

        //Q-08
        String hql6 = "SELECT a FROM Author a WHERE SIZE(a.books) > (SELECT AVG(SIZE(b.books)) FROM Author b)";
        Query query5 = session.createQuery(hql6);
        List<Author> authors = query5.list();
        for (Author author2 :authors) {
            System.out.println(author2.getName());
        }



      transaction.commit();
      session.close();

    }
}
