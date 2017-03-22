package ru.inversion.bobans.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ru.inversion.fx.form.JInvFXDialogController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fxgem.ui.controller.GemController;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.function.BiConsumer;

/**
 * Created by GrishukovVM on 15.11.2016.
 */
public class MainController
        extends GemController {
    //extends JInvFXBrowserController {

    @FXML
    JInvButton viewQueueButton;

    @Override
    public void init() throws Exception {
        super.init();
        this.setTitle("Менеджер очереди API-GATE");
        this.getViewContext().setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    @FXML
    public void onViewQueue(ActionEvent event) {
        System.out.println("Start onViewQueue");
        //JInvFXBrowserController.show(this.getTaskContext(), this.getStage(), "fxml/ViewQueue.fxml", this.getCommonResourceBundle(), (Map) null);
        JInvFXDialogController.show(this.getTaskContext(), this.getViewContext(), "fxml/ViewQueue.fxml", this.getCommonResourceBundle(), (BiConsumer) null, (Map) null, true);
    }

    public ResourceBundle getCommonResourceBundle() {
        return ResourceBundle.getBundle("fxml/ViewQueue");
    }

}


