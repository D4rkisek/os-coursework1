
echo Running Experiment 1...

REM run the simulator for FirstComeFirstServe with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters_FirstComeFirstServe.prp experiment1/output_FirstComeFirstServe.out experiment1/inputs.in

REM run the simulator for RoundRobin with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters_RoundRobin.prp experiment1/output_RoundRobin.out experiment1/inputs.in

REM run the simulator for IdealSJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters_IdealSJF.prp experiment1/output_IdealSJF.out experiment1/inputs.in

REM run the simulator for FeedbackRR with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters_FeedbackRR.prp experiment1/output_FeedbackRR.out experiment1/inputs.in

REM run the simulator for SJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment1/simulator_parameters_SJF.prp experiment1/output_SJF.out experiment1/inputs.in

echo Running Experiment 2...

REM run the simulator for FirstComeFirstServe with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters_FirstComeFirstServe.prp experiment2/output_FirstComeFirstServe.out experiment2/inputs.in

REM run the simulator for RoundRobin with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters_RoundRobin.prp experiment2/output_RoundRobin.out experiment2/inputs.in

REM run the simulator for IdealSJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters_IdealSJF.prp experiment2/output_IdealSJF.out experiment2/inputs.in

REM run the simulator for FeedbackRR with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters_FeedbackRR.prp experiment2/output_FeedbackRR.out experiment2/inputs.in

REM run the simulator for SJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment2/simulator_parameters_SJF.prp experiment2/output_SJF.out experiment2/inputs.in


echo Running Experiment 3...

REM run the simulator for FirstComeFirstServe with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters_FirstComeFirstServe.prp experiment3/output_FirstComeFirstServe.out experiment3/inputs.in

REM run the simulator for RoundRobin with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters_RoundRobin.prp experiment3/output_RoundRobin.out experiment3/inputs.in

REM run the simulator for IdealSJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters_IdealSJF.prp experiment3/output_IdealSJF.out experiment3/inputs.in

REM run the simulator for FeedbackRR with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters_FeedbackRR.prp experiment3/output_FeedbackRR.out experiment3/inputs.in

REM run the simulator for SJF with the input file
java -cp target/os-coursework1-1.0-SNAPSHOT.jar Simulator experiment3/simulator_parameters_SJF.prp experiment3/output_SJF.out experiment3/inputs.in


REM Done
echo All experiments completed.