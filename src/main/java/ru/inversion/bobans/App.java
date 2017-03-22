package ru.inversion.bobans;

import ru.inversion.bobans.controller.ViewQueueController;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.app.es.JInvErrorService;
import ru.inversion.fx.form.ViewContext;
import ru.inversion.fxgem.ui.GemAlerts;
import ru.inversion.fxgem.ui.GemCall;
import ru.inversion.fxgem.ui.controller.GemController;
import ru.inversion.tc.TaskContext;

import java.util.*;


public class App extends BaseApp {
    public App() {
    }

    /*public void showMain1Window() {
        try {


            JInvFXBrowserController.show(new TaskContext(), this.getPrimaryStage(), "fxml/MainForm.fxml", this.getCommonResourceBundle(), (Map) null);

            (new FXFormLauncher(new TaskContext(), ViewContext.of(this.getPrimaryStage()), "MainForm.fxml"))
                    .bundle(ResourceBundle.getBundle("bndl"))
                    .show();
              FormCall.showForm(new TaskContext(), ViewContext.of(this.getPrimaryStage()), MainController.class, AbstractBaseController.FormModeEnum.VM_SHOW, Boolean.valueOf(false), Boolean.valueOf(true), (Object)null, Collections.EMPTY_MAP, null);

            JInvFXBrowserController.show(this.getCommonTaskContext(), this.getPrimaryViewContext(), "ViewAttributeSchema.fxml", true,getCommonResourceBundle() , null, (Consumer) null);

            JInvFXBrowserController.show(new ru.inversion.tc.TaskContext(), getPrimaryStage(), "MainForm.fxml", getCommonResourceBundle(), null);
            showMainForm(ViewContext.of(this.getPrimaryStage()), new TaskContext(), Collections.EMPTY_MAP);

        } catch (Throwable ex) {
            JInvErrorService.handleException(null, ex);
        }

    }

    public ResourceBundle getCommonResourceBundle() {
        return ResourceBundle.getBundle("fxml/MainForm");
    }*/


    public String getAppID() {
        return "apiGateQueue";
    }

    public static void showForm(ViewContext pParentViewContext, TaskContext pTaskContext, Map pParametersMap) {
        GemCall.showForm(pTaskContext, pParentViewContext, ViewQueueController.class,//MainController.class,
                GemController.FormModeEnum.VM_SHOW, false, true, null,
                pParametersMap, null);
    }

    // Показывает главное окно
    @Override
    public void showMainWindow()  {
        try {
            App.showForm(ViewContext.of(this.getPrimaryStage()), new TaskContext(), Collections.EMPTY_MAP);
        } catch(Throwable lThrowable) {
            GemAlerts.showExceptionAlert(null, lThrowable);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            launch(args);
        } catch (Throwable var2) {
            JInvErrorService.handleException(null, var2);
        }

    }
}



