package com.play.talkingclock;

import com.play.talkingclock.io.TimeIO;
import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.services.TalkingClockServiceImpl;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
@ComponentScan(basePackages = {"com.play.talkingclock"})
public class TalkingClock {

    private static ApplicationContext applicationContext;

    @Autowired
    TalkingClockService talkingClockService;

    public static void main(String args[]) throws Exception {

        TalkingClock tc = new TalkingClock();
        tc.run(args);
    }

    /**
     * Main cli harness runner
     *
     * @param args
     * @throws Exception
     */
    private void run(String[] args) throws Exception {

        talkingClockService = new TalkingClockServiceImpl();

        Options posixOptions = new CommandLineOptionsBuilder().getOptions();
        CommandLine cmd = getCommandLineArgs(posixOptions, args);

        if (cmd == null)
            displayHelp(posixOptions);

        LocalTime localTime = null;
        String[] a = cmd.getArgs();


        if (cmd.hasOption(CommandLineOptionsBuilder.NOW_TIME_OPTION_ARG))
            localTime = LocalTime.now();

        else if (cmd.hasOption(CommandLineOptionsBuilder.GIVEN_TIME_OPTION_ARG))
            try {
                localTime = LocalTime.parse(cmd.getOptionValue(CommandLineOptionsBuilder.GIVEN_TIME_OPTION_ARG));
            } catch (DateTimeParseException dateTimeParseException) {
                System.out.println("Error: " + dateTimeParseException.getMessage());
                displayHelp(posixOptions);
            }

        else
            displayHelp(posixOptions);

        String translatedTime = talkingClockService.translateToHumanFriendly(localTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedDate = dateTimeFormatter.format(localTime);


        TimeIO timeIO = new TimeIO();
        timeIO.setHumanFriendlyTime(translatedTime);
        timeIO.setNumericTime(formattedDate);

        System.out.println(timeIO.toString());
    }


    /**
     * Retuns the command line options if valid options are passed
     *
     * @param options
     * @param args
     * @return
     * @throws ParseException
     */
    public CommandLine getCommandLineArgs(Options options, String[] args) throws ParseException {

        CommandLineParser posixParser = new PosixParser();
        CommandLine cmd = null;
        try {
            cmd = posixParser.parse(options, args);

            if (cmd.getArgs().length > CommandLineOptionsBuilder.MAX_OPTIONS_ON_COMMAND_LINE) {
                cmd = null;
            }

        } catch (UnrecognizedOptionException uoe) {
            cmd = null;
        }

        return cmd;
    }

    /**
     * Displays the help options
     *
     * @param posixOptions
     */
    public void displayHelp(Options posixOptions) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(getClass().getSimpleName(), posixOptions);
        System.exit(1);
    }

}
