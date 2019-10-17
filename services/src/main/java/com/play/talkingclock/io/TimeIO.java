package com.play.talkingclock.io;

/**
 * Represents the response format for /time.  Contains a numeric time and the human-friendly equivalent.
 */
public class TimeIO {

    String humanFriendlyTime;
    String numericTime;

    public String getNumericTime() {
        return numericTime;
    }

    public void setNumericTime(String numericTime) {
        this.numericTime = numericTime;
    }

    public String getHumanFriendlyTime() {
        return humanFriendlyTime;
    }

    public void setHumanFriendlyTime(String humanFriendlyTime) {
        this.humanFriendlyTime = humanFriendlyTime;
    }

    @Override
    public String toString() {
        return numericTime + " " + humanFriendlyTime;
    }
}
