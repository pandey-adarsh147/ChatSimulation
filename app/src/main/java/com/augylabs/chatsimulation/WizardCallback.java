package com.augylabs.chatsimulation;

/**
 * Created by adarshpandey on 8/26/15.
 */
public interface WizardCallback {

    void onStartTyping();

    void onStopTyping();

    void onReceiveCommand(Command command);

}
