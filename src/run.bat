echo Running Experiment 1...

REM run the simulator with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters.prp experiment1/output_exp1.out experiment1/inputs.in

REM copy input and parameter files to output directory
copy experiment1\input_parameters.prp experiment1\output
copy experiment1\inputs.in experiment1\output
copy experiment1\simulator_parameters.prp experiment1\output

REM copy output files to output directory
copy experiment1\output_exp1.out experiment1\output

REM Experiment 2
echo Running Experiment 2...

REM run the simulator with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters.prp experiment2/output_exp2.out experiment2/inputs.in

REM copy input and parameter files to output directory
copy experiment2\input_parameters.prp experiment2\output
copy experiment2\inputs.in experiment2\output
copy experiment2\simulator_parameters.prp experiment2\output

REM copy output files to output directory
copy experiment2\output_exp2.out experiment2\output

REM Experiment 3
echo Running Experiment 3...

REM run the simulator with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters.prp experiment3/output_exp3.out experiment3/inputs.in

REM copy input and parameter files to output directory
copy experiment3\input_parameters.prp experiment3\output
copy experiment3\inputs.in experiment3\output
copy experiment3\simulator_parameters.prp experiment3\output

REM copy output files to output directory
copy experiment3\output_exp3.out experiment3\output

REM Done
echo All experiments completed.