package ru.inversion.bobans.block;


import ru.inversion.bobans.Entity.SysLog;
import ru.inversion.bobans.controller.ViewDetailQueueController;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.fx.form.controls.JInvTable;
import ru.inversion.fxgem.ui.controller.GemController;
import ru.inversion.fxgem.ui.controller.block.GemTableBlock;

/**
 * Created by GrishukovVM on 15.03.2017.
 */
public class detailBlock extends GemTableBlock<SysLog> {

    public detailBlock(GemController pController, JInvTable pTable) {
        super(pController, pTable);
    }

    public ViewDetailQueueController getController() {
        return (ViewDetailQueueController) super.getController();
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.getDataSet().setOrderBy("ID desc");
        this.getDataSet().setRowClass(SysLog.class);
        if (this.getController().getDataObject().getSTREAM() != null) {
            this.getDataSet().setWherePredicat(" systype='apiGate' and stream = '" + this.getController().getDataObject().getSTREAM() + "'");
        }

        DSFXAdapter lDSAdapter = DSFXAdapter.bind(this.getDataSet(), this.getTable());
        this.bindControls(lDSAdapter);
        this.refresh();
    }
}
