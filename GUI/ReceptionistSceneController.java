package GUI;

import DBClasses.DBReceptionist;
import JavaClasses.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReceptionistSceneController {
    @FXML
    private ChoiceBox CbStyleAdd,CbStyleUpdate,CbStatusAdd,CbStatusUpdate,CbSmokingAdd,CbSmokingUpdate,CbStyleSearch,CbStatusSearch,CbSmokingSearch;
    @FXML
    private TextField TfPriceAdd,TfPriceUpdate,TfRoomIdUpdate,TfRoomIdDelete,TfRoomIdSearch1;
    @FXML
    private Label LbResultAdd,LbResultUpdate,LbResultDelete,LbResultSearch1,LbResultSearch2;
    @FXML
    private ListView RoomListView1,RoomListView2,AllRoomsListView;

    private DBReceptionist receptionist=new DBReceptionist();
    public void initialize() {
        CbStyleAdd.getItems().add(0,"STANDARD");
        CbStyleAdd.getItems().add(1,"DELUXE");
        CbStyleAdd.getItems().add(2,"FAMILY SUITE");
        CbStyleAdd.getItems().add(3,"BUSINESS SUITE");
        CbStyleAdd.getSelectionModel().select(0);

        CbStatusAdd.getItems().add("AVAILABLE");
        CbStatusAdd.getItems().add("OCCUPIED");
        CbStatusAdd.getItems().add("NOT AVAILABLE");
        CbStatusAdd.getItems().add("OTHER");
        CbStatusAdd.getSelectionModel().select(0);

        CbSmokingAdd.getItems().add("ALLOWED");
        CbSmokingAdd.getItems().add("NOT ALLOWED");
        CbSmokingAdd.getSelectionModel().select(0);
        /////////////////////////////////////////////////////////////////////////////////////
        CbStyleUpdate.getItems().add(0,"STANDARD");
        CbStyleUpdate.getItems().add(1,"DELUXE");
        CbStyleUpdate.getItems().add(2,"FAMILY SUITE");
        CbStyleUpdate.getItems().add(3,"BUSINESS SUITE");
        CbStyleUpdate.getSelectionModel().select(0);

        CbStatusUpdate.getItems().add("AVAILABLE");
        CbStatusUpdate.getItems().add("OCCUPIED");
        CbStatusUpdate.getItems().add("NOT AVAILABLE");
        CbStatusUpdate.getItems().add("OTHER");
        CbStatusUpdate.getSelectionModel().select(0);

        CbSmokingUpdate.getItems().add("ALLOWED");
        CbSmokingUpdate.getItems().add("NOT ALLOWED");
        CbSmokingUpdate.getSelectionModel().select(0);
        ////////////////////////////////////////////////////////////////////
        CbStyleSearch.getItems().add(0,"STANDARD");
        CbStyleSearch.getItems().add(1,"DELUXE");
        CbStyleSearch.getItems().add(2,"FAMILY SUITE");
        CbStyleSearch.getItems().add(3,"BUSINESS SUITE");
        CbStyleSearch.getSelectionModel().select(0);

        CbStatusSearch.getItems().add("AVAILABLE");
        CbStatusSearch.getItems().add("OCCUPIED");
        CbStatusSearch.getItems().add("NOT AVAILABLE");
        CbStatusSearch.getItems().add("OTHER");
        CbStatusSearch.getSelectionModel().select(0);

        CbSmokingSearch.getItems().add("ALLOWED");
        CbSmokingSearch.getItems().add("NOT ALLOWED");
        CbSmokingSearch.getSelectionModel().select(0);

    }

    public void AddRoom(ActionEvent event){
        if (TfPriceAdd.getText().isEmpty())
            LbResultAdd.setText("Booking Price Field Should Not Be Empty");
        else
            {String result=receptionist.addRoom(new Room(CbStyleAdd.getSelectionModel().getSelectedItem()+"",CbStatusAdd.getSelectionModel().getSelectedItem()+"",TfPriceAdd.getText(),CbSmokingAdd.getSelectionModel().getSelectedItem()+""));
            LbResultAdd.setText(result);}
    }

    public void UpdateRoom(ActionEvent event){
        if (TfRoomIdUpdate.getText().isEmpty() || TfPriceUpdate.getText().isEmpty())
            LbResultUpdate.setText("Booking Price And Room Id Fields Should Not Be Empty");
        else
            { if (receptionist.searchRoomByNumber(TfRoomIdUpdate.getText()).isEmpty())
            LbResultUpdate.setText("Room Doesnt Exist");
        else{
            String result=receptionist.updateRoom(TfRoomIdUpdate.getText(),new Room(CbStyleUpdate.getSelectionModel().getSelectedItem()+"",CbStatusUpdate.getSelectionModel().getSelectedItem()+"",TfPriceUpdate.getText(),CbSmokingUpdate.getSelectionModel().getSelectedItem()+""));
            LbResultUpdate.setText(result);}}
    }

    public void DeleteRoom(ActionEvent event){
        if (TfRoomIdDelete.getText().isEmpty())
            LbResultDelete.setText("Room Id Field Should Not Be Empty");
        else
        {   if (receptionist.searchRoomByNumber(TfRoomIdDelete.getText()).isEmpty())
            LbResultDelete.setText("Room Doesnt Exist");
        else{
            String result=receptionist.deleteRoom(TfRoomIdDelete.getText());
            LbResultDelete.setText(result);}}
    }
    public void SearchRoom1(ActionEvent event){
        if (TfRoomIdSearch1.getText().isEmpty())
            LbResultSearch1.setText("Room Id Field Should Not Be Empty");
        else
        {   if (receptionist.searchRoomByNumber(TfRoomIdSearch1.getText()).isEmpty())
            LbResultSearch1.setText("Room Doesnt Exist");
        else{
            LbResultSearch1.setText("Room Does Exists");
            ObservableList<String> observableList= FXCollections.observableArrayList(receptionist.searchRoomByNumber(TfRoomIdSearch1.getText()).get(0)+"");
            RoomListView1.setItems(observableList);
        }}
    }


    public void SearchRoom2(ActionEvent event){
        Clear(event);
        if (receptionist.searchRoom(CbStyleSearch.getSelectionModel().getSelectedItem()+"",CbStatusSearch.getSelectionModel().getSelectedItem()+"",CbSmokingSearch.getSelectionModel().getSelectedItem()+"").isEmpty())
            LbResultSearch2.setText("Room Doesnt Exist");
        else{
            LbResultSearch2.setText("Room Does Exists");
            receptionist.searchRoom(CbStyleSearch.getSelectionModel().getSelectedItem()+"",CbStatusSearch.getSelectionModel().getSelectedItem()+"",CbSmokingSearch.getSelectionModel().getSelectedItem()+"").stream().forEach(x->RoomListView2.getItems().add(x+""));
        }
    }
    public void Clear(ActionEvent event){
        RoomListView2.getItems().clear();
    }
    public void ClearAll(ActionEvent event){
        AllRoomsListView.getItems().clear();
    }
    public void AllRooms(ActionEvent event){
        ClearAll(event);
        receptionist.getRooms().stream().forEach(x->AllRoomsListView.getItems().add(x+""));
    }
    }


