package com.ringov.yatrnsltr.storage_module.view;

import com.ringov.yatrnsltr.base.interfaces.BaseView;
import com.ringov.yatrnsltr.ui_entities.UITranslation;

import java.util.List;

/**
 * Created by Sergey Koltsov on 14.04.2017.
 */

public interface StorageView extends BaseView {
    void showHistory(List<UITranslation> translations);

    void addToHistory(UITranslation transaction);

    void itemDeleted();

    void returnItemBack(UITranslation translation, int position);

    // todo create a new parent class StonedView and move this method there
    void setStonedMode(boolean enable);
}
