package ru.inversion.bobans.block;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.inversion.bobans.Entity.apigateQueue;
import ru.inversion.bobans.controller.ViewDetailQueueController;
import ru.inversion.bobans.controller.ViewQueueController;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.dataset.fx.ICellValueChangeListener;
import ru.inversion.fx.form.AbstractBaseController;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fxgem.ui.GemCall;
import ru.inversion.fxgem.ui.controller.GemController;
import ru.inversion.fxgem.ui.controller.action.GemAction;
import ru.inversion.fxgem.ui.controller.block.GemTableBlock;

import java.util.Map;


/**
 * Created by GrishukovVM on 13.03.2017.
 */
public class queueBlock extends GemTableBlock<apigateQueue> {

    public queueBlock(GemController pController, JInvTable pTable) {
        super(pController, pTable);
    }

    public ViewQueueController getController() {
        return (ViewQueueController) super.getController();
    }

    @Override
    public void init() throws Exception {
        super.init();

        this.getDataSet().setOrderBy("ID desc");
        this.getDataSet().setRowClass(apigateQueue.class);
        DSFXAdapter lDSAdapter = DSFXAdapter.bind(this.getDataSet(), this.getTable(), (ICellValueChangeListener) null, false);
        this.bindControls(lDSAdapter);
        //this.setFieldsGName(new String[]{"id"});
        this.getToolBar().getItems().addAll(new Node[]{this.createActionButton(GemAction.ACTION_REFRESH, Boolean.valueOf(false)),
                this.createActionButton(GemAction.ACTION_RECORD_VIEW, Boolean.valueOf(false)),
                this.createActionButton(GemAction.ACTION_ABOUT, Boolean.valueOf(false))
        });
        this.refresh();
    }

    @Override
    public void refresh() throws Exception {
        super.refresh();
        //this.getTable().getStylesheets().clear();
    }


    public void viewRecord() throws Exception {
        //Отключаем таймер рефреша
        ViewQueueController cntl = getController();
        if (cntl.getTimer() != null) {
            cntl.onAutoRefresh();
        }
        apigateQueue lEntity = this.getDataSet().getCurrentRow();
        if (lEntity != null) {
            GemCall.showForm(cntl.getTaskContext(), cntl.getViewContext(), ViewDetailQueueController.class, AbstractBaseController.FormModeEnum.VM_EDIT,
                    Boolean.valueOf(true), Boolean.valueOf(false), lEntity, (Map) null, (pFormReturnEnum, pController) -> {
                        this.handleCallEntityForm(pFormReturnEnum, pController);
                    });

        }
    }


    public void showAbout() throws Exception {
        System.out.println("Start about form");

        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("About form");
        dialogStage.setResizable(false);

        Button button = new Button("Close");
        button.setOnAction(event -> {
            dialogStage.close();
        });

        VBox vbox = new VBox(
                new Text("Приложение для управления очередью сообщений в ПЦ / SmartVista ")
                , new Text()
                , new Text("bobans@")
                , new Text()
                , button);

        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }

}
