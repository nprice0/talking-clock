package com.play.talkingclock;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineOptionsBuilder {

    public final static String NOW_TIME_OPTION_ARG = "n";
    public final static String GIVEN_TIME_OPTION_ARG = "t";
    public final static String HELP_OPTION_ARG = "?";

    public final static int MAX_OPTIONS_ON_COMMAND_LINE = 1;


    public CommandLineOptionsBuilder() {
    }


    public Options getOptions() {

        Option nowTimeOption;
        Option givenTimeOption;
        Option helpOption;

        givenTimeOption = new Option(GIVEN_TIME_OPTION_ARG, true, "Returns a human friendly equivalent of the numeric time given");

        nowTimeOption = new Option(NOW_TIME_OPTION_ARG, false, "Returns a human friendly equivalent of the current time");

        helpOption = new Option(HELP_OPTION_ARG, false, "help");

        Options options = new Options();
        options.addOption(nowTimeOption).addOption(givenTimeOption).addOption(helpOption);
        return options;
    }
}
