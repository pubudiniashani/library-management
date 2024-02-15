Question 01 
String hql1 = "FROM Book WHERE publicationYear > :year";

Question 02
String hql2 = "UPDATE Book SET price = price*1.1 WHERE author.id = id ";

Question 03
 Author author = session.get(Author.class,2);
        if(author!= null){
            session.delete(author);
      }
 Question 04
 String hql3 = "SELECT AVG(price) FROM Book";

 Question 05
 String hql4 = "SELECT a, COUNT(b) FROM Author a LEFT JOIN a.books b GROUP BY a";

 Question 06
 String hql5 = "SELECT b FROM Book b WHERE author.country = :country";

 Question 07
 The @JoinColumn annotation is used to specify the mapping of a foreign key column in a relationship between two entities.This annotation is applied on the owning side to define the foreign key column name and other attributes related with join column.
 In here this is an one-to-many relationship. So an author can write many books. Many books can have a single author.To map this relationship @JoinColumn annotation is used.

 Questin 08 
  String hql6 = "SELECT a FROM Author a WHERE SIZE(a.books) > (SELECT AVG(SIZE(b.books)) FROM Author b)";

  Annotation explanasions

  01. @JoinColumn -The @JoinColumn annotation is used to specify the mapping of a foreign key column in a relationship between two entities.This annotation is applied on the owning side to define
   the foreign key column name and other attributes related with join column.

  02. Cascade -
     Cascades are designed to propagate changes in parent table with relavent associated child tables. In here CascadeType.REMOVE is used to delete an author with the relavent books.
  
  03.@GeneratedValue
    This defines how the primary key value of an entity are generated.
    
  
 
