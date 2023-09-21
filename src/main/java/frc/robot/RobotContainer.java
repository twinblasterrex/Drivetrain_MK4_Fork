package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.sim.SimSubsystem;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

import static edu.wpi.first.wpilibj.RobotBase.isReal;

public class RobotContainer
{
    public RobotContainer()
    {
        Logger.getInstance().recordMetadata("ProjectName", "Off_season"); // Set a metadata value
        if (isReal()) {
            Logger.getInstance().addDataReceiver(new WPILOGWriter("/media/sda1/")); // Log to a USB stick
            Logger.getInstance().addDataReceiver(new NT4Publisher()); // Publish data to NetworkTables
        } else {
            // Regular sim
            Logger.getInstance().addDataReceiver(new WPILOGWriter("C:\\Users\\mloma\\IdeaProjects\\AdvantageKit\\logSim")); // Log to a USB stick
            Logger.getInstance().addDataReceiver(new NT4Publisher()); // Publish data to NetworkTables
        }

        if (RobotBase.isSimulation())
        {
            SimSubsystem.getInstance();
        }

        Logger.getInstance().start();

        DrivetrainSubsystem.getInstance().setDefaultCommand(new DriveCommand());

        configureBindings();
    }
    

    private void configureBindings()
    {

    }

    public Command getAutonomousCommand()
    {
        return null;
    }
}
