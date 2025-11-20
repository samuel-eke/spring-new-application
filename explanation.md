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

# Responses to requests
- To handle error requests or requests in general, there is a class /ResponseEntity/ class that is used to handle this action. 
- //     public ResponseEntity<User> getAUser(@PathVariable Long id){
  //        var user = userRepository.findById(id).orElse(null);
  //        if(user == null){
  //            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  //            or return ResponseEntity.notFound().build();
  //        }
  //        return new ResponseEntity<>(user, HttpStatus.OK);
  //        return ResponseEntity.ok(user);
  //     }

## Formating responses with @Json annotation
- the @Jsonignore, is used in the DTO to ignore certain fields that we dont want parsed to the response out. simply place it on top of the field you wish hidden, and it will not display.
- the @Jsonproperty is used to provide an alias for a field. simply, place it on top of the field you want to rename and supply property="alias"; as the argument for it and the response will rename that field with the new field name
- @JsonInclude(JsonInclude.Include.NON_NULL)  this allows us to remove null fields from the return response

