package org.cloudbus.cloudsim.power.planetlab;

import java.util.Calendar;

import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.power.Helper;
import org.cloudbus.cloudsim.power.RunnerAbstract;

public class PlanetLabRunner extends RunnerAbstract {

    /**
     * Instantiates a new planet lab runner.
     *
     * @param enableOutput the enable output
     * @param outputToFile the output to file
     * @param inputFolder the input folder
     * @param outputFolder the output folder
     * @param workload the workload
     * @param vmAllocationPolicy the vm allocation policy
     * @param vmSelectionPolicy the vm selection policy
     * @param parameter the parameter
     */
 
    
    public PlanetLabRunner(
            boolean enableOutput,
            boolean outputToFile,
            String inputFolder,
            String outputFolder,
            String workload,
            String vmAllocationPolicy,
            String vmSelectionPolicy,
            String parameter) {

        super(
                enableOutput,
                outputToFile,
                inputFolder,
                outputFolder,
                workload,
                vmAllocationPolicy,
                vmSelectionPolicy,
                parameter);
    }

    public PlanetLabRunner(
            boolean enableOutput,
            boolean outputToFile,
            String inputFolder,
            String outputFolder,
            String workload,
            String vmAllocationPolicy,
            String vmSelectionPolicy,
            String parameter,
            int NUMBER_OF_HOSTS) {

        super(
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

    /*
	 * (non-Javadoc)
	 * 
	 * @see org.cloudbus.cloudsim.examples.power.RunnerAbstract#init(java.lang.String)
     */
    @Override
    protected void init(String inputFolder) {
        try {
            CloudSim.init(1, Calendar.getInstance(), false);

            broker = Helper.createBroker();
            int brokerId = broker.getId();

            cloudletList = PlanetLabHelper.createCloudletListPlanetLab(brokerId, inputFolder);
            vmList = Helper.createVmList(brokerId, cloudletList.size());

            if (this.NUMBER_OF_HOSTS != 0) {
               
                hostList = Helper.createHostList(this.NUMBER_OF_HOSTS);

            } else {

                hostList = Helper.createHostList(PlanetLabConstants.NUMBER_OF_HOSTS);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.printLine("The simulation has been terminated due to an unexpected error");
            System.exit(0);
        }
    }

}
