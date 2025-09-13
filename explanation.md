# Database creation in Java Spring
 - Two ways to manage database in Spring is: database-first and Model-first approach
## Databse-first approach
- the database, schema and tables are defined via sql, and entities created for them in Java. However,
- Model-first apporach, spring handles the creation and behaviour of the tables and columns.

# Generating Entities using JPA
* To do this, create the table you want via the datasource menu on the side panel.
* click the table of interest, right-click and choose the 'Create JPA entitiy from database'
* it will create a java class with all necessary setup

# Defining relationships amongs entities

## One-to-many relationship
 - there is the concept of ownership. To get the 'owner'; the table with the foreign key is the owner of the relationship

-   @OneToMany(mappedBy = "user")
   @Builder.Default
   private List<Addresses> addresses = new ArrayList<>();

   public void addAddress(Addresses address){
   addresses.add(address);
   address.setUser(this);
   }

public void removeAddress(Addresses address){
addresses.remove(address);
address.setUser(null);
}
- The above code is used to define relationship amongst entities and also add to memory records
- there is also a method to remove an address

### the table with the foreign key

@ManyToOne
@JoinColumn(name = "user_id")
@ToString.Exclude
private User user;

- the above is the code for the second table

## Many-to-many relationship

