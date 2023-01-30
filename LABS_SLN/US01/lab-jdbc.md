:one: _Connect to database Sakila and fetch Actor Details from table to store them in a Map._  


```java
public class SelectStatementEx {
    public static void main(String[] args) {
        getActorsAsMap();

    }
//    GOAL IS TO UNDERSTAND THE WORKING OF ORM
    public Map<Integer,ActorModel> getActorsAsMap() {
//        USE JDBC TO POPULATE ACTORS INSIDE THE MAP.
        Map<Integer, ActorModel> map =new HashMap<>();
        int id=0;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAKILA","matlab","matlab");

            Statement statement = connection.createStatement();

            String selectQuery = "SELECT ACTOR_ID, FIRST_NAME, LAST_NAME FROM ACTOR";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while(resultSet.next()){
                int actorId = resultSet.getInt("ACTOR_ID");
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString("LAST_NAME");
                map.put(id, new ActorModel(actorId, firstName,lastName));
                id++;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return map;
    }
```


```java
package com.demo.jdbc;

public class ActorModel {
    private int actorId;
    private String firstName;
    private String lastName;
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public ActorModel(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return   "Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t";
    }
}

```
