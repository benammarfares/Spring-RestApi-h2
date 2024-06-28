package dev.first.cardios.embedded;

import dev.first.cardios.cardio.Cardio;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcCardioRepo {

    private final JdbcClient jdbcClient;

    public JdbcCardioRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Cardio> findAll(){
        return jdbcClient.sql("select * from cardio")
                .query(Cardio.class)
                .list();
    }

    public Optional <Cardio> FindById(Integer id){
        return jdbcClient.sql("SELECT * FROM cardio where id = :id")
                .param("id", id)
                .query(Cardio.class)
                .optional();
    }

    public void create(Cardio cardio){
      var updated =  jdbcClient.sql("INSERT INTO cardio (ID , NAME , DESCRIPTION , EQUIPMENT, TARGETMUSCLE , DIFFICULTY , TYPEE) values (?, ?, ?, ?, ?, ?, ?)")
                .params(List.of(cardio.id(),cardio.name(), cardio.description(), cardio.equipment().name(), cardio.targetMuscle(), cardio.difficulty(), cardio.typee()))
                .update();
      Assert.state(updated == 1, "Failed to create run " + cardio.name());
    }

    public void update(Cardio cardio,Integer id){
        var updated = jdbcClient.sql("update cardio set name = ?, description = ?, equipment = ?, targetMuscle = ?, difficulty = ?, typee = ? where id = ?")
                .params(List.of(cardio.name(), cardio.description(), cardio.equipment().name(), cardio.targetMuscle(), cardio.difficulty(), cardio.typee(), id))
                .update();
        Assert.state(updated == 1, "Failed to update run " + cardio.name());
    }

    public void delete(Integer id){
        var updated = jdbcClient.sql("delete from cardio where id = :id")
                .param("id", id)
                .update();
        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public int count (){
        return jdbcClient.sql("select * from cardio").query().listOfRows().size();

    }

    public void saveAll(List<Cardio> cardios){
      //  cardios.stream().forEach(this::create);
        cardios.forEach(this::create);
    }

    public List<Cardio> FilterByEquipment(String equipment){
        return jdbcClient.sql("select * from cardio where equipment = ?")
                .param("equipment", equipment)
                .query(Cardio.class)
                .list();
    }

}
