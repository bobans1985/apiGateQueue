package ru.inversion.bobans.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import ru.inversion.bobans.Entity.apigateQueue;
import ru.inversion.bobans.block.detailBlock;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fx.form.controls.JInvTextArea;
import ru.inversion.fxgem.ui.controller.GemController;

/**
 * Created by GrishukovVM on 14.03.2017.
 */
public class ViewDetailQueueController extends GemController<apigateQueue> {

    @FXML
    public JInvTextArea tReq;
    @FXML
    public JInvTextArea tRes;
    @FXML
    public Label lbStatus;

    public detailBlock block_Detail;

    @FXML
    public JInvTable tbl_syslog;

    @Override
    public void init() throws Exception {
        super.init();
        tReq.setText(this.getDataObject().getREQUEST());
        tRes.setText(this.getDataObject().getRESPONSE());
        String status = this.getDataObject().getSTATUS();
        lbStatus.setText(status);
        if (status!=null && status.equalsIgnoreCase("ERROR")) {
            lbStatus.setTextFill(Color.RED);
        }
    }

    @Override
    public void initComponents() throws Exception {
        super.initComponents();
        this.block_Detail = new detailBlock(this, this.tbl_syslog);
        this.block_Detail.init();
    }

    public void onExit(ActionEvent event) {
        this.close();
    }
}
