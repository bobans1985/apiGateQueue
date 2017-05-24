package ru.inversion.bobans.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import jfxtras.labs.scene.control.BigDecimalField;
import ru.inversion.db.expr.SQLExpressionException;
import ru.inversion.fx.form.controls.combobox.JInvComboBoxSimple;
import ru.inversion.fxgem.ui.controller.GemController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GrishukovVM on 24.05.2017.
 */
public class UnloadController extends GemController {

    @FXML
    public JInvComboBoxSimple p_roolback;
    @FXML
    public BigDecimalField p_trnnum;
    @FXML
    public BigDecimalField p_trnanum;
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @Override
    public void init() throws Exception {
        super.init();
        p_roolback.getItems().addAll("false", "true");
        p_roolback.getSelectionModel().select("false");
        p_trnanum.setMinValue(BigDecimal.valueOf(0));
        p_trnnum.setMinValue(BigDecimal.valueOf(0));

        alert.setTitle("Ошибка");
        alert.setHeaderText("При выполнении произошла ошибка");
    }

    public void onExit(ActionEvent event) {
        this.close();
    }

    public void onRun(ActionEvent event) {
        System.out.println("Run unload api-gate");

        int trnnum;
        int trnanum;
        String roolback;

        if (p_trnnum.getNumber() != null && p_trnanum.getNumber() != null && p_roolback.getPromptText() != null) {
            trnnum = p_trnnum.getNumber().intValue();
            System.out.println("trnnum=" + trnnum);
            trnanum = p_trnanum.getNumber().intValue();
            System.out.println("trnanum=" + trnanum);
            roolback = p_roolback.getSelectionModel().getSelectedItem().toString();
            System.out.println("roolback=" + roolback);

            Map<String, Object> param = new HashMap<>();
            param.put("p_trnnum", trnnum);
            param.put("p_trnanum", trnanum);
            param.put("p_roolback", roolback);
            try {
                this.executeSQLExpression(getClass().getResource ("plsql/UnloadController.xml"), "bobans_ApiGate.toApiGate", param);
            } catch (SQLExpressionException ex) {
                ex.printStackTrace();
                alert.setContentText("Ошибка при выполнении процедуры:" + ex.getMessage()+". " + ex.getCause().getCause().getCause().getMessage());
                alert.showAndWait();
            }

        } else {
            alert.setContentText("Некорректно заданы параметры");
            alert.showAndWait();
        }
    }
}

