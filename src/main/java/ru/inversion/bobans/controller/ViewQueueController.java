package ru.inversion.bobans.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.inversion.bobans.Entity.apigateQueue;
import ru.inversion.bobans.block.queueBlock;

import ru.inversion.bobans.util.TimerTaskRefresh;
import ru.inversion.fx.form.controls.*;
import ru.inversion.fxgem.ui.controller.GemController;

import java.util.Timer;


/**
 * Created by GrishukovVM on 10.03.2017.
 */
public class ViewQueueController extends GemController {

    @FXML
    private JInvTable tbl_Queue;
    @FXML
    private JInvButton btAutoRefresh;
    @FXML
    private JInvToolBar toolBar;
    @FXML
    private JInvTableColumn roolback;
    @FXML
    Slider slInterval;
    @FXML
    Label lbInterval;
    @FXML
    JInvTableColumn status;

    private Timer timer;
    private queueBlock block_Queue;


    public queueBlock getBlock_Queue() {
        return this.block_Queue;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void initComponents() throws Exception {
        super.initComponents();
        this.block_Queue = new queueBlock(this, this.tbl_Queue);
        this.block_Queue.setToolBar(this.toolBar);
        this.block_Queue.init();

    }


    @Override
    public void init() throws Exception {
        super.init();

        lbInterval.setText(String.valueOf(Math.round(slInterval.getValue())));
        slInterval.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                lbInterval.setText(String.valueOf(Math.round(slInterval.getValue())));
            }
        });

        status.setCellFactory(column -> {
            return new TableCell<apigateQueue, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty || item == null ? "" : getItem().toString());
                    setGraphic(null);

                    TableRow<apigateQueue> currentRow = getTableRow();
                    if (!isEmpty()) {
                        if (item != null && item.equals("ERROR"))
                            this.setStyle("-fx-background-color:lightcoral");
                        else this.setStyle("-fx-background-color: null ;\n" +
                                "    -fx-border-color: transparent -fx-table-cell-border-color transparent transparent;\n");


                    }
                }
            };
        });

        roolback.setCellFactory(column -> new TableCell<apigateQueue, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if ((item != null && !isEmpty()) && (getItem() == 0)) {
                    setText("Нет");
                } else if ((item != null && !isEmpty()) && (getItem() == 1)) {
                    setText("ДА");
                } else if (item == null) {
                    setText("");
                }
            }
        });

        tbl_Queue.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                System.out.println(tbl_Queue.getSelectionModel().getSelectedItem());
                try {
                    block_Queue.viewRecord();
                } catch (Exception ex) {

                }
            }
        });


    }

    @FXML
    public void onAutoRefresh() throws Exception {
        System.out.println("onAutoRefresh");
        if (btAutoRefresh.getText().toUpperCase().indexOf("ВЫКЛ") == -1) {
            timer = new Timer();
            int interval = Integer.valueOf(lbInterval.getText()) * 1000;
            timer.scheduleAtFixedRate(new TimerTaskRefresh(block_Queue), 0, interval);
            btAutoRefresh.setText("Выкл. автообновление");
            slInterval.setDisable(true);
            System.out.println("Enable autorefresh = " + interval);
        } else {
            timer.cancel();
            timer.purge();
            timer=null;
            btAutoRefresh.setText("Автообновление");
            slInterval.setDisable(false);
            System.out.println("Disable autorefresh");
        }
    }


    @Override
    public void onCloseWindow() {
        super.onCloseWindow();
        if (timer != null) {
            timer.cancel();
        }

    }

    @FXML
    public void onExit() {
        this.close();
    }

}


       /* ParamMap ex;
        SQLDataSet p;
        int i;
        try {
            //ex = new ParamMap();
            //ex.put("id", this.FIND_ID.getText());
            p = this.populateDataSet(bobans_apigate_queue.class, "select ID,ITRNNUM,ITRNANUM,DATETIMECREATE,STATUS,INFOTYPE,ROOLBACK,AMOUNT,AMOUNT_COMMIS,ACCD,CURCODED,ACCC,CURCODEC,STREAM from bobans_apigate_queue", (String) null, (String) null, (Map) null, 2);

               //for(i = 0; i < p.getTotalRowCount(); ++i) {
                    //this.tbl_Queue.add(new bobans_apigate_queue((PVFXAttributeList)p.getRow(i)));
                //}
            System.out.println("ok");
        } catch (DataSetException var7) {
            Logger.getLogger(ViewQueueController.class.getName()).log(Level.SEVERE, (String) null, var7);
        }*/
