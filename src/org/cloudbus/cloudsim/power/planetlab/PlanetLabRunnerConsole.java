package org.cloudbus.cloudsim.power.planetlab;

import java.io.IOException;

public class PlanetLabRunnerConsole {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        boolean enableOutput = true;
        boolean outputToFile = false;

        String inputFolder = args[1];
        String outputFolder = args[2];
        String workload = args[3];
        String vmAllocationPolicy = args[4];
        String vmSelectionPolicy = "";
        if (args.length >= 6 && args[5] != null && !args[5].isEmpty()) {
            vmSelectionPolicy = args[5];
        }
        String parameter = "";
        if (args.length >= 7 && args[6] != null && !args[6].isEmpty()) {
            parameter = args[6];
        }

        int NUMBER_OF_HOSTS = PlanetLabConstants.NUMBER_OF_HOSTS;

        if (args.length >= 8 && args[7] != null && !args[7].isEmpty()) {
            NUMBER_OF_HOSTS = Integer.parseInt(args[7]);
        }

        new PlanetLabRunner(
                enableOutput,
                outputToFile,
                inputFolder,
                outputFolder,
                workload,
                vmAllocationPolicy,
                vmSelectionPolicy,
                parameter,
                NUMBER_OF_HOSTS);
    }

}
