package stepdefinitions.dbstepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaRoomStepDefs.roomNumber;

public class RoomDBStepDefs {

    @Given("Olusan odayi room_number ile dogrula")
    public void olusan_odayi_room_number_ile_dogrula() throws SQLException {
     Connection connection= DriverManager.getConnection(
                "jdbc:postgresql://medunna.com:5432/medunna_db_v2",
                "select_user",
                "Medunna_pass_@6");
       Statement statement= connection.createStatement();
       ResultSet resultSet=statement.executeQuery("SELECT * FROM room WHERE created_by = 'tuba_hayati' ORDER BY created_date DESC");//olusturma tarihine gore tum oda bilgilerini verir
       // resultSet : her zaman resultsette pointer vardır. her zaman baslıgı gosterir once. datanın datasını alabiliriz..
    //resultSet.next()//next diyince pointer bir yana kayacak.while loop kullanırız;kac kere next yaparsak o kadar gider. true oldugu surece calısır
        /*
        resultSet.next();
       int x= resultSet.getInt(2);//1den baslıyor ...ogrenmek icin boyle yaptık
        System.out.println("x = " + x);
        System.out.println("roomNumber = " + roomNumber); //x:2 ile roomNumber esitliyor
         */
        List<Integer> roomNumberList=new ArrayList<>();

while (resultSet.next()){
    roomNumberList.add(resultSet.getInt(2));//2 =roomNumber ; string olarak belirtsek de calısır
    roomNumberList.add(resultSet.getInt(1));
    roomNumberList.add(resultSet.getInt(6));
}
        System.out.println("roomNumberList = " + roomNumberList);
assertTrue(roomNumberList.contains(roomNumber));
assertTrue(roomNumberList.contains(37271));
//assertTrue(roomNumberList.contains("Created By Selenium For Api Test"));//bunu yapmak icin liste koyman lazım
    }

}
