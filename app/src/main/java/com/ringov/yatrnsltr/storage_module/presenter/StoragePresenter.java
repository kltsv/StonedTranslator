package com.ringov.yatrnsltr.storage_module.presenter;

import com.ringov.yatrnsltr.Utils;
import com.ringov.yatrnsltr.base.BasePresenter;
import com.ringov.yatrnsltr.storage_module.interactor.StorageInteractor;
import com.ringov.yatrnsltr.storage_module.router.StorageRouter;
import com.ringov.yatrnsltr.storage_module.view.StorageView;
import com.ringov.yatrnsltr.ui_entities.UITranslation;

/**
 * Created by Sergey Koltsov on 14.04.2017.
 */

public class StoragePresenter extends BasePresenter<StorageView, StorageRouter, StorageInteractor> {

    public StoragePresenter(StorageView view, StorageRouter router, StorageInteractor interactor) {
        super(view, router, interactor);
        loadHistory();
        subscribeToItemsInsertion();
    }

    private void loadHistory() {
        getInteractor().loadHistory()
                .compose(Utils.setRxSchedulers())
                .doOnSubscribe(getView()::showLoading)
                .doOnTerminate(getView()::hideLoading)
                .subscribe(getView()::showHistory, this::handleError);
    }

    private void subscribeToItemsInsertion(){
        getInteractor().itemInserted()
                .compose(Utils.setRxSchedulers())
                .subscribe(getView()::addToHistory, this::handleError);
    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewPaused() {

    }

    public void onItemsSwiped(int position) {
        getInteractor().deleteItem(position)
                .compose(Utils.setRxSchedulersForCompletable())
                .subscribe(getView()::itemDeleted);
    }
}
