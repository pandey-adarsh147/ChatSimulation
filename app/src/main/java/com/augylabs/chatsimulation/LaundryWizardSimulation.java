package com.augylabs.chatsimulation;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshpandey on 8/26/15.
 */
public class LaundryWizardSimulation implements WizardSimulation {

    private List<WizardCallback> wizardCallbacks = new ArrayList<>();

    private Handler handler = new Handler();

    @Override
    public void submitResponse(WizardResponse response) {

        if (wizardCallbacks.size() > 0) {
            for (WizardCallback wizardCallback: wizardCallbacks) {
                wizardCallback.onStartTyping();
            }
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (WizardCallback wizardCallback: wizardCallbacks) {
                    wizardCallback.onStopTyping();
                    wizardCallback.onReceiveCommand(new Command());
                }
            }
        }, 4000);
    }

    @Override
    public void registerCallback(WizardCallback wizardCallback) {
        if (!wizardCallbacks.contains(wizardCallback)) {
            wizardCallbacks.add(wizardCallback);
        }
    }
}
